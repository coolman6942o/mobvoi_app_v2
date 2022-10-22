package x6;

import android.os.RemoteException;
import b6.i;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import y6.a;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f36460a;

    public static a a(LatLngBounds latLngBounds, int i10) {
        try {
            return new a(f().g(latLngBounds, i10));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public static a b(LatLngBounds latLngBounds, int i10, int i11, int i12) {
        try {
            return new a(f().V0(latLngBounds, i10, i11, i12));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public static a c(LatLng latLng, float f10) {
        try {
            return new a(f().b2(latLng, f10));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public static a d(float f10, float f11) {
        try {
            return new a(f().c2(f10, f11));
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public static void e(a aVar) {
        f36460a = (a) i.k(aVar);
    }

    private static a f() {
        return (a) i.l(f36460a, "CameraUpdateFactory is not initialized");
    }
}
