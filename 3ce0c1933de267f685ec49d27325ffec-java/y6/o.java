package y6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import k6.b;
import u6.a;
import u6.h;
import u6.i;
import u6.j;
/* loaded from: classes.dex */
public final class o extends a implements n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // y6.n
    public final a D1() throws RemoteException {
        a aVar;
        Parcel U1 = U1(4, m1());
        IBinder readStrongBinder = U1.readStrongBinder();
        if (readStrongBinder == null) {
            aVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (queryLocalInterface instanceof a) {
                aVar = (a) queryLocalInterface;
            } else {
                aVar = new j(readStrongBinder);
            }
        }
        U1.recycle();
        return aVar;
    }

    @Override // y6.n
    public final c X(b bVar, GoogleMapOptions googleMapOptions) throws RemoteException {
        c cVar;
        Parcel m12 = m1();
        h.b(m12, bVar);
        h.c(m12, googleMapOptions);
        Parcel U1 = U1(3, m12);
        IBinder readStrongBinder = U1.readStrongBinder();
        if (readStrongBinder == null) {
            cVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (queryLocalInterface instanceof c) {
                cVar = (c) queryLocalInterface;
            } else {
                cVar = new q(readStrongBinder);
            }
        }
        U1.recycle();
        return cVar;
    }

    @Override // y6.n
    public final i j0() throws RemoteException {
        Parcel U1 = U1(5, m1());
        i m12 = j.m1(U1.readStrongBinder());
        U1.recycle();
        return m12;
    }

    @Override // y6.n
    public final void l2(b bVar, int i10) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, bVar);
        m12.writeInt(i10);
        A2(6, m12);
    }
}
