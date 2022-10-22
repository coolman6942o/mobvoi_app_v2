package b3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: b3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0064a extends Binder implements a {

        /* renamed from: b3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0065a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4983a;

            C0065a(IBinder iBinder) {
                this.f4983a = iBinder;
            }

            @Override // b3.a
            public final byte[] B1(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
                    obtain.writeByteArray(bArr);
                    this.f4983a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b3.a
            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
                    boolean z10 = false;
                    this.f4983a.transact(4, obtain, obtain2, 0);
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

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4983a;
            }

            @Override // b3.a
            public final boolean b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.f4983a.transact(8, obtain, obtain2, 0);
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

            @Override // b3.a
            public final byte[] k2(byte[] bArr, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    this.f4983a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cn.gov.pbc.tsm.client.mobile.android.bank.service.IServiceForBank");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0065a(iBinder) : (a) queryLocalInterface;
        }
    }

    byte[] B1(byte[] bArr) throws RemoteException;

    boolean a() throws RemoteException;

    boolean b(String str) throws RemoteException;

    byte[] k2(byte[] bArr, String str) throws RemoteException;
}
