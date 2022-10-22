package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class p6 extends k6 implements n6 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p6(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.n6
    public final Bundle J1(Bundle bundle) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, bundle);
        Parcel U1 = U1(1, m12);
        Bundle bundle2 = (Bundle) m6.a(U1, Bundle.CREATOR);
        U1.recycle();
        return bundle2;
    }
}
