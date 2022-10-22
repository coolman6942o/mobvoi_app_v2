package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: SimpleItemAnimator.java */
/* loaded from: classes.dex */
public abstract class q extends RecyclerView.l {

    /* renamed from: g  reason: collision with root package name */
    boolean f4114g = true;

    public abstract boolean A(RecyclerView.b0 b0Var);

    public final void B(RecyclerView.b0 b0Var) {
        J(b0Var);
        h(b0Var);
    }

    public final void C(RecyclerView.b0 b0Var) {
        K(b0Var);
    }

    public final void D(RecyclerView.b0 b0Var, boolean z10) {
        L(b0Var, z10);
        h(b0Var);
    }

    public final void E(RecyclerView.b0 b0Var, boolean z10) {
        M(b0Var, z10);
    }

    public final void F(RecyclerView.b0 b0Var) {
        N(b0Var);
        h(b0Var);
    }

    public final void G(RecyclerView.b0 b0Var) {
        O(b0Var);
    }

    public final void H(RecyclerView.b0 b0Var) {
        P(b0Var);
        h(b0Var);
    }

    public final void I(RecyclerView.b0 b0Var) {
        Q(b0Var);
    }

    public void J(RecyclerView.b0 b0Var) {
    }

    public void K(RecyclerView.b0 b0Var) {
    }

    public void L(RecyclerView.b0 b0Var, boolean z10) {
    }

    public void M(RecyclerView.b0 b0Var, boolean z10) {
    }

    public void N(RecyclerView.b0 b0Var) {
    }

    public void O(RecyclerView.b0 b0Var) {
    }

    public void P(RecyclerView.b0 b0Var) {
    }

    public void Q(RecyclerView.b0 b0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        if (cVar == null || ((i10 = cVar.f3821a) == (i11 = cVar2.f3821a) && cVar.f3822b == cVar2.f3822b)) {
            return x(b0Var);
        }
        return z(b0Var, i10, cVar.f3822b, i11, cVar2.f3822b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f3821a;
        int i13 = cVar.f3822b;
        if (b0Var2.shouldIgnore()) {
            int i14 = cVar.f3821a;
            i10 = cVar.f3822b;
            i11 = i14;
        } else {
            i11 = cVar2.f3821a;
            i10 = cVar2.f3822b;
        }
        return y(b0Var, b0Var2, i12, i13, i11, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f3821a;
        int i11 = cVar.f3822b;
        View view = b0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3821a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3822b;
        if (b0Var.isRemoved() || (i10 == left && i11 == top)) {
            return A(b0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(b0Var, i10, i11, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f3821a;
        int i11 = cVar2.f3821a;
        if (i10 != i11 || cVar.f3822b != cVar2.f3822b) {
            return z(b0Var, i10, cVar.f3822b, i11, cVar2.f3822b);
        }
        F(b0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.b0 b0Var) {
        return !this.f4114g || b0Var.isInvalid();
    }

    public abstract boolean x(RecyclerView.b0 b0Var);

    public abstract boolean y(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean z(RecyclerView.b0 b0Var, int i10, int i11, int i12, int i13);
}
