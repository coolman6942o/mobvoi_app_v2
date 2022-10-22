package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.wearable.a;
/* loaded from: classes.dex */
public final class j extends a implements i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    @Override // com.google.android.gms.wearable.internal.i
    public final void S(d dVar) throws RemoteException {
        Parcel m12 = m1();
        v6.a.b(m12, dVar);
        U1(14, m12);
    }

    @Override // com.google.android.gms.wearable.internal.i
    public final void Z1(d dVar, String str, int i10) throws RemoteException {
        Parcel m12 = m1();
        v6.a.b(m12, dVar);
        m12.writeString(str);
        m12.writeInt(i10);
        U1(42, m12);
    }

    @Override // com.google.android.gms.wearable.internal.i
    public final void e0(d dVar, zzd zzdVar) throws RemoteException {
        Parcel m12 = m1();
        v6.a.b(m12, dVar);
        v6.a.c(m12, zzdVar);
        U1(16, m12);
    }

    @Override // com.google.android.gms.wearable.internal.i
    public final void h1(d dVar) throws RemoteException {
        Parcel m12 = m1();
        v6.a.b(m12, dVar);
        U1(15, m12);
    }

    @Override // com.google.android.gms.wearable.internal.i
    public final void z(d dVar, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel m12 = m1();
        v6.a.b(m12, dVar);
        m12.writeString(str);
        m12.writeString(str2);
        m12.writeByteArray(bArr);
        U1(12, m12);
    }
}
