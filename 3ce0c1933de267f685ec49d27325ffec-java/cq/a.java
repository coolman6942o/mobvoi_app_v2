package cq;

import bq.c;
import bq.g;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.internal.schedulers.h;
/* compiled from: Schedulers.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<a> f24707d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private final f f24708a;

    /* renamed from: b  reason: collision with root package name */
    private final f f24709b;

    /* renamed from: c  reason: collision with root package name */
    private final f f24710c;

    private a() {
        g f10 = bq.f.c().f();
        f g10 = f10.g();
        if (g10 != null) {
            this.f24708a = g10;
        } else {
            this.f24708a = g.a();
        }
        f i10 = f10.i();
        if (i10 != null) {
            this.f24709b = i10;
        } else {
            this.f24709b = g.c();
        }
        f j10 = f10.j();
        if (j10 != null) {
            this.f24710c = j10;
        } else {
            this.f24710c = g.e();
        }
    }

    public static f a() {
        return c.e(b().f24708a);
    }

    private static a b() {
        while (true) {
            AtomicReference<a> atomicReference = f24707d;
            a aVar = atomicReference.get();
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            if (atomicReference.compareAndSet(null, aVar2)) {
                return aVar2;
            }
            aVar2.e();
        }
    }

    public static f c() {
        return c.j(b().f24709b);
    }

    public static f d() {
        return c.k(b().f24710c);
    }

    public static f f() {
        return h.f34068a;
    }

    synchronized void e() {
        f fVar = this.f24708a;
        if (fVar instanceof rx.internal.schedulers.f) {
            ((rx.internal.schedulers.f) fVar).shutdown();
        }
        f fVar2 = this.f24709b;
        if (fVar2 instanceof rx.internal.schedulers.f) {
            ((rx.internal.schedulers.f) fVar2).shutdown();
        }
        f fVar3 = this.f24710c;
        if (fVar3 instanceof rx.internal.schedulers.f) {
            ((rx.internal.schedulers.f) fVar3).shutdown();
        }
    }
}
