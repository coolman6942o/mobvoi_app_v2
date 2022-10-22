package d6;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import q6.a;
import q6.c;
/* loaded from: classes.dex */
public final class n extends a implements m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // d6.m
    public final void T0(k kVar) throws RemoteException {
        Parcel m12 = m1();
        c.c(m12, kVar);
        A2(1, m12);
    }
}
