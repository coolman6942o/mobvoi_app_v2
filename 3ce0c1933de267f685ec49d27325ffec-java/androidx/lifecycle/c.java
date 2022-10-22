package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: ClassesInfoCache.java */
@Deprecated
/* loaded from: classes.dex */
final class c {

    /* renamed from: c  reason: collision with root package name */
    static c f3289c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, a> f3290a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3291b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<Lifecycle.Event, List<b>> f3292a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, Lifecycle.Event> f3293b;

        a(Map<b, Lifecycle.Event> map) {
            this.f3293b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> list = this.f3292a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f3292a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, p pVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(pVar, event, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(p pVar, Lifecycle.Event event, Object obj) {
            b(this.f3292a.get(event), pVar, event, obj);
            b(this.f3292a.get(Lifecycle.Event.ON_ANY), pVar, event, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f3294a;

        /* renamed from: b  reason: collision with root package name */
        final Method f3295b;

        b(int i10, Method method) {
            this.f3294a = i10;
            this.f3295b = method;
            method.setAccessible(true);
        }

        void a(p pVar, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f3294a;
                if (i10 == 0) {
                    this.f3295b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f3295b.invoke(obj, pVar);
                } else if (i10 == 2) {
                    this.f3295b.invoke(obj, pVar, event);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3294a == bVar.f3294a && this.f3295b.getName().equals(bVar.f3295b.getName());
        }

        public int hashCode() {
            return (this.f3294a * 31) + this.f3295b.getName().hashCode();
        }
    }

    c() {
    }

    private a a(Class<?> cls, Method[] methodArr) {
        int i10;
        a c10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c10 = c(superclass)) == null)) {
            hashMap.putAll(c10.f3293b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : c(cls2).f3293b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            y yVar = (y) method.getAnnotation(y.class);
            if (yVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else if (parameterTypes[0].isAssignableFrom(p.class)) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = yVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i10 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i10, method), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f3290a.put(cls, aVar);
        this.f3291b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    private void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f3295b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c(Class<?> cls) {
        a aVar = this.f3290a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f3291b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method method : b10) {
            if (((y) method.getAnnotation(y.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f3291b.put(cls, Boolean.FALSE);
        return false;
    }
}
