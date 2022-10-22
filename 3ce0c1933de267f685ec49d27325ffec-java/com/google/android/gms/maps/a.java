package com.google.android.gms.maps;

import android.os.RemoteException;
import b6.i;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import u6.l;
import y6.b;
import z6.c;
import z6.d;
import z6.e;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f10011a;

    /* renamed from: b  reason: collision with root package name */
    private b f10012b;

    /* renamed from: com.google.android.gms.maps.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0115a {
        void q();
    }

    public a(b bVar) {
        this.f10011a = (b) i.k(bVar);
    }

    public final c a(MarkerOptions markerOptions) {
        try {
            l q22 = this.f10011a.q2(markerOptions);
            if (q22 != null) {
                return new c(q22);
            }
            return null;
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final d b(PolygonOptions polygonOptions) {
        try {
            return new d(this.f10011a.R0(polygonOptions));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final e c(PolylineOptions polylineOptions) {
        try {
            return new e(this.f10011a.S1(polylineOptions));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void d() {
        try {
            this.f10011a.clear();
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final b e() {
        try {
            if (this.f10012b == null) {
                this.f10012b = new b(this.f10011a.b1());
            }
            return this.f10012b;
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void f(x6.a aVar) {
        try {
            this.f10011a.L1(aVar.a());
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void g(boolean z10) {
        try {
            this.f10011a.e(z10);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void h(AbstractC0115a aVar) {
        try {
            if (aVar == null) {
                this.f10011a.I(null);
            } else {
                this.f10011a.I(new f(this, aVar));
            }
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }
}
