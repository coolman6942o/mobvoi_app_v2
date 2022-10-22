package com.mobvoi.health.common.data.sync.net;

import java.util.Locale;
/* loaded from: classes2.dex */
public class ServerSyncException extends Exception {
    public final int errCode;
    public final String errMessage;

    public ServerSyncException(String str, int i10) {
        this.errMessage = str;
        this.errCode = i10;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.getDefault(), "Server sync exception %d: %s", Integer.valueOf(this.errCode), this.errMessage);
    }
}
