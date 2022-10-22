package com.huawei.hms.hmsscankit.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.aiscan.common.x;
/* loaded from: classes2.dex */
public interface IRemoteFrameDecoderDelegate extends IInterface {

    /* loaded from: classes2.dex */
    public static class Default implements IRemoteFrameDecoderDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
        public x[] decode(byte[] bArr, int i10, int i11, int i12, int i13, IObjectWrapper iObjectWrapper) throws RemoteException {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IRemoteFrameDecoderDelegate {
        private static final String DESCRIPTOR = "com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate";
        static final int TRANSACTION_decode = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class Proxy implements IRemoteFrameDecoderDelegate {
            public static IRemoteFrameDecoderDelegate sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate
            public x[] decode(byte[] bArr, int i10, int i11, int i12, int i13, IObjectWrapper iObjectWrapper) throws RemoteException {
                Throwable th2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(i13);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    try {
                        if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            x[] xVarArr = (x[]) obtain2.createTypedArray(x.CREATOR);
                            obtain2.recycle();
                            obtain.recycle();
                            return xVarArr;
                        }
                        x[] decode = Stub.getDefaultImpl().decode(bArr, i10, i11, i12, i13, iObjectWrapper);
                        obtain2.recycle();
                        obtain.recycle();
                        return decode;
                    } catch (Throwable th3) {
                        th2 = th3;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteFrameDecoderDelegate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteFrameDecoderDelegate)) {
                return new Proxy(iBinder);
            }
            return (IRemoteFrameDecoderDelegate) queryLocalInterface;
        }

        public static IRemoteFrameDecoderDelegate getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteFrameDecoderDelegate iRemoteFrameDecoderDelegate) {
            if (Proxy.sDefaultImpl != null || iRemoteFrameDecoderDelegate == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteFrameDecoderDelegate;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                x[] decode = decode(parcel.createByteArray(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeTypedArray(decode, 1);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    x[] decode(byte[] bArr, int i10, int i11, int i12, int i13, IObjectWrapper iObjectWrapper) throws RemoteException;
}
