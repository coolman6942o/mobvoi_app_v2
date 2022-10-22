package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface ITsmActivityCallback extends IInterface {

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ITsmActivityCallback {

        /* loaded from: classes2.dex */
        final class a implements ITsmActivityCallback {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24528a;

            a(IBinder iBinder) {
                this.f24528a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24528a;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmActivityCallback
            public final void startActivity(String str, String str2, int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmActivityCallback");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24528a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmActivityCallback");
        }

        public static ITsmActivityCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmActivityCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmActivityCallback)) ? new a(iBinder) : (ITsmActivityCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmActivityCallback");
                startActivity(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmActivityCallback");
                return true;
            }
        }
    }

    void startActivity(String str, String str2, int i10, Bundle bundle);
}
