package s6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f34325a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34326b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f34325a = iBinder;
        this.f34326b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U1(int i10, Parcel parcel) throws RemoteException {
        try {
            this.f34325a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f34325a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel m1() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f34326b);
        return obtain;
    }
}
