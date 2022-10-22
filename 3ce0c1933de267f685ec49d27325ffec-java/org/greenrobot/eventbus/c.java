package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: s  reason: collision with root package name */
    static volatile c f32438s;

    /* renamed from: t  reason: collision with root package name */
    private static final d f32439t = new d();

    /* renamed from: u  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f32440u = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<n>> f32441a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f32442b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, Object> f32443c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<C0447c> f32444d;

    /* renamed from: e  reason: collision with root package name */
    private final g f32445e;

    /* renamed from: f  reason: collision with root package name */
    private final j f32446f;

    /* renamed from: g  reason: collision with root package name */
    private final org.greenrobot.eventbus.b f32447g;

    /* renamed from: h  reason: collision with root package name */
    private final org.greenrobot.eventbus.a f32448h;

    /* renamed from: i  reason: collision with root package name */
    private final m f32449i;

    /* renamed from: j  reason: collision with root package name */
    private final ExecutorService f32450j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f32451k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f32452l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f32453m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f32454n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f32455o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f32456p;

    /* renamed from: q  reason: collision with root package name */
    private final int f32457q;

    /* renamed from: r  reason: collision with root package name */
    private final f f32458r;

    /* compiled from: EventBus.java */
    /* loaded from: classes3.dex */
    class a extends ThreadLocal<C0447c> {
        a(c cVar) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public C0447c initialValue() {
            return new C0447c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32459a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f32459a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32459a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32459a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32459a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32459a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0447c {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f32460a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f32461b;

        /* renamed from: c  reason: collision with root package name */
        boolean f32462c;

        /* renamed from: d  reason: collision with root package name */
        Object f32463d;

        /* renamed from: e  reason: collision with root package name */
        boolean f32464e;

        C0447c() {
        }
    }

    public c() {
        this(f32439t);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private void b(n nVar, Object obj) {
        if (obj != null) {
            n(nVar, obj, i());
        }
    }

    public static c c() {
        if (f32438s == null) {
            synchronized (c.class) {
                if (f32438s == null) {
                    f32438s = new c();
                }
            }
        }
        return f32438s;
    }

    private void f(n nVar, Object obj, Throwable th2) {
        if (obj instanceof tp.b) {
            if (this.f32452l) {
                f fVar = this.f32458r;
                Level level = Level.SEVERE;
                fVar.b(level, "SubscriberExceptionEvent subscriber " + nVar.f32509a.getClass() + " threw an exception", th2);
                tp.b bVar = (tp.b) obj;
                f fVar2 = this.f32458r;
                fVar2.b(level, "Initial event " + bVar.f35236b + " caused exception in " + bVar.f35237c, bVar.f35235a);
            }
        } else if (!this.f32451k) {
            if (this.f32452l) {
                f fVar3 = this.f32458r;
                Level level2 = Level.SEVERE;
                fVar3.b(level2, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f32509a.getClass(), th2);
            }
            if (this.f32454n) {
                k(new tp.b(this, th2, obj, nVar.f32509a));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th2);
        }
    }

    private boolean i() {
        g gVar = this.f32445e;
        if (gVar != null) {
            return gVar.b();
        }
        return true;
    }

    private static List<Class<?>> j(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f32440u;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f32440u.put(cls, list);
            }
        }
        return list;
    }

    private void l(Object obj, C0447c cVar) throws Error {
        boolean z10;
        Class<?> cls = obj.getClass();
        if (this.f32456p) {
            List<Class<?>> j10 = j(cls);
            int size = j10.size();
            z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                z10 |= m(obj, cVar, j10.get(i10));
            }
        } else {
            z10 = m(obj, cVar, cls);
        }
        if (!z10) {
            if (this.f32453m) {
                this.f32458r.a(Level.FINE, "No subscribers registered for event " + cls);
            }
            if (!(!this.f32455o || cls == tp.a.class || cls == tp.b.class)) {
                k(new tp.a(this, obj));
            }
        }
    }

    private boolean m(Object obj, C0447c cVar, Class<?> cls) {
        CopyOnWriteArrayList<n> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f32441a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<n> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            cVar.f32463d = obj;
            try {
                n(next, obj, cVar.f32462c);
                if (cVar.f32464e) {
                    return true;
                }
            } finally {
                cVar.f32464e = false;
            }
        }
        return true;
    }

    private void n(n nVar, Object obj, boolean z10) {
        int i10 = b.f32459a[nVar.f32510b.f32492b.ordinal()];
        if (i10 == 1) {
            h(nVar, obj);
        } else if (i10 != 2) {
            if (i10 == 3) {
                j jVar = this.f32446f;
                if (jVar != null) {
                    jVar.a(nVar, obj);
                } else {
                    h(nVar, obj);
                }
            } else if (i10 != 4) {
                if (i10 == 5) {
                    this.f32448h.a(nVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + nVar.f32510b.f32492b);
            } else if (z10) {
                this.f32447g.a(nVar, obj);
            } else {
                h(nVar, obj);
            }
        } else if (z10) {
            h(nVar, obj);
        } else {
            this.f32446f.a(nVar, obj);
        }
    }

    private void p(Object obj, l lVar) {
        Class<?> cls = lVar.f32493c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList<n> copyOnWriteArrayList = this.f32441a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f32441a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i10 = 0; i10 <= size; i10++) {
            if (i10 == size || lVar.f32494d > copyOnWriteArrayList.get(i10).f32510b.f32494d) {
                copyOnWriteArrayList.add(i10, nVar);
                break;
            }
        }
        List<Class<?>> list = this.f32442b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f32442b.put(obj, list);
        }
        list.add(cls);
        if (!lVar.f32495e) {
            return;
        }
        if (this.f32456p) {
            for (Map.Entry<Class<?>, Object> entry : this.f32443c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(nVar, entry.getValue());
                }
            }
            return;
        }
        b(nVar, this.f32443c.get(cls));
    }

    private void r(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<n> copyOnWriteArrayList = this.f32441a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                n nVar = copyOnWriteArrayList.get(i10);
                if (nVar.f32509a == obj) {
                    nVar.f32511c = false;
                    copyOnWriteArrayList.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExecutorService d() {
        return this.f32450j;
    }

    public f e() {
        return this.f32458r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(h hVar) {
        Object obj = hVar.f32486a;
        n nVar = hVar.f32487b;
        h.b(hVar);
        if (nVar.f32511c) {
            h(nVar, obj);
        }
    }

    void h(n nVar, Object obj) {
        try {
            nVar.f32510b.f32491a.invoke(nVar.f32509a, obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Unexpected exception", e10);
        } catch (InvocationTargetException e11) {
            f(nVar, obj, e11.getCause());
        }
    }

    public void k(Object obj) {
        C0447c cVar = this.f32444d.get();
        List<Object> list = cVar.f32460a;
        list.add(obj);
        if (!cVar.f32461b) {
            cVar.f32462c = i();
            cVar.f32461b = true;
            if (!cVar.f32464e) {
                while (true) {
                    try {
                        if (!list.isEmpty()) {
                            l(list.remove(0), cVar);
                        } else {
                            return;
                        }
                    } finally {
                        cVar.f32461b = false;
                        cVar.f32462c = false;
                    }
                }
            } else {
                throw new EventBusException("Internal error. Abort state was not reset");
            }
        }
    }

    public void o(Object obj) {
        List<l> a10 = this.f32449i.a(obj.getClass());
        synchronized (this) {
            for (l lVar : a10) {
                p(obj, lVar);
            }
        }
    }

    public synchronized void q(Object obj) {
        List<Class<?>> list = this.f32442b.get(obj);
        if (list != null) {
            for (Class<?> cls : list) {
                r(obj, cls);
            }
            this.f32442b.remove(obj);
        } else {
            f fVar = this.f32458r;
            Level level = Level.WARNING;
            fVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f32457q + ", eventInheritance=" + this.f32456p + "]";
    }

    c(d dVar) {
        this.f32444d = new a(this);
        this.f32458r = dVar.b();
        this.f32441a = new HashMap();
        this.f32442b = new HashMap();
        this.f32443c = new ConcurrentHashMap();
        g c10 = dVar.c();
        this.f32445e = c10;
        this.f32446f = c10 != null ? c10.a(this) : null;
        this.f32447g = new org.greenrobot.eventbus.b(this);
        this.f32448h = new org.greenrobot.eventbus.a(this);
        List<up.b> list = dVar.f32475j;
        this.f32457q = list != null ? list.size() : 0;
        this.f32449i = new m(dVar.f32475j, dVar.f32473h, dVar.f32472g);
        this.f32452l = dVar.f32466a;
        this.f32453m = dVar.f32467b;
        this.f32454n = dVar.f32468c;
        this.f32455o = dVar.f32469d;
        this.f32451k = dVar.f32470e;
        this.f32456p = dVar.f32471f;
        this.f32450j = dVar.f32474i;
    }
}
