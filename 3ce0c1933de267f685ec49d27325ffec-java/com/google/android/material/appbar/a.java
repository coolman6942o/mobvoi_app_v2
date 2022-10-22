package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f10382d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f10383e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10384f;

    /* renamed from: h  reason: collision with root package name */
    private int f10386h;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f10388j;

    /* renamed from: g  reason: collision with root package name */
    private int f10385g = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f10387i = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderBehavior.java */
    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0118a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final CoordinatorLayout f10389a;

        /* renamed from: b  reason: collision with root package name */
        private final V f10390b;

        RunnableC0118a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f10389a = coordinatorLayout;
            this.f10390b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f10390b != null && (overScroller = a.this.f10383e) != null) {
                if (overScroller.computeScrollOffset()) {
                    a aVar = a.this;
                    aVar.P(this.f10389a, this.f10390b, aVar.f10383e.getCurrY());
                    d0.l0(this.f10390b, this);
                    return;
                }
                a.this.N(this.f10389a, this.f10390b);
            }
        }
    }

    public a() {
    }

    private void I() {
        if (this.f10388j == null) {
            this.f10388j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f10385g);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y10 = (int) motionEvent.getY(findPointerIndex);
                this.f10386h = y10;
                O(coordinatorLayout, v10, this.f10386h - y10, K(v10), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i10 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.f10385g = motionEvent.getPointerId(i10);
                    this.f10386h = (int) (motionEvent.getY(i10) + 0.5f);
                }
            }
            z10 = false;
            velocityTracker = this.f10388j;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return !this.f10384f || z10;
        }
        VelocityTracker velocityTracker3 = this.f10388j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.f10388j.computeCurrentVelocity(1000);
            J(coordinatorLayout, v10, -L(v10), 0, this.f10388j.getYVelocity(this.f10385g));
            z10 = true;
            this.f10384f = false;
            this.f10385g = -1;
            velocityTracker2 = this.f10388j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f10388j = null;
            }
            velocityTracker = this.f10388j;
            if (velocityTracker != null) {
            }
            if (!this.f10384f) {
                return true;
            }
        }
        z10 = false;
        this.f10384f = false;
        this.f10385g = -1;
        velocityTracker2 = this.f10388j;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.f10388j;
        if (velocityTracker != null) {
        }
        if (!this.f10384f) {
        }
    }

    abstract boolean H(V v10);

    final boolean J(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f10382d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f10382d = null;
        }
        if (this.f10383e == null) {
            this.f10383e = new OverScroller(v10.getContext());
        }
        this.f10383e.fling(0, E(), 0, Math.round(f10), 0, 0, i10, i11);
        if (this.f10383e.computeScrollOffset()) {
            RunnableC0118a aVar = new RunnableC0118a(coordinatorLayout, v10);
            this.f10382d = aVar;
            d0.l0(v10, aVar);
            return true;
        }
        N(coordinatorLayout, v10);
        return false;
    }

    abstract int K(V v10);

    abstract int L(V v10);

    abstract int M();

    abstract void N(CoordinatorLayout coordinatorLayout, V v10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return Q(coordinatorLayout, v10, M() - i10, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return Q(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    abstract int Q(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f10387i < 0) {
            this.f10387i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f10384f) {
            int i10 = this.f10385g;
            if (i10 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y10 - this.f10386h) > this.f10387i) {
                this.f10386h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f10385g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = H(v10) && coordinatorLayout.B(v10, x10, y11);
            this.f10384f = z10;
            if (z10) {
                this.f10386h = y11;
                this.f10385g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f10383e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f10383e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f10388j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
