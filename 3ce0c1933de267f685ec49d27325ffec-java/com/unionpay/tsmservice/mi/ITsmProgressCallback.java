package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface ITsmProgressCallback extends IInterface {

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ITsmProgressCallback {

        /* loaded from: classes2.dex */
        final class a implements ITsmProgressCallback {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24530a;

            a(IBinder iBinder) {
                this.f24530a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24530a;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmProgressCallback
            public final void onProgress(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmProgressCallback");
                    obtain.writeInt(i10);
                    this.f24530a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmProgressCallback");
        }

        public static ITsmProgressCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmProgressCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmProgressCallback)) ? new a(iBinder) : (ITsmProgressCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmProgressCallback");
                onProgress(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmProgressCallback");
                return true;
            }
        }
    }

    void onProgress(int i10);
}
