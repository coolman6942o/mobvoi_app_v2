package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzk;
import k6.b;
import r6.a;
import r6.c;
/* loaded from: classes.dex */
public final class c0 extends a implements a0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.a0
    public final boolean x2(zzk zzkVar, b bVar) throws RemoteException {
        Parcel m12 = m1();
        c.d(m12, zzkVar);
        c.c(m12, bVar);
        Parcel U1 = U1(5, m12);
        boolean e10 = c.e(U1);
        U1.recycle();
        return e10;
    }
}
