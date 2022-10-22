package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public interface IDynamicLoader extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDynamicLoader {

        /* renamed from: a  reason: collision with root package name */
        static final int f13773a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final String f13774b = "com.huawei.hms.feature.dynamic.IDynamicLoader";

        /* loaded from: classes.dex */
        static class Proxy implements IDynamicLoader {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13775a;

            Proxy(IBinder iBinder) {
                this.f13775a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13775a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f13774b;
            }

            @Override // com.huawei.hms.feature.dynamic.IDynamicLoader
            public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i10, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f13774b);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f13775a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f13774b);
        }

        public static IDynamicLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f13774b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicLoader)) ? new Proxy(iBinder) : (IDynamicLoader) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f13774b);
                IObjectWrapper load = load(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(load != null ? load.asBinder() : null);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(f13774b);
                return true;
            }
        }
    }

    IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i10, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
