package com.bjleisen.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface IBluetoothInterfaceService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IBluetoothInterfaceService {
        private static final String DESCRIPTOR = "com.bjleisen.bluetooth.IBluetoothInterfaceService";
        static final int TRANSACTION_closeSEChannel = 7;
        static final int TRANSACTION_connectBluetoothDevice = 3;
        static final int TRANSACTION_disconnectBluetoothDevice = 4;
        static final int TRANSACTION_getDeviceInfo = 1;
        static final int TRANSACTION_openSEChannel = 5;
        static final int TRANSACTION_queryBluetoothState = 2;
        static final int TRANSACTION_transiveAPDU = 6;

        /* loaded from: classes.dex */
        private static class Proxy implements IBluetoothInterfaceService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public void closeSEChannel() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public int connectBluetoothDevice(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (deviceInfo != null) {
                        obtain.writeInt(1);
                        deviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public void disconnectBluetoothDevice() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public int getDeviceInfo(DeviceInfo deviceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    if (obtain2.readInt() != 0) {
                        deviceInfo.readFromParcel(obtain2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public byte[] openSEChannel(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public boolean queryBluetoothState() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            @Override // com.bjleisen.bluetooth.IBluetoothInterfaceService
            public byte[] transiveAPDU(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBluetoothInterfaceService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothInterfaceService)) {
                return new Proxy(iBinder);
            }
            return (IBluetoothInterfaceService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        DeviceInfo deviceInfo = new DeviceInfo();
                        int deviceInfo2 = getDeviceInfo(deviceInfo);
                        parcel2.writeNoException();
                        parcel2.writeInt(deviceInfo2);
                        parcel2.writeInt(1);
                        deviceInfo.writeToParcel(parcel2, 1);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean queryBluetoothState = queryBluetoothState();
                        parcel2.writeNoException();
                        parcel2.writeInt(queryBluetoothState ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int connectBluetoothDevice = connectBluetoothDevice(parcel.readInt() != 0 ? DeviceInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(connectBluetoothDevice);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        disconnectBluetoothDevice();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] openSEChannel = openSEChannel(parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(openSEChannel);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] transiveAPDU = transiveAPDU(parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(transiveAPDU);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        closeSEChannel();
                        parcel2.writeNoException();
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

    void closeSEChannel();

    int connectBluetoothDevice(DeviceInfo deviceInfo);

    void disconnectBluetoothDevice();

    int getDeviceInfo(DeviceInfo deviceInfo);

    byte[] openSEChannel(byte[] bArr);

    boolean queryBluetoothState();

    byte[] transiveAPDU(byte[] bArr);
}
