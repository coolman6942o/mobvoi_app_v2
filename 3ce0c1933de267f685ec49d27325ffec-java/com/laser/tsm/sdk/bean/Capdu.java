package com.laser.tsm.sdk.bean;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class Capdu {
    private String apdu;
    private int index;
    private String[] sw;

    public Capdu(int i10, String str, String[] strArr) {
        this.index = i10;
        this.apdu = str;
        this.sw = strArr;
    }

    public String getApdu() {
        return this.apdu;
    }

    public int getIndex() {
        return this.index;
    }

    public String[] getSw() {
        return this.sw;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public void setIndex(int i10) {
        this.index = i10;
    }

    public void setSw(String[] strArr) {
        this.sw = strArr;
    }

    public String toString() {
        return "Capdu [index=" + this.index + ", apdu=" + this.apdu + ", sw=" + Arrays.toString(this.sw) + "]";
    }

    public Capdu() {
    }
}
