package com.euicc.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IServiceBinder.java */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: IServiceBinder.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.euicc.server.IServiceBinder");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.euicc.server.IServiceBinder");
                IBinder d10 = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(d10);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.euicc.server.IServiceBinder");
                return true;
            }
        }
    }

    IBinder d(String str) throws RemoteException;
}
