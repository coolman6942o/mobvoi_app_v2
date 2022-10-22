package il;

import android.text.TextUtils;
import hl.a;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f28329a = "Realtek";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f28330b = false;

    /* renamed from: c  reason: collision with root package name */
    public static int f28331c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f28332d;

    /* renamed from: e  reason: collision with root package name */
    public static a f28333e = new a();

    public static void a(int i10, String str, String str2) {
        if (f28333e != null) {
            int max = Math.max(i10, f28331c);
            int i11 = 6;
            if ((max & 6) != 6 || f28332d > 6) {
                i11 = 5;
                if ((max & 5) != 5 || f28332d > 5) {
                    i11 = 4;
                    if ((max & 4) != 4 || f28332d > 4) {
                        i11 = 3;
                        if ((max & 3) != 3 || f28332d > 3) {
                            i11 = 2;
                            if ((max & 2) != 2 || f28332d > 2) {
                                if ((max & 1) == 1 && f28332d <= 1) {
                                    f28333e.log(1, str, str2);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
            f28333e.log(i11, str, str2);
        }
    }

    public static void b(boolean z10, int i10, String str, Object obj) {
        String[] strArr;
        String[] split;
        if (z10) {
            Object[] objArr = {obj};
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length < 6) {
                strArr = null;
            } else {
                String className = stackTrace[5].getClassName();
                if (className.split("\\.").length > 0) {
                    className = split[split.length - 1] + ".java";
                }
                if (className.contains("$")) {
                    className = className.split("\\$")[0] + ".java";
                }
                String methodName = stackTrace[5].getMethodName();
                int lineNumber = stackTrace[5].getLineNumber();
                if (lineNumber < 0) {
                    lineNumber = 0;
                }
                String str2 = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
                String str3 = str == null ? className : str;
                if (TextUtils.isEmpty(str3)) {
                    str3 = f28329a;
                }
                strArr = new String[]{str3, objArr[0].toString(), String.format(Locale.US, "[ (%s:%d)#%s ]", className, Integer.valueOf(lineNumber), str2)};
            }
            if (strArr == null || strArr.length < 3) {
                a(i10, str, (String) obj);
                return;
            }
            String str4 = strArr[0];
            String str5 = strArr[1];
            a(i10, str4, strArr[2] + str5);
        }
    }

    public static void c(String str) {
        b(f28330b, 2, f28329a, str);
    }

    public static void d(boolean z10, String str) {
        b(z10, 2, f28329a, str);
    }

    public static void e(String str) {
        b(f28330b, 5, f28329a, str);
    }

    public static void f(boolean z10, String str) {
        b(z10, 5, f28329a, str);
    }

    public static void g(String str) {
        b(f28330b, 3, f28329a, str);
    }

    public static void h(boolean z10, String str) {
        b(z10, 3, f28329a, str);
    }

    public static void i(String str, boolean z10, int i10) {
        f28329a = str;
        f28330b = z10;
        f28331c = i10;
    }

    public static void j(String str) {
        b(f28330b, 1, f28329a, str);
    }

    public static void k(boolean z10, String str) {
        b(z10, 1, f28329a, str);
    }

    public static void l(String str) {
        b(f28330b, 4, f28329a, str);
    }

    public static void m(boolean z10, String str) {
        b(z10, 4, f28329a, str);
    }
}
