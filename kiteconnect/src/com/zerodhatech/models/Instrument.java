package com.zerodhatech.models;

import java.util.Date;

/**
 * A wrapper for Instrument.
 */
public class Instrument {
    public long instrument_token,exchange_token;
    public String tradingsymbol,name;
    public double last_price, tick_size;
    public String instrument_type,segment,exchange, strike;
    public int lot_size;
    public Date expiry;

    public Instrument(long instrument_token, long exchange_token, String tradingsymbol, String name, double last_price, double tick_size, String instrument_type, String segment, String exchange, String strike, int lot_size, Date expiry) {
        this.instrument_token = instrument_token;
        this.exchange_token = exchange_token;
        this.tradingsymbol = tradingsymbol;
        this.name = name;
        this.last_price = last_price;
        this.tick_size = tick_size;
        this.instrument_type = instrument_type;
        this.segment = segment;
        this.exchange = exchange;
        this.strike = strike;
        this.lot_size = lot_size;
        this.expiry = expiry;
    }

    public Instrument() {
    }

    public long getInstrument_token() {
        return instrument_token;
    }

    public void setInstrument_token(long instrument_token) {
        this.instrument_token = instrument_token;
    }

    public long getExchange_token() {
        return exchange_token;
    }

    public void setExchange_token(long exchange_token) {
        this.exchange_token = exchange_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingsymbol() {
        return tradingsymbol;
    }

    public void setTradingsymbol(String tradingsymbol) {
        this.tradingsymbol = tradingsymbol;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getTick_size() {
        return tick_size;
    }

    public void setTick_size(double tick_size) {
        this.tick_size = tick_size;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getInstrument_type() {
        return instrument_type;
    }

    public void setInstrument_type(String instrument_type) {
        this.instrument_type = instrument_type;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public int getLot_size() {
        return lot_size;
    }

    public void setLot_size(int lot_size) {
        this.lot_size = lot_size;
    }
}
