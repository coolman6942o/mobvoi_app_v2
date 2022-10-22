package com.mobvoi.android.common.ui.view.datetimepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeaserLayout.java */
/* loaded from: classes2.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f15333a;

    /* renamed from: e  reason: collision with root package name */
    private b f15337e;

    /* renamed from: f  reason: collision with root package name */
    private GestureDetector f15338f;

    /* renamed from: h  reason: collision with root package name */
    private float f15340h;

    /* renamed from: i  reason: collision with root package name */
    private float f15341i;

    /* renamed from: j  reason: collision with root package name */
    private int f15342j;

    /* renamed from: k  reason: collision with root package name */
    private Boolean f15343k;

    /* renamed from: l  reason: collision with root package name */
    private c f15344l;

    /* renamed from: b  reason: collision with root package name */
    private float f15334b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f15335c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    private int f15336d = -1;

    /* renamed from: g  reason: collision with root package name */
    private final d f15339g = new d();

    /* compiled from: TeaserLayout.java */
    /* loaded from: classes2.dex */
    public static class b {
        public void a(View view) {
            com.mobvoi.android.common.ui.view.datetimepicker.b.a(view, true);
            view.setActivated(true);
            view.setClickable(true);
            view.requestFocus();
            view.setImportantForAccessibility(1);
        }

        public void b(View view) {
            com.mobvoi.android.common.ui.view.datetimepicker.b.a(view, false);
            view.setActivated(false);
            view.setClickable(false);
            view.clearFocus();
            view.setImportantForAccessibility(2);
        }
    }

    /* compiled from: TeaserLayout.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TeaserLayout.java */
    /* loaded from: classes2.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private float f15345a;

        /* renamed from: b  reason: collision with root package name */
        private float f15346b;

        /* renamed from: c  reason: collision with root package name */
        private AnimatorSet f15347c;

        /* renamed from: d  reason: collision with root package name */
        private AnimatorSet f15348d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TeaserLayout.java */
        /* renamed from: com.mobvoi.android.common.ui.view.datetimepicker.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0186a extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f15350a;

            C0186a(int i10) {
                this.f15350a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.m(this.f15350a, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TeaserLayout.java */
        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f15352a;

            b(int i10) {
                this.f15352a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.m(this.f15352a, false);
            }
        }

        private d() {
        }

        private boolean b() {
            return a.this.f15336d > 0;
        }

        private boolean c() {
            return a.this.f15336d < a.this.getChildCount() - 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            AnimatorSet animatorSet;
            AnimatorSet animatorSet2;
            float f10 = this.f15345a;
            if (f10 >= 0.0f || (animatorSet2 = this.f15347c) == null) {
                if (f10 > 0.0f && (animatorSet = this.f15348d) != null) {
                    if (this.f15346b >= 0.3f) {
                        this.f15348d.addListener(new b(a.this.f15336d - 1));
                        this.f15348d.start();
                    } else {
                        Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
                        while (it.hasNext()) {
                            ((ValueAnimator) it.next()).reverse();
                        }
                    }
                }
            } else if (this.f15346b >= 0.3f) {
                this.f15347c.addListener(new C0186a(a.this.f15336d + 1));
                this.f15347c.start();
            } else {
                Iterator<Animator> it2 = animatorSet2.getChildAnimations().iterator();
                while (it2.hasNext()) {
                    ((ValueAnimator) it2.next()).reverse();
                }
            }
            this.f15347c = null;
            this.f15348d = null;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f15345a = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            this.f15345a = motionEvent2.getX() - motionEvent.getX();
            this.f15346b = Math.min(1.0f, Math.abs(this.f15345a) / (a.this.getWidth() / 2.0f));
            if (this.f15345a >= 0.0f || !c()) {
                float f12 = this.f15345a;
                if (f12 == 0.0f) {
                    a aVar = a.this;
                    aVar.k(aVar.f15336d);
                } else if (f12 > 0.0f && b()) {
                    if (this.f15348d == null) {
                        a aVar2 = a.this;
                        this.f15348d = aVar2.e(aVar2.f15336d - 1);
                    }
                    Iterator<Animator> it = this.f15348d.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        ValueAnimator valueAnimator = (ValueAnimator) it.next();
                        valueAnimator.setCurrentPlayTime(Math.round(this.f15346b * ((float) valueAnimator.getDuration())));
                    }
                }
            } else {
                if (this.f15347c == null) {
                    a aVar3 = a.this;
                    this.f15347c = aVar3.e(aVar3.f15336d + 1);
                }
                Iterator<Animator> it2 = this.f15347c.getChildAnimations().iterator();
                while (it2.hasNext()) {
                    ValueAnimator valueAnimator2 = (ValueAnimator) it2.next();
                    valueAnimator2.setCurrentPlayTime(Math.round(this.f15346b * ((float) valueAnimator2.getDuration())));
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            float width = a.this.getWidth();
            float f10 = 0.25f * width;
            float x10 = motionEvent.getX();
            if (x10 < f10 && b()) {
                a aVar = a.this;
                aVar.m(aVar.f15336d - 1, true);
            } else if (x10 + f10 > width && c()) {
                a aVar2 = a.this;
                aVar2.m(aVar2.f15336d + 1, true);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TeaserLayout.java */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f15354a;

        /* renamed from: b  reason: collision with root package name */
        private final float[] f15355b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f15356c;

        /* renamed from: d  reason: collision with root package name */
        private final float[] f15357d;

        public int e() {
            return this.f15354a.length;
        }

        private e(int i10) {
            this.f15354a = new int[i10];
            this.f15355b = new float[i10];
            this.f15356c = new float[i10];
            this.f15357d = new float[i10];
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(context);
    }

    private void d(int i10) {
        e(i10).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet e(int i10) {
        WearableListView f10;
        a aVar = this;
        e j10 = j(i10);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        while (i12 < j10.e()) {
            View childAt = aVar.getChildAt(i12);
            float x10 = childAt.getX();
            Property property = View.X;
            float[] fArr = new float[2];
            fArr[i11] = x10;
            int i13 = 1;
            fArr[1] = j10.f15354a[i12];
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(property, fArr);
            float f11 = j10.f15355b[i12];
            float scaleX = childAt.getScaleX();
            Property property2 = View.SCALE_X;
            float[] fArr2 = new float[2];
            fArr2[i11] = scaleX;
            fArr2[1] = f11;
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(property2, fArr2);
            float scaleY = childAt.getScaleY();
            Property property3 = View.SCALE_Y;
            float[] fArr3 = new float[2];
            fArr3[i11] = scaleY;
            fArr3[1] = f11;
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(property3, fArr3);
            if ((childAt instanceof ViewGroup) && (f10 = aVar.f((ViewGroup) childAt)) != null) {
                int i14 = i11;
                while (i14 < f10.getChildCount()) {
                    View childAt2 = f10.getChildAt(i14);
                    PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[i13];
                    propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.ALPHA, childAt2.getAlpha(), childAt2.isSelected() ? j10.f15356c[i12] : j10.f15357d[i12]);
                    arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt2, propertyValuesHolderArr));
                    i14++;
                    i11 = 0;
                    i13 = 1;
                }
            }
            int i15 = i11;
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[3];
            propertyValuesHolderArr2[i15] = ofFloat;
            propertyValuesHolderArr2[1] = ofFloat2;
            propertyValuesHolderArr2[2] = ofFloat3;
            arrayList.add(ObjectAnimator.ofPropertyValuesHolder(childAt, propertyValuesHolderArr2));
            i12++;
            aVar = this;
            i11 = i15;
        }
        AnimatorSet duration = new AnimatorSet().setDuration(300L);
        duration.playTogether(arrayList);
        return duration;
    }

    private WearableListView f(ViewGroup viewGroup) {
        WearableListView f10;
        if (viewGroup instanceof WearableListView) {
            return (WearableListView) viewGroup;
        }
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof ViewGroup) && (f10 = f((ViewGroup) childAt)) != null) {
                return f10;
            }
        }
        return null;
    }

    private e j(int i10) {
        View childAt;
        int width;
        int width2;
        e eVar = new e(getChildCount());
        int width3 = getWidth();
        int i11 = width3 / 2;
        eVar.f15354a[i10] = i11 - (getChildAt(i10).getWidth() / 2);
        int i12 = i10 - 1;
        if (getChildAt(i12) != null) {
            eVar.f15354a[i12] = -Math.round((childAt.getWidth() / 2) - this.f15333a);
        }
        int i13 = i10 + 1;
        View childAt2 = getChildAt(i13);
        if (childAt2 != null) {
            eVar.f15354a[i13] = width3 - (childAt2.getWidth() - Math.round((width2 / 2) - this.f15333a));
        }
        for (int i14 = i10 - 2; i14 >= 0; i14--) {
            int i15 = i14 + 1;
            eVar.f15354a[i14] = ((eVar.f15354a[i15] + (getChildAt(i15).getWidth() / 2)) - i11) - Math.round((getChildAt(i14).getWidth() / 2) - this.f15333a);
        }
        for (int i16 = i10 + 2; i16 < eVar.e(); i16++) {
            int i17 = i16 - 1;
            eVar.f15354a[i16] = ((eVar.f15354a[i17] + (getChildAt(i17).getWidth() / 2)) + i11) - (getChildAt(i16).getWidth() - Math.round((width / 2) - this.f15333a));
        }
        int i18 = 0;
        while (i18 < eVar.e()) {
            boolean z10 = true;
            eVar.f15355b[i18] = i(i18, i18 == i10);
            eVar.f15356c[i18] = g(i18, i18 == i10);
            float[] fArr = eVar.f15357d;
            if (i18 != i10) {
                z10 = false;
            }
            fArr[i18] = h(i18, z10);
            i18++;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i10) {
        WearableListView f10;
        e j10 = j(i10);
        for (int i11 = 0; i11 < j10.e(); i11++) {
            View childAt = getChildAt(i11);
            childAt.setX(j10.f15354a[i11]);
            childAt.setScaleX(j10.f15355b[i11]);
            childAt.setScaleY(j10.f15355b[i11]);
            if ((childAt instanceof ViewGroup) && (f10 = f((ViewGroup) childAt)) != null) {
                for (int i12 = 0; i12 < f10.getChildCount(); i12++) {
                    View childAt2 = f10.getChildAt(i12);
                    childAt2.setAlpha(childAt2.isSelected() ? j10.f15356c[i11] : j10.f15357d[i11]);
                }
            }
        }
    }

    private void l(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this.f15339g);
        this.f15338f = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f15342j = scaledTouchSlop;
        this.f15342j = scaledTouchSlop * scaledTouchSlop;
        this.f15333a = getResources().getDimensionPixelOffset(y9.e.f36811c);
        setActivePassiveSetter(new b());
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (i10 <= 0 || this.f15336d >= getChildCount() - 1) {
            return i10 < 0 && this.f15336d > 0;
        }
        return true;
    }

    protected float g(int i10, boolean z10) {
        return 1.0f;
    }

    protected float h(int i10, boolean z10) {
        return z10 ? 1.0f : 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float i(int i10, boolean z10) {
        return z10 ? this.f15334b : this.f15335c;
    }

    public void m(int i10, boolean z10) {
        int i11;
        b bVar;
        if (i10 >= 0 && i10 < getChildCount() && (i11 = this.f15336d) != i10) {
            if (i11 >= 0 || this.f15337e == null) {
                b bVar2 = this.f15337e;
                if (bVar2 != null) {
                    bVar2.b(getChildAt(i11));
                }
            } else {
                for (int i12 = 0; i12 < getChildCount(); i12++) {
                    if (i12 != i10) {
                        this.f15337e.b(getChildAt(i12));
                    }
                }
            }
            this.f15336d = i10;
            if (i10 >= 0 && (bVar = this.f15337e) != null) {
                bVar.a(getChildAt(i10));
            }
            if (z10) {
                d(i10);
            } else {
                k(i10);
            }
            c cVar = this.f15344l;
            if (cVar != null) {
                cVar.a(this.f15336d);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f15340h = motionEvent.getX();
            this.f15341i = motionEvent.getY();
            this.f15343k = null;
            this.f15338f.onTouchEvent(motionEvent);
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && this.f15343k == null) {
            float abs = Math.abs(this.f15340h - motionEvent.getX());
            float abs2 = Math.abs(this.f15341i - motionEvent.getY());
            if ((abs * abs) + (abs2 * abs2) > this.f15342j) {
                this.f15343k = Boolean.valueOf(abs > abs2);
            }
        }
        Boolean bool = this.f15343k;
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return this.f15338f.onTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = this.f15336d;
        if (i14 != -1) {
            k(i14);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            this.f15339g.d();
        }
        return this.f15338f.onTouchEvent(motionEvent);
    }

    void setActivePassiveSetter(b bVar) {
        this.f15337e = bVar;
        if (bVar != null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (i10 == this.f15336d) {
                    this.f15337e.a(childAt);
                } else {
                    this.f15337e.b(childAt);
                }
            }
        }
    }

    public void setListener(c cVar) {
        this.f15344l = cVar;
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l(context);
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        l(context);
    }
}
