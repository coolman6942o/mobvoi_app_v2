package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.ml.scan.HmsScan;
/* loaded from: classes2.dex */
public interface IRemoteDecoderDelegate extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IRemoteDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
        public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IRemoteDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate";
        static final int TRANSACTION_buildBitmap = 3;
        static final int TRANSACTION_buildBitmapLog = 2;
        static final int TRANSACTION_decodeWithBitmap = 1;
        static final int TRANSACTION_queryDeepLinkInfo = 4;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IRemoteDecoderDelegate {
            public static IRemoteDecoderDelegate sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().buildBitmap(iObjectWrapper);
                    }
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().buildBitmapLog(iObjectWrapper);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
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
                        return Stub.getDefaultImpl().decodeWithBitmap(iObjectWrapper, iObjectWrapper2);
                    }
                    obtain2.readException();
                    return (HmsScan[]) obtain2.createTypedArray(HmsScan.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
            public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryDeepLinkInfo(iObjectWrapper);
                    }
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteDecoderDelegate)) {
                return new Proxy(iBinder);
            }
            return (IRemoteDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteDecoderDelegate iRemoteDecoderDelegate) {
            if (Proxy.sDefaultImpl != null || iRemoteDecoderDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteDecoderDelegate;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                HmsScan[] decodeWithBitmap = decodeWithBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decodeWithBitmap, 1);
                return true;
            } else if (i10 != 2) {
                IBinder iBinder = null;
                if (i10 == 3) {
                    parcel.enforceInterface(DESCRIPTOR);
                    IObjectWrapper buildBitmap = buildBitmap(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (buildBitmap != null) {
                        iBinder = buildBitmap.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                } else if (i10 != 4) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                } else {
                    parcel.enforceInterface(DESCRIPTOR);
                    IObjectWrapper queryDeepLinkInfo = queryDeepLinkInfo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (queryDeepLinkInfo != null) {
                        iBinder = queryDeepLinkInfo.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                }
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                buildBitmapLog(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException;

    void buildBitmapLog(IObjectWrapper iObjectWrapper) throws RemoteException;

    HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException;
}
