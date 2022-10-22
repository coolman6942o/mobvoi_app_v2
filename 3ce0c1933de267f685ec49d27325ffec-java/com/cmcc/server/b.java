package com.cmcc.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.cmcc.server.model.a;
/* compiled from: IOpenMultiSim.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IOpenMultiSim.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.cmcc.server.IOpenMultiSim");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.cmcc.server.IOpenMultiSim");
                t(a.AbstractBinderC0100a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("com.cmcc.server.IOpenMultiSim");
                O(a.AbstractBinderC0100a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("com.cmcc.server.IOpenMultiSim");
                p();
                parcel2.writeNoException();
                return true;
            } else if (i10 == 4) {
                parcel.enforceInterface("com.cmcc.server.IOpenMultiSim");
                K0(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.cmcc.server.IOpenMultiSim");
                return true;
            }
        }
    }

    void K0(String str) throws RemoteException;

    void O(com.cmcc.server.model.a aVar) throws RemoteException;

    void p() throws RemoteException;

    void t(com.cmcc.server.model.a aVar) throws RemoteException;
}
