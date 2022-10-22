package com.bjleisen.iface.sdk.bean;

import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
/* loaded from: classes.dex */
public class CardInfo {
    private int cardBalance;
    private String cardNum;
    private EnumCardAppStatus cardStatus;
    private String expiryDate;
    private String startDate;

    public int getCardBalance() {
        return this.cardBalance;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public EnumCardAppStatus getCardStatus() {
        return this.cardStatus;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setCardBalance(int i10) {
        this.cardBalance = i10;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public void setCardStatus(EnumCardAppStatus enumCardAppStatus) {
        this.cardStatus = enumCardAppStatus;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String toString() {
        return "CardTemplateInfo [cardStatus=" + this.cardStatus + ", cardNum=" + this.cardNum + ", cardBalance=" + this.cardBalance + ", startDate=" + this.startDate + ", expiryDate=" + this.expiryDate + "]";
    }
}
