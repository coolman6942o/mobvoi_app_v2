package n6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f31048a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31049b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f31048a = iBinder;
        this.f31049b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel U1(int i10, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f31048a.transact(i10, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e10) {
            throw e10;
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f31048a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel m1() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f31049b);
        return obtain;
    }
}
