package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.j;
/* compiled from: SettableFuture.java */
/* loaded from: classes.dex */
public final class c<V> extends a<V> {
    private c() {
    }

    public static <V> c<V> t() {
        return new c<>();
    }

    @Override // androidx.work.impl.utils.futures.a
    public boolean p(V v10) {
        return super.p(v10);
    }

    @Override // androidx.work.impl.utils.futures.a
    public boolean q(Throwable th2) {
        return super.q(th2);
    }

    @Override // androidx.work.impl.utils.futures.a
    public boolean r(j<? extends V> jVar) {
        return super.r(jVar);
    }
}
