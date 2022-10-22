package com.google.android.gms.internal.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b6.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.LocationRequest;
import w6.b;
/* loaded from: classes.dex */
public final class p extends u {
    private final i G;

    public p(Context context, Looper looper, d.b bVar, d.c cVar, String str, c cVar2) {
        super(context, looper, bVar, cVar, str, cVar2);
        this.G = new i(context, this.F);
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final void a() {
        synchronized (this.G) {
            if (isConnected()) {
                try {
                    this.G.b();
                    this.G.i();
                } catch (Exception e10) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e10);
                }
            }
            super.a();
        }
    }

    public final Location r0() throws RemoteException {
        return this.G.a();
    }

    public final void s0(i.a<w6.c> aVar, d dVar) throws RemoteException {
        this.G.d(aVar, dVar);
    }

    public final void t0(zzbd zzbdVar, i<b> iVar, d dVar) throws RemoteException {
        synchronized (this.G) {
            this.G.e(zzbdVar, iVar, dVar);
        }
    }

    public final void u0(LocationRequest locationRequest, i<w6.c> iVar, d dVar) throws RemoteException {
        synchronized (this.G) {
            this.G.f(locationRequest, iVar, dVar);
        }
    }

    public final void v0(i.a<b> aVar, d dVar) throws RemoteException {
        this.G.j(aVar, dVar);
    }
}
