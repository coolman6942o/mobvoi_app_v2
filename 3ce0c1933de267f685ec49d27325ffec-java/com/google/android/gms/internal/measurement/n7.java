package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import k6.b;
/* loaded from: classes.dex */
public final class n7 extends k6 implements m7 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n7(IBinder iBinder) {
        super(iBinder, "com.google.firebase.crash.internal.IFirebaseCrashApi");
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void Y(b bVar, zzxs zzxsVar) throws RemoteException {
        Parcel m12 = m1();
        m6.b(m12, bVar);
        m6.c(m12, zzxsVar);
        A2(1, m12);
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void a1(String str) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        A2(6, m12);
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void l0(boolean z10) throws RemoteException {
        Parcel m12 = m1();
        m6.d(m12, z10);
        A2(10, m12);
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void r(b bVar) throws RemoteException {
        Parcel m12 = m1();
        m6.b(m12, bVar);
        A2(5, m12);
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void s(List<String> list) throws RemoteException {
        Parcel m12 = m1();
        m12.writeStringList(list);
        A2(11, m12);
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final boolean x1() throws RemoteException {
        Parcel U1 = U1(9, m1());
        boolean e10 = m6.e(U1);
        U1.recycle();
        return e10;
    }

    @Override // com.google.android.gms.internal.measurement.m7
    public final void z1(String str, long j10, Bundle bundle) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        m12.writeLong(j10);
        m6.c(m12, bundle);
        A2(7, m12);
    }
}
