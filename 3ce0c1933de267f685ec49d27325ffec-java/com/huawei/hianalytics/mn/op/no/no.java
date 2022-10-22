package com.huawei.hianalytics.mn.op.no;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.op.mn.pq;
import com.huawei.hianalytics.mn.op.mn.mn;
/* loaded from: classes.dex */
public abstract class no {
    private mn mn(int i10, Context context) {
        String str;
        if ((i10 & 4) != 0 && (i10 & 1) != 0) {
            return new mn(com.huawei.hianalytics.mn.op.mn.no.UDID, mn(no(context)));
        }
        if ((i10 & 1) != 0) {
            str = no(context);
            if (!TextUtils.isEmpty(str)) {
                return new mn(com.huawei.hianalytics.mn.op.mn.no.SN, str);
            }
        } else {
            str = "";
        }
        if ((i10 & 2) == 0) {
            return new mn(com.huawei.hianalytics.mn.op.mn.no.EMPTY, str);
        }
        return new mn(com.huawei.hianalytics.mn.op.mn.no.IMEI, op(context));
    }

    private mn no(int i10, Context context) {
        String str;
        if (i10 != 0) {
            str = rs();
            if (!TextUtils.isEmpty(str)) {
                return new mn(com.huawei.hianalytics.mn.op.mn.no.UDID, str);
            }
        } else {
            str = "";
        }
        if ((i10 & 2) != 0) {
            str = op(context);
            if (!TextUtils.isEmpty(str)) {
                return new mn(com.huawei.hianalytics.mn.op.mn.no.IMEI, str);
            }
        }
        if ((i10 & 1) == 0) {
            return new mn(com.huawei.hianalytics.mn.op.mn.no.EMPTY, str);
        }
        return new mn(com.huawei.hianalytics.mn.op.mn.no.SN, no(context));
    }

    private String no(Context context) {
        pq op2 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op();
        if (TextUtils.isEmpty(op2.pq())) {
            op2.mn(op.rs(context));
        }
        return op2.pq();
    }

    private String op(Context context) {
        pq op2 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op();
        if (TextUtils.isEmpty(op2.st())) {
            op2.pq(op.qr(context));
        }
        return op2.st();
    }

    private boolean qr() {
        pq op2 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op();
        if (TextUtils.isEmpty(op2.rs())) {
            op2.op(com.huawei.hianalytics.mn.no.no.mn.mn());
        }
        return !TextUtils.isEmpty(op2.rs());
    }

    private String rs() {
        pq op2 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op();
        if (TextUtils.isEmpty(op2.tu())) {
            op2.qr(op.op());
        }
        return op2.tu();
    }

    public mn mn(Context context) {
        String mn2 = mn();
        if (!TextUtils.isEmpty(mn2)) {
            return new mn(com.huawei.hianalytics.mn.op.mn.no.UDID, mn2);
        }
        String no2 = no();
        if (!TextUtils.isEmpty(no2)) {
            return new mn(com.huawei.hianalytics.mn.op.mn.no.IMEI, no2);
        }
        boolean qr = qr();
        String op2 = op();
        return !TextUtils.isEmpty(op2) ? qr ? new mn(com.huawei.hianalytics.mn.op.mn.no.SN, op2) : new mn(com.huawei.hianalytics.mn.op.mn.no.UDID, mn(op2)) : qr ? no(pq(), context) : mn(pq(), context);
    }

    public abstract String mn();

    public abstract String mn(String str);

    public abstract String no();

    public abstract String op();

    public abstract int pq();
}
