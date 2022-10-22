package com.mobvoi.companion.ticpay.buscard;
/* loaded from: classes2.dex */
public class TradeInfo {
    public static final String CONSUMPTION1 = "06";
    public static final String CONSUMPTION2 = "09";
    public static final String RECHARGE = "02";
    private int creditLine;
    private String posNo;
    private int tradeAmount;
    private String tradeDate;
    private String tradeNo;
    private String tradeTime;
    private String tradeType;

    public int getCreditLine() {
        return this.creditLine;
    }

    public String getPosNo() {
        return this.posNo;
    }

    public int getTradeAmount() {
        return this.tradeAmount;
    }

    public String getTradeDate() {
        return this.tradeDate;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getTradeTime() {
        return this.tradeTime;
    }

    public String getTradeType() {
        return this.tradeType;
    }

    public int intTradeType() {
        return "02".equalsIgnoreCase(this.tradeType) ? 1 : 0;
    }

    public void setCreditLine(int i10) {
        this.creditLine = i10;
    }

    public void setPosNo(String str) {
        this.posNo = str;
    }

    public void setTradeAmount(int i10) {
        this.tradeAmount = i10;
    }

    public void setTradeDate(String str) {
        this.tradeDate = str;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setTradeTime(String str) {
        this.tradeTime = str;
    }

    public void setTradeType(String str) {
        this.tradeType = str;
    }
}
