package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o5.a;
/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private DataSource A;
    private r4.d<?> B;
    private volatile com.bumptech.glide.load.engine.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d  reason: collision with root package name */
    private final e f7912d;

    /* renamed from: e  reason: collision with root package name */
    private final j0.e<h<?>> f7913e;

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.e f7916h;

    /* renamed from: i  reason: collision with root package name */
    private q4.b f7917i;

    /* renamed from: j  reason: collision with root package name */
    private Priority f7918j;

    /* renamed from: k  reason: collision with root package name */
    private m f7919k;

    /* renamed from: l  reason: collision with root package name */
    private int f7920l;

    /* renamed from: m  reason: collision with root package name */
    private int f7921m;

    /* renamed from: n  reason: collision with root package name */
    private t4.a f7922n;

    /* renamed from: o  reason: collision with root package name */
    private q4.e f7923o;

    /* renamed from: p  reason: collision with root package name */
    private b<R> f7924p;

    /* renamed from: q  reason: collision with root package name */
    private int f7925q;

    /* renamed from: r  reason: collision with root package name */
    private EnumC0095h f7926r;

    /* renamed from: s  reason: collision with root package name */
    private g f7927s;

    /* renamed from: t  reason: collision with root package name */
    private long f7928t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7929u;

    /* renamed from: v  reason: collision with root package name */
    private Object f7930v;

    /* renamed from: w  reason: collision with root package name */
    private Thread f7931w;

    /* renamed from: x  reason: collision with root package name */
    private q4.b f7932x;

    /* renamed from: y  reason: collision with root package name */
    private q4.b f7933y;

    /* renamed from: z  reason: collision with root package name */
    private Object f7934z;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.g<R> f7909a = new com.bumptech.glide.load.engine.g<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f7910b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final o5.c f7911c = o5.c.a();

    /* renamed from: f  reason: collision with root package name */
    private final d<?> f7914f = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final f f7915g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7935a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7936b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f7937c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f7937c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7937c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0095h.values().length];
            f7936b = iArr2;
            try {
                iArr2[EnumC0095h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7936b[EnumC0095h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7936b[EnumC0095h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7936b[EnumC0095h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7936b[EnumC0095h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f7935a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7935a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7935a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface b<R> {
        void a(GlideException glideException);

        void c(t4.c<R> cVar, DataSource dataSource);

        void d(h<?> hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public final class c<Z> implements i.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f7938a;

        c(DataSource dataSource) {
            this.f7938a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        public t4.c<Z> a(t4.c<Z> cVar) {
            return h.this.A(this.f7938a, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private q4.b f7940a;

        /* renamed from: b  reason: collision with root package name */
        private q4.f<Z> f7941b;

        /* renamed from: c  reason: collision with root package name */
        private r<Z> f7942c;

        d() {
        }

        void a() {
            this.f7940a = null;
            this.f7941b = null;
            this.f7942c = null;
        }

        void b(e eVar, q4.e eVar2) {
            o5.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f7940a, new com.bumptech.glide.load.engine.e(this.f7941b, this.f7942c, eVar2));
            } finally {
                this.f7942c.h();
                o5.b.d();
            }
        }

        boolean c() {
            return this.f7942c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(q4.b bVar, q4.f<X> fVar, r<X> rVar) {
            this.f7940a = bVar;
            this.f7941b = fVar;
            this.f7942c = rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface e {
        v4.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f7943a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7944b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7945c;

        f() {
        }

        private boolean a(boolean z10) {
            return (this.f7945c || z10 || this.f7944b) && this.f7943a;
        }

        synchronized boolean b() {
            this.f7944b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f7945c = true;
            return a(false);
        }

        synchronized boolean d(boolean z10) {
            this.f7943a = true;
            return a(z10);
        }

        synchronized void e() {
            this.f7944b = false;
            this.f7943a = false;
            this.f7945c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.load.engine.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0095h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, j0.e<h<?>> eVar2) {
        this.f7912d = eVar;
        this.f7913e = eVar2;
    }

    private void C() {
        this.f7915g.e();
        this.f7914f.a();
        this.f7909a.a();
        this.D = false;
        this.f7916h = null;
        this.f7917i = null;
        this.f7923o = null;
        this.f7918j = null;
        this.f7919k = null;
        this.f7924p = null;
        this.f7926r = null;
        this.C = null;
        this.f7931w = null;
        this.f7932x = null;
        this.f7934z = null;
        this.A = null;
        this.B = null;
        this.f7928t = 0L;
        this.E = false;
        this.f7930v = null;
        this.f7910b.clear();
        this.f7913e.a(this);
    }

    private void D() {
        this.f7931w = Thread.currentThread();
        this.f7928t = n5.f.b();
        boolean z10 = false;
        while (!this.E && this.C != null && !(z10 = this.C.b())) {
            this.f7926r = k(this.f7926r);
            this.C = j();
            if (this.f7926r == EnumC0095h.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f7926r == EnumC0095h.FINISHED || this.E) && !z10) {
            x();
        }
    }

    private <Data, ResourceType> t4.c<R> E(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) throws GlideException {
        q4.e l10 = l(dataSource);
        r4.e<Data> l11 = this.f7916h.h().l(data);
        try {
            return qVar.a(l11, l10, this.f7920l, this.f7921m, new c(dataSource));
        } finally {
            l11.c();
        }
    }

    private void F() {
        int i10 = a.f7935a[this.f7927s.ordinal()];
        if (i10 == 1) {
            this.f7926r = k(EnumC0095h.INITIALIZE);
            this.C = j();
            D();
        } else if (i10 == 2) {
            D();
        } else if (i10 == 3) {
            i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f7927s);
        }
    }

    private void G() {
        Throwable th2;
        this.f7911c.c();
        if (this.D) {
            if (this.f7910b.isEmpty()) {
                th2 = null;
            } else {
                List<Throwable> list = this.f7910b;
                th2 = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th2);
        }
        this.D = true;
    }

    private <Data> t4.c<R> g(r4.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long b10 = n5.f.b();
            t4.c<R> h10 = h(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                q("Decoded result " + h10, b10);
            }
            return h10;
        } finally {
            dVar.c();
        }
    }

    private <Data> t4.c<R> h(Data data, DataSource dataSource) throws GlideException {
        return E(data, dataSource, (q<Data, ?, R>) this.f7909a.h(data.getClass()));
    }

    private void i() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j10 = this.f7928t;
            u("Retrieved data", j10, "data: " + this.f7934z + ", cache key: " + this.f7932x + ", fetcher: " + this.B);
        }
        t4.c<R> cVar = null;
        try {
            cVar = g(this.B, this.f7934z, this.A);
        } catch (GlideException e10) {
            e10.h(this.f7933y, this.A);
            this.f7910b.add(e10);
        }
        if (cVar != null) {
            w(cVar, this.A);
        } else {
            D();
        }
    }

    private com.bumptech.glide.load.engine.f j() {
        int i10 = a.f7936b[this.f7926r.ordinal()];
        if (i10 == 1) {
            return new s(this.f7909a, this);
        }
        if (i10 == 2) {
            return new com.bumptech.glide.load.engine.c(this.f7909a, this);
        }
        if (i10 == 3) {
            return new v(this.f7909a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f7926r);
    }

    private EnumC0095h k(EnumC0095h hVar) {
        int i10 = a.f7936b[hVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return this.f7929u ? EnumC0095h.FINISHED : EnumC0095h.SOURCE;
            }
            if (i10 == 3 || i10 == 4) {
                return EnumC0095h.FINISHED;
            }
            if (i10 != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + hVar);
            } else if (this.f7922n.b()) {
                return EnumC0095h.RESOURCE_CACHE;
            } else {
                return k(EnumC0095h.RESOURCE_CACHE);
            }
        } else if (this.f7922n.a()) {
            return EnumC0095h.DATA_CACHE;
        } else {
            return k(EnumC0095h.DATA_CACHE);
        }
    }

    private q4.e l(DataSource dataSource) {
        q4.e eVar = this.f7923o;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        boolean z10 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f7909a.w();
        q4.d<Boolean> dVar = com.bumptech.glide.load.resource.bitmap.f.f8083i;
        Boolean bool = (Boolean) eVar.c(dVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return eVar;
        }
        q4.e eVar2 = new q4.e();
        eVar2.d(this.f7923o);
        eVar2.e(dVar, Boolean.valueOf(z10));
        return eVar2;
    }

    private int m() {
        return this.f7918j.ordinal();
    }

    private void q(String str, long j10) {
        u(str, j10, null);
    }

    private void u(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(n5.f.a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f7919k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    private void v(t4.c<R> cVar, DataSource dataSource) {
        G();
        this.f7924p.c(cVar, dataSource);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w(t4.c<R> cVar, DataSource dataSource) {
        if (cVar instanceof t4.b) {
            ((t4.b) cVar).a();
        }
        r rVar = 0;
        if (this.f7914f.c()) {
            cVar = r.e(cVar);
            rVar = cVar;
        }
        v(cVar, dataSource);
        this.f7926r = EnumC0095h.ENCODE;
        try {
            if (this.f7914f.c()) {
                this.f7914f.b(this.f7912d, this.f7923o);
            }
            y();
        } finally {
            if (rVar != 0) {
                rVar.h();
            }
        }
    }

    private void x() {
        G();
        this.f7924p.a(new GlideException("Failed to load resource", new ArrayList(this.f7910b)));
        z();
    }

    private void y() {
        if (this.f7915g.b()) {
            C();
        }
    }

    private void z() {
        if (this.f7915g.c()) {
            C();
        }
    }

    <Z> t4.c<Z> A(DataSource dataSource, t4.c<Z> cVar) {
        q4.g<Z> gVar;
        t4.c<Z> cVar2;
        EncodeStrategy encodeStrategy;
        q4.b bVar;
        Class<?> cls = cVar.get().getClass();
        q4.f<Z> fVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            q4.g<Z> r10 = this.f7909a.r(cls);
            cVar2 = r10.a(this.f7916h, cVar, this.f7920l, this.f7921m);
            gVar = r10;
        } else {
            cVar2 = cVar;
            gVar = null;
        }
        if (!cVar.equals(cVar2)) {
            cVar.b();
        }
        if (this.f7909a.v(cVar2)) {
            fVar = this.f7909a.n(cVar2);
            encodeStrategy = fVar.a(this.f7923o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        q4.f fVar2 = fVar;
        if (!this.f7922n.d(!this.f7909a.x(this.f7932x), dataSource, encodeStrategy)) {
            return cVar2;
        }
        if (fVar2 != null) {
            int i10 = a.f7937c[encodeStrategy.ordinal()];
            if (i10 == 1) {
                bVar = new com.bumptech.glide.load.engine.d(this.f7932x, this.f7917i);
            } else if (i10 == 2) {
                bVar = new t(this.f7909a.b(), this.f7932x, this.f7917i, this.f7920l, this.f7921m, gVar, cls, this.f7923o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
            }
            r e10 = r.e(cVar2);
            this.f7914f.d(bVar, fVar2, e10);
            return e10;
        }
        throw new Registry.NoResultEncoderAvailableException(cVar2.get().getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(boolean z10) {
        if (this.f7915g.d(z10)) {
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        EnumC0095h k10 = k(EnumC0095h.INITIALIZE);
        return k10 == EnumC0095h.RESOURCE_CACHE || k10 == EnumC0095h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(q4.b bVar, Exception exc, r4.d<?> dVar, DataSource dataSource) {
        dVar.c();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.i(bVar, dataSource, dVar.a());
        this.f7910b.add(glideException);
        if (Thread.currentThread() != this.f7931w) {
            this.f7927s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f7924p.d(this);
            return;
        }
        D();
    }

    public void b() {
        this.E = true;
        com.bumptech.glide.load.engine.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        this.f7927s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f7924p.d(this);
    }

    /* renamed from: d */
    public int compareTo(h<?> hVar) {
        int m10 = m() - hVar.m();
        return m10 == 0 ? this.f7925q - hVar.f7925q : m10;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void e(q4.b bVar, Object obj, r4.d<?> dVar, DataSource dataSource, q4.b bVar2) {
        this.f7932x = bVar;
        this.f7934z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.f7933y = bVar2;
        if (Thread.currentThread() != this.f7931w) {
            this.f7927s = g.DECODE_DATA;
            this.f7924p.d(this);
            return;
        }
        o5.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            o5.b.d();
        }
    }

    @Override // o5.a.f
    public o5.c f() {
        return this.f7911c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<R> n(com.bumptech.glide.e eVar, Object obj, m mVar, q4.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, t4.a aVar, Map<Class<?>, q4.g<?>> map, boolean z10, boolean z11, boolean z12, q4.e eVar2, b<R> bVar2, int i12) {
        this.f7909a.u(eVar, obj, bVar, i10, i11, aVar, cls, cls2, priority, eVar2, map, z10, z11, this.f7912d);
        this.f7916h = eVar;
        this.f7917i = bVar;
        this.f7918j = priority;
        this.f7919k = mVar;
        this.f7920l = i10;
        this.f7921m = i11;
        this.f7922n = aVar;
        this.f7929u = z12;
        this.f7923o = eVar2;
        this.f7924p = bVar2;
        this.f7925q = i12;
        this.f7927s = g.INITIALIZE;
        this.f7930v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        o5.b.b("DecodeJob#run(model=%s)", this.f7930v);
        r4.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    x();
                    if (dVar != null) {
                        dVar.c();
                    }
                    o5.b.d();
                    return;
                }
                F();
                if (dVar != null) {
                    dVar.c();
                }
                o5.b.d();
            } catch (com.bumptech.glide.load.engine.b e10) {
                throw e10;
            }
        }
    }
}
