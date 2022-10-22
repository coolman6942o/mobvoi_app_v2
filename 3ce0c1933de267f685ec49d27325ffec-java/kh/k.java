package kh;

import android.content.Context;
import android.util.SparseArray;
import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.DataType;
import ef.u;
import hf.o;
import ig.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import nf.a;
import nf.h;
import qf.c;
import yg.f;
/* compiled from: HealthDetailCalendarViewModel.java */
/* loaded from: classes2.dex */
public class k extends w {

    /* renamed from: r  reason: collision with root package name */
    private int f29929r;

    /* renamed from: s  reason: collision with root package name */
    private final h<List<Integer>> f29930s = new a();

    public k(Context context, int i10) {
        this.f29929r = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(List list) {
        this.f29930s.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DataType dataType, long j10, long j11) {
        List<qf.a> h10 = b.J().z().h(dataType, j10, j11);
        final ArrayList arrayList = new ArrayList();
        if (h10 != null && h10.size() > 0) {
            Calendar calendar = Calendar.getInstance();
            for (qf.a aVar : h10) {
                calendar.setTimeInMillis(aVar.f33129e);
                int i10 = calendar.get(5);
                if (!arrayList.contains(Integer.valueOf(i10))) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            Collections.sort(arrayList);
        }
        b.J().j().post(new Runnable() { // from class: kh.f
            @Override // java.lang.Runnable
            public final void run() {
                k.this.Z(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(List list) {
        this.f29930s.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Collection collection, Throwable th2) {
        final ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Calendar calendar = Calendar.getInstance();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                calendar.setTimeInMillis(((u) it.next()).f25989h);
                int i10 = calendar.get(5);
                if (!arrayList.contains(Integer.valueOf(i10))) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            Collections.sort(arrayList);
        }
        b.J().j().post(new Runnable() { // from class: kh.g
            @Override // java.lang.Runnable
            public final void run() {
                k.this.b0(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(List list) {
        this.f29930s.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(long j10, long j11) {
        oh.b bVar = new oh.b(com.mobvoi.android.common.utils.b.e(), b.J());
        bVar.e(j10, j11);
        bVar.d(ta.a.x(), null);
        SparseArray<oh.a> b10 = bVar.b();
        final ArrayList arrayList = new ArrayList();
        if (b10 != null && b10.size() > 0) {
            Calendar calendar = Calendar.getInstance();
            for (int i10 = 0; i10 < b10.size(); i10++) {
                calendar.setTimeInMillis(TimeUnit.SECONDS.toMillis(b10.valueAt(i10).d()));
                int i11 = calendar.get(5);
                if (!arrayList.contains(Integer.valueOf(i11))) {
                    arrayList.add(Integer.valueOf(i11));
                }
            }
            Collections.sort(arrayList);
        }
        b.J().j().post(new Runnable() { // from class: kh.i
            @Override // java.lang.Runnable
            public final void run() {
                k.this.d0(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(List list) {
        this.f29930s.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(long j10, long j11) {
        List<rh.b> a10 = b.J().I().a(j10, j11);
        final ArrayList arrayList = new ArrayList();
        if (a10 != null && a10.size() > 0) {
            Calendar calendar = Calendar.getInstance();
            for (rh.b bVar : a10) {
                calendar.setTimeInMillis(bVar.f33518a);
                int i10 = calendar.get(5);
                if (!arrayList.contains(Integer.valueOf(i10))) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            Collections.sort(arrayList);
        }
        b.J().j().post(new Runnable() { // from class: kh.j
            @Override // java.lang.Runnable
            public final void run() {
                k.this.f0(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(List list) {
        this.f29930s.f(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(long j10, long j11) {
        List<c> h10 = b.J().K().k().h(ActivityType.AutoSleep, j10, j11);
        final ArrayList arrayList = new ArrayList();
        if (h10 != null && h10.size() > 0) {
            Calendar calendar = Calendar.getInstance();
            for (c cVar : h10) {
                calendar.setTimeInMillis(cVar.f33128d);
                int i10 = calendar.get(5);
                if (!arrayList.contains(Integer.valueOf(i10))) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            Collections.sort(arrayList);
        }
        b.J().j().post(new Runnable() { // from class: kh.h
            @Override // java.lang.Runnable
            public final void run() {
                k.this.h0(arrayList);
            }
        });
    }

    private void j0() {
        this.f29930s.f(new ArrayList());
    }

    private void k0(final DataType dataType, final long j10, final long j11) {
        b.J().m().post(new Runnable() { // from class: kh.e
            @Override // java.lang.Runnable
            public final void run() {
                k.this.a0(dataType, j10, j11);
            }
        });
    }

    private void l0(long j10, long j11) {
        f.X().G(new Date(j11), new Date(j10), -1, null, new o() { // from class: kh.a
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                k.this.c0((Collection) obj, th2);
            }
        });
    }

    private void m0(final long j10, final long j11) {
        b.J().m().post(new Runnable() { // from class: kh.b
            @Override // java.lang.Runnable
            public final void run() {
                k.this.e0(j10, j11);
            }
        });
    }

    private void n0(final long j10, final long j11) {
        b.J().m().post(new Runnable() { // from class: kh.c
            @Override // java.lang.Runnable
            public final void run() {
                k.this.g0(j10, j11);
            }
        });
    }

    private void o0(final long j10, final long j11) {
        b.J().m().post(new Runnable() { // from class: kh.d
            @Override // java.lang.Runnable
            public final void run() {
                k.this.i0(j10, j11);
            }
        });
    }

    public h<List<Integer>> Y() {
        return this.f29930s;
    }

    @Override // kh.w
    protected void n(long j10, long j11) {
        b.J().w(Long.valueOf(j10), Long.valueOf(j11));
        f.X().F(new Date(j11), new Date(j10), Integer.MAX_VALUE);
    }

    @Override // kh.w
    protected void o(long j10, long j11) {
        int i10 = this.f29929r;
        if (i10 == 4) {
            o0(j10, j11);
        } else if (i10 == 1 || i10 == 9) {
            n0(j10, j11);
        } else if (i10 == 2) {
            k0(DataType.BloodOxygen, j10, j11);
        } else if (i10 == 3) {
            k0(DataType.Pressure, j10, j11);
        } else if (i10 == 5) {
            k0(DataType.NOISE_DECIBEL, j10, j11);
        } else if (i10 == 7) {
            m0(j10, j11);
        } else if (i10 == 6) {
            l0(j10, j11);
        } else if (i10 == 8) {
            k0(DataType.Temperature, j10, j11);
        } else if (i10 == 10) {
            k0(DataType.BodyAndMindState, j10, j11);
        } else if (i10 == 11) {
            j0();
        }
    }
}
