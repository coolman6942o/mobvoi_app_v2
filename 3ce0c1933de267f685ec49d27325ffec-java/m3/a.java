package m3;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a implements i, j {
    @Override // m3.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(f.b(obj2));
        }
        return arrayList;
    }

    @Override // m3.i, m3.j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }

    @Override // m3.i
    public final Object b(Object obj, Type type) {
        if (!obj.getClass().equals(org.json.alipay.a.class)) {
            return null;
        }
        org.json.alipay.a aVar = (org.json.alipay.a) obj;
        if (!(type instanceof GenericArrayType)) {
            Class<?> componentType = ((Class) type).getComponentType();
            int a10 = aVar.a();
            Object newInstance = Array.newInstance(componentType, a10);
            for (int i10 = 0; i10 < a10; i10++) {
                Array.set(newInstance, i10, e.a(aVar.a(i10), componentType));
            }
            return newInstance;
        }
        throw new IllegalArgumentException("Does not support generic array!");
    }
}
