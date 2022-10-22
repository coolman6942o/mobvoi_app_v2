package com.laser.tsm.sdk.business;
/* loaded from: classes2.dex */
public class ApduResBean {
    private String apdu;
    private int index;
    private String sw;

    public ApduResBean() {
    }

    public String getApdu() {
        return this.apdu;
    }

    public int getIndex() {
        return this.index;
    }

    public String getSw() {
        return this.sw;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setSw(String str) {
        this.sw = str;
    }

    public ApduResBean(String str) {
        this.apdu = str;
    }
}
