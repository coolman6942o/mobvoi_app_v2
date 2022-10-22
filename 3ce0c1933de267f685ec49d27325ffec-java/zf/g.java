package zf;

import ag.e;
import ag.f;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import qf.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataSetGetter.java */
/* loaded from: classes2.dex */
public class g extends i<DataType, a, ag.g, e, f> {
    private g(DbSyncAccessor<DataType, a> dbSyncAccessor) {
        super(dbSyncAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g e(DbSyncAccessor<DataType, a> dbSyncAccessor) {
        return new g(dbSyncAccessor);
    }

    @Override // zf.i
    public void c(List<e> list) {
        for (e eVar : list) {
            b().e(DataType.from(eVar.type), eVar.time_from, eVar.time_to);
        }
    }

    @Override // zf.i
    protected List<ag.g> d(List<a> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        TreeMap treeMap = new TreeMap();
        for (a aVar : list) {
            String str = aVar.f33125a + String.valueOf(aVar.f33127c);
            ag.g gVar = (ag.g) treeMap.get(str);
            if (gVar == null) {
                gVar = new ag.g();
                gVar.device_id = aVar.f33125a;
                gVar.type = aVar.f33127c;
                gVar.time_from = Long.MAX_VALUE;
                gVar.points = new ArrayList();
                treeMap.put(str, gVar);
            }
            gVar.wwid = aVar.f33126b;
            long j10 = aVar.f33128d;
            if (j10 < gVar.time_from) {
                gVar.time_from = j10;
            }
            if (j10 >= gVar.time_to) {
                gVar.time_to = j10 + 1;
            }
            gVar.points.add(ag.a.a(aVar));
        }
        return new ArrayList(treeMap.values());
    }
}
