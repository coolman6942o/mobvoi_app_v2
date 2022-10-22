package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.internal.e;
import g6.a;
import java.util.HashMap;
import r6.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends e implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    private final Context f8954d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f8955e;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<e.a, v> f8953c = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final a f8956f = a.b();

    /* renamed from: g  reason: collision with root package name */
    private final long f8957g = 5000;

    /* renamed from: h  reason: collision with root package name */
    private final long f8958h = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context) {
        this.f8954d = context.getApplicationContext();
        this.f8955e = new d(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.e
    protected final boolean c(e.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d10;
        i.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f8953c) {
            v vVar = this.f8953c.get(aVar);
            if (vVar == null) {
                vVar = new v(this, aVar);
                vVar.e(serviceConnection, str);
                vVar.h(str);
                this.f8953c.put(aVar, vVar);
            } else {
                this.f8955e.removeMessages(0, aVar);
                if (!vVar.f(serviceConnection)) {
                    vVar.e(serviceConnection, str);
                    int c10 = vVar.c();
                    if (c10 == 1) {
                        serviceConnection.onServiceConnected(vVar.b(), vVar.a());
                    } else if (c10 == 2) {
                        vVar.h(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 81);
                    sb2.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb2.append(valueOf);
                    throw new IllegalStateException(sb2.toString());
                }
            }
            d10 = vVar.d();
        }
        return d10;
    }

    @Override // com.google.android.gms.common.internal.e
    protected final void d(e.a aVar, ServiceConnection serviceConnection, String str) {
        i.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f8953c) {
            v vVar = this.f8953c.get(aVar);
            if (vVar == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 50);
                sb2.append("Nonexistent connection status for service config: ");
                sb2.append(valueOf);
                throw new IllegalStateException(sb2.toString());
            } else if (vVar.f(serviceConnection)) {
                vVar.g(serviceConnection, str);
                if (vVar.j()) {
                    this.f8955e.sendMessageDelayed(this.f8955e.obtainMessage(0, aVar), this.f8957g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 76);
                sb3.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb3.append(valueOf2);
                throw new IllegalStateException(sb3.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f8953c) {
                e.a aVar = (e.a) message.obj;
                v vVar = this.f8953c.get(aVar);
                if (vVar != null && vVar.j()) {
                    if (vVar.d()) {
                        vVar.i("GmsClientSupervisor");
                    }
                    this.f8953c.remove(aVar);
                }
            }
            return true;
        } else if (i10 != 1) {
            return false;
        } else {
            synchronized (this.f8953c) {
                e.a aVar2 = (e.a) message.obj;
                v vVar2 = this.f8953c.get(aVar2);
                if (vVar2 != null && vVar2.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
                    sb2.append("Timeout waiting for ServiceConnection callback ");
                    sb2.append(valueOf);
                    Log.e("GmsClientSupervisor", sb2.toString(), new Exception());
                    ComponentName b10 = vVar2.b();
                    if (b10 == null) {
                        b10 = aVar2.a();
                    }
                    if (b10 == null) {
                        b10 = new ComponentName(aVar2.b(), "unknown");
                    }
                    vVar2.onServiceDisconnected(b10);
                }
            }
            return true;
        }
    }
}
