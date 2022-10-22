package y6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import u6.g;
/* loaded from: classes.dex */
public abstract class i extends g implements h {
    public i() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // u6.g
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        b bVar;
        if (i10 != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            bVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (queryLocalInterface instanceof b) {
                bVar = (b) queryLocalInterface;
            } else {
                bVar = new p(readStrongBinder);
            }
        }
        R1(bVar);
        parcel2.writeNoException();
        return true;
    }
}
