package okhttp3.internal.cache;

import io.m;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.u;
import okio.h;
import okio.n;
import okio.r;
import okio.t;
import qo.l;
/* compiled from: DiskLruCache.kt */
/* loaded from: classes3.dex */
public final class d implements Closeable, Flushable {

    /* renamed from: a */
    private long f31899a;

    /* renamed from: b */
    private final File f31900b;

    /* renamed from: c */
    private final File f31901c;

    /* renamed from: d */
    private final File f31902d;

    /* renamed from: e */
    private long f31903e;

    /* renamed from: f */
    private okio.d f31904f;

    /* renamed from: h */
    private int f31906h;

    /* renamed from: i */
    private boolean f31907i;

    /* renamed from: j */
    private boolean f31908j;

    /* renamed from: k */
    private boolean f31909k;

    /* renamed from: l */
    private boolean f31910l;

    /* renamed from: m */
    private boolean f31911m;

    /* renamed from: n */
    private boolean f31912n;

    /* renamed from: o */
    private long f31913o;

    /* renamed from: p */
    private final ip.d f31914p;

    /* renamed from: r */
    private final mp.a f31916r;

    /* renamed from: s */
    private final File f31917s;

    /* renamed from: t */
    private final int f31918t;

    /* renamed from: u */
    private final int f31919u;

    /* renamed from: v */
    public static final String f31894v = "journal";

    /* renamed from: w */
    public static final String f31895w = "journal.tmp";

    /* renamed from: x */
    public static final String f31896x = "journal.bkp";

    /* renamed from: y */
    public static final String f31897y = "libcore.io.DiskLruCache";

    /* renamed from: z */
    public static final String f31898z = "1";
    public static final long A = -1;
    public static final Regex B = new Regex("[a-z0-9_-]{1,120}");
    public static final String C = "CLEAN";
    public static final String D = "DIRTY";
    public static final String E = "REMOVE";
    public static final String F = "READ";

    /* renamed from: g */
    private final LinkedHashMap<String, c> f31905g = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: q */
    private final e f31915q = new e(gp.b.f27633i + " Cache");

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes3.dex */
    public final class b {

        /* renamed from: a */
        private final boolean[] f31920a;

        /* renamed from: b */
        private boolean f31921b;

        /* renamed from: c */
        private final c f31922c;

        /* renamed from: d */
        final /* synthetic */ d f31923d;

        /* compiled from: DiskLruCache.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements l<IOException, m> {
            final /* synthetic */ int $index$inlined;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i10) {
                super(1);
                b.this = r1;
                this.$index$inlined = i10;
            }

            public final void a(IOException it) {
                i.f(it, "it");
                synchronized (b.this.f31923d) {
                    b.this.c();
                    m mVar = m.f28349a;
                }
            }

            @Override // qo.l
            public /* bridge */ /* synthetic */ m invoke(IOException iOException) {
                a(iOException);
                return m.f28349a;
            }
        }

        public b(d dVar, c entry) {
            i.f(entry, "entry");
            this.f31923d = dVar;
            this.f31922c = entry;
            this.f31920a = entry.g() ? null : new boolean[dVar.W()];
        }

        public final void a() throws IOException {
            synchronized (this.f31923d) {
                if (!this.f31921b) {
                    if (i.b(this.f31922c.b(), this)) {
                        this.f31923d.w(this, false);
                    }
                    this.f31921b = true;
                    m mVar = m.f28349a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void b() throws IOException {
            synchronized (this.f31923d) {
                if (!this.f31921b) {
                    if (i.b(this.f31922c.b(), this)) {
                        this.f31923d.w(this, true);
                    }
                    this.f31921b = true;
                    m mVar = m.f28349a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void c() {
            if (!i.b(this.f31922c.b(), this)) {
                return;
            }
            if (this.f31923d.f31908j) {
                this.f31923d.w(this, false);
            } else {
                this.f31922c.q(true);
            }
        }

        public final c d() {
            return this.f31922c;
        }

        public final boolean[] e() {
            return this.f31920a;
        }

        public final r f(int i10) {
            synchronized (this.f31923d) {
                if (!(!this.f31921b)) {
                    throw new IllegalStateException("Check failed.".toString());
                } else if (!i.b(this.f31922c.b(), this)) {
                    return n.b();
                } else {
                    if (!this.f31922c.g()) {
                        boolean[] zArr = this.f31920a;
                        i.d(zArr);
                        zArr[i10] = true;
                    }
                    try {
                        return new okhttp3.internal.cache.e(this.f31923d.V().b(this.f31922c.c().get(i10)), new a(i10));
                    } catch (FileNotFoundException unused) {
                        return n.b();
                    }
                }
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes3.dex */
    public final class c {

        /* renamed from: a */
        private final long[] f31924a;

        /* renamed from: b */
        private final List<File> f31925b = new ArrayList();

        /* renamed from: c */
        private final List<File> f31926c = new ArrayList();

        /* renamed from: d */
        private boolean f31927d;

        /* renamed from: e */
        private boolean f31928e;

        /* renamed from: f */
        private b f31929f;

        /* renamed from: g */
        private int f31930g;

        /* renamed from: h */
        private long f31931h;

        /* renamed from: i */
        private final String f31932i;

        /* renamed from: j */
        final /* synthetic */ d f31933j;

        /* compiled from: DiskLruCache.kt */
        /* loaded from: classes3.dex */
        public static final class a extends h {

            /* renamed from: a */
            private boolean f31934a;

            /* renamed from: c */
            final /* synthetic */ t f31936c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t tVar, t tVar2) {
                super(tVar2);
                c.this = r1;
                this.f31936c = tVar;
            }

            @Override // okio.h, okio.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                super.close();
                if (!this.f31934a) {
                    this.f31934a = true;
                    synchronized (c.this.f31933j) {
                        c cVar = c.this;
                        cVar.n(cVar.f() - 1);
                        if (c.this.f() == 0 && c.this.i()) {
                            c cVar2 = c.this;
                            cVar2.f31933j.t0(cVar2);
                        }
                        m mVar = m.f28349a;
                    }
                }
            }
        }

        public c(d dVar, String key) {
            i.f(key, "key");
            this.f31933j = dVar;
            this.f31932i = key;
            this.f31924a = new long[dVar.W()];
            StringBuilder sb2 = new StringBuilder(key);
            sb2.append('.');
            int length = sb2.length();
            int W = dVar.W();
            for (int i10 = 0; i10 < W; i10++) {
                sb2.append(i10);
                this.f31925b.add(new File(dVar.T(), sb2.toString()));
                sb2.append(".tmp");
                this.f31926c.add(new File(dVar.T(), sb2.toString()));
                sb2.setLength(length);
            }
        }

        private final Void j(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final t k(int i10) {
            t a10 = this.f31933j.V().a(this.f31925b.get(i10));
            if (this.f31933j.f31908j) {
                return a10;
            }
            this.f31930g++;
            return new a(a10, a10);
        }

        public final List<File> a() {
            return this.f31925b;
        }

        public final b b() {
            return this.f31929f;
        }

        public final List<File> c() {
            return this.f31926c;
        }

        public final String d() {
            return this.f31932i;
        }

        public final long[] e() {
            return this.f31924a;
        }

        public final int f() {
            return this.f31930g;
        }

        public final boolean g() {
            return this.f31927d;
        }

        public final long h() {
            return this.f31931h;
        }

        public final boolean i() {
            return this.f31928e;
        }

        public final void l(b bVar) {
            this.f31929f = bVar;
        }

        public final void m(List<String> strings) throws IOException {
            i.f(strings, "strings");
            if (strings.size() == this.f31933j.W()) {
                try {
                    int size = strings.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f31924a[i10] = Long.parseLong(strings.get(i10));
                    }
                } catch (NumberFormatException unused) {
                    j(strings);
                    throw new KotlinNothingValueException();
                }
            } else {
                j(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void n(int i10) {
            this.f31930g = i10;
        }

        public final void o(boolean z10) {
            this.f31927d = z10;
        }

        public final void p(long j10) {
            this.f31931h = j10;
        }

        public final void q(boolean z10) {
            this.f31928e = z10;
        }

        public final C0429d r() {
            d dVar = this.f31933j;
            if (gp.b.f27632h && !Thread.holdsLock(dVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread = Thread.currentThread();
                i.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST hold lock on ");
                sb2.append(dVar);
                throw new AssertionError(sb2.toString());
            } else if (!this.f31927d) {
                return null;
            } else {
                if (!this.f31933j.f31908j && (this.f31929f != null || this.f31928e)) {
                    return null;
                }
                ArrayList<t> arrayList = new ArrayList();
                long[] jArr = (long[]) this.f31924a.clone();
                try {
                    int W = this.f31933j.W();
                    for (int i10 = 0; i10 < W; i10++) {
                        arrayList.add(k(i10));
                    }
                    return new C0429d(this.f31933j, this.f31932i, this.f31931h, arrayList, jArr);
                } catch (FileNotFoundException unused) {
                    for (t tVar : arrayList) {
                        gp.b.j(tVar);
                    }
                    try {
                        this.f31933j.t0(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void s(okio.d writer) throws IOException {
            i.f(writer, "writer");
            for (long j10 : this.f31924a) {
                writer.C(32).C0(j10);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* renamed from: okhttp3.internal.cache.d$d */
    /* loaded from: classes3.dex */
    public final class C0429d implements Closeable {

        /* renamed from: a */
        private final String f31937a;

        /* renamed from: b */
        private final long f31938b;

        /* renamed from: c */
        private final List<t> f31939c;

        /* renamed from: d */
        final /* synthetic */ d f31940d;

        /* JADX WARN: Multi-variable type inference failed */
        public C0429d(d dVar, String key, long j10, List<? extends t> sources, long[] lengths) {
            i.f(key, "key");
            i.f(sources, "sources");
            i.f(lengths, "lengths");
            this.f31940d = dVar;
            this.f31937a = key;
            this.f31938b = j10;
            this.f31939c = sources;
        }

        public final b c() throws IOException {
            return this.f31940d.E(this.f31937a, this.f31938b);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (t tVar : this.f31939c) {
                gp.b.j(tVar);
            }
        }

        public final t d(int i10) {
            return this.f31939c.get(i10);
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes3.dex */
    public static final class e extends ip.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(str, false, 2, null);
            d.this = r3;
        }

        @Override // ip.a
        public long f() {
            synchronized (d.this) {
                if (!d.this.f31909k || d.this.Q()) {
                    return -1L;
                }
                try {
                    d.this.w0();
                } catch (IOException unused) {
                    d.this.f31911m = true;
                }
                try {
                    if (d.this.h0()) {
                        d.this.o0();
                        d.this.f31906h = 0;
                    }
                } catch (IOException unused2) {
                    d.this.f31912n = true;
                    d.this.f31904f = n.c(n.b());
                }
                return -1L;
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements l<IOException, m> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f() {
            super(1);
            d.this = r1;
        }

        public final void a(IOException it) {
            i.f(it, "it");
            d dVar = d.this;
            if (!gp.b.f27632h || Thread.holdsLock(dVar)) {
                d.this.f31907i = true;
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(dVar);
            throw new AssertionError(sb2.toString());
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(IOException iOException) {
            a(iOException);
            return m.f28349a;
        }
    }

    static {
        new a(null);
    }

    public d(mp.a fileSystem, File directory, int i10, int i11, long j10, ip.e taskRunner) {
        i.f(fileSystem, "fileSystem");
        i.f(directory, "directory");
        i.f(taskRunner, "taskRunner");
        this.f31916r = fileSystem;
        this.f31917s = directory;
        this.f31918t = i10;
        this.f31919u = i11;
        this.f31899a = j10;
        boolean z10 = false;
        this.f31914p = taskRunner.i();
        if (j10 > 0) {
            if (i11 > 0 ? true : z10) {
                this.f31900b = new File(directory, f31894v);
                this.f31901c = new File(directory, f31895w);
                this.f31902d = new File(directory, f31896x);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public static /* synthetic */ b I(d dVar, String str, long j10, int i10, Object obj) throws IOException {
        if ((i10 & 2) != 0) {
            j10 = A;
        }
        return dVar.E(str, j10);
    }

    public final boolean h0() {
        int i10 = this.f31906h;
        return i10 >= 2000 && i10 >= this.f31905g.size();
    }

    private final okio.d i0() throws FileNotFoundException {
        return n.c(new okhttp3.internal.cache.e(this.f31916r.g(this.f31900b), new f()));
    }

    private final void j0() throws IOException {
        this.f31916r.f(this.f31901c);
        Iterator<c> it = this.f31905g.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            i.e(next, "i.next()");
            c cVar = next;
            int i10 = 0;
            if (cVar.b() == null) {
                int i11 = this.f31919u;
                while (i10 < i11) {
                    this.f31903e += cVar.e()[i10];
                    i10++;
                }
            } else {
                cVar.l(null);
                int i12 = this.f31919u;
                while (i10 < i12) {
                    this.f31916r.f(cVar.a().get(i10));
                    this.f31916r.f(cVar.c().get(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private final void k0() throws IOException {
        okio.e d10 = n.d(this.f31916r.a(this.f31900b));
        try {
            String n02 = d10.n0();
            String n03 = d10.n0();
            String n04 = d10.n0();
            String n05 = d10.n0();
            String n06 = d10.n0();
            boolean z10 = true;
            if (!(!i.b(f31897y, n02)) && !(!i.b(f31898z, n03)) && !(!i.b(String.valueOf(this.f31918t), n04)) && !(!i.b(String.valueOf(this.f31919u), n05))) {
                int i10 = 0;
                if (n06.length() <= 0) {
                    z10 = false;
                }
                if (!z10) {
                    while (true) {
                        try {
                            m0(d10.n0());
                            i10++;
                        } catch (EOFException unused) {
                            this.f31906h = i10 - this.f31905g.size();
                            if (!d10.B()) {
                                o0();
                            } else {
                                this.f31904f = i0();
                            }
                            m mVar = m.f28349a;
                            th = null;
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + n02 + ", " + n03 + ", " + n05 + ", " + n06 + ']');
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    private final void m0(String str) throws IOException {
        int S;
        int S2;
        String str2;
        boolean D2;
        boolean D3;
        boolean D4;
        List<String> n02;
        boolean D5;
        S = u.S(str, ' ', 0, false, 6, null);
        if (S != -1) {
            int i10 = S + 1;
            S2 = u.S(str, ' ', i10, false, 4, null);
            if (S2 == -1) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str2 = str.substring(i10);
                i.e(str2, "(this as java.lang.String).substring(startIndex)");
                String str3 = E;
                if (S == str3.length()) {
                    D5 = kotlin.text.t.D(str, str3, false, 2, null);
                    if (D5) {
                        this.f31905g.remove(str2);
                        return;
                    }
                }
            } else {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                str2 = str.substring(i10, S2);
                i.e(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            c cVar = this.f31905g.get(str2);
            if (cVar == null) {
                cVar = new c(this, str2);
                this.f31905g.put(str2, cVar);
            }
            if (S2 != -1) {
                String str4 = C;
                if (S == str4.length()) {
                    D4 = kotlin.text.t.D(str, str4, false, 2, null);
                    if (D4) {
                        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                        String substring = str.substring(S2 + 1);
                        i.e(substring, "(this as java.lang.String).substring(startIndex)");
                        n02 = u.n0(substring, new char[]{' '}, false, 0, 6, null);
                        cVar.o(true);
                        cVar.l(null);
                        cVar.m(n02);
                        return;
                    }
                }
            }
            if (S2 == -1) {
                String str5 = D;
                if (S == str5.length()) {
                    D3 = kotlin.text.t.D(str, str5, false, 2, null);
                    if (D3) {
                        cVar.l(new b(this, cVar));
                        return;
                    }
                }
            }
            if (S2 == -1) {
                String str6 = F;
                if (S == str6.length()) {
                    D2 = kotlin.text.t.D(str, str6, false, 2, null);
                    if (D2) {
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean u0() {
        for (c toEvict : this.f31905g.values()) {
            if (!toEvict.i()) {
                i.e(toEvict, "toEvict");
                t0(toEvict);
                return true;
            }
        }
        return false;
    }

    private final synchronized void v() {
        if (!(!this.f31910l)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    private final void z0(String str) {
        if (!B.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    public final synchronized b E(String key, long j10) throws IOException {
        i.f(key, "key");
        g0();
        v();
        z0(key);
        c cVar = this.f31905g.get(key);
        if (j10 != A && (cVar == null || cVar.h() != j10)) {
            return null;
        }
        if ((cVar != null ? cVar.b() : null) != null) {
            return null;
        }
        if (cVar != null && cVar.f() != 0) {
            return null;
        }
        if (!this.f31911m && !this.f31912n) {
            okio.d dVar = this.f31904f;
            i.d(dVar);
            dVar.R(D).C(32).R(key).C(10);
            dVar.flush();
            if (this.f31907i) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(this, key);
                this.f31905g.put(key, cVar);
            }
            b bVar = new b(this, cVar);
            cVar.l(bVar);
            return bVar;
        }
        ip.d.j(this.f31914p, this.f31915q, 0L, 2, null);
        return null;
    }

    public final synchronized C0429d O(String key) throws IOException {
        i.f(key, "key");
        g0();
        v();
        z0(key);
        c cVar = this.f31905g.get(key);
        if (cVar == null) {
            return null;
        }
        i.e(cVar, "lruEntries[key] ?: return null");
        C0429d r10 = cVar.r();
        if (r10 == null) {
            return null;
        }
        this.f31906h++;
        okio.d dVar = this.f31904f;
        i.d(dVar);
        dVar.R(F).C(32).R(key).C(10);
        if (h0()) {
            ip.d.j(this.f31914p, this.f31915q, 0L, 2, null);
        }
        return r10;
    }

    public final boolean Q() {
        return this.f31910l;
    }

    public final File T() {
        return this.f31917s;
    }

    public final mp.a V() {
        return this.f31916r;
    }

    public final int W() {
        return this.f31919u;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        c[] cVarArr;
        b b10;
        if (this.f31909k && !this.f31910l) {
            Collection<c> values = this.f31905g.values();
            i.e(values, "lruEntries.values");
            Object[] array = values.toArray(new c[0]);
            if (array != null) {
                for (c cVar : (c[]) array) {
                    if (!(cVar.b() == null || (b10 = cVar.b()) == null)) {
                        b10.c();
                    }
                }
                w0();
                okio.d dVar = this.f31904f;
                i.d(dVar);
                dVar.close();
                this.f31904f = null;
                this.f31910l = true;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        this.f31910l = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f31909k) {
            v();
            w0();
            okio.d dVar = this.f31904f;
            i.d(dVar);
            dVar.flush();
        }
    }

    public final synchronized void g0() throws IOException {
        if (gp.b.f27632h && !Thread.holdsLock(this)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
        if (!this.f31909k) {
            if (this.f31916r.d(this.f31902d)) {
                if (this.f31916r.d(this.f31900b)) {
                    this.f31916r.f(this.f31902d);
                } else {
                    this.f31916r.e(this.f31902d, this.f31900b);
                }
            }
            this.f31908j = gp.b.C(this.f31916r, this.f31902d);
            if (this.f31916r.d(this.f31900b)) {
                try {
                    k0();
                    j0();
                    this.f31909k = true;
                    return;
                } catch (IOException e10) {
                    okhttp3.internal.platform.h g10 = okhttp3.internal.platform.h.f32213c.g();
                    g10.k("DiskLruCache " + this.f31917s + " is corrupt: " + e10.getMessage() + ", removing", 5, e10);
                    x();
                    this.f31910l = false;
                }
            }
            o0();
            this.f31909k = true;
        }
    }

    public final synchronized void o0() throws IOException {
        okio.d dVar = this.f31904f;
        if (dVar != null) {
            dVar.close();
        }
        okio.d c10 = n.c(this.f31916r.b(this.f31901c));
        c10.R(f31897y).C(10);
        c10.R(f31898z).C(10);
        c10.C0(this.f31918t).C(10);
        c10.C0(this.f31919u).C(10);
        c10.C(10);
        for (c cVar : this.f31905g.values()) {
            if (cVar.b() != null) {
                c10.R(D).C(32);
                c10.R(cVar.d());
                c10.C(10);
            } else {
                c10.R(C).C(32);
                c10.R(cVar.d());
                cVar.s(c10);
                c10.C(10);
            }
        }
        m mVar = m.f28349a;
        oo.b.a(c10, null);
        if (this.f31916r.d(this.f31900b)) {
            this.f31916r.e(this.f31900b, this.f31902d);
        }
        this.f31916r.e(this.f31901c, this.f31900b);
        this.f31916r.f(this.f31902d);
        this.f31904f = i0();
        this.f31907i = false;
        this.f31912n = false;
    }

    public final synchronized boolean r0(String key) throws IOException {
        i.f(key, "key");
        g0();
        v();
        z0(key);
        c cVar = this.f31905g.get(key);
        if (cVar == null) {
            return false;
        }
        i.e(cVar, "lruEntries[key] ?: return false");
        boolean t02 = t0(cVar);
        if (t02 && this.f31903e <= this.f31899a) {
            this.f31911m = false;
        }
        return t02;
    }

    public final boolean t0(c entry) throws IOException {
        okio.d dVar;
        i.f(entry, "entry");
        if (!this.f31908j) {
            if (entry.f() > 0 && (dVar = this.f31904f) != null) {
                dVar.R(D);
                dVar.C(32);
                dVar.R(entry.d());
                dVar.C(10);
                dVar.flush();
            }
            if (entry.f() > 0 || entry.b() != null) {
                entry.q(true);
                return true;
            }
        }
        b b10 = entry.b();
        if (b10 != null) {
            b10.c();
        }
        int i10 = this.f31919u;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f31916r.f(entry.a().get(i11));
            this.f31903e -= entry.e()[i11];
            entry.e()[i11] = 0;
        }
        this.f31906h++;
        okio.d dVar2 = this.f31904f;
        if (dVar2 != null) {
            dVar2.R(E);
            dVar2.C(32);
            dVar2.R(entry.d());
            dVar2.C(10);
        }
        this.f31905g.remove(entry.d());
        if (h0()) {
            ip.d.j(this.f31914p, this.f31915q, 0L, 2, null);
        }
        return true;
    }

    public final synchronized void w(b editor, boolean z10) throws IOException {
        i.f(editor, "editor");
        c d10 = editor.d();
        if (i.b(d10.b(), editor)) {
            if (z10 && !d10.g()) {
                int i10 = this.f31919u;
                for (int i11 = 0; i11 < i10; i11++) {
                    boolean[] e10 = editor.e();
                    i.d(e10);
                    if (!e10[i11]) {
                        editor.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i11);
                    } else if (!this.f31916r.d(d10.c().get(i11))) {
                        editor.a();
                        return;
                    }
                }
            }
            int i12 = this.f31919u;
            for (int i13 = 0; i13 < i12; i13++) {
                File file = d10.c().get(i13);
                if (!z10 || d10.i()) {
                    this.f31916r.f(file);
                } else if (this.f31916r.d(file)) {
                    File file2 = d10.a().get(i13);
                    this.f31916r.e(file, file2);
                    long j10 = d10.e()[i13];
                    long h10 = this.f31916r.h(file2);
                    d10.e()[i13] = h10;
                    this.f31903e = (this.f31903e - j10) + h10;
                }
            }
            d10.l(null);
            if (d10.i()) {
                t0(d10);
                return;
            }
            this.f31906h++;
            okio.d dVar = this.f31904f;
            i.d(dVar);
            if (!d10.g() && !z10) {
                this.f31905g.remove(d10.d());
                dVar.R(E).C(32);
                dVar.R(d10.d());
                dVar.C(10);
                dVar.flush();
                if (this.f31903e <= this.f31899a || h0()) {
                    ip.d.j(this.f31914p, this.f31915q, 0L, 2, null);
                }
                return;
            }
            d10.o(true);
            dVar.R(C).C(32);
            dVar.R(d10.d());
            d10.s(dVar);
            dVar.C(10);
            if (z10) {
                long j11 = this.f31913o;
                this.f31913o = 1 + j11;
                d10.p(j11);
            }
            dVar.flush();
            if (this.f31903e <= this.f31899a) {
            }
            ip.d.j(this.f31914p, this.f31915q, 0L, 2, null);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void w0() throws IOException {
        while (this.f31903e > this.f31899a) {
            if (!u0()) {
                return;
            }
        }
        this.f31911m = false;
    }

    public final void x() throws IOException {
        close();
        this.f31916r.c(this.f31917s);
    }
}
