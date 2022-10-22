package kh;

import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.companion.sleep.c;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.l;
import ig.b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import nf.h;
import nf.m;
import qf.a;
import yj.d;
/* compiled from: SleepShareViewModel.java */
/* loaded from: classes2.dex */
public class d0 extends z {

    /* renamed from: e  reason: collision with root package name */
    private h<c.b> f29914e = new nf.c();

    public d0(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f29914e.f(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(c.b bVar) {
        this.f29914e.f(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        SleepRecord m10 = b.J().K().m(this.f29980d);
        if (m10 != null) {
            List<a> C = b.J().z().g(m10.f20738b, m10.f20739c, DataType.BloodOxygen, m10.f20740d, m10.f20741e);
            float f10 = 0.0f;
            if (C != null && C.size() > 0) {
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < C.size(); i12++) {
                    a aVar = C.get(i12);
                    float e10 = aVar.e();
                    f10 += e10;
                    if (i12 == 0) {
                        i10 = (int) e10;
                        i11 = i10;
                    }
                    if (e10 > i10) {
                        i10 = (int) e10;
                    }
                    if (e10 < i11) {
                        i11 = (int) e10;
                    }
                    arrayList.add(new yj.a(aVar.f33128d, (int) aVar.e()));
                }
                m10.j(new d(m10.f20740d, m10.f20741e, arrayList, i10, i11, new BigDecimal(f10 / C.size()).setScale(0, 4).intValue()));
            }
            final c.b bVar = new c.b();
            bVar.f18637b = m10;
            SleepRecord.TimeType timeType = SleepRecord.TimeType.Awake;
            long j10 = 0;
            bVar.f18643h = m10.e(timeType) == null ? 0L : m10.e(timeType).longValue();
            SleepRecord.TimeType timeType2 = SleepRecord.TimeType.Rem;
            bVar.f18644i = m10.e(timeType2) == null ? 0L : m10.e(timeType2).longValue();
            SleepRecord.TimeType timeType3 = SleepRecord.TimeType.LightSleep;
            bVar.f18645j = m10.e(timeType3) == null ? 0L : m10.e(timeType3).longValue();
            SleepRecord.TimeType timeType4 = SleepRecord.TimeType.DeepSleep;
            bVar.f18646k = m10.e(timeType4) == null ? 0L : m10.e(timeType4).longValue();
            SleepRecord.TimeType timeType5 = SleepRecord.TimeType.FallAsleep;
            if (m10.e(timeType5) != null) {
                j10 = m10.e(timeType5).longValue();
            }
            bVar.f18647l = j10;
            long[] jArr = {bVar.f18643h, bVar.f18644i, bVar.f18645j, bVar.f18646k, j10};
            double longValue = m10.e(SleepRecord.TimeType.InBed).longValue();
            bVar.f18638c = (int) l.b(jArr, longValue, 0, 0);
            bVar.f18639d = (int) l.b(jArr, longValue, 1, 0);
            bVar.f18640e = (int) l.b(jArr, longValue, 2, 0);
            bVar.f18641f = (int) l.b(jArr, longValue, 3, 0);
            bVar.f18642g = (int) l.b(jArr, longValue, 4, 0);
            b.J().j().post(new Runnable() { // from class: kh.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.this.o(bVar);
                }
            });
            return;
        }
        b.J().j().post(new Runnable() { // from class: kh.a0
            @Override // java.lang.Runnable
            public final void run() {
                d0.this.j();
            }
        });
    }

    @Override // kh.z, nf.g
    protected void c(m mVar) {
        b.J().m().post(new Runnable() { // from class: kh.b0
            @Override // java.lang.Runnable
            public final void run() {
                d0.this.p();
            }
        });
    }

    public h<c.b> n() {
        return this.f29914e;
    }
}
