package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.n0;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: r  reason: collision with root package name */
    static final Handler f11263r;

    /* renamed from: s  reason: collision with root package name */
    private static final boolean f11264s;

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f11265t;

    /* renamed from: u  reason: collision with root package name */
    private static final String f11266u;

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f11267a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11268b;

    /* renamed from: c  reason: collision with root package name */
    protected final v f11269c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.snackbar.a f11270d;

    /* renamed from: e  reason: collision with root package name */
    private int f11271e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11272f;

    /* renamed from: h  reason: collision with root package name */
    private Rect f11274h;

    /* renamed from: i  reason: collision with root package name */
    private int f11275i;

    /* renamed from: j  reason: collision with root package name */
    private int f11276j;

    /* renamed from: k  reason: collision with root package name */
    private int f11277k;

    /* renamed from: l  reason: collision with root package name */
    private int f11278l;

    /* renamed from: m  reason: collision with root package name */
    private int f11279m;

    /* renamed from: n  reason: collision with root package name */
    private List<r<B>> f11280n;

    /* renamed from: o  reason: collision with root package name */
    private Behavior f11281o;

    /* renamed from: p  reason: collision with root package name */
    private final AccessibilityManager f11282p;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f11273g = new j();

    /* renamed from: q  reason: collision with root package name */
    b.AbstractC0129b f11283q = new m();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k  reason: collision with root package name */
        private final s f11284k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f11284k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f11284k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f11284k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f11286a;

        b(int i10) {
            this.f11286a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.f11286a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f11269c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f11269c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f11269c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f11270d.a(70, CameraConfig.CAMERA_THIRD_DEGREE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f11291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11292b;

        f(int i10) {
            this.f11292b = i10;
            this.f11291a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f11264s) {
                d0.e0(BaseTransientBottomBar.this.f11269c, intValue - this.f11291a);
            } else {
                BaseTransientBottomBar.this.f11269c.setTranslationY(intValue);
            }
            this.f11291a = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f11294a;

        g(int i10) {
            this.f11294a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.H(this.f11294a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f11270d.b(0, CameraConfig.CAMERA_THIRD_DEGREE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private int f11296a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f11264s) {
                d0.e0(BaseTransientBottomBar.this.f11269c, intValue - this.f11296a);
            } else {
                BaseTransientBottomBar.this.f11269c.setTranslationY(intValue);
            }
            this.f11296a = intValue;
        }
    }

    /* loaded from: classes.dex */
    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).P();
                return true;
            } else if (i10 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).E(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int z10;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f11269c != null && baseTransientBottomBar.f11268b != null && (z10 = (BaseTransientBottomBar.this.z() - BaseTransientBottomBar.this.C()) + ((int) BaseTransientBottomBar.this.f11269c.getTranslationY())) < BaseTransientBottomBar.this.f11278l) {
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f11269c.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(BaseTransientBottomBar.f11266u, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f11278l - z10;
                BaseTransientBottomBar.this.f11269c.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    class k implements androidx.core.view.v {
        k() {
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            BaseTransientBottomBar.this.f11275i = n0Var.j();
            BaseTransientBottomBar.this.f11276j = n0Var.k();
            BaseTransientBottomBar.this.f11277k = n0Var.l();
            BaseTransientBottomBar.this.V();
            return n0Var;
        }
    }

    /* loaded from: classes.dex */
    class l extends androidx.core.view.a {
        l() {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            cVar.a(1048576);
            cVar.f0(true);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 != 1048576) {
                return super.j(view, i10, bundle);
            }
            BaseTransientBottomBar.this.s();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class m implements b.AbstractC0129b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.AbstractC0129b
        public void a() {
            Handler handler = BaseTransientBottomBar.f11263r;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.AbstractC0129b
        public void b(int i10) {
            Handler handler = BaseTransientBottomBar.f11263r;
            handler.sendMessage(handler.obtainMessage(1, i10, 0, BaseTransientBottomBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements t {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.H(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f11269c.getRootWindowInsets()) != null) {
                BaseTransientBottomBar.this.f11278l = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                BaseTransientBottomBar.this.V();
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.F()) {
                BaseTransientBottomBar.f11263r.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements u {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i10, int i11, int i12, int i13) {
            BaseTransientBottomBar.this.f11269c.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements SwipeDismissBehavior.c {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.t(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i10) {
            if (i10 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.f11283q);
            } else if (i10 == 1 || i10 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.f11283q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = BaseTransientBottomBar.this.f11269c;
            if (vVar != null) {
                if (vVar.getParent() != null) {
                    BaseTransientBottomBar.this.f11269c.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f11269c.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.R();
                } else {
                    BaseTransientBottomBar.this.T();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class r<B> {
        public void a(B b10, int i10) {
        }

        public void b(B b10) {
        }
    }

    /* loaded from: classes.dex */
    public static class s {

        /* renamed from: a  reason: collision with root package name */
        private b.AbstractC0129b f11307a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    com.google.android.material.snackbar.b.c().k(this.f11307a);
                }
            } else if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.google.android.material.snackbar.b.c().j(this.f11307a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f11307a = baseTransientBottomBar.f11283q;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface u {
        void a(View view, int i10, int i11, int i12, int i13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class v extends FrameLayout {

        /* renamed from: j  reason: collision with root package name */
        private static final View.OnTouchListener f11308j = new a();

        /* renamed from: a  reason: collision with root package name */
        private u f11309a;

        /* renamed from: b  reason: collision with root package name */
        private t f11310b;

        /* renamed from: c  reason: collision with root package name */
        private int f11311c;

        /* renamed from: d  reason: collision with root package name */
        private final float f11312d;

        /* renamed from: e  reason: collision with root package name */
        private final float f11313e;

        /* renamed from: f  reason: collision with root package name */
        private final int f11314f;

        /* renamed from: g  reason: collision with root package name */
        private final int f11315g;

        /* renamed from: h  reason: collision with root package name */
        private ColorStateList f11316h;

        /* renamed from: i  reason: collision with root package name */
        private PorterDuff.Mode f11317i;

        /* loaded from: classes.dex */
        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public v(Context context, AttributeSet attributeSet) {
            super(x7.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, d7.l.f25558y4);
            int i10 = d7.l.F4;
            if (obtainStyledAttributes.hasValue(i10)) {
                d0.B0(this, obtainStyledAttributes.getDimensionPixelSize(i10, 0));
            }
            this.f11311c = obtainStyledAttributes.getInt(d7.l.B4, 0);
            this.f11312d = obtainStyledAttributes.getFloat(d7.l.C4, 1.0f);
            setBackgroundTintList(t7.c.a(context2, obtainStyledAttributes, d7.l.D4));
            setBackgroundTintMode(com.google.android.material.internal.m.e(obtainStyledAttributes.getInt(d7.l.E4, -1), PorterDuff.Mode.SRC_IN));
            this.f11313e = obtainStyledAttributes.getFloat(d7.l.A4, 1.0f);
            this.f11314f = obtainStyledAttributes.getDimensionPixelSize(d7.l.f25566z4, -1);
            this.f11315g = obtainStyledAttributes.getDimensionPixelSize(d7.l.G4, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f11308j);
            setFocusable(true);
            if (getBackground() == null) {
                d0.x0(this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(d7.d.f25223u0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(j7.a.i(this, d7.b.f25161q, d7.b.f25158n, getBackgroundOverlayColorAlpha()));
            if (this.f11316h == null) {
                return androidx.core.graphics.drawable.a.r(gradientDrawable);
            }
            Drawable r10 = androidx.core.graphics.drawable.a.r(gradientDrawable);
            androidx.core.graphics.drawable.a.o(r10, this.f11316h);
            return r10;
        }

        float getActionTextColorAlpha() {
            return this.f11313e;
        }

        int getAnimationMode() {
            return this.f11311c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f11312d;
        }

        int getMaxInlineActionWidth() {
            return this.f11315g;
        }

        int getMaxWidth() {
            return this.f11314f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.f11310b;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            d0.q0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.f11310b;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            u uVar = this.f11309a;
            if (uVar != null) {
                uVar.a(this, i10, i11, i12, i13);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f11314f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f11314f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        void setAnimationMode(int i10) {
            this.f11311c = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f11316h == null)) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.f11316h);
                androidx.core.graphics.drawable.a.p(drawable, this.f11317i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f11316h = colorStateList;
            if (getBackground() != null) {
                Drawable r10 = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(r10, colorStateList);
                androidx.core.graphics.drawable.a.p(r10, this.f11317i);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f11317i = mode;
            if (getBackground() != null) {
                Drawable r10 = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(r10, mode);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        void setOnAttachStateChangeListener(t tVar) {
            this.f11310b = tVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f11308j);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(u uVar) {
            this.f11309a = uVar;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f11264s = i10 >= 16 && i10 <= 19;
        f11265t = new int[]{d7.b.P};
        f11266u = BaseTransientBottomBar.class.getSimpleName();
        f11263r = new Handler(Looper.getMainLooper(), new i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f11267a = viewGroup;
            this.f11270d = aVar;
            this.f11268b = context;
            com.google.android.material.internal.k.a(context);
            v vVar = (v) LayoutInflater.from(context).inflate(A(), viewGroup, false);
            this.f11269c = vVar;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                snackbarContentLayout.c(vVar.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(vVar.getMaxInlineActionWidth());
            }
            vVar.addView(view);
            ViewGroup.LayoutParams layoutParams = vVar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f11274h = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            d0.v0(vVar, 1);
            d0.E0(vVar, 1);
            d0.C0(vVar, true);
            d0.G0(vVar, new k());
            d0.t0(vVar, new l());
            this.f11282p = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private int B() {
        int height = this.f11269c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f11269c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        int[] iArr = new int[2];
        this.f11269c.getLocationOnScreen(iArr);
        return iArr[1] + this.f11269c.getHeight();
    }

    private boolean G() {
        ViewGroup.LayoutParams layoutParams = this.f11269c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void J() {
        this.f11279m = r();
        V();
    }

    private void L(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f11281o;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = x();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).P(this);
        }
        swipeDismissBehavior.K(new p());
        fVar.o(swipeDismissBehavior);
        if (v() == null) {
            fVar.f2204g = 80;
        }
    }

    private boolean N() {
        return this.f11278l > 0 && !this.f11272f && G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (M()) {
            p();
            return;
        }
        if (this.f11269c.getParent() != null) {
            this.f11269c.setVisibility(0);
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        ValueAnimator u10 = u(0.0f, 1.0f);
        ValueAnimator y10 = y(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(u10, y10);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void S(int i10) {
        ValueAnimator u10 = u(1.0f, 0.0f);
        u10.setDuration(75L);
        u10.addListener(new b(i10));
        u10.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int B = B();
        if (f11264s) {
            d0.e0(this.f11269c, B);
        } else {
            this.f11269c.setTranslationY(B);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(B, 0);
        valueAnimator.setInterpolator(e7.a.f25834b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(B));
        valueAnimator.start();
    }

    private void U(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, B());
        valueAnimator.setInterpolator(e7.a.f25834b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i10));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ViewGroup.LayoutParams layoutParams = this.f11269c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.f11274h == null) {
            Log.w(f11266u, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i10 = v() != null ? this.f11279m : this.f11275i;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.f11274h;
        marginLayoutParams.bottomMargin = rect.bottom + i10;
        marginLayoutParams.leftMargin = rect.left + this.f11276j;
        marginLayoutParams.rightMargin = rect.right + this.f11277k;
        this.f11269c.requestLayout();
        if (Build.VERSION.SDK_INT >= 29 && N()) {
            this.f11269c.removeCallbacks(this.f11273g);
            this.f11269c.post(this.f11273g);
        }
    }

    private void q(int i10) {
        if (this.f11269c.getAnimationMode() == 1) {
            S(i10);
        } else {
            U(i10);
        }
    }

    private int r() {
        if (v() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        v().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f11267a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f11267a.getHeight()) - i10;
    }

    private ValueAnimator u(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e7.a.f25833a);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    private ValueAnimator y(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e7.a.f25836d);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f11268b.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    protected int A() {
        return D() ? d7.h.f25305w : d7.h.f25285c;
    }

    protected boolean D() {
        TypedArray obtainStyledAttributes = this.f11268b.obtainStyledAttributes(f11265t);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void E(int i10) {
        if (!M() || this.f11269c.getVisibility() != 0) {
            H(i10);
        } else {
            q(i10);
        }
    }

    public boolean F() {
        return com.google.android.material.snackbar.b.c().e(this.f11283q);
    }

    void H(int i10) {
        com.google.android.material.snackbar.b.c().h(this.f11283q);
        List<r<B>> list = this.f11280n;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f11280n.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f11269c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f11269c);
        }
    }

    void I() {
        com.google.android.material.snackbar.b.c().i(this.f11283q);
        List<r<B>> list = this.f11280n;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f11280n.get(size).b(this);
            }
        }
    }

    public B K(int i10) {
        this.f11271e = i10;
        return this;
    }

    boolean M() {
        AccessibilityManager accessibilityManager = this.f11282p;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void O() {
        com.google.android.material.snackbar.b.c().m(w(), this.f11283q);
    }

    final void P() {
        this.f11269c.setOnAttachStateChangeListener(new n());
        if (this.f11269c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f11269c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                L((CoordinatorLayout.f) layoutParams);
            }
            J();
            this.f11269c.setVisibility(4);
            this.f11267a.addView(this.f11269c);
        }
        if (d0.X(this.f11269c)) {
            Q();
        } else {
            this.f11269c.setOnLayoutChangeListener(new o());
        }
    }

    void p() {
        this.f11269c.post(new q());
    }

    public void s() {
        t(3);
    }

    protected void t(int i10) {
        com.google.android.material.snackbar.b.c().b(this.f11283q, i10);
    }

    public View v() {
        return null;
    }

    public int w() {
        return this.f11271e;
    }

    protected SwipeDismissBehavior<? extends View> x() {
        return new Behavior();
    }
}
