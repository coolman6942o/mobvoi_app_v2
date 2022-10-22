package com.mobvoi.wear.voicesearch;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mobvoi.wear.voicesearch.ISearchCallback;
/* loaded from: classes2.dex */
public interface ISearchInterface extends IInterface {
    public static final String BIND_ACTION = "com.mobvoi.wear.voicesearch.REMOTE_SERVICE";

    /* loaded from: classes2.dex */
    public static class Default implements ISearchInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public void cancelSession() throws RemoteException {
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public void onConnect(ISearchCallback iSearchCallback) throws RemoteException {
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public void onDisconnect() throws RemoteException {
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public void onError(int i10) throws RemoteException {
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public int sendEvent(int i10, byte[] bArr) throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public void startSearch() throws RemoteException {
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchInterface
        public boolean startSession(int i10) throws RemoteException {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ISearchInterface {
        private static final String DESCRIPTOR = "com.mobvoi.wear.voicesearch.ISearchInterface";
        static final int TRANSACTION_cancelSession = 6;
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_onConnect = 2;
        static final int TRANSACTION_onDisconnect = 3;
        static final int TRANSACTION_onError = 7;
        static final int TRANSACTION_sendEvent = 8;
        static final int TRANSACTION_startSearch = 5;
        static final int TRANSACTION_startSession = 4;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements ISearchInterface {
            public static ISearchInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public void cancelSession() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelSession();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public int getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVersion();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public void onConnect(ISearchCallback iSearchCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iSearchCallback != null ? iSearchCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onConnect(iSearchCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public void onDisconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onDisconnect();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public void onError(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onError(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public int sendEvent(int i10, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sendEvent(i10, bArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public void startSearch() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().startSearch();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchInterface
            public boolean startSession(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startSession(i10);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISearchInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISearchInterface)) {
                return new Proxy(iBinder);
            }
            return (ISearchInterface) queryLocalInterface;
        }

        public static ISearchInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISearchInterface iSearchInterface) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iSearchInterface == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSearchInterface;
                return true;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int version = getVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(version);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onConnect(ISearchCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDisconnect();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean startSession = startSession(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(startSession ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        startSearch();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        cancelSession();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onError(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        int sendEvent = sendEvent(parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(sendEvent);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void cancelSession() throws RemoteException;

    int getVersion() throws RemoteException;

    void onConnect(ISearchCallback iSearchCallback) throws RemoteException;

    void onDisconnect() throws RemoteException;

    void onError(int i10) throws RemoteException;

    int sendEvent(int i10, byte[] bArr) throws RemoteException;

    void startSearch() throws RemoteException;

    boolean startSession(int i10) throws RemoteException;
}
