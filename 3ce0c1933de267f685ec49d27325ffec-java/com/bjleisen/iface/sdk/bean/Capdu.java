package com.bjleisen.iface.sdk.bean;
/* loaded from: classes.dex */
public class Capdu {
    private String capdu;
    private String[] expSw;
    private int index;

    public Capdu(String str) {
        this.capdu = str;
    }

    public String getCpadu() {
        return this.capdu;
    }

    public String[] getExpSw() {
        return this.expSw;
    }

    public int getIndex() {
        return this.index;
    }

    public void setCpadu(String str) {
        this.capdu = str;
    }

    public void setExpSw(String[] strArr) {
        this.expSw = strArr;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public Capdu(int i10, String str, String[] strArr) {
        this.index = i10;
        this.capdu = str;
        this.expSw = strArr;
    }
}
