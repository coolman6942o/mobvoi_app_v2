package com.huawei.hianalytics.mn.rs;

import android.content.Context;
import com.huawei.hianalytics.mn.no.b.op;
/* loaded from: classes.dex */
public final class mn {

    /* renamed from: mn  reason: collision with root package name */
    private static final String[] f13641mn = {"ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag"};

    /* renamed from: no  reason: collision with root package name */
    private static mn f13642no = null;

    /* renamed from: op  reason: collision with root package name */
    private static final Object f13643op = new Object();
    private Context pq;

    private mn() {
    }

    public static mn mn() {
        if (f13642no == null) {
            op();
        }
        return f13642no;
    }

    private static synchronized void op() {
        synchronized (mn.class) {
            if (f13642no == null) {
                f13642no = new mn();
            }
        }
    }

    public final void mn(Context context) {
        synchronized (f13643op) {
            if (this.pq != null) {
                com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsDataManager", "DataManager already initialized.");
                return;
            }
            this.pq = context;
            com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().mn(this.pq);
            com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().st(context.getPackageName());
            com.huawei.hianalytics.mn.op.no.mn.mn().mn(context);
        }
    }

    public final void mn(String str) {
        if (this.pq == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsDataManager", "clearDataByTag() sdk is not init");
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearDataByTag(String appid) is execute.");
        com.huawei.hianalytics.mn.no.uv.mn.op(this.pq, str);
    }

    public final void no() {
        com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsDataManager", "clearCachedData() is execute.");
        if (this.pq == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("HiAnalyticsDataManager", "clearCachedData() sdk is not init");
            return;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("HiAnalyticsDataManager", "HiAnalyticsDataManager.clearCachedData() is execute.");
        com.huawei.hianalytics.mn.no.uv.mn.mn(this.pq, "stat_v2_1", new String[0]);
        com.huawei.hianalytics.mn.no.uv.mn.mn(this.pq, "cached_v2_1", new String[0]);
    }

    public final void no(String str) {
        com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.pq;
        if (context == null) {
            com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "sdk is not init");
            return;
        }
        com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().tu(op.mn("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
