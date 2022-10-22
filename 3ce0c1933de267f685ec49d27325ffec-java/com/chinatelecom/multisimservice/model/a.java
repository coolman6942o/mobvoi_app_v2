package com.chinatelecom.multisimservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IOpenMultiSimCalbcak.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IOpenMultiSimCalbcak.java */
    /* renamed from: com.chinatelecom.multisimservice.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0097a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IOpenMultiSimCalbcak.java */
        /* renamed from: com.chinatelecom.multisimservice.model.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0098a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f8228b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8229a;

            C0098a(IBinder iBinder) {
                this.f8229a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8229a;
            }

            @Override // com.chinatelecom.multisimservice.model.a
            public void s2(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.chinatelecom.multisimservice.model.IOpenMultiSimCalbcak");
                    if (multiSimDeviceInfo != null) {
                        obtain.writeInt(1);
                        multiSimDeviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f8229a.transact(1, obtain, obtain2, 0) || AbstractBinderC0097a.m1() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0097a.m1().s2(multiSimDeviceInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.chinatelecom.multisimservice.model.IOpenMultiSimCalbcak");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0098a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a m1() {
            return C0098a.f8228b;
        }
    }

    void s2(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException;
}
