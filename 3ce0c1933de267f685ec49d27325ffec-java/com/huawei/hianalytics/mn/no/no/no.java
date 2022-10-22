package com.huawei.hianalytics.mn.no.no;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.mn.mn;
import com.huawei.hianalytics.mn.mn.op;
import com.huawei.hianalytics.mn.no.op.mn.pq;
/* loaded from: classes.dex */
public abstract class no {
    public static String mn(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(mn.op(str, str2))) {
            return mn.op(str, str2);
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "getAndroidId(): to getConfigByType()");
        return op(context, str, str2);
    }

    public static String no(Context context, String str, String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "getChannel(): Invalid type: ".concat(str2));
            return "";
        }
        return pq(context, str, str2);
    }

    private static String op(Context context, String str, String str2) {
        if (!mn.uv(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(com.huawei.hianalytics.mn.mn.no.op())) {
            com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().rs(mn.op(context));
        }
        return com.huawei.hianalytics.mn.mn.no.op();
    }

    private static String pq(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(op.no(str, str2))) {
            return op.no(str, str2);
        }
        pq op2 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op();
        if (TextUtils.isEmpty(op2.qr())) {
            String pq = mn.pq(context);
            if (!com.huawei.hianalytics.mn.no.b.op.mn("channel", pq, 256)) {
                pq = "";
            }
            op2.no(pq);
        }
        return op2.qr();
    }
}
