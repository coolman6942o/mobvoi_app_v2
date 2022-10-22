package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IMultiInstanceInvalidationCallback.java */
/* loaded from: classes.dex */
public interface k extends IInterface {

    /* compiled from: IMultiInstanceInvalidationCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements k {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IMultiInstanceInvalidationCallback.java */
        /* renamed from: androidx.room.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0045a implements k {

            /* renamed from: b  reason: collision with root package name */
            public static k f4266b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f4267a;

            C0045a(IBinder iBinder) {
                this.f4267a = iBinder;
            }

            @Override // androidx.room.k
            public void H(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    if (!this.f4267a.transact(1, obtain, null, 1) && a.m1() != null) {
                        a.m1().H(strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4267a;
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static k c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof k)) {
                return new C0045a(iBinder);
            }
            return (k) queryLocalInterface;
        }

        public static k m1() {
            return C0045a.f4266b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                H(parcel.createStringArray());
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            }
        }
    }

    void H(String[] strArr) throws RemoteException;
}
