package com.mobvoi.health.common.data.sync.net;

import ag.a;
import ag.e;
import ag.g;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.FeatureUtil;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;
import wf.h;
import wf.j;
/* compiled from: PutDataSetApiService.java */
/* loaded from: classes2.dex */
public class i extends d<g, e> {
    public i(of.g gVar) {
        super(gVar);
    }

    private boolean i(j jVar) {
        List<j.a> list = jVar.data_set_responses;
        if (list == null) {
            return false;
        }
        for (j.a aVar : list) {
            int i10 = aVar.err_code;
            if (!(i10 == 400102 || i10 == 400103)) {
                return false;
            }
        }
        return true;
    }

    private static h j(String str, g gVar) {
        h hVar = new h();
        hVar.data_source_name = str;
        List<a> list = gVar.points;
        if (list == null || list.isEmpty()) {
            hVar.points = new ArrayList();
            return hVar;
        }
        hVar.points = new ArrayList(gVar.points.size());
        for (a aVar : gVar.points) {
            h.a a10 = h.a.a(gVar.type, aVar);
            hVar.points.add(a10);
            long j10 = hVar.min_start_time_ms;
            if (j10 == 0 || a10.start_time_millis < j10) {
                hVar.min_start_time_ms = a10.start_time_millis;
            }
            long j11 = hVar.max_end_time_ms;
            if (j11 == 0 || a10.end_time_millis > j11) {
                hVar.max_end_time_ms = a10.end_time_millis;
            }
        }
        return hVar;
    }

    @Override // com.mobvoi.health.common.data.sync.net.d
    protected List<e> e(uf.a aVar, List<g> list) throws Throwable {
        boolean isWatch = FeatureUtil.isWatch(b.e());
        String wearDeviceId = SharedWearInfoHelper.getWearDeviceId(b.e());
        ArrayList arrayList = new ArrayList(list.size());
        wf.i iVar = new wf.i();
        iVar.data_sets = new ArrayList(list.size());
        for (g gVar : list) {
            String c10 = aVar.c(gVar.device_id);
            if (TextUtils.isEmpty(c10)) {
                k.s("health.sync.PutDataSet", "No valid data source found for device[%s], skip sync the data", gVar.device_id);
            } else if (!isWatch || wearDeviceId == null || wearDeviceId.equals(gVar.device_id)) {
                iVar.data_sets.add(j(c10, gVar));
                arrayList.add(e.a(gVar));
            } else {
                k.s("health.sync.PutDataSet", "data source changed, skip sync  data set. current id %s, sync id %s", wearDeviceId, gVar.device_id);
            }
        }
        Response<j> execute = ((vf.b) aVar.a(vf.b.class)).a("derived:com.mobvoi.fitness", iVar).execute();
        if (execute.isSuccessful()) {
            j body = execute.body();
            if (body != null && (body.a() || i(body))) {
                return arrayList;
            }
            if (body != null) {
                throw new ServerSyncException(body.err_msg, body.err_code);
            }
            throw new ServerSyncException(execute.message(), execute.code());
        }
        throw new ServerSyncException(execute.message(), execute.code());
    }
}
