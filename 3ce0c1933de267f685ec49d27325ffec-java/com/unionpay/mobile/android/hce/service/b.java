package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.unionpay.mobile.android.hce.service.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0263a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f23424a;

            C0263a(IBinder iBinder) {
                this.f23424a = iBinder;
            }

            @Override // com.unionpay.mobile.android.hce.service.b
            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
                    obtain.writeString(str);
                    this.f23424a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.mobile.android.hce.service.b
            public final void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCECallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f23424a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23424a;
            }
        }

        public a() {
            attachInterface(this, "com.unionpay.mobile.android.hce.service.IHCECallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0263a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
                a(parcel.readString(), parcel.readString());
            } else if (i10 == 2) {
                parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCECallback");
                a(parcel.readString());
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCECallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;
}
