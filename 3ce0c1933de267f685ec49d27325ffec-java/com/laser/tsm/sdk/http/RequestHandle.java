package com.laser.tsm.sdk.http;

import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest asyncHttpRequest) {
        this.request = new WeakReference<>(asyncHttpRequest);
    }

    public boolean cancel(boolean z10) {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.cancel(z10);
    }

    public boolean isCancelled() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isCancelled();
    }

    public boolean isFinished() {
        AsyncHttpRequest asyncHttpRequest = this.request.get();
        return asyncHttpRequest == null || asyncHttpRequest.isDone();
    }

    public boolean shouldBeGarbageCollected() {
        boolean z10 = isFinished() || isCancelled();
        if (z10) {
            this.request.clear();
        }
        return z10;
    }
}
