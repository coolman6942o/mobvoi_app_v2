package a4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import t3.a;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f85a;

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format("[%s][%s]", str, str2);
    }

    public static void b(String str) {
        try {
            a aVar = f85a;
            if (aVar != null) {
                aVar.a(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        String a10 = a(str, str2);
        b(a10 + " " + e(th2));
    }

    public static void d(Throwable th2) {
        if (th2 != null) {
            try {
                b(e(th2));
            } catch (Throwable unused) {
            }
        }
    }

    public static String e(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(String str, String str2) {
        b(a(str, str2));
    }

    public static void g(String str, String str2) {
        b(a(str, str2));
    }

    public static void h(String str, String str2) {
        b(a(str, str2));
    }

    public static void i(String str, String str2) {
        b(a(str, str2));
    }
}
