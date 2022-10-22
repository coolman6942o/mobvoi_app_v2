package o3;

import com.alipay.sdk.app.c;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31408a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f31409b;

    public static String a() {
        c b10 = c.b(c.CANCELED.b());
        return b(b10.b(), b10.a(), "");
    }

    public static String b(int i10, String str, String str2) {
        return "resultStatus={" + i10 + "};memo={" + str + "};result={" + str2 + "}";
    }

    public static void c(String str) {
        f31409b = str;
    }

    public static void d(boolean z10) {
        f31408a = z10;
    }

    public static String e() {
        c b10 = c.b(c.DOUBLE_REQUEST.b());
        return b(b10.b(), b10.a(), "");
    }

    public static boolean f() {
        return f31408a;
    }

    public static String g() {
        return f31409b;
    }

    public static String h() {
        c b10 = c.b(c.PARAMS_ERROR.b());
        return b(b10.b(), b10.a(), "");
    }
}
