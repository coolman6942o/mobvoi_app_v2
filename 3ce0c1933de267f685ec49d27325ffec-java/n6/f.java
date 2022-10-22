package n6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class f extends a implements d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // n6.d
    public final boolean f0(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        c.a(m12, true);
        Parcel U1 = U1(2, m12);
        boolean b10 = c.b(U1);
        U1.recycle();
        return b10;
    }

    @Override // n6.d
    public final String getId() throws RemoteException {
        Parcel U1 = U1(1, m1());
        String readString = U1.readString();
        U1.recycle();
        return readString;
    }
}
