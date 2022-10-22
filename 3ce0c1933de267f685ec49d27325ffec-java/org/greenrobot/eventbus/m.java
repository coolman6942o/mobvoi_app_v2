package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import up.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriberMethodFinder.java */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<?>, List<l>> f32497d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final a[] f32498e = new a[4];

    /* renamed from: a  reason: collision with root package name */
    private List<b> f32499a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32500b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32501c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SubscriberMethodFinder.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<l> f32502a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f32503b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f32504c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f32505d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        Class<?> f32506e;

        /* renamed from: f  reason: collision with root package name */
        boolean f32507f;

        /* renamed from: g  reason: collision with root package name */
        up.a f32508g;

        a() {
        }

        private boolean b(Method method, Class<?> cls) {
            this.f32505d.setLength(0);
            this.f32505d.append(method.getName());
            StringBuilder sb2 = this.f32505d;
            sb2.append('>');
            sb2.append(cls.getName());
            String sb3 = this.f32505d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f32504c.put(sb3, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f32504c.put(sb3, put);
            return false;
        }

        boolean a(Method method, Class<?> cls) {
            Object put = this.f32503b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f32503b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        void c(Class<?> cls) {
            this.f32506e = cls;
            this.f32507f = false;
            this.f32508g = null;
        }

        void d() {
            if (this.f32507f) {
                this.f32506e = null;
                return;
            }
            Class<? super Object> superclass = this.f32506e.getSuperclass();
            this.f32506e = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f32506e = null;
            }
        }

        void e() {
            this.f32502a.clear();
            this.f32503b.clear();
            this.f32504c.clear();
            this.f32505d.setLength(0);
            this.f32506e = null;
            this.f32507f = false;
            this.f32508g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(List<b> list, boolean z10, boolean z11) {
        this.f32499a = list;
        this.f32500b = z10;
        this.f32501c = z11;
    }

    private List<l> b(Class<?> cls) {
        l[] a10;
        a g10 = g();
        g10.c(cls);
        while (g10.f32506e != null) {
            up.a f10 = f(g10);
            g10.f32508g = f10;
            if (f10 != null) {
                for (l lVar : f10.a()) {
                    if (g10.a(lVar.f32491a, lVar.f32493c)) {
                        g10.f32502a.add(lVar);
                    }
                }
            } else {
                d(g10);
            }
            g10.d();
        }
        return e(g10);
    }

    private List<l> c(Class<?> cls) {
        a g10 = g();
        g10.c(cls);
        while (g10.f32506e != null) {
            d(g10);
            g10.d();
        }
        return e(g10);
    }

    private void d(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f32506e.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f32506e.getMethods();
            aVar.f32507f = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    k kVar = (k) method.getAnnotation(k.class);
                    if (kVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f32502a.add(new l(method, cls, kVar.threadMode(), kVar.priority(), kVar.sticky()));
                        }
                    }
                } else if (this.f32500b && method.isAnnotationPresent(k.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f32500b && method.isAnnotationPresent(k.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List<l> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f32502a);
        aVar.e();
        synchronized (f32498e) {
            int i10 = 0;
            while (true) {
                if (i10 >= 4) {
                    break;
                }
                a[] aVarArr = f32498e;
                if (aVarArr[i10] == null) {
                    aVarArr[i10] = aVar;
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    private up.a f(a aVar) {
        up.a aVar2 = aVar.f32508g;
        if (!(aVar2 == null || aVar2.b() == null)) {
            up.a b10 = aVar.f32508g.b();
            if (aVar.f32506e == b10.c()) {
                return b10;
            }
        }
        List<b> list = this.f32499a;
        if (list == null) {
            return null;
        }
        for (b bVar : list) {
            up.a a10 = bVar.a(aVar.f32506e);
            if (a10 != null) {
                return a10;
            }
        }
        return null;
    }

    private a g() {
        synchronized (f32498e) {
            for (int i10 = 0; i10 < 4; i10++) {
                a[] aVarArr = f32498e;
                a aVar = aVarArr[i10];
                if (aVar != null) {
                    aVarArr[i10] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<l> a(Class<?> cls) {
        List<l> list;
        Map<Class<?>, List<l>> map = f32497d;
        List<l> list2 = map.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f32501c) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            map.put(cls, list);
            return list;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
