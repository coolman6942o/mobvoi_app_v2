package s6;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class e extends b implements d {
    public static d c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
        return queryLocalInterface instanceof d ? (d) queryLocalInterface : new f(iBinder);
    }
}
