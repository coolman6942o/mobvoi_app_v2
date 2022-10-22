package com.mobvoi.wear.mcu;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mobvoi.wear.mcu.IMcuManagerCallback;
/* loaded from: classes2.dex */
public interface IMcuManager extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IMcuManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void calibrateLLOB(long j10, IMcuManagerCallback iMcuManagerCallback) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void configOled(int i10, int i11) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void enableHeartRate(boolean z10) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void enableMotion(boolean z10) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void enableStep(boolean z10) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public byte[] getBandModeData() throws RemoteException {
            return null;
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public int getDataVersion() throws RemoteException {
            return 0;
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void updateFitnessState(FitnessMcuData fitnessMcuData) throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void wakeUp() throws RemoteException {
        }

        @Override // com.mobvoi.wear.mcu.IMcuManager
        public void wipeBandModeData() throws RemoteException {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IMcuManager {
        private static final String DESCRIPTOR = "com.mobvoi.wear.mcu.IMcuManager";
        static final int TRANSACTION_calibrateLLOB = 8;
        static final int TRANSACTION_configOled = 10;
        static final int TRANSACTION_enableHeartRate = 4;
        static final int TRANSACTION_enableMotion = 6;
        static final int TRANSACTION_enableStep = 5;
        static final int TRANSACTION_getBandModeData = 2;
        static final int TRANSACTION_getDataVersion = 7;
        static final int TRANSACTION_updateFitnessState = 1;
        static final int TRANSACTION_wakeUp = 9;
        static final int TRANSACTION_wipeBandModeData = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IMcuManager {
            public static IMcuManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void calibrateLLOB(long j10, IMcuManagerCallback iMcuManagerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j10);
                    obtain.writeStrongBinder(iMcuManagerCallback != null ? iMcuManagerCallback.asBinder() : null);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().calibrateLLOB(j10, iMcuManagerCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void configOled(int i10, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().configOled(i10, i11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void enableHeartRate(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().enableHeartRate(z10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void enableMotion(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().enableMotion(z10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void enableStep(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().enableStep(z10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public byte[] getBandModeData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBandModeData();
                    }
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public int getDataVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDataVersion();
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

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void updateFitnessState(FitnessMcuData fitnessMcuData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (fitnessMcuData != null) {
                        obtain.writeInt(1);
                        fitnessMcuData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateFitnessState(fitnessMcuData);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void wakeUp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().wakeUp();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.mcu.IMcuManager
            public void wipeBandModeData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().wipeBandModeData();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMcuManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMcuManager)) {
                return new Proxy(iBinder);
            }
            return (IMcuManager) queryLocalInterface;
        }

        public static IMcuManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMcuManager iMcuManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMcuManager == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMcuManager;
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
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateFitnessState(parcel.readInt() != 0 ? FitnessMcuData.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] bandModeData = getBandModeData();
                        parcel2.writeNoException();
                        parcel2.writeByteArray(bandModeData);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        wipeBandModeData();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        enableHeartRate(z10);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        enableStep(z10);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        enableMotion(z10);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        int dataVersion = getDataVersion();
                        parcel2.writeNoException();
                        parcel2.writeInt(dataVersion);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        calibrateLLOB(parcel.readLong(), IMcuManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        wakeUp();
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        configOled(parcel.readInt(), parcel.readInt());
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

    void calibrateLLOB(long j10, IMcuManagerCallback iMcuManagerCallback) throws RemoteException;

    void configOled(int i10, int i11) throws RemoteException;

    void enableHeartRate(boolean z10) throws RemoteException;

    void enableMotion(boolean z10) throws RemoteException;

    void enableStep(boolean z10) throws RemoteException;

    byte[] getBandModeData() throws RemoteException;

    int getDataVersion() throws RemoteException;

    void updateFitnessState(FitnessMcuData fitnessMcuData) throws RemoteException;

    void wakeUp() throws RemoteException;

    void wipeBandModeData() throws RemoteException;
}
