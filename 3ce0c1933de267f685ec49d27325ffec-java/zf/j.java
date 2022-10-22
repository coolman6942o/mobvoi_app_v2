package zf;

import com.mobvoi.health.common.data.db.DbSyncAccessor;
import java.lang.Enum;
import java.util.List;
import qf.b;
import xf.c;
import yf.c;
/* compiled from: DataSyncSetter.java */
/* loaded from: classes2.dex */
abstract class j<Type extends Enum<Type> & c, Data extends b<Type>, DataSync extends yf.c> {

    /* renamed from: a  reason: collision with root package name */
    protected final DbSyncAccessor<Type, Data> f37407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(DbSyncAccessor<Type, Data> dbSyncAccessor) {
        this.f37407a = dbSyncAccessor;
    }

    public abstract void a(List<DataSync> list);
}
