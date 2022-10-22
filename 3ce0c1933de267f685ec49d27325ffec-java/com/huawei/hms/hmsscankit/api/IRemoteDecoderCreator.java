package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
/* loaded from: classes2.dex */
public interface IRemoteDecoderCreator extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IRemoteDecoderCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
        public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IRemoteDecoderCreator {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator";
        static final int TRANSACTION_newRemoteFrameDecoderDelegate = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IRemoteDecoderCreator {
            public static IRemoteDecoderCreator sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator
            public IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteFrameDecoderDelegate();
                    }
                    obtain2.readException();
                    return IRemoteFrameDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteDecoderCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteDecoderCreator)) {
                return new Proxy(iBinder);
            }
            return (IRemoteDecoderCreator) queryLocalInterface;
        }

        public static IRemoteDecoderCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteDecoderCreator iRemoteDecoderCreator) {
            if (Proxy.sDefaultImpl != null || iRemoteDecoderCreator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteDecoderCreator;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate = newRemoteFrameDecoderDelegate();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(newRemoteFrameDecoderDelegate != null ? newRemoteFrameDecoderDelegate.asBinder() : null);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    IRemoteFrameDecoderDelegate newRemoteFrameDecoderDelegate() throws RemoteException;
}
