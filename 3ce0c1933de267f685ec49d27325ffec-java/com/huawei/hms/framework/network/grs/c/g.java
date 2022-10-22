package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.grs.c.b.a;
import com.mobvoi.wear.util.ConnectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f13913a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f13914b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ArrayList f13915c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ JSONArray f13916d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(long j10, Context context, ArrayList arrayList, JSONArray jSONArray) {
        this.f13913a = j10;
        this.f13914b = context;
        this.f13915c = arrayList;
        this.f13916d = jSONArray;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        LinkedHashMap b10;
        LinkedHashMap<String, String> b11;
        LinkedHashMap<String, String> b12;
        a aVar = new a();
        aVar.put("total_time", this.f13913a);
        aVar.put(ConnectionUtils.KEY_TYPE, NetworkUtil.getNetworkType(this.f13914b));
        Iterator it = this.f13915c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            f fVar = (f) it.next();
            if (fVar.m()) {
                b12 = h.b(fVar);
                aVar.put(b12);
                it.remove();
                z10 = true;
                break;
            }
        }
        if (!z10 && this.f13915c.size() > 0) {
            ArrayList arrayList = this.f13915c;
            f fVar2 = (f) arrayList.get(arrayList.size() - 1);
            b11 = h.b(fVar2);
            aVar.put(b11);
            this.f13915c.remove(fVar2);
        }
        if (this.f13915c.size() > 0) {
            Iterator it2 = this.f13915c.iterator();
            while (it2.hasNext()) {
                b10 = h.b((f) it2.next());
                this.f13916d.put(new JSONObject(b10));
            }
        }
        if (this.f13916d.length() > 0) {
            aVar.put("failed_info", this.f13916d.toString());
        }
        Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
        HianalyticsHelper.getInstance().onEvent(aVar.get(), "networkkit_grs");
    }
}
