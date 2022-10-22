package ln;

import tn.b;
/* compiled from: EntryPoints.java */
/* loaded from: classes2.dex */
public final class a {
    public static <T> T a(Object obj, Class<T> cls) {
        if (obj instanceof tn.a) {
            return cls.cast(obj);
        }
        if (obj instanceof b) {
            return (T) a(((b) obj).h(), cls);
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", obj.getClass(), tn.a.class, b.class));
    }
}
