package com.bumptech.glide.load;

import java.io.IOException;
/* loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i10) {
        this("Http request failed with status code: " + i10, i10);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i10) {
        this(str, i10, null);
    }

    public HttpException(String str, int i10, Throwable th2) {
        super(str, th2);
        this.statusCode = i10;
    }
}
