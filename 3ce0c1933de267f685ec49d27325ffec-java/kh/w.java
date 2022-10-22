package kh;

import android.util.SparseArray;
import com.mobvoi.health.common.data.pojo.DataType;
import gg.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import nf.g;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
import nf.n;
import ug.e;
/* compiled from: HistoryViewModel.java */
/* loaded from: classes2.dex */
public abstract class w extends g {

    /* renamed from: p  reason: collision with root package name */
    protected static final long f29955p = TimeUnit.DAYS.toMillis(1);

    /* renamed from: q  reason: collision with root package name */
    protected static final Comparator<e> f29956q = t.f29952a;

    /* renamed from: b  reason: collision with root package name */
    private final h<SparseArray<oh.a>> f29957b = new nf.a();

    /* renamed from: c  reason: collision with root package name */
    private final h<Object> f29958c = new nf.a();

    /* renamed from: d  reason: collision with root package name */
    private final h<List<gg.c>> f29959d = new nf.a();

    /* renamed from: e  reason: collision with root package name */
    private final h<Map<Long, List<gg.c>>> f29960e = new nf.a();

    /* renamed from: f  reason: collision with root package name */
    private final h<Map<Long, List<gg.c>>> f29961f = new nf.a();

    /* renamed from: g  reason: collision with root package name */
    private boolean f29962g = false;

    /* renamed from: h  reason: collision with root package name */
    private c f29963h;

    /* renamed from: i  reason: collision with root package name */
    private k<SparseArray<oh.a>> f29964i;

    /* renamed from: j  reason: collision with root package name */
    List<Long> f29965j;

    /* renamed from: k  reason: collision with root package name */
    List<d> f29966k;

    /* renamed from: l  reason: collision with root package name */
    protected List<Long> f29967l;

    /* renamed from: m  reason: collision with root package name */
    protected List<b> f29968m;

    /* renamed from: n  reason: collision with root package name */
    protected List<b> f29969n;

    /* renamed from: o  reason: collision with root package name */
    private long f29970o;

    /* compiled from: HistoryViewModel.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f29971a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f29972b = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HistoryViewModel.java */
    /* loaded from: classes2.dex */
    public static class c extends j0.d<Long, Long> {
        /* JADX INFO: Access modifiers changed from: private */
        public long d() {
            return ((Long) this.f29364a).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long e() {
            return ((Long) this.f29365b).longValue();
        }

        private c(long j10, long j11) {
            super(Long.valueOf(j10), Long.valueOf(j11));
        }
    }

    /* compiled from: HistoryViewModel.java */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f29973a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f29974b = 0;
    }

    static {
        TimeUnit.MINUTES.toMillis(30L);
    }

    public w() {
        new nf.a();
        new nf.a();
        new nf.a();
        new nf.a();
        new nf.a();
        new nf.c();
        new nf.c();
        new nf.a();
        new nf.a();
        new nf.a();
        new nf.a();
        new nf.c();
        new nf.c();
        new nf.c();
        new nf.c();
    }

    private boolean A(long j10, long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int B(e eVar, e eVar2) {
        return -eVar.f35420d.compareTo(eVar2.f35420d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(h hVar, Collection collection) {
        if (this.f29962g) {
            this.f29962g = false;
            this.f29958c.f(null);
        }
        c cVar = this.f29963h;
        if (cVar != null) {
            o(cVar.d(), this.f29963h.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(h hVar, SparseArray sparseArray) {
        if (this.f29962g) {
            this.f29962g = false;
            this.f29958c.f(null);
        }
        if (this.f29963h != null) {
            this.f29957b.f(sparseArray.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f29962g = false;
        this.f29963h = null;
        this.f29964i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(long j10, long j11, final int i10) {
        final Map<Long, List<gg.c>> u10 = u(j10, j11);
        ig.b.J().j().post(new Runnable() { // from class: kh.p
            @Override // java.lang.Runnable
            public final void run() {
                w.this.G(i10, u10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(int i10, Map map) {
        if (i10 == 1) {
            this.f29961f.f(map);
        } else {
            this.f29960e.f(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(List list) {
        this.f29959d.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(long j10, long j11) {
        final List<gg.c> w10 = w(ig.b.J().z().h(DataType.ArtyData, j10, j11), j10);
        ig.b.J().j().post(new Runnable() { // from class: kh.s
            @Override // java.lang.Runnable
            public final void run() {
                w.this.H(w10);
            }
        });
    }

    private gg.c K(List<f> list, long j10) {
        gg.a aVar;
        int i10;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        long j11 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = Integer.MAX_VALUE;
        int i20 = Integer.MIN_VALUE;
        for (f fVar : list) {
            if (fVar instanceof gg.b) {
                i15 = ((gg.b) fVar).f27456c;
                i10 = fVar.f27465b;
                i17 += i15;
                if (i15 > i20) {
                    i11 = i10;
                    i20 = i15;
                }
                if (i10 < i12) {
                    i12 = i10;
                    i19 = i15;
                }
            } else {
                i10 = fVar.f27465b;
                if (i10 > i11) {
                    i11 = i10;
                }
                if (i10 < i12) {
                    i12 = i10;
                    i16 = i12;
                    i18++;
                    i14 += i16;
                    j11 = fVar.f27464a;
                }
            }
            i16 = i10;
            i18++;
            i14 += i16;
            j11 = fVar.f27464a;
        }
        if (i17 > 0) {
            int i21 = i18 > 0 ? i14 / i18 : 0;
            int i22 = i18 > 0 ? i12 : 0;
            int i23 = i18 > 0 ? i11 : 0;
            int i24 = i15;
            gg.a aVar2 = new gg.a(i21, i22, i23, j10, list, i16, j11);
            aVar2.f27452h = i18 > 0 ? i17 / i18 : 0;
            if (i18 <= 0) {
                i19 = 0;
            }
            aVar2.f27453i = i19;
            if (i18 > 0) {
                i13 = i20;
            }
            aVar2.f27454j = i13;
            aVar2.f27455k = i24;
            aVar = aVar2;
        } else {
            aVar = new gg.c(i18 > 0 ? i14 / i18 : 0, i18 > 0 ? i12 : 0, i18 > 0 ? i11 : 0, j10, list, i16, j11);
        }
        return aVar;
    }

    private void m() {
        if (!A(this.f29970o, Calendar.getInstance().getTimeInMillis())) {
            z();
        }
    }

    private List<gg.c> w(List<qf.a> list, long j10) {
        Iterator<qf.a> it;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        ArrayList arrayList4 = new ArrayList(list.size());
        ArrayList arrayList5 = new ArrayList(list.size());
        ArrayList arrayList6 = new ArrayList(list.size());
        ArrayList arrayList7 = new ArrayList(list.size());
        Iterator<qf.a> it2 = list.iterator();
        while (it2.hasNext()) {
            qf.a next = it2.next();
            float[] f10 = next.f();
            if (f10 != null) {
                int i10 = 0;
                while (i10 < f10.length) {
                    com.mobvoi.android.common.utils.k.h("health.vm.history", " updateArtyData index = " + i10 + " pointValues[index] = " + f10[i10]);
                    if (i10 == 0) {
                        arrayList = arrayList7;
                        it = it2;
                        arrayList2.add(new f(next.f33128d, (int) f10[i10 + 1]));
                    } else if (i10 == 1) {
                        arrayList = arrayList7;
                        it = it2;
                        arrayList3.add(new f(next.f33128d, (int) f10[i10 + 1]));
                    } else if (i10 == 2) {
                        arrayList = arrayList7;
                        it = it2;
                        arrayList4.add(new f(next.f33128d, (int) f10[i10 + 1]));
                    } else if (i10 == 3) {
                        arrayList = arrayList7;
                        it = it2;
                        arrayList5.add(new f(next.f33128d, (int) f10[i10 + 1]));
                    } else if (i10 != 4) {
                        arrayList = arrayList7;
                        it = it2;
                    } else {
                        it = it2;
                        arrayList = arrayList7;
                        arrayList6.add(new gg.b(next.f33128d, (int) f10[i10 + 1], (int) f10[i10 + 2]));
                    }
                    i10++;
                    it2 = it;
                    arrayList7 = arrayList;
                }
            }
            arrayList7 = arrayList7;
            it2 = it2;
        }
        arrayList7.add(K(arrayList2, j10));
        arrayList7.add(K(arrayList3, j10));
        arrayList7.add(K(arrayList4, j10));
        arrayList7.add(K(arrayList5, j10));
        arrayList7.add(K(arrayList6, j10));
        return arrayList7;
    }

    private void z() {
        this.f29970o = System.currentTimeMillis();
        this.f29965j = new ArrayList();
        this.f29967l = new ArrayList();
        this.f29966k = new ArrayList();
        this.f29968m = new ArrayList();
        this.f29969n = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        Calendar a10 = bh.b.a();
        d dVar = new d();
        b bVar = new b();
        b bVar2 = new b();
        dVar.f29973a = a10.getTimeInMillis();
        while (a10.before(calendar)) {
            a10.set(11, 0);
            a10.set(12, 0);
            a10.set(13, 0);
            a10.set(14, 0);
            this.f29967l.add(Long.valueOf(a10.getTimeInMillis()));
            int size = this.f29967l.size() - 1;
            int i10 = a10.get(7);
            if (2 == i10) {
                dVar = new d();
                dVar.f29973a = a10.getTimeInMillis();
                bVar = new b();
                bVar.f29971a = size;
            } else if (1 == i10) {
                dVar.f29974b = a10.getTimeInMillis();
                this.f29966k.add(dVar);
                bVar.f29972b = size;
                this.f29968m.add(bVar);
            }
            int i11 = a10.get(5);
            if (1 == i11) {
                bVar2 = new b();
                bVar2.f29971a = size;
            } else if (a10.getActualMaximum(5) == i11) {
                bVar2.f29972b = size;
                this.f29969n.add(bVar2);
                this.f29965j.add(Long.valueOf(a10.getTimeInMillis()));
            }
            a10.add(6, 1);
        }
        if (dVar.f29974b == 0) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
            calendar2.setFirstDayOfWeek(2);
            calendar2.set(7, 1);
            dVar.f29974b = calendar2.getTimeInMillis();
            this.f29966k.add(dVar);
        }
        if (bVar.f29972b == 0) {
            bVar.f29972b = this.f29967l.size() - 1;
            this.f29968m.add(bVar);
        }
        if (bVar2.f29972b == 0) {
            bVar2.f29972b = this.f29967l.size() - 1;
            this.f29969n.add(bVar2);
            this.f29965j.add(Long.valueOf(calendar.getTimeInMillis()));
        }
    }

    public void J(long j10, long j11) {
        com.mobvoi.android.common.utils.k.c("health.vm.history", "Reload history from %d (%s) to %d (%s)", Long.valueOf(j10), new Date(j10), Long.valueOf(j11), new Date(j11));
        this.f29963h = new c(j10, j11);
        o(j10, j11);
    }

    public void L(final long j10, final long j11, final int i10) {
        ig.b.J().m().post(new Runnable() { // from class: kh.r
            @Override // java.lang.Runnable
            public final void run() {
                w.this.F(j10, j11, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(long j10, long j11) {
        if (this.f29964i != null) {
            pg.b.q().o(this.f29964i, j10, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(final long j10, final long j11) {
        ig.b.J().m().post(new Runnable() { // from class: kh.q
            @Override // java.lang.Runnable
            public final void run() {
                w.this.I(j10, j11);
            }
        });
    }

    @Override // nf.g
    protected void c(m mVar) {
        z();
        mVar.a(j.c(yg.f.X().N(), new k() { // from class: kh.v
            @Override // nf.k
            public final void i(h hVar, Object obj) {
                w.this.C(hVar, (Collection) obj);
            }
        }));
        this.f29964i = new k() { // from class: kh.u
            @Override // nf.k
            public final void i(h hVar, Object obj) {
                w.this.D(hVar, (SparseArray) obj);
            }
        };
        mVar.a(j.c(pg.b.q().e(), this.f29964i));
        mVar.a(n.a(new Runnable() { // from class: kh.o
            @Override // java.lang.Runnable
            public final void run() {
                w.this.E();
            }
        }));
    }

    protected abstract void n(long j10, long j11);

    protected abstract void o(long j10, long j11);

    public void p(long j10, long j11) {
        com.mobvoi.android.common.utils.k.i("health.vm.history", "Fetch history from cloud from %d (%s) to %d (%s)", Long.valueOf(j10), new Date(j10), Long.valueOf(j11), new Date(j11));
        this.f29962g = true;
        n(j10, j11);
    }

    public h<Map<Long, List<gg.c>>> q() {
        return this.f29961f;
    }

    public h<SparseArray<oh.a>> r() {
        return this.f29957b;
    }

    public List<Long> s() {
        m();
        return this.f29967l;
    }

    public h<Map<Long, List<gg.c>>> t() {
        return this.f29960e;
    }

    public Map<Long, List<gg.c>> u(long j10, long j11) {
        List<qf.a> h10 = ig.b.J().z().h(DataType.ArtyData, j10, j11);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (qf.a aVar : h10) {
            long b10 = eg.c.b(aVar.f33129e);
            if (!hashMap2.containsKey(Long.valueOf(b10))) {
                hashMap2.put(Long.valueOf(b10), new ArrayList());
            }
            ((List) hashMap2.get(Long.valueOf(b10))).add(aVar);
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            hashMap.put((Long) entry.getKey(), w((List) entry.getValue(), ((Long) entry.getKey()).longValue()));
        }
        return hashMap;
    }

    public List<Long> v() {
        m();
        return this.f29965j;
    }

    public h<Object> x() {
        return this.f29958c;
    }

    public List<d> y() {
        m();
        return this.f29966k;
    }
}
