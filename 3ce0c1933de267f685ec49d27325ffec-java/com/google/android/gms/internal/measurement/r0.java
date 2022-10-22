package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
public interface r0 extends IInterface {
    void C1(zzed zzedVar) throws RemoteException;

    List<zzjx> G(String str, String str2, String str3, boolean z10) throws RemoteException;

    void K(zzjx zzjxVar, zzdz zzdzVar) throws RemoteException;

    byte[] P(zzeu zzeuVar, String str) throws RemoteException;

    void Q0(zzdz zzdzVar) throws RemoteException;

    void X0(zzed zzedVar, zzdz zzdzVar) throws RemoteException;

    void c0(zzdz zzdzVar) throws RemoteException;

    List<zzed> e2(String str, String str2, String str3) throws RemoteException;

    List<zzjx> f2(String str, String str2, boolean z10, zzdz zzdzVar) throws RemoteException;

    List<zzjx> i1(zzdz zzdzVar, boolean z10) throws RemoteException;

    void l1(zzeu zzeuVar, zzdz zzdzVar) throws RemoteException;

    void r0(zzdz zzdzVar) throws RemoteException;

    String r1(zzdz zzdzVar) throws RemoteException;

    List<zzed> v2(String str, String str2, zzdz zzdzVar) throws RemoteException;

    void w0(zzeu zzeuVar, String str, String str2) throws RemoteException;

    void x0(long j10, String str, String str2, String str3) throws RemoteException;
}
