package z6;

import android.os.RemoteException;
import b6.i;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import u6.r;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final r f37294a;

    public e(r rVar) {
        this.f37294a = (r) i.k(rVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        try {
            return this.f37294a.h(((e) obj).f37294a);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final int hashCode() {
        try {
            return this.f37294a.n();
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }
}
