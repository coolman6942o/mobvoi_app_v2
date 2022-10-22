package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import q6.i;
/* loaded from: classes.dex */
public final class d implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final a f8935a;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f8942h;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<d.b> f8936b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<d.b> f8937c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<d.c> f8938d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f8939e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f8940f = new AtomicInteger(0);

    /* renamed from: g  reason: collision with root package name */
    private boolean f8941g = false;

    /* renamed from: i  reason: collision with root package name */
    private final Object f8943i = new Object();

    /* loaded from: classes.dex */
    public interface a {
        boolean isConnected();

        Bundle w();
    }

    public d(Looper looper, a aVar) {
        this.f8935a = aVar;
        this.f8942h = new i(looper, this);
    }

    public final void a() {
        this.f8939e = false;
        this.f8940f.incrementAndGet();
    }

    public final void b() {
        this.f8939e = true;
    }

    public final void c(ConnectionResult connectionResult) {
        b6.i.e(this.f8942h, "onConnectionFailure must only be called on the Handler thread");
        this.f8942h.removeMessages(1);
        synchronized (this.f8943i) {
            ArrayList arrayList = new ArrayList(this.f8938d);
            int i10 = this.f8940f.get();
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                d.c cVar = (d.c) obj;
                if (this.f8939e && this.f8940f.get() == i10) {
                    if (this.f8938d.contains(cVar)) {
                        cVar.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    public final void d(Bundle bundle) {
        b6.i.e(this.f8942h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f8943i) {
            boolean z10 = true;
            b6.i.n(!this.f8941g);
            this.f8942h.removeMessages(1);
            this.f8941g = true;
            if (this.f8937c.size() != 0) {
                z10 = false;
            }
            b6.i.n(z10);
            ArrayList arrayList = new ArrayList(this.f8936b);
            int i10 = this.f8940f.get();
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                d.b bVar = (d.b) obj;
                if (!this.f8939e || !this.f8935a.isConnected() || this.f8940f.get() != i10) {
                    break;
                } else if (!this.f8937c.contains(bVar)) {
                    bVar.onConnected(bundle);
                }
            }
            this.f8937c.clear();
            this.f8941g = false;
        }
    }

    public final void e(int i10) {
        b6.i.e(this.f8942h, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f8942h.removeMessages(1);
        synchronized (this.f8943i) {
            this.f8941g = true;
            ArrayList arrayList = new ArrayList(this.f8936b);
            int i11 = this.f8940f.get();
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                d.b bVar = (d.b) obj;
                if (!this.f8939e || this.f8940f.get() != i11) {
                    break;
                } else if (this.f8936b.contains(bVar)) {
                    bVar.onConnectionSuspended(i10);
                }
            }
            this.f8937c.clear();
            this.f8941g = false;
        }
    }

    public final void f(d.b bVar) {
        b6.i.k(bVar);
        synchronized (this.f8943i) {
            if (this.f8936b.contains(bVar)) {
                String valueOf = String.valueOf(bVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 62);
                sb2.append("registerConnectionCallbacks(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
                Log.w("GmsClientEvents", sb2.toString());
            } else {
                this.f8936b.add(bVar);
            }
        }
        if (this.f8935a.isConnected()) {
            Handler handler = this.f8942h;
            handler.sendMessage(handler.obtainMessage(1, bVar));
        }
    }

    public final void g(d.c cVar) {
        b6.i.k(cVar);
        synchronized (this.f8943i) {
            if (this.f8938d.contains(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 67);
                sb2.append("registerConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" is already registered");
                Log.w("GmsClientEvents", sb2.toString());
            } else {
                this.f8938d.add(cVar);
            }
        }
    }

    public final void h(d.c cVar) {
        b6.i.k(cVar);
        synchronized (this.f8943i) {
            if (!this.f8938d.remove(cVar)) {
                String valueOf = String.valueOf(cVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 57);
                sb2.append("unregisterConnectionFailedListener(): listener ");
                sb2.append(valueOf);
                sb2.append(" not found");
                Log.w("GmsClientEvents", sb2.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            d.b bVar = (d.b) message.obj;
            synchronized (this.f8943i) {
                if (this.f8939e && this.f8935a.isConnected() && this.f8936b.contains(bVar)) {
                    bVar.onConnected(this.f8935a.w());
                }
            }
            return true;
        }
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("Don't know how to handle message: ");
        sb2.append(i10);
        Log.wtf("GmsClientEvents", sb2.toString(), new Exception());
        return false;
    }
}
