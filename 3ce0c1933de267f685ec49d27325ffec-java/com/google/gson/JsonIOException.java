package com.google.gson;
/* loaded from: classes.dex */
public final class JsonIOException extends JsonParseException {
    private static final long serialVersionUID = 1;

    public JsonIOException(String str) {
        super(str);
    }

    public JsonIOException(String str, Throwable th2) {
        super(str, th2);
    }

    public JsonIOException(Throwable th2) {
        super(th2);
    }
}
