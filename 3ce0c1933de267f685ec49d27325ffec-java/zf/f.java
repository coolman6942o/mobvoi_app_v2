package zf;

import ag.d;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.ActivityType;
import java.util.List;
import qf.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataSessionSetter.java */
/* loaded from: classes2.dex */
public class f extends j<ActivityType, c, d> {
    private f(DbSyncAccessor<ActivityType, c> dbSyncAccessor) {
        super(dbSyncAccessor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f b(DbSyncAccessor<ActivityType, c> dbSyncAccessor) {
        return new f(dbSyncAccessor);
    }

    @Override // zf.j
    public void a(List<d> list) {
        for (d dVar : list) {
            c d10 = c.d(dVar);
            if (d10.e()) {
                this.f37407a.d(d10);
            }
        }
        this.f37407a.a();
    }
}
