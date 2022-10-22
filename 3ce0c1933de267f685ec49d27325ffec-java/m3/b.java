package m3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.a;
/* loaded from: classes.dex */
public final class b implements i, j {
    public static Collection<Object> c(Class<?> cls, Type type) {
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class);
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception unused) {
            throw new IllegalArgumentException("create instane error, class " + cls.getName());
        }
    }

    @Override // m3.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            arrayList.add(f.b(obj2));
        }
        return arrayList;
    }

    @Override // m3.i, m3.j
    public final boolean a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }

    @Override // m3.i
    public final Object b(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        Collection<Object> c10 = c(n3.a.a(type), type);
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            for (int i10 = 0; i10 < aVar.a(); i10++) {
                c10.add(e.a(aVar.a(i10), type2));
            }
            return c10;
        }
        throw new IllegalArgumentException("Does not support the implement for generics.");
    }
}
