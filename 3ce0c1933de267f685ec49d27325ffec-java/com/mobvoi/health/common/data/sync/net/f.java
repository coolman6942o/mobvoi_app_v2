package com.mobvoi.health.common.data.sync.net;

import ag.g;
import android.text.TextUtils;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import retrofit2.Call;
import retrofit2.Response;
import uf.a;
import vf.b;
import wf.h;
import wf.k;
import wf.m;
/* compiled from: GetDataSetApiService.java */
/* loaded from: classes2.dex */
public class f extends d<ag.f, g> {
    public f(of.g gVar) {
        super(gVar);
    }

    private Call<k> i(a aVar, ag.f fVar) {
        if (fVar.type == null) {
            return ((b) aVar.a(b.class)).e("derived:com.mobvoi.fitness", fVar.wwid, fVar.time_from.longValue(), fVar.time_to.longValue());
        }
        return ((b) aVar.a(b.class)).b("derived:com.mobvoi.fitness", fVar.wwid, fVar.time_from.longValue(), fVar.time_to.longValue(), DataType.from(fVar.type.intValue()).name);
    }

    private Call<k> j(a aVar, ag.f fVar) {
        if (fVar.type == null) {
            return ((b) aVar.a(b.class)).c("derived:com.mobvoi.fitness", fVar.time_from.longValue(), fVar.time_to.longValue());
        }
        return ((b) aVar.a(b.class)).d("derived:com.mobvoi.fitness", fVar.time_from.longValue(), fVar.time_to.longValue(), DataType.from(fVar.type.intValue()).name);
    }

    private static List<g> k(a aVar, h hVar, ag.f fVar) {
        com.mobvoi.android.common.utils.k.h("health.net.dataSet", " dataSet.data_source_name = " + hVar.data_source_name);
        m e10 = aVar.e(hVar.data_source_name, fVar);
        if (e10 == null || TextUtils.isEmpty(e10.f36231id) || e10.f36231id.equals("unknown")) {
            com.mobvoi.android.common.utils.k.s("health.net.dataSet", "Bad device found: %s, ignore the data set: %s", e10, hVar.data_source_name);
            return Collections.emptyList();
        }
        TreeMap treeMap = new TreeMap();
        for (h.a aVar2 : hVar.points) {
            DataType from = DataType.from(aVar2.data_type);
            g gVar = (g) treeMap.get(from);
            if (gVar == null) {
                gVar = new g();
                gVar.wwid = fVar.wwid;
                gVar.device_id = e10.f36231id;
                gVar.type = from.typeCode;
                gVar.points = new ArrayList();
                treeMap.put(from, gVar);
            }
            ag.a b10 = ag.a.b(aVar2);
            gVar.points.add(b10);
            long j10 = gVar.time_from;
            if (j10 == 0 || b10.time_from < j10) {
                gVar.time_from = b10.time_from;
            }
            long j11 = gVar.time_to;
            if (j11 == 0 || b10.time_to > j11) {
                gVar.time_to = b10.time_to;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (g gVar2 : treeMap.values()) {
            arrayList.add(gVar2);
        }
        return arrayList;
    }

    @Override // com.mobvoi.health.common.data.sync.net.d
    protected List<g> e(a aVar, List<ag.f> list) throws Throwable {
        Call<k> call;
        List<h> list2;
        ArrayList arrayList = new ArrayList();
        for (ag.f fVar : list) {
            com.mobvoi.android.common.utils.k.h("health.net.dataSet", " doCall healthServer.getIsRequestTiccare() = " + aVar.b());
            if (aVar.b()) {
                call = i(aVar, fVar);
            } else {
                call = j(aVar, fVar);
            }
            Response<k> execute = call.execute();
            if (execute.isSuccessful()) {
                k body = execute.body();
                if (body == null || (list2 = body.data_sets) == null) {
                    throw new ServerSyncException(execute.message(), execute.code());
                }
                for (h hVar : list2) {
                    arrayList.addAll(k(aVar, hVar, fVar));
                }
            } else {
                throw new ServerSyncException(execute.message(), execute.code());
            }
        }
        return arrayList;
    }
}
