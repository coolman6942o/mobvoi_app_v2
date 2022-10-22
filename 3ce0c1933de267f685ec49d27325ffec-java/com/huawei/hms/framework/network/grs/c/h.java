package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class h {
    public static void a(ArrayList<f> arrayList, long j10, JSONArray jSONArray, Context context) {
        if (context != null && arrayList != null && arrayList.size() > 0 && HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            HianalyticsHelper.getInstance().getReportExecutor().execute(new g(j10, context, arrayList, jSONArray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> b(f fVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception d10 = fVar.d();
        if (d10 != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(d10));
            linkedHashMapPack.put("exception_name", d10.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d10.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", fVar.b());
            linkedHashMapPack.put("exception_name", fVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(fVar.k()).getHost());
        } catch (MalformedURLException e10) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e10);
        }
        linkedHashMapPack.put("req_start_time", fVar.g());
        linkedHashMapPack.put("req_end_time", fVar.f());
        linkedHashMapPack.put("req_total_time", fVar.h());
        return linkedHashMapPack.getAll();
    }
}
