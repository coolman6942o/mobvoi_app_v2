package com.chinatelecom.multisimservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.chinatelecom.multisimservice.model.a;
/* compiled from: IOpenMultiSim.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IOpenMultiSim.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.chinatelecom.multisimservice.IOpenMultiSim");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IOpenMultiSim");
                Z(a.AbstractBinderC0097a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IOpenMultiSim");
                i0(a.AbstractBinderC0097a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IOpenMultiSim");
                p();
                parcel2.writeNoException();
                return true;
            } else if (i10 == 4) {
                parcel.enforceInterface("com.chinatelecom.multisimservice.IOpenMultiSim");
                B0(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.chinatelecom.multisimservice.IOpenMultiSim");
                return true;
            }
        }
    }

    void B0(String str) throws RemoteException;

    void Z(com.chinatelecom.multisimservice.model.a aVar) throws RemoteException;

    void i0(com.chinatelecom.multisimservice.model.a aVar) throws RemoteException;

    void p() throws RemoteException;
}
