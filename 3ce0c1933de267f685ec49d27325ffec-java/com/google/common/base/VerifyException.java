package com.google.common.base;
/* loaded from: classes.dex */
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(String str) {
        super(str);
    }

    public VerifyException(Throwable th2) {
        super(th2);
    }

    public VerifyException(String str, Throwable th2) {
        super(str, th2);
    }
}
