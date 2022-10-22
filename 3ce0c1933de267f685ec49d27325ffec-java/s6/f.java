package s6;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class f extends a implements d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    @Override // s6.d
    public final void E(Message message) throws RemoteException {
        Parcel m12 = m1();
        c.a(m12, message);
        U1(1, m12);
    }
}
