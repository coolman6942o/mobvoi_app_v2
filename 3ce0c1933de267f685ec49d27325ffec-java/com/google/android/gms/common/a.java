package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b6.i;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8439a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<IBinder> f8440b = new LinkedBlockingQueue();

    public IBinder a(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        i.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f8439a) {
            this.f8439a = true;
            IBinder poll = this.f8440b.poll(j10, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8440b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
