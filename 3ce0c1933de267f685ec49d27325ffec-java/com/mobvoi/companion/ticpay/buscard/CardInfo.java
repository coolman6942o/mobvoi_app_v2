package com.mobvoi.companion.ticpay.buscard;

import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
/* loaded from: classes2.dex */
public class CardInfo {
    public static final String BLACK_LIST_BJHT1 = "6283";
    public static final String BLACK_LIST_BJHT2 = "6284";
    public static final String BLACK_LIST_BJT = "A5";
    public static final String FLAG_BJHT = "01";
    public static final String FLAG_BJT = "02";
    public static final String FLAG_HEBT = "03";
    public static final String FLAG_SZT = "03";
    public static final String FLAG_TFT = "01";
    public static final String FLAG_TJT = "03";
    public static final String FLAG_WHT = "01";
    public static final String FLAG_XMT = "01";
    private String blackList;
    private int cardBalance;
    private String cardNum;
    private String enableFlag;
    private String endDate;
    private EnumCardAppStatus mCardStatus;
    private int overdraftMoney;
    private String startDate;

    public String getBlackList() {
        return this.blackList;
    }

    public int getCardBalance() {
        return this.cardBalance;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public EnumCardAppStatus getCardStatus() {
        return this.mCardStatus;
    }

    public String getEnableFlag() {
        return this.enableFlag;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getExpiryDate() {
        return this.endDate;
    }

    public int getOverdraftMoney() {
        return this.overdraftMoney;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setBlackList(String str) {
        this.blackList = str;
    }

    public void setCardBalance(int i10) {
        this.cardBalance = i10;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public void setCardStatus(EnumCardAppStatus enumCardAppStatus) {
        this.mCardStatus = enumCardAppStatus;
    }

    public void setEnableFlag(String str) {
        this.enableFlag = str;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setExpiryDate(String str) {
        this.endDate = str;
    }

    public void setOverdraftMoney(int i10) {
        this.overdraftMoney = i10;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }
}
