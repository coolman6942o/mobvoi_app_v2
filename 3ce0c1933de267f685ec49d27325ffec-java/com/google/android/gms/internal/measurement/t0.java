package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class t0 extends k6 implements r0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void C1(zzed zzedVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzedVar);
        A2(13, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> G(String str, String str2, String str3, boolean z10) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        m12.writeString(str2);
        m12.writeString(str3);
        m6.d(m12, z10);
        Parcel U1 = U1(15, m12);
        ArrayList createTypedArrayList = U1.createTypedArrayList(zzjx.CREATOR);
        U1.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void K(zzjx zzjxVar, zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzjxVar);
        m6.c(m12, zzdzVar);
        A2(2, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void Q0(zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzdzVar);
        A2(18, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void X0(zzed zzedVar, zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzedVar);
        m6.c(m12, zzdzVar);
        A2(12, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void c0(zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzdzVar);
        A2(6, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzed> e2(String str, String str2, String str3) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        m12.writeString(str2);
        m12.writeString(str3);
        Parcel U1 = U1(17, m12);
        ArrayList createTypedArrayList = U1.createTypedArrayList(zzed.CREATOR);
        U1.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> f2(String str, String str2, boolean z10, zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        m12.writeString(str2);
        m6.d(m12, z10);
        m6.c(m12, zzdzVar);
        Parcel U1 = U1(14, m12);
        ArrayList createTypedArrayList = U1.createTypedArrayList(zzjx.CREATOR);
        U1.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> i1(zzdz zzdzVar, boolean z10) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzdzVar);
        m6.d(m12, z10);
        Parcel U1 = U1(7, m12);
        ArrayList createTypedArrayList = U1.createTypedArrayList(zzjx.CREATOR);
        U1.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void l1(zzeu zzeuVar, zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzeuVar);
        m6.c(m12, zzdzVar);
        A2(1, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void r0(zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzdzVar);
        A2(4, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final String r1(zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzdzVar);
        Parcel U1 = U1(11, m12);
        String readString = U1.readString();
        U1.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzed> v2(String str, String str2, zzdz zzdzVar) throws RemoteException {
        Parcel m12 = m1();
        m12.writeString(str);
        m12.writeString(str2);
        m6.c(m12, zzdzVar);
        Parcel U1 = U1(16, m12);
        ArrayList createTypedArrayList = U1.createTypedArrayList(zzed.CREATOR);
        U1.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void w0(zzeu zzeuVar, String str, String str2) throws RemoteException {
        Parcel m12 = m1();
        m6.c(m12, zzeuVar);
        m12.writeString(str);
        m12.writeString(str2);
        A2(5, m12);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void x0(long j10, String str, String str2, String str3) throws RemoteException {
        Parcel m12 = m1();
        m12.writeLong(j10);
        m12.writeString(str);
        m12.writeString(str2);
        m12.writeString(str3);
        A2(10, m12);
    }
}
