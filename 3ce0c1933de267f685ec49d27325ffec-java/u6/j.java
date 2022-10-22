package u6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class j extends g implements i {
    public static i m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
        if (queryLocalInterface instanceof i) {
            return (i) queryLocalInterface;
        }
        return new k(iBinder);
    }
}
