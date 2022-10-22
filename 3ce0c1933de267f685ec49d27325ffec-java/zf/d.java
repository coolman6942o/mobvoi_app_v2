package zf;

import ag.b;
import ag.c;
import ag.e;
import ag.f;
import android.content.Context;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.sync.net.g;
import qf.a;
/* compiled from: ClientSyncerFactory.java */
/* loaded from: classes2.dex */
public class d {
    public static c<ag.d, b, c, ActivityType, qf.c> a(Context context, DbSyncAccessor<ActivityType, qf.c> dbSyncAccessor, g.a<ag.d, b> aVar, g.a<c, ag.d> aVar2, k kVar, k kVar2) {
        return new c<>(dbSyncAccessor, e.e(dbSyncAccessor), f.b(dbSyncAccessor), g.c(context, aVar), g.c(context, aVar2), kVar, kVar2);
    }

    public static c<ag.g, e, f, DataType, a> b(Context context, DbSyncAccessor<DataType, a> dbSyncAccessor, g.a<ag.g, e> aVar, g.a<f, ag.g> aVar2, k kVar, k kVar2) {
        return new c<>(dbSyncAccessor, g.e(dbSyncAccessor), h.b(dbSyncAccessor), g.c(context, aVar), g.c(context, aVar2), kVar, kVar2);
    }
}
