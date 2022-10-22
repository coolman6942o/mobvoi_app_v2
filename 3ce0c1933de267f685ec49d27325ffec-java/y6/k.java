package y6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import u6.a;
import u6.h;
/* loaded from: classes.dex */
public final class k extends a implements d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // y6.d
    public final void H0(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        h.a(m12, z10);
        A2(7, m12);
    }

    @Override // y6.d
    public final void p0(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        h.a(m12, z10);
        A2(5, m12);
    }

    @Override // y6.d
    public final void v1(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        h.a(m12, z10);
        A2(4, m12);
    }

    @Override // y6.d
    public final void y(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        h.a(m12, z10);
        A2(3, m12);
    }
}
