package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f4104a;

    /* renamed from: b  reason: collision with root package name */
    private int f4105b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f4106c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public class a extends m {
        a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f4104a.U(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.f4104a.T(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.f4104a.S(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f4104a.R(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f4104a.p0();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f4104a.p0() - this.f4104a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f4104a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f4104a.q0();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f4104a.Y();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f4104a.f0();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f4104a.p0() - this.f4104a.f0()) - this.f4104a.g0();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f4104a.o0(view, true, this.f4106c);
            return this.f4106c.right;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f4104a.o0(view, true, this.f4106c);
            return this.f4106c.left;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i10) {
            this.f4104a.D0(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public class b extends m {
        b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f4104a.P(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.f4104a.S(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            return this.f4104a.T(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f4104a.V(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f4104a.X();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f4104a.X() - this.f4104a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f4104a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f4104a.Y();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f4104a.q0();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f4104a.h0();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f4104a.X() - this.f4104a.h0()) - this.f4104a.e0();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f4104a.o0(view, true, this.f4106c);
            return this.f4106c.bottom;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f4104a.o0(view, true, this.f4106c);
            return this.f4106c.top;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i10) {
            this.f4104a.E0(i10);
        }
    }

    /* synthetic */ m(RecyclerView.LayoutManager layoutManager, a aVar) {
        this(layoutManager);
    }

    public static m a(RecyclerView.LayoutManager layoutManager) {
        return new a(layoutManager);
    }

    public static m b(RecyclerView.LayoutManager layoutManager, int i10) {
        if (i10 == 0) {
            return a(layoutManager);
        }
        if (i10 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.LayoutManager layoutManager) {
        return new b(layoutManager);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f4105b) {
            return 0;
        }
        return n() - this.f4105b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f4105b = n();
    }

    private m(RecyclerView.LayoutManager layoutManager) {
        this.f4105b = Integer.MIN_VALUE;
        this.f4106c = new Rect();
        this.f4104a = layoutManager;
    }
}
