package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.core.view.d0;
import com.google.android.material.progressindicator.b;
import d7.k;
import d7.l;
import java.util.Arrays;
/* compiled from: BaseProgressIndicator.java */
/* loaded from: classes.dex */
public abstract class a<S extends com.google.android.material.progressindicator.b> extends ProgressBar {

    /* renamed from: n  reason: collision with root package name */
    static final int f11180n = k.A;

    /* renamed from: a  reason: collision with root package name */
    S f11181a;

    /* renamed from: b  reason: collision with root package name */
    private int f11182b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11183c;

    /* renamed from: e  reason: collision with root package name */
    private final int f11185e;

    /* renamed from: f  reason: collision with root package name */
    private long f11186f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11188h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f11189i = 4;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f11190j = new RunnableC0127a();

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f11191k = new b();

    /* renamed from: l  reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f11192l = new c();

    /* renamed from: m  reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f11193m = new d();

    /* renamed from: g  reason: collision with root package name */
    r7.a f11187g = new r7.a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f11184d = true;

    /* compiled from: BaseProgressIndicator.java */
    /* renamed from: com.google.android.material.progressindicator.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0127a implements Runnable {
        RunnableC0127a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k();
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.j();
            a.this.f11186f = -1L;
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes.dex */
    class c extends androidx.vectordrawable.graphics.drawable.b {
        c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void a(Drawable drawable) {
            a.this.setIndeterminate(false);
            a aVar = a.this;
            aVar.o(aVar.f11182b, a.this.f11183c);
        }
    }

    /* compiled from: BaseProgressIndicator.java */
    /* loaded from: classes.dex */
    class d extends androidx.vectordrawable.graphics.drawable.b {
        d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void a(Drawable drawable) {
            super.a(drawable);
            if (!a.this.f11188h) {
                a aVar = a.this;
                aVar.setVisibility(aVar.f11189i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(x7.a.c(context, attributeSet, i10, f11180n), attributeSet, i10);
        Context context2 = getContext();
        this.f11181a = i(context2, attributeSet);
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.A, i10, i11, new int[0]);
        h10.getInt(l.F, -1);
        this.f11185e = Math.min(h10.getInt(l.D, -1), 1000);
        h10.recycle();
    }

    private h<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().u();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((g) getCurrentDrawable()).p(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f11185e > 0) {
            SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void n() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().t().d(this.f11192l);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().l(this.f11193m);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().l(this.f11193m);
        }
    }

    private void p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().r(this.f11193m);
            getIndeterminateDrawable().t().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().r(this.f11193m);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f11181a.f11203f;
    }

    public int[] getIndicatorColor() {
        return this.f11181a.f11200c;
    }

    public int getShowAnimationBehavior() {
        return this.f11181a.f11202e;
    }

    public int getTrackColor() {
        return this.f11181a.f11201d;
    }

    public int getTrackCornerRadius() {
        return this.f11181a.f11199b;
    }

    public int getTrackThickness() {
        return this.f11181a.f11198a;
    }

    protected void h(boolean z10) {
        if (this.f11184d) {
            ((g) getCurrentDrawable()).p(q(), false, z10);
        }
    }

    abstract S i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public void o(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() != null && !z10) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.f11182b = i10;
            this.f11183c = z10;
            this.f11188h = true;
            if (!getIndeterminateDrawable().isVisible() || this.f11187g.a(getContext().getContentResolver()) == 0.0f) {
                this.f11192l.a(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().t().f();
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f11191k);
        removeCallbacks(this.f11190j);
        ((g) getCurrentDrawable()).h();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        super.onMeasure(i10, i11);
        h<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int e10 = currentDrawingDelegate.e();
            int d10 = currentDrawingDelegate.d();
            if (e10 < 0) {
                i12 = getMeasuredWidth();
            } else {
                i12 = e10 + getPaddingLeft() + getPaddingRight();
            }
            if (d10 < 0) {
                i13 = getMeasuredHeight();
            } else {
                i13 = d10 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(i12, i13);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        h(i10 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    boolean q() {
        return d0.W(this) && getWindowVisibility() == 0 && l();
    }

    public void setAnimatorDurationScaleProvider(r7.a aVar) {
        this.f11187g = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f11235c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f11235c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f11181a.f11203f = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        if (z10 != isIndeterminate()) {
            g gVar = (g) getCurrentDrawable();
            if (gVar != null) {
                gVar.h();
            }
            super.setIndeterminate(z10);
            g gVar2 = (g) getCurrentDrawable();
            if (gVar2 != null) {
                gVar2.p(q(), false, false);
            }
            if ((gVar2 instanceof j) && q()) {
                ((j) gVar2).t().g();
            }
            this.f11188h = false;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof j) {
            ((g) drawable).h();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{j7.a.b(getContext(), d7.b.f25159o, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f11181a.f11200c = iArr;
            getIndeterminateDrawable().t().c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (!isIndeterminate()) {
            o(i10, false);
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof f) {
            f fVar = (f) drawable;
            fVar.h();
            super.setProgressDrawable(fVar);
            fVar.z(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f11181a.f11202e = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        S s10 = this.f11181a;
        if (s10.f11201d != i10) {
            s10.f11201d = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        S s10 = this.f11181a;
        if (s10.f11199b != i10) {
            s10.f11199b = Math.min(i10, s10.f11198a / 2);
        }
    }

    public void setTrackThickness(int i10) {
        S s10 = this.f11181a;
        if (s10.f11198a != i10) {
            s10.f11198a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 == 0 || i10 == 4 || i10 == 8) {
            this.f11189i = i10;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    @Override // android.widget.ProgressBar
    public j<S> getIndeterminateDrawable() {
        return (j) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public f<S> getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }
}
