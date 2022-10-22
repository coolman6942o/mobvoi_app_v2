package kh;

import android.text.TextUtils;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import ig.b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import nf.c;
import nf.g;
import nf.h;
import nf.m;
import qf.a;
import yj.d;
/* compiled from: SleepDetailsViewModel.java */
/* loaded from: classes2.dex */
public class z extends g {

    /* renamed from: b  reason: collision with root package name */
    private h<SleepRecord> f29978b = new c();

    /* renamed from: c  reason: collision with root package name */
    private SleepRecord f29979c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f29980d;

    public z(String str) {
        this.f29980d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(SleepRecord sleepRecord) {
        this.f29978b.f(sleepRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        final SleepRecord m10 = b.J().K().m(this.f29980d);
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
        }
        this.f29979c = m10;
        b.J().j().post(new Runnable() { // from class: kh.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.i(m10);
            }
        });
    }

    @Override // nf.g
    protected void c(m mVar) {
        b.J().m().post(new Runnable() { // from class: kh.x
            @Override // java.lang.Runnable
            public final void run() {
                z.this.j();
            }
        });
    }

    public void g() {
        if (!TextUtils.isEmpty(this.f29980d) || this.f29979c == null) {
            b.J().K().n(this.f29979c);
            b.J().A();
        }
    }

    public h<SleepRecord> h() {
        return this.f29978b;
    }
}
