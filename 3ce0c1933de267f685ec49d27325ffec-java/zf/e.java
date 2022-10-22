package zf;

import ag.b;
import ag.d;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.ActivityType;
import java.util.ArrayList;
import java.util.List;
import qf.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataSessionGetter.java */
/* loaded from: classes2.dex */
public class e extends i<ActivityType, c, d, b, ag.c> {
    private e(DbSyncAccessor<ActivityType, c> dbSyncAccessor) {
        super(dbSyncAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e e(DbSyncAccessor<ActivityType, c> dbSyncAccessor) {
        return new e(dbSyncAccessor);
    }

    @Override // zf.i
    public void c(List<b> list) {
        for (b bVar : list) {
            ((com.mobvoi.health.common.data.db.b) b()).p(bVar.sid);
        }
    }

    @Override // zf.i
    protected List<d> d(List<c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            arrayList.add(d.b(cVar));
        }
        return arrayList;
    }
}
