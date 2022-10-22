package z6;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import u6.i;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static i f37291a;

    public static a a(Bitmap bitmap) {
        try {
            return new a(c().z0(bitmap));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public static void b(i iVar) {
        if (f37291a == null) {
            f37291a = (i) b6.i.k(iVar);
        }
    }

    private static i c() {
        return (i) b6.i.l(f37291a, "IBitmapDescriptorFactory is not initialized");
    }
}
