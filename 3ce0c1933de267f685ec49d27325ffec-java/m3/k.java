package m3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;
/* loaded from: classes.dex */
public final class k implements i {
    @Override // m3.i, m3.j
    public final boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }

    @Override // m3.i
    public final Object b(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        HashSet hashSet = new HashSet();
        Class cls = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
        for (int i10 = 0; i10 < aVar.a(); i10++) {
            hashSet.add(e.a(aVar.a(i10), cls));
        }
        return hashSet;
    }
}
