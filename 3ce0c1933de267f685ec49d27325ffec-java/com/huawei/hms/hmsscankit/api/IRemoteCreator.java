package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
/* loaded from: classes2.dex */
public interface IRemoteCreator extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IRemoteCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IRemoteCreator {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteCreator";
        static final int TRANSACTION_newRemoteDecoderDelegate = 2;
        static final int TRANSACTION_newRemoteHmsDecoderDelegate = 3;
        static final int TRANSACTION_newRemoteViewDelegate = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IRemoteCreator {
            public static IRemoteCreator sDefaultImpl;
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

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteDecoderDelegate();
                    }
                    obtain2.readException();
                    return IRemoteDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteHmsDecoderDelegate();
                    }
                    obtain2.readException();
                    return IRemoteHmsDecoderDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newRemoteViewDelegate(iObjectWrapper, iObjectWrapper2);
                    }
                    obtain2.readException();
                    return IRemoteViewDelegate.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteCreator)) {
                return new Proxy(iBinder);
            }
            return (IRemoteCreator) queryLocalInterface;
        }

        public static IRemoteCreator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteCreator iRemoteCreator) {
            if (Proxy.sDefaultImpl != null || iRemoteCreator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteCreator;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            IBinder iBinder = null;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteViewDelegate newRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (newRemoteViewDelegate != null) {
                    iBinder = newRemoteViewDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteDecoderDelegate newRemoteDecoderDelegate = newRemoteDecoderDelegate();
                parcel2.writeNoException();
                if (newRemoteDecoderDelegate != null) {
                    iBinder = newRemoteDecoderDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate = newRemoteHmsDecoderDelegate();
                parcel2.writeNoException();
                if (newRemoteHmsDecoderDelegate != null) {
                    iBinder = newRemoteHmsDecoderDelegate.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException;

    IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException;

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
