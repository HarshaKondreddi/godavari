package com.zerodhatech.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * A wrapper for quote.
 */
public class Quote {

    @SerializedName("volume")
    public double volumeTradedToday;
    @SerializedName("last_quantity")
    public double lastTradedQuantity;
    @SerializedName("last_trade_time")
    public Date lastTradedTime;
    @SerializedName("net_change")
    public double change;
    @SerializedName("oi")
    public double oi;
    @SerializedName("sell_quantity")
    public double sellQuantity;
    @SerializedName("last_price")
    public double lastPrice;
    @SerializedName("buy_quantity")
    public double buyQuantity;
    @SerializedName("ohlc")
    public OHLC ohlc;
    @SerializedName("instrument_token")
    public long instrumentToken;
    @SerializedName("timestamp")
    public Date timestamp;
    @SerializedName("average_price")
    public double averagePrice;
    @SerializedName("oi_day_high")
    public double oiDayHigh;
    @SerializedName("oi_day_low")
    public double oiDayLow;
    @SerializedName("depth")
    public MarketDepth depth;
    @SerializedName("lower_circuit_limit")
    public double lowerCircuitLimit;
    @SerializedName("upper_circuit_limit")
    public double upperCircuitLimit;

    public double getVolumeTradedToday() {
        return volumeTradedToday;
    }

    public double getLastTradedQuantity() {
        return lastTradedQuantity;
    }

    public Date getLastTradedTime() {
        return lastTradedTime;
    }

    public double getChange() {
        return change;
    }

    public double getOi() {
        return oi;
    }

    public double getSellQuantity() {
        return sellQuantity;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public double getBuyQuantity() {
        return buyQuantity;
    }

    public OHLC getOhlc() {
        return ohlc;
    }

    public long getInstrumentToken() {
        return instrumentToken;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public double getOiDayHigh() {
        return oiDayHigh;
    }

    public double getOiDayLow() {
        return oiDayLow;
    }

    public MarketDepth getDepth() {
        return depth;
    }

    public double getLowerCircuitLimit() {
        return lowerCircuitLimit;
    }

    public double getUpperCircuitLimit() {
        return upperCircuitLimit;
    }

    public void setVolumeTradedToday(double volumeTradedToday) {
        this.volumeTradedToday = volumeTradedToday;
    }

    public void setLastTradedQuantity(double lastTradedQuantity) {
        this.lastTradedQuantity = lastTradedQuantity;
    }

    public void setLastTradedTime(Date lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setOi(double oi) {
        this.oi = oi;
    }

    public void setSellQuantity(double sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public void setBuyQuantity(double buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public void setOhlc(OHLC ohlc) {
        this.ohlc = ohlc;
    }

    public void setInstrumentToken(long instrumentToken) {
        this.instrumentToken = instrumentToken;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public void setOiDayHigh(double oiDayHigh) {
        this.oiDayHigh = oiDayHigh;
    }

    public void setOiDayLow(double oiDayLow) {
        this.oiDayLow = oiDayLow;
    }

    public void setDepth(MarketDepth depth) {
        this.depth = depth;
    }

    public void setLowerCircuitLimit(double lowerCircuitLimit) {
        this.lowerCircuitLimit = lowerCircuitLimit;
    }

    public void setUpperCircuitLimit(double upperCircuitLimit) {
        this.upperCircuitLimit = upperCircuitLimit;
    }

    public Quote(double volumeTradedToday, double lastTradedQuantity, Date lastTradedTime, double change, double oi, double sellQuantity, double lastPrice, double buyQuantity, OHLC ohlc, long instrumentToken, Date timestamp, double averagePrice, double oiDayHigh, double oiDayLow, MarketDepth depth, double lowerCircuitLimit, double upperCircuitLimit) {
        this.volumeTradedToday = volumeTradedToday;
        this.lastTradedQuantity = lastTradedQuantity;
        this.lastTradedTime = lastTradedTime;
        this.change = change;
        this.oi = oi;
        this.sellQuantity = sellQuantity;
        this.lastPrice = lastPrice;
        this.buyQuantity = buyQuantity;
        this.ohlc = ohlc;
        this.instrumentToken = instrumentToken;
        this.timestamp = timestamp;
        this.averagePrice = averagePrice;
        this.oiDayHigh = oiDayHigh;
        this.oiDayLow = oiDayLow;
        this.depth = depth;
        this.lowerCircuitLimit = lowerCircuitLimit;
        this.upperCircuitLimit = upperCircuitLimit;
    }

    public Quote() {
    }
}
