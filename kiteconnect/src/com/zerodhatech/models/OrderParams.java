package com.zerodhatech.models;

/** A wrapper for order params to be sent while placing an order.*/
public class OrderParams {
    /**
     * Exchange in which instrument is listed (NSE, BSE, NFO, BFO, CDS, MCX).
     */
    public String exchange;

    /**
     * Tradingsymbol of the instrument  (ex. RELIANCE, INFY).
     */
    public String tradingsymbol;

    /**
     * Transaction type (BUY or SELL).
     */
    public String transactionType;

    /**
     * Order quantity
     */
    public Integer quantity;

    /**
     * Order Price
     */
    public Double price;

    /**
     * Product code (NRML, MIS, CNC).
     */
    public String product;

    /**
     * Order type (LIMIT, SL, SL-M, MARKET).
     */
    public String orderType;

    /**
     * Order validity (DAY, IOC).
     */
    public String validity;

    /**
     * Disclosed quantity
     */
    public Integer disclosedQuantity;

    /**
     * Trigger price
     */
    public Double triggerPrice;

    /**
     * Square off value (only for bracket orders)
     */
    public Double squareoff;

    /**
     * Stoploss value (only for bracket orders)
     */
    public Double stoploss;

    /**
     * Trailing stoploss value (only for bracket orders)
     */
    public Double trailingStoploss;

    /**
     * Tag: field for users to tag orders. It accepts alphanumeric 8 character String values.
     */
     public String tag;

     /**
      * Parent order id is used to send order modify request.
      */
     public String parentOrderId;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getTradingsymbol() {
        return tradingsymbol;
    }

    public void setTradingsymbol(String tradingsymbol) {
        this.tradingsymbol = tradingsymbol;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Integer getDisclosedQuantity() {
        return disclosedQuantity;
    }

    public void setDisclosedQuantity(Integer disclosedQuantity) {
        this.disclosedQuantity = disclosedQuantity;
    }

    public Double getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(Double triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public Double getSquareoff() {
        return squareoff;
    }

    public void setSquareoff(Double squareoff) {
        this.squareoff = squareoff;
    }

    public Double getStoploss() {
        return stoploss;
    }

    public void setStoploss(Double stoploss) {
        this.stoploss = stoploss;
    }

    public Double getTrailingStoploss() {
        return trailingStoploss;
    }

    public void setTrailingStoploss(Double trailingStoploss) {
        this.trailingStoploss = trailingStoploss;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(String parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public OrderParams(String exchange, String tradingsymbol, String transactionType, Integer quantity, Double price, String product, String orderType, String validity, Integer disclosedQuantity, Double triggerPrice, Double squareoff, Double stoploss, Double trailingStoploss, String tag, String parentOrderId) {
        this.exchange = exchange;
        this.tradingsymbol = tradingsymbol;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.orderType = orderType;
        this.validity = validity;
        this.disclosedQuantity = disclosedQuantity;
        this.triggerPrice = triggerPrice;
        this.squareoff = squareoff;
        this.stoploss = stoploss;
        this.trailingStoploss = trailingStoploss;
        this.tag = tag;
        this.parentOrderId = parentOrderId;
    }

    public OrderParams() {
    }

    @Override
    public String toString() {
        return "OrderParams{" +
                "exchange='" + exchange + '\'' +
                ", tradingsymbol='" + tradingsymbol + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", product='" + product + '\'' +
                ", orderType='" + orderType + '\'' +
                ", validity='" + validity + '\'' +
                ", disclosedQuantity=" + disclosedQuantity +
                ", triggerPrice=" + triggerPrice +
                ", squareoff=" + squareoff +
                ", stoploss=" + stoploss +
                ", trailingStoploss=" + trailingStoploss +
                ", tag='" + tag + '\'' +
                ", parentOrderId='" + parentOrderId + '\'' +
                '}';
    }
}