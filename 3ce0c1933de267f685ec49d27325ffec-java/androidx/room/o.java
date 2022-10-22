package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import androidx.lifecycle.LiveData;
import i1.f;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f4282m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b  reason: collision with root package name */
    final String[] f4284b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Set<String>> f4285c;

    /* renamed from: e  reason: collision with root package name */
    final RoomDatabase f4287e;

    /* renamed from: h  reason: collision with root package name */
    volatile f f4290h;

    /* renamed from: i  reason: collision with root package name */
    private b f4291i;

    /* renamed from: j  reason: collision with root package name */
    private final m f4292j;

    /* renamed from: d  reason: collision with root package name */
    androidx.room.a f4286d = null;

    /* renamed from: f  reason: collision with root package name */
    AtomicBoolean f4288f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f4289g = false;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: k  reason: collision with root package name */
    final l.b<c, d> f4293k = new l.b<>();

    /* renamed from: l  reason: collision with root package name */
    Runnable f4294l = new a();

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f4283a = new HashMap<>();

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Finally extract failed */
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor y10 = o.this.f4287e.y(new i1.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (y10.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(y10.getInt(0)));
                } catch (Throwable th2) {
                    y10.close();
                    throw th2;
                }
            }
            y10.close();
            if (!hashSet.isEmpty()) {
                o.this.f4290h.r();
            }
            return hashSet;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
            if (r0 != null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
            r0.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
            if (r0 == null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:
            if (r1 == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a1, code lost:
            if (r1.isEmpty() != false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
            r0 = r5.f4295a.f4293k;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
            r2 = r5.f4295a.f4293k.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b4, code lost:
            if (r2.hasNext() == false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00b6, code lost:
            r2.next().getValue().a(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00cb, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            androidx.room.a aVar;
            Lock j10 = o.this.f4287e.j();
            j10.lock();
            Set<Integer> set = null;
            try {
                try {
                    if (!o.this.f()) {
                    } else if (!o.this.f4288f.compareAndSet(true, false)) {
                        j10.unlock();
                        androidx.room.a aVar2 = o.this.f4286d;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    } else if (o.this.f4287e.p()) {
                        j10.unlock();
                        androidx.room.a aVar3 = o.this.f4286d;
                        if (aVar3 != null) {
                            aVar3.b();
                        }
                    } else {
                        RoomDatabase roomDatabase = o.this.f4287e;
                        if (roomDatabase.f4144g) {
                            i1.b S = roomDatabase.l().S();
                            S.N();
                            try {
                                set = a();
                                S.L();
                                S.Y();
                            } catch (Throwable th2) {
                                S.Y();
                                throw th2;
                            }
                        } else {
                            set = a();
                        }
                        j10.unlock();
                        aVar = o.this.f4286d;
                    }
                } finally {
                    j10.unlock();
                    androidx.room.a aVar4 = o.this.f4286d;
                    if (aVar4 != null) {
                        aVar4.b();
                    }
                }
            } catch (SQLiteException | IllegalStateException e10) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                j10.unlock();
                aVar = o.this.f4286d;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final long[] f4296a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f4297b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f4298c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4299d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4300e;

        b(int i10) {
            long[] jArr = new long[i10];
            this.f4296a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f4297b = zArr;
            this.f4298c = new int[i10];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        int[] a() {
            synchronized (this) {
                if (this.f4299d && !this.f4300e) {
                    int length = this.f4296a.length;
                    int i10 = 0;
                    while (true) {
                        int i11 = 1;
                        if (i10 < length) {
                            boolean z10 = this.f4296a[i10] > 0;
                            boolean[] zArr = this.f4297b;
                            if (z10 != zArr[i10]) {
                                int[] iArr = this.f4298c;
                                if (!z10) {
                                    i11 = 2;
                                }
                                iArr[i10] = i11;
                            } else {
                                this.f4298c[i10] = 0;
                            }
                            zArr[i10] = z10;
                            i10++;
                        } else {
                            this.f4300e = true;
                            this.f4299d = false;
                            return this.f4298c;
                        }
                    }
                }
                return null;
            }
        }

        boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f4296a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        this.f4299d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f4296a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        this.f4299d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        void d() {
            synchronized (this) {
                this.f4300e = false;
            }
        }

        void e() {
            synchronized (this) {
                Arrays.fill(this.f4297b, false);
                this.f4299d = true;
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final String[] f4301a;

        public c(String[] strArr) {
            this.f4301a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        final int[] f4302a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f4303b;

        /* renamed from: c  reason: collision with root package name */
        final c f4304c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f4305d;

        d(c cVar, int[] iArr, String[] strArr) {
            this.f4304c = cVar;
            this.f4302a = iArr;
            this.f4303b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f4305d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f4305d = null;
        }

        void a(Set<Integer> set) {
            int length = this.f4302a.length;
            Set<String> set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f4302a[i10]))) {
                    if (length == 1) {
                        set2 = this.f4305d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet<>(length);
                        }
                        set2.add(this.f4303b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f4304c.b(set2);
            }
        }

        void b(String[] strArr) {
            Set<String> set = null;
            if (this.f4303b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    } else if (strArr[i10].equalsIgnoreCase(this.f4303b[0])) {
                        set = this.f4305d;
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f4303b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            String str2 = strArr2[i11];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i11++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f4304c.b(set);
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        final o f4306b;

        /* renamed from: c  reason: collision with root package name */
        final WeakReference<c> f4307c;

        e(o oVar, c cVar) {
            super(cVar.f4301a);
            this.f4306b = oVar;
            this.f4307c = new WeakReference<>(cVar);
        }

        @Override // androidx.room.o.c
        public void b(Set<String> set) {
            c cVar = this.f4307c.get();
            if (cVar == null) {
                this.f4306b.k(this);
            } else {
                cVar.b(set);
            }
        }
    }

    public o(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f4287e = roomDatabase;
        this.f4291i = new b(strArr.length);
        this.f4285c = map2;
        this.f4292j = new m(roomDatabase);
        int length = strArr.length;
        this.f4284b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f4283a.put(lowerCase, Integer.valueOf(i10));
            String str2 = map.get(strArr[i10]);
            if (str2 != null) {
                this.f4284b[i10] = str2.toLowerCase(locale);
            } else {
                this.f4284b[i10] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.f4283a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f4283a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void c(StringBuilder sb2, String str, String str2) {
        sb2.append("`");
        sb2.append("room_table_modification_trigger_");
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        sb2.append("`");
    }

    private static void d(i1.b bVar) {
        if (Build.VERSION.SDK_INT < 16 || !bVar.x0()) {
            bVar.g();
        } else {
            bVar.N();
        }
    }

    private String[] l(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f4285c.containsKey(lowerCase)) {
                hashSet.addAll(this.f4285c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void o(i1.b bVar, int i10) {
        String[] strArr;
        bVar.l("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f4284b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f4282m) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append("room_table_modification_log");
            sb2.append(" SET ");
            sb2.append("invalidated");
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append("table_id");
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(" AND ");
            sb2.append("invalidated");
            sb2.append(" = 0");
            sb2.append("; END");
            bVar.l(sb2.toString());
        }
    }

    private void p(i1.b bVar, int i10) {
        String[] strArr;
        String str = this.f4284b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f4282m) {
            sb2.setLength(0);
            sb2.append("DROP TRIGGER IF EXISTS ");
            c(sb2, str, str2);
            bVar.l(sb2.toString());
        }
    }

    private String[] s(String[] strArr) {
        String[] l10 = l(strArr);
        for (String str : l10) {
            if (!this.f4283a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return l10;
    }

    @SuppressLint({"RestrictedApi"})
    public void a(c cVar) {
        d f10;
        String[] l10 = l(cVar.f4301a);
        int[] iArr = new int[l10.length];
        int length = l10.length;
        for (int i10 = 0; i10 < length; i10++) {
            Integer num = this.f4283a.get(l10[i10].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i10] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + l10[i10]);
            }
        }
        d dVar = new d(cVar, iArr, l10);
        synchronized (this.f4293k) {
            f10 = this.f4293k.f(cVar, dVar);
        }
        if (f10 == null && this.f4291i.b(iArr)) {
            q();
        }
    }

    public void b(c cVar) {
        a(new e(this, cVar));
    }

    public <T> LiveData<T> e(String[] strArr, boolean z10, Callable<T> callable) {
        return this.f4292j.a(s(strArr), z10, callable);
    }

    boolean f() {
        if (!this.f4287e.v()) {
            return false;
        }
        if (!this.f4289g) {
            this.f4287e.l().S();
        }
        if (this.f4289g) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(i1.b bVar) {
        synchronized (this) {
            if (this.f4289g) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.l("PRAGMA temp_store = MEMORY;");
            bVar.l("PRAGMA recursive_triggers='ON';");
            bVar.l("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            r(bVar);
            this.f4290h = bVar.s("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f4289g = true;
        }
    }

    public void h(String... strArr) {
        synchronized (this.f4293k) {
            Iterator<Map.Entry<c, d>> it = this.f4293k.iterator();
            while (it.hasNext()) {
                Map.Entry<c, d> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().b(strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        synchronized (this) {
            this.f4289g = false;
            this.f4291i.e();
        }
    }

    public void j() {
        if (this.f4288f.compareAndSet(false, true)) {
            androidx.room.a aVar = this.f4286d;
            if (aVar != null) {
                aVar.e();
            }
            this.f4287e.m().execute(this.f4294l);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void k(c cVar) {
        d g10;
        synchronized (this.f4293k) {
            g10 = this.f4293k.g(cVar);
        }
        if (g10 != null && this.f4291i.c(g10.f4302a)) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(androidx.room.a aVar) {
        this.f4286d = aVar;
        aVar.h(new Runnable() { // from class: androidx.room.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.i();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Context context, String str) {
        new p(context, str, this, this.f4287e.m());
    }

    void q() {
        if (this.f4287e.v()) {
            r(this.f4287e.l().S());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(i1.b bVar) {
        if (!bVar.q0()) {
            while (true) {
                try {
                    Lock j10 = this.f4287e.j();
                    j10.lock();
                    try {
                        int[] a10 = this.f4291i.a();
                        if (a10 != null) {
                            int length = a10.length;
                            d(bVar);
                            for (int i10 = 0; i10 < length; i10++) {
                                int i11 = a10[i10];
                                if (i11 == 1) {
                                    o(bVar, i10);
                                } else if (i11 == 2) {
                                    p(bVar, i10);
                                }
                            }
                            bVar.L();
                            bVar.Y();
                            this.f4291i.d();
                        } else {
                            return;
                        }
                    } finally {
                        j10.unlock();
                    }
                } catch (SQLiteException | IllegalStateException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    return;
                }
            }
        }
    }
}
