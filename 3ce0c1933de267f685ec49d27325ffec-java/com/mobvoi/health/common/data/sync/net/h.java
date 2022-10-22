package com.mobvoi.health.common.data.sync.net;

import ag.b;
import ag.d;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.FeatureUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import of.g;
import retrofit2.Response;
import uf.a;
import wf.e;
import wf.f;
/* compiled from: PutDataSessionApiService.java */
/* loaded from: classes2.dex */
public class h extends d<d, b> {
    public h(g gVar) {
        super(gVar);
    }

    private void i(List<String> list, Map<String, b> map, List<b> list2) {
        for (String str : list) {
            b bVar = map.get(str);
            if (bVar != null) {
                list2.add(bVar);
            } else if (k.j()) {
                throw new RuntimeException("Unknown sid from server: " + str);
            }
        }
    }

    @Override // com.mobvoi.health.common.data.sync.net.d
    protected List<b> e(a aVar, List<d> list) throws Throwable {
        boolean isWatch = FeatureUtil.isWatch(com.mobvoi.android.common.utils.b.e());
        String wearDeviceId = SharedWearInfoHelper.getWearDeviceId(com.mobvoi.android.common.utils.b.e());
        HashMap hashMap = new HashMap(list.size());
        e eVar = new e();
        eVar.data_sessions = new ArrayList();
        for (d dVar : list) {
            String c10 = aVar.c(dVar.device_id);
            if (TextUtils.isEmpty(c10)) {
                k.s("health.sync.PutSession", "No valid data source found for device[%s], skip sync the data", dVar.device_id);
            } else if (!isWatch || wearDeviceId == null || wearDeviceId.equals(dVar.device_id)) {
                eVar.data_sessions.add(wf.d.a(c10, dVar));
                b a10 = b.a(dVar);
                hashMap.put(a10.sid, a10);
            } else {
                k.s("health.sync.PutSession", "data source changed, skip sync the data. current id %s, sync id %s", wearDeviceId, dVar.device_id);
            }
        }
        Response<f> execute = ((vf.a) aVar.a(vf.a.class)).c("derived:com.mobvoi.fitness", eVar).execute();
        if (execute.isSuccessful()) {
            f body = execute.body();
            if (body != null) {
                ArrayList arrayList = new ArrayList();
                List<String> list2 = body.success_session_ids;
                if (list2 != null) {
                    i(list2, hashMap, arrayList);
                }
                List<String> list3 = body.repeat_session_ids;
                if (list3 != null) {
                    i(list3, hashMap, arrayList);
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
                throw new ServerSyncException(body.err_msg, body.err_code);
            }
            throw new ServerSyncException(execute.message(), execute.code());
        }
        throw new ServerSyncException(execute.message(), execute.code());
    }
}
