package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements g.j, RecyclerView.x.b {
    int A;
    int B;
    private boolean C;
    SavedState D;
    final a E;
    private final b F;
    private int G;
    private int[] H;

    /* renamed from: s  reason: collision with root package name */
    int f3705s;

    /* renamed from: t  reason: collision with root package name */
    private c f3706t;

    /* renamed from: u  reason: collision with root package name */
    m f3707u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3708v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3709w;

    /* renamed from: x  reason: collision with root package name */
    boolean f3710x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f3711y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3712z;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3713a;

        /* renamed from: b  reason: collision with root package name */
        int f3714b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3715c;

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

        boolean a() {
            return this.f3713a >= 0;
        }

        void b() {
            this.f3713a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3713a);
            parcel.writeInt(this.f3714b);
            parcel.writeInt(this.f3715c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f3713a = parcel.readInt();
            this.f3714b = parcel.readInt();
            this.f3715c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f3713a = savedState.f3713a;
            this.f3714b = savedState.f3714b;
            this.f3715c = savedState.f3715c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        m f3716a;

        /* renamed from: b  reason: collision with root package name */
        int f3717b;

        /* renamed from: c  reason: collision with root package name */
        int f3718c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3719d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3720e;

        a() {
            e();
        }

        void a() {
            int i10;
            if (this.f3719d) {
                i10 = this.f3716a.i();
            } else {
                i10 = this.f3716a.m();
            }
            this.f3718c = i10;
        }

        public void b(View view, int i10) {
            if (this.f3719d) {
                this.f3718c = this.f3716a.d(view) + this.f3716a.o();
            } else {
                this.f3718c = this.f3716a.g(view);
            }
            this.f3717b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f3716a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f3717b = i10;
            if (this.f3719d) {
                int i11 = (this.f3716a.i() - o10) - this.f3716a.d(view);
                this.f3718c = this.f3716a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f3718c - this.f3716a.e(view);
                    int m10 = this.f3716a.m();
                    int min = e10 - (m10 + Math.min(this.f3716a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f3718c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f3716a.g(view);
            int m11 = g10 - this.f3716a.m();
            this.f3718c = g10;
            if (m11 > 0) {
                int i12 = (this.f3716a.i() - Math.min(0, (this.f3716a.i() - o10) - this.f3716a.d(view))) - (g10 + this.f3716a.e(view));
                if (i12 < 0) {
                    this.f3718c -= Math.min(m11, -i12);
                }
            }
        }

        boolean d(View view, RecyclerView.y yVar) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return !oVar.c() && oVar.a() >= 0 && oVar.a() < yVar.b();
        }

        void e() {
            this.f3717b = -1;
            this.f3718c = Integer.MIN_VALUE;
            this.f3719d = false;
            this.f3720e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3717b + ", mCoordinate=" + this.f3718c + ", mLayoutFromEnd=" + this.f3719d + ", mValid=" + this.f3720e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3721a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3722b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3723c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3724d;

        protected b() {
        }

        void a() {
            this.f3721a = 0;
            this.f3722b = false;
            this.f3723c = false;
            this.f3724d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        int f3726b;

        /* renamed from: c  reason: collision with root package name */
        int f3727c;

        /* renamed from: d  reason: collision with root package name */
        int f3728d;

        /* renamed from: e  reason: collision with root package name */
        int f3729e;

        /* renamed from: f  reason: collision with root package name */
        int f3730f;

        /* renamed from: g  reason: collision with root package name */
        int f3731g;

        /* renamed from: j  reason: collision with root package name */
        boolean f3734j;

        /* renamed from: k  reason: collision with root package name */
        int f3735k;

        /* renamed from: m  reason: collision with root package name */
        boolean f3737m;

        /* renamed from: a  reason: collision with root package name */
        boolean f3725a = true;

        /* renamed from: h  reason: collision with root package name */
        int f3732h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f3733i = 0;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.b0> f3736l = null;

        c() {
        }

        private View e() {
            int size = this.f3736l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f3736l.get(i10).itemView;
                RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
                if (!oVar.c() && this.f3728d == oVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f3728d = -1;
            } else {
                this.f3728d = ((RecyclerView.o) f10.getLayoutParams()).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.y yVar) {
            int i10 = this.f3728d;
            return i10 >= 0 && i10 < yVar.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.u uVar) {
            if (this.f3736l != null) {
                return e();
            }
            View o10 = uVar.o(this.f3728d);
            this.f3728d += this.f3729e;
            return o10;
        }

        public View f(View view) {
            int a10;
            int size = this.f3736l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f3736l.get(i11).itemView;
                RecyclerView.o oVar = (RecyclerView.o) view3.getLayoutParams();
                if (view3 != view && !oVar.c() && (a10 = (oVar.a() - this.f3728d) * this.f3729e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private boolean E2(RecyclerView.u uVar, RecyclerView.y yVar, a aVar) {
        View h22;
        boolean z10 = false;
        if (K() == 0) {
            return false;
        }
        View W = W();
        if (W == null || !aVar.d(W, yVar)) {
            boolean z11 = this.f3708v;
            boolean z12 = this.f3711y;
            if (z11 != z12 || (h22 = h2(uVar, yVar, aVar.f3719d, z12)) == null) {
                return false;
            }
            aVar.b(h22, i0(h22));
            if (!yVar.e() && M1()) {
                int g10 = this.f3707u.g(h22);
                int d10 = this.f3707u.d(h22);
                int m10 = this.f3707u.m();
                int i10 = this.f3707u.i();
                boolean z13 = d10 <= m10 && g10 < m10;
                if (g10 >= i10 && d10 > i10) {
                    z10 = true;
                }
                if (z13 || z10) {
                    if (aVar.f3719d) {
                        m10 = i10;
                    }
                    aVar.f3718c = m10;
                }
            }
            return true;
        }
        aVar.c(W, i0(W));
        return true;
    }

    private boolean F2(RecyclerView.y yVar, a aVar) {
        int i10;
        int i11;
        boolean z10 = false;
        if (!yVar.e() && (i10 = this.A) != -1) {
            if (i10 < 0 || i10 >= yVar.b()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f3717b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z11 = this.D.f3715c;
                    aVar.f3719d = z11;
                    if (z11) {
                        aVar.f3718c = this.f3707u.i() - this.D.f3714b;
                    } else {
                        aVar.f3718c = this.f3707u.m() + this.D.f3714b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View D = D(this.A);
                    if (D == null) {
                        if (K() > 0) {
                            if ((this.A < i0(J(0))) == this.f3710x) {
                                z10 = true;
                            }
                            aVar.f3719d = z10;
                        }
                        aVar.a();
                    } else if (this.f3707u.e(D) > this.f3707u.n()) {
                        aVar.a();
                        return true;
                    } else if (this.f3707u.g(D) - this.f3707u.m() < 0) {
                        aVar.f3718c = this.f3707u.m();
                        aVar.f3719d = false;
                        return true;
                    } else if (this.f3707u.i() - this.f3707u.d(D) < 0) {
                        aVar.f3718c = this.f3707u.i();
                        aVar.f3719d = true;
                        return true;
                    } else {
                        if (aVar.f3719d) {
                            i11 = this.f3707u.d(D) + this.f3707u.o();
                        } else {
                            i11 = this.f3707u.g(D);
                        }
                        aVar.f3718c = i11;
                    }
                    return true;
                } else {
                    boolean z12 = this.f3710x;
                    aVar.f3719d = z12;
                    if (z12) {
                        aVar.f3718c = this.f3707u.i() - this.B;
                    } else {
                        aVar.f3718c = this.f3707u.m() + this.B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void G2(RecyclerView.u uVar, RecyclerView.y yVar, a aVar) {
        if (!F2(yVar, aVar) && !E2(uVar, yVar, aVar)) {
            aVar.a();
            aVar.f3717b = this.f3711y ? yVar.b() - 1 : 0;
        }
    }

    private void H2(int i10, int i11, boolean z10, RecyclerView.y yVar) {
        int i12;
        this.f3706t.f3737m = x2();
        this.f3706t.f3730f = i10;
        int[] iArr = this.H;
        boolean z11 = false;
        iArr[0] = 0;
        int i13 = 1;
        iArr[1] = 0;
        N1(yVar, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        if (i10 == 1) {
            z11 = true;
        }
        c cVar = this.f3706t;
        int i14 = z11 ? max2 : max;
        cVar.f3732h = i14;
        if (!z11) {
            max = max2;
        }
        cVar.f3733i = max;
        if (z11) {
            cVar.f3732h = i14 + this.f3707u.j();
            View k22 = k2();
            c cVar2 = this.f3706t;
            if (this.f3710x) {
                i13 = -1;
            }
            cVar2.f3729e = i13;
            int i02 = i0(k22);
            c cVar3 = this.f3706t;
            cVar2.f3728d = i02 + cVar3.f3729e;
            cVar3.f3726b = this.f3707u.d(k22);
            i12 = this.f3707u.d(k22) - this.f3707u.i();
        } else {
            View l22 = l2();
            this.f3706t.f3732h += this.f3707u.m();
            c cVar4 = this.f3706t;
            if (!this.f3710x) {
                i13 = -1;
            }
            cVar4.f3729e = i13;
            int i03 = i0(l22);
            c cVar5 = this.f3706t;
            cVar4.f3728d = i03 + cVar5.f3729e;
            cVar5.f3726b = this.f3707u.g(l22);
            i12 = (-this.f3707u.g(l22)) + this.f3707u.m();
        }
        c cVar6 = this.f3706t;
        cVar6.f3727c = i11;
        if (z10) {
            cVar6.f3727c = i11 - i12;
        }
        cVar6.f3731g = i12;
    }

    private void I2(int i10, int i11) {
        this.f3706t.f3727c = this.f3707u.i() - i11;
        c cVar = this.f3706t;
        cVar.f3729e = this.f3710x ? -1 : 1;
        cVar.f3728d = i10;
        cVar.f3730f = 1;
        cVar.f3726b = i11;
        cVar.f3731g = Integer.MIN_VALUE;
    }

    private void J2(a aVar) {
        I2(aVar.f3717b, aVar.f3718c);
    }

    private void K2(int i10, int i11) {
        this.f3706t.f3727c = i11 - this.f3707u.m();
        c cVar = this.f3706t;
        cVar.f3728d = i10;
        cVar.f3729e = this.f3710x ? 1 : -1;
        cVar.f3730f = -1;
        cVar.f3726b = i11;
        cVar.f3731g = Integer.MIN_VALUE;
    }

    private void L2(a aVar) {
        K2(aVar.f3717b, aVar.f3718c);
    }

    private int P1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return p.a(yVar, this.f3707u, Y1(!this.f3712z, true), X1(!this.f3712z, true), this, this.f3712z);
    }

    private int Q1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return p.b(yVar, this.f3707u, Y1(!this.f3712z, true), X1(!this.f3712z, true), this, this.f3712z, this.f3710x);
    }

    private int R1(RecyclerView.y yVar) {
        if (K() == 0) {
            return 0;
        }
        U1();
        return p.c(yVar, this.f3707u, Y1(!this.f3712z, true), X1(!this.f3712z, true), this, this.f3712z);
    }

    private View W1() {
        return d2(0, K());
    }

    private View b2() {
        return d2(K() - 1, -1);
    }

    private View f2() {
        return this.f3710x ? W1() : b2();
    }

    private View g2() {
        return this.f3710x ? b2() : W1();
    }

    private int i2(int i10, RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int i11;
        int i12 = this.f3707u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -z2(-i12, uVar, yVar);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f3707u.i() - i14) <= 0) {
            return i13;
        }
        this.f3707u.r(i11);
        return i11 + i13;
    }

    private int j2(int i10, RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int m10;
        int m11 = i10 - this.f3707u.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -z2(m11, uVar, yVar);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.f3707u.m()) <= 0) {
            return i11;
        }
        this.f3707u.r(-m10);
        return i11 - m10;
    }

    private View k2() {
        return J(this.f3710x ? 0 : K() - 1);
    }

    private View l2() {
        return J(this.f3710x ? K() - 1 : 0);
    }

    private void r2(RecyclerView.u uVar, RecyclerView.y yVar, int i10, int i11) {
        if (yVar.g() && K() != 0 && !yVar.e() && M1()) {
            List<RecyclerView.b0> k10 = uVar.k();
            int size = k10.size();
            int i02 = i0(J(0));
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.b0 b0Var = k10.get(i14);
                if (!b0Var.isRemoved()) {
                    boolean z10 = true;
                    if ((b0Var.getLayoutPosition() < i02) != this.f3710x) {
                        z10 = true;
                    }
                    if (z10) {
                        i12 += this.f3707u.e(b0Var.itemView);
                    } else {
                        i13 += this.f3707u.e(b0Var.itemView);
                    }
                }
            }
            this.f3706t.f3736l = k10;
            if (i12 > 0) {
                K2(i0(l2()), i10);
                c cVar = this.f3706t;
                cVar.f3732h = i12;
                cVar.f3727c = 0;
                cVar.a();
                V1(uVar, this.f3706t, yVar, false);
            }
            if (i13 > 0) {
                I2(i0(k2()), i11);
                c cVar2 = this.f3706t;
                cVar2.f3732h = i13;
                cVar2.f3727c = 0;
                cVar2.a();
                V1(uVar, this.f3706t, yVar, false);
            }
            this.f3706t.f3736l = null;
        }
    }

    private void t2(RecyclerView.u uVar, c cVar) {
        if (cVar.f3725a && !cVar.f3737m) {
            int i10 = cVar.f3731g;
            int i11 = cVar.f3733i;
            if (cVar.f3730f == -1) {
                v2(uVar, i10, i11);
            } else {
                w2(uVar, i10, i11);
            }
        }
    }

    private void u2(RecyclerView.u uVar, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                for (int i12 = i11 - 1; i12 >= i10; i12--) {
                    o1(i12, uVar);
                }
                return;
            }
            while (i10 > i11) {
                o1(i10, uVar);
                i10--;
            }
        }
    }

    private void v2(RecyclerView.u uVar, int i10, int i11) {
        int K = K();
        if (i10 >= 0) {
            int h10 = (this.f3707u.h() - i10) + i11;
            if (this.f3710x) {
                for (int i12 = 0; i12 < K; i12++) {
                    View J = J(i12);
                    if (this.f3707u.g(J) < h10 || this.f3707u.q(J) < h10) {
                        u2(uVar, 0, i12);
                        return;
                    }
                }
                return;
            }
            int i13 = K - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                View J2 = J(i14);
                if (this.f3707u.g(J2) < h10 || this.f3707u.q(J2) < h10) {
                    u2(uVar, i13, i14);
                    return;
                }
            }
        }
    }

    private void w2(RecyclerView.u uVar, int i10, int i11) {
        if (i10 >= 0) {
            int i12 = i10 - i11;
            int K = K();
            if (this.f3710x) {
                int i13 = K - 1;
                for (int i14 = i13; i14 >= 0; i14--) {
                    View J = J(i14);
                    if (this.f3707u.d(J) > i12 || this.f3707u.p(J) > i12) {
                        u2(uVar, i13, i14);
                        return;
                    }
                }
                return;
            }
            for (int i15 = 0; i15 < K; i15++) {
                View J2 = J(i15);
                if (this.f3707u.d(J2) > i12 || this.f3707u.p(J2) > i12) {
                    u2(uVar, 0, i15);
                    return;
                }
            }
        }
    }

    private void y2() {
        if (this.f3705s == 1 || !o2()) {
            this.f3710x = this.f3709w;
        } else {
            this.f3710x = !this.f3709w;
        }
    }

    public void A2(int i10, int i11) {
        this.A = i10;
        this.B = i11;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        u1();
    }

    public void B2(int i10) {
        if (i10 == 0 || i10 == 1) {
            h(null);
            if (i10 != this.f3705s || this.f3707u == null) {
                m b10 = m.b(this, i10);
                this.f3707u = b10;
                this.E.f3716a = b10;
                this.f3705s = i10;
                u1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i10);
    }

    public void C2(boolean z10) {
        h(null);
        if (z10 != this.f3709w) {
            this.f3709w = z10;
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View D(int i10) {
        int K = K();
        if (K == 0) {
            return null;
        }
        int i02 = i10 - i0(J(0));
        if (i02 >= 0 && i02 < K) {
            View J = J(i02);
            if (i0(J) == i10) {
                return J;
            }
        }
        return super.D(i10);
    }

    public void D2(boolean z10) {
        h(null);
        if (this.f3711y != z10) {
            this.f3711y = z10;
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o E() {
        return new RecyclerView.o(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean H1() {
        return (Y() == 1073741824 || q0() == 1073741824 || !r0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J0(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.J0(recyclerView, uVar);
        if (this.C) {
            l1(uVar);
            uVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J1(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        k kVar = new k(recyclerView.getContext());
        kVar.p(i10);
        K1(kVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View K0(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        int S1;
        View view2;
        View view3;
        y2();
        if (K() == 0 || (S1 = S1(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        U1();
        H2(S1, (int) (this.f3707u.n() * 0.33333334f), false, yVar);
        c cVar = this.f3706t;
        cVar.f3731g = Integer.MIN_VALUE;
        cVar.f3725a = false;
        V1(uVar, cVar, yVar, true);
        if (S1 == -1) {
            view2 = g2();
        } else {
            view2 = f2();
        }
        if (S1 == -1) {
            view3 = l2();
        } else {
            view3 = k2();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            accessibilityEvent.setFromIndex(Z1());
            accessibilityEvent.setToIndex(c2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean M1() {
        return this.D == null && this.f3708v == this.f3711y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N1(RecyclerView.y yVar, int[] iArr) {
        int i10;
        int m22 = m2(yVar);
        if (this.f3706t.f3730f == -1) {
            i10 = 0;
        } else {
            i10 = m22;
            m22 = 0;
        }
        iArr[0] = m22;
        iArr[1] = i10;
    }

    void O1(RecyclerView.y yVar, c cVar, RecyclerView.LayoutManager.c cVar2) {
        int i10 = cVar.f3728d;
        if (i10 >= 0 && i10 < yVar.b()) {
            cVar2.a(i10, Math.max(0, cVar.f3731g));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int S1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3705s == 1) ? 1 : Integer.MIN_VALUE : this.f3705s == 0 ? 1 : Integer.MIN_VALUE : this.f3705s == 1 ? -1 : Integer.MIN_VALUE : this.f3705s == 0 ? -1 : Integer.MIN_VALUE : (this.f3705s != 1 && o2()) ? -1 : 1 : (this.f3705s != 1 && o2()) ? 1 : -1;
    }

    c T1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U1() {
        if (this.f3706t == null) {
            this.f3706t = T1();
        }
    }

    int V1(RecyclerView.u uVar, c cVar, RecyclerView.y yVar, boolean z10) {
        int i10 = cVar.f3727c;
        int i11 = cVar.f3731g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f3731g = i11 + i10;
            }
            t2(uVar, cVar);
        }
        int i12 = cVar.f3727c + cVar.f3732h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f3737m && i12 <= 0) || !cVar.c(yVar)) {
                break;
            }
            bVar.a();
            q2(uVar, yVar, cVar, bVar);
            if (!bVar.f3722b) {
                cVar.f3726b += bVar.f3721a * cVar.f3730f;
                if (!bVar.f3723c || cVar.f3736l != null || !yVar.e()) {
                    int i13 = cVar.f3727c;
                    int i14 = bVar.f3721a;
                    cVar.f3727c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f3731g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f3721a;
                    cVar.f3731g = i16;
                    int i17 = cVar.f3727c;
                    if (i17 < 0) {
                        cVar.f3731g = i16 + i17;
                    }
                    t2(uVar, cVar);
                }
                if (z10 && bVar.f3724d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f3727c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View X1(boolean z10, boolean z11) {
        if (this.f3710x) {
            return e2(0, K(), z10, z11);
        }
        return e2(K() - 1, -1, z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView.u uVar, RecyclerView.y yVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View D;
        int i16;
        int i17;
        int i18 = -1;
        if (!(this.D == null && this.A == -1) && yVar.b() == 0) {
            l1(uVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f3713a;
        }
        U1();
        this.f3706t.f3725a = false;
        y2();
        View W = W();
        a aVar = this.E;
        if (!aVar.f3720e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f3719d = this.f3710x ^ this.f3711y;
            G2(uVar, yVar, aVar2);
            this.E.f3720e = true;
        } else if (W != null && (this.f3707u.g(W) >= this.f3707u.i() || this.f3707u.d(W) <= this.f3707u.m())) {
            this.E.c(W, i0(W));
        }
        c cVar = this.f3706t;
        cVar.f3730f = cVar.f3735k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        N1(yVar, iArr);
        int max = Math.max(0, this.H[0]) + this.f3707u.m();
        int max2 = Math.max(0, this.H[1]) + this.f3707u.j();
        if (!(!yVar.e() || (i15 = this.A) == -1 || this.B == Integer.MIN_VALUE || (D = D(i15)) == null)) {
            if (this.f3710x) {
                i16 = this.f3707u.i() - this.f3707u.d(D);
                i17 = this.B;
            } else {
                i17 = this.f3707u.g(D) - this.f3707u.m();
                i16 = this.B;
            }
            int i19 = i16 - i17;
            if (i19 > 0) {
                max += i19;
            } else {
                max2 -= i19;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f3719d ? !this.f3710x : this.f3710x) {
            i18 = 1;
        }
        s2(uVar, yVar, aVar3, i18);
        x(uVar);
        this.f3706t.f3737m = x2();
        this.f3706t.f3734j = yVar.e();
        this.f3706t.f3733i = 0;
        a aVar4 = this.E;
        if (aVar4.f3719d) {
            L2(aVar4);
            c cVar2 = this.f3706t;
            cVar2.f3732h = max;
            V1(uVar, cVar2, yVar, false);
            c cVar3 = this.f3706t;
            i11 = cVar3.f3726b;
            int i20 = cVar3.f3728d;
            int i21 = cVar3.f3727c;
            if (i21 > 0) {
                max2 += i21;
            }
            J2(this.E);
            c cVar4 = this.f3706t;
            cVar4.f3732h = max2;
            cVar4.f3728d += cVar4.f3729e;
            V1(uVar, cVar4, yVar, false);
            c cVar5 = this.f3706t;
            i10 = cVar5.f3726b;
            int i22 = cVar5.f3727c;
            if (i22 > 0) {
                K2(i20, i11);
                c cVar6 = this.f3706t;
                cVar6.f3732h = i22;
                V1(uVar, cVar6, yVar, false);
                i11 = this.f3706t.f3726b;
            }
        } else {
            J2(aVar4);
            c cVar7 = this.f3706t;
            cVar7.f3732h = max2;
            V1(uVar, cVar7, yVar, false);
            c cVar8 = this.f3706t;
            i10 = cVar8.f3726b;
            int i23 = cVar8.f3728d;
            int i24 = cVar8.f3727c;
            if (i24 > 0) {
                max += i24;
            }
            L2(this.E);
            c cVar9 = this.f3706t;
            cVar9.f3732h = max;
            cVar9.f3728d += cVar9.f3729e;
            V1(uVar, cVar9, yVar, false);
            c cVar10 = this.f3706t;
            i11 = cVar10.f3726b;
            int i25 = cVar10.f3727c;
            if (i25 > 0) {
                I2(i23, i10);
                c cVar11 = this.f3706t;
                cVar11.f3732h = i25;
                V1(uVar, cVar11, yVar, false);
                i10 = this.f3706t.f3726b;
            }
        }
        if (K() > 0) {
            if (this.f3710x ^ this.f3711y) {
                int i26 = i2(i10, uVar, yVar, true);
                i13 = i11 + i26;
                i12 = i10 + i26;
                i14 = j2(i13, uVar, yVar, false);
            } else {
                int j22 = j2(i11, uVar, yVar, true);
                i13 = i11 + j22;
                i12 = i10 + j22;
                i14 = i2(i12, uVar, yVar, false);
            }
            i11 = i13 + i14;
            i10 = i12 + i14;
        }
        r2(uVar, yVar, i11, i10);
        if (!yVar.e()) {
            this.f3707u.s();
        } else {
            this.E.e();
        }
        this.f3708v = this.f3711y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Y1(boolean z10, boolean z11) {
        if (this.f3710x) {
            return e2(K() - 1, -1, z10, z11);
        }
        return e2(0, K(), z10, z11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView.y yVar) {
        super.Z0(yVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    public int Z1() {
        View e22 = e2(0, K(), false, true);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF a(int i10) {
        if (K() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < i0(J(0))) {
            z10 = true;
        }
        if (z10 != this.f3710x) {
            i11 = -1;
        }
        if (this.f3705s == 0) {
            return new PointF(i11, 0.0f);
        }
        return new PointF(0.0f, i11);
    }

    public int a2() {
        View e22 = e2(K() - 1, -1, true, false);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @Override // androidx.recyclerview.widget.g.j
    public void b(View view, View view2, int i10, int i11) {
        h("Cannot drop a view during a scroll or layout calculation");
        U1();
        y2();
        int i02 = i0(view);
        int i03 = i0(view2);
        boolean z10 = i02 < i03 ? true : true;
        if (this.f3710x) {
            if (z10) {
                A2(i03, this.f3707u.i() - (this.f3707u.g(view2) + this.f3707u.e(view)));
            } else {
                A2(i03, this.f3707u.i() - this.f3707u.d(view2));
            }
        } else if (z10) {
            A2(i03, this.f3707u.g(view2));
        } else {
            A2(i03, this.f3707u.d(view2) - this.f3707u.e(view));
        }
    }

    public int c2() {
        View e22 = e2(K() - 1, -1, false, true);
        if (e22 == null) {
            return -1;
        }
        return i0(e22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.b();
            }
            u1();
        }
    }

    View d2(int i10, int i11) {
        int i12;
        int i13;
        U1();
        if ((i11 > i10 ? (char) 1 : i11 < i10 ? (char) 65535 : (char) 0) == 0) {
            return J(i10);
        }
        if (this.f3707u.g(J(i10)) < this.f3707u.m()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = 4097;
        }
        if (this.f3705s == 0) {
            return this.f3785e.a(i10, i11, i13, i12);
        }
        return this.f3786f.a(i10, i11, i13, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable e1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (K() > 0) {
            U1();
            boolean z10 = this.f3708v ^ this.f3710x;
            savedState.f3715c = z10;
            if (z10) {
                View k22 = k2();
                savedState.f3714b = this.f3707u.i() - this.f3707u.d(k22);
                savedState.f3713a = i0(k22);
            } else {
                View l22 = l2();
                savedState.f3713a = i0(l22);
                savedState.f3714b = this.f3707u.g(l22) - this.f3707u.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    View e2(int i10, int i11, boolean z10, boolean z11) {
        U1();
        int i12 = 320;
        int i13 = z10 ? 24579 : 320;
        if (!z11) {
            i12 = 0;
        }
        if (this.f3705s == 0) {
            return this.f3785e.a(i10, i11, i13, i12);
        }
        return this.f3786f.a(i10, i11, i13, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void h(String str) {
        if (this.D == null) {
            super.h(str);
        }
    }

    View h2(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i10;
        int i11;
        U1();
        int K = K();
        int i12 = -1;
        if (z11) {
            i11 = K() - 1;
            i10 = -1;
        } else {
            i12 = K;
            i11 = 0;
            i10 = 1;
        }
        int b10 = yVar.b();
        int m10 = this.f3707u.m();
        int i13 = this.f3707u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i11 != i12) {
            View J = J(i11);
            int i02 = i0(J);
            int g10 = this.f3707u.g(J);
            int d10 = this.f3707u.d(J);
            if (i02 >= 0 && i02 < b10) {
                if (!((RecyclerView.o) J.getLayoutParams()).c()) {
                    boolean z12 = d10 <= m10 && g10 < m10;
                    boolean z13 = g10 >= i13 && d10 > i13;
                    if (!z12 && !z13) {
                        return J;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = J;
                        }
                        view2 = J;
                    } else {
                        if (!z12) {
                            if (view != null) {
                            }
                            view = J;
                        }
                        view2 = J;
                    }
                } else if (view3 == null) {
                    view3 = J;
                }
            }
            i11 += i10;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean l() {
        return this.f3705s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean m() {
        return this.f3705s == 1;
    }

    @Deprecated
    protected int m2(RecyclerView.y yVar) {
        if (yVar.d()) {
            return this.f3707u.n();
        }
        return 0;
    }

    public int n2() {
        return this.f3705s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void p(int i10, int i11, RecyclerView.y yVar, RecyclerView.LayoutManager.c cVar) {
        if (this.f3705s != 0) {
            i10 = i11;
        }
        if (K() != 0 && i10 != 0) {
            U1();
            H2(i10 > 0 ? 1 : -1, Math.abs(i10), true, yVar);
            O1(yVar, this.f3706t, cVar);
        }
    }

    public boolean p2() {
        return this.f3712z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void q(int i10, RecyclerView.LayoutManager.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.D;
        int i12 = -1;
        if (savedState == null || !savedState.a()) {
            y2();
            z10 = this.f3710x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f3715c;
            i11 = savedState2.f3713a;
        }
        if (!z10) {
            i12 = 1;
        }
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    void q2(RecyclerView.u uVar, RecyclerView.y yVar, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View d10 = cVar.d(uVar);
        if (d10 == null) {
            bVar.f3722b = true;
            return;
        }
        RecyclerView.o oVar = (RecyclerView.o) d10.getLayoutParams();
        if (cVar.f3736l == null) {
            if (this.f3710x == (cVar.f3730f == -1)) {
                e(d10);
            } else {
                f(d10, 0);
            }
        } else {
            if (this.f3710x == (cVar.f3730f == -1)) {
                c(d10);
            } else {
                d(d10, 0);
            }
        }
        B0(d10, 0, 0);
        bVar.f3721a = this.f3707u.e(d10);
        if (this.f3705s == 1) {
            if (o2()) {
                i14 = p0() - g0();
                i13 = i14 - this.f3707u.f(d10);
            } else {
                i13 = f0();
                i14 = this.f3707u.f(d10) + i13;
            }
            if (cVar.f3730f == -1) {
                int i15 = cVar.f3726b;
                i12 = i15 - bVar.f3721a;
                i10 = i15;
                i11 = i14;
            } else {
                int i16 = cVar.f3726b;
                i10 = bVar.f3721a + i16;
                i12 = i16;
                i11 = i14;
            }
        } else {
            int h02 = h0();
            int f10 = this.f3707u.f(d10) + h02;
            if (cVar.f3730f == -1) {
                int i17 = cVar.f3726b;
                i13 = i17 - bVar.f3721a;
                i11 = i17;
                i12 = h02;
                i10 = f10;
            } else {
                int i18 = cVar.f3726b;
                i11 = bVar.f3721a + i18;
                i12 = h02;
                i10 = f10;
                i13 = i18;
            }
        }
        A0(d10, i13, i12, i11, i10);
        if (oVar.c() || oVar.b()) {
            bVar.f3723c = true;
        }
        bVar.f3724d = d10.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int r(RecyclerView.y yVar) {
        return P1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int s(RecyclerView.y yVar) {
        return Q1(yVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s2(RecyclerView.u uVar, RecyclerView.y yVar, a aVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int t(RecyclerView.y yVar) {
        return R1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean t0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int u(RecyclerView.y yVar) {
        return P1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int v(RecyclerView.y yVar) {
        return Q1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.y yVar) {
        return R1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f3705s == 1) {
            return 0;
        }
        return z2(i10, uVar, yVar);
    }

    boolean x2() {
        return this.f3707u.k() == 0 && this.f3707u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void y1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f3705s == 0) {
            return 0;
        }
        return z2(i10, uVar, yVar);
    }

    int z2(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (K() == 0 || i10 == 0) {
            return 0;
        }
        U1();
        this.f3706t.f3725a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int abs = Math.abs(i10);
        H2(i11, abs, true, yVar);
        c cVar = this.f3706t;
        int V1 = cVar.f3731g + V1(uVar, cVar, yVar, false);
        if (V1 < 0) {
            return 0;
        }
        if (abs > V1) {
            i10 = i11 * V1;
        }
        this.f3707u.r(-i10);
        this.f3706t.f3735k = i10;
        return i10;
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f3705s = 1;
        this.f3709w = false;
        this.f3710x = false;
        this.f3711y = false;
        this.f3712z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        B2(i10);
        C2(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3705s = 1;
        this.f3709w = false;
        this.f3710x = false;
        this.f3711y = false;
        this.f3712z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.LayoutManager.Properties j02 = RecyclerView.LayoutManager.j0(context, attributeSet, i10, i11);
        B2(j02.orientation);
        C2(j02.reverseLayout);
        D2(j02.stackFromEnd);
    }
}
