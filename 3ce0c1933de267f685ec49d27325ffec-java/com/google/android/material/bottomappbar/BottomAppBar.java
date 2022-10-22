package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.m;
import e7.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w7.h;
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private Integer R;
    private final int S;
    private final w7.g T;
    private Animator U;
    private Animator V;
    private int W;

    /* renamed from: j0  reason: collision with root package name */
    private int f10467j0;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f10468k0;

    /* renamed from: l0  reason: collision with root package name */
    private int f10469l0;

    /* renamed from: m0  reason: collision with root package name */
    private ArrayList<g> f10470m0;

    /* renamed from: n0  reason: collision with root package name */
    private int f10471n0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f10472o0;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f10473p0;

    /* renamed from: q0  reason: collision with root package name */
    private Behavior f10474q0;

    /* renamed from: r0  reason: collision with root package name */
    private int f10475r0;

    /* renamed from: s0  reason: collision with root package name */
    private int f10476s0;

    /* renamed from: t0  reason: collision with root package name */
    private int f10477t0;

    /* renamed from: u0  reason: collision with root package name */
    AnimatorListenerAdapter f10478u0;

    /* renamed from: v0  reason: collision with root package name */
    k<FloatingActionButton> f10479v0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f10485c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10486d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f10485c);
            parcel.writeInt(this.f10486d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10485c = parcel.readInt();
            this.f10486d = parcel.readInt() != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.n0();
            BottomAppBar.this.U = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends FloatingActionButton.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10488a;

        /* loaded from: classes.dex */
        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.n0();
            }
        }

        b(int i10) {
            this.f10488a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.s0(this.f10488a));
            floatingActionButton.t(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.n0();
            BottomAppBar.this.f10472o0 = false;
            BottomAppBar.this.V = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10492a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f10493b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10494c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f10495d;

        d(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f10493b = actionMenuView;
            this.f10494c = i10;
            this.f10495d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10492a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f10492a) {
                boolean z10 = BottomAppBar.this.f10471n0 != 0;
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.x0(bottomAppBar.f10471n0);
                BottomAppBar.this.D0(this.f10493b, this.f10494c, this.f10495d, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f10497a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10498b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f10499c;

        e(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f10497a = actionMenuView;
            this.f10498b = i10;
            this.f10499c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.f10497a;
            actionMenuView.setTranslationX(BottomAppBar.this.r0(actionMenuView, this.f10498b, this.f10499c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f10478u0.onAnimationStart(animator);
            FloatingActionButton p02 = BottomAppBar.this.p0();
            if (p02 != null) {
                p02.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    private void C0(ActionMenuView actionMenuView, int i10, boolean z10) {
        D0(actionMenuView, i10, z10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        e eVar = new e(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f10475r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return s0(this.W);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f10477t0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f10476s0;
    }

    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.T.E().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.f10478u0);
        floatingActionButton.e(new f());
        floatingActionButton.f(this.f10479v0);
    }

    private void j0() {
        Animator animator = this.V;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.U;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void l0(int i10, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(p0(), "translationX", s0(i10));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void m0(int i10, boolean z10, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
            if (Math.abs(actionMenuView.getTranslationX() - r0(actionMenuView, i10, z10)) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                ofFloat2.addListener(new d(actionMenuView, i10, z10));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150L);
                animatorSet.playSequentially(ofFloat2, ofFloat);
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        ArrayList<g> arrayList;
        int i10 = this.f10469l0 - 1;
        this.f10469l0 = i10;
        if (i10 == 0 && (arrayList = this.f10470m0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        ArrayList<g> arrayList;
        int i10 = this.f10469l0;
        this.f10469l0 = i10 + 1;
        if (i10 == 0 && (arrayList = this.f10470m0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton p0() {
        View q02 = q0();
        if (q02 instanceof FloatingActionButton) {
            return (FloatingActionButton) q02;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View q0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).s(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float s0(int i10) {
        boolean d10 = m.d(this);
        int i11 = 1;
        if (i10 != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.S + (d10 ? this.f10477t0 : this.f10476s0));
        if (d10) {
            i11 = -1;
        }
        return measuredWidth * i11;
    }

    private boolean t0() {
        FloatingActionButton p02 = p0();
        return p02 != null && p02.o();
    }

    private void u0(int i10, boolean z10) {
        if (!d0.X(this)) {
            x0(this.f10471n0);
            return;
        }
        Animator animator = this.V;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        i10 = 0;
        if (!t0()) {
            z10 = false;
        }
        m0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.V = animatorSet;
        animatorSet.addListener(new c());
        this.V.start();
    }

    private void v0(int i10) {
        if (this.W != i10 && d0.X(this)) {
            Animator animator = this.U;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f10467j0 == 1) {
                l0(i10, arrayList);
            } else {
                k0(i10, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.U = animatorSet;
            animatorSet.addListener(new a());
            this.U.start();
        }
    }

    private Drawable w0(Drawable drawable) {
        if (drawable == null || this.R == null) {
            return drawable;
        }
        Drawable r10 = androidx.core.graphics.drawable.a.r(drawable.mutate());
        androidx.core.graphics.drawable.a.n(r10, this.R.intValue());
        return r10;
    }

    private void y0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.V == null) {
            actionMenuView.setAlpha(1.0f);
            if (!t0()) {
                C0(actionMenuView, 0, false);
            } else {
                C0(actionMenuView, this.W, this.f10473p0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        getTopEdgeTreatment().n(getFabTranslationX());
        View q02 = q0();
        this.T.a0((!this.f10473p0 || !t0()) ? 0.0f : 1.0f);
        if (q02 != null) {
            q02.setTranslationY(getFabTranslationY());
            q02.setTranslationX(getFabTranslationX());
        }
    }

    public void A0(int i10, int i11) {
        this.f10471n0 = i11;
        u0(i10, this.f10473p0);
        v0(i10);
        this.W = i10;
    }

    boolean B0(int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().g()) {
            return false;
        }
        getTopEdgeTreatment().m(f10);
        this.T.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.T.G();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.W;
    }

    public int getFabAnimationMode() {
        return this.f10467j0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f10468k0;
    }

    protected void k0(int i10, List<Animator> list) {
        FloatingActionButton p02 = p0();
        if (p02 != null && !p02.n()) {
            o0();
            p02.l(new b(i10));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.T);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            j0();
            z0();
        }
        y0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.W = savedState.f10485c;
        this.f10473p0 = savedState.f10486d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10485c = this.W;
        savedState.f10486d = this.f10473p0;
        return savedState;
    }

    protected int r0(ActionMenuView actionMenuView, int i10, boolean z10) {
        if (i10 != 1 || !z10) {
            return 0;
        }
        boolean d10 = m.d(this);
        int measuredWidth = d10 ? getMeasuredWidth() : 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f512a & 8388615) == 8388611) {
                if (d10) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((d10 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (d10 ? this.f10476s0 : -this.f10477t0));
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.T, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f10);
            this.T.invalidateSelf();
            z0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.T.Y(f10);
        getBehavior().I(this, this.T.D() - this.T.C());
    }

    public void setFabAlignmentMode(int i10) {
        A0(i10, 0);
    }

    public void setFabAnimationMode(int i10) {
        this.f10467j0 = i10;
    }

    void setFabCornerSize(float f10) {
        if (f10 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().j(f10);
            this.T.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f10);
            this.T.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f10);
            this.T.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f10468k0 = z10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(w0(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.R = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void x0(int i10) {
        if (i10 != 0) {
            this.f10471n0 = 0;
            getMenu().clear();
            x(i10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f10474q0 == null) {
            this.f10474q0 = new Behavior();
        }
        return this.f10474q0;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<BottomAppBar> f10481f;

        /* renamed from: g  reason: collision with root package name */
        private int f10482g;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnLayoutChangeListener f10483h = new a();

        /* renamed from: e  reason: collision with root package name */
        private final Rect f10480e = new Rect();

        /* loaded from: classes.dex */
        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f10481f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.i(Behavior.this.f10480e);
                int height = Behavior.this.f10480e.height();
                bottomAppBar.B0(height);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f10480e)));
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f10482g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(d7.d.W) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (m.d(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.S;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.S;
                    }
                }
            }
        }

        public Behavior() {
        }

        /* renamed from: Q */
        public boolean l(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f10481f = new WeakReference<>(bottomAppBar);
            View q02 = bottomAppBar.q0();
            if (q02 != null && !d0.X(q02)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) q02.getLayoutParams();
                fVar.f2201d = 49;
                this.f10482g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (q02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) q02;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(d7.a.f25140b);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(d7.a.f25139a);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.f10483h);
                    bottomAppBar.i0(floatingActionButton);
                }
                bottomAppBar.z0();
            }
            coordinatorLayout.I(bottomAppBar, i10);
            return super.l(coordinatorLayout, bottomAppBar, i10);
        }

        /* renamed from: R */
        public boolean A(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.A(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
