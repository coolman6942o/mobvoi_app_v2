package com.mobvoi.wear.msgproxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes2.dex */
public interface IMessageProxyService extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IMessageProxyService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public List<NodeInfo> getConnectedNodes() throws RemoteException {
            return null;
        }

        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public boolean hasConnectedNodes() throws RemoteException {
            return false;
        }

        @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
        public void sendMessage(String str, String str2, byte[] bArr) throws RemoteException {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IMessageProxyService {
        private static final String DESCRIPTOR = "com.mobvoi.wear.msgproxy.IMessageProxyService";
        static final int TRANSACTION_getConnectedNodes = 2;
        static final int TRANSACTION_hasConnectedNodes = 1;
        static final int TRANSACTION_sendMessage = 3;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IMessageProxyService {
            public static IMessageProxyService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
            public List<NodeInfo> getConnectedNodes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConnectedNodes();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(NodeInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
            public boolean hasConnectedNodes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasConnectedNodes();
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

            @Override // com.mobvoi.wear.msgproxy.IMessageProxyService
            public void sendMessage(String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendMessage(str, str2, bArr);
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

        public static IMessageProxyService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMessageProxyService)) {
                return new Proxy(iBinder);
            }
            return (IMessageProxyService) queryLocalInterface;
        }

        public static IMessageProxyService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMessageProxyService iMessageProxyService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMessageProxyService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMessageProxyService;
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
                boolean hasConnectedNodes = hasConnectedNodes();
                parcel2.writeNoException();
                parcel2.writeInt(hasConnectedNodes ? 1 : 0);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                List<NodeInfo> connectedNodes = getConnectedNodes();
                parcel2.writeNoException();
                parcel2.writeTypedList(connectedNodes);
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                sendMessage(parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    List<NodeInfo> getConnectedNodes() throws RemoteException;

    boolean hasConnectedNodes() throws RemoteException;

    void sendMessage(String str, String str2, byte[] bArr) throws RemoteException;
}
