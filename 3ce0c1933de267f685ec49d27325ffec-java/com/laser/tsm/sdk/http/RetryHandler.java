package com.laser.tsm.sdk.http;

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
/* loaded from: classes2.dex */
class RetryHandler implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> exceptionBlacklist;
    private static final HashSet<Class<?>> exceptionWhitelist;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        exceptionWhitelist = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        exceptionBlacklist = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    public RetryHandler(int i10, int i11) {
        this.maxRetries = i10;
        this.retrySleepTimeMS = i11;
    }

    static void addClassToBlacklist(Class<?> cls) {
        exceptionBlacklist.add(cls);
    }

    static void addClassToWhitelist(Class<?> cls) {
        exceptionWhitelist.add(cls);
    }

    protected boolean isInList(HashSet<Class<?>> hashSet, Throwable th2) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th2)) {
                return true;
            }
        }
        return false;
    }

    public boolean retryRequest(IOException iOException, int i10, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        boolean z10 = true;
        if (i10 > this.maxRetries || (!isInList(exceptionWhitelist, iOException) && isInList(exceptionBlacklist, iOException))) {
            z10 = false;
        }
        if (z10 && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
            return false;
        }
        if (z10) {
            SystemClock.sleep(this.retrySleepTimeMS);
        } else {
            iOException.printStackTrace();
        }
        return z10;
    }
}
