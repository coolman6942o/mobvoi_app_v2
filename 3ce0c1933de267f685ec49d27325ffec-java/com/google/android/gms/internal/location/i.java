package com.google.android.gms.internal.location;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;
import w6.b;
import w6.c;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final t<g> f9101a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9102b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9103c = false;

    /* renamed from: d  reason: collision with root package name */
    private final Map<i.a<c>, n> f9104d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<i.a<Object>, m> f9105e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<i.a<b>, j> f9106f = new HashMap();

    public i(Context context, t<g> tVar) {
        this.f9102b = context;
        this.f9101a = tVar;
    }

    private final n c(com.google.android.gms.common.api.internal.i<c> iVar) {
        n nVar;
        synchronized (this.f9104d) {
            nVar = this.f9104d.get(iVar.b());
            if (nVar == null) {
                nVar = new n(iVar);
            }
            this.f9104d.put(iVar.b(), nVar);
        }
        return nVar;
    }

    private final j h(com.google.android.gms.common.api.internal.i<b> iVar) {
        j jVar;
        synchronized (this.f9106f) {
            jVar = this.f9106f.get(iVar.b());
            if (jVar == null) {
                jVar = new j(iVar);
            }
            this.f9106f.put(iVar.b(), jVar);
        }
        return jVar;
    }

    public final Location a() throws RemoteException {
        this.f9101a.a();
        return this.f9101a.b().H1(this.f9102b.getPackageName());
    }

    public final void b() throws RemoteException {
        synchronized (this.f9104d) {
            for (n nVar : this.f9104d.values()) {
                if (nVar != null) {
                    this.f9101a.b().G1(zzbf.H0(nVar, null));
                }
            }
            this.f9104d.clear();
        }
        synchronized (this.f9106f) {
            for (j jVar : this.f9106f.values()) {
                if (jVar != null) {
                    this.f9101a.b().G1(zzbf.G0(jVar, null));
                }
            }
            this.f9106f.clear();
        }
        synchronized (this.f9105e) {
            for (m mVar : this.f9105e.values()) {
                if (mVar != null) {
                    this.f9101a.b().D0(new zzo(2, null, mVar.asBinder(), null));
                }
            }
            this.f9105e.clear();
        }
    }

    public final void d(i.a<c> aVar, d dVar) throws RemoteException {
        this.f9101a.a();
        b6.i.l(aVar, "Invalid null listener key");
        synchronized (this.f9104d) {
            n remove = this.f9104d.remove(aVar);
            if (remove != null) {
                remove.U1();
                this.f9101a.b().G1(zzbf.H0(remove, dVar));
            }
        }
    }

    public final void e(zzbd zzbdVar, com.google.android.gms.common.api.internal.i<b> iVar, d dVar) throws RemoteException {
        this.f9101a.a();
        this.f9101a.b().G1(new zzbf(1, zzbdVar, null, null, h(iVar).asBinder(), dVar != null ? dVar.asBinder() : null));
    }

    public final void f(LocationRequest locationRequest, com.google.android.gms.common.api.internal.i<c> iVar, d dVar) throws RemoteException {
        this.f9101a.a();
        this.f9101a.b().G1(new zzbf(1, zzbd.G0(locationRequest), c(iVar).asBinder(), null, null, dVar != null ? dVar.asBinder() : null));
    }

    public final void g(boolean z10) throws RemoteException {
        this.f9101a.a();
        this.f9101a.b().w1(z10);
        this.f9103c = z10;
    }

    public final void i() throws RemoteException {
        if (this.f9103c) {
            g(false);
        }
    }

    public final void j(i.a<b> aVar, d dVar) throws RemoteException {
        this.f9101a.a();
        b6.i.l(aVar, "Invalid null listener key");
        synchronized (this.f9106f) {
            j remove = this.f9106f.remove(aVar);
            if (remove != null) {
                remove.U1();
                this.f9101a.b().G1(zzbf.G0(remove, dVar));
            }
        }
    }
}
