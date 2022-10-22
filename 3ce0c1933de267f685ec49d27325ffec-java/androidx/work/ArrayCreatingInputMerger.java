package androidx.work;

import androidx.work.d;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends h {
    private Object c(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj2.getClass(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        return newInstance;
    }

    private Object d(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    private Object e(Object obj, Object obj2) {
        Object newInstance = Array.newInstance(obj.getClass(), 2);
        Array.set(newInstance, 0, obj);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    private Object f(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }

    @Override // androidx.work.h
    public d b(List<d> list) {
        d.a aVar = new d.a();
        HashMap hashMap = new HashMap();
        for (d dVar : list) {
            for (Map.Entry<String, Object> entry : dVar.h().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj = hashMap.get(key);
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        if (cls2.isArray()) {
                            value = d(obj, value);
                        } else {
                            value = e(obj, value);
                        }
                    } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                        value = c(obj, value);
                    } else if (!cls.isArray() || !cls.getComponentType().equals(cls2)) {
                        throw new IllegalArgumentException();
                    } else {
                        value = c(value, obj);
                    }
                } else if (!cls.isArray()) {
                    value = f(value);
                }
                hashMap.put(key, value);
            }
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
