package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.k;
/* compiled from: IMultiInstanceInvalidationService.java */
/* loaded from: classes.dex */
public interface l extends IInterface {

    /* compiled from: IMultiInstanceInvalidationService.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements l {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IMultiInstanceInvalidationService.java */
        /* renamed from: androidx.room.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0046a implements l {

            /* renamed from: b  reason: collision with root package name */
            public static l f4272b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4273a;

            C0046a(IBinder iBinder) {
                this.f4273a = iBinder;
            }

            @Override // androidx.room.l
            public int U(k kVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    obtain.writeString(str);
                    if (!this.f4273a.transact(1, obtain, obtain2, 0) && a.m1() != null) {
                        return a.m1().U(kVar, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4273a;
            }

            @Override // androidx.room.l
            public void g2(int i10, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    if (!this.f4273a.transact(3, obtain, null, 1) && a.m1() != null) {
                        a.m1().g2(i10, strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static l c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                return new C0046a(iBinder);
            }
            return (l) queryLocalInterface;
        }

        public static l m1() {
            return C0046a.f4272b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int U = U(k.a.c(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(U);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                p2(k.a.c(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                g2(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
        }
    }

    int U(k kVar, String str) throws RemoteException;

    void g2(int i10, String[] strArr) throws RemoteException;

    void p2(k kVar, int i10) throws RemoteException;
}
