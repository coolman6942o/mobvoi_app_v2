package com.google.common.util.concurrent;
/* loaded from: classes.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(String str) {
        super(str);
    }

    public UncheckedTimeoutException(Throwable th2) {
        super(th2);
    }

    public UncheckedTimeoutException(String str, Throwable th2) {
        super(str, th2);
    }
}
