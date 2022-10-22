package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
/* loaded from: classes.dex */
public interface IDynamicInstall extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDynamicInstall {

        /* renamed from: a  reason: collision with root package name */
        static final int f13770a = 1;

        /* renamed from: b  reason: collision with root package name */
        private static final String f13771b = "com.huawei.hms.feature.dynamic.IDynamicInstall";

        /* loaded from: classes.dex */
        static class Proxy implements IDynamicInstall {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13772a;

            Proxy(IBinder iBinder) {
                this.f13772a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13772a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f13771b;
            }

            @Override // com.huawei.hms.feature.dynamic.IDynamicInstall
            public Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f13771b);
                    Bundle bundle2 = null;
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f13772a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, f13771b);
        }

        public static IDynamicInstall asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f13771b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicInstall)) ? new Proxy(iBinder) : (IDynamicInstall) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f13771b);
                Bundle install = install(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (install != null) {
                    parcel2.writeInt(1);
                    install.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(f13771b);
                return true;
            }
        }
    }

    Bundle install(IObjectWrapper iObjectWrapper, Bundle bundle) throws RemoteException;
}
