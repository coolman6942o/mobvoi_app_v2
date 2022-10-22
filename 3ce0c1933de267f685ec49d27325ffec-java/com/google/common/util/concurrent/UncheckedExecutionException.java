package com.google.common.util.concurrent;
/* loaded from: classes.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    public UncheckedExecutionException(String str, Throwable th2) {
        super(str, th2);
    }

    public UncheckedExecutionException(Throwable th2) {
        super(th2);
    }
}
