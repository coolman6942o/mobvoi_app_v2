package com.huawei.hianalytics.mn.mn;

import com.huawei.hianalytics.mn.no.op.mn.no;
import com.huawei.hianalytics.mn.no.op.mn.op;
import com.huawei.hianalytics.mn.no.op.mn.qr;
/* loaded from: classes.dex */
public abstract class mn {
    public static boolean a(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null && b10.no();
    }

    private static no b(String str, String str2) {
        op mn2;
        qr mn3 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().mn(str);
        if (mn3 == null || (mn2 = mn3.mn(str2)) == null) {
            return null;
        }
        return mn2.no();
    }

    public static String mn(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null ? b10.qr() : "";
    }

    public static String no(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null ? b10.rs() : "";
    }

    public static String op(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null ? b10.st() : "";
    }

    public static String pq(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null ? b10.tu() : "";
    }

    public static boolean qr(String str, String str2) {
        op mn2;
        qr mn3 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().mn(str);
        if (mn3 == null || (mn2 = mn3.mn(str2)) == null) {
            return false;
        }
        return mn2.qr();
    }

    public static boolean rs(String str, String str2) {
        op mn2;
        qr mn3 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().mn(str);
        if (mn3 == null || (mn2 = mn3.mn(str2)) == null) {
            return false;
        }
        return mn2.rs();
    }

    public static boolean st(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null && b10.mn();
    }

    public static boolean tu(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null && b10.op();
    }

    public static boolean uv(String str, String str2) {
        no b10 = b(str, str2);
        return b10 != null && b10.pq();
    }
}
