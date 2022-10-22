package com.huawei.hms.mlkit.common.ha;

import android.content.Context;
import com.huawei.hianalytics.scankit.HiAnalytics;
import com.huawei.hianalytics.scankit.HiAnalyticsConf;
import com.huawei.hianalytics.scankit.HiAnalyticsTools;
import java.util.LinkedHashMap;
import java.util.List;
/* compiled from: HianalyticsLogExecutor.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f14068a = new c();

    public static boolean a(Context context, List<String> list) {
        if (context == null || list.isEmpty()) {
            b.c("HaLogExecutor", "HianalyticsLogExecutor executeInitialize failed, context or haServiceUrls is empty.");
            return false;
        }
        HiAnalyticsTools.enableLog();
        new HiAnalyticsConf.Builder(context).setEnableImei(false).setEnableUUID(false).setCollectURL(1, list.get(0)).setCollectURL(0, list.get(0)).create();
        b.a("HaLogExecutor", "HianalyticsLogExecutor executeInitialize init success");
        return true;
    }

    public static void a(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        b.a("HaLogExecutor", "type " + i10 + " mapValue:" + linkedHashMap);
        HiAnalytics.onEvent(i10, str, linkedHashMap);
    }

    public static void a() {
        HiAnalytics.onReport();
    }
}
