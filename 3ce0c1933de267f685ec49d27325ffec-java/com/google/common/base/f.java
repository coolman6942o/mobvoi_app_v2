package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: Enums.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f11703a = new WeakHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map2 = f11703a;
        synchronized (map2) {
            map = map2.get(cls);
            if (map == null) {
                map = c(cls);
            }
        }
        return map;
    }

    public static <T extends Enum<T>> Optional<T> b(Class<T> cls, String str) {
        p.o(cls);
        p.o(str);
        return o.a(cls, str);
    }

    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> c(Class<T> cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum r22 = (Enum) it.next();
            hashMap.put(r22.name(), new WeakReference(r22));
        }
        f11703a.put(cls, hashMap);
        return hashMap;
    }
}
