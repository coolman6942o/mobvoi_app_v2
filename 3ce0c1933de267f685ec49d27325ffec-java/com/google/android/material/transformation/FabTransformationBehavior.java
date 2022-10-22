package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d7.f;
import e7.h;
import e7.i;
import e7.j;
import h7.d;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f11672c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f11673d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f11674e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f11675f;

    /* renamed from: g  reason: collision with root package name */
    private float f11676g;

    /* renamed from: h  reason: collision with root package name */
    private float f11677h;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f11678a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f11679b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f11680c;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z10, View view, View view2) {
            this.f11678a = z10;
            this.f11679b = view;
            this.f11680c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f11678a) {
                this.f11679b.setVisibility(4);
                this.f11680c.setAlpha(1.0f);
                this.f11680c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f11678a) {
                this.f11679b.setVisibility(0);
                this.f11680c.setAlpha(0.0f);
                this.f11680c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f11681a;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.f11681a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f11681a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h7.d f11682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Drawable f11683b;

        c(FabTransformationBehavior fabTransformationBehavior, h7.d dVar, Drawable drawable) {
            this.f11682a = dVar;
            this.f11683b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11682a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f11682a.setCircularRevealOverlayDrawable(this.f11683b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h7.d f11684a;

        d(FabTransformationBehavior fabTransformationBehavior, h7.d dVar) {
            this.f11684a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f11684a.getRevealInfo();
            revealInfo.f27751c = Float.MAX_VALUE;
            this.f11684a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public h f11685a;

        /* renamed from: b  reason: collision with root package name */
        public j f11686b;
    }

    public FabTransformationBehavior() {
        this.f11672c = new Rect();
        this.f11673d = new RectF();
        this.f11674e = new RectF();
        this.f11675f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(f.M);
        if (findViewById != null) {
            return f0(findViewById);
        }
        if ((view instanceof y7.b) || (view instanceof y7.a)) {
            return f0(((ViewGroup) view).getChildAt(0));
        }
        return f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f10, float f11, float f12, float f13, RectF rectF) {
        float S = S(eVar, iVar, f10, f12);
        float S2 = S(eVar, iVar2, f11, f13);
        Rect rect = this.f11672c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f11673d;
        rectF2.set(rect);
        RectF rectF3 = this.f11674e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f11676g, this.f11677h);
    }

    private Pair<i, i> N(float f10, float f11, boolean z10, e eVar) {
        i iVar;
        i iVar2;
        int i10;
        if (f10 == 0.0f || f11 == 0.0f) {
            iVar2 = eVar.f11685a.e("translationXLinear");
            iVar = eVar.f11685a.e("translationYLinear");
        } else if ((!z10 || f11 >= 0.0f) && (z10 || i10 <= 0)) {
            iVar2 = eVar.f11685a.e("translationXCurveDownwards");
            iVar = eVar.f11685a.e("translationYCurveDownwards");
        } else {
            iVar2 = eVar.f11685a.e("translationXCurveUpwards");
            iVar = eVar.f11685a.e("translationYCurveUpwards");
        }
        return new Pair<>(iVar2, iVar);
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f11673d;
        RectF rectF2 = this.f11674e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f11673d;
        RectF rectF2 = this.f11674e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float f10;
        float f11;
        float f12;
        RectF rectF = this.f11673d;
        RectF rectF2 = this.f11674e;
        M(view, rectF);
        T(view2, rectF2);
        int i10 = jVar.f25853a & 7;
        if (i10 == 1) {
            f12 = rectF2.centerX();
            f11 = rectF.centerX();
        } else if (i10 == 3) {
            f12 = rectF2.left;
            f11 = rectF.left;
        } else if (i10 != 5) {
            f10 = 0.0f;
            return f10 + jVar.f25854b;
        } else {
            f12 = rectF2.right;
            f11 = rectF.right;
        }
        f10 = f12 - f11;
        return f10 + jVar.f25854b;
    }

    private float R(View view, View view2, j jVar) {
        float f10;
        float f11;
        float f12;
        RectF rectF = this.f11673d;
        RectF rectF2 = this.f11674e;
        M(view, rectF);
        T(view2, rectF2);
        int i10 = jVar.f25853a & 112;
        if (i10 == 16) {
            f12 = rectF2.centerY();
            f11 = rectF.centerY();
        } else if (i10 == 48) {
            f12 = rectF2.top;
            f11 = rectF.top;
        } else if (i10 != 80) {
            f10 = 0.0f;
            return f10 + jVar.f25855c;
        } else {
            f12 = rectF2.bottom;
            f11 = rectF.bottom;
        }
        f10 = f12 - f11;
        return f10 + jVar.f25855c;
    }

    private float S(e eVar, i iVar, float f10, float f11) {
        long c10 = iVar.c();
        long d10 = iVar.d();
        i e10 = eVar.f11685a.e("expansion");
        return e7.a.a(f10, f11, iVar.e().getInterpolation(((float) (((e10.c() + e10.d()) + 17) - c10)) / ((float) d10)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f11675f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof h7.d) || h7.c.f27744a != 0) && (K = K(view2)) != null) {
                if (z10) {
                    if (!z11) {
                        e7.d.f25839a.set(K, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(K, e7.d.f25839a, 1.0f);
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(K, e7.d.f25839a, 0.0f);
                }
                eVar.f11685a.e("contentFade").a(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void V(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof h7.d) {
            h7.d dVar = (h7.d) view2;
            int d02 = d0(view);
            int i10 = 16777215 & d02;
            if (z10) {
                if (!z11) {
                    dVar.setCircularRevealScrimColor(d02);
                }
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0299d.f27748a, i10);
            } else {
                objectAnimator = ObjectAnimator.ofInt(dVar, d.C0299d.f27748a, d02);
            }
            objectAnimator.setEvaluator(e7.c.b());
            eVar.f11685a.e("color").a(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void W(View view, View view2, boolean z10, e eVar, List<Animator> list) {
        float Q = Q(view, view2, eVar.f11686b);
        float R = R(view, view2, eVar.f11686b);
        Pair<i, i> N = N(Q, R, z10, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z10) {
            Q = this.f11676g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z10) {
            R = this.f11677h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float y10 = d0.y(view2) - d0.y(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-y10);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -y10);
        }
        eVar.f11685a.e("elevation").a(objectAnimator);
        list.add(objectAnimator);
    }

    private void Y(View view, View view2, boolean z10, boolean z11, e eVar, float f10, float f11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof h7.d) {
            h7.d dVar = (h7.d) view2;
            float O = O(view, view2, eVar.f11686b);
            float P = P(view, view2, eVar.f11686b);
            ((FloatingActionButton) view).h(this.f11672c);
            float width = this.f11672c.width() / 2.0f;
            i e10 = eVar.f11685a.e("expansion");
            if (z10) {
                if (!z11) {
                    dVar.setRevealInfo(new d.e(O, P, width));
                }
                if (z11) {
                    width = dVar.getRevealInfo().f27751c;
                }
                animator = h7.a.a(dVar, O, P, p7.a.b(O, P, 0.0f, 0.0f, f10, f11));
                animator.addListener(new d(this, dVar));
                b0(view2, e10.c(), (int) O, (int) P, width, list);
            } else {
                float f12 = dVar.getRevealInfo().f27751c;
                Animator a10 = h7.a.a(dVar, O, P, width);
                int i10 = (int) O;
                int i11 = (int) P;
                b0(view2, e10.c(), i10, i11, f12, list);
                a0(view2, e10.c(), e10.d(), eVar.f11685a.f(), i10, i11, width, list);
                animator = a10;
            }
            e10.a(animator);
            list.add(animator);
            list2.add(h7.a.b(dVar));
        }
    }

    private void Z(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof h7.d) && (view instanceof ImageView)) {
            h7.d dVar = (h7.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z10) {
                    if (!z11) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, e7.e.f25840b, 0);
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, e7.e.f25840b, 255);
                }
                objectAnimator.addUpdateListener(new b(this, view2));
                eVar.f11685a.e("iconFade").a(objectAnimator);
                list.add(objectAnimator);
                list2.add(new c(this, dVar, drawable));
            }
        }
    }

    private void a0(View view, long j10, long j11, long j12, int i10, int i11, float f10, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j13 = j10 + j11;
            if (j13 < j12) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
                createCircularReveal.setStartDelay(j13);
                createCircularReveal.setDuration(j12 - j13);
                list.add(createCircularReveal);
            }
        }
    }

    private void b0(View view, long j10, int i10, int i11, float f10, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j10 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j10);
            list.add(createCircularReveal);
        }
    }

    private void c0(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        float Q = Q(view, view2, eVar.f11686b);
        float R = R(view, view2, eVar.f11686b);
        Pair<i, i> N = N(Q, R, z10, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -Q);
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -R);
        }
        iVar.a(objectAnimator2);
        iVar2.a(objectAnimator);
        list.add(objectAnimator2);
        list.add(objectAnimator);
    }

    private int d0(View view) {
        ColorStateList u10 = d0.u(view);
        if (u10 != null) {
            return u10.getColorForState(view.getDrawableState(), u10.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z10, boolean z11) {
        e e02 = e0(view2.getContext(), z10);
        if (z10) {
            this.f11676g = view.getTranslationX();
            this.f11677h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            X(view, view2, z10, z11, e02, arrayList, arrayList2);
        }
        RectF rectF = this.f11673d;
        c0(view, view2, z10, z11, e02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z10, e02, arrayList);
        Z(view, view2, z10, z11, e02, arrayList, arrayList2);
        Y(view, view2, z10, z11, e02, width, height, arrayList, arrayList2);
        V(view, view2, z10, z11, e02, arrayList, arrayList2);
        U(view, view2, z10, z11, e02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        e7.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
    }

    protected abstract e e0(Context context, boolean z10);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f2205h == 0) {
            fVar.f2205h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11672c = new Rect();
        this.f11673d = new RectF();
        this.f11674e = new RectF();
        this.f11675f = new int[2];
    }
}
