package kh;

import android.util.SparseArray;
import com.mobvoi.health.companion.provider.Recorder;
import com.mobvoi.health.core.data.pojo.DataType;
import eg.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kh.w;
import nf.h;
/* compiled from: HealthDetailsViewModel.java */
/* loaded from: classes2.dex */
public class n extends w {

    /* renamed from: r  reason: collision with root package name */
    private final h<a> f29934r = new nf.a();

    /* renamed from: s  reason: collision with root package name */
    private hg.a f29935s;

    /* compiled from: HealthDetailsViewModel.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f29936a;

        /* renamed from: b  reason: collision with root package name */
        public int f29937b;

        /* renamed from: c  reason: collision with root package name */
        public int f29938c;

        public a(int i10, int i11, int i12) {
            this.f29936a = i10;
            this.f29937b = i11;
            this.f29938c = i12;
        }
    }

    private static int Q(oh.a aVar, DataType dataType, List<Recorder.Item> list) {
        SparseArray<Float> c10 = aVar.c(dataType);
        int i10 = 0;
        for (int i11 = 0; i11 < c10.size(); i11++) {
            int minutes = (int) (TimeUnit.SECONDS.toMinutes(c10.keyAt(i11) - aVar.d()) / 30);
            int b10 = DataType.Exercise == dataType ? ph.a.b(Math.round(c10.valueAt(i11).floatValue())) : Math.round(c10.valueAt(i11).floatValue());
            if (b10 > 0) {
                if (b10 > i10) {
                    i10 = b10;
                }
                Recorder.Item item = new Recorder.Item();
                item.time = minutes;
                item.value = b10;
                list.add(item);
            }
        }
        return i10;
    }

    private void U(SparseArray<oh.a> sparseArray, mg.a aVar, int i10, int i11) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i12;
        SparseArray<oh.a> sparseArray2 = sparseArray;
        if (sparseArray2 != null && sparseArray.size() != 0) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            float f10 = 0.0f;
            int i13 = 0;
            int i14 = i11;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = i10;
            while (i14 <= i24) {
                ArrayList arrayList6 = arrayList5;
                oh.a R = R(sparseArray2, i14);
                if (R != null) {
                    Recorder.Item item = new Recorder.Item();
                    Recorder.Item item2 = new Recorder.Item();
                    int i25 = i22;
                    Recorder.Item item3 = new Recorder.Item();
                    int i26 = i19;
                    int i27 = i14 - i11;
                    item3.time = i27;
                    item2.time = i27;
                    item.time = i27;
                    int e10 = R.e(DataType.Step);
                    if (e10 > 0) {
                        i13 += e10;
                        item.value = e10;
                        if (e10 > i17) {
                            i17 = e10;
                        }
                        if (e10 > aVar.f30790q) {
                            i20++;
                        }
                        arrayList3.add(item);
                    }
                    DataType dataType = DataType.Exercise;
                    if (R.e(dataType) > 0) {
                        int b10 = ph.a.b(R.e(dataType));
                        item2.value = b10;
                        i15 += b10;
                        if (b10 > i18) {
                            i18 = b10;
                        }
                        if (b10 > aVar.f30791r) {
                            i21++;
                        }
                        arrayList4.add(item2);
                    }
                    int e11 = R.e(DataType.Active);
                    if (e11 > 0) {
                        i16 += e11;
                        item3.value = e11;
                        i19 = e11 > i26 ? e11 : i26;
                        if (e11 > aVar.f30792s) {
                            i12 = i25 + 1;
                            arrayList2 = arrayList6;
                        } else {
                            arrayList2 = arrayList6;
                            i12 = i25;
                        }
                        arrayList2.add(item3);
                        i22 = i12;
                        arrayList = arrayList2;
                    } else {
                        arrayList = arrayList6;
                        i19 = i26;
                        i22 = i25;
                    }
                    i23 += R.e(DataType.Calorie);
                    f10 += R.e(DataType.Distance);
                } else {
                    arrayList = arrayList6;
                }
                i14++;
                i24 = i10;
                arrayList5 = arrayList;
                sparseArray2 = sparseArray;
            }
            aVar.f30782i = i13;
            aVar.f30783j = i15;
            aVar.f30784k = i16;
            aVar.f30785l = i23;
            aVar.f30786m = f10;
            aVar.f30779f = i17;
            aVar.f30780g = i18;
            aVar.f30781h = i19;
            aVar.f30776c = arrayList3;
            aVar.f30777d = arrayList4;
            aVar.f30778e = arrayList5;
            aVar.f30787n = i20;
            aVar.f30788o = i21;
            aVar.f30789p = i22;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(a aVar) {
        this.f29934r.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        long currentTimeMillis = System.currentTimeMillis();
        final a aVar = new a(b.a(V(com.mobvoi.health.common.data.pojo.DataType.GoalTodayStep, 0L, currentTimeMillis), 10000), b.a(V(com.mobvoi.health.common.data.pojo.DataType.GoalTodayExercise, 0L, currentTimeMillis) / 60, 30), b.a(V(com.mobvoi.health.common.data.pojo.DataType.GoalTodayActive, 0L, currentTimeMillis), 10));
        ig.b.J().j().post(new Runnable() { // from class: kh.m
            @Override // java.lang.Runnable
            public final void run() {
                n.this.Z(aVar);
            }
        });
    }

    public oh.a R(SparseArray<oh.a> sparseArray, int i10) {
        if (sparseArray == null || sparseArray.size() == 0) {
            return null;
        }
        return sparseArray.get((int) TimeUnit.MILLISECONDS.toSeconds(this.f29967l.get(i10).longValue()));
    }

    public void S(oh.a aVar, mg.a aVar2) {
        if (aVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int Q = Q(aVar, DataType.Step, arrayList);
            int Q2 = Q(aVar, DataType.Exercise, arrayList2);
            SparseArray<Float> c10 = aVar.c(DataType.Active);
            long millis = TimeUnit.SECONDS.toMillis(aVar.d());
            long millis2 = TimeUnit.DAYS.toMillis(1L) + millis;
            Calendar calendar = Calendar.getInstance();
            int i10 = 0;
            for (int i11 = 0; i11 < c10.size(); i11++) {
                arrayList = arrayList;
                arrayList2 = arrayList2;
                calendar.setTimeInMillis(TimeUnit.SECONDS.toMillis(c10.keyAt(i11)));
                int i12 = calendar.get(11);
                if (c10.valueAt(i11).floatValue() >= 100.0f) {
                    if (i12 > i10) {
                        i10 = i12;
                    }
                    arrayList3.add(new Recorder.Item(i12, i12));
                }
            }
            aVar2.f30774a = millis;
            aVar2.f30775b = millis2;
            aVar2.f30779f = Q;
            aVar2.f30780g = Q2;
            aVar2.f30781h = i10;
            aVar2.f30776c = arrayList;
            aVar2.f30777d = arrayList2;
            aVar2.f30778e = arrayList3;
        }
    }

    public h<a> T() {
        return this.f29934r;
    }

    public int V(com.mobvoi.health.common.data.pojo.DataType dataType, long j10, long j11) {
        qf.a E = ig.b.J().z().j(null, dataType, j10, j11);
        if (E != null) {
            return (int) E.e();
        }
        if (com.mobvoi.health.common.data.pojo.DataType.GoalTodayStep == dataType) {
            return 10000;
        }
        if (com.mobvoi.health.common.data.pojo.DataType.GoalTodayExercise == dataType) {
            return 30;
        }
        return com.mobvoi.health.common.data.pojo.DataType.GoalTodayActive == dataType ? 10 : -1;
    }

    public long W(int i10) {
        List<Long> list = this.f29967l;
        if (list == null || list.size() <= i10) {
            return -1L;
        }
        return this.f29967l.get(i10).longValue();
    }

    public void X(SparseArray<oh.a> sparseArray, mg.a aVar, int i10) {
        if (i10 > 0) {
            w.b bVar = this.f29969n.get(i10);
            aVar.f30774a = this.f29967l.get(bVar.f29971a).longValue();
            aVar.f30775b = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
            U(sparseArray, aVar, bVar.f29972b, bVar.f29971a);
        }
    }

    public void Y(SparseArray<oh.a> sparseArray, mg.a aVar, int i10) {
        w.b bVar = this.f29968m.get(i10);
        aVar.f30774a = this.f29967l.get(bVar.f29971a).longValue();
        aVar.f30775b = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
        U(sparseArray, aVar, bVar.f29972b, bVar.f29971a);
    }

    public void b0() {
        ig.b.J().m().post(new Runnable() { // from class: kh.l
            @Override // java.lang.Runnable
            public final void run() {
                n.this.a0();
            }
        });
    }

    public void c0(hg.a aVar) {
        this.f29935s = aVar;
    }

    public void d0(int i10, boolean z10) {
        long longValue = this.f29967l.get(i10).longValue();
        long millis = TimeUnit.DAYS.toMillis(1L) + longValue;
        if (z10) {
            p(longValue, millis);
        } else {
            J(longValue, millis);
        }
    }

    public void e0(int i10, boolean z10) {
        w.b bVar = this.f29969n.get(i10);
        long longValue = this.f29967l.get(bVar.f29971a).longValue();
        long longValue2 = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
        if (z10) {
            p(longValue, longValue2);
        } else {
            J(longValue, longValue2);
        }
    }

    public void f0(int i10, boolean z10) {
        w.b bVar = this.f29968m.get(i10);
        long longValue = this.f29967l.get(bVar.f29971a).longValue();
        long longValue2 = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
        if (z10) {
            p(longValue, longValue2);
        } else {
            J(longValue, longValue2);
        }
    }

    @Override // kh.w
    protected void n(long j10, long j11) {
        ig.b.J().w(Long.valueOf(j10), Long.valueOf(j11));
    }

    @Override // kh.w
    protected void o(long j10, long j11) {
        hg.a aVar = this.f29935s;
        if (aVar != null) {
            aVar.n(j10, j11);
        }
        M(j10, j11);
    }
}
