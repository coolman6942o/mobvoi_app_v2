package n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
import java.util.Map;
/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends m {
    private static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> N = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> O = new C0405c(PointF.class, "topLeft");
    private static final Property<k, PointF> P = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> Q = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> S = new g(PointF.class, "position");
    private static n1.k T = new n1.k();
    private int[] J = new int[2];
    private boolean K = false;
    private boolean L = false;

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f30862a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f30863b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f30864c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f30865d;

        a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f30862a = viewGroup;
            this.f30863b = bitmapDrawable;
            this.f30864c = view;
            this.f30865d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.f30862a).b(this.f30863b);
            c0.g(this.f30864c, this.f30865d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f30866a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f30866a);
            Rect rect = this.f30866a;
            return new PointF(rect.left, rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f30866a);
            this.f30866a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f30866a);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: n1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0405c extends Property<k, PointF> {
        C0405c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f30867a;
        private k mViewBounds;

        h(c cVar, k kVar) {
            this.f30867a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f30868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f30869b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f30870c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f30871d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f30872e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f30873f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f30874g;

        i(c cVar, View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f30869b = view;
            this.f30870c = rect;
            this.f30871d = i10;
            this.f30872e = i11;
            this.f30873f = i12;
            this.f30874g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f30868a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f30868a) {
                d0.A0(this.f30869b, this.f30870c);
                c0.f(this.f30869b, this.f30871d, this.f30872e, this.f30873f, this.f30874g);
            }
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    class j extends n {

        /* renamed from: a  reason: collision with root package name */
        boolean f30875a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f30876b;

        j(c cVar, ViewGroup viewGroup) {
            this.f30876b = viewGroup;
        }

        @Override // n1.m.f
        public void b(m mVar) {
            if (!this.f30875a) {
                x.c(this.f30876b, false);
            }
            mVar.P(this);
        }

        @Override // n1.n, n1.m.f
        public void c(m mVar) {
            x.c(this.f30876b, false);
        }

        @Override // n1.n, n1.m.f
        public void d(m mVar) {
            x.c(this.f30876b, false);
            this.f30875a = true;
        }

        @Override // n1.n, n1.m.f
        public void e(m mVar) {
            x.c(this.f30876b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f30877a;

        /* renamed from: b  reason: collision with root package name */
        private int f30878b;

        /* renamed from: c  reason: collision with root package name */
        private int f30879c;

        /* renamed from: d  reason: collision with root package name */
        private int f30880d;

        /* renamed from: e  reason: collision with root package name */
        private View f30881e;

        /* renamed from: f  reason: collision with root package name */
        private int f30882f;

        /* renamed from: g  reason: collision with root package name */
        private int f30883g;

        k(View view) {
            this.f30881e = view;
        }

        private void b() {
            c0.f(this.f30881e, this.f30877a, this.f30878b, this.f30879c, this.f30880d);
            this.f30882f = 0;
            this.f30883g = 0;
        }

        void a(PointF pointF) {
            this.f30879c = Math.round(pointF.x);
            this.f30880d = Math.round(pointF.y);
            int i10 = this.f30883g + 1;
            this.f30883g = i10;
            if (this.f30882f == i10) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f30877a = Math.round(pointF.x);
            this.f30878b = Math.round(pointF.y);
            int i10 = this.f30882f + 1;
            this.f30882f = i10;
            if (i10 == this.f30883g) {
                b();
            }
        }
    }

    private void c0(s sVar) {
        View view = sVar.f30987b;
        if (d0.X(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            sVar.f30986a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            sVar.f30986a.put("android:changeBounds:parent", sVar.f30987b.getParent());
            if (this.L) {
                sVar.f30987b.getLocationInWindow(this.J);
                sVar.f30986a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
                sVar.f30986a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
            }
            if (this.K) {
                sVar.f30986a.put("android:changeBounds:clip", d0.w(view));
            }
        }
    }

    private boolean d0(View view, View view2) {
        if (!this.L) {
            return true;
        }
        s t10 = t(view, true);
        if (t10 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == t10.f30987b) {
            return true;
        }
        return false;
    }

    @Override // n1.m
    public String[] D() {
        return M;
    }

    @Override // n1.m
    public void f(s sVar) {
        c0(sVar);
    }

    @Override // n1.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // n1.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i10;
        View view;
        Animator animator;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f30986a;
        Map<String, Object> map2 = sVar2.f30986a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f30987b;
        if (d0(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f30986a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f30986a.get("android:changeBounds:bounds");
            int i12 = rect2.left;
            int i13 = rect3.left;
            int i14 = rect2.top;
            int i15 = rect3.top;
            int i16 = rect2.right;
            int i17 = rect3.right;
            int i18 = rect2.bottom;
            int i19 = rect3.bottom;
            int i20 = i16 - i12;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            Rect rect4 = (Rect) sVar.f30986a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.f30986a.get("android:changeBounds:clip");
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                i10 = (i12 == i13 && i14 == i15) ? 0 : 1;
                if (!(i16 == i17 && i18 == i19)) {
                    i10++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i10++;
            }
            if (i10 <= 0) {
                return null;
            }
            if (!this.K) {
                view = view2;
                c0.f(view, i12, i14, i16, i18);
                if (i10 == 2) {
                    if (i20 == i22 && i21 == i23) {
                        animator = n1.f.a(view, S, v().a(i12, i14, i13, i15));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a10 = n1.f.a(kVar, O, v().a(i12, i14, i13, i15));
                        ObjectAnimator a11 = n1.f.a(kVar, P, v().a(i16, i18, i17, i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a10, a11);
                        animatorSet.addListener(new h(this, kVar));
                        animator = animatorSet;
                    }
                } else if (i12 == i13 && i14 == i15) {
                    animator = n1.f.a(view, Q, v().a(i16, i18, i17, i19));
                } else {
                    animator = n1.f.a(view, R, v().a(i12, i14, i13, i15));
                }
            } else {
                view = view2;
                c0.f(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                ObjectAnimator a12 = (i12 == i13 && i14 == i15) ? null : n1.f.a(view, S, v().a(i12, i14, i13, i15));
                if (rect4 == null) {
                    i11 = 0;
                    rect = new Rect(0, 0, i20, i21);
                } else {
                    i11 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i11, i11, i22, i23) : rect5;
                if (!rect.equals(rect6)) {
                    d0.A0(view, rect);
                    n1.k kVar2 = T;
                    Object[] objArr = new Object[2];
                    objArr[i11] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", kVar2, objArr);
                    ofObject.addListener(new i(this, view, rect5, i13, i15, i17, i19));
                    objectAnimator = ofObject;
                } else {
                    objectAnimator = null;
                }
                animator = r.c(a12, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                x.c(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) sVar.f30986a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar.f30986a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar2.f30986a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar2.f30986a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.J);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c10 = c0.c(view2);
        c0.g(view2, 0.0f);
        c0.b(viewGroup).a(bitmapDrawable);
        n1.g v10 = v();
        int[] iArr = this.J;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, n1.i.a(N, v10.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c10));
        return ofPropertyValuesHolder;
    }
}
