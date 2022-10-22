package com.mobvoi.wear.permission;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface IMobvoiPermissionManager extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IMobvoiPermissionManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
        public int checkPermission(String str, int i10) throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
        public boolean isUserFixed(String str, int i10) throws RemoteException {
            return false;
        }

        @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
        public int queryPermission(String str, int i10) throws RemoteException {
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IMobvoiPermissionManager {
        private static final String DESCRIPTOR = "com.mobvoi.wear.permission.IMobvoiPermissionManager";
        static final int TRANSACTION_checkPermission = 1;
        static final int TRANSACTION_isUserFixed = 3;
        static final int TRANSACTION_queryPermission = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IMobvoiPermissionManager {
            public static IMobvoiPermissionManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
            public int checkPermission(String str, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkPermission(str, i10);
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

            @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
            public boolean isUserFixed(String str, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    boolean z10 = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isUserFixed(str, i10);
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

            @Override // com.mobvoi.wear.permission.IMobvoiPermissionManager
            public int queryPermission(String str, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryPermission(str, i10);
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

        public static IMobvoiPermissionManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMobvoiPermissionManager)) {
                return new Proxy(iBinder);
            }
            return (IMobvoiPermissionManager) queryLocalInterface;
        }

        public static IMobvoiPermissionManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMobvoiPermissionManager iMobvoiPermissionManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMobvoiPermissionManager == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMobvoiPermissionManager;
                return true;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int checkPermission = checkPermission(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(checkPermission);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                int queryPermission = queryPermission(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(queryPermission);
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isUserFixed = isUserFixed(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(isUserFixed ? 1 : 0);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    int checkPermission(String str, int i10) throws RemoteException;

    boolean isUserFixed(String str, int i10) throws RemoteException;

    int queryPermission(String str, int i10) throws RemoteException;
}
