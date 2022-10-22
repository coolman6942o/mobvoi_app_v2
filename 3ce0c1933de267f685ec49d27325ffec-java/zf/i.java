package zf;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import eg.f;
import java.lang.Enum;
import java.util.Iterator;
import java.util.List;
import qf.b;
import xf.c;
import yf.c;
/* compiled from: DataSyncGetter.java */
/* loaded from: classes2.dex */
abstract class i<Type extends Enum<Type> & c, Data extends b<Type>, DataSync extends yf.c, DataIdentify extends yf.c, DataSearch extends yf.c> {

    /* renamed from: a  reason: collision with root package name */
    private final DbSyncAccessor<Type, Data> f37406a;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(DbSyncAccessor<Type, Data> dbSyncAccessor) {
        this.f37406a = dbSyncAccessor;
    }

    /* JADX WARN: Incorrect types in method signature: (TType;J)Ljava/util/List<TDataSync;>; */
    public List a(Enum r52, long j10) {
        List<Data> f10 = this.f37406a.f(r52, j10);
        k.c("health.sync.db_getter", "find %d data unsynced", Integer.valueOf(f10.size()));
        if (f.a.c()) {
            Iterator<Data> it = f10.iterator();
            while (it.hasNext()) {
                k.p("health.sync.db_getter", "unsynced: %s", it.next());
            }
        }
        return d(f10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DbSyncAccessor<Type, Data> b() {
        return this.f37406a;
    }

    public abstract void c(List<DataIdentify> list);

    protected abstract List<DataSync> d(List<Data> list);
}
