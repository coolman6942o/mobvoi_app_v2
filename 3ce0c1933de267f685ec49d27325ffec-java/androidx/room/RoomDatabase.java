package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import i1.b;
import i1.c;
import i1.f;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public abstract class RoomDatabase {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile i1.b f4138a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f4139b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f4140c;

    /* renamed from: d  reason: collision with root package name */
    private i1.c f4141d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4143f;

    /* renamed from: g  reason: collision with root package name */
    boolean f4144g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    protected List<b> f4145h;

    /* renamed from: j  reason: collision with root package name */
    private androidx.room.a f4147j;

    /* renamed from: i  reason: collision with root package name */
    private final ReentrantReadWriteLock f4146i = new ReentrantReadWriteLock();

    /* renamed from: k  reason: collision with root package name */
    private final ThreadLocal<Integer> f4148k = new ThreadLocal<>();

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, Object> f4149l = Collections.synchronizedMap(new HashMap());

    /* renamed from: e  reason: collision with root package name */
    private final o f4142e = g();

    /* renamed from: m  reason: collision with root package name */
    private final Map<Class<?>, Object> f4150m = new HashMap();

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }

        @SuppressLint({"NewApi"})
        JournalMode b(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT < 16 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || a(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    /* loaded from: classes.dex */
    public static class a<T extends RoomDatabase> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f4151a;

        /* renamed from: b  reason: collision with root package name */
        private final String f4152b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f4153c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f4154d;

        /* renamed from: e  reason: collision with root package name */
        private d f4155e;

        /* renamed from: f  reason: collision with root package name */
        private e f4156f;

        /* renamed from: g  reason: collision with root package name */
        private Executor f4157g;

        /* renamed from: h  reason: collision with root package name */
        private List<Object> f4158h;

        /* renamed from: i  reason: collision with root package name */
        private Executor f4159i;

        /* renamed from: j  reason: collision with root package name */
        private Executor f4160j;

        /* renamed from: k  reason: collision with root package name */
        private c.AbstractC0307c f4161k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4162l;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4164n;

        /* renamed from: p  reason: collision with root package name */
        private boolean f4166p;

        /* renamed from: r  reason: collision with root package name */
        private TimeUnit f4168r;

        /* renamed from: t  reason: collision with root package name */
        private Set<Integer> f4170t;

        /* renamed from: u  reason: collision with root package name */
        private Set<Integer> f4171u;

        /* renamed from: v  reason: collision with root package name */
        private String f4172v;

        /* renamed from: w  reason: collision with root package name */
        private File f4173w;

        /* renamed from: x  reason: collision with root package name */
        private Callable<InputStream> f4174x;

        /* renamed from: q  reason: collision with root package name */
        private long f4167q = -1;

        /* renamed from: m  reason: collision with root package name */
        private JournalMode f4163m = JournalMode.AUTOMATIC;

        /* renamed from: o  reason: collision with root package name */
        private boolean f4165o = true;

        /* renamed from: s  reason: collision with root package name */
        private final c f4169s = new c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, Class<T> cls, String str) {
            this.f4153c = context;
            this.f4151a = cls;
            this.f4152b = str;
        }

        public a<T> a(b bVar) {
            if (this.f4154d == null) {
                this.f4154d = new ArrayList<>();
            }
            this.f4154d.add(bVar);
            return this;
        }

        public a<T> b(Migration... migrationArr) {
            if (this.f4171u == null) {
                this.f4171u = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.f4171u.add(Integer.valueOf(migration.f27192a));
                this.f4171u.add(Integer.valueOf(migration.f27193b));
            }
            this.f4169s.b(migrationArr);
            return this;
        }

        public a<T> c() {
            this.f4162l = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T d() {
            Executor executor;
            if (this.f4153c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f4151a != null) {
                Executor executor2 = this.f4159i;
                if (executor2 == null && this.f4160j == null) {
                    Executor e10 = k.a.e();
                    this.f4160j = e10;
                    this.f4159i = e10;
                } else if (executor2 != null && this.f4160j == null) {
                    this.f4160j = executor2;
                } else if (executor2 == null && (executor = this.f4160j) != null) {
                    this.f4159i = executor;
                }
                Set<Integer> set = this.f4171u;
                if (!(set == null || this.f4170t == null)) {
                    for (Integer num : set) {
                        if (this.f4170t.contains(num)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                        }
                    }
                }
                h hVar = this.f4161k;
                if (hVar == null) {
                    hVar = new j1.c();
                }
                long j10 = this.f4167q;
                if (j10 > 0) {
                    if (this.f4152b != null) {
                        hVar = new h(hVar, new androidx.room.a(j10, this.f4168r, this.f4160j));
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                String str = this.f4172v;
                if (!(str == null && this.f4173w == null && this.f4174x == null)) {
                    if (this.f4152b != null) {
                        int i10 = 0;
                        int i11 = str == null ? 0 : 1;
                        File file = this.f4173w;
                        int i12 = i11 + (file == null ? 0 : 1);
                        Callable<InputStream> callable = this.f4174x;
                        if (callable != null) {
                            i10 = 1;
                        }
                        if (i12 + i10 == 1) {
                            hVar = new k0(str, file, callable, hVar);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
                e eVar = this.f4156f;
                b0 b0Var = eVar != null ? new b0(hVar, eVar, this.f4157g) : hVar;
                Context context = this.f4153c;
                i iVar = new i(context, this.f4152b, b0Var, this.f4169s, this.f4154d, this.f4162l, this.f4163m.b(context), this.f4159i, this.f4160j, this.f4164n, this.f4165o, this.f4166p, this.f4170t, this.f4172v, this.f4173w, this.f4174x, this.f4155e, this.f4158h);
                T t10 = (T) g0.b(this.f4151a, "_Impl");
                t10.q(iVar);
                return t10;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        public a<T> e() {
            this.f4165o = false;
            this.f4166p = true;
            return this;
        }

        public a<T> f(c.AbstractC0307c cVar) {
            this.f4161k = cVar;
            return this;
        }

        public a<T> g(Executor executor) {
            this.f4159i = executor;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(i1.b bVar) {
        }

        public void b(i1.b bVar) {
        }

        public void c(i1.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, g1.a>> f4175a = new HashMap<>();

        private void a(g1.a aVar) {
            int i10 = aVar.f27192a;
            int i11 = aVar.f27193b;
            TreeMap<Integer, g1.a> treeMap = this.f4175a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.f4175a.put(Integer.valueOf(i10), treeMap);
            }
            g1.a aVar2 = treeMap.get(Integer.valueOf(i11));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i11), aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<g1.a> d(List<g1.a> list, boolean z10, int i10, int i11) {
            TreeMap<Integer, g1.a> treeMap;
            Set<Integer> set;
            boolean z11;
            do {
                if (z10) {
                    if (i10 >= i11) {
                        return list;
                    }
                    treeMap = this.f4175a.get(Integer.valueOf(i10));
                    if (treeMap == null) {
                        if (z10) {
                            set = treeMap.descendingKeySet();
                        } else {
                            set = treeMap.keySet();
                        }
                        Iterator<Integer> it = set.iterator();
                        while (true) {
                            z11 = true;
                            boolean z12 = false;
                            if (!it.hasNext()) {
                                z11 = false;
                                continue;
                                break;
                            }
                            int intValue = it.next().intValue();
                            if (!z10 ? !(intValue < i11 || intValue >= i10) : !(intValue > i11 || intValue <= i10)) {
                                z12 = true;
                                continue;
                            }
                            if (z12) {
                                list.add(treeMap.get(Integer.valueOf(intValue)));
                                i10 = intValue;
                                continue;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i10 <= i11) {
                        return list;
                    }
                    treeMap = this.f4175a.get(Integer.valueOf(i10));
                    if (treeMap == null) {
                    }
                }
            } while (z11);
            return null;
        }

        public void b(g1.a... aVarArr) {
            for (g1.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public List<g1.a> c(int i10, int i11) {
            if (i10 == i11) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i11 > i10, i10, i11);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str, List<Object> list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T C(Class<T> cls, i1.c cVar) {
        if (cls.isInstance(cVar)) {
            return cVar;
        }
        if (cVar instanceof j) {
            return (T) C(cls, ((j) cVar).getDelegate());
        }
        return null;
    }

    private void r() {
        c();
        i1.b S = this.f4141d.S();
        this.f4142e.r(S);
        if (Build.VERSION.SDK_INT < 16 || !S.x0()) {
            S.g();
        } else {
            S.N();
        }
    }

    private void s() {
        this.f4141d.S().Y();
        if (!p()) {
            this.f4142e.j();
        }
    }

    private static boolean u() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object w(i1.b bVar) {
        r();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object x(i1.b bVar) {
        s();
        return null;
    }

    public void A(Runnable runnable) {
        e();
        try {
            runnable.run();
            B();
        } finally {
            i();
        }
    }

    @Deprecated
    public void B() {
        this.f4141d.S().L();
    }

    public void c() {
        if (!this.f4143f && u()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void d() {
        if (!p() && this.f4148k.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void e() {
        c();
        androidx.room.a aVar = this.f4147j;
        if (aVar == null) {
            r();
        } else {
            aVar.c(new m.a() { // from class: f1.h
                @Override // m.a
                public final Object apply(Object obj) {
                    Object w10;
                    w10 = RoomDatabase.this.w((b) obj);
                    return w10;
                }
            });
        }
    }

    public f f(String str) {
        c();
        d();
        return this.f4141d.S().s(str);
    }

    protected abstract o g();

    protected abstract i1.c h(i iVar);

    @Deprecated
    public void i() {
        androidx.room.a aVar = this.f4147j;
        if (aVar == null) {
            s();
        } else {
            aVar.c(new m.a() { // from class: f1.i
                @Override // m.a
                public final Object apply(Object obj) {
                    Object x10;
                    x10 = RoomDatabase.this.x((b) obj);
                    return x10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock j() {
        return this.f4146i.readLock();
    }

    public o k() {
        return this.f4142e;
    }

    public i1.c l() {
        return this.f4141d;
    }

    public Executor m() {
        return this.f4139b;
    }

    protected Map<Class<?>, List<Class<?>>> n() {
        return Collections.emptyMap();
    }

    public Executor o() {
        return this.f4140c;
    }

    public boolean p() {
        return this.f4141d.S().q0();
    }

    public void q(i iVar) {
        i1.c h10 = h(iVar);
        this.f4141d = h10;
        j0 j0Var = (j0) C(j0.class, h10);
        if (j0Var != null) {
            j0Var.h(iVar);
        }
        f fVar = (f) C(f.class, this.f4141d);
        if (fVar != null) {
            androidx.room.a c10 = fVar.c();
            this.f4147j = c10;
            this.f4142e.m(c10);
        }
        boolean z10 = false;
        if (Build.VERSION.SDK_INT >= 16) {
            if (iVar.f4237i == JournalMode.WRITE_AHEAD_LOGGING) {
                z10 = true;
            }
            this.f4141d.setWriteAheadLoggingEnabled(z10);
        }
        this.f4145h = iVar.f4233e;
        this.f4139b = iVar.f4238j;
        this.f4140c = new l0(iVar.f4239k);
        this.f4143f = iVar.f4236h;
        this.f4144g = z10;
        if (iVar.f4240l) {
            this.f4142e.n(iVar.f4230b, iVar.f4231c);
        }
        Map<Class<?>, List<Class<?>>> n10 = n();
        BitSet bitSet = new BitSet();
        for (Map.Entry<Class<?>, List<Class<?>>> entry : n10.entrySet()) {
            Class<?> key = entry.getKey();
            for (Class<?> cls : entry.getValue()) {
                int size = iVar.f4235g.size() - 1;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    } else if (cls.isAssignableFrom(iVar.f4235g.get(size).getClass())) {
                        bitSet.set(size);
                        break;
                    } else {
                        size--;
                    }
                }
                if (size >= 0) {
                    this.f4150m.put(cls, iVar.f4235g.get(size));
                } else {
                    throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                }
            }
        }
        for (int size2 = iVar.f4235g.size() - 1; size2 >= 0; size2--) {
            if (!bitSet.get(size2)) {
                throw new IllegalArgumentException("Unexpected type converter " + iVar.f4235g.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(i1.b bVar) {
        this.f4142e.g(bVar);
    }

    public boolean v() {
        androidx.room.a aVar = this.f4147j;
        if (aVar != null) {
            return aVar.g();
        }
        i1.b bVar = this.f4138a;
        return bVar != null && bVar.isOpen();
    }

    public Cursor y(i1.e eVar) {
        return z(eVar, null);
    }

    public Cursor z(i1.e eVar, CancellationSignal cancellationSignal) {
        c();
        d();
        if (cancellationSignal == null || Build.VERSION.SDK_INT < 16) {
            return this.f4141d.S().f0(eVar);
        }
        return this.f4141d.S().D(eVar, cancellationSignal);
    }
}
