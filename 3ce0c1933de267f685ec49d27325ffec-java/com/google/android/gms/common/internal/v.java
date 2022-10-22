package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.e;
import g6.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ServiceConnection> f8959a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private int f8960b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8961c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f8962d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a f8963e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f8964f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ u f8965g;

    public v(u uVar, e.a aVar) {
        this.f8965g = uVar;
        this.f8963e = aVar;
    }

    public final IBinder a() {
        return this.f8962d;
    }

    public final ComponentName b() {
        return this.f8964f;
    }

    public final int c() {
        return this.f8960b;
    }

    public final boolean d() {
        return this.f8961c;
    }

    public final void e(ServiceConnection serviceConnection, String str) {
        Context context;
        a unused;
        Context unused2;
        unused = this.f8965g.f8956f;
        unused2 = this.f8965g.f8954d;
        e.a aVar = this.f8963e;
        context = this.f8965g.f8954d;
        aVar.c(context);
        this.f8959a.add(serviceConnection);
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f8959a.contains(serviceConnection);
    }

    public final void g(ServiceConnection serviceConnection, String str) {
        a unused;
        Context unused2;
        unused = this.f8965g.f8956f;
        unused2 = this.f8965g.f8954d;
        this.f8959a.remove(serviceConnection);
    }

    public final void h(String str) {
        a aVar;
        Context context;
        Context context2;
        a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j10;
        this.f8960b = 3;
        aVar = this.f8965g.f8956f;
        context = this.f8965g.f8954d;
        e.a aVar3 = this.f8963e;
        context2 = this.f8965g.f8954d;
        boolean d10 = aVar.d(context, str, aVar3.c(context2), this, this.f8963e.d());
        this.f8961c = d10;
        if (d10) {
            handler = this.f8965g.f8955e;
            Message obtainMessage = handler.obtainMessage(1, this.f8963e);
            handler2 = this.f8965g.f8955e;
            j10 = this.f8965g.f8958h;
            handler2.sendMessageDelayed(obtainMessage, j10);
            return;
        }
        this.f8960b = 2;
        try {
            aVar2 = this.f8965g.f8956f;
            context3 = this.f8965g.f8954d;
            aVar2.c(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void i(String str) {
        Handler handler;
        a aVar;
        Context context;
        handler = this.f8965g.f8955e;
        handler.removeMessages(1, this.f8963e);
        aVar = this.f8965g.f8956f;
        context = this.f8965g.f8954d;
        aVar.c(context, this);
        this.f8961c = false;
        this.f8960b = 2;
    }

    public final boolean j() {
        return this.f8959a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f8965g.f8953c;
        synchronized (hashMap) {
            handler = this.f8965g.f8955e;
            handler.removeMessages(1, this.f8963e);
            this.f8962d = iBinder;
            this.f8964f = componentName;
            for (ServiceConnection serviceConnection : this.f8959a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f8960b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f8965g.f8953c;
        synchronized (hashMap) {
            handler = this.f8965g.f8955e;
            handler.removeMessages(1, this.f8963e);
            this.f8962d = null;
            this.f8964f = componentName;
            for (ServiceConnection serviceConnection : this.f8959a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f8960b = 2;
        }
    }
}
