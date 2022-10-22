package u6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes.dex */
public final class n extends a implements l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // u6.l
    public final void F(LatLng latLng) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, latLng);
        A2(3, m12);
    }

    @Override // u6.l
    public final boolean W1(l lVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, lVar);
        Parcel U1 = U1(16, m12);
        boolean d10 = h.d(U1);
        U1.recycle();
        return d10;
    }

    @Override // u6.l
    public final int n() throws RemoteException {
        Parcel U1 = U1(17, m1());
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }

    @Override // u6.l
    public final void remove() throws RemoteException {
        A2(1, m1());
    }
}
