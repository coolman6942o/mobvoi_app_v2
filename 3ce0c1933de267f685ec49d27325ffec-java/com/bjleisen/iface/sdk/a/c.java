package com.bjleisen.iface.sdk.a;

import android.util.Log;
import h9.b;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
/* compiled from: AsyncHttpRequest.java */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractHttpClient f7630a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpContext f7631b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpUriRequest f7632c;

    /* renamed from: d  reason: collision with root package name */
    private final h f7633d;

    /* renamed from: e  reason: collision with root package name */
    private int f7634e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7635f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7636g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7637h = false;

    public c(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, h hVar) {
        this.f7630a = abstractHttpClient;
        this.f7631b = httpContext;
        this.f7632c = httpUriRequest;
        this.f7633d = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x000b A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        h hVar;
        IOException iOException;
        boolean z10;
        h hVar2;
        HttpRequestRetryHandler httpRequestRetryHandler = this.f7630a.getHttpRequestRetryHandler();
        IOException e10 = null;
        boolean z11 = true;
        while (z11) {
            try {
                try {
                    try {
                        if (a()) {
                            return;
                        }
                        if (this.f7632c.getURI().getScheme() != null) {
                            b.g("AysncHttpClient", "get response before");
                            HttpResponse execute = this.f7630a.execute(this.f7632c);
                            b.g("AysncHttpClient", "get response after" + execute.getStatusLine().getStatusCode());
                            if (!a() && (hVar2 = this.f7633d) != null) {
                                hVar2.a(execute);
                                return;
                            }
                            return;
                        }
                        throw new MalformedURLException("No valid URI scheme was provided");
                    } catch (IOException e11) {
                        e10 = e11;
                        try {
                            if (!a()) {
                                int i10 = this.f7634e + 1;
                                this.f7634e = i10;
                                z11 = httpRequestRetryHandler.retryRequest(e10, i10, this.f7631b);
                                if (z11 && (hVar = this.f7633d) != null) {
                                    hVar.a(this.f7634e);
                                }
                            } else {
                                return;
                            }
                        } catch (Exception e12) {
                            Log.e("AsyncHttpRequest", "Unhandled exception origin cause", e12);
                            throw new IOException("Unhandled exception: " + e12.getMessage());
                        }
                    }
                } catch (NullPointerException e13) {
                    iOException = new IOException("NPE in HttpClient: " + e13.getMessage());
                    int i11 = this.f7634e + 1;
                    this.f7634e = i11;
                    z10 = httpRequestRetryHandler.retryRequest(iOException, i11, this.f7631b);
                    e10 = iOException;
                    z11 = z10;
                    if (z11) {
                        hVar.a(this.f7634e);
                    }
                }
            } catch (UnknownHostException e14) {
                iOException = new IOException("UnknownHostException exception:" + e14.getMessage());
                int i12 = this.f7634e;
                if (i12 > 0) {
                    int i13 = i12 + 1;
                    this.f7634e = i13;
                    if (httpRequestRetryHandler.retryRequest(iOException, i13, this.f7631b)) {
                        z10 = true;
                        e10 = iOException;
                        z11 = z10;
                        if (z11) {
                        }
                    }
                }
                z10 = false;
                e10 = iOException;
                z11 = z10;
                if (z11) {
                }
            }
        }
    }

    private void e() {
        h hVar;
        if (!a()) {
            if (this.f7632c.getURI().getScheme() != null) {
                b.g("AysncHttpClient", "get response before");
                HttpResponse execute = this.f7630a.execute(this.f7632c);
                b.g("AysncHttpClient", "get response after" + execute.getStatusLine().getStatusCode());
                if (!a() && (hVar = this.f7633d) != null) {
                    hVar.a(execute);
                    return;
                }
                return;
            }
            throw new MalformedURLException("No valid URI scheme was provided");
        }
    }

    private synchronized void f() {
        if (!this.f7637h && this.f7635f && !this.f7636g) {
            this.f7636g = true;
            h hVar = this.f7633d;
            if (hVar != null) {
                hVar.p();
            }
        }
    }

    public final boolean a() {
        if (this.f7635f) {
            f();
        }
        return this.f7635f;
    }

    public final boolean b() {
        return a() || this.f7637h;
    }

    public final boolean c() {
        this.f7635f = true;
        this.f7632c.abort();
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0024 A[ADDED_TO_REGION, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        h hVar;
        HttpRequestRetryHandler httpRequestRetryHandler;
        IOException iOException;
        boolean z10;
        h hVar2;
        h hVar3;
        if (!a()) {
            h hVar4 = this.f7633d;
            if (hVar4 != null) {
                hVar4.n();
            }
            if (!a()) {
                try {
                    httpRequestRetryHandler = this.f7630a.getHttpRequestRetryHandler();
                    iOException = null;
                    z10 = true;
                } catch (Exception e10) {
                    if (a() || (hVar = this.f7633d) == null) {
                        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null" + e10);
                    } else {
                        hVar.a(0, null, null, e10);
                    }
                }
                while (z10) {
                    try {
                        try {
                            if (!a()) {
                                if (this.f7632c.getURI().getScheme() != null) {
                                    b.g("AysncHttpClient", "get response before");
                                    HttpResponse execute = this.f7630a.execute(this.f7632c);
                                    b.g("AysncHttpClient", "get response after" + execute.getStatusLine().getStatusCode());
                                    if (!a() && (hVar3 = this.f7633d) != null) {
                                        hVar3.a(execute);
                                    }
                                } else {
                                    throw new MalformedURLException("No valid URI scheme was provided");
                                }
                            }
                        } catch (UnknownHostException e11) {
                            iOException = new IOException("UnknownHostException exception:" + e11.getMessage());
                            int i10 = this.f7634e;
                            if (i10 > 0) {
                                int i11 = i10 + 1;
                                this.f7634e = i11;
                                if (httpRequestRetryHandler.retryRequest(iOException, i11, this.f7631b)) {
                                    z10 = true;
                                    if (z10 && (hVar2 = this.f7633d) != null) {
                                        hVar2.a(this.f7634e);
                                    }
                                }
                            }
                            z10 = false;
                            if (z10) {
                                hVar2.a(this.f7634e);
                            }
                        }
                    } catch (IOException e12) {
                        try {
                            if (!a()) {
                                int i12 = this.f7634e + 1;
                                this.f7634e = i12;
                                z10 = httpRequestRetryHandler.retryRequest(e12, i12, this.f7631b);
                                iOException = e12;
                                if (z10) {
                                }
                            }
                        } catch (Exception e13) {
                            Log.e("AsyncHttpRequest", "Unhandled exception origin cause", e13);
                            throw new IOException("Unhandled exception: " + e13.getMessage());
                        }
                    } catch (NullPointerException e14) {
                        iOException = new IOException("NPE in HttpClient: " + e14.getMessage());
                        int i13 = this.f7634e + 1;
                        this.f7634e = i13;
                        z10 = httpRequestRetryHandler.retryRequest(iOException, i13, this.f7631b);
                        if (z10) {
                        }
                    }
                    if (!a()) {
                        h hVar5 = this.f7633d;
                        if (hVar5 != null) {
                            hVar5.o();
                        }
                        this.f7637h = true;
                        return;
                    }
                    return;
                }
            }
        }
    }
}
