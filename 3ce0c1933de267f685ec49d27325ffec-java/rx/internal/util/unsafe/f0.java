package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* compiled from: UnsafeAccess.java */
/* loaded from: classes3.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Unsafe f34169a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34170b;

    static {
        f34170b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f34169a = unsafe;
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f34169a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e10) {
            InternalError internalError = new InternalError();
            internalError.initCause(e10);
            throw internalError;
        }
    }

    public static boolean b() {
        return f34169a != null && !f34170b;
    }
}
