package u6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class p extends g implements o {
    public static o m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
        if (queryLocalInterface instanceof o) {
            return (o) queryLocalInterface;
        }
        return new q(iBinder);
    }
}
