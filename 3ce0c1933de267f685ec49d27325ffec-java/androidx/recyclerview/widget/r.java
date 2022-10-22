package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: SnapHelper.java */
/* loaded from: classes.dex */
public abstract class r extends RecyclerView.q {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f4115a;

    /* renamed from: b  reason: collision with root package name */
    private final RecyclerView.s f4116b = new a();

    /* compiled from: SnapHelper.java */
    /* loaded from: classes.dex */
    class a extends RecyclerView.s {

        /* renamed from: a  reason: collision with root package name */
        boolean f4117a = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, int i10) {
            super.a(recyclerView, i10);
            if (i10 == 0 && this.f4117a) {
                this.f4117a = false;
                r.this.j();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f4117a = true;
            }
        }
    }

    private void e() {
        this.f4115a.f1(this.f4116b);
        this.f4115a.setOnFlingListener(null);
    }

    private void h() throws IllegalStateException {
        if (this.f4115a.getOnFlingListener() == null) {
            this.f4115a.l(this.f4116b);
            this.f4115a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean i(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        RecyclerView.x d10;
        int g10;
        if (!(layoutManager instanceof RecyclerView.x.b) || (d10 = d(layoutManager)) == null || (g10 = g(layoutManager, i10, i11)) == -1) {
            return false;
        }
        d10.p(g10);
        layoutManager.K1(d10);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean a(int i10, int i11) {
        RecyclerView.LayoutManager layoutManager = this.f4115a.getLayoutManager();
        if (layoutManager == null || this.f4115a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4115a.getMinFlingVelocity();
        return (Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && i(layoutManager, i10, i11);
    }

    public void b(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f4115a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.f4115a = recyclerView;
            if (recyclerView != null) {
                h();
                new Scroller(this.f4115a.getContext(), new DecelerateInterpolator());
                j();
            }
        }
    }

    public abstract int[] c(RecyclerView.LayoutManager layoutManager, View view);

    protected abstract RecyclerView.x d(RecyclerView.LayoutManager layoutManager);

    public abstract View f(RecyclerView.LayoutManager layoutManager);

    public abstract int g(RecyclerView.LayoutManager layoutManager, int i10, int i11);

    void j() {
        RecyclerView.LayoutManager layoutManager;
        View f10;
        RecyclerView recyclerView = this.f4115a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (f10 = f(layoutManager)) != null) {
            int[] c10 = c(layoutManager, f10);
            if (c10[0] != 0 || c10[1] != 0) {
                this.f4115a.s1(c10[0], c10[1]);
            }
        }
    }
}
