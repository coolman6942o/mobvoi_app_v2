package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: Primitives.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f12642a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f12643b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        a(hashMap, hashMap2, Character.TYPE, Character.class);
        a(hashMap, hashMap2, Double.TYPE, Double.class);
        a(hashMap, hashMap2, Float.TYPE, Float.class);
        a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        a(hashMap, hashMap2, Long.TYPE, Long.class);
        a(hashMap, hashMap2, Short.TYPE, Short.class);
        a(hashMap, hashMap2, Void.TYPE, Void.class);
        f12642a = Collections.unmodifiableMap(hashMap);
        f12643b = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean b(Type type) {
        return f12642a.containsKey(type);
    }

    public static <T> Class<T> c(Class<T> cls) {
        Class<T> cls2 = (Class<T>) f12642a.get(a.b(cls));
        return cls2 == null ? cls : cls2;
    }
}
