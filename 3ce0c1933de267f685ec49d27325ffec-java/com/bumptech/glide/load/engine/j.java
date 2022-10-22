package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.o;
import j0.e;
import java.util.Map;
import java.util.concurrent.Executor;
import n5.f;
import o5.a;
import q4.g;
import v4.a;
import v4.h;
/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class j implements l, h.a, o.a {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f7951i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final p f7952a;

    /* renamed from: b  reason: collision with root package name */
    private final n f7953b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7954c;

    /* renamed from: d  reason: collision with root package name */
    private final b f7955d;

    /* renamed from: e  reason: collision with root package name */
    private final u f7956e;

    /* renamed from: f  reason: collision with root package name */
    private final c f7957f;

    /* renamed from: g  reason: collision with root package name */
    private final a f7958g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a f7959h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final h.e f7960a;

        /* renamed from: b  reason: collision with root package name */
        final e<h<?>> f7961b = o5.a.d(150, new C0096a());

        /* renamed from: c  reason: collision with root package name */
        private int f7962c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0096a implements a.d<h<?>> {
            C0096a() {
            }

            /* renamed from: b */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f7960a, aVar.f7961b);
            }
        }

        a(h.e eVar) {
            this.f7960a = eVar;
        }

        <R> h<R> a(com.bumptech.glide.e eVar, Object obj, m mVar, q4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, t4.a aVar, Map<Class<?>, g<?>> map, boolean z10, boolean z11, boolean z12, q4.e eVar2, h.b<R> bVar2) {
            h hVar = (h) n5.j.d(this.f7961b.b());
            int i12 = this.f7962c;
            this.f7962c = i12 + 1;
            return hVar.n(eVar, obj, mVar, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, z12, eVar2, bVar2, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final w4.a f7964a;

        /* renamed from: b  reason: collision with root package name */
        final w4.a f7965b;

        /* renamed from: c  reason: collision with root package name */
        final w4.a f7966c;

        /* renamed from: d  reason: collision with root package name */
        final w4.a f7967d;

        /* renamed from: e  reason: collision with root package name */
        final l f7968e;

        /* renamed from: f  reason: collision with root package name */
        final o.a f7969f;

        /* renamed from: g  reason: collision with root package name */
        final e<k<?>> f7970g = o5.a.d(150, new a());

        /* compiled from: Engine.java */
        /* loaded from: classes.dex */
        class a implements a.d<k<?>> {
            a() {
            }

            /* renamed from: b */
            public k<?> a() {
                b bVar = b.this;
                return new k<>(bVar.f7964a, bVar.f7965b, bVar.f7966c, bVar.f7967d, bVar.f7968e, bVar.f7969f, bVar.f7970g);
            }
        }

        b(w4.a aVar, w4.a aVar2, w4.a aVar3, w4.a aVar4, l lVar, o.a aVar5) {
            this.f7964a = aVar;
            this.f7965b = aVar2;
            this.f7966c = aVar3;
            this.f7967d = aVar4;
            this.f7968e = lVar;
            this.f7969f = aVar5;
        }

        <R> k<R> a(q4.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((k) n5.j.d(this.f7970g.b())).l(bVar, z10, z11, z12, z13);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    private static class c implements h.e {

        /* renamed from: a  reason: collision with root package name */
        private final a.AbstractC0513a f7972a;

        /* renamed from: b  reason: collision with root package name */
        private volatile v4.a f7973b;

        c(a.AbstractC0513a aVar) {
            this.f7972a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public v4.a a() {
            if (this.f7973b == null) {
                synchronized (this) {
                    if (this.f7973b == null) {
                        this.f7973b = this.f7972a.build();
                    }
                    if (this.f7973b == null) {
                        this.f7973b = new v4.b();
                    }
                }
            }
            return this.f7973b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private final k<?> f7974a;

        /* renamed from: b  reason: collision with root package name */
        private final j5.d f7975b;

        d(j5.d dVar, k<?> kVar) {
            this.f7975b = dVar;
            this.f7974a = kVar;
        }

        public void a() {
            synchronized (j.this) {
                this.f7974a.r(this.f7975b);
            }
        }
    }

    public j(v4.h hVar, a.AbstractC0513a aVar, w4.a aVar2, w4.a aVar3, w4.a aVar4, w4.a aVar5, boolean z10) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, null, null, null, null, null, null, z10);
    }

    private o<?> e(q4.b bVar) {
        t4.c<?> c10 = this.f7954c.c(bVar);
        if (c10 == null) {
            return null;
        }
        if (c10 instanceof o) {
            return (o) c10;
        }
        return new o<>(c10, true, true, bVar, this);
    }

    private o<?> g(q4.b bVar) {
        o<?> e10 = this.f7959h.e(bVar);
        if (e10 != null) {
            e10.a();
        }
        return e10;
    }

    private o<?> h(q4.b bVar) {
        o<?> e10 = e(bVar);
        if (e10 != null) {
            e10.a();
            this.f7959h.a(bVar, e10);
        }
        return e10;
    }

    private o<?> i(m mVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        o<?> g10 = g(mVar);
        if (g10 != null) {
            if (f7951i) {
                j("Loaded resource from active resources", j10, mVar);
            }
            return g10;
        }
        o<?> h10 = h(mVar);
        if (h10 == null) {
            return null;
        }
        if (f7951i) {
            j("Loaded resource from cache", j10, mVar);
        }
        return h10;
    }

    private static void j(String str, long j10, q4.b bVar) {
        Log.v("Engine", str + " in " + f.a(j10) + "ms, key: " + bVar);
    }

    private <R> d l(com.bumptech.glide.e eVar, Object obj, q4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, t4.a aVar, Map<Class<?>, g<?>> map, boolean z10, boolean z11, q4.e eVar2, boolean z12, boolean z13, boolean z14, boolean z15, j5.d dVar, Executor executor, m mVar, long j10) {
        k<?> a10 = this.f7952a.a(mVar, z15);
        if (a10 != null) {
            a10.b(dVar, executor);
            if (f7951i) {
                j("Added to existing load", j10, mVar);
            }
            return new d(dVar, a10);
        }
        k<R> a11 = this.f7955d.a(mVar, z12, z13, z14, z15);
        h<R> a12 = this.f7958g.a(eVar, obj, mVar, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, z15, eVar2, a11);
        this.f7952a.c(mVar, a11);
        a11.b(dVar, executor);
        a11.s(a12);
        if (f7951i) {
            j("Started new load", j10, mVar);
        }
        return new d(dVar, a11);
    }

    @Override // v4.h.a
    public void a(t4.c<?> cVar) {
        this.f7956e.a(cVar);
    }

    @Override // com.bumptech.glide.load.engine.l
    public synchronized void b(k<?> kVar, q4.b bVar, o<?> oVar) {
        if (oVar != null) {
            if (oVar.f()) {
                this.f7959h.a(bVar, oVar);
            }
        }
        this.f7952a.d(bVar, kVar);
    }

    @Override // com.bumptech.glide.load.engine.l
    public synchronized void c(k<?> kVar, q4.b bVar) {
        this.f7952a.d(bVar, kVar);
    }

    @Override // com.bumptech.glide.load.engine.o.a
    public void d(q4.b bVar, o<?> oVar) {
        this.f7959h.d(bVar);
        if (oVar.f()) {
            this.f7954c.e(bVar, oVar);
        } else {
            this.f7956e.a(oVar);
        }
    }

    public <R> d f(com.bumptech.glide.e eVar, Object obj, q4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, t4.a aVar, Map<Class<?>, g<?>> map, boolean z10, boolean z11, q4.e eVar2, boolean z12, boolean z13, boolean z14, boolean z15, j5.d dVar, Executor executor) {
        long b10 = f7951i ? f.b() : 0L;
        m a10 = this.f7953b.a(obj, bVar, i10, i11, map, cls, cls2, eVar2);
        synchronized (this) {
            o<?> i12 = i(a10, z12, b10);
            if (i12 == null) {
                return l(eVar, obj, bVar, i10, i11, cls, cls2, priority, aVar, map, z10, z11, eVar2, z12, z13, z14, z15, dVar, executor, a10, b10);
            }
            dVar.c(i12, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public void k(t4.c<?> cVar) {
        if (cVar instanceof o) {
            ((o) cVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    j(v4.h hVar, a.AbstractC0513a aVar, w4.a aVar2, w4.a aVar3, w4.a aVar4, w4.a aVar5, p pVar, n nVar, com.bumptech.glide.load.engine.a aVar6, b bVar, a aVar7, u uVar, boolean z10) {
        this.f7954c = hVar;
        c cVar = new c(aVar);
        this.f7957f = cVar;
        com.bumptech.glide.load.engine.a aVar8 = aVar6 == null ? new com.bumptech.glide.load.engine.a(z10) : aVar6;
        this.f7959h = aVar8;
        aVar8.f(this);
        this.f7953b = nVar == null ? new n() : nVar;
        this.f7952a = pVar == null ? new p() : pVar;
        this.f7955d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.f7958g = aVar7 == null ? new a(cVar) : aVar7;
        this.f7956e = uVar == null ? new u() : uVar;
        hVar.d(this);
    }
}
