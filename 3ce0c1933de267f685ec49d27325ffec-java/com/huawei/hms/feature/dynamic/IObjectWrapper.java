package com.huawei.hms.feature.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IObjectWrapper extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IObjectWrapper {

        /* renamed from: a  reason: collision with root package name */
        private static final String f13776a = "com.huawei.hms.feature.dynamic.IObjectWrapper";

        /* loaded from: classes.dex */
        static class Proxy implements IObjectWrapper {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13777a;

            Proxy(IBinder iBinder) {
                this.f13777a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13777a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f13776a;
            }
        }

        public Stub() {
            attachInterface(this, f13776a);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f13776a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f13776a);
            return true;
        }
    }
}
