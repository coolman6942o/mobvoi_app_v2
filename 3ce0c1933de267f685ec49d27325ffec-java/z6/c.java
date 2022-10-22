package z6;

import android.os.RemoteException;
import b6.i;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import u6.l;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final l f37292a;

    public c(l lVar) {
        this.f37292a = (l) i.k(lVar);
    }

    public final void a() {
        try {
            this.f37292a.remove();
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void b(LatLng latLng) {
        if (latLng != null) {
            try {
                this.f37292a.F(latLng);
            } catch (RemoteException e10) {
                throw new RuntimeRemoteException(e10);
            }
        } else {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        try {
            return this.f37292a.W1(((c) obj).f37292a);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final int hashCode() {
        try {
            return this.f37292a.n();
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }
}
