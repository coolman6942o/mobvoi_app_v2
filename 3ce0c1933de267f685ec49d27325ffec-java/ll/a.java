package ll;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import ll.b;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: ll.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0385a extends Binder implements a {

        /* renamed from: ll.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0386a implements a {

            /* renamed from: b  reason: collision with root package name */
            public static a f30506b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f30507a;

            public C0386a(IBinder iBinder) {
                this.f30507a = iBinder;
            }

            @Override // ll.a
            public void T1(String str, b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f30507a.transact(7, obtain, obtain2, 0) || AbstractBinderC0385a.m1() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC0385a.m1().T1(str, bVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ll.a
            public int a() {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    if (this.f30507a.transact(4, obtain, obtain2, 0) || AbstractBinderC0385a.m1() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = AbstractBinderC0385a.m1().a();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ll.a
            public boolean a(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeInt(z10 ? 1 : 0);
                    boolean z11 = false;
                    if (!this.f30507a.transact(2, obtain, obtain2, 0) && AbstractBinderC0385a.m1() != null) {
                        return AbstractBinderC0385a.m1().a(z10);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30507a;
            }

            @Override // ll.a
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    boolean z10 = false;
                    if (!this.f30507a.transact(3, obtain, obtain2, 0) && AbstractBinderC0385a.m1() != null) {
                        return AbstractBinderC0385a.m1().c();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ll.a
            public boolean k1(String str, DfuConfig dfuConfig, QcConfig qcConfig) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    boolean z10 = true;
                    if (dfuConfig != null) {
                        obtain.writeInt(1);
                        dfuConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qcConfig != null) {
                        obtain.writeInt(1);
                        qcConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f30507a.transact(1, obtain, obtain2, 0) && AbstractBinderC0385a.m1() != null) {
                        return AbstractBinderC0385a.m1().k1(str, dfuConfig, qcConfig);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ll.a
            public boolean m2(String str, b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.realsil.sdk.dfu.IRealsilDfu");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    boolean z10 = false;
                    if (!this.f30507a.transact(6, obtain, obtain2, 0) && AbstractBinderC0385a.m1() != null) {
                        return AbstractBinderC0385a.m1().m2(str, bVar);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0385a() {
            attachInterface(this, "com.realsil.sdk.dfu.IRealsilDfu");
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.realsil.sdk.dfu.IRealsilDfu");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0386a(iBinder) : (a) queryLocalInterface;
        }

        public static a m1() {
            return C0386a.f30506b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        String readString = parcel.readString();
                        QcConfig qcConfig = null;
                        DfuConfig createFromParcel = parcel.readInt() != 0 ? DfuConfig.CREATOR.createFromParcel(parcel) : null;
                        if (parcel.readInt() != 0) {
                            qcConfig = QcConfig.CREATOR.createFromParcel(parcel);
                        }
                        boolean k12 = k1(readString, createFromParcel, qcConfig);
                        parcel2.writeNoException();
                        parcel2.writeInt(k12 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        boolean a10 = a(z10);
                        parcel2.writeNoException();
                        parcel2.writeInt(a10 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        boolean c10 = c();
                        parcel2.writeNoException();
                        parcel2.writeInt(c10 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        int a11 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a11);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        Throughput b10 = b();
                        parcel2.writeNoException();
                        if (b10 != null) {
                            parcel2.writeInt(1);
                            b10.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        boolean m22 = m2(parcel.readString(), b.a.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(m22 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.realsil.sdk.dfu.IRealsilDfu");
                        T1(parcel.readString(), b.a.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString("com.realsil.sdk.dfu.IRealsilDfu");
                return true;
            }
        }
    }

    void T1(String str, b bVar);

    int a();

    boolean a(boolean z10);

    Throughput b();

    boolean c();

    boolean k1(String str, DfuConfig dfuConfig, QcConfig qcConfig);

    boolean m2(String str, b bVar);
}
