package m3;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public final class d implements i, j {
    @Override // m3.j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // m3.i, m3.j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    @Override // m3.i
    public final Object b(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }
}
