package m9;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
/* compiled from: IFileDownloadIPCCallback.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IFileDownloadIPCCallback.java */
    /* renamed from: m9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0397a extends Binder implements a {

        /* compiled from: IFileDownloadIPCCallback.java */
        /* renamed from: m9.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0398a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30613a;

            C0398a(IBinder iBinder) {
                this.f30613a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30613a;
            }

            @Override // m9.a
            public void e1(MessageSnapshot messageSnapshot) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f30613a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0397a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0398a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                e1(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCCallback");
                return true;
            }
        }
    }

    void e1(MessageSnapshot messageSnapshot) throws RemoteException;
}
