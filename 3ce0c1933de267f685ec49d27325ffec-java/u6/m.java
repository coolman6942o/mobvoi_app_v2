package u6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class m extends g implements l {
    public static l m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (queryLocalInterface instanceof l) {
            return (l) queryLocalInterface;
        }
        return new n(iBinder);
    }
}
