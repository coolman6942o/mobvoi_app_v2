package com.mobvoi.wear.voicesearch;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface ISearchCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements ISearchCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int cancelSession() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int endAnsweer() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int read(byte[] bArr, int i10, int i11) throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int reset() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int sendEvent(int i10, byte[] bArr) throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int startAnswer() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int startRecording() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int startSession(int i10) throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.voicesearch.ISearchCallback
        public int stopRecording() throws RemoteException {
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ISearchCallback {
        private static final String DESCRIPTOR = "com.mobvoi.wear.voicesearch.ISearchCallback";
        static final int TRANSACTION_cancelSession = 9;
        static final int TRANSACTION_endAnsweer = 7;
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_read = 5;
        static final int TRANSACTION_reset = 8;
        static final int TRANSACTION_sendEvent = 10;
        static final int TRANSACTION_startAnswer = 6;
        static final int TRANSACTION_startRecording = 3;
        static final int TRANSACTION_startSession = 2;
        static final int TRANSACTION_stopRecording = 4;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements ISearchCallback {
            public static ISearchCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int cancelSession() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cancelSession();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int endAnsweer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().endAnsweer();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
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

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int read(byte[] bArr, int i10, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().read(bArr, i10, i11);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int reset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().reset();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int sendEvent(int i10, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeByteArray(bArr);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sendEvent(i10, bArr);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int startAnswer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startAnswer();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int startRecording() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startRecording();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int startSession(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().startSession(i10);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.voicesearch.ISearchCallback
            public int stopRecording() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stopRecording();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISearchCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISearchCallback)) {
                return new Proxy(iBinder);
            }
            return (ISearchCallback) queryLocalInterface;
        }

        public static ISearchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ISearchCallback iSearchCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iSearchCallback == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iSearchCallback;
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
                        int startSession = startSession(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(startSession);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startRecording = startRecording();
                        parcel2.writeNoException();
                        parcel2.writeInt(startRecording);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int stopRecording = stopRecording();
                        parcel2.writeNoException();
                        parcel2.writeInt(stopRecording);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        byte[] bArr = readInt < 0 ? null : new byte[readInt];
                        int read = read(bArr, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(read);
                        parcel2.writeByteArray(bArr);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startAnswer = startAnswer();
                        parcel2.writeNoException();
                        parcel2.writeInt(startAnswer);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        int endAnsweer = endAnsweer();
                        parcel2.writeNoException();
                        parcel2.writeInt(endAnsweer);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        int reset = reset();
                        parcel2.writeNoException();
                        parcel2.writeInt(reset);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int cancelSession = cancelSession();
                        parcel2.writeNoException();
                        parcel2.writeInt(cancelSession);
                        return true;
                    case 10:
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

    int cancelSession() throws RemoteException;

    int endAnsweer() throws RemoteException;

    int getVersion() throws RemoteException;

    int read(byte[] bArr, int i10, int i11) throws RemoteException;

    int reset() throws RemoteException;

    int sendEvent(int i10, byte[] bArr) throws RemoteException;

    int startAnswer() throws RemoteException;

    int startRecording() throws RemoteException;

    int startSession(int i10) throws RemoteException;

    int stopRecording() throws RemoteException;
}
