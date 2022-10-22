package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;
/* compiled from: Intrinsics.java */
/* loaded from: classes3.dex */
public class i {
    private i() {
    }

    public static boolean a(float f10, Float f11) {
        return f11 != null && f10 == f11.floatValue();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) l(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void d(Object obj) {
        if (obj == null) {
            o();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) l(new NullPointerException(str + " must not be null")));
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            q(str);
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static int h(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    private static String i(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void j() {
        r();
    }

    public static void k(int i10, String str) {
        r();
    }

    private static <T extends Throwable> T l(T t10) {
        return (T) m(t10, i.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T m(T t10, String str) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        t10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return t10;
    }

    public static String n(String str, Object obj) {
        return str + obj;
    }

    public static void o() {
        throw ((NullPointerException) l(new NullPointerException()));
    }

    private static void p(String str) {
        throw ((IllegalArgumentException) l(new IllegalArgumentException(i(str))));
    }

    private static void q(String str) {
        throw ((NullPointerException) l(new NullPointerException(i(str))));
    }

    public static void r() {
        s("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void s(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void t(String str) {
        throw ((UninitializedPropertyAccessException) l(new UninitializedPropertyAccessException(str)));
    }

    public static void u(String str) {
        t("lateinit property " + str + " has not been initialized");
    }
}
