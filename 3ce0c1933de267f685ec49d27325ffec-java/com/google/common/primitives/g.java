package com.google.common.primitives;

import com.google.common.base.p;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: Primitives.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f12353a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f12354b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(16);
        a(linkedHashMap, linkedHashMap2, Boolean.TYPE, Boolean.class);
        a(linkedHashMap, linkedHashMap2, Byte.TYPE, Byte.class);
        a(linkedHashMap, linkedHashMap2, Character.TYPE, Character.class);
        a(linkedHashMap, linkedHashMap2, Double.TYPE, Double.class);
        a(linkedHashMap, linkedHashMap2, Float.TYPE, Float.class);
        a(linkedHashMap, linkedHashMap2, Integer.TYPE, Integer.class);
        a(linkedHashMap, linkedHashMap2, Long.TYPE, Long.class);
        a(linkedHashMap, linkedHashMap2, Short.TYPE, Short.class);
        a(linkedHashMap, linkedHashMap2, Void.TYPE, Void.class);
        f12353a = Collections.unmodifiableMap(linkedHashMap);
        f12354b = Collections.unmodifiableMap(linkedHashMap2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> b() {
        return f12354b.keySet();
    }

    public static <T> Class<T> c(Class<T> cls) {
        p.o(cls);
        Class<T> cls2 = (Class<T>) f12354b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> d(Class<T> cls) {
        p.o(cls);
        Class<T> cls2 = (Class<T>) f12353a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
