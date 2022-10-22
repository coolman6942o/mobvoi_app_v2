package m9;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import m9.a;
/* compiled from: IFileDownloadIPCService.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: IFileDownloadIPCService.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* compiled from: IFileDownloadIPCService.java */
        /* renamed from: m9.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0399a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f30614a;

            C0399a(IBinder iBinder) {
                this.f30614a = iBinder;
            }

            @Override // m9.b
            public void O1(m9.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30614a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30614a;
            }

            @Override // m9.b
            public void s0(m9.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f30614a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        public static b A2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0399a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                Notification notification = null;
                boolean z10 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        s0(a.AbstractBinderC0397a.c(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        O1(a.AbstractBinderC0397a.c(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean k02 = k0(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(k02 ? 1 : 0);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        k(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? FileDownloadHeader.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean N = N(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(N ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        u2();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean o02 = o0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(o02 ? 1 : 0);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        long F1 = F1(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(F1);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        long Y0 = Y0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeLong(Y0);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        byte f10 = f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByte(f10);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean u12 = u1();
                        parcel2.writeNoException();
                        parcel2.writeInt(u12 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                        }
                        j2(readInt, notification);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        Z0(z10);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        boolean O0 = O0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(O0 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                        V();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                return true;
            }
        }
    }

    long F1(int i10) throws RemoteException;

    boolean N(int i10) throws RemoteException;

    boolean O0(int i10) throws RemoteException;

    void O1(m9.a aVar) throws RemoteException;

    void V() throws RemoteException;

    long Y0(int i10) throws RemoteException;

    void Z0(boolean z10) throws RemoteException;

    byte f(int i10) throws RemoteException;

    void j2(int i10, Notification notification) throws RemoteException;

    void k(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, FileDownloadHeader fileDownloadHeader, boolean z12) throws RemoteException;

    boolean k0(String str, String str2) throws RemoteException;

    boolean o0(int i10) throws RemoteException;

    void s0(m9.a aVar) throws RemoteException;

    boolean u1() throws RemoteException;

    void u2() throws RemoteException;
}
