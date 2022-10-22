package com.unionpay.mobile.android.hce.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.mobile.android.hce.service.b;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.unionpay.mobile.android.hce.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0261a extends Binder implements a {

        /* renamed from: com.unionpay.mobile.android.hce.service.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0262a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f23423a;

            C0262a(IBinder iBinder) {
                this.f23423a = iBinder;
            }

            @Override // com.unionpay.mobile.android.hce.service.a
            public final String a(String str, String str2, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f23423a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.mobile.android.hce.service.a
            public final void a(String str, String str2, String str3, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.mobile.android.hce.service.IHCEBankService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f23423a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f23423a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0262a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
                String a10 = a(parcel.readString(), parcel.readString(), b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("com.unionpay.mobile.android.hce.service.IHCEBankService");
                a(parcel.readString(), parcel.readString(), parcel.readString(), b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.mobile.android.hce.service.IHCEBankService");
                return true;
            }
        }
    }

    String a(String str, String str2, b bVar) throws RemoteException;

    void a(String str, String str2, String str3, b bVar) throws RemoteException;
}
