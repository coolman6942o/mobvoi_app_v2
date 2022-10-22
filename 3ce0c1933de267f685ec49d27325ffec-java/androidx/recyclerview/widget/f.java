package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import g0.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    static final ThreadLocal<f> f4017e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    static Comparator<c> f4018f = new a();

    /* renamed from: b  reason: collision with root package name */
    long f4020b;

    /* renamed from: c  reason: collision with root package name */
    long f4021c;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<RecyclerView> f4019a = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<c> f4022d = new ArrayList<>();

    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    class a implements Comparator<c> {
        a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f4030d;
            if ((recyclerView == null) != (cVar2.f4030d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f4027a;
            if (z10 != cVar2.f4027a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f4028b - cVar.f4028b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f4029c - cVar2.f4029c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.LayoutManager.c {

        /* renamed from: a  reason: collision with root package name */
        int f4023a;

        /* renamed from: b  reason: collision with root package name */
        int f4024b;

        /* renamed from: c  reason: collision with root package name */
        int[] f4025c;

        /* renamed from: d  reason: collision with root package name */
        int f4026d;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i11 >= 0) {
                int i12 = this.f4026d * 2;
                int[] iArr = this.f4025c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f4025c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i12 >= iArr.length) {
                    int[] iArr3 = new int[i12 * 2];
                    this.f4025c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f4025c;
                iArr4[i12] = i10;
                iArr4[i12 + 1] = i11;
                this.f4026d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f4025c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4026d = 0;
        }

        void c(RecyclerView recyclerView, boolean z10) {
            this.f4026d = 0;
            int[] iArr = this.f4025c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.f3753m;
            if (recyclerView.f3751l != null && layoutManager != null && layoutManager.v0()) {
                if (z10) {
                    if (!recyclerView.f3741d.p()) {
                        layoutManager.q(recyclerView.f3751l.getItemCount(), this);
                    }
                } else if (!recyclerView.r0()) {
                    layoutManager.p(this.f4023a, this.f4024b, recyclerView.f3764r0, this);
                }
                int i10 = this.f4026d;
                if (i10 > layoutManager.f3793m) {
                    layoutManager.f3793m = i10;
                    layoutManager.f3794n = z10;
                    recyclerView.f3739b.K();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean d(int i10) {
            if (this.f4025c != null) {
                int i11 = this.f4026d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f4025c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i10, int i11) {
            this.f4023a = i10;
            this.f4024b = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4027a;

        /* renamed from: b  reason: collision with root package name */
        public int f4028b;

        /* renamed from: c  reason: collision with root package name */
        public int f4029c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f4030d;

        /* renamed from: e  reason: collision with root package name */
        public int f4031e;

        c() {
        }

        public void a() {
            this.f4027a = false;
            this.f4028b = 0;
            this.f4029c = 0;
            this.f4030d = null;
            this.f4031e = 0;
        }
    }

    private void b() {
        c cVar;
        int size = this.f4019a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f4019a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f3762q0.c(recyclerView, false);
                i10 += recyclerView.f3762q0.f4026d;
            }
        }
        this.f4022d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f4019a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f3762q0;
                int abs = Math.abs(bVar.f4023a) + Math.abs(bVar.f4024b);
                for (int i14 = 0; i14 < bVar.f4026d * 2; i14 += 2) {
                    if (i12 >= this.f4022d.size()) {
                        cVar = new c();
                        this.f4022d.add(cVar);
                    } else {
                        cVar = this.f4022d.get(i12);
                    }
                    int[] iArr = bVar.f4025c;
                    int i15 = iArr[i14 + 1];
                    cVar.f4027a = i15 <= abs;
                    cVar.f4028b = abs;
                    cVar.f4029c = i15;
                    cVar.f4030d = recyclerView2;
                    cVar.f4031e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f4022d, f4018f);
    }

    private void c(c cVar, long j10) {
        RecyclerView.b0 i10 = i(cVar.f4030d, cVar.f4031e, cVar.f4027a ? Long.MAX_VALUE : j10);
        if (i10 != null && i10.mNestedRecyclerView != null && i10.isBound() && !i10.isInvalid()) {
            h(i10.mNestedRecyclerView.get(), j10);
        }
    }

    private void d(long j10) {
        for (int i10 = 0; i10 < this.f4022d.size(); i10++) {
            c cVar = this.f4022d.get(i10);
            if (cVar.f4030d != null) {
                c(cVar, j10);
                cVar.a();
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.f3742e.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.b0 j02 = RecyclerView.j0(recyclerView.f3742e.i(i11));
            if (j02.mPosition == i10 && !j02.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j10) {
        if (recyclerView != null) {
            if (recyclerView.E && recyclerView.f3742e.j() != 0) {
                recyclerView.a1();
            }
            b bVar = recyclerView.f3762q0;
            bVar.c(recyclerView, true);
            if (bVar.f4026d != 0) {
                try {
                    j.a("RV Nested Prefetch");
                    recyclerView.f3764r0.f(recyclerView.f3751l);
                    for (int i10 = 0; i10 < bVar.f4026d * 2; i10 += 2) {
                        i(recyclerView, bVar.f4025c[i10], j10);
                    }
                } finally {
                    j.b();
                }
            }
        }
    }

    private RecyclerView.b0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f3739b;
        try {
            recyclerView.M0();
            RecyclerView.b0 I = uVar.I(i10, false, j10);
            if (I != null) {
                if (!I.isBound() || I.isInvalid()) {
                    uVar.a(I, false);
                } else {
                    uVar.B(I.itemView);
                }
            }
            return I;
        } finally {
            recyclerView.O0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f4019a.add(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f4020b == 0) {
            this.f4020b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f3762q0.e(i10, i11);
    }

    void g(long j10) {
        b();
        d(j10);
    }

    public void j(RecyclerView recyclerView) {
        this.f4019a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            j.a("RV Prefetch");
            if (!this.f4019a.isEmpty()) {
                int size = this.f4019a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f4019a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f4021c);
                }
            }
        } finally {
            this.f4020b = 0L;
            j.b();
        }
    }
}
