package com.bjleisen.iface.sdk.bean;
/* loaded from: classes.dex */
public class Rapdu {
    private int index;
    private String rapdu;
    private String sw;

    public Rapdu() {
    }

    public int getIndex() {
        return this.index;
    }

    public String getRapdu() {
        return this.rapdu;
    }

    public String getSw() {
        return this.sw;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setRapdu(String str) {
        this.rapdu = str;
    }

    public void setSw(String str) {
        this.sw = str;
    }

    public String toString() {
        return "Rapdu [index=" + this.index + ", rapdu=" + this.rapdu + ", sw=" + this.sw + "]";
    }

    public Rapdu(int i10, String str, String str2) {
        this.index = i10;
        this.rapdu = str;
        this.sw = str2;
    }
}
