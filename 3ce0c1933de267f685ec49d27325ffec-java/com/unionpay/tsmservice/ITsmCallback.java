package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface ITsmCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ITsmCallback {

        /* loaded from: classes2.dex */
        private static class a implements ITsmCallback {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24477a;

            a(IBinder iBinder) {
                this.f24477a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24477a;
            }

            @Override // com.unionpay.tsmservice.ITsmCallback
            public final void onError(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f24477a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmCallback
            public final void onResult(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24477a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.ITsmCallback");
        }

        public static ITsmCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmCallback)) ? new a(iBinder) : (ITsmCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.ITsmCallback");
                onResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            } else if (i10 == 2) {
                parcel.enforceInterface("com.unionpay.tsmservice.ITsmCallback");
                onError(parcel.readString(), parcel.readString());
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.tsmservice.ITsmCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(String str, String str2) throws RemoteException;

    void onResult(Bundle bundle) throws RemoteException;
}
