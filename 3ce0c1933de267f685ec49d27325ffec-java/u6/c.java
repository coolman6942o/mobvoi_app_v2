package u6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class c extends a implements r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
    }

    @Override // u6.r
    public final boolean h(r rVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, rVar);
        Parcel U1 = U1(15, m12);
        boolean d10 = h.d(U1);
        U1.recycle();
        return d10;
    }

    @Override // u6.r
    public final int n() throws RemoteException {
        Parcel U1 = U1(16, m1());
        int readInt = U1.readInt();
        U1.recycle();
        return readInt;
    }
}
