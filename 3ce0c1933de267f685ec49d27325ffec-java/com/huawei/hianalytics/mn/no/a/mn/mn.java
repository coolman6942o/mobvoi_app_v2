package com.huawei.hianalytics.mn.no.a.mn;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.mn.op;
import com.huawei.hianalytics.mn.no.a.op.no;
import com.huawei.hianalytics.mn.no.b.qr;
import com.huawei.hianalytics.mn.no.b.st;
import com.huawei.hianalytics.mn.no.pq.rs;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.tendcloud.tenddata.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class mn {

    /* renamed from: mn  reason: collision with root package name */
    private static mn f13511mn;

    /* renamed from: op  reason: collision with root package name */
    private static Map<String, Long> f13512op = new HashMap();

    /* renamed from: no  reason: collision with root package name */
    private Context f13513no;

    public static mn mn() {
        return no();
    }

    private static void mn(String str, String str2, long j10, long j11, JSONObject jSONObject, String str3, String str4) {
        no.mn().mn(new com.huawei.hianalytics.mn.no.a.no.no(str3, qr.mn(jSONObject, str2, String.valueOf(j11), str4), str, "oper", j10));
    }

    private static synchronized mn no() {
        mn mnVar;
        synchronized (mn.class) {
            if (f13511mn == null) {
                f13511mn = new mn();
            }
            mnVar = f13511mn;
        }
        return mnVar;
    }

    private void no(Context context) {
        String str;
        String no2 = com.huawei.hianalytics.mn.no.no.mn.no(context);
        com.huawei.hianalytics.mn.mn.no.no(no2);
        if (st.mn().no()) {
            String no3 = com.huawei.hianalytics.mn.no.uv.mn.no(context, "global_v2", "app_ver", "");
            com.huawei.hianalytics.mn.no.uv.mn.mn(context, "global_v2", "app_ver", no2);
            com.huawei.hianalytics.mn.mn.no.op(no3);
            if (TextUtils.isEmpty(no3)) {
                str = "app ver is first save!";
            } else if (!no3.equals(no2)) {
                com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsEventServer", "the appVers are different!");
                mn().mn("", "alltype", no3);
                return;
            } else {
                return;
            }
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsEventServer", str);
    }

    private static void op(String str, String str2, String str3, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = 0;
        long longValue = f13512op.containsKey(str) ? f13512op.get(str).longValue() : 0L;
        j10 = currentTimeMillis - longValue;
        if (longValue != 0) {
        }
        mn(str, str3, currentTimeMillis, j10, jSONObject, str2, "OnPause");
    }

    public void mn(Context context) {
        this.f13513no = context;
        no(context);
        com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().op(com.huawei.hianalytics.mn.no.no.mn.mn());
    }

    public void mn(String str, int i10) {
        if (this.f13513no == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsEventServer", "onReport() null context or SDK was not init.");
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "onReport: Before calling runtaskhandler()");
        mn(str, qr.mn(i10), com.huawei.hianalytics.mn.mn.no.rs());
    }

    public void mn(String str, int i10, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i10) {
            currentTimeMillis = qr.mn(SettingConstants.DATE_FORMAT_DEFAULT, currentTimeMillis);
        }
        no.mn().mn(new com.huawei.hianalytics.mn.no.a.no.no(str2, jSONObject, str, qr.mn(i10), currentTimeMillis));
    }

    public void mn(String str, int i10, String str2, JSONObject jSONObject, long j10) {
        new rs(str, qr.mn(i10), str2, jSONObject.toString(), j10).mn();
    }

    public void mn(String str, String str2) {
        if (op.uv(str, str2)) {
            long e10 = op.e(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - e10 > ab.Y) {
                com.huawei.hianalytics.mn.no.qr.mn.mn("HiAnalyticsEventServer", "begin to call onReport!");
                op.mn(str, str2, currentTimeMillis);
                mn(str, str2, com.huawei.hianalytics.mn.mn.no.rs());
                return;
            }
            com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsEventServer", "autoReport timeout. interval < 30s ");
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsEventServer", "auto report is closed tag:".concat(String.valueOf(str)));
    }

    public void mn(String str, String str2, String str3) {
        if (op.a(str, str2)) {
            String mn2 = com.huawei.hianalytics.mn.no.no.op.mn(this.f13513no);
            if (!"WIFI".equals(mn2)) {
                com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsEventServer", "strNetworkType is :".concat(String.valueOf(mn2)));
                return;
            }
        }
        no.mn().mn(new com.huawei.hianalytics.mn.no.a.no.op(str, str2, str3));
    }

    public void mn(String str, String str2, String str3, JSONObject jSONObject) {
        if (this.f13513no == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsEventServer", "onPause null context or SDK was not init.");
            return;
        }
        op(str, str2, str3, jSONObject);
        f13512op.put(str, 0L);
    }

    public void mn(String str, String str2, JSONObject jSONObject) {
        mn(str, "$AppOnPause", str2, jSONObject);
    }

    public void no(String str, String str2, String str3, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        f13512op.put(str, Long.valueOf(currentTimeMillis));
        mn(str, str3, currentTimeMillis, 0L, jSONObject, str2, "OnResume");
    }

    public void no(String str, String str2, JSONObject jSONObject) {
        no(str, "$AppOnResume", str2, jSONObject);
    }
}
