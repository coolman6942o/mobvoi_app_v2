package nh;

import android.util.SparseArray;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import nf.c;
import nf.k;
/* compiled from: HealthObservable.java */
/* loaded from: classes2.dex */
public class a extends c<SparseArray<oh.a>> {

    /* renamed from: e  reason: collision with root package name */
    private final Map<k<SparseArray<oh.a>>, b> f31249e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Set<k<SparseArray<oh.a>>> f31250f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private b f31251g = new b();

    private static b j(long j10) {
        long b10 = eg.c.b(j10);
        return new b(b10, (eg.c.f26040a * 1000) + b10);
    }

    private static b k(Collection<b> collection) {
        long j10 = -1;
        long j11 = -1;
        for (b bVar : collection) {
            if (!bVar.b()) {
                if (j10 == -1 || bVar.f31252a < j10) {
                    j10 = bVar.f31252a;
                }
                if (j11 == -1 || bVar.f31253b > j11) {
                    j11 = bVar.f31253b;
                }
            }
        }
        return new b(j10, j11);
    }

    @Override // nf.c, nf.h
    public void a(k<SparseArray<oh.a>> kVar) {
        super.a(kVar);
        this.f31249e.put(kVar, new b());
    }

    @Override // nf.h
    public void c(k<SparseArray<oh.a>> kVar) {
        super.c(kVar);
        this.f31249e.remove(kVar);
        this.f31250f.remove(kVar);
    }

    @Override // nf.h
    public void d() {
        super.d();
        this.f31249e.clear();
        this.f31250f.clear();
    }

    public b h() {
        return k(this.f31249e.values());
    }

    long i() {
        return System.currentTimeMillis();
    }

    public boolean l() {
        if (this.f31251g.b()) {
            return false;
        }
        long i10 = i();
        if (eg.c.l(this.f31251g.f31252a, i10)) {
            return false;
        }
        this.f31251g = j(i10);
        for (k<SparseArray<oh.a>> kVar : this.f31250f) {
            this.f31249e.put(kVar, this.f31251g);
        }
        return true;
    }

    public void m(k<SparseArray<oh.a>> kVar, b bVar) {
        if (this.f31249e.containsKey(kVar)) {
            this.f31249e.put(kVar, bVar);
        } else {
            com.mobvoi.android.common.utils.k.s("health.data.storage", "observer %s not registered, can not set range %s.", kVar, bVar);
        }
    }

    public void n(k<SparseArray<oh.a>> kVar) {
        if (this.f31249e.containsKey(kVar)) {
            if (this.f31250f.isEmpty()) {
                this.f31251g = j(i());
            }
            this.f31250f.add(kVar);
            this.f31249e.put(kVar, this.f31251g);
            return;
        }
        com.mobvoi.android.common.utils.k.s("health.data.storage", "observer %s not registered, can not set range for today.", kVar);
    }
}
