package com.laser.tsm.sdk.http;

import android.util.Log;
import com.laser.tsm.sdk.util.LogUtil;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes2.dex */
public class AsyncHttpRequest implements Runnable {
    private int executionCount;
    private final AbstractHttpClient httpClient;
    private final HttpContext httpContext;
    private final HttpUriRequest httpUriRequest;
    private final ResponseHandlerInterface responseHandler;
    private boolean isCancelled = false;
    private boolean cancelIsNotified = false;
    private boolean isFinished = false;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        this.httpClient = abstractHttpClient;
        this.httpContext = httpContext;
        this.httpUriRequest = httpUriRequest;
        this.responseHandler = responseHandlerInterface;
    }

    private void makeRequest() throws IOException {
        ResponseHandlerInterface responseHandlerInterface;
        if (!isCancelled()) {
            if (this.httpUriRequest.getURI().getScheme() != null) {
                LogUtil.e("AysncHttpClient", "get response before");
                HttpResponse execute = this.httpClient.execute(this.httpUriRequest);
                LogUtil.e("AysncHttpClient", "get response after" + execute.getStatusLine().getStatusCode());
                if (!isCancelled() && (responseHandlerInterface = this.responseHandler) != null) {
                    responseHandlerInterface.sendResponseMessage(execute);
                    return;
                }
                return;
            }
            throw new MalformedURLException("No valid URI scheme was provided");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0009 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequestWithRetries() throws IOException {
        ResponseHandlerInterface responseHandlerInterface;
        IOException iOException;
        boolean z10;
        HttpRequestRetryHandler httpRequestRetryHandler = this.httpClient.getHttpRequestRetryHandler();
        IOException e10 = null;
        boolean z11 = true;
        while (z11) {
            try {
                try {
                    try {
                        makeRequest();
                        return;
                    } catch (UnknownHostException e11) {
                        iOException = new IOException("UnknownHostException exception:" + e11.getMessage());
                        if (this.executionCount > 0) {
                            int i10 = this.executionCount + 1;
                            this.executionCount = i10;
                            if (httpRequestRetryHandler.retryRequest(iOException, i10, this.httpContext)) {
                                z10 = true;
                                e10 = iOException;
                                z11 = z10;
                                if (z11 && (responseHandlerInterface = this.responseHandler) != null) {
                                    responseHandlerInterface.sendRetryMessage(this.executionCount);
                                }
                            }
                        }
                        z10 = false;
                        e10 = iOException;
                        z11 = z10;
                        if (z11) {
                            responseHandlerInterface.sendRetryMessage(this.executionCount);
                        }
                    }
                } catch (NullPointerException e12) {
                    iOException = new IOException("NPE in HttpClient: " + e12.getMessage());
                    int i11 = this.executionCount + 1;
                    this.executionCount = i11;
                    z10 = httpRequestRetryHandler.retryRequest(iOException, i11, this.httpContext);
                    e10 = iOException;
                    z11 = z10;
                    if (z11) {
                    }
                }
            } catch (IOException e13) {
                e10 = e13;
                try {
                    if (!isCancelled()) {
                        int i12 = this.executionCount + 1;
                        this.executionCount = i12;
                        z11 = httpRequestRetryHandler.retryRequest(e10, i12, this.httpContext);
                        if (z11) {
                        }
                    } else {
                        return;
                    }
                } catch (Exception e14) {
                    Log.e("AsyncHttpRequest", "Unhandled exception origin cause", e14);
                    throw new IOException("Unhandled exception: " + e14.getMessage());
                }
            }
        }
    }

    private synchronized void sendCancelNotification() {
        if (!this.isFinished && this.isCancelled && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            ResponseHandlerInterface responseHandlerInterface = this.responseHandler;
            if (responseHandlerInterface != null) {
                responseHandlerInterface.sendCancelMessage();
            }
        }
    }

    public boolean cancel(boolean z10) {
        this.isCancelled = true;
        this.httpUriRequest.abort();
        return isCancelled();
    }

    public boolean isCancelled() {
        if (this.isCancelled) {
            sendCancelNotification();
        }
        return this.isCancelled;
    }

    public boolean isDone() {
        return isCancelled() || this.isFinished;
    }

    @Override // java.lang.Runnable
    public void run() {
        ResponseHandlerInterface responseHandlerInterface;
        if (!isCancelled()) {
            ResponseHandlerInterface responseHandlerInterface2 = this.responseHandler;
            if (responseHandlerInterface2 != null) {
                responseHandlerInterface2.sendStartMessage();
            }
            if (!isCancelled()) {
                try {
                    makeRequestWithRetries();
                } catch (Exception e10) {
                    if (isCancelled() || (responseHandlerInterface = this.responseHandler) == null) {
                        Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null" + e10);
                    } else {
                        responseHandlerInterface.sendFailureMessage(0, null, null, e10);
                    }
                }
                if (!isCancelled()) {
                    ResponseHandlerInterface responseHandlerInterface3 = this.responseHandler;
                    if (responseHandlerInterface3 != null) {
                        responseHandlerInterface3.sendFinishMessage();
                    }
                    this.isFinished = true;
                }
            }
        }
    }
}
