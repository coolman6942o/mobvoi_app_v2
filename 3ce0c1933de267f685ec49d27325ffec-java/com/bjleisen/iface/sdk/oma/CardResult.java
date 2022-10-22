package com.bjleisen.iface.sdk.oma;
/* loaded from: classes.dex */
public class CardResult {
    private String errorMsg;
    private String rapdu;
    private int status;

    public CardResult(String str, int i10, String str2) {
        this.rapdu = str;
        this.status = i10;
        this.errorMsg = str2;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getRapdu() {
        return this.rapdu;
    }

    public int getStatus() {
        return this.status;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setRapdu(String str) {
        this.rapdu = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "CardResult [rapdu=" + this.rapdu + ", status=" + this.status + ", errorMsg=" + this.errorMsg + "]";
    }

    public CardResult(int i10, String str) {
        this.status = i10;
        this.errorMsg = str;
    }
}
