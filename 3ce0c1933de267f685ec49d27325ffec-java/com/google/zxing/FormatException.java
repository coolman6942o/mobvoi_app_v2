package com.google.zxing;
/* loaded from: classes.dex */
public final class FormatException extends ReaderException {
    private static final FormatException INSTANCE;

    static {
        FormatException formatException = new FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.isStackTrace ? new FormatException() : INSTANCE;
    }

    private FormatException(Throwable th2) {
        super(th2);
    }

    public static FormatException getFormatInstance(Throwable th2) {
        return ReaderException.isStackTrace ? new FormatException(th2) : INSTANCE;
    }
}
