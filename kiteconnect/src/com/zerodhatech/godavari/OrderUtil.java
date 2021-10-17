package com.zerodhatech.godavari;

import com.zerodhatech.models.Instrument;
import com.zerodhatech.models.OrderParams;
import com.zerodhatech.models.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    public static final String NFO = "NFO";

    /***
     * gets options sell order to place
     * @param instrumentsToPlace
     * @return
     * @throws IOException
     */
    public static List<OrderParams> getOptionsSELLOrdersToPlace(List<Instrument> instrumentsToPlace) throws IOException {
        List<OrderParams> orders = new ArrayList<>();
        for(Instrument instrument: instrumentsToPlace) {
            OrderParams orderParams = new OrderParams();
            orderParams.setExchange(NFO);
            orderParams.setTradingsymbol(instrument.getTradingsymbol());
            orderParams.setTransactionType("SELL");
            orderParams.setQuantity(Integer.valueOf(FileUtil.getPropertyName("godavari.lot.size")));
            orderParams.setOrderType("MARKET");
            orderParams.setProduct("NRML");
            orders.add(orderParams);
        }
        return orders;
    }

    /**
     * prepares and get exit orders by taking positions
     * @param positions
     * @return
     */
    public static List<OrderParams> exitOptionsDetails(List<Position> positions) {
        List<OrderParams> orders = new ArrayList<>();
        for(Position position : positions) {
            OrderParams orderParams = new OrderParams();
            orderParams.setExchange(NFO);
            orderParams.setTradingsymbol(position.getTradingSymbol());
            orderParams.setTransactionType("BUY");
            orderParams.setQuantity(position.getNetQuantity());
            orderParams.setOrderType("MARKET");
            orderParams.setProduct("NRML");
            orders.add(orderParams);
        }
        return orders;
    }
 }
