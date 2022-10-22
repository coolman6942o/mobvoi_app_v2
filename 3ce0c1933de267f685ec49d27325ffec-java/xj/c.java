package xj;

import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qf.a;
import qf.d;
import qf.e;
import qf.k;
import yj.b;
/* compiled from: SleepDbAccessorImpl.java */
/* loaded from: classes2.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final com.mobvoi.health.common.data.db.c f36579a;

    /* renamed from: b  reason: collision with root package name */
    private final k f36580b;

    /* renamed from: c  reason: collision with root package name */
    private final e f36581c;

    /* renamed from: d  reason: collision with root package name */
    private String f36582d = "";

    public c(com.mobvoi.health.common.data.db.c cVar, k kVar, e eVar) {
        this.f36579a = cVar;
        this.f36580b = kVar;
        this.f36581c = eVar;
    }

    private List<a> e(List<a> list) {
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            long j10 = aVar.f33129e;
            if (j10 != 0 && aVar.f33128d > j10) {
                linkedList.add(aVar);
            }
        }
        if (linkedList.isEmpty()) {
            return linkedList;
        }
        a[] aVarArr = (a[]) linkedList.toArray(new a[0]);
        Arrays.sort(aVarArr, b.f36578a);
        linkedList.clear();
        long j11 = aVarArr[0].f33128d;
        linkedList.add(aVarArr[0]);
        for (a aVar2 : aVarArr) {
            if (aVar2.f33129e >= j11) {
                linkedList.add(aVar2);
                j11 = aVar2.f33128d;
            }
        }
        return linkedList;
    }

    private List<a> g(long j10, long j11) {
        return this.f36579a.h(DataType.HeartRate, j10, j11);
    }

    private List<a> h(long j10, long j11, String str) {
        return this.f36579a.i(str, DataType.HeartRate, j10, j11);
    }

    private b i(long j10, boolean z10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar n10 = eg.c.n(calendar);
        n10.set(11, 4);
        long timeInMillis = n10.getTimeInMillis();
        n10.set(11, 12);
        long timeInMillis2 = n10.getTimeInMillis();
        List h10 = this.f36580b.h(ActivityType.AutoSleep, timeInMillis, timeInMillis2);
        long j11 = !h10.isEmpty() ? ((qf.c) h10.get(0)).f33128d : 0L;
        if (j11 != 0 || !z10 || j10 <= timeInMillis || j10 >= timeInMillis2) {
            j10 = j11;
        }
        if (j10 == 0) {
            return null;
        }
        List<a> g10 = g(j10, timeInMillis2);
        float e10 = g10.isEmpty() ? 0.0f : g10.get(0).e();
        if (e10 > 0.0f) {
            return new b(j10, e10);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int l(a aVar, a aVar2) {
        long j10 = aVar.f33128d;
        long j11 = aVar2.f33128d;
        return j10 != j11 ? Long.compare(j10, j11) : Long.compare(aVar.f33129e, aVar2.f33129e);
    }

    private SleepRecord o(qf.c cVar) {
        return p(cVar, 2);
    }

    private SleepRecord p(qf.c cVar, int i10) {
        com.mobvoi.android.common.utils.k.c("sleep.db", "Session to record for %s [%d, %d] in %d type, device_id is %s", cVar.f33133i, Long.valueOf(cVar.f33129e), Long.valueOf(cVar.f33128d), Integer.valueOf(i10), cVar.f33125a);
        SleepRecord.b C = new SleepRecord.b(cVar.f33133i).J(cVar.f33126b).t(cVar.f33125a).F(cVar.f33129e).v(cVar.f33128d).z(cVar.f33131g).C((cVar.f33130f & 1) != 0);
        d a10 = this.f36581c.a(cVar.f33125a);
        if (a10 != null) {
            com.mobvoi.android.common.utils.k.c("sleep.db", "data source: %s", a10);
            C.u(a10.f33138e);
        }
        long timeInMillis = eg.c.a(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1L)).getTimeInMillis();
        long j10 = cVar.f33129e;
        long j11 = cVar.f33128d;
        long j12 = j11 > 0 ? j11 : timeInMillis - 1;
        if (1 == i10) {
            if (j11 > 0) {
                C.D(SleepRecord.TimeType.InBed, j11 - j10);
            }
            return C.s();
        }
        List<a> e10 = e(this.f36579a.i(cVar.f33125a, DataType.Motion, j10, j12 + 1));
        if (!e10.isEmpty()) {
            ArrayList<yj.e> arrayList = new ArrayList();
            for (a aVar : e10) {
                float[] f10 = aVar.f();
                yj.e eVar = new yj.e(aVar.f33129e, aVar.f33128d, MotionType.from((int) f10[0]), f10.length > 1 ? MotionType.from((int) f10[1]) : MotionType.Unknown);
                if (eVar.depth.isSleep()) {
                    if (!arrayList.isEmpty()) {
                        for (yj.e eVar2 : arrayList) {
                            C.q(eVar2);
                        }
                        arrayList.clear();
                    }
                    C.q(eVar);
                } else {
                    arrayList.add(eVar);
                }
            }
        } else {
            long j13 = cVar.f33128d;
            if (j13 > 0) {
                C.D(SleepRecord.TimeType.InBed, j13 - cVar.f33129e);
            }
        }
        List<a> h10 = h(j10, j12, cVar.f33125a);
        if (!h10.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(h10.size());
            for (a aVar2 : h10) {
                float e11 = aVar2.e();
                if (e11 > 0.0f) {
                    arrayList2.add(new b(aVar2.f33128d, e11));
                }
            }
            C.A(arrayList2);
        } else {
            C.y(0.0f);
        }
        if (2 == i10) {
            long j14 = cVar.f33128d;
            boolean z10 = j14 > 0;
            if (!z10) {
                j14 = C.s().h();
            }
            b i11 = i(j14, !z10);
            com.mobvoi.android.common.utils.k.c("sleep.db", "Get morning pulse after %d, finished? %s, hr %s", Long.valueOf(j14), Boolean.valueOf(z10), i11);
            if (i11 != null && i11.time == j14) {
                C.B(i11);
            }
            C.E(i(j14 - TimeUnit.HOURS.toMillis(24L), false));
        }
        return C.s();
    }

    @Override // xj.a
    public void a(SleepRecord sleepRecord) {
        this.f36580b.d(sleepRecord.k());
    }

    @Override // xj.a
    public Collection<SleepRecord> b(long j10, long j11, int i10) {
        List<qf.c> h10 = this.f36580b.h(ActivityType.AutoSleep, j10, j11);
        if (h10.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(h10.size());
        for (qf.c cVar : h10) {
            SleepRecord p10 = p(cVar, i10);
            if (p10.f20742f != 1) {
                arrayList.add(p10);
            }
        }
        return arrayList;
    }

    @Override // xj.a
    public void c(yj.e eVar, String str) {
        if (eVar != null) {
            a a10 = eVar.a();
            a10.f33126b = this.f36582d;
            a10.f33125a = str;
            this.f36579a.d(a10);
        }
    }

    public void f(String str) {
        this.f36582d = str;
    }

    public com.mobvoi.health.common.data.db.c j() {
        return this.f36579a;
    }

    public k k() {
        return this.f36580b;
    }

    public SleepRecord m(String str) {
        qf.c c10 = this.f36580b.c(str);
        if (c10 == null) {
            return null;
        }
        return o(c10);
    }

    public void n(SleepRecord sleepRecord) {
        qf.c k10 = sleepRecord.k();
        k10.f33131g = 1;
        this.f36580b.b(k10);
    }
}
