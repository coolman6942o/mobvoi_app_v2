package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class e extends DefaultRedirectHandler {

    /* renamed from: a  reason: collision with root package name */
    public int f6741a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f6742b;

    public e(d dVar) {
        this.f6742b = dVar;
    }

    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode;
        this.f6741a++;
        boolean isRedirectRequested = e.super.isRedirectRequested(httpResponse, httpContext);
        if (isRedirectRequested || this.f6741a >= 5 || ((statusCode = httpResponse.getStatusLine().getStatusCode()) != 301 && statusCode != 302)) {
            return isRedirectRequested;
        }
        return true;
    }
}
