package com.mobvoi.android.common.utils;

import android.os.Build;
import android.util.Log;
import com.mobvoi.wear.common.base.Constants;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
/* compiled from: LogUtil.java */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15451a = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogUtil.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static boolean f15452a = !Build.TYPE.equals(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);

        /* renamed from: b  reason: collision with root package name */
        private static g f15453b;

        public static boolean a() {
            return f15452a;
        }

        private static boolean b(String str, int i10) {
            try {
                if (!Log.isLoggable(str, i10)) {
                    if (!Log.isLoggable("MobvoiGlobalDebug", i10)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e10) {
                if (!f15452a) {
                    Log.e(str, "Can't detect is loggable.", e10);
                    return false;
                }
                throw e10;
            }
        }

        public static void c(int i10, String str, String str2, Throwable th2, Object... objArr) {
            if (h(i10, str)) {
                if (objArr != null && objArr.length > 0) {
                    str2 = String.format(Locale.US, str2, objArr);
                }
                d(i10, str, str2, th2);
            }
        }

        private static void d(int i10, String str, String str2, Throwable th2) {
            if (th2 == null) {
                Log.println(i10, str, str2);
            } else {
                Log.println(i10, str, str2 + '\n' + k.g(th2));
            }
            e(str, str2, th2);
        }

        private static void e(String str, String str2, Throwable th2) {
            g gVar;
            if (f15452a && (gVar = f15453b) != null) {
                gVar.d(str, str2, th2);
            }
        }

        public static void f(boolean z10) {
            g gVar;
            f15452a = z10;
            if (!z10 && (gVar = f15453b) != null) {
                gVar.a();
            }
        }

        public static void g(g gVar) {
            f15453b = gVar;
        }

        private static boolean h(int i10, String str) {
            return b(str, i10) || f15452a;
        }
    }

    public static void a(String str, String str2) {
        l(3, str, str2, null, new Object[0]);
    }

    public static void b(String str, String str2, Throwable th2) {
        l(3, str, str2, th2, new Object[0]);
    }

    public static void c(String str, String str2, Object... objArr) {
        l(3, str, str2, null, objArr);
    }

    public static void d(String str, String str2) {
        l(6, str, str2, null, new Object[0]);
    }

    public static void e(String str, String str2, Throwable th2) {
        l(6, str, str2, th2, new Object[0]);
    }

    public static void f(String str, String str2, Object... objArr) {
        l(6, str, str2, null, objArr);
    }

    public static String g(Throwable th2) {
        StringWriter stringWriter = new StringWriter(4096);
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void h(String str, String str2) {
        l(4, str, str2, null, new Object[0]);
    }

    public static void i(String str, String str2, Object... objArr) {
        l(4, str, str2, null, objArr);
    }

    public static boolean j() {
        return f15451a || a.a();
    }

    public static boolean k() {
        return f15451a;
    }

    public static void l(int i10, String str, String str2, Throwable th2, Object... objArr) {
        if (f15451a) {
            if (objArr != null && objArr.length > 0) {
                str2 = String.format(Locale.US, str2, objArr);
            }
            PrintStream printStream = System.out;
            printStream.println("[" + str + "] " + str2);
            if (th2 != null) {
                th2.printStackTrace();
                return;
            }
            return;
        }
        a.c(i10, str, str2, th2, objArr);
    }

    public static void m(boolean z10) {
        if (!f15451a) {
            a.f(z10);
        }
    }

    public static void n(g gVar) {
        if (!f15451a) {
            a.g(gVar);
        }
    }

    public static void o(String str, String str2) {
        l(2, str, str2, null, new Object[0]);
    }

    public static void p(String str, String str2, Object... objArr) {
        l(2, str, str2, null, objArr);
    }

    public static void q(String str, String str2) {
        l(5, str, str2, null, new Object[0]);
    }

    public static void r(String str, String str2, Throwable th2, Object... objArr) {
        l(5, str, str2, th2, objArr);
    }

    public static void s(String str, String str2, Object... objArr) {
        l(5, str, str2, null, objArr);
    }
}
