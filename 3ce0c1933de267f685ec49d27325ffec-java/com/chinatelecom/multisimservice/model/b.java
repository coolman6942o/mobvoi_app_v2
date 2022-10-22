package com.chinatelecom.multisimservice.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ISmartWearServiceInfoCallback.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: ISmartWearServiceInfoCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ISmartWearServiceInfoCallback.java */
        /* renamed from: com.chinatelecom.multisimservice.model.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0099a implements b {

            /* renamed from: b  reason: collision with root package name */
            public static b f8230b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8231a;

            C0099a(IBinder iBinder) {
                this.f8231a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8231a;
            }

            @Override // com.chinatelecom.multisimservice.model.b
            public void m(SmartWearServiceInfo smartWearServiceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.chinatelecom.multisimservice.model.ISmartWearServiceInfoCallback");
                    if (smartWearServiceInfo != null) {
                        obtain.writeInt(1);
                        smartWearServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f8231a.transact(1, obtain, obtain2, 0) || a.m1() == null) {
                        obtain2.readException();
                    } else {
                        a.m1().m(smartWearServiceInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.chinatelecom.multisimservice.model.ISmartWearServiceInfoCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0099a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public static b m1() {
            return C0099a.f8230b;
        }
    }

    void m(SmartWearServiceInfo smartWearServiceInfo) throws RemoteException;
}
