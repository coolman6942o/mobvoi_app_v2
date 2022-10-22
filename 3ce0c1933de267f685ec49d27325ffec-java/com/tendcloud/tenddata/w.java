package com.tendcloud.tenddata;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: td */
/* loaded from: classes2.dex */
final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, Map<Class<?>, Set<Method>>> f23028a = new ConcurrentHashMap();

    private w() {
    }

    private static void a(Class<?> cls) {
        Method[] declaredMethods;
        try {
            Map<Class<?>, Set<Method>> hashMap = new HashMap<>();
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().startsWith("onTDEBEvent") && method.getParameterTypes().length == 1) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        g.eForInternal("Method " + method + " must have one and only one argument.");
                    }
                    Class<?> cls2 = parameterTypes[0];
                    if (cls2.isInterface()) {
                        g.eForInternal("Method " + method + " must have a argument whose type is a class which can be instantialized.");
                    }
                    if ((method.getModifiers() & 1) == 0) {
                        g.eForInternal("Method " + method + " must be 'public'.");
                    }
                    Set<Method> set = hashMap.get(cls2);
                    if (set == null) {
                        set = new HashSet<>();
                        hashMap.put(cls2, set);
                    }
                    set.add(method);
                }
            }
            f23028a.put(cls, hashMap);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<Class<?>, Set<x>> a(Object obj) {
        HashMap hashMap = new HashMap();
        try {
            Class<?> cls = obj.getClass();
            Map<Class<?>, Map<Class<?>, Set<Method>>> map = f23028a;
            if (!map.containsKey(cls)) {
                a(cls);
            }
            Map<Class<?>, Set<Method>> map2 = map.get(cls);
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry<Class<?>, Set<Method>> entry : map2.entrySet()) {
                    HashSet hashSet = new HashSet();
                    for (Method method : entry.getValue()) {
                        hashSet.add(new x(obj, method));
                    }
                    hashMap.put(entry.getKey(), hashSet);
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return hashMap;
    }
}
