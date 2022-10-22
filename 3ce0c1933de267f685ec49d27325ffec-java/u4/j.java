package u4;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements u4.b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f35302a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f35303b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f35304c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, u4.a<?>> f35305d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final int f35306e;

    /* renamed from: f  reason: collision with root package name */
    private int f35307f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f35308a;

        /* renamed from: b  reason: collision with root package name */
        int f35309b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f35310c;

        a(b bVar) {
            this.f35308a = bVar;
        }

        @Override // u4.m
        public void a() {
            this.f35308a.c(this);
        }

        void b(int i10, Class<?> cls) {
            this.f35309b = i10;
            this.f35310c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f35309b == aVar.f35309b && this.f35310c == aVar.f35310c;
        }

        public int hashCode() {
            int i10 = this.f35309b * 31;
            Class<?> cls = this.f35310c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f35309b + "array=" + this.f35310c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    private static final class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i10, Class<?> cls) {
            a b10 = b();
            b10.b(i10, cls);
            return b10;
        }
    }

    public j(int i10) {
        this.f35306e = i10;
    }

    private void f(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> m10 = m(cls);
        Integer num = (Integer) m10.get(Integer.valueOf(i10));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
        } else if (num.intValue() == 1) {
            m10.remove(Integer.valueOf(i10));
        } else {
            m10.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void g() {
        h(this.f35306e);
    }

    private void h(int i10) {
        while (this.f35307f > i10) {
            Object f10 = this.f35302a.f();
            n5.j.d(f10);
            u4.a i11 = i(f10);
            this.f35307f -= i11.c(f10) * i11.a();
            f(i11.c(f10), f10.getClass());
            if (Log.isLoggable(i11.b(), 2)) {
                Log.v(i11.b(), "evicted: " + i11.c(f10));
            }
        }
    }

    private <T> u4.a<T> i(T t10) {
        return j(t10.getClass());
    }

    private <T> u4.a<T> j(Class<T> cls) {
        g gVar = (u4.a<T>) this.f35305d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f35305d.put(cls, gVar);
        }
        return gVar;
    }

    private <T> T k(a aVar) {
        return (T) this.f35302a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        u4.a<T> j10 = j(cls);
        T t10 = (T) k(aVar);
        if (t10 != null) {
            this.f35307f -= j10.c(t10) * j10.a();
            f(j10.c(t10), cls);
        }
        if (t10 != null) {
            return t10;
        }
        if (Log.isLoggable(j10.b(), 2)) {
            Log.v(j10.b(), "Allocated " + aVar.f35309b + " bytes");
        }
        return j10.newArray(aVar.f35309b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f35304c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f35304c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i10 = this.f35307f;
        return i10 == 0 || this.f35306e / i10 >= 2;
    }

    private boolean o(int i10) {
        return i10 <= this.f35306e / 2;
    }

    private boolean p(int i10, Integer num) {
        return num != null && (n() || num.intValue() <= i10 * 8);
    }

    @Override // u4.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                h(this.f35306e / 2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // u4.b
    public synchronized void b() {
        h(0);
    }

    @Override // u4.b
    public synchronized <T> T c(int i10, Class<T> cls) {
        return (T) l(this.f35303b.e(i10, cls), cls);
    }

    @Override // u4.b
    public synchronized <T> void d(T t10) {
        Class<?> cls = t10.getClass();
        u4.a<T> j10 = j(cls);
        int c10 = j10.c(t10);
        int a10 = j10.a() * c10;
        if (o(a10)) {
            a e10 = this.f35303b.e(c10, cls);
            this.f35302a.d(e10, t10);
            NavigableMap<Integer, Integer> m10 = m(cls);
            Integer num = (Integer) m10.get(Integer.valueOf(e10.f35309b));
            Integer valueOf = Integer.valueOf(e10.f35309b);
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            m10.put(valueOf, Integer.valueOf(i10));
            this.f35307f += a10;
            g();
        }
    }

    @Override // u4.b
    public synchronized <T> T e(int i10, Class<T> cls) {
        a aVar;
        Integer ceilingKey = m(cls).ceilingKey(Integer.valueOf(i10));
        if (p(i10, ceilingKey)) {
            aVar = this.f35303b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f35303b.e(i10, cls);
        }
        return (T) l(aVar, cls);
    }
}
