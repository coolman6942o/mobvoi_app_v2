package z6;

import android.os.RemoteException;
import b6.i;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import u6.o;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final o f37293a;

    public d(o oVar) {
        this.f37293a = (o) i.k(oVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        try {
            return this.f37293a.g1(((d) obj).f37293a);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final int hashCode() {
        try {
            return this.f37293a.n();
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }
}
