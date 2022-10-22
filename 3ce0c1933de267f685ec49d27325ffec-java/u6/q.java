package u6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class q extends a implements o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    @Override // u6.o
    public final boolean g1(o oVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, oVar);
        Parcel U1 = U1(19, m12);
        boolean d10 = h.d(U1);
        U1.recycle();
        return d10;
    }

    @Override // u6.o
    public final int n() throws RemoteException {
        Parcel U1 = U1(20, m1());
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }
}
