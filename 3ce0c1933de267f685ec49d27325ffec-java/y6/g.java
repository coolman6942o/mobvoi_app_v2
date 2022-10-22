package y6;

import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class g extends u6.g implements f {
    public g() {
        super("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    }

    @Override // u6.g
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        q();
        parcel2.writeNoException();
        return true;
    }
}
