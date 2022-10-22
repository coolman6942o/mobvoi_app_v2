package d6;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
/* loaded from: classes.dex */
final class g extends b {

    /* renamed from: a  reason: collision with root package name */
    private final d<Status> f25138a;

    public g(d<Status> dVar) {
        this.f25138a = dVar;
    }

    @Override // d6.k
    public final void d0(int i10) throws RemoteException {
        this.f25138a.a(new Status(i10));
    }
}
