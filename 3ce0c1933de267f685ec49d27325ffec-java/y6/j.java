package y6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import k6.b;
import u6.a;
import u6.h;
/* loaded from: classes.dex */
public final class j extends a implements a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    @Override // y6.a
    public final b V0(LatLngBounds latLngBounds, int i10, int i11, int i12) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, latLngBounds);
        m12.writeInt(i10);
        m12.writeInt(i11);
        m12.writeInt(i12);
        Parcel U1 = U1(11, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // y6.a
    public final b b2(LatLng latLng, float f10) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, latLng);
        m12.writeFloat(f10);
        Parcel U1 = U1(9, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // y6.a
    public final b c2(float f10, float f11) throws RemoteException {
        Parcel m12 = m1();
        m12.writeFloat(f10);
        m12.writeFloat(f11);
        Parcel U1 = U1(3, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }

    @Override // y6.a
    public final b g(LatLngBounds latLngBounds, int i10) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, latLngBounds);
        m12.writeInt(i10);
        Parcel U1 = U1(10, m12);
        b m13 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m13;
    }
}
