package y6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import k6.b;
import u6.a;
import u6.h;
import u6.l;
import u6.m;
import u6.o;
import u6.r;
/* loaded from: classes.dex */
public final class p extends a implements b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // y6.b
    public final void I(f fVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, fVar);
        A2(42, m12);
    }

    @Override // y6.b
    public final void L1(b bVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, bVar);
        A2(4, m12);
    }

    @Override // y6.b
    public final o R0(PolygonOptions polygonOptions) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, polygonOptions);
        Parcel U1 = U1(10, m12);
        o m13 = u6.p.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // y6.b
    public final r S1(PolylineOptions polylineOptions) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, polylineOptions);
        Parcel U1 = U1(9, m12);
        r m13 = u6.b.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // y6.b
    public final d b1() throws RemoteException {
        d dVar;
        Parcel U1 = U1(25, m1());
        IBinder readStrongBinder = U1.readStrongBinder();
        if (readStrongBinder == null) {
            dVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            if (queryLocalInterface instanceof d) {
                dVar = (d) queryLocalInterface;
            } else {
                dVar = new k(readStrongBinder);
            }
        }
        U1.recycle();
        return dVar;
    }

    @Override // y6.b
    public final void clear() throws RemoteException {
        A2(14, m1());
    }

    @Override // y6.b
    public final void e(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        h.a(m12, z10);
        A2(22, m12);
    }

    @Override // y6.b
    public final l q2(MarkerOptions markerOptions) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, markerOptions);
        Parcel U1 = U1(11, m12);
        l m13 = m.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }
}
