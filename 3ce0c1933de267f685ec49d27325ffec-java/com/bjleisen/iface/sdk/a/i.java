package com.bjleisen.iface.sdk.a;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
/* compiled from: RetryHandler.java */
/* loaded from: classes.dex */
final class i implements HttpRequestRetryHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet<Class<?>> f7662a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet<Class<?>> f7663b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7664c = 5;

    /* renamed from: d  reason: collision with root package name */
    private final int f7665d = 1500;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        f7662a = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        f7663b = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    private static void a(Class<?> cls) {
        f7662a.add(cls);
    }

    private static void b(Class<?> cls) {
        f7663b.add(cls);
    }

    public final boolean retryRequest(IOException iOException, int i10, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        boolean z10 = true;
        if (i10 > this.f7664c || (!a(f7662a, iOException) && a(f7663b, iOException))) {
            z10 = false;
        }
        if (z10 && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
            return false;
        }
        if (z10) {
            SystemClock.sleep(this.f7665d);
        } else {
            iOException.printStackTrace();
        }
        return z10;
    }

    private static boolean a(HashSet<Class<?>> hashSet, Throwable th2) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th2)) {
                return true;
            }
        }
        return false;
    }
}
