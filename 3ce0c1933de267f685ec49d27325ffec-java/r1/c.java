package r1;

import androidx.lifecycle.w;
import androidx.work.m;
/* compiled from: OperationImpl.java */
/* loaded from: classes.dex */
public class c implements m {

    /* renamed from: c  reason: collision with root package name */
    private final w<m.b> f33287c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.utils.futures.c<m.b.c> f33288d = androidx.work.impl.utils.futures.c.t();

    public c() {
        a(m.f4894b);
    }

    public void a(m.b bVar) {
        this.f33287c.m(bVar);
        if (bVar instanceof m.b.c) {
            this.f33288d.p((m.b.c) bVar);
        } else if (bVar instanceof m.b.a) {
            this.f33288d.q(((m.b.a) bVar).a());
        }
    }
}
