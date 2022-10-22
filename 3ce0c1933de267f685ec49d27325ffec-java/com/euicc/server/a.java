package com.euicc.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.euicc.server.model.a;
/* compiled from: IOpenEUICC.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IOpenEUICC.java */
    /* renamed from: com.euicc.server.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0102a extends Binder implements a {
        public AbstractBinderC0102a() {
            attachInterface(this, "com.euicc.server.IOpenEUICC");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.euicc.server.IOpenEUICC");
                n1(a.AbstractBinderC0103a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("com.euicc.server.IOpenEUICC");
                U0(a.AbstractBinderC0103a.c(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("com.euicc.server.IOpenEUICC");
                I1();
                parcel2.writeNoException();
                return true;
            } else if (i10 == 4) {
                parcel.enforceInterface("com.euicc.server.IOpenEUICC");
                p1(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.euicc.server.IOpenEUICC");
                return true;
            }
        }
    }

    void I1() throws RemoteException;

    void U0(com.euicc.server.model.a aVar) throws RemoteException;

    void n1(com.euicc.server.model.a aVar) throws RemoteException;

    void p1(String str) throws RemoteException;
}
