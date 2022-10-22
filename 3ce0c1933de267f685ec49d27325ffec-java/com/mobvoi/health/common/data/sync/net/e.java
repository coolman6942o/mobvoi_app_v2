package com.mobvoi.health.common.data.sync.net;

import ag.c;
import ag.d;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.ActivityType;
import java.util.ArrayList;
import java.util.List;
import of.g;
import retrofit2.Call;
import retrofit2.Response;
import uf.a;
import wf.m;
/* compiled from: GetDataSessionApiService.java */
/* loaded from: classes2.dex */
public class e extends d<c, d> {
    public e(g gVar) {
        super(gVar);
    }

    private Call<wf.g> i(a aVar, c cVar) {
        if (cVar.activity == null) {
            return ((vf.a) aVar.a(vf.a.class)).b("derived:com.mobvoi.fitness", cVar.wwid, cVar.time_from.longValue(), cVar.time_to.longValue());
        }
        return ((vf.a) aVar.a(vf.a.class)).a("derived:com.mobvoi.fitness", cVar.wwid, cVar.time_from.longValue(), cVar.time_to.longValue(), ActivityType.from(cVar.activity.intValue()).name);
    }

    private Call<wf.g> j(a aVar, c cVar) {
        if (cVar.activity == null) {
            return ((vf.a) aVar.a(vf.a.class)).d("derived:com.mobvoi.fitness", cVar.time_from.longValue(), cVar.time_to.longValue());
        }
        return ((vf.a) aVar.a(vf.a.class)).e("derived:com.mobvoi.fitness", cVar.time_from.longValue(), cVar.time_to.longValue(), ActivityType.from(cVar.activity.intValue()).name);
    }

    private static List<d> k(a aVar, List<wf.d> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (wf.d dVar : list) {
            k.h("health.net.dataSession", " session.data_source_name = " + dVar.data_source_name);
            m e10 = aVar.e(dVar.data_source_name, cVar);
            if (e10 == null || TextUtils.isEmpty(e10.f36231id) || e10.f36231id.equals("unknown")) {
                k.s("health.net.dataSession", "Bad device found: %s, ignore the data session: %s", e10, dVar.data_source_name);
            } else {
                arrayList.add(d.a(cVar.wwid, e10.f36231id, ActivityType.from(dVar.activity_type).typeCode, dVar));
            }
        }
        return arrayList;
    }

    @Override // com.mobvoi.health.common.data.sync.net.d
    protected List<d> e(a aVar, List<c> list) throws Throwable {
        Call<wf.g> call;
        List<wf.d> list2;
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            if (aVar.b()) {
                call = i(aVar, cVar);
            } else {
                call = j(aVar, cVar);
            }
            Response<wf.g> execute = call.execute();
            if (execute.isSuccessful()) {
                wf.g body = execute.body();
                if (body == null || (list2 = body.data_sessions) == null) {
                    throw new ServerSyncException(execute.message(), execute.code());
                }
                arrayList.addAll(k(aVar, list2, cVar));
            } else {
                throw new ServerSyncException(execute.message(), execute.code());
            }
        }
        return arrayList;
    }
}
