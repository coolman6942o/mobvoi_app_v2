package com.mobvoi.wear.stats;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
/* loaded from: classes2.dex */
public interface IMmsStats extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IMmsStats {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.stats.IMmsStats
        public Map getStats() throws RemoteException {
            return null;
        }

        @Override // com.mobvoi.wear.stats.IMmsStats
        public void noteReceive(String str, long j10) throws RemoteException {
        }

        @Override // com.mobvoi.wear.stats.IMmsStats
        public void noteSend(String str, long j10) throws RemoteException {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IMmsStats {
        private static final String DESCRIPTOR = "com.mobvoi.wear.stats.IMmsStats";
        static final int TRANSACTION_getStats = 3;
        static final int TRANSACTION_noteReceive = 2;
        static final int TRANSACTION_noteSend = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IMmsStats {
            public static IMmsStats sDefaultImpl;
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

            @Override // com.mobvoi.wear.stats.IMmsStats
            public Map getStats() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getStats();
                    }
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.stats.IMmsStats
            public void noteReceive(String str, long j10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j10);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().noteReceive(str, j10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mobvoi.wear.stats.IMmsStats
            public void noteSend(String str, long j10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j10);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().noteSend(str, j10);
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

        public static IMmsStats asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMmsStats)) {
                return new Proxy(iBinder);
            }
            return (IMmsStats) queryLocalInterface;
        }

        public static IMmsStats getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMmsStats iMmsStats) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMmsStats == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMmsStats;
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
                noteSend(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                noteReceive(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                Map stats = getStats();
                parcel2.writeNoException();
                parcel2.writeMap(stats);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    Map getStats() throws RemoteException;

    void noteReceive(String str, long j10) throws RemoteException;

    void noteSend(String str, long j10) throws RemoteException;
}
