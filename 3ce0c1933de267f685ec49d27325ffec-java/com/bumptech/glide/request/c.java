package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.j;
import j5.b;
import j5.d;
import java.util.List;
import java.util.concurrent.Executor;
import k5.h;
import k5.i;
import n5.f;
import n5.k;
/* compiled from: SingleRequest.java */
/* loaded from: classes.dex */
public final class c<R> implements j5.a, h, d {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;

    /* renamed from: a  reason: collision with root package name */
    private final String f8163a;

    /* renamed from: b  reason: collision with root package name */
    private final o5.c f8164b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f8165c;

    /* renamed from: d  reason: collision with root package name */
    private final b<R> f8166d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f8167e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f8168f;

    /* renamed from: g  reason: collision with root package name */
    private final e f8169g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f8170h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f8171i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bumptech.glide.request.a<?> f8172j;

    /* renamed from: k  reason: collision with root package name */
    private final int f8173k;

    /* renamed from: l  reason: collision with root package name */
    private final int f8174l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f8175m;

    /* renamed from: n  reason: collision with root package name */
    private final i<R> f8176n;

    /* renamed from: o  reason: collision with root package name */
    private final List<b<R>> f8177o;

    /* renamed from: p  reason: collision with root package name */
    private final l5.c<? super R> f8178p;

    /* renamed from: q  reason: collision with root package name */
    private final Executor f8179q;

    /* renamed from: r  reason: collision with root package name */
    private t4.c<R> f8180r;

    /* renamed from: s  reason: collision with root package name */
    private j.d f8181s;

    /* renamed from: t  reason: collision with root package name */
    private long f8182t;

    /* renamed from: u  reason: collision with root package name */
    private volatile j f8183u;

    /* renamed from: v  reason: collision with root package name */
    private a f8184v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f8185w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f8186x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f8187y;

    /* renamed from: z  reason: collision with root package name */
    private int f8188z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleRequest.java */
    /* loaded from: classes.dex */
    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private c(Context context, e eVar, Object obj, Object obj2, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i10, int i11, Priority priority, i<R> iVar, b<R> bVar, List<b<R>> list, RequestCoordinator requestCoordinator, j jVar, l5.c<? super R> cVar, Executor executor) {
        this.f8163a = D ? String.valueOf(super.hashCode()) : null;
        this.f8164b = o5.c.a();
        this.f8165c = obj;
        this.f8168f = context;
        this.f8169g = eVar;
        this.f8170h = obj2;
        this.f8171i = cls;
        this.f8172j = aVar;
        this.f8173k = i10;
        this.f8174l = i11;
        this.f8175m = priority;
        this.f8176n = iVar;
        this.f8166d = bVar;
        this.f8177o = list;
        this.f8167e = requestCoordinator;
        this.f8183u = jVar;
        this.f8178p = cVar;
        this.f8179q = executor;
        this.f8184v = a.PENDING;
        if (this.C == null && eVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void A() {
        if (l()) {
            Drawable drawable = null;
            if (this.f8170h == null) {
                drawable = p();
            }
            if (drawable == null) {
                drawable = o();
            }
            if (drawable == null) {
                drawable = q();
            }
            this.f8176n.c(drawable);
        }
    }

    private void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean j() {
        RequestCoordinator requestCoordinator = this.f8167e;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f8167e;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f8167e;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    private void n() {
        i();
        this.f8164b.c();
        this.f8176n.b(this);
        j.d dVar = this.f8181s;
        if (dVar != null) {
            dVar.a();
            this.f8181s = null;
        }
    }

    private Drawable o() {
        if (this.f8185w == null) {
            Drawable n10 = this.f8172j.n();
            this.f8185w = n10;
            if (n10 == null && this.f8172j.m() > 0) {
                this.f8185w = s(this.f8172j.m());
            }
        }
        return this.f8185w;
    }

    private Drawable p() {
        if (this.f8187y == null) {
            Drawable o10 = this.f8172j.o();
            this.f8187y = o10;
            if (o10 == null && this.f8172j.p() > 0) {
                this.f8187y = s(this.f8172j.p());
            }
        }
        return this.f8187y;
    }

    private Drawable q() {
        if (this.f8186x == null) {
            Drawable u10 = this.f8172j.u();
            this.f8186x = u10;
            if (u10 == null && this.f8172j.v() > 0) {
                this.f8186x = s(this.f8172j.v());
            }
        }
        return this.f8186x;
    }

    private boolean r() {
        RequestCoordinator requestCoordinator = this.f8167e;
        return requestCoordinator == null || !requestCoordinator.c();
    }

    private Drawable s(int i10) {
        return c5.a.a(this.f8169g, i10, this.f8172j.A() != null ? this.f8172j.A() : this.f8168f.getTheme());
    }

    private void t(String str) {
        Log.v("Request", str + " this: " + this.f8163a);
    }

    private static int u(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    private void v() {
        RequestCoordinator requestCoordinator = this.f8167e;
        if (requestCoordinator != null) {
            requestCoordinator.j(this);
        }
    }

    private void w() {
        RequestCoordinator requestCoordinator = this.f8167e;
        if (requestCoordinator != null) {
            requestCoordinator.a(this);
        }
    }

    public static <R> c<R> x(Context context, e eVar, Object obj, Object obj2, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i10, int i11, Priority priority, i<R> iVar, b<R> bVar, List<b<R>> list, RequestCoordinator requestCoordinator, j jVar, l5.c<? super R> cVar, Executor executor) {
        return new c<>(context, eVar, obj, obj2, cls, aVar, i10, i11, priority, iVar, bVar, list, requestCoordinator, jVar, cVar, executor);
    }

    private void y(GlideException glideException, int i10) {
        boolean z10;
        this.f8164b.c();
        synchronized (this.f8165c) {
            glideException.setOrigin(this.C);
            int g10 = this.f8169g.g();
            if (g10 <= i10) {
                Log.w("Glide", "Load failed for " + this.f8170h + " with size [" + this.f8188z + "x" + this.A + "]", glideException);
                if (g10 <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.f8181s = null;
            this.f8184v = a.FAILED;
            boolean z11 = true;
            this.B = true;
            List<b<R>> list = this.f8177o;
            if (list != null) {
                z10 = false;
                for (b<R> bVar : list) {
                    z10 |= bVar.a(glideException, this.f8170h, this.f8176n, r());
                }
            } else {
                z10 = false;
            }
            b<R> bVar2 = this.f8166d;
            if (bVar2 == null || !bVar2.a(glideException, this.f8170h, this.f8176n, r())) {
                z11 = false;
            }
            if (!z10 && !z11) {
                A();
            }
            this.B = false;
            v();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void z(t4.c<R> cVar, R r10, DataSource dataSource) {
        boolean z10;
        boolean r11 = r();
        this.f8184v = a.COMPLETE;
        this.f8180r = cVar;
        if (this.f8169g.g() <= 3) {
            Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + dataSource + " for " + this.f8170h + " with size [" + this.f8188z + "x" + this.A + "] in " + f.a(this.f8182t) + " ms");
        }
        boolean z11 = true;
        this.B = true;
        try {
            List<b<R>> list = this.f8177o;
            if (list != null) {
                z10 = false;
                for (b<R> bVar : list) {
                    z10 |= bVar.b(r10, this.f8170h, this.f8176n, dataSource, r11);
                }
            } else {
                z10 = false;
            }
            b<R> bVar2 = this.f8166d;
            if (bVar2 == null || !bVar2.b(r10, this.f8170h, this.f8176n, dataSource, r11)) {
                z11 = false;
            }
            if (!z11 && !z10) {
                this.f8176n.a(r10, this.f8178p.a(dataSource, r11));
            }
            this.B = false;
            w();
        } catch (Throwable th2) {
            this.B = false;
            throw th2;
        }
    }

    @Override // j5.d
    public void a(GlideException glideException) {
        y(glideException, 5);
    }

    @Override // j5.a
    public void b() {
        synchronized (this.f8165c) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j5.d
    public void c(t4.c<?> cVar, DataSource dataSource) {
        Throwable th2;
        this.f8164b.c();
        t4.c<?> cVar2 = null;
        try {
            try {
                synchronized (this.f8165c) {
                    this.f8181s = null;
                    if (cVar == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f8171i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = cVar.get();
                    try {
                        if (obj != null && this.f8171i.isAssignableFrom(obj.getClass())) {
                            if (!m()) {
                                this.f8180r = null;
                                this.f8184v = a.COMPLETE;
                                this.f8183u.k(cVar);
                                return;
                            }
                            z(cVar, obj, dataSource);
                            return;
                        }
                        this.f8180r = null;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected to receive an object of ");
                        sb2.append(this.f8171i);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : "");
                        sb2.append("{");
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append(cVar);
                        sb2.append("}.");
                        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new GlideException(sb2.toString()));
                        this.f8183u.k(cVar);
                    } catch (Throwable th3) {
                        th2 = th3;
                        cVar2 = cVar;
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
        } catch (Throwable th5) {
            if (cVar2 != null) {
                this.f8183u.k(cVar2);
            }
            throw th5;
        }
    }

    @Override // j5.a
    public void clear() {
        synchronized (this.f8165c) {
            i();
            this.f8164b.c();
            a aVar = this.f8184v;
            a aVar2 = a.CLEARED;
            if (aVar != aVar2) {
                n();
                t4.c<R> cVar = this.f8180r;
                if (cVar != null) {
                    this.f8180r = null;
                } else {
                    cVar = null;
                }
                if (j()) {
                    this.f8176n.g(q());
                }
                this.f8184v = aVar2;
                if (cVar != null) {
                    this.f8183u.k(cVar);
                }
            }
        }
    }

    @Override // j5.a
    public boolean d() {
        boolean z10;
        synchronized (this.f8165c) {
            z10 = this.f8184v == a.CLEARED;
        }
        return z10;
    }

    @Override // j5.a
    public void e() {
        synchronized (this.f8165c) {
            i();
            this.f8164b.c();
            this.f8182t = f.b();
            if (this.f8170h == null) {
                if (k.s(this.f8173k, this.f8174l)) {
                    this.f8188z = this.f8173k;
                    this.A = this.f8174l;
                }
                y(new GlideException("Received null model"), p() == null ? 5 : 3);
                return;
            }
            a aVar = this.f8184v;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            } else if (aVar == a.COMPLETE) {
                c(this.f8180r, DataSource.MEMORY_CACHE);
            } else {
                a aVar3 = a.WAITING_FOR_SIZE;
                this.f8184v = aVar3;
                if (k.s(this.f8173k, this.f8174l)) {
                    g(this.f8173k, this.f8174l);
                } else {
                    this.f8176n.h(this);
                }
                a aVar4 = this.f8184v;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && l()) {
                    this.f8176n.e(q());
                }
                if (D) {
                    t("finished run method in " + f.a(this.f8182t));
                }
            }
        }
    }

    @Override // j5.a
    public boolean f(j5.a aVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        com.bumptech.glide.request.a<?> aVar2;
        Priority priority;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        com.bumptech.glide.request.a<?> aVar3;
        Priority priority2;
        int size2;
        if (!(aVar instanceof c)) {
            return false;
        }
        synchronized (this.f8165c) {
            i10 = this.f8173k;
            i11 = this.f8174l;
            obj = this.f8170h;
            cls = this.f8171i;
            aVar2 = this.f8172j;
            priority = this.f8175m;
            List<b<R>> list = this.f8177o;
            size = list != null ? list.size() : 0;
        }
        c cVar = (c) aVar;
        synchronized (cVar.f8165c) {
            i12 = cVar.f8173k;
            i13 = cVar.f8174l;
            obj2 = cVar.f8170h;
            cls2 = cVar.f8171i;
            aVar3 = cVar.f8172j;
            priority2 = cVar.f8175m;
            List<b<R>> list2 = cVar.f8177o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i10 == i12 && i11 == i13 && k.b(obj, obj2) && cls.equals(cls2) && aVar2.equals(aVar3) && priority == priority2 && size == size2;
    }

    @Override // k5.h
    public void g(int i10, int i11) {
        Object obj;
        this.f8164b.c();
        Object obj2 = this.f8165c;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = D;
                    if (z10) {
                        t("Got onSizeReady in " + f.a(this.f8182t));
                    }
                    if (this.f8184v == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.f8184v = aVar;
                        float z11 = this.f8172j.z();
                        this.f8188z = u(i10, z11);
                        this.A = u(i11, z11);
                        if (z10) {
                            t("finished setup for calling load in " + f.a(this.f8182t));
                        }
                        obj = obj2;
                        try {
                            this.f8181s = this.f8183u.f(this.f8169g, this.f8170h, this.f8172j.y(), this.f8188z, this.A, this.f8172j.x(), this.f8171i, this.f8175m, this.f8172j.l(), this.f8172j.B(), this.f8172j.K(), this.f8172j.G(), this.f8172j.r(), this.f8172j.E(), this.f8172j.D(), this.f8172j.C(), this.f8172j.q(), this, this.f8179q);
                            if (this.f8184v != aVar) {
                                this.f8181s = null;
                            }
                            if (z10) {
                                t("finished onSizeReady in " + f.a(this.f8182t));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
            }
        }
    }

    @Override // j5.d
    public Object h() {
        this.f8164b.c();
        return this.f8165c;
    }

    @Override // j5.a
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f8165c) {
            a aVar = this.f8184v;
            if (!(aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    @Override // j5.a
    public boolean k() {
        boolean z10;
        synchronized (this.f8165c) {
            z10 = this.f8184v == a.COMPLETE;
        }
        return z10;
    }
}
