package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.d0;
import java.util.ArrayList;
import java.util.Iterator;
import w7.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class b {
    static final TimeInterpolator D = e7.a.f25835c;
    static final int[] E = {16842919, 16842910};
    static final int[] F = {16843623, 16842908, 16842910};
    static final int[] G = {16842908, 16842910};
    static final int[] H = {16843623, 16842910};
    static final int[] I = {16842910};
    static final int[] J = new int[0];
    private ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a  reason: collision with root package name */
    w7.k f10926a;

    /* renamed from: b  reason: collision with root package name */
    w7.g f10927b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f10928c;

    /* renamed from: d  reason: collision with root package name */
    com.google.android.material.floatingactionbutton.a f10929d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f10930e;

    /* renamed from: f  reason: collision with root package name */
    boolean f10931f;

    /* renamed from: h  reason: collision with root package name */
    float f10933h;

    /* renamed from: i  reason: collision with root package name */
    float f10934i;

    /* renamed from: j  reason: collision with root package name */
    float f10935j;

    /* renamed from: k  reason: collision with root package name */
    int f10936k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.material.internal.f f10937l;

    /* renamed from: m  reason: collision with root package name */
    private Animator f10938m;

    /* renamed from: n  reason: collision with root package name */
    private e7.h f10939n;

    /* renamed from: o  reason: collision with root package name */
    private e7.h f10940o;

    /* renamed from: p  reason: collision with root package name */
    private float f10941p;

    /* renamed from: r  reason: collision with root package name */
    private int f10943r;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f10945t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f10946u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<j> f10947v;

    /* renamed from: w  reason: collision with root package name */
    final FloatingActionButton f10948w;

    /* renamed from: x  reason: collision with root package name */
    final v7.b f10949x;

    /* renamed from: g  reason: collision with root package name */
    boolean f10932g = true;

    /* renamed from: q  reason: collision with root package name */
    private float f10942q = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private int f10944s = 0;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f10950y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f10951z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10952a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f10953b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f10954c;

        a(boolean z10, k kVar) {
            this.f10953b = z10;
            this.f10954c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10952a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f10944s = 0;
            b.this.f10938m = null;
            if (!this.f10952a) {
                FloatingActionButton floatingActionButton = b.this.f10948w;
                boolean z10 = this.f10953b;
                floatingActionButton.a(z10 ? 8 : 4, z10);
                k kVar = this.f10954c;
                if (kVar != null) {
                    kVar.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f10948w.a(0, this.f10953b);
            b.this.f10944s = 1;
            b.this.f10938m = animator;
            this.f10952a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0124b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f10957b;

        C0124b(boolean z10, k kVar) {
            this.f10956a = z10;
            this.f10957b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f10944s = 0;
            b.this.f10938m = null;
            k kVar = this.f10957b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f10948w.a(0, this.f10956a);
            b.this.f10944s = 2;
            b.this.f10938m = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class c extends e7.g {
        c() {
        }

        @Override // e7.g
        /* renamed from: a */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            b.this.f10942q = f10;
            return super.a(f10, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f10960a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f10961b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f10962c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f10963d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f10964e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f10965f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ float f10966g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Matrix f10967h;

        d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f10960a = f10;
            this.f10961b = f11;
            this.f10962c = f12;
            this.f10963d = f13;
            this.f10964e = f14;
            this.f10965f = f15;
            this.f10966g = f16;
            this.f10967h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.f10948w.setAlpha(e7.a.b(this.f10960a, this.f10961b, 0.0f, 0.2f, floatValue));
            b.this.f10948w.setScaleX(e7.a.a(this.f10962c, this.f10963d, floatValue));
            b.this.f10948w.setScaleY(e7.a.a(this.f10964e, this.f10963d, floatValue));
            b.this.f10942q = e7.a.a(this.f10965f, this.f10966g, floatValue);
            b.this.h(e7.a.a(this.f10965f, this.f10966g, floatValue), this.f10967h);
            b.this.f10948w.setImageMatrix(this.f10967h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class e implements TypeEvaluator<Float> {

        /* renamed from: a  reason: collision with root package name */
        FloatEvaluator f10969a = new FloatEvaluator();

        e(b bVar) {
        }

        /* renamed from: a */
        public Float evaluate(float f10, Float f11, Float f12) {
            float floatValue = this.f10969a.evaluate(f10, (Number) f11, (Number) f12).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.H();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class g extends m {
        g(b bVar) {
            super(bVar, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.m
        protected float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class h extends m {
        h() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.m
        protected float a() {
            b bVar = b.this;
            return bVar.f10933h + bVar.f10934i;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class i extends m {
        i() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.m
        protected float a() {
            b bVar = b.this;
            return bVar.f10933h + bVar.f10935j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public interface j {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    public interface k {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private class l extends m {
        l() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.m
        protected float a() {
            return b.this.f10933h;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes.dex */
    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10974a;

        /* renamed from: b  reason: collision with root package name */
        private float f10975b;

        /* renamed from: c  reason: collision with root package name */
        private float f10976c;

        private m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.g0((int) this.f10976c);
            this.f10974a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f10974a) {
                w7.g gVar = b.this.f10927b;
                this.f10975b = gVar == null ? 0.0f : gVar.w();
                this.f10976c = a();
                this.f10974a = true;
            }
            b bVar = b.this;
            float f10 = this.f10975b;
            bVar.g0((int) (f10 + ((this.f10976c - f10) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(b bVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FloatingActionButton floatingActionButton, v7.b bVar) {
        this.f10948w = floatingActionButton;
        this.f10949x = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.f10937l = fVar;
        fVar.a(E, k(new i()));
        fVar.a(F, k(new h()));
        fVar.a(G, k(new h()));
        fVar.a(H, k(new h()));
        fVar.a(I, k(new l()));
        fVar.a(J, k(new g(this)));
        this.f10941p = floatingActionButton.getRotation();
    }

    private boolean a0() {
        return d0.X(this.f10948w) && !this.f10948w.isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f10, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f10948w.getDrawable();
        if (drawable != null && this.f10943r != 0) {
            RectF rectF = this.f10951z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i10 = this.f10943r;
            rectF2.set(0.0f, 0.0f, i10, i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f10943r;
            matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
        }
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new e(this));
        }
    }

    private AnimatorSet i(e7.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f10948w, View.ALPHA, f10);
        hVar.e("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f10948w, View.SCALE_X, f11);
        hVar.e("scale").a(ofFloat2);
        h0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f10948w, View.SCALE_Y, f11);
        hVar.e("scale").a(ofFloat3);
        h0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f12, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f10948w, new e7.f(), new c(), new Matrix(this.B));
        hVar.e("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        e7.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f10, float f11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new d(this.f10948w.getAlpha(), f10, this.f10948w.getScaleX(), f11, this.f10948w.getScaleY(), this.f10942q, f12, new Matrix(this.B)));
        arrayList.add(ofFloat);
        e7.b.a(animatorSet, arrayList);
        animatorSet.setDuration(q7.a.d(this.f10948w.getContext(), d7.b.K, this.f10948w.getContext().getResources().getInteger(d7.g.f25281b)));
        animatorSet.setInterpolator(q7.a.e(this.f10948w.getContext(), d7.b.L, e7.a.f25834b));
        return animatorSet;
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.f10937l.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            w7.h.f(this.f10948w, gVar);
        }
        if (K()) {
            this.f10948w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        ViewTreeObserver viewTreeObserver = this.f10948w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int[] iArr) {
        this.f10937l.d(iArr);
    }

    void F(float f10, float f11, float f12) {
        f0();
        g0(f10);
    }

    void G(Rect rect) {
        j0.h.h(this.f10930e, "Didn't initialize content background");
        if (Z()) {
            this.f10949x.c(new InsetDrawable(this.f10930e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f10949x.c(this.f10930e);
    }

    void H() {
        float rotation = this.f10948w.getRotation();
        if (this.f10941p != rotation) {
            this.f10941p = rotation;
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        ArrayList<j> arrayList = this.f10947v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        ArrayList<j> arrayList = this.f10947v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f10929d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(PorterDuff.Mode mode) {
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(float f10) {
        if (this.f10933h != f10) {
            this.f10933h = f10;
            F(f10, this.f10934i, this.f10935j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z10) {
        this.f10931f = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(e7.h hVar) {
        this.f10940o = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f10) {
        if (this.f10934i != f10) {
            this.f10934i = f10;
            F(this.f10933h, f10, this.f10935j);
        }
    }

    final void R(float f10) {
        this.f10942q = f10;
        Matrix matrix = this.B;
        h(f10, matrix);
        this.f10948w.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(int i10) {
        if (this.f10943r != i10) {
            this.f10943r = i10;
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i10) {
        this.f10936k = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(float f10) {
        if (this.f10935j != f10) {
            this.f10935j = f10;
            F(this.f10933h, this.f10934i, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f10928c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, u7.b.d(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(boolean z10) {
        this.f10932g = z10;
        f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(w7.k kVar) {
        this.f10926a = kVar;
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Drawable drawable = this.f10928c;
        if (drawable instanceof n) {
            ((n) drawable).setShapeAppearanceModel(kVar);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f10929d;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Y(e7.h hVar) {
        this.f10939n = hVar;
    }

    boolean Z() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b0() {
        return !this.f10931f || this.f10948w.getSizeDimension() >= this.f10936k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(k kVar, boolean z10) {
        AnimatorSet animatorSet;
        if (!z()) {
            Animator animator = this.f10938m;
            if (animator != null) {
                animator.cancel();
            }
            boolean z11 = this.f10939n == null;
            if (a0()) {
                if (this.f10948w.getVisibility() != 0) {
                    float f10 = 0.0f;
                    this.f10948w.setAlpha(0.0f);
                    this.f10948w.setScaleY(z11 ? 0.4f : 0.0f);
                    this.f10948w.setScaleX(z11 ? 0.4f : 0.0f);
                    if (z11) {
                        f10 = 0.4f;
                    }
                    R(f10);
                }
                e7.h hVar = this.f10939n;
                if (hVar != null) {
                    animatorSet = i(hVar, 1.0f, 1.0f, 1.0f);
                } else {
                    animatorSet = j(1.0f, 1.0f, 1.0f);
                }
                animatorSet.addListener(new C0124b(z10, kVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f10945t;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener(it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            this.f10948w.a(0, z10);
            this.f10948w.setAlpha(1.0f);
            this.f10948w.setScaleY(1.0f);
            this.f10948w.setScaleX(1.0f);
            R(1.0f);
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    void d0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f10941p % 90.0f != 0.0f) {
                if (this.f10948w.getLayerType() != 1) {
                    this.f10948w.setLayerType(1, null);
                }
            } else if (this.f10948w.getLayerType() != 0) {
                this.f10948w.setLayerType(0, null);
            }
        }
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            gVar.f0((int) this.f10941p);
        }
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f10946u == null) {
            this.f10946u = new ArrayList<>();
        }
        this.f10946u.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e0() {
        R(this.f10942q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f10945t == null) {
            this.f10945t = new ArrayList<>();
        }
        this.f10945t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f0() {
        Rect rect = this.f10950y;
        s(rect);
        G(rect);
        this.f10949x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(j jVar) {
        if (this.f10947v == null) {
            this.f10947v = new ArrayList<>();
        }
        this.f10947v.add(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(float f10) {
        w7.g gVar = this.f10927b;
        if (gVar != null) {
            gVar.Y(f10);
        }
    }

    w7.g l() {
        return new w7.g((w7.k) j0.h.g(this.f10926a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable m() {
        return this.f10930e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.f10933h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f10931f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e7.h p() {
        return this.f10940o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float q() {
        return this.f10934i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Rect rect) {
        int sizeDimension = this.f10931f ? (this.f10936k - this.f10948w.getSizeDimension()) / 2 : 0;
        float n10 = this.f10932g ? n() + this.f10935j : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil(n10));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(n10 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.f10935j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final w7.k u() {
        return this.f10926a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e7.h v() {
        return this.f10939n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(k kVar, boolean z10) {
        AnimatorSet animatorSet;
        if (!y()) {
            Animator animator = this.f10938m;
            if (animator != null) {
                animator.cancel();
            }
            if (a0()) {
                e7.h hVar = this.f10940o;
                if (hVar != null) {
                    animatorSet = i(hVar, 0.0f, 0.0f, 0.0f);
                } else {
                    animatorSet = j(0.0f, 0.4f, 0.4f);
                }
                animatorSet.addListener(new a(z10, kVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.f10946u;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener(it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            this.f10948w.a(z10 ? 8 : 4, z10);
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        w7.g l10 = l();
        this.f10927b = l10;
        l10.setTintList(colorStateList);
        if (mode != null) {
            this.f10927b.setTintMode(mode);
        }
        this.f10927b.e0(-12303292);
        this.f10927b.O(this.f10948w.getContext());
        u7.a aVar = new u7.a(this.f10927b.E());
        aVar.setTintList(u7.b.d(colorStateList2));
        this.f10928c = aVar;
        this.f10930e = new LayerDrawable(new Drawable[]{(Drawable) j0.h.g(this.f10927b), aVar});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return this.f10948w.getVisibility() == 0 ? this.f10944s == 1 : this.f10944s != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f10948w.getVisibility() != 0 ? this.f10944s == 2 : this.f10944s != 1;
    }
}
