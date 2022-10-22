package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class f implements ConnectionKeepAliveStrategy {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f6743a;

    public f(d dVar) {
        this.f6743a = dVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000L;
    }
}
