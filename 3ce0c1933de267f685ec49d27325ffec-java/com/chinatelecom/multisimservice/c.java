package com.chinatelecom.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.chinatelecom.multisimservice.model.b;
/* compiled from: IServiceBinder.java */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: IServiceBinder.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.chinatelecom.multisimservice.IServiceBinder");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IServiceBinder");
                IBinder M0 = M0(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(M0);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IServiceBinder");
                x(b.a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IServiceBinder");
                g0(b.a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 4) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IServiceBinder");
                r2();
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.chinatelecom.multisimservice.IServiceBinder");
                return true;
            }
        }
    }

    IBinder M0(String str, String str2) throws RemoteException;

    void g0(b bVar) throws RemoteException;

    void r2() throws RemoteException;

    void x(b bVar) throws RemoteException;
}
