package com.zerodhatech.godavari;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Godavari {

    public static String ACCESS_TOKEN;
    public static String PUBLIC_TOKEN;
    public static String USER_ID = "USER_ID";
    public static String API_KEY = "API_KEY";
    public static String API_SECRET_KEY = "API_SECRET_KEY";

    public static final String BANKNIFTY = "BANKNIFTY";
    public static List<String> validInstruments = Arrays.asList(BANKNIFTY);
    public static boolean IS_TRADE_COMPLETED_ON_THURSDAY;
    public static Logger logger = Logger.getLogger(Godavari.class.getName());

    public static void main(String[] args) throws IOException, KiteException, ParseException, InterruptedException {
        String requestToken = args[0];
        init(requestToken);
    }

    /***
     * starts the application
     * @throws IOException
     * @throws KiteException
     * @throws ParseException
     * @throws InterruptedException
     * @param requestToken
     */
    public static void init(String requestToken) throws IOException, KiteException, ParseException, InterruptedException {
        KiteConnect kiteConnect = new KiteConnect(API_KEY);
        kiteConnect.setUserId(USER_ID);
        User user = kiteConnect.generateSession(requestToken, API_SECRET_KEY);
        ACCESS_TOKEN = user.accessToken;
        PUBLIC_TOKEN = user.publicToken;
        kiteConnect.setAccessToken(ACCESS_TOKEN);
        kiteConnect.setPublicToken(PUBLIC_TOKEN);
        // Set session expiry callback.
        kiteConnect.setSessionExpiryHook(new SessionExpiryHook() {
            @Override
            public void sessionExpired() {
                System.out.println("session expired");
            }
        });
        while(true) {
            Thread.sleep(60000);
            logger.info("executing trades");
            executeTrade(kiteConnect);
            logger.info("checking existing positions");
            checkExistingPositions(kiteConnect);
        }
    }

    /**
     * checks existing positions and closes them when at risk
     * @param kiteConnect
     * @return
     * @throws IOException
     * @throws KiteException
     */
    private static List<OrderParams> checkExistingPositions(KiteConnect kiteConnect) throws IOException, KiteException {
        Map<String, List<Position>> openPositions = kiteConnect.getPositions();
        List<Position> positionsToBeExited = new ArrayList<>();
        Long stopLossPercent = Long.valueOf(FileUtil.getPropertyName("godavari.stoploss.percent"));
        for(String key : openPositions.keySet()) {
            List<Position> positions = openPositions.get(key);
            for(Position position : positions) {
                if(position.getNetQuantity() < 0 &&
                        position.getLastPrice() >= position.getAveragePrice()*(1+stopLossPercent/100)) {
                    positionsToBeExited.add(position);
                }
            }
        }
        logger.info("Found "+ positionsToBeExited.size() + " to be exited. Continuing to buy these positions");
        List<OrderParams> orders = OrderUtil.exitOptionsDetails(positionsToBeExited);
        for(OrderParams orderParam : orders) {
                        kiteConnect.placeOrder(orderParam, "REGULAR");
        }
        return orders;
    }

    /***
     * executes FNO trade for the week of Banknifty with a specified range in properties at 15:15 hours
     * @param kiteConnect
     * @return
     * @throws IOException
     * @throws KiteException
     * @throws ParseException
     */
    public static List<OrderParams> executeTrade(KiteConnect kiteConnect) throws IOException, KiteException, ParseException {
        for(String instrument : validInstruments) {
            switch (instrument) {
                case BANKNIFTY:
                    if(TimeUtil.getWeekDayName().equals("THURSDAY") && TimeUtil.isValidOptionsTradingTime() && !IS_TRADE_COMPLETED_ON_THURSDAY) {
                        IS_TRADE_COMPLETED_ON_THURSDAY = true;
                        List<Instrument> instruments = getBankNiftyInstruments(kiteConnect);
                        Double spotPrice = getSpotPrice(kiteConnect, "NSE", "NIFTY BANK");
                        Double basePrice = new BigDecimal(spotPrice / 1000).setScale(1, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).doubleValue();
                        List<OrderParams> orders = GodavariUtil.getBankNiftyValidOrders(basePrice, instruments);
                        for (OrderParams orderParam : orders) {
                            kiteConnect.placeOrder(orderParam, "REGULAR");
                        }
                        return orders;
                    }
                default:break;
            }
        }
        return null;
    }

    /***
     * gets Valid Bank Nifty instruments to identify the slabs and strike prices to place order
     * @param kiteConnect
     * @return
     * @throws IOException
     * @throws KiteException
     */
    public static List<Instrument> getBankNiftyInstruments(KiteConnect kiteConnect) throws IOException, KiteException {
        List<Instrument> instrumentList = kiteConnect.getInstruments("NFO");
        List<Instrument> bankNiftyInstruments = new ArrayList<>();
        for(Instrument instrument : instrumentList) {
            if(instrument.getName() != null && instrument.getName().equals(BANKNIFTY)) {
                bankNiftyInstruments.add(instrument);
            }
        }
        return bankNiftyInstruments;
    }

    /***
     * gets current spot pruce for an exchange and scrip name
     * @param kiteConnect
     * @param exchange
     * @param name
     * @return
     * @throws IOException
     * @throws KiteException
     */
    public static double getSpotPrice(KiteConnect kiteConnect, String exchange, String name) throws IOException, KiteException {
        String[] req = {exchange+":"+name};
        Map<String, Quote> marketQuote = kiteConnect.getQuote(req);
        return marketQuote.get(req[0]).lastPrice;
    }


}
