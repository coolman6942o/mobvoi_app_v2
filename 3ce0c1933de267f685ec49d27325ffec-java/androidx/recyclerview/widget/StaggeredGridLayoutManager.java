package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.x.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private int[] O;

    /* renamed from: t  reason: collision with root package name */
    d[] f3875t;

    /* renamed from: u  reason: collision with root package name */
    m f3876u;

    /* renamed from: v  reason: collision with root package name */
    m f3877v;

    /* renamed from: w  reason: collision with root package name */
    private int f3878w;

    /* renamed from: x  reason: collision with root package name */
    private int f3879x;

    /* renamed from: s  reason: collision with root package name */
    private int f3874s = -1;

    /* renamed from: z  reason: collision with root package name */
    boolean f3881z = false;
    boolean A = false;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    /* renamed from: y  reason: collision with root package name */
    private final j f3880y = new j();

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3888a;

        /* renamed from: b  reason: collision with root package name */
        int f3889b;

        /* renamed from: c  reason: collision with root package name */
        int f3890c;

        /* renamed from: d  reason: collision with root package name */
        int[] f3891d;

        /* renamed from: e  reason: collision with root package name */
        int f3892e;

        /* renamed from: f  reason: collision with root package name */
        int[] f3893f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f3894g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3895h;

        /* renamed from: i  reason: collision with root package name */
        boolean f3896i;

        /* renamed from: j  reason: collision with root package name */
        boolean f3897j;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        void a() {
            this.f3891d = null;
            this.f3890c = 0;
            this.f3888a = -1;
            this.f3889b = -1;
        }

        void b() {
            this.f3891d = null;
            this.f3890c = 0;
            this.f3892e = 0;
            this.f3893f = null;
            this.f3894g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3888a);
            parcel.writeInt(this.f3889b);
            parcel.writeInt(this.f3890c);
            if (this.f3890c > 0) {
                parcel.writeIntArray(this.f3891d);
            }
            parcel.writeInt(this.f3892e);
            if (this.f3892e > 0) {
                parcel.writeIntArray(this.f3893f);
            }
            parcel.writeInt(this.f3895h ? 1 : 0);
            parcel.writeInt(this.f3896i ? 1 : 0);
            parcel.writeInt(this.f3897j ? 1 : 0);
            parcel.writeList(this.f3894g);
        }

        SavedState(Parcel parcel) {
            this.f3888a = parcel.readInt();
            this.f3889b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3890c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3891d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3892e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3893f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z10 = false;
            this.f3895h = parcel.readInt() == 1;
            this.f3896i = parcel.readInt() == 1;
            this.f3897j = parcel.readInt() == 1 ? true : z10;
            this.f3894g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3890c = savedState.f3890c;
            this.f3888a = savedState.f3888a;
            this.f3889b = savedState.f3889b;
            this.f3891d = savedState.f3891d;
            this.f3892e = savedState.f3892e;
            this.f3893f = savedState.f3893f;
            this.f3895h = savedState.f3895h;
            this.f3896i = savedState.f3896i;
            this.f3897j = savedState.f3897j;
            this.f3894g = savedState.f3894g;
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f3899a;

        /* renamed from: b  reason: collision with root package name */
        int f3900b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3901c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3902d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3903e;

        /* renamed from: f  reason: collision with root package name */
        int[] f3904f;

        b() {
            c();
        }

        void a() {
            this.f3900b = this.f3901c ? StaggeredGridLayoutManager.this.f3876u.i() : StaggeredGridLayoutManager.this.f3876u.m();
        }

        void b(int i10) {
            if (this.f3901c) {
                this.f3900b = StaggeredGridLayoutManager.this.f3876u.i() - i10;
            } else {
                this.f3900b = StaggeredGridLayoutManager.this.f3876u.m() + i10;
            }
        }

        void c() {
            this.f3899a = -1;
            this.f3900b = Integer.MIN_VALUE;
            this.f3901c = false;
            this.f3902d = false;
            this.f3903e = false;
            int[] iArr = this.f3904f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f3904f;
            if (iArr == null || iArr.length < length) {
                this.f3904f = new int[StaggeredGridLayoutManager.this.f3875t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f3904f[i10] = dVarArr[i10].r(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.o {

        /* renamed from: e  reason: collision with root package name */
        d f3906e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3907f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f3907f;
        }

        public void f(boolean z10) {
            this.f3907f = z10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f3908a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f3909b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f3910c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f3911d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f3912e;

        d(int i10) {
            this.f3912e = i10;
        }

        void a(View view) {
            c p10 = p(view);
            p10.f3906e = this;
            this.f3908a.add(view);
            this.f3910c = Integer.MIN_VALUE;
            if (this.f3908a.size() == 1) {
                this.f3909b = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3911d += StaggeredGridLayoutManager.this.f3876u.e(view);
            }
        }

        void b(boolean z10, int i10) {
            int i11;
            if (z10) {
                i11 = n(Integer.MIN_VALUE);
            } else {
                i11 = r(Integer.MIN_VALUE);
            }
            e();
            if (i11 != Integer.MIN_VALUE) {
                if (z10 && i11 < StaggeredGridLayoutManager.this.f3876u.i()) {
                    return;
                }
                if (z10 || i11 <= StaggeredGridLayoutManager.this.f3876u.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        i11 += i10;
                    }
                    this.f3910c = i11;
                    this.f3909b = i11;
                }
            }
        }

        void c() {
            LazySpanLookup.FullSpanItem f10;
            ArrayList<View> arrayList = this.f3908a;
            View view = arrayList.get(arrayList.size() - 1);
            c p10 = p(view);
            this.f3910c = StaggeredGridLayoutManager.this.f3876u.d(view);
            if (p10.f3907f && (f10 = StaggeredGridLayoutManager.this.E.f(p10.a())) != null && f10.f3885b == 1) {
                this.f3910c += f10.a(this.f3912e);
            }
        }

        void d() {
            LazySpanLookup.FullSpanItem f10;
            View view = this.f3908a.get(0);
            c p10 = p(view);
            this.f3909b = StaggeredGridLayoutManager.this.f3876u.g(view);
            if (p10.f3907f && (f10 = StaggeredGridLayoutManager.this.E.f(p10.a())) != null && f10.f3885b == -1) {
                this.f3909b -= f10.a(this.f3912e);
            }
        }

        void e() {
            this.f3908a.clear();
            s();
            this.f3911d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f3881z) {
                return j(this.f3908a.size() - 1, -1, true);
            }
            return j(0, this.f3908a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f3881z) {
                return k(0, this.f3908a.size(), true);
            }
            return k(this.f3908a.size() - 1, -1, true);
        }

        public int h() {
            if (StaggeredGridLayoutManager.this.f3881z) {
                return j(0, this.f3908a.size(), true);
            }
            return j(this.f3908a.size() - 1, -1, true);
        }

        int i(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int m10 = StaggeredGridLayoutManager.this.f3876u.m();
            int i12 = StaggeredGridLayoutManager.this.f3876u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f3908a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f3876u.g(view);
                int d10 = StaggeredGridLayoutManager.this.f3876u.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? g10 < i12 : g10 <= i12;
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (!z10 || !z11) {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                        if (g10 < m10 || d10 > i12) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    } else if (g10 >= m10 && d10 <= i12) {
                        return StaggeredGridLayoutManager.this.i0(view);
                    }
                }
                i10 += i13;
            }
            return -1;
        }

        int j(int i10, int i11, boolean z10) {
            return i(i10, i11, false, false, z10);
        }

        int k(int i10, int i11, boolean z10) {
            return i(i10, i11, z10, true, false);
        }

        public int l() {
            return this.f3911d;
        }

        int m() {
            int i10 = this.f3910c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f3910c;
        }

        int n(int i10) {
            int i11 = this.f3910c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3908a.size() == 0) {
                return i10;
            }
            c();
            return this.f3910c;
        }

        public View o(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f3908a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f3908a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3881z && staggeredGridLayoutManager.i0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3881z && staggeredGridLayoutManager2.i0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3908a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f3908a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3881z && staggeredGridLayoutManager3.i0(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3881z && staggeredGridLayoutManager4.i0(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        c p(View view) {
            return (c) view.getLayoutParams();
        }

        int q() {
            int i10 = this.f3909b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f3909b;
        }

        int r(int i10) {
            int i11 = this.f3909b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3908a.size() == 0) {
                return i10;
            }
            d();
            return this.f3909b;
        }

        void s() {
            this.f3909b = Integer.MIN_VALUE;
            this.f3910c = Integer.MIN_VALUE;
        }

        void t(int i10) {
            int i11 = this.f3909b;
            if (i11 != Integer.MIN_VALUE) {
                this.f3909b = i11 + i10;
            }
            int i12 = this.f3910c;
            if (i12 != Integer.MIN_VALUE) {
                this.f3910c = i12 + i10;
            }
        }

        void u() {
            int size = this.f3908a.size();
            View remove = this.f3908a.remove(size - 1);
            c p10 = p(remove);
            p10.f3906e = null;
            if (p10.c() || p10.b()) {
                this.f3911d -= StaggeredGridLayoutManager.this.f3876u.e(remove);
            }
            if (size == 1) {
                this.f3909b = Integer.MIN_VALUE;
            }
            this.f3910c = Integer.MIN_VALUE;
        }

        void v() {
            View remove = this.f3908a.remove(0);
            c p10 = p(remove);
            p10.f3906e = null;
            if (this.f3908a.size() == 0) {
                this.f3910c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3911d -= StaggeredGridLayoutManager.this.f3876u.e(remove);
            }
            this.f3909b = Integer.MIN_VALUE;
        }

        void w(View view) {
            c p10 = p(view);
            p10.f3906e = this;
            this.f3908a.add(0, view);
            this.f3909b = Integer.MIN_VALUE;
            if (this.f3908a.size() == 1) {
                this.f3910c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3911d += StaggeredGridLayoutManager.this.f3876u.e(view);
            }
        }

        void x(int i10) {
            this.f3909b = i10;
            this.f3910c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.LayoutManager.Properties j02 = RecyclerView.LayoutManager.j0(context, attributeSet, i10, i11);
        L2(j02.orientation);
        N2(j02.spanCount);
        M2(j02.reverseLayout);
        b2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0157, code lost:
        if (T1() != false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A2(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        SavedState savedState;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && yVar.b() == 0) {
            l1(uVar);
            bVar.c();
            return;
        }
        boolean z11 = true;
        boolean z12 = (bVar.f3903e && this.C == -1 && this.I == null) ? false : true;
        if (z12) {
            bVar.c();
            if (this.I != null) {
                O1(bVar);
            } else {
                I2();
                bVar.f3901c = this.A;
            }
            R2(yVar, bVar);
            bVar.f3903e = true;
        }
        if (this.I == null && this.C == -1 && !(bVar.f3901c == this.G && x2() == this.H)) {
            this.E.b();
            bVar.f3902d = true;
        }
        if (K() > 0 && ((savedState = this.I) == null || savedState.f3890c < 1)) {
            if (bVar.f3902d) {
                for (int i10 = 0; i10 < this.f3874s; i10++) {
                    this.f3875t[i10].e();
                    int i11 = bVar.f3900b;
                    if (i11 != Integer.MIN_VALUE) {
                        this.f3875t[i10].x(i11);
                    }
                }
            } else if (z12 || this.L.f3904f == null) {
                for (int i12 = 0; i12 < this.f3874s; i12++) {
                    this.f3875t[i12].b(this.A, bVar.f3900b);
                }
                this.L.d(this.f3875t);
            } else {
                for (int i13 = 0; i13 < this.f3874s; i13++) {
                    d dVar = this.f3875t[i13];
                    dVar.e();
                    dVar.x(this.L.f3904f[i13]);
                }
            }
        }
        x(uVar);
        this.f3880y.f4086a = false;
        this.M = false;
        T2(this.f3877v.n());
        S2(bVar.f3899a, yVar);
        if (bVar.f3901c) {
            K2(-1);
            c2(uVar, this.f3880y, yVar);
            K2(1);
            j jVar = this.f3880y;
            jVar.f4088c = bVar.f3899a + jVar.f4089d;
            c2(uVar, jVar, yVar);
        } else {
            K2(1);
            c2(uVar, this.f3880y, yVar);
            K2(-1);
            j jVar2 = this.f3880y;
            jVar2.f4088c = bVar.f3899a + jVar2.f4089d;
            c2(uVar, jVar2, yVar);
        }
        H2();
        if (K() > 0) {
            if (this.A) {
                j2(uVar, yVar, true);
                k2(uVar, yVar, false);
            } else {
                k2(uVar, yVar, true);
                j2(uVar, yVar, false);
            }
        }
        if (z10 && !yVar.e()) {
            if (this.F != 0 && K() > 0 && (this.M || v2() != null)) {
                p1(this.P);
            }
        }
        z11 = false;
        if (yVar.e()) {
            this.L.c();
        }
        this.G = bVar.f3901c;
        this.H = x2();
        if (z11) {
            this.L.c();
            A2(uVar, yVar, false);
        }
    }

    private boolean B2(int i10) {
        if (this.f3878w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == x2();
    }

    private void D2(View view) {
        for (int i10 = this.f3874s - 1; i10 >= 0; i10--) {
            this.f3875t[i10].w(view);
        }
    }

    private void E2(RecyclerView.u uVar, j jVar) {
        int i10;
        int i11;
        if (jVar.f4086a && !jVar.f4094i) {
            if (jVar.f4087b == 0) {
                if (jVar.f4090e == -1) {
                    F2(uVar, jVar.f4092g);
                } else {
                    G2(uVar, jVar.f4091f);
                }
            } else if (jVar.f4090e == -1) {
                int i12 = jVar.f4091f;
                int o22 = i12 - o2(i12);
                if (o22 < 0) {
                    i11 = jVar.f4092g;
                } else {
                    i11 = jVar.f4092g - Math.min(o22, jVar.f4087b);
                }
                F2(uVar, i11);
            } else {
                int p22 = p2(jVar.f4092g) - jVar.f4092g;
                if (p22 < 0) {
                    i10 = jVar.f4091f;
                } else {
                    i10 = Math.min(p22, jVar.f4087b) + jVar.f4091f;
                }
                G2(uVar, i10);
            }
        }
    }

    private void F2(RecyclerView.u uVar, int i10) {
        for (int K = K() - 1; K >= 0; K--) {
            View J = J(K);
            if (this.f3876u.g(J) >= i10 && this.f3876u.q(J) >= i10) {
                c cVar = (c) J.getLayoutParams();
                if (cVar.f3907f) {
                    for (int i11 = 0; i11 < this.f3874s; i11++) {
                        if (this.f3875t[i11].f3908a.size() == 1) {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f3874s; i12++) {
                        this.f3875t[i12].u();
                    }
                } else if (cVar.f3906e.f3908a.size() != 1) {
                    cVar.f3906e.u();
                } else {
                    return;
                }
                n1(J, uVar);
            } else {
                return;
            }
        }
    }

    private void G2(RecyclerView.u uVar, int i10) {
        while (K() > 0) {
            View J = J(0);
            if (this.f3876u.d(J) <= i10 && this.f3876u.p(J) <= i10) {
                c cVar = (c) J.getLayoutParams();
                if (cVar.f3907f) {
                    for (int i11 = 0; i11 < this.f3874s; i11++) {
                        if (this.f3875t[i11].f3908a.size() == 1) {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f3874s; i12++) {
                        this.f3875t[i12].v();
                    }
                } else if (cVar.f3906e.f3908a.size() != 1) {
                    cVar.f3906e.v();
                } else {
                    return;
                }
                n1(J, uVar);
            } else {
                return;
            }
        }
    }

    private void H2() {
        if (this.f3877v.k() != 1073741824) {
            float f10 = 0.0f;
            int K = K();
            for (int i10 = 0; i10 < K; i10++) {
                View J = J(i10);
                float e10 = this.f3877v.e(J);
                if (e10 >= f10) {
                    if (((c) J.getLayoutParams()).e()) {
                        e10 = (e10 * 1.0f) / this.f3874s;
                    }
                    f10 = Math.max(f10, e10);
                }
            }
            int i11 = this.f3879x;
            int round = Math.round(f10 * this.f3874s);
            if (this.f3877v.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f3877v.n());
            }
            T2(round);
            if (this.f3879x != i11) {
                for (int i12 = 0; i12 < K; i12++) {
                    View J2 = J(i12);
                    c cVar = (c) J2.getLayoutParams();
                    if (!cVar.f3907f) {
                        if (!x2() || this.f3878w != 1) {
                            int i13 = cVar.f3906e.f3912e;
                            int i14 = this.f3879x * i13;
                            int i15 = i13 * i11;
                            if (this.f3878w == 1) {
                                J2.offsetLeftAndRight(i14 - i15);
                            } else {
                                J2.offsetTopAndBottom(i14 - i15);
                            }
                        } else {
                            int i16 = this.f3874s;
                            int i17 = cVar.f3906e.f3912e;
                            J2.offsetLeftAndRight(((-((i16 - 1) - i17)) * this.f3879x) - ((-((i16 - 1) - i17)) * i11));
                        }
                    }
                }
            }
        }
    }

    private void I2() {
        if (this.f3878w == 1 || !x2()) {
            this.A = this.f3881z;
        } else {
            this.A = !this.f3881z;
        }
    }

    private void K2(int i10) {
        j jVar = this.f3880y;
        jVar.f4090e = i10;
        int i11 = 1;
        if (this.A != (i10 == -1)) {
            i11 = -1;
        }
        jVar.f4089d = i11;
    }

    private void N1(View view) {
        for (int i10 = this.f3874s - 1; i10 >= 0; i10--) {
            this.f3875t[i10].a(view);
        }
    }

    private void O1(b bVar) {
        int i10;
        SavedState savedState = this.I;
        int i11 = savedState.f3890c;
        if (i11 > 0) {
            if (i11 == this.f3874s) {
                for (int i12 = 0; i12 < this.f3874s; i12++) {
                    this.f3875t[i12].e();
                    SavedState savedState2 = this.I;
                    int i13 = savedState2.f3891d[i12];
                    if (i13 != Integer.MIN_VALUE) {
                        if (savedState2.f3896i) {
                            i10 = this.f3876u.i();
                        } else {
                            i10 = this.f3876u.m();
                        }
                        i13 += i10;
                    }
                    this.f3875t[i12].x(i13);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.I;
                savedState3.f3888a = savedState3.f3889b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.f3897j;
        M2(savedState4.f3895h);
        I2();
        SavedState savedState5 = this.I;
        int i14 = savedState5.f3888a;
        if (i14 != -1) {
            this.C = i14;
            bVar.f3901c = savedState5.f3896i;
        } else {
            bVar.f3901c = this.A;
        }
        if (savedState5.f3892e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f3882a = savedState5.f3893f;
            lazySpanLookup.f3883b = savedState5.f3894g;
        }
    }

    private void O2(int i10, int i11) {
        for (int i12 = 0; i12 < this.f3874s; i12++) {
            if (!this.f3875t[i12].f3908a.isEmpty()) {
                U2(this.f3875t[i12], i10, i11);
            }
        }
    }

    private boolean P2(RecyclerView.y yVar, b bVar) {
        int i10;
        if (this.G) {
            i10 = i2(yVar.b());
        } else {
            i10 = d2(yVar.b());
        }
        bVar.f3899a = i10;
        bVar.f3900b = Integer.MIN_VALUE;
        return true;
    }

    private void R1(View view, c cVar, j jVar) {
        if (jVar.f4090e == 1) {
            if (cVar.f3907f) {
                N1(view);
            } else {
                cVar.f3906e.a(view);
            }
        } else if (cVar.f3907f) {
            D2(view);
        } else {
            cVar.f3906e.w(view);
        }
    }

    private int S1(int i10) {
        if (K() == 0) {
            return this.A ? 1 : -1;
        }
        return (i10 < l2()) != this.A ? -1 : 1;
    }

    private void S2(int i10, RecyclerView.y yVar) {
        int i11;
        int i12;
        int c10;
        j jVar = this.f3880y;
        boolean z10 = false;
        jVar.f4087b = 0;
        jVar.f4088c = i10;
        if (!y0() || (c10 = yVar.c()) == -1) {
            i12 = 0;
            i11 = 0;
        } else {
            if (this.A == (c10 < i10)) {
                i12 = this.f3876u.n();
                i11 = 0;
            } else {
                i11 = this.f3876u.n();
                i12 = 0;
            }
        }
        if (N()) {
            this.f3880y.f4091f = this.f3876u.m() - i11;
            this.f3880y.f4092g = this.f3876u.i() + i12;
        } else {
            this.f3880y.f4092g = this.f3876u.h() + i12;
            this.f3880y.f4091f = -i11;
        }
        j jVar2 = this.f3880y;
        jVar2.f4093h = false;
        jVar2.f4086a = true;
        if (this.f3876u.k() == 0 && this.f3876u.h() == 0) {
            z10 = true;
        }
        jVar2.f4094i = z10;
    }

    private boolean U1(d dVar) {
        if (this.A) {
            if (dVar.m() < this.f3876u.i()) {
                ArrayList<View> arrayList = dVar.f3908a;
                return !dVar.p(arrayList.get(arrayList.size() - 1)).f3907f;
            }
        } else if (dVar.q() > this.f3876u.m()) {
            return !dVar.p(dVar.f3908a.get(0)).f3907f;
        }
        return false;
    }

    private void U2(d dVar, int i10, int i11) {
        int l10 = dVar.l();
        if (i10 == -1) {
            if (dVar.q() + l10 <= i11) {
                this.B.set(dVar.f3912e, false);
            }
        } else if (dVar.m() - l10 >= i11) {
            this.B.set(dVar.f3912e, false);
        }
    }

    private int V1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        return p.a(yVar, this.f3876u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int V2(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    private int W1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        return p.b(yVar, this.f3876u, f2(!this.N), e2(!this.N), this, this.N, this.A);
    }

    private int X1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        return p.c(yVar, this.f3876u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int Y1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3878w == 1) ? 1 : Integer.MIN_VALUE : this.f3878w == 0 ? 1 : Integer.MIN_VALUE : this.f3878w == 1 ? -1 : Integer.MIN_VALUE : this.f3878w == 0 ? -1 : Integer.MIN_VALUE : (this.f3878w != 1 && x2()) ? -1 : 1 : (this.f3878w != 1 && x2()) ? 1 : -1;
    }

    private LazySpanLookup.FullSpanItem Z1(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3886c = new int[this.f3874s];
        for (int i11 = 0; i11 < this.f3874s; i11++) {
            fullSpanItem.f3886c[i11] = i10 - this.f3875t[i11].n(i10);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem a2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3886c = new int[this.f3874s];
        for (int i11 = 0; i11 < this.f3874s; i11++) {
            fullSpanItem.f3886c[i11] = this.f3875t[i11].r(i10) - i10;
        }
        return fullSpanItem;
    }

    private void b2() {
        this.f3876u = m.b(this, this.f3878w);
        this.f3877v = m.b(this, 1 - this.f3878w);
    }

    private int c2(RecyclerView.u uVar, j jVar, RecyclerView.y yVar) {
        int i10;
        int i11;
        int i12;
        d dVar;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z10;
        boolean z11;
        int i17;
        int i18;
        boolean z12 = false;
        this.B.set(0, this.f3874s, true);
        if (this.f3880y.f4094i) {
            i10 = jVar.f4090e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (jVar.f4090e == 1) {
            i10 = jVar.f4092g + jVar.f4087b;
        } else {
            i10 = jVar.f4091f - jVar.f4087b;
        }
        int i19 = i10;
        O2(jVar.f4090e, i19);
        if (this.A) {
            i11 = this.f3876u.i();
        } else {
            i11 = this.f3876u.m();
        }
        int i20 = i11;
        Object[] objArr = null;
        while (jVar.a(yVar) && (this.f3880y.f4094i || !this.B.isEmpty())) {
            View b10 = jVar.b(uVar);
            c cVar = (c) b10.getLayoutParams();
            int a10 = cVar.a();
            int g10 = this.E.g(a10);
            boolean z13 = g10 == -1 ? true : z12;
            if (z13) {
                if (cVar.f3907f) {
                    d[] dVarArr = this.f3875t;
                    char c10 = z12 ? 1 : 0;
                    char c11 = z12 ? 1 : 0;
                    dVar = dVarArr[c10];
                } else {
                    dVar = r2(jVar);
                }
                this.E.n(a10, dVar);
            } else {
                dVar = this.f3875t[g10];
            }
            d dVar2 = dVar;
            cVar.f3906e = dVar2;
            if (jVar.f4090e == 1) {
                e(b10);
            } else {
                int i21 = z12 ? 1 : 0;
                int i22 = z12 ? 1 : 0;
                f(b10, i21);
            }
            z2(b10, cVar, z12);
            if (jVar.f4090e == 1) {
                if (cVar.f3907f) {
                    i18 = n2(i20);
                } else {
                    i18 = dVar2.n(i20);
                }
                i13 = this.f3876u.e(b10) + i18;
                if (z13 && cVar.f3907f) {
                    LazySpanLookup.FullSpanItem Z1 = Z1(i18);
                    Z1.f3885b = -1;
                    Z1.f3884a = a10;
                    this.E.a(Z1);
                }
                i14 = i18;
            } else {
                if (cVar.f3907f) {
                    i17 = q2(i20);
                } else {
                    i17 = dVar2.r(i20);
                }
                i14 = i17 - this.f3876u.e(b10);
                if (z13 && cVar.f3907f) {
                    LazySpanLookup.FullSpanItem a22 = a2(i17);
                    a22.f3885b = 1;
                    a22.f3884a = a10;
                    this.E.a(a22);
                }
                i13 = i17;
            }
            if (cVar.f3907f && jVar.f4089d == -1) {
                if (z13) {
                    this.M = true;
                } else {
                    if (jVar.f4090e == 1) {
                        z11 = P1();
                    } else {
                        z11 = Q1();
                    }
                    if (!z11) {
                        LazySpanLookup.FullSpanItem f10 = this.E.f(a10);
                        if (f10 != null) {
                            f10.f3887d = true;
                        }
                        this.M = true;
                    }
                }
            }
            R1(b10, cVar, jVar);
            if (!x2() || this.f3878w != 1) {
                int m10 = cVar.f3907f ? this.f3877v.m() : (dVar2.f3912e * this.f3879x) + this.f3877v.m();
                i15 = this.f3877v.e(b10) + m10;
                i16 = m10;
            } else {
                int i23 = cVar.f3907f ? this.f3877v.i() : this.f3877v.i() - (((this.f3874s - 1) - dVar2.f3912e) * this.f3879x);
                i16 = i23 - this.f3877v.e(b10);
                i15 = i23;
            }
            if (this.f3878w == 1) {
                A0(b10, i16, i14, i15, i13);
            } else {
                A0(b10, i14, i16, i13, i15);
            }
            if (cVar.f3907f) {
                O2(this.f3880y.f4090e, i19);
            } else {
                U2(dVar2, this.f3880y.f4090e, i19);
            }
            E2(uVar, this.f3880y);
            if (this.f3880y.f4093h && b10.hasFocusable()) {
                if (cVar.f3907f) {
                    this.B.clear();
                } else {
                    z10 = false;
                    this.B.set(dVar2.f3912e, false);
                    z12 = z10;
                    objArr = 1;
                }
            }
            z10 = false;
            z12 = z10;
            objArr = 1;
        }
        int i24 = z12 ? 1 : 0;
        Object[] objArr2 = z12 ? 1 : 0;
        int i25 = i24;
        if (objArr == null) {
            E2(uVar, this.f3880y);
        }
        if (this.f3880y.f4090e == -1) {
            i12 = this.f3876u.m() - q2(this.f3876u.m());
        } else {
            i12 = n2(this.f3876u.i()) - this.f3876u.i();
        }
        return i12 > 0 ? Math.min(jVar.f4087b, i12) : i25;
    }

    private int d2(int i10) {
        int K = K();
        for (int i11 = 0; i11 < K; i11++) {
            int i02 = i0(J(i11));
            if (i02 >= 0 && i02 < i10) {
                return i02;
            }
        }
        return 0;
    }

    private int i2(int i10) {
        for (int K = K() - 1; K >= 0; K--) {
            int i02 = i0(J(K));
            if (i02 >= 0 && i02 < i10) {
                return i02;
            }
        }
        return 0;
    }

    private void j2(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int i10;
        int n22 = n2(Integer.MIN_VALUE);
        if (n22 != Integer.MIN_VALUE && (i10 = this.f3876u.i() - n22) > 0) {
            int i11 = i10 - (-J2(-i10, uVar, yVar));
            if (z10 && i11 > 0) {
                this.f3876u.r(i11);
            }
        }
    }

    private void k2(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int m10;
        int q22 = q2(Integer.MAX_VALUE);
        if (q22 != Integer.MAX_VALUE && (m10 = q22 - this.f3876u.m()) > 0) {
            int J2 = m10 - J2(m10, uVar, yVar);
            if (z10 && J2 > 0) {
                this.f3876u.r(-J2);
            }
        }
    }

    private int n2(int i10) {
        int n10 = this.f3875t[0].n(i10);
        for (int i11 = 1; i11 < this.f3874s; i11++) {
            int n11 = this.f3875t[i11].n(i10);
            if (n11 > n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    private int o2(int i10) {
        int r10 = this.f3875t[0].r(i10);
        for (int i11 = 1; i11 < this.f3874s; i11++) {
            int r11 = this.f3875t[i11].r(i10);
            if (r11 > r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    private int p2(int i10) {
        int n10 = this.f3875t[0].n(i10);
        for (int i11 = 1; i11 < this.f3874s; i11++) {
            int n11 = this.f3875t[i11].n(i10);
            if (n11 < n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    private int q2(int i10) {
        int r10 = this.f3875t[0].r(i10);
        for (int i11 = 1; i11 < this.f3874s; i11++) {
            int r11 = this.f3875t[i11].r(i10);
            if (r11 < r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    private d r2(j jVar) {
        int i10;
        int i11;
        int i12 = -1;
        if (B2(jVar.f4090e)) {
            i11 = this.f3874s - 1;
            i10 = -1;
        } else {
            i11 = 0;
            i12 = this.f3874s;
            i10 = 1;
        }
        d dVar = null;
        if (jVar.f4090e == 1) {
            int i13 = Integer.MAX_VALUE;
            int m10 = this.f3876u.m();
            while (i11 != i12) {
                d dVar2 = this.f3875t[i11];
                int n10 = dVar2.n(m10);
                if (n10 < i13) {
                    dVar = dVar2;
                    i13 = n10;
                }
                i11 += i10;
            }
            return dVar;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = this.f3876u.i();
        while (i11 != i12) {
            d dVar3 = this.f3875t[i11];
            int r10 = dVar3.r(i15);
            if (r10 > i14) {
                dVar = dVar3;
                i14 = r10;
            }
            i11 += i10;
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u2(int i10, int i11, int i12) {
        int i13;
        int i14;
        int m22 = this.A ? m2() : l2();
        if (i12 != 8) {
            i14 = i10 + i11;
        } else if (i10 < i11) {
            i14 = i11 + 1;
        } else {
            i14 = i10 + 1;
            i13 = i11;
            this.E.h(i13);
            if (i12 != 1) {
                this.E.j(i10, i11);
            } else if (i12 == 2) {
                this.E.k(i10, i11);
            } else if (i12 == 8) {
                this.E.k(i10, 1);
                this.E.j(i11, 1);
            }
            if (i14 <= m22) {
                if (i13 <= (this.A ? l2() : m2())) {
                    u1();
                    return;
                }
                return;
            }
            return;
        }
        i13 = i10;
        this.E.h(i13);
        if (i12 != 1) {
        }
        if (i14 <= m22) {
        }
    }

    private void y2(View view, int i10, int i11, boolean z10) {
        boolean z11;
        k(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int V2 = V2(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int V22 = V2(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10) {
            z11 = I1(view, V2, V22, cVar);
        } else {
            z11 = G1(view, V2, V22, cVar);
        }
        if (z11) {
            view.measure(V2, V22);
        }
    }

    private void z2(View view, c cVar, boolean z10) {
        if (cVar.f3907f) {
            if (this.f3878w == 1) {
                y2(view, this.J, RecyclerView.LayoutManager.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
            } else {
                y2(view, RecyclerView.LayoutManager.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z10);
            }
        } else if (this.f3878w == 1) {
            y2(view, RecyclerView.LayoutManager.L(this.f3879x, q0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.LayoutManager.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
        } else {
            y2(view, RecyclerView.LayoutManager.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.LayoutManager.L(this.f3879x, Y(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z10);
        }
    }

    void C2(int i10, RecyclerView.y yVar) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = m2();
            i11 = 1;
        } else {
            i11 = -1;
            i12 = l2();
        }
        this.f3880y.f4086a = true;
        S2(i12, yVar);
        K2(i11);
        j jVar = this.f3880y;
        jVar.f4088c = i12 + jVar.f4089d;
        jVar.f4087b = Math.abs(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void D0(int i10) {
        super.D0(i10);
        for (int i11 = 0; i11 < this.f3874s; i11++) {
            this.f3875t[i11].t(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void D1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int f02 = f0() + g0();
        int h02 = h0() + e0();
        if (this.f3878w == 1) {
            i13 = RecyclerView.LayoutManager.o(i11, rect.height() + h02, c0());
            i12 = RecyclerView.LayoutManager.o(i10, (this.f3879x * this.f3874s) + f02, d0());
        } else {
            i12 = RecyclerView.LayoutManager.o(i10, rect.width() + f02, d0());
            i13 = RecyclerView.LayoutManager.o(i11, (this.f3879x * this.f3874s) + h02, c0());
        }
        C1(i12, i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o E() {
        if (this.f3878w == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void E0(int i10) {
        super.E0(i10);
        for (int i11 = 0; i11 < this.f3874s; i11++) {
            this.f3875t[i11].t(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o F(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void F0(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.E.b();
        for (int i10 = 0; i10 < this.f3874s; i10++) {
            this.f3875t[i10].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.J0(recyclerView, uVar);
        p1(this.P);
        for (int i10 = 0; i10 < this.f3874s; i10++) {
            this.f3875t[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J1(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        k kVar = new k(recyclerView.getContext());
        kVar.p(i10);
        K1(kVar);
    }

    int J2(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        C2(i10, yVar);
        int c22 = c2(uVar, this.f3880y, yVar);
        if (this.f3880y.f4087b >= c22) {
            i10 = i10 < 0 ? -c22 : c22;
        }
        this.f3876u.r(-i10);
        this.G = this.A;
        j jVar = this.f3880y;
        jVar.f4087b = 0;
        E2(uVar, jVar);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View K0(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        View C;
        int i11;
        int i12;
        int i13;
        int i14;
        View o10;
        if (K() == 0 || (C = C(view)) == null) {
            return null;
        }
        I2();
        int Y1 = Y1(i10);
        if (Y1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) C.getLayoutParams();
        boolean z10 = cVar.f3907f;
        d dVar = cVar.f3906e;
        if (Y1 == 1) {
            i11 = m2();
        } else {
            i11 = l2();
        }
        S2(i11, yVar);
        K2(Y1);
        j jVar = this.f3880y;
        jVar.f4088c = jVar.f4089d + i11;
        jVar.f4087b = (int) (this.f3876u.n() * 0.33333334f);
        j jVar2 = this.f3880y;
        jVar2.f4093h = true;
        jVar2.f4086a = false;
        c2(uVar, jVar2, yVar);
        this.G = this.A;
        if (!(z10 || (o10 = dVar.o(i11, Y1)) == null || o10 == C)) {
            return o10;
        }
        if (B2(Y1)) {
            for (int i15 = this.f3874s - 1; i15 >= 0; i15--) {
                View o11 = this.f3875t[i15].o(i11, Y1);
                if (!(o11 == null || o11 == C)) {
                    return o11;
                }
            }
        } else {
            for (int i16 = 0; i16 < this.f3874s; i16++) {
                View o12 = this.f3875t[i16].o(i11, Y1);
                if (!(o12 == null || o12 == C)) {
                    return o12;
                }
            }
        }
        boolean z11 = (this.f3881z ^ true) == (Y1 == -1);
        if (!z10) {
            if (z11) {
                i14 = dVar.f();
            } else {
                i14 = dVar.h();
            }
            View D = D(i14);
            if (!(D == null || D == C)) {
                return D;
            }
        }
        if (B2(Y1)) {
            for (int i17 = this.f3874s - 1; i17 >= 0; i17--) {
                if (i17 != dVar.f3912e) {
                    if (z11) {
                        i13 = this.f3875t[i17].f();
                    } else {
                        i13 = this.f3875t[i17].h();
                    }
                    View D2 = D(i13);
                    if (!(D2 == null || D2 == C)) {
                        return D2;
                    }
                }
            }
        } else {
            for (int i18 = 0; i18 < this.f3874s; i18++) {
                if (z11) {
                    i12 = this.f3875t[i18].f();
                } else {
                    i12 = this.f3875t[i18].h();
                }
                View D3 = D(i12);
                if (!(D3 == null || D3 == C)) {
                    return D3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            View f22 = f2(false);
            View e22 = e2(false);
            if (f22 != null && e22 != null) {
                int i02 = i0(f22);
                int i03 = i0(e22);
                if (i02 < i03) {
                    accessibilityEvent.setFromIndex(i02);
                    accessibilityEvent.setToIndex(i03);
                    return;
                }
                accessibilityEvent.setFromIndex(i03);
                accessibilityEvent.setToIndex(i02);
            }
        }
    }

    public void L2(int i10) {
        if (i10 == 0 || i10 == 1) {
            h(null);
            if (i10 != this.f3878w) {
                this.f3878w = i10;
                m mVar = this.f3876u;
                this.f3876u = this.f3877v;
                this.f3877v = mVar;
                u1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean M1() {
        return this.I == null;
    }

    public void M2(boolean z10) {
        h(null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f3895h == z10)) {
            savedState.f3895h = z10;
        }
        this.f3881z = z10;
        u1();
    }

    public void N2(int i10) {
        h(null);
        if (i10 != this.f3874s) {
            w2();
            this.f3874s = i10;
            this.B = new BitSet(this.f3874s);
            this.f3875t = new d[this.f3874s];
            for (int i11 = 0; i11 < this.f3874s; i11++) {
                this.f3875t[i11] = new d(i11);
            }
            u1();
        }
    }

    boolean P1() {
        int n10 = this.f3875t[0].n(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3874s; i10++) {
            if (this.f3875t[i10].n(Integer.MIN_VALUE) != n10) {
                return false;
            }
        }
        return true;
    }

    boolean Q1() {
        int r10 = this.f3875t[0].r(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3874s; i10++) {
            if (this.f3875t[i10].r(Integer.MIN_VALUE) != r10) {
                return false;
            }
        }
        return true;
    }

    boolean Q2(RecyclerView.y yVar, b bVar) {
        int i10;
        int i11;
        boolean z10 = false;
        if (!yVar.e() && (i10 = this.C) != -1) {
            if (i10 < 0 || i10 >= yVar.b()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f3888a == -1 || savedState.f3890c < 1) {
                    View D = D(this.C);
                    if (D != null) {
                        bVar.f3899a = this.A ? m2() : l2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f3901c) {
                                bVar.f3900b = (this.f3876u.i() - this.D) - this.f3876u.d(D);
                            } else {
                                bVar.f3900b = (this.f3876u.m() + this.D) - this.f3876u.g(D);
                            }
                            return true;
                        } else if (this.f3876u.e(D) > this.f3876u.n()) {
                            if (bVar.f3901c) {
                                i11 = this.f3876u.i();
                            } else {
                                i11 = this.f3876u.m();
                            }
                            bVar.f3900b = i11;
                            return true;
                        } else {
                            int g10 = this.f3876u.g(D) - this.f3876u.m();
                            if (g10 < 0) {
                                bVar.f3900b = -g10;
                                return true;
                            }
                            int i12 = this.f3876u.i() - this.f3876u.d(D);
                            if (i12 < 0) {
                                bVar.f3900b = i12;
                                return true;
                            }
                            bVar.f3900b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i13 = this.C;
                        bVar.f3899a = i13;
                        int i14 = this.D;
                        if (i14 == Integer.MIN_VALUE) {
                            if (S1(i13) == 1) {
                                z10 = true;
                            }
                            bVar.f3901c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i14);
                        }
                        bVar.f3902d = true;
                    }
                } else {
                    bVar.f3900b = Integer.MIN_VALUE;
                    bVar.f3899a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    void R2(RecyclerView.y yVar, b bVar) {
        if (!Q2(yVar, bVar) && !P2(yVar, bVar)) {
            bVar.a();
            bVar.f3899a = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void S0(RecyclerView recyclerView, int i10, int i11) {
        u2(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T0(RecyclerView recyclerView) {
        this.E.b();
        u1();
    }

    boolean T1() {
        int i10;
        int i11;
        if (K() == 0 || this.F == 0 || !s0()) {
            return false;
        }
        if (this.A) {
            i11 = m2();
            i10 = l2();
        } else {
            i11 = l2();
            i10 = m2();
        }
        if (i11 == 0 && v2() != null) {
            this.E.b();
            v1();
            u1();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i12 = this.A ? -1 : 1;
            int i13 = i10 + 1;
            LazySpanLookup.FullSpanItem e10 = this.E.e(i11, i13, i12, true);
            if (e10 == null) {
                this.M = false;
                this.E.d(i13);
                return false;
            }
            LazySpanLookup.FullSpanItem e11 = this.E.e(i11, e10.f3884a, i12 * (-1), true);
            if (e11 == null) {
                this.E.d(e10.f3884a);
            } else {
                this.E.d(e11.f3884a + 1);
            }
            v1();
            u1();
            return true;
        }
    }

    void T2(int i10) {
        this.f3879x = i10 / this.f3874s;
        this.J = View.MeasureSpec.makeMeasureSpec(i10, this.f3877v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        u2(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void V0(RecyclerView recyclerView, int i10, int i11) {
        u2(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        u2(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView.u uVar, RecyclerView.y yVar) {
        A2(uVar, yVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView.y yVar) {
        super.Z0(yVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF a(int i10) {
        int S1 = S1(i10);
        PointF pointF = new PointF();
        if (S1 == 0) {
            return null;
        }
        if (this.f3878w == 0) {
            pointF.x = S1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = S1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.I = savedState;
            if (this.C != -1) {
                savedState.a();
                this.I.b();
            }
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable e1() {
        int i10;
        int i11;
        int[] iArr;
        if (this.I != null) {
            return new SavedState(this.I);
        }
        SavedState savedState = new SavedState();
        savedState.f3895h = this.f3881z;
        savedState.f3896i = this.G;
        savedState.f3897j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f3882a) == null) {
            savedState.f3892e = 0;
        } else {
            savedState.f3893f = iArr;
            savedState.f3892e = iArr.length;
            savedState.f3894g = lazySpanLookup.f3883b;
        }
        if (K() > 0) {
            savedState.f3888a = this.G ? m2() : l2();
            savedState.f3889b = g2();
            int i12 = this.f3874s;
            savedState.f3890c = i12;
            savedState.f3891d = new int[i12];
            for (int i13 = 0; i13 < this.f3874s; i13++) {
                if (this.G) {
                    i10 = this.f3875t[i13].n(Integer.MIN_VALUE);
                    if (i10 != Integer.MIN_VALUE) {
                        i11 = this.f3876u.i();
                        i10 -= i11;
                        savedState.f3891d[i13] = i10;
                    } else {
                        savedState.f3891d[i13] = i10;
                    }
                } else {
                    i10 = this.f3875t[i13].r(Integer.MIN_VALUE);
                    if (i10 != Integer.MIN_VALUE) {
                        i11 = this.f3876u.m();
                        i10 -= i11;
                        savedState.f3891d[i13] = i10;
                    } else {
                        savedState.f3891d[i13] = i10;
                    }
                }
            }
        } else {
            savedState.f3888a = -1;
            savedState.f3889b = -1;
            savedState.f3890c = 0;
        }
        return savedState;
    }

    View e2(boolean z10) {
        int m10 = this.f3876u.m();
        int i10 = this.f3876u.i();
        View view = null;
        for (int K = K() - 1; K >= 0; K--) {
            View J = J(K);
            int g10 = this.f3876u.g(J);
            int d10 = this.f3876u.d(J);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return J;
                }
                if (view == null) {
                    view = J;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void f1(int i10) {
        if (i10 == 0) {
            T1();
        }
    }

    View f2(boolean z10) {
        int m10 = this.f3876u.m();
        int i10 = this.f3876u.i();
        int K = K();
        View view = null;
        for (int i11 = 0; i11 < K; i11++) {
            View J = J(i11);
            int g10 = this.f3876u.g(J);
            if (this.f3876u.d(J) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return J;
                }
                if (view == null) {
                    view = J;
                }
            }
        }
        return view;
    }

    int g2() {
        View e22 = this.A ? e2(true) : f2(true);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h(String str) {
        if (this.I == null) {
            super.h(str);
        }
    }

    public int[] h2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3874s];
        } else if (iArr.length < this.f3874s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3874s + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f3874s; i10++) {
            iArr[i10] = this.f3875t[i10].g();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean l() {
        return this.f3878w == 0;
    }

    int l2() {
        if (K() == 0) {
            return 0;
        }
        return i0(J(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean m() {
        return this.f3878w == 1;
    }

    int m2() {
        int K = K();
        if (K == 0) {
            return 0;
        }
        return i0(J(K - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean n(RecyclerView.o oVar) {
        return oVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void p(int i10, int i11, RecyclerView.y yVar, RecyclerView.LayoutManager.c cVar) {
        int i12;
        int i13;
        if (this.f3878w != 0) {
            i10 = i11;
        }
        if (!(K() == 0 || i10 == 0)) {
            C2(i10, yVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.f3874s) {
                this.O = new int[this.f3874s];
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f3874s; i15++) {
                j jVar = this.f3880y;
                if (jVar.f4089d == -1) {
                    i13 = jVar.f4091f;
                    i12 = this.f3875t[i15].r(i13);
                } else {
                    i13 = this.f3875t[i15].n(jVar.f4092g);
                    i12 = this.f3880y.f4092g;
                }
                int i16 = i13 - i12;
                if (i16 >= 0) {
                    this.O[i14] = i16;
                    i14++;
                }
            }
            Arrays.sort(this.O, 0, i14);
            for (int i17 = 0; i17 < i14 && this.f3880y.a(yVar); i17++) {
                cVar.a(this.f3880y.f4088c, this.O[i17]);
                j jVar2 = this.f3880y;
                jVar2.f4088c += jVar2.f4089d;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int r(RecyclerView.y yVar) {
        return V1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int s(RecyclerView.y yVar) {
        return W1(yVar);
    }

    public int s2() {
        return this.f3878w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int t(RecyclerView.y yVar) {
        return X1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean t0() {
        return this.F != 0;
    }

    public int t2() {
        return this.f3874s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int u(RecyclerView.y yVar) {
        return V1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int v(RecyclerView.y yVar) {
        return W1(yVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
        if (r10 == r11) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        if (r10 == r11) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008a, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View v2() {
        int i10;
        int i11;
        boolean z10;
        int K = K() - 1;
        BitSet bitSet = new BitSet(this.f3874s);
        bitSet.set(0, this.f3874s, true);
        int i12 = -1;
        char c10 = (this.f3878w != 1 || !x2()) ? (char) 65535 : (char) 1;
        if (this.A) {
            i10 = -1;
        } else {
            i10 = K + 1;
            K = 0;
        }
        if (K < i10) {
            i12 = 1;
        }
        while (K != i10) {
            View J = J(K);
            c cVar = (c) J.getLayoutParams();
            if (bitSet.get(cVar.f3906e.f3912e)) {
                if (U1(cVar.f3906e)) {
                    return J;
                }
                bitSet.clear(cVar.f3906e.f3912e);
            }
            if (!cVar.f3907f && (i11 = K + i12) != i10) {
                View J2 = J(i11);
                if (this.A) {
                    int d10 = this.f3876u.d(J);
                    int d11 = this.f3876u.d(J2);
                    if (d10 < d11) {
                        return J;
                    }
                } else {
                    int g10 = this.f3876u.g(J);
                    int g11 = this.f3876u.g(J2);
                    if (g10 > g11) {
                        return J;
                    }
                }
                if (!z10) {
                    continue;
                } else {
                    if ((cVar.f3906e.f3912e - ((c) J2.getLayoutParams()).f3906e.f3912e < 0) != (c10 < 0)) {
                        return J;
                    }
                }
            }
            K += i12;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.y yVar) {
        return X1(yVar);
    }

    public void w2() {
        this.E.b();
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        return J2(i10, uVar, yVar);
    }

    boolean x2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void y1(int i10) {
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.f3888a == i10)) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        return J2(i10, uVar, yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f3882a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f3883b;

        LazySpanLookup() {
        }

        private int i(int i10) {
            if (this.f3883b == null) {
                return -1;
            }
            FullSpanItem f10 = f(i10);
            if (f10 != null) {
                this.f3883b.remove(f10);
            }
            int size = this.f3883b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                } else if (this.f3883b.get(i11).f3884a >= i10) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            this.f3883b.remove(i11);
            return this.f3883b.get(i11).f3884a;
        }

        private void l(int i10, int i11) {
            List<FullSpanItem> list = this.f3883b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3883b.get(size);
                    int i12 = fullSpanItem.f3884a;
                    if (i12 >= i10) {
                        fullSpanItem.f3884a = i12 + i11;
                    }
                }
            }
        }

        private void m(int i10, int i11) {
            List<FullSpanItem> list = this.f3883b;
            if (list != null) {
                int i12 = i10 + i11;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f3883b.get(size);
                    int i13 = fullSpanItem.f3884a;
                    if (i13 >= i10) {
                        if (i13 < i12) {
                            this.f3883b.remove(size);
                        } else {
                            fullSpanItem.f3884a = i13 - i11;
                        }
                    }
                }
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f3883b == null) {
                this.f3883b = new ArrayList();
            }
            int size = this.f3883b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f3883b.get(i10);
                if (fullSpanItem2.f3884a == fullSpanItem.f3884a) {
                    this.f3883b.remove(i10);
                }
                if (fullSpanItem2.f3884a >= fullSpanItem.f3884a) {
                    this.f3883b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f3883b.add(fullSpanItem);
        }

        void b() {
            int[] iArr = this.f3882a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3883b = null;
        }

        void c(int i10) {
            int[] iArr = this.f3882a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f3882a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f3882a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3882a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i10) {
            List<FullSpanItem> list = this.f3883b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f3883b.get(size).f3884a >= i10) {
                        this.f3883b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f3883b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f3883b.get(i13);
                int i14 = fullSpanItem.f3884a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f3885b == i12 || (z10 && fullSpanItem.f3887d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List<FullSpanItem> list = this.f3883b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3883b.get(size);
                if (fullSpanItem.f3884a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int g(int i10) {
            int[] iArr = this.f3882a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        int h(int i10) {
            int[] iArr = this.f3882a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f3882a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f3882a.length;
            }
            int min = Math.min(i11 + 1, this.f3882a.length);
            Arrays.fill(this.f3882a, i10, min, -1);
            return min;
        }

        void j(int i10, int i11) {
            int[] iArr = this.f3882a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f3882a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f3882a, i10, i12, -1);
                l(i10, i11);
            }
        }

        void k(int i10, int i11) {
            int[] iArr = this.f3882a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f3882a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f3882a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        void n(int i10, d dVar) {
            c(i10);
            this.f3882a[i10] = dVar.f3912e;
        }

        int o(int i10) {
            int length = this.f3882a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            int f3884a;

            /* renamed from: b  reason: collision with root package name */
            int f3885b;

            /* renamed from: c  reason: collision with root package name */
            int[] f3886c;

            /* renamed from: d  reason: collision with root package name */
            boolean f3887d;

            /* loaded from: classes.dex */
            class a implements Parcelable.Creator<FullSpanItem> {
                a() {
                }

                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f3884a = parcel.readInt();
                this.f3885b = parcel.readInt();
                this.f3887d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3886c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i10) {
                int[] iArr = this.f3886c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3884a + ", mGapDir=" + this.f3885b + ", mHasUnwantedGapAfter=" + this.f3887d + ", mGapPerSpan=" + Arrays.toString(this.f3886c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f3884a);
                parcel.writeInt(this.f3885b);
                parcel.writeInt(this.f3887d ? 1 : 0);
                int[] iArr = this.f3886c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f3886c);
            }

            FullSpanItem() {
            }
        }
    }
}
