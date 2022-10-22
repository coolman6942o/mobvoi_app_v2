package com.bjleisen.iface.sdk.bean.resp;
/* loaded from: classes.dex */
public class ZytRechargeBusiRespInfo extends BaseBusiRespInfo {
    private int addamt;
    private int balance;
    private String cardNo;

    public int getAddamt() {
        return this.addamt;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setAddamt(int i10) {
        this.addamt = i10;
    }

    public void setBalance(int i10) {
        this.balance = i10;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }
}
