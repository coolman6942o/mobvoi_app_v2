package og;

import android.app.Application;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.heartrate.ui.c;
import com.mobvoi.health.companion.sleep.c;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.wear.location.FusedLocationConstants;
import fg.l;
import hf.o;
import hg.a;
import ih.b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kh.w;
import nf.h;
import ug.e;
import ug.n;
import yg.f;
import yj.d;
/* compiled from: DetailsViewModel.java */
/* loaded from: classes2.dex */
public class u extends w {
    public static final long D;
    public static final long E;

    /* renamed from: r  reason: collision with root package name */
    private int f31695r;

    /* renamed from: u  reason: collision with root package name */
    private a f31698u;

    /* renamed from: s  reason: collision with root package name */
    private int f31696s = 1;

    /* renamed from: t  reason: collision with root package name */
    private SportType f31697t = SportType.Unknown;

    /* renamed from: v  reason: collision with root package name */
    protected final h<c> f31699v = new nf.a();

    /* renamed from: w  reason: collision with root package name */
    protected final h<com.mobvoi.health.companion.noise.a> f31700w = new nf.a();

    /* renamed from: x  reason: collision with root package name */
    protected final h<com.mobvoi.health.companion.pressure.a> f31701x = new nf.a();

    /* renamed from: y  reason: collision with root package name */
    protected final h<com.mobvoi.health.companion.oxygen.a> f31702y = new nf.a();

    /* renamed from: z  reason: collision with root package name */
    private final h<n> f31703z = new nf.a();
    private final h<b> A = new nf.a();
    private final h<com.mobvoi.health.companion.sleep.c> B = new nf.a();
    private final h<com.mobvoi.health.companion.heartrate.ui.b> C = new nf.a();

    static {
        TimeUnit timeUnit = TimeUnit.HOURS;
        D = timeUnit.toMillis(12L);
        E = timeUnit.toMillis(4L);
    }

    public u(Context context, int i10) {
        this.f31695r = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(com.mobvoi.health.companion.noise.a aVar) {
        this.f31700w.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.noise.a h10 = com.mobvoi.health.companion.heartrate.ui.a.h(j10, ig.b.J().z().h(DataType.NOISE_DECIBEL, j10, j11), i10);
        ig.b.J().j().post(new Runnable() { // from class: og.e
            @Override // java.lang.Runnable
            public final void run() {
                u.this.A0(h10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(com.mobvoi.health.companion.pressure.a aVar) {
        this.f31701x.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.pressure.a i11 = com.mobvoi.health.companion.heartrate.ui.a.i(j10, ig.b.J().z().h(DataType.Pressure, j10, j11), i10);
        ig.b.J().j().post(new Runnable() { // from class: og.g
            @Override // java.lang.Runnable
            public final void run() {
                u.this.C0(i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(com.mobvoi.health.companion.sleep.c cVar) {
        this.B.f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(com.mobvoi.health.companion.sleep.c cVar) {
        this.B.f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        this.B.f(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(long j10, long j11, int i10) {
        int i11;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i12;
        int i13;
        int i14;
        int i15;
        long j12;
        long j13;
        int i16;
        Calendar calendar;
        long j14;
        long j15;
        c.b bVar;
        SleepRecord sleepRecord;
        int i17;
        int i18;
        Collection<SleepRecord> b10 = ig.b.J().K().b(j10, j11, 0);
        long j16 = 0;
        if (i10 == 1) {
            final com.mobvoi.health.companion.sleep.c cVar = new com.mobvoi.health.companion.sleep.c(j10);
            if (b10 != null && b10.size() > 0) {
                SleepRecord sleepRecord2 = null;
                long j17 = -1;
                for (SleepRecord sleepRecord3 : b10) {
                    long longValue = sleepRecord3.e(SleepRecord.TimeType.InBed).longValue();
                    if (longValue > j17) {
                        sleepRecord2 = sleepRecord3;
                        j17 = longValue;
                    }
                }
                c.b bVar2 = new c.b();
                if (sleepRecord2 != null) {
                    b10.remove(sleepRecord2);
                    SleepRecord sleepRecord4 = sleepRecord2;
                    bVar = bVar2;
                    V0(j10, j11, sleepRecord4);
                    sleepRecord = sleepRecord4;
                    List<qf.a> C = ig.b.J().z().g(sleepRecord.f20738b, sleepRecord.f20739c, DataType.BloodOxygen, sleepRecord.f20740d, sleepRecord.f20741e);
                    if (C != null && C.size() > 0) {
                        ArrayList arrayList3 = new ArrayList();
                        int i19 = 0;
                        int i20 = 0;
                        float f10 = 0.0f;
                        for (int i21 = 0; i21 < C.size(); i21++) {
                            qf.a aVar = C.get(i21);
                            float e10 = aVar.e();
                            f10 += e10;
                            if (i21 == 0) {
                                i17 = (int) e10;
                                i18 = i17;
                            } else {
                                i17 = i19;
                                i18 = i20;
                            }
                            i19 = e10 > ((float) i17) ? (int) e10 : i17;
                            if (e10 < i18) {
                                i18 = (int) e10;
                            }
                            i20 = i18;
                            arrayList3.add(new yj.a(aVar.f33128d, (int) aVar.e()));
                        }
                        sleepRecord.j(new d(sleepRecord.f20740d, sleepRecord.f20741e, arrayList3, i19, i20, new BigDecimal(f10 / C.size()).setScale(0, 4).intValue()));
                    }
                    SleepRecord.TimeType timeType = SleepRecord.TimeType.Awake;
                    bVar.f18643h = sleepRecord.e(timeType) == null ? 0L : sleepRecord.e(timeType).longValue();
                    SleepRecord.TimeType timeType2 = SleepRecord.TimeType.Rem;
                    bVar.f18644i = sleepRecord.e(timeType2) == null ? 0L : sleepRecord.e(timeType2).longValue();
                    SleepRecord.TimeType timeType3 = SleepRecord.TimeType.LightSleep;
                    bVar.f18645j = sleepRecord.e(timeType3) == null ? 0L : sleepRecord.e(timeType3).longValue();
                    SleepRecord.TimeType timeType4 = SleepRecord.TimeType.DeepSleep;
                    bVar.f18646k = sleepRecord.e(timeType4) == null ? 0L : sleepRecord.e(timeType4).longValue();
                    SleepRecord.TimeType timeType5 = SleepRecord.TimeType.FallAsleep;
                    if (sleepRecord.e(timeType5) != null) {
                        j16 = sleepRecord.e(timeType5).longValue();
                    }
                    long j18 = j16;
                    bVar.f18647l = j18;
                    long[] jArr = {bVar.f18643h, bVar.f18644i, bVar.f18645j, bVar.f18646k, j18};
                    double longValue2 = sleepRecord.e(SleepRecord.TimeType.InBed).longValue();
                    bVar.f18638c = (int) l.b(jArr, longValue2, 0, 0);
                    bVar.f18639d = (int) l.b(jArr, longValue2, 1, 0);
                    bVar.f18640e = (int) l.b(jArr, longValue2, 2, 0);
                    bVar.f18641f = (int) l.b(jArr, longValue2, 3, 0);
                    bVar.f18642g = (int) l.b(jArr, longValue2, 4, 0);
                } else {
                    sleepRecord = sleepRecord2;
                    bVar = bVar2;
                }
                bVar.f18637b = sleepRecord;
                ArrayList arrayList4 = new ArrayList();
                bVar.f18636a = arrayList4;
                arrayList4.addAll(b10);
                cVar.f18624d = bVar;
            }
            ig.b.J().j().post(new Runnable() { // from class: og.i
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.E0(cVar);
                }
            });
            return;
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j10);
        if (i10 == 3) {
            calendar2.add(2, -1);
        } else if (i10 == 2) {
            calendar2.add(5, -7);
        }
        long timeInMillis = calendar2.getTimeInMillis();
        if (b10 == null || b10.size() <= 0) {
            ig.b.J().j().post(new Runnable() { // from class: og.l
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.G0();
                }
            });
            return;
        }
        int size = b10.size();
        Calendar calendar3 = Calendar.getInstance();
        int firstDayOfWeek = calendar3.getFirstDayOfWeek();
        HashMap hashMap = new HashMap();
        Iterator<SleepRecord> it = b10.iterator();
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        long j19 = 0;
        long j20 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        long j24 = 0;
        long j25 = 0;
        long j26 = 0;
        long j27 = 0;
        long j28 = 0;
        long j29 = 0;
        long j30 = 0;
        float f11 = 0.0f;
        while (true) {
            i11 = i22;
            if (!it.hasNext()) {
                break;
            }
            SleepRecord next = it.next();
            it = it;
            long g10 = next.g(SleepRecord.TimeType.InBed);
            long j31 = j22;
            calendar3.setTimeInMillis(next.f20741e);
            if (i10 == 2) {
                i15 = com.mobvoi.health.companion.heartrate.ui.a.o(firstDayOfWeek, calendar3.get(7));
            } else {
                i15 = i10 == 3 ? calendar3.get(5) - 1 : i24;
            }
            if (hashMap.containsKey(Integer.valueOf(i15))) {
                c.a aVar2 = (c.a) hashMap.get(Integer.valueOf(i15));
                calendar = calendar3;
                i16 = firstDayOfWeek;
                aVar2.f18628d += next.g(SleepRecord.TimeType.DeepSleep);
                aVar2.f18627c += next.g(SleepRecord.TimeType.LightSleep);
                aVar2.f18625a += next.g(SleepRecord.TimeType.Awake);
                aVar2.f18629e += next.g(SleepRecord.TimeType.FallAsleep);
                long g11 = aVar2.f18626b + next.g(SleepRecord.TimeType.Rem);
                aVar2.f18626b = g11;
                j13 = j21;
                j12 = j20;
                aVar2.f18630f = aVar2.f18628d + aVar2.f18627c + aVar2.f18625a + g11;
            } else {
                j12 = j20;
                j13 = j21;
                calendar = calendar3;
                i16 = firstDayOfWeek;
                c.a aVar3 = new c.a();
                aVar3.f18625a = next.g(SleepRecord.TimeType.Awake);
                aVar3.f18626b = next.g(SleepRecord.TimeType.Rem);
                aVar3.f18627c = next.g(SleepRecord.TimeType.LightSleep);
                aVar3.f18628d = next.g(SleepRecord.TimeType.DeepSleep);
                aVar3.f18629e = next.g(SleepRecord.TimeType.FallAsleep);
                aVar3.f18631g = i15;
                aVar3.f18630f = aVar3.f18628d + aVar3.f18627c + aVar3.f18625a + aVar3.f18626b;
                hashMap.put(Integer.valueOf(i15), aVar3);
            }
            i23 += next.f20743g;
            j19 += g10;
            if (g10 > j12) {
                j28 = next.f20741e;
                j14 = g10;
            } else {
                j14 = j12;
            }
            if (j13 == 0 || j13 > g10) {
                j30 = next.f20741e;
                j21 = g10;
            } else {
                j21 = j13;
            }
            if (eg.c.l(next.f20740d, next.f20741e)) {
                long b11 = eg.c.b(next.f20740d);
                long j32 = w.f29955p;
                j24 += (next.f20740d - b11) + j32;
                j25 += (next.f20741e - b11) + j32;
                j15 = j14;
            } else {
                long b12 = eg.c.b(next.f20740d);
                long b13 = eg.c.b(next.f20741e);
                j15 = j14;
                j24 += next.f20740d - b12;
                j25 += (next.f20741e - b13) + w.f29955p;
            }
            j22 = j31 + next.g(SleepRecord.TimeType.Awake);
            j29 += next.g(SleepRecord.TimeType.Rem);
            j27 += next.g(SleepRecord.TimeType.LightSleep);
            j26 += next.g(SleepRecord.TimeType.DeepSleep);
            j23 += next.g(SleepRecord.TimeType.FallAsleep);
            if (next.b() == null || next.b().size() <= 0) {
                i22 = i11;
            } else {
                i22 = i11;
                for (yj.b bVar3 : next.b()) {
                    float f12 = bVar3.value;
                    if (f12 > 0.0f) {
                        f11 += f12;
                        i22++;
                    }
                }
            }
            calendar3 = calendar;
            firstDayOfWeek = i16;
            j20 = j15;
            i24 = i15;
        }
        long j33 = j20;
        long j34 = j21;
        long j35 = j22;
        Calendar calendar4 = calendar3;
        int i25 = firstDayOfWeek;
        c.d dVar = new c.d();
        ArrayList arrayList5 = new ArrayList();
        long j36 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            long j37 = ((c.a) entry.getValue()).f18630f;
            if (j37 > j36) {
                j36 = j37;
            }
            arrayList5.add((c.a) entry.getValue());
        }
        dVar.f18651a = j36;
        long j38 = size;
        dVar.f18652b = j25 / j38;
        dVar.f18653c = j24 / j38;
        dVar.f18654d = i23 / size;
        dVar.f18655e = j19 / arrayList5.size();
        int i26 = 0;
        long[] jArr2 = {j35, j29, j27, j26, j23};
        double d10 = j19;
        dVar.f18661k = (int) l.b(jArr2, d10, 0, 0);
        dVar.f18662l = (int) l.b(jArr2, d10, 1, 0);
        dVar.f18663m = (int) l.b(jArr2, d10, 2, 0);
        dVar.f18664n = (int) l.b(jArr2, d10, 3, 0);
        dVar.f18665o = (int) l.b(jArr2, d10, 4, 0);
        dVar.f18666p = j35;
        dVar.f18667q = j29;
        dVar.f18668r = j27;
        dVar.f18669s = j26;
        dVar.f18656f = i11 == 0 ? 0 : Math.round(f11 / i11);
        dVar.f18657g = j33;
        dVar.f18658h = j28;
        dVar.f18659i = j34;
        dVar.f18660j = j30;
        Collection<SleepRecord> b14 = ig.b.J().K().b(timeInMillis, j10, 0);
        if (b14 == null || b14.size() <= 0) {
            arrayList = arrayList5;
        } else {
            int size2 = b14.size();
            ArrayList arrayList6 = new ArrayList();
            int i27 = 0;
            long j39 = 0;
            long j40 = 0;
            for (SleepRecord sleepRecord5 : b14) {
                i27 += sleepRecord5.f20743g;
                j40 += sleepRecord5.g(SleepRecord.TimeType.InBed);
                if (eg.c.l(sleepRecord5.f20740d, sleepRecord5.f20741e)) {
                    long b15 = eg.c.b(sleepRecord5.f20740d);
                    long j41 = w.f29955p;
                    j16 += (sleepRecord5.f20740d - b15) + j41;
                    j39 += (sleepRecord5.f20741e - b15) + j41;
                    arrayList2 = arrayList5;
                    i12 = i26;
                } else {
                    long b16 = eg.c.b(sleepRecord5.f20740d);
                    long b17 = eg.c.b(sleepRecord5.f20741e);
                    arrayList2 = arrayList5;
                    i12 = i26;
                    j16 += sleepRecord5.f20740d - b16;
                    j39 += (sleepRecord5.f20741e - b17) + w.f29955p;
                }
                long j42 = sleepRecord5.f20741e;
                Calendar calendar5 = calendar4;
                calendar5.setTimeInMillis(j42);
                if (i10 == 2) {
                    i13 = i25;
                    i14 = com.mobvoi.health.companion.heartrate.ui.a.o(i13, calendar5.get(7));
                } else {
                    i13 = i25;
                    i14 = i10 == 3 ? calendar5.get(5) - 1 : i12;
                }
                if (!arrayList6.contains(Integer.valueOf(i14))) {
                    arrayList6.add(Integer.valueOf(i14));
                }
                arrayList5 = arrayList2;
                i26 = i14;
                calendar4 = calendar5;
                i25 = i13;
            }
            arrayList = arrayList5;
            dVar.f18670t = dVar.f18654d - (i27 / size2);
            long j43 = size2;
            dVar.f18672v = dVar.f18653c - (j16 / j43);
            dVar.f18671u = dVar.f18652b - (j39 / j43);
            dVar.f18673w = dVar.f18655e - (j40 / arrayList6.size());
        }
        final com.mobvoi.health.companion.sleep.c cVar2 = new com.mobvoi.health.companion.sleep.c(j10, arrayList, dVar);
        ig.b.J().j().post(new Runnable() { // from class: og.h
            @Override // java.lang.Runnable
            public final void run() {
                u.this.F0(cVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(SportType sportType, long j10, long j11, Collection collection, Throwable th2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f10;
        Iterator it;
        int i15;
        int i16;
        SportType sportType2 = sportType;
        long j12 = j10;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator it2 = collection.iterator();
            i14 = 0;
            i13 = 0;
            float f11 = 0.0f;
            i12 = 0;
            i11 = 0;
            i10 = 0;
            while (it2.hasNext()) {
                ef.u uVar = (ef.u) it2.next();
                if (sportType2 == SportType.Unknown || uVar.f25985d == sportType2) {
                    long j13 = uVar.f25989h;
                    it = it2;
                    long j14 = uVar.f25990i;
                    if (j13 >= j12 && j13 < j11) {
                        float c10 = uVar.c();
                        i16 = i11;
                        i15 = i12;
                        e eVar = new e(uVar.f25984c, uVar.f25983b, uVar.f25985d, new Date(j13), new Date(j14), uVar.f25991j, c10 < 0.0f ? 0 : (int) c10);
                        eVar.f35424h = uVar.f25993l;
                        eVar.f35425i = uVar.f25992k;
                        eVar.f35426j = uVar.f25994m;
                        arrayList.add(eVar);
                        i10++;
                        i14 += uVar.f25992k;
                        i13 = (int) (i13 + uVar.f25991j);
                        f11 += uVar.f25993l;
                        int i17 = uVar.f25994m;
                        if (i17 > 0) {
                            i12 = i15 + i17;
                            i11 = i16 + 1;
                            sportType2 = sportType;
                            j12 = j10;
                            it2 = it;
                        }
                        i11 = i16;
                        i12 = i15;
                        sportType2 = sportType;
                        j12 = j10;
                        it2 = it;
                    }
                } else {
                    it = it2;
                }
                i15 = i12;
                i16 = i11;
                i11 = i16;
                i12 = i15;
                sportType2 = sportType;
                j12 = j10;
                it2 = it;
            }
            f10 = f11;
        } else {
            f10 = 0.0f;
            i14 = 0;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i10 = 0;
        }
        Collections.sort(arrayList, w.f29956q);
        n nVar = new n(j10);
        nVar.f35437b = arrayList;
        nVar.f35438c = i10;
        nVar.f35442g = i11 > 0 ? Math.round(i12 / i11) : 0;
        nVar.f35440e = i14;
        nVar.f35441f = i13;
        nVar.f35439d = Math.round(f10);
        this.f31703z.f(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int J0(qf.a aVar, qf.a aVar2) {
        long j10 = aVar.f33129e;
        long j11 = aVar2.f33129e;
        if (j10 < j11) {
            return -1;
        }
        return j10 > j11 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(b bVar) {
        this.A.f(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(DataType.Temperature, j10, j11);
        if (h10 != null && h10.size() > 0) {
            Collections.sort(h10, k.f31662a);
        }
        ArrayList arrayList = new ArrayList(h10.size());
        float f10 = 2.14748365E9f;
        int i10 = Integer.MAX_VALUE;
        float f11 = -2.14748365E9f;
        int i11 = Integer.MIN_VALUE;
        float f12 = 0.0f;
        int i12 = 0;
        float f13 = 0.0f;
        for (qf.a aVar : h10) {
            if (aVar.e() > 0.0f) {
                float a10 = ih.a.a(aVar.e());
                if (a10 > 0.0f) {
                    i12++;
                    f13 += a10;
                    if (a10 > f11) {
                        i11 = i12 - 1;
                        f11 = a10;
                    }
                    if (a10 < f10) {
                        i10 = i12 - 1;
                        f10 = a10;
                    }
                }
                arrayList.add(new ih.a(aVar.f33128d, a10));
            }
        }
        float f14 = i12 > 0 ? f13 / i12 : 0.0f;
        if (i12 <= 0) {
            f10 = 0.0f;
        }
        if (i12 > 0) {
            f12 = f11;
        }
        final b bVar = new b(f14, f10, f12, i12 > 0 ? i10 : 0, i12 > 0 ? i11 : 0, j10, arrayList);
        ig.b.J().j().post(new Runnable() { // from class: og.j
            @Override // java.lang.Runnable
            public final void run() {
                u.this.K0(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(com.mobvoi.health.companion.oxygen.a aVar) {
        this.f31702y.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.oxygen.a d10 = com.mobvoi.health.companion.heartrate.ui.a.d(j10, ig.b.J().z().h(DataType.BloodOxygen, j10, j11), i10);
        ig.b.J().j().post(new Runnable() { // from class: og.f
            @Override // java.lang.Runnable
            public final void run() {
                u.this.s0(d10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(com.mobvoi.health.companion.heartrate.ui.b bVar) {
        this.C.f(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.heartrate.ui.b e10 = com.mobvoi.health.companion.heartrate.ui.a.e(j10, ig.b.J().z().h(DataType.BodyAndMindState, j10, j11), i10);
        ig.b.J().j().post(new Runnable() { // from class: og.b
            @Override // java.lang.Runnable
            public final void run() {
                u.this.u0(e10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(com.mobvoi.health.companion.heartrate.ui.c cVar) {
        this.f31699v.f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.heartrate.ui.c j12 = com.mobvoi.health.companion.heartrate.ui.a.j(ig.b.J().I().a(j10, j11), com.mobvoi.health.companion.heartrate.ui.a.l(ig.b.J().z().h(DataType.Motion, j10, j11), j10, j11), j10, j11, i10);
        com.mobvoi.health.companion.heartrate.ui.a.g(j12, j10, j11, i10);
        ig.b.J().j().post(new Runnable() { // from class: og.d
            @Override // java.lang.Runnable
            public final void run() {
                u.this.w0(j12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(com.mobvoi.health.companion.heartrate.ui.c cVar) {
        this.f31699v.f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(long j10, long j11, int i10) {
        final com.mobvoi.health.companion.heartrate.ui.c j12 = com.mobvoi.health.companion.heartrate.ui.a.j(ig.b.J().I().a(j10, j11), null, j10, j11, i10);
        ig.b.J().j().post(new Runnable() { // from class: og.c
            @Override // java.lang.Runnable
            public final void run() {
                u.this.y0(j12);
            }
        });
    }

    protected void M0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.n
            @Override // java.lang.Runnable
            public final void run() {
                u.this.t0(j10, j11, i10);
            }
        });
    }

    protected void N0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.o
            @Override // java.lang.Runnable
            public final void run() {
                u.this.v0(j10, j11, i10);
            }
        });
    }

    protected void O0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.x0(j10, j11, i10);
            }
        });
    }

    protected void P0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.s
            @Override // java.lang.Runnable
            public final void run() {
                u.this.z0(j10, j11, i10);
            }
        });
    }

    protected void Q0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.q
            @Override // java.lang.Runnable
            public final void run() {
                u.this.B0(j10, j11, i10);
            }
        });
    }

    protected void R0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.p
            @Override // java.lang.Runnable
            public final void run() {
                u.this.D0(j10, j11, i10);
            }
        });
    }

    protected void S0(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: og.r
            @Override // java.lang.Runnable
            public final void run() {
                u.this.H0(j10, j11, i10);
            }
        });
    }

    protected void T0(final long j10, final long j11, int i10, final SportType sportType) {
        f.X().G(new Date(j11), new Date(j10), -1, null, new o() { // from class: og.a
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                u.this.I0(sportType, j10, j11, (Collection) obj, th2);
            }
        });
    }

    protected void U0(final long j10, final long j11) {
        ig.b.J().m().post(new Runnable() { // from class: og.m
            @Override // java.lang.Runnable
            public final void run() {
                u.this.L0(j10, j11);
            }
        });
    }

    public void V0(long j10, long j11, SleepRecord sleepRecord) {
        int i10;
        long j12;
        long j13;
        long j14;
        Calendar a10 = eg.c.a(j10);
        long timeInMillis = a10.getTimeInMillis();
        long j15 = w.f29955p;
        long j16 = timeInMillis + j15;
        HashMap hashMap = new HashMap();
        int i11 = a10.get(7);
        Collection<SleepRecord> b10 = ig.b.J().K().b(timeInMillis - ((i11 == 1 ? 6 : i11 - 2) * j15), j16, 0);
        qf.a aVar = (qf.a) ig.b.J().K().j().j(null, DataType.ExpectedGetUpTime, 0L, System.currentTimeMillis());
        qf.a aVar2 = (qf.a) ig.b.J().K().j().j(null, DataType.ExpectedSleepTime, 0L, System.currentTimeMillis());
        long e10 = aVar2 == null ? 82800000L : aVar2.e();
        long e11 = aVar == null ? 28800000L : aVar.e();
        if (e11 > e10) {
            e10 += j15;
        }
        long j17 = j15 + e11;
        if (b10 == null || b10.size() <= 0) {
            i10 = 0;
        } else {
            new ArrayList();
            i10 = 0;
            for (SleepRecord sleepRecord2 : b10) {
                long b11 = eg.c.b(sleepRecord2.f20740d);
                long b12 = eg.c.b(sleepRecord2.f20741e);
                int i12 = i10;
                long j18 = sleepRecord2.f20740d;
                long j19 = j18 - b11;
                long j20 = sleepRecord2.f20741e;
                long j21 = j20 - b12;
                if (eg.c.l(j18, j20)) {
                    long j22 = w.f29955p;
                    j13 = j19 + j22;
                    j12 = j21 + j22;
                } else {
                    j12 = j21 + w.f29955p;
                    j13 = j19;
                }
                int i13 = (j13 > e10 ? 1 : (j13 == e10 ? 0 : -1));
                boolean z10 = (i13 > 0 && j13 < j17) || (j12 > e10 && j12 < j17);
                boolean z11 = i13 <= 0 && j12 >= j17;
                boolean z12 = i13 >= 0 && j12 <= j17;
                if (z10 || z11 || z12) {
                    boolean z13 = j13 > e10 + FusedLocationConstants.MIN_TIME_BETWEEN_TWO_LOCATING;
                    boolean z14 = j12 > j17 + FusedLocationConstants.MIN_TIME_BETWEEN_TWO_LOCATING;
                    boolean z15 = j12 < j17 - FusedLocationConstants.MIN_TIME_BETWEEN_TWO_LOCATING;
                    i10 = z13 ? i12 + 1 : i12;
                    j14 = j17;
                    k.c("details.model", "this week records [%s - %s], tip : %s", com.mobvoi.android.common.utils.d.a(sleepRecord2.f20740d), com.mobvoi.android.common.utils.d.a(sleepRecord2.f20741e), sleepRecord2.f20747k);
                    k.c("details.model", "isSleepToLater = %s, isGetUpToLater =  %s, isGetUpToEarly =   %s", Boolean.valueOf(z13), Boolean.valueOf(z14), Boolean.valueOf(z15));
                    yj.c cVar = new yj.c();
                    long j23 = sleepRecord2.f20740d;
                    cVar.f37103a = j23;
                    cVar.f37105c = z13;
                    cVar.f37106d = z14;
                    cVar.f37107e = z15;
                    hashMap.put(Long.valueOf(j23), cVar);
                } else {
                    i10 = i12;
                    j14 = j17;
                }
                j17 = j14;
            }
        }
        Application e12 = com.mobvoi.android.common.utils.b.e();
        StringBuffer stringBuffer = new StringBuffer();
        if (hashMap.containsKey(Long.valueOf(sleepRecord.f20740d))) {
            yj.c cVar2 = (yj.c) hashMap.get(Long.valueOf(sleepRecord.f20740d));
            if (cVar2.f37105c) {
                if (i10 >= 3) {
                    stringBuffer.append(e12.getString(fg.u.f26937n4));
                    stringBuffer.append(String.format(e12.getString(fg.u.f26943o4), Integer.valueOf(i10)));
                } else if (i10 == 2) {
                    stringBuffer.append(e12.getString(fg.u.f26931m4));
                    long b13 = eg.c.b(sleepRecord.f20740d) - w.f29955p;
                    Iterator it = hashMap.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (b13 == eg.c.b(((Long) entry.getKey()).longValue()) && ((yj.c) entry.getValue()).f37105c) {
                            stringBuffer.append(e12.getString(fg.u.f26949p4));
                            break;
                        }
                    }
                } else {
                    stringBuffer.append(e12.getString(fg.u.f26937n4));
                }
            } else if (cVar2.f37107e) {
                stringBuffer.append(e12.getString(fg.u.M1));
            } else if (cVar2.f37106d) {
                stringBuffer.append(e12.getString(fg.u.N1));
            } else if (cVar2.f37104b) {
                stringBuffer.append(e12.getString(fg.u.f26919k4));
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.append(e12.getString(fg.u.f26955q4));
                sleepRecord.f20747k = stringBuffer.toString();
            }
        }
    }

    public void W0(a aVar) {
        this.f31698u = aVar;
    }

    public void X0(SportType sportType) {
        this.f31697t = sportType;
    }

    public void Y0(int i10, boolean z10, int i11) {
        this.f31696s = i11;
        long longValue = this.f29967l.get(i10).longValue();
        long millis = TimeUnit.DAYS.toMillis(1L) + longValue;
        if (z10) {
            p(longValue, millis);
        } else {
            J(longValue, millis);
        }
    }

    public void Z0(int i10, boolean z10, int i11) {
        this.f31696s = i11;
        w.b bVar = this.f29969n.get(i10);
        long longValue = this.f29967l.get(bVar.f29971a).longValue();
        long longValue2 = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
        if (z10) {
            p(longValue, longValue2);
        } else {
            J(longValue, longValue2);
        }
    }

    public void a1(int i10, boolean z10, int i11) {
        this.f31696s = i11;
        w.b bVar = this.f29968m.get(i10);
        long longValue = this.f29967l.get(bVar.f29971a).longValue();
        long longValue2 = this.f29967l.get(bVar.f29972b).longValue() + TimeUnit.DAYS.toMillis(1L);
        if (z10) {
            p(longValue, longValue2);
        } else {
            J(longValue, longValue2);
        }
    }

    public h<com.mobvoi.health.companion.oxygen.a> i0() {
        return this.f31702y;
    }

    public h<com.mobvoi.health.companion.heartrate.ui.b> j0() {
        return this.C;
    }

    public h<com.mobvoi.health.companion.heartrate.ui.c> k0() {
        return this.f31699v;
    }

    public long l0(int i10) {
        List<Long> list = this.f29967l;
        if (list == null || list.size() <= i10) {
            return -1L;
        }
        return this.f29967l.get(i10).longValue();
    }

    public h<com.mobvoi.health.companion.noise.a> m0() {
        return this.f31700w;
    }

    @Override // kh.w
    protected void n(long j10, long j11) {
        if (this.f31695r == 4) {
            j10 -= E;
        }
        ig.b.J().w(Long.valueOf(j10), Long.valueOf(j11));
        f.X().F(new Date(j11), new Date(j10), Integer.MAX_VALUE);
    }

    public h<com.mobvoi.health.companion.pressure.a> n0() {
        return this.f31701x;
    }

    @Override // kh.w
    protected void o(long j10, long j11) {
        a aVar = this.f31698u;
        if (aVar != null) {
            aVar.n(j10, j11);
        }
        int i10 = this.f31695r;
        if (i10 == 1) {
            O0(j10, j11, this.f31696s);
        } else if (i10 == 9) {
            P0(j10, j11, this.f31696s);
        } else if (i10 == 2) {
            M0(j10, j11, this.f31696s);
        } else if (i10 == 3) {
            R0(j10, j11, this.f31696s);
        } else if (i10 == 4) {
            S0(j10, j11, this.f31696s);
        } else if (i10 == 5) {
            Q0(j10, j11, this.f31696s);
        } else if (i10 == 6) {
            T0(j10, j11, this.f31696s, this.f31697t);
        } else if (i10 == 7) {
            M(j10, j11);
        } else if (i10 == 8) {
            U0(j10, j11);
        } else if (i10 == 10) {
            N0(j10, j11, this.f31696s);
        }
    }

    public h<com.mobvoi.health.companion.sleep.c> o0() {
        return this.B;
    }

    public h<n> p0() {
        return this.f31703z;
    }

    public SportType q0() {
        return this.f31697t;
    }

    public h<b> r0() {
        return this.A;
    }
}
