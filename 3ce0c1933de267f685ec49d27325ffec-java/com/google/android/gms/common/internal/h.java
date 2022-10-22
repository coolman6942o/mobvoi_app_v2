package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import r6.b;
import r6.c;
/* loaded from: classes.dex */
public interface h extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends b implements h {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // r6.b
        protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                J0(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.b(parcel, Bundle.CREATOR));
            } else if (i10 == 2) {
                A0(parcel.readInt(), (Bundle) c.b(parcel, Bundle.CREATOR));
            } else if (i10 != 3) {
                return false;
            } else {
                q0(parcel.readInt(), parcel.readStrongBinder(), (zzb) c.b(parcel, zzb.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void A0(int i10, Bundle bundle) throws RemoteException;

    void J0(int i10, IBinder iBinder, Bundle bundle) throws RemoteException;

    void q0(int i10, IBinder iBinder, zzb zzbVar) throws RemoteException;
}
