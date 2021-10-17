package com.zerodhatech.godavari;

import com.zerodhatech.models.Instrument;
import com.zerodhatech.models.OrderParams;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class GodavariUtil {

    public static Logger logger = Logger.getLogger(GodavariUtil.class.getName());

    /***
     * Gets orders to execute for bank nifty on
     * @param basePrice
     * @param instruments
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static List<OrderParams> getBankNiftyValidOrders(Double basePrice, List<Instrument> instruments) throws IOException, ParseException {
        Long range = Long.valueOf(FileUtil.getPropertyName("godavari.banknifty.range"));
        Long upperRange = basePrice.longValue()+range;
        Long lowerRange = basePrice.longValue()-range;
        List<Instrument> callInstruments = getValidInstrumentsForInstrumentType(instruments, "CE");
        List<Instrument> putInstruments = getValidInstrumentsForInstrumentType(instruments, "PE");
        String today = TimeUtil.getWeekDayName();
        logger.info("Executing trades at : " + upperRange + " , " + lowerRange);
        switch (today) {
            case "THURSDAY" :
                List<Instrument> instrumentsToPlace = new ArrayList<>();
                Instrument bankNiftyValidStrikePriceCallInstrument = getBankNiftyValidStrikePriceInstrument(upperRange, callInstruments);
                if(bankNiftyValidStrikePriceCallInstrument != null) {
                    instrumentsToPlace.add(bankNiftyValidStrikePriceCallInstrument);
                }
                Instrument bankNiftyValidStrikePricePutInstrument = getBankNiftyValidStrikePriceInstrument(lowerRange, putInstruments);
                if(bankNiftyValidStrikePricePutInstrument != null) {
                    instrumentsToPlace.add(bankNiftyValidStrikePricePutInstrument);
                }
                return OrderUtil.getOptionsSELLOrdersToPlace(instrumentsToPlace);
            default:
        }
        return null;
    }

    /***
     * Gets vaid strike prices instruments to place an order for next week
     * @param slab
     * @param instruments
     * @return
     * @throws ParseException
     */
    private static Instrument getBankNiftyValidStrikePriceInstrument(Long slab, List<Instrument> instruments) throws ParseException {
        for(int counter = 7; counter>=1; counter--) {
            LocalDate nextWeekSameDay = LocalDate.now().plusDays(counter);
            for (Instrument instrument : instruments) {
                Date expirtyDate = instrument.getExpiry();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(expirtyDate);
                LocalDate ld = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
                if (ld.isEqual(nextWeekSameDay) && slab.longValue() == Long.valueOf(instrument.getStrike()).longValue()) {
                    return instrument;
                }
            }
        }
        return null;
    }

    /***
     * gets valid instruments for instrument type
     * @param instruments
     * @param instrumentType
     * @return
     */
    private static List<Instrument> getValidInstrumentsForInstrumentType(List<Instrument> instruments, String instrumentType) {
        List<Instrument> validInstrumentsForInstrumentType = new ArrayList<>();
        for(Instrument instrument : instruments) {
            if(instrument.getInstrument_type().equals(instrumentType)) {
                validInstrumentsForInstrumentType.add(instrument);
            }
        }
        return validInstrumentsForInstrumentType;
    }
}
