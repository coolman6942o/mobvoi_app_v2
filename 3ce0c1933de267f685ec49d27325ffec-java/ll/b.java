package ll;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: ll.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0387a implements b {

            /* renamed from: b  reason: collision with root package name */
            public static b f30508b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f30509a;

            public C0387a(IBinder iBinder) {
                this.f30509a = iBinder;
            }

            @Override // ll.b
            public void P1(DfuProgressInfo dfuProgressInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfuCallback");
                    if (dfuProgressInfo != null) {
                        obtain.writeInt(1);
                        dfuProgressInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f30509a.transact(3, obtain, obtain2, 0) || a.m1() == null) {
                        obtain2.readException();
                    } else {
                        a.m1().P1(dfuProgressInfo);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ll.b
            public void a(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfuCallback");
                    obtain.writeInt(i10);
                    if (this.f30509a.transact(2, obtain, obtain2, 0) || a.m1() == null) {
                        obtain2.readException();
                    } else {
                        a.m1().a(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30509a;
            }

            @Override // ll.b
            public void b(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfuCallback");
                    obtain.writeInt(i10);
                    if (this.f30509a.transact(1, obtain, obtain2, 0) || a.m1() == null) {
                        obtain2.readException();
                    } else {
                        a.m1().b(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.realsil.sdk.dfu.IRealsilDfuCallback");
        }

        public static b c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.realsil.sdk.dfu.IRealsilDfuCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0387a(iBinder) : (b) queryLocalInterface;
        }

        public static b m1() {
            return C0387a.f30508b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfuCallback");
                b(parcel.readInt());
            } else if (i10 == 2) {
                parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfuCallback");
                a(parcel.readInt());
            } else if (i10 == 3) {
                parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfuCallback");
                P1(parcel.readInt() != 0 ? DfuProgressInfo.CREATOR.createFromParcel(parcel) : null);
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.realsil.sdk.dfu.IRealsilDfuCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void P1(DfuProgressInfo dfuProgressInfo);

    void a(int i10);

    void b(int i10);
}
