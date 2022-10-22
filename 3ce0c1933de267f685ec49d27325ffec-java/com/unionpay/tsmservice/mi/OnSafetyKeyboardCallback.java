package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface OnSafetyKeyboardCallback extends IInterface {

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements OnSafetyKeyboardCallback {

        /* loaded from: classes2.dex */
        final class a implements OnSafetyKeyboardCallback {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24532a;

            a(IBinder iBinder) {
                this.f24532a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24532a;
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onConfirmClicked() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f24532a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onEditorChanged(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    obtain.writeInt(i10);
                    this.f24532a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onHide() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f24532a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onOutsideTouch(float f10, float f11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    obtain.writeFloat(f10);
                    obtain.writeFloat(f11);
                    this.f24532a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback
            public final void onShow() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                    this.f24532a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
        }

        public static OnSafetyKeyboardCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OnSafetyKeyboardCallback)) ? new a(iBinder) : (OnSafetyKeyboardCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onShow();
            } else if (i10 == 2) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onHide();
            } else if (i10 == 3) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onEditorChanged(parcel.readInt());
            } else if (i10 == 4) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onOutsideTouch(parcel.readFloat(), parcel.readFloat());
            } else if (i10 == 5) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                onConfirmClicked();
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onConfirmClicked();

    void onEditorChanged(int i10);

    void onHide();

    void onOutsideTouch(float f10, float f11);

    void onShow();
}
