package pk;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.DbSyncAccessor;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import xj.a;
import yj.e;
/* compiled from: SleepResultHandler.java */
/* loaded from: classes2.dex */
public class p0 extends a<List<v>, s0> {

    /* renamed from: b  reason: collision with root package name */
    private final a f32816b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0() {
        this(e.f().g());
    }

    private SleepRecord d(s0 s0Var) {
        List<SleepRecord> list;
        if (!(s0Var == null || (list = s0Var.f32831a) == null || list.size() <= 0)) {
            SleepRecord sleepRecord = s0Var.f32831a.get(0);
            Collection<SleepRecord> b10 = this.f32816b.b(sleepRecord.f20740d, sleepRecord.f20741e + 1, 2);
            if (!b10.isEmpty() && b10.size() != 0) {
                Iterator<SleepRecord> it = b10.iterator();
                if (it.hasNext()) {
                    return it.next();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void b(s0 s0Var) {
        SleepRecord d10 = d(s0Var);
        if (d10 != null) {
            try {
                SleepRecord sleepRecord = s0Var.f32831a.get(0);
                sleepRecord.f20737a = d10.f20737a;
                k.d("SleepResultHandler", "开始更新SleepRecord:");
                this.f32816b.a(sleepRecord);
            } catch (DbSyncAccessor.TimeOverlapException e10) {
                k.e("SleepResultHandler", "Update sleep record error", e10);
            }
            for (e eVar : s0Var.f32832b) {
                k.d("SleepResultHandler", "开始更新SleepDepth");
                if (eVar != null) {
                    try {
                        this.f32816b.c(eVar, this.f32776a.getDeviceId());
                    } catch (DbSyncAccessor.TimeOverlapException e11) {
                        k.e("SleepResultHandler", "Update point error", e11);
                    }
                }
            }
        } else {
            for (SleepRecord sleepRecord2 : s0Var.f32831a) {
                k.d("SleepResultHandler", "开始插入SleepRecord:");
                try {
                    this.f32816b.a(sleepRecord2);
                } catch (DbSyncAccessor.TimeOverlapException e12) {
                    k.e("SleepResultHandler", "Insert sleep record error", e12);
                }
            }
            for (e eVar2 : s0Var.f32832b) {
                k.d("SleepResultHandler", "开始插入SleepDepth");
                try {
                    this.f32816b.c(eVar2, this.f32776a.getDeviceId());
                } catch (DbSyncAccessor.TimeOverlapException e13) {
                    k.e("SleepResultHandler", "Insert point error", e13);
                }
            }
        }
        k.d("SleepResultHandler", "插入Over");
    }

    public p0(a aVar) {
        super(new o0());
        this.f32816b = aVar;
    }
}
