package com.huawei.hianalytics.mn.pq;

import android.util.Pair;
import com.huawei.hianalytics.mn.mn.op;
import com.huawei.hianalytics.mn.no.op.no.qr;
import com.huawei.hianalytics.mn.no.pq.pq;
import com.huawei.hianalytics.mn.no.pq.st;
import com.huawei.hianalytics.mn.op.mn.no;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class mn extends pq {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hianalytics.mn.pq.mn$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: mn  reason: collision with root package name */
        static final /* synthetic */ int[] f13638mn;

        static {
            int[] iArr = new int[no.values().length];
            f13638mn = iArr;
            try {
                iArr[no.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13638mn[no.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13638mn[no.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static qr mn(List<com.huawei.hianalytics.mn.no.op.no.pq> list, String str, String str2, String str3, String str4) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "generate UploadData");
        qr mn2 = pq.mn();
        if (mn2 == null) {
            return null;
        }
        mn2.mn(no(st.mn().pq(), str, str2, str3));
        mn2.mn(op(str, str2));
        mn2.mn(no(str2, str, str4));
        mn2.mn(op.rs(str, str2));
        mn2.mn(list);
        return mn2;
    }

    protected static com.huawei.hianalytics.mn.qr.no no(String str, String str2, String str3, String str4) {
        com.huawei.hianalytics.mn.qr.no mn2 = pq.mn(str, str2, str3, str4);
        String mn3 = com.huawei.hianalytics.mn.op.no.mn.mn().mn(op.b(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String mn4 = com.huawei.hianalytics.mn.no.mn.no.mn().mn(com.huawei.hianalytics.mn.mn.no.qr() + mn3 + currentTimeMillis);
        mn2.no(String.valueOf(currentTimeMillis));
        mn2.st(mn4);
        return mn2;
    }

    protected static com.huawei.hianalytics.mn.qr.op no(String str, String str2, String str3) {
        com.huawei.hianalytics.mn.qr.op mn2 = pq.mn(str, str2, str3);
        Pair<String, String> no2 = com.huawei.hianalytics.mn.op.no.mn.mn().no(str2, str);
        mn2.rs((String) no2.first);
        mn2.st((String) no2.second);
        mn2.tu(com.huawei.hianalytics.mn.no.no.mn.no());
        mn2.qr(com.huawei.hianalytics.mn.op.no.mn.mn().rs(str2, str));
        return mn2;
    }

    protected static com.huawei.hianalytics.mn.qr.mn op(String str, String str2) {
        com.huawei.hianalytics.mn.qr.mn mn2 = pq.mn(str, str2);
        com.huawei.hianalytics.mn.op.mn.mn mn3 = com.huawei.hianalytics.mn.op.no.mn.mn().mn(str, str2);
        mn2.rs(com.huawei.hianalytics.mn.op.no.mn.mn().mn(op.b(str, str2)));
        mn2.pq(op.mn(str, str2));
        mn2.st(com.huawei.hianalytics.mn.op.no.mn.mn().op(str, str2));
        int i10 = AnonymousClass1.f13638mn[mn3.mn().ordinal()];
        if (i10 == 1) {
            mn2.op(mn3.no());
        } else if (i10 == 2) {
            mn2.no(mn3.no());
        } else if (i10 == 3) {
            mn2.qr(mn3.no());
        }
        return mn2;
    }

    public static Map<String, String> op(String str, String str2, String str3) {
        Map<String, String> no2 = pq.no(str, str3);
        Map<String, String> c10 = op.c(str, str2);
        if (c10 == null) {
            return no2;
        }
        no2.putAll(c10);
        return no2;
    }
}
