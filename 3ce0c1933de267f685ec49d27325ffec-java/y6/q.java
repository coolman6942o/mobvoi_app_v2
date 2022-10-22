package y6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import k6.b;
import u6.a;
import u6.h;
/* loaded from: classes.dex */
public final class q extends a implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IMapViewDelegate");
    }

    @Override // y6.c
    public final void G0(h hVar) throws RemoteException {
        Parcel m12 = m1();
        h.b(m12, hVar);
        A2(9, m12);
    }

    @Override // y6.c
    public final b getView() throws RemoteException {
        Parcel U1 = U1(8, m1());
        b m12 = b.a.m1(U1.readStrongBinder());
        U1.recycle();
        return m12;
    }

    @Override // y6.c
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel m12 = m1();
        h.c(m12, bundle);
        A2(2, m12);
    }

    @Override // y6.c
    public final void onDestroy() throws RemoteException {
        A2(5, m1());
    }

    @Override // y6.c
    public final void onPause() throws RemoteException {
        A2(4, m1());
    }

    @Override // y6.c
    public final void onResume() throws RemoteException {
        A2(3, m1());
    }
}
