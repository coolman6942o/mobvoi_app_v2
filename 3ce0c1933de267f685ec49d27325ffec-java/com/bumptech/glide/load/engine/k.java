package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import n5.j;
import o5.a;
/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class k<R> implements h.b<R>, a.f {

    /* renamed from: y  reason: collision with root package name */
    private static final c f7977y = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f7978a;

    /* renamed from: b  reason: collision with root package name */
    private final o5.c f7979b;

    /* renamed from: c  reason: collision with root package name */
    private final o.a f7980c;

    /* renamed from: d  reason: collision with root package name */
    private final j0.e<k<?>> f7981d;

    /* renamed from: e  reason: collision with root package name */
    private final c f7982e;

    /* renamed from: f  reason: collision with root package name */
    private final l f7983f;

    /* renamed from: g  reason: collision with root package name */
    private final w4.a f7984g;

    /* renamed from: h  reason: collision with root package name */
    private final w4.a f7985h;

    /* renamed from: i  reason: collision with root package name */
    private final w4.a f7986i;

    /* renamed from: j  reason: collision with root package name */
    private final w4.a f7987j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f7988k;

    /* renamed from: l  reason: collision with root package name */
    private q4.b f7989l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7990m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f7991n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7992o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f7993p;

    /* renamed from: q  reason: collision with root package name */
    private t4.c<?> f7994q;

    /* renamed from: r  reason: collision with root package name */
    DataSource f7995r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f7996s;

    /* renamed from: t  reason: collision with root package name */
    GlideException f7997t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7998u;

    /* renamed from: v  reason: collision with root package name */
    o<?> f7999v;

    /* renamed from: w  reason: collision with root package name */
    private h<R> f8000w;

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f8001x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final j5.d f8002a;

        a(j5.d dVar) {
            this.f8002a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f8002a.h()) {
                synchronized (k.this) {
                    if (k.this.f7978a.b(this.f8002a)) {
                        k.this.e(this.f8002a);
                    }
                    k.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final j5.d f8004a;

        b(j5.d dVar) {
            this.f8004a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f8004a.h()) {
                synchronized (k.this) {
                    if (k.this.f7978a.b(this.f8004a)) {
                        k.this.f7999v.a();
                        k.this.g(this.f8004a);
                        k.this.r(this.f8004a);
                    }
                    k.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        public <R> o<R> a(t4.c<R> cVar, boolean z10, q4.b bVar, o.a aVar) {
            return new o<>(cVar, z10, true, bVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final j5.d f8006a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f8007b;

        d(j5.d dVar, Executor executor) {
            this.f8006a = dVar;
            this.f8007b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f8006a.equals(((d) obj).f8006a);
            }
            return false;
        }

        public int hashCode() {
            return this.f8006a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f8008a;

        e() {
            this(new ArrayList(2));
        }

        private static d d(j5.d dVar) {
            return new d(dVar, n5.e.a());
        }

        void a(j5.d dVar, Executor executor) {
            this.f8008a.add(new d(dVar, executor));
        }

        boolean b(j5.d dVar) {
            return this.f8008a.contains(d(dVar));
        }

        e c() {
            return new e(new ArrayList(this.f8008a));
        }

        void clear() {
            this.f8008a.clear();
        }

        void e(j5.d dVar) {
            this.f8008a.remove(d(dVar));
        }

        boolean isEmpty() {
            return this.f8008a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f8008a.iterator();
        }

        int size() {
            return this.f8008a.size();
        }

        e(List<d> list) {
            this.f8008a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(w4.a aVar, w4.a aVar2, w4.a aVar3, w4.a aVar4, l lVar, o.a aVar5, j0.e<k<?>> eVar) {
        this(aVar, aVar2, aVar3, aVar4, lVar, aVar5, eVar, f7977y);
    }

    private w4.a j() {
        if (this.f7991n) {
            return this.f7986i;
        }
        return this.f7992o ? this.f7987j : this.f7985h;
    }

    private boolean m() {
        return this.f7998u || this.f7996s || this.f8001x;
    }

    private synchronized void q() {
        if (this.f7989l != null) {
            this.f7978a.clear();
            this.f7989l = null;
            this.f7999v = null;
            this.f7994q = null;
            this.f7998u = false;
            this.f8001x = false;
            this.f7996s = false;
            this.f8000w.B(false);
            this.f8000w = null;
            this.f7997t = null;
            this.f7995r = null;
            this.f7981d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.f7997t = glideException;
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(j5.d dVar, Executor executor) {
        this.f7979b.c();
        this.f7978a.a(dVar, executor);
        boolean z10 = true;
        if (this.f7996s) {
            k(1);
            executor.execute(new b(dVar));
        } else if (this.f7998u) {
            k(1);
            executor.execute(new a(dVar));
        } else {
            if (this.f8001x) {
                z10 = false;
            }
            j.a(z10, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void c(t4.c<R> cVar, DataSource dataSource) {
        synchronized (this) {
            this.f7994q = cVar;
            this.f7995r = dataSource;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void d(h<?> hVar) {
        j().execute(hVar);
    }

    void e(j5.d dVar) {
        try {
            dVar.a(this.f7997t);
        } catch (Throwable th2) {
            throw new com.bumptech.glide.load.engine.b(th2);
        }
    }

    @Override // o5.a.f
    public o5.c f() {
        return this.f7979b;
    }

    void g(j5.d dVar) {
        try {
            dVar.c(this.f7999v, this.f7995r);
        } catch (Throwable th2) {
            throw new com.bumptech.glide.load.engine.b(th2);
        }
    }

    void h() {
        if (!m()) {
            this.f8001x = true;
            this.f8000w.b();
            this.f7983f.c(this, this.f7989l);
        }
    }

    void i() {
        o<?> oVar;
        synchronized (this) {
            this.f7979b.c();
            j.a(m(), "Not yet complete!");
            int decrementAndGet = this.f7988k.decrementAndGet();
            j.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                oVar = this.f7999v;
                q();
            } else {
                oVar = null;
            }
        }
        if (oVar != null) {
            oVar.g();
        }
    }

    synchronized void k(int i10) {
        o<?> oVar;
        j.a(m(), "Not yet complete!");
        if (this.f7988k.getAndAdd(i10) == 0 && (oVar = this.f7999v) != null) {
            oVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized k<R> l(q4.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f7989l = bVar;
        this.f7990m = z10;
        this.f7991n = z11;
        this.f7992o = z12;
        this.f7993p = z13;
        return this;
    }

    void n() {
        synchronized (this) {
            this.f7979b.c();
            if (this.f8001x) {
                q();
            } else if (this.f7978a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!this.f7998u) {
                this.f7998u = true;
                q4.b bVar = this.f7989l;
                e c10 = this.f7978a.c();
                k(c10.size() + 1);
                this.f7983f.b(this, bVar, null);
                Iterator<d> it = c10.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f8007b.execute(new a(next.f8006a));
                }
                i();
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
    }

    void o() {
        synchronized (this) {
            this.f7979b.c();
            if (this.f8001x) {
                this.f7994q.b();
                q();
            } else if (this.f7978a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else if (!this.f7996s) {
                this.f7999v = this.f7982e.a(this.f7994q, this.f7990m, this.f7989l, this.f7980c);
                this.f7996s = true;
                e c10 = this.f7978a.c();
                k(c10.size() + 1);
                this.f7983f.b(this, this.f7989l, this.f7999v);
                Iterator<d> it = c10.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f8007b.execute(new b(next.f8006a));
                }
                i();
            } else {
                throw new IllegalStateException("Already have resource");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f7993p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(j5.d dVar) {
        boolean z10;
        this.f7979b.c();
        this.f7978a.e(dVar);
        if (this.f7978a.isEmpty()) {
            h();
            if (!this.f7996s && !this.f7998u) {
                z10 = false;
                if (z10 && this.f7988k.get() == 0) {
                    q();
                }
            }
            z10 = true;
            if (z10) {
                q();
            }
        }
    }

    public synchronized void s(h<R> hVar) {
        this.f8000w = hVar;
        (hVar.H() ? this.f7984g : j()).execute(hVar);
    }

    k(w4.a aVar, w4.a aVar2, w4.a aVar3, w4.a aVar4, l lVar, o.a aVar5, j0.e<k<?>> eVar, c cVar) {
        this.f7978a = new e();
        this.f7979b = o5.c.a();
        this.f7988k = new AtomicInteger();
        this.f7984g = aVar;
        this.f7985h = aVar2;
        this.f7986i = aVar3;
        this.f7987j = aVar4;
        this.f7983f = lVar;
        this.f7980c = aVar5;
        this.f7981d = eVar;
        this.f7982e = cVar;
    }
}
