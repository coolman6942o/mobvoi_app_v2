package com.cmcc.server.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IOpenMultiSimCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IOpenMultiSimCallback.java */
    /* renamed from: com.cmcc.server.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0100a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IOpenMultiSimCallback.java */
        /* renamed from: com.cmcc.server.model.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0101a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f8252b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8253a;

            C0101a(IBinder iBinder) {
                this.f8253a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8253a;
            }

            @Override // com.cmcc.server.model.a
            public void j1(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.cmcc.server.model.IOpenMultiSimCallback");
                    if (multiSimDeviceInfo != null) {
                        obtain.writeInt(1);
                        multiSimDeviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f8253a.transact(1, obtain, obtain2, 0) || AbstractBinderC0100a.m1() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0100a.m1().j1(multiSimDeviceInfo);
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
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.cmcc.server.model.IOpenMultiSimCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0101a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a m1() {
            return C0101a.f8252b;
        }
    }

    void j1(MultiSimDeviceInfo multiSimDeviceInfo) throws RemoteException;
}
