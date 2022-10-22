package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface OnSafetyKeyboardCallback extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements OnSafetyKeyboardCallback {

        /* loaded from: classes2.dex */
        private static class a implements OnSafetyKeyboardCallback {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24480a;

            a(IBinder iBinder) {
                this.f24480a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24480a;
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onEditorChanged(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    obtain.writeInt(i10);
                    this.f24480a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onHide() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    this.f24480a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.OnSafetyKeyboardCallback
            public final void onShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                    this.f24480a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.OnSafetyKeyboardCallback");
        }

        public static OnSafetyKeyboardCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OnSafetyKeyboardCallback)) ? new a(iBinder) : (OnSafetyKeyboardCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                onShow();
            } else if (i10 == 2) {
                parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                onHide();
            } else if (i10 == 3) {
                parcel.enforceInterface("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                onEditorChanged(parcel.readInt());
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.tsmservice.OnSafetyKeyboardCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onEditorChanged(int i10) throws RemoteException;

    void onHide() throws RemoteException;

    void onShow() throws RemoteException;
}
