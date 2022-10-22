package r9;

import android.util.Log;
/* compiled from: FileDownloadLog.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33469a = false;

    public static void a(Object obj, String str, Object... objArr) {
        f(3, obj, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        f(6, obj, str, objArr);
    }

    public static void c(Object obj, Throwable th2, String str, Object... objArr) {
        g(6, obj, th2, str, objArr);
    }

    private static String d(Object obj) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FileDownloader.");
        sb2.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb2.toString();
    }

    public static void e(Object obj, String str, Object... objArr) {
        f(4, obj, str, objArr);
    }

    private static void f(int i10, Object obj, String str, Object... objArr) {
        g(i10, obj, null, str, objArr);
    }

    private static void g(int i10, Object obj, Throwable th2, String str, Object... objArr) {
        if ((i10 >= 5) || f33469a) {
            Log.println(i10, d(obj), e.n(str, objArr));
            if (th2 != null) {
                th2.printStackTrace();
            }
        }
    }

    public static void h(Object obj, String str, Object... objArr) {
        f(2, obj, str, objArr);
    }

    public static void i(Object obj, String str, Object... objArr) {
        f(5, obj, str, objArr);
    }
}
