package com.huawei.hianalytics.mn.mn;

import com.huawei.hianalytics.mn.no.op.mn.mn;
import com.huawei.hianalytics.mn.no.op.mn.qr;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class op {
    public static boolean a(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.f();
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.d();
        }
        return true;
    }

    public static Map<String, String> c(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.mn();
        }
        return null;
    }

    public static String d(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.g() : "";
    }

    public static long e(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.h();
        }
        return 0L;
    }

    private static com.huawei.hianalytics.mn.no.op.mn.op f(String str, String str2) {
        qr mn2 = mn.mn().mn(str);
        if (mn2 == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return mn2.mn(str2);
        }
        com.huawei.hianalytics.mn.no.op.mn.op mn3 = mn2.mn("oper");
        return mn3 == null ? mn2.mn("maint") : mn3;
    }

    public static String mn(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.c() : "";
    }

    public static void mn(String str, String str2, long j10) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            f10.mn(j10);
        }
    }

    public static String no(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.st() : "";
    }

    public static String op(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.tu() : "";
    }

    public static String pq(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.uv() : "";
    }

    public static String qr(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.a() : "";
    }

    public static String rs(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        return f10 != null ? f10.b() : "";
    }

    public static int st(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.op();
        }
        return 7;
    }

    public static int tu(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.pq();
        }
        return 10;
    }

    public static boolean uv(String str, String str2) {
        com.huawei.hianalytics.mn.no.op.mn.op f10 = f(str, str2);
        if (f10 != null) {
            return f10.e();
        }
        return true;
    }
}
