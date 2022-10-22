package u6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class e extends g implements d {
    public static d m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        if (queryLocalInterface instanceof d) {
            return (d) queryLocalInterface;
        }
        return new f(iBinder);
    }
}
