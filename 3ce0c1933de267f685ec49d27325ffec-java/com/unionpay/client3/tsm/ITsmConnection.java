package com.unionpay.client3.tsm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface ITsmConnection extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ITsmConnection {
        private static final String DESCRIPTOR = "com.unionpay.client3.tsm.ITsmConnection";
        static final int TRANSACTION_closeChannel = 2;
        static final int TRANSACTION_getSeApps = 3;
        static final int TRANSACTION_sendApdu = 1;

        /* loaded from: classes2.dex */
        private static class Proxy implements ITsmConnection {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.unionpay.client3.tsm.ITsmConnection
            public void closeChannel(int i10, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.unionpay.client3.tsm.ITsmConnection
            public SeAppInfo[] getSeApps(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return (SeAppInfo[]) obtain2.createTypedArray(SeAppInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.client3.tsm.ITsmConnection
            public String sendApdu(int i10, String str, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITsmConnection asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmConnection)) ? new Proxy(iBinder) : (ITsmConnection) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String sendApdu = sendApdu(parcel.readInt(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(sendApdu);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                closeChannel(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                SeAppInfo[] seApps = getSeApps(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeTypedArray(seApps, 1);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void closeChannel(int i10, int i11) throws RemoteException;

    SeAppInfo[] getSeApps(int i10) throws RemoteException;

    String sendApdu(int i10, String str, int i11) throws RemoteException;
}
