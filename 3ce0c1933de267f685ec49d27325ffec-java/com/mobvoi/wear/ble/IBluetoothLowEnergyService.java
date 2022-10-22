package com.mobvoi.wear.ble;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface IBluetoothLowEnergyService extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IBluetoothLowEnergyService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public void connect(String str) throws RemoteException {
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public void disconnect(String str) throws RemoteException {
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public String getConnectedDevice() throws RemoteException {
            return null;
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public boolean isAncsConnected() throws RemoteException {
            return false;
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public boolean isCompanionConnected() throws RemoteException {
            return false;
        }

        @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
        public boolean isConnected() throws RemoteException {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IBluetoothLowEnergyService {
        private static final String DESCRIPTOR = "com.mobvoi.wear.ble.IBluetoothLowEnergyService";
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_disconnect = 5;
        static final int TRANSACTION_getConnectedDevice = 6;
        static final int TRANSACTION_isAncsConnected = 3;
        static final int TRANSACTION_isCompanionConnected = 4;
        static final int TRANSACTION_isConnected = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IBluetoothLowEnergyService {
            public static IBluetoothLowEnergyService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public void connect(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().connect(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public void disconnect(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().disconnect(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public String getConnectedDevice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConnectedDevice();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public boolean isAncsConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isAncsConnected();
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

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public boolean isCompanionConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCompanionConnected();
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

            @Override // com.mobvoi.wear.ble.IBluetoothLowEnergyService
            public boolean isConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isConnected();
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

        public static IBluetoothLowEnergyService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothLowEnergyService)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothLowEnergyService) queryLocalInterface;
        }

        public static IBluetoothLowEnergyService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBluetoothLowEnergyService iBluetoothLowEnergyService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iBluetoothLowEnergyService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iBluetoothLowEnergyService;
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
                        connect(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isConnected = isConnected();
                        parcel2.writeNoException();
                        parcel2.writeInt(isConnected ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isAncsConnected = isAncsConnected();
                        parcel2.writeNoException();
                        parcel2.writeInt(isAncsConnected ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isCompanionConnected = isCompanionConnected();
                        parcel2.writeNoException();
                        parcel2.writeInt(isCompanionConnected ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        disconnect(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String connectedDevice = getConnectedDevice();
                        parcel2.writeNoException();
                        parcel2.writeString(connectedDevice);
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

    void connect(String str) throws RemoteException;

    void disconnect(String str) throws RemoteException;

    String getConnectedDevice() throws RemoteException;

    boolean isAncsConnected() throws RemoteException;

    boolean isCompanionConnected() throws RemoteException;

    boolean isConnected() throws RemoteException;
}
