package d6;

import android.os.Parcel;
import android.os.RemoteException;
import q6.b;
/* loaded from: classes.dex */
public abstract class l extends b implements k {
    public l() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // q6.b
    protected boolean m1(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        d0(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
