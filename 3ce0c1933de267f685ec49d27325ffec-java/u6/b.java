package u6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class b extends g implements r {
    public static r m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
        if (queryLocalInterface instanceof r) {
            return (r) queryLocalInterface;
        }
        return new c(iBinder);
    }
}
