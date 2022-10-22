package com.euicc.server.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IOpenEUICCCalbcak.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IOpenEUICCCalbcak.java */
    /* renamed from: com.euicc.server.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0103a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IOpenEUICCCalbcak.java */
        /* renamed from: com.euicc.server.model.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0104a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f8274b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8275a;

            C0104a(IBinder iBinder) {
                this.f8275a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8275a;
            }

            @Override // com.euicc.server.model.a
            public void y2(EUICCDeviceInfo eUICCDeviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.euicc.server.model.IOpenEUICCCalbcak");
                    if (eUICCDeviceInfo != null) {
                        obtain.writeInt(1);
                        eUICCDeviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f8275a.transact(1, obtain, obtain2, 0) || AbstractBinderC0103a.m1() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0103a.m1().y2(eUICCDeviceInfo);
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
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.euicc.server.model.IOpenEUICCCalbcak");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0104a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a m1() {
            return C0104a.f8274b;
        }
    }

    void y2(EUICCDeviceInfo eUICCDeviceInfo) throws RemoteException;
}
