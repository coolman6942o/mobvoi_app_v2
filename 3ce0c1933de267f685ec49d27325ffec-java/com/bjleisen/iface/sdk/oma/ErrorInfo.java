package com.bjleisen.iface.sdk.oma;
/* loaded from: classes.dex */
public class ErrorInfo extends Error {
    private int errorCode;

    public ErrorInfo(int i10, String str) {
        super(str);
        this.errorCode = i10;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }
}
