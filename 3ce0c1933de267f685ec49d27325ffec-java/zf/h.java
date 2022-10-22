package zf;

import ag.g;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.List;
import qf.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataSetSetter.java */
/* loaded from: classes2.dex */
public class h extends j<DataType, a, g> {
    private h(DbSyncAccessor<DataType, a> dbSyncAccessor) {
        super(dbSyncAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h b(DbSyncAccessor<DataType, a> dbSyncAccessor) {
        return new h(dbSyncAccessor);
    }

    private List<a> c(g gVar) {
        ArrayList arrayList = new ArrayList();
        List<ag.a> list = gVar.points;
        if (list == null) {
            return arrayList;
        }
        for (ag.a aVar : list) {
            a d10 = a.d(gVar.wwid, gVar.device_id, gVar.type, aVar);
            if (d10.g()) {
                arrayList.add(d10);
            }
        }
        return arrayList;
    }

    @Override // zf.j
    public void a(List<g> list) {
        for (g gVar : list) {
            this.f37407a.k(c(gVar));
        }
        this.f37407a.a();
    }
}
