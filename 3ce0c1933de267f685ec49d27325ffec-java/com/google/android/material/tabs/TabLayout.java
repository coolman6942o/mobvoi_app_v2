package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.a1;
import androidx.core.view.d0;
import androidx.core.view.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.m;
import d7.k;
import d7.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import k0.c;
@ViewPager.e
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int R = k.f25347l;
    private static final j0.e<g> S = new j0.g(16);
    boolean A;
    boolean B;
    int C;
    int D;
    boolean E;
    private com.google.android.material.tabs.b F;
    private c G;
    private final ArrayList<c> H;
    private c I;
    private ValueAnimator J;
    ViewPager K;
    private androidx.viewpager.widget.a L;
    private DataSetObserver M;
    private h N;
    private b O;
    private boolean P;
    private final j0.e<i> Q;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<g> f11339a;

    /* renamed from: b  reason: collision with root package name */
    private g f11340b;

    /* renamed from: c  reason: collision with root package name */
    final f f11341c;

    /* renamed from: d  reason: collision with root package name */
    int f11342d;

    /* renamed from: e  reason: collision with root package name */
    int f11343e;

    /* renamed from: f  reason: collision with root package name */
    int f11344f;

    /* renamed from: g  reason: collision with root package name */
    int f11345g;

    /* renamed from: h  reason: collision with root package name */
    int f11346h;

    /* renamed from: i  reason: collision with root package name */
    ColorStateList f11347i;

    /* renamed from: j  reason: collision with root package name */
    ColorStateList f11348j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f11349k;

    /* renamed from: l  reason: collision with root package name */
    Drawable f11350l;

    /* renamed from: m  reason: collision with root package name */
    private int f11351m;

    /* renamed from: n  reason: collision with root package name */
    PorterDuff.Mode f11352n;

    /* renamed from: o  reason: collision with root package name */
    float f11353o;

    /* renamed from: p  reason: collision with root package name */
    float f11354p;

    /* renamed from: q  reason: collision with root package name */
    final int f11355q;

    /* renamed from: r  reason: collision with root package name */
    int f11356r;

    /* renamed from: s  reason: collision with root package name */
    private final int f11357s;

    /* renamed from: t  reason: collision with root package name */
    private final int f11358t;

    /* renamed from: u  reason: collision with root package name */
    private final int f11359u;

    /* renamed from: v  reason: collision with root package name */
    private int f11360v;

    /* renamed from: w  reason: collision with root package name */
    int f11361w;

    /* renamed from: x  reason: collision with root package name */
    int f11362x;

    /* renamed from: y  reason: collision with root package name */
    int f11363y;

    /* renamed from: z  reason: collision with root package name */
    int f11364z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements ViewPager.i {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11366a;

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.K == viewPager) {
                tabLayout.H(aVar2, this.f11366a);
            }
        }

        void b(boolean z10) {
            this.f11366a = z10;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface c<T extends g> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    /* loaded from: classes.dex */
    public interface d extends c<g> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.A();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        ValueAnimator f11369a;

        /* renamed from: c  reason: collision with root package name */
        float f11371c;

        /* renamed from: b  reason: collision with root package name */
        int f11370b = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f11372d = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f11374a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f11375b;

            a(View view, View view2) {
                this.f11374a = view;
                this.f11375b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.h(this.f11374a, this.f11375b, valueAnimator.getAnimatedFraction());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f11377a;

            b(int i10) {
                this.f11377a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.f11370b = this.f11377a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f11370b = this.f11377a;
            }
        }

        f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            View childAt = getChildAt(this.f11370b);
            com.google.android.material.tabs.b bVar = TabLayout.this.F;
            TabLayout tabLayout = TabLayout.this;
            bVar.d(tabLayout, childAt, tabLayout.f11350l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f10) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.b bVar = TabLayout.this.F;
                TabLayout tabLayout = TabLayout.this;
                bVar.c(tabLayout, view, view2, f10, tabLayout.f11350l);
            } else {
                Drawable drawable = TabLayout.this.f11350l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f11350l.getBounds().bottom);
            }
            d0.k0(this);
        }

        private void i(boolean z10, int i10, int i11) {
            View childAt = getChildAt(this.f11370b);
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z10) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f11369a = valueAnimator;
                valueAnimator.setInterpolator(e7.a.f25834b);
                valueAnimator.setDuration(i11);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i10));
                valueAnimator.start();
                return;
            }
            this.f11369a.removeAllUpdateListeners();
            this.f11369a.addUpdateListener(aVar);
        }

        void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f11369a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f11369a.cancel();
            }
            i(true, i10, i11);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height = TabLayout.this.f11350l.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.f11350l.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.f11363y;
            int i11 = 0;
            if (i10 == 0) {
                i11 = getHeight() - height;
                height = getHeight();
            } else if (i10 == 1) {
                i11 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i10 != 2) {
                height = i10 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.f11350l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f11350l.getBounds();
                TabLayout.this.f11350l.setBounds(bounds.left, i11, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.f11350l;
                if (tabLayout.f11351m != 0) {
                    drawable = androidx.core.graphics.drawable.a.r(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.f11351m, PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.n(drawable, TabLayout.this.f11351m);
                    }
                } else if (Build.VERSION.SDK_INT == 21) {
                    drawable.setColorFilter(null);
                } else {
                    androidx.core.graphics.drawable.a.o(drawable, null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i10, float f10) {
            ValueAnimator valueAnimator = this.f11369a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f11369a.cancel();
            }
            this.f11370b = i10;
            this.f11371c = f10;
            h(getChildAt(i10), getChildAt(this.f11370b + 1), this.f11371c);
        }

        void g(int i10) {
            Rect bounds = TabLayout.this.f11350l.getBounds();
            TabLayout.this.f11350l.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f11369a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                i(false, this.f11370b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z10 = true;
                if (tabLayout.f11361w == 1 || tabLayout.f11364z == 2) {
                    int childCount = getChildCount();
                    int i12 = 0;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt = getChildAt(i13);
                        if (childAt.getVisibility() == 0) {
                            i12 = Math.max(i12, childAt.getMeasuredWidth());
                        }
                    }
                    if (i12 > 0) {
                        if (i12 * childCount <= getMeasuredWidth() - (((int) m.b(getContext(), 16)) * 2)) {
                            boolean z11 = false;
                            for (int i14 = 0; i14 < childCount; i14++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i14).getLayoutParams();
                                if (layoutParams.width != i12 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i12;
                                    layoutParams.weight = 0.0f;
                                    z11 = true;
                                }
                            }
                            z10 = z11;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.f11361w = 0;
                            tabLayout2.O(false);
                        }
                        if (z10) {
                            super.onMeasure(i10, i11);
                        }
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
            if (Build.VERSION.SDK_INT < 23 && this.f11372d != i10) {
                requestLayout();
                this.f11372d = i10;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f11379a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f11380b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f11381c;

        /* renamed from: e  reason: collision with root package name */
        private View f11383e;

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f11385g;

        /* renamed from: h  reason: collision with root package name */
        public i f11386h;

        /* renamed from: d  reason: collision with root package name */
        private int f11382d = -1;

        /* renamed from: f  reason: collision with root package name */
        private int f11384f = 1;

        /* renamed from: i  reason: collision with root package name */
        private int f11387i = -1;

        public View e() {
            return this.f11383e;
        }

        public Drawable f() {
            return this.f11379a;
        }

        public int g() {
            return this.f11382d;
        }

        public int h() {
            return this.f11384f;
        }

        public CharSequence i() {
            return this.f11380b;
        }

        public boolean j() {
            TabLayout tabLayout = this.f11385g;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                return selectedTabPosition != -1 && selectedTabPosition == this.f11382d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void k() {
            this.f11385g = null;
            this.f11386h = null;
            this.f11379a = null;
            this.f11387i = -1;
            this.f11380b = null;
            this.f11381c = null;
            this.f11382d = -1;
            this.f11383e = null;
        }

        public void l() {
            TabLayout tabLayout = this.f11385g;
            if (tabLayout != null) {
                tabLayout.F(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g m(CharSequence charSequence) {
            this.f11381c = charSequence;
            t();
            return this;
        }

        public g n(int i10) {
            return o(LayoutInflater.from(this.f11386h.getContext()).inflate(i10, (ViewGroup) this.f11386h, false));
        }

        public g o(View view) {
            this.f11383e = view;
            t();
            return this;
        }

        public g p(int i10) {
            TabLayout tabLayout = this.f11385g;
            if (tabLayout != null) {
                return q(e.a.b(tabLayout.getContext(), i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g q(Drawable drawable) {
            this.f11379a = drawable;
            TabLayout tabLayout = this.f11385g;
            if (tabLayout.f11361w == 1 || tabLayout.f11364z == 2) {
                tabLayout.O(true);
            }
            t();
            if (com.google.android.material.badge.a.f10444a && this.f11386h.l() && this.f11386h.f11395e.isVisible()) {
                this.f11386h.invalidate();
            }
            return this;
        }

        void r(int i10) {
            this.f11382d = i10;
        }

        public g s(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f11381c) && !TextUtils.isEmpty(charSequence)) {
                this.f11386h.setContentDescription(charSequence);
            }
            this.f11380b = charSequence;
            t();
            return this;
        }

        void t() {
            i iVar = this.f11386h;
            if (iVar != null) {
                iVar.t();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h implements ViewPager.j {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f11388a;

        /* renamed from: b  reason: collision with root package name */
        private int f11389b;

        /* renamed from: c  reason: collision with root package name */
        private int f11390c;

        public h(TabLayout tabLayout) {
            this.f11388a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f11390c = 0;
            this.f11389b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f11388a.get();
            if (tabLayout != null) {
                int i12 = this.f11390c;
                boolean z10 = false;
                boolean z11 = i12 != 2 || this.f11389b == 1;
                if (!(i12 == 2 && this.f11389b == 0)) {
                    z10 = true;
                }
                tabLayout.J(i10, f10, z11, z10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void u(int i10) {
            this.f11389b = this.f11390c;
            this.f11390c = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void v(int i10) {
            TabLayout tabLayout = this.f11388a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f11390c;
                tabLayout.G(tabLayout.x(i10), i11 == 0 || (i11 == 2 && this.f11389b == 0));
            }
        }
    }

    /* loaded from: classes.dex */
    public final class i extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private g f11391a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f11392b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f11393c;

        /* renamed from: d  reason: collision with root package name */
        private View f11394d;

        /* renamed from: e  reason: collision with root package name */
        private BadgeDrawable f11395e;

        /* renamed from: f  reason: collision with root package name */
        private View f11396f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f11397g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f11398h;

        /* renamed from: i  reason: collision with root package name */
        private Drawable f11399i;

        /* renamed from: j  reason: collision with root package name */
        private int f11400j = 2;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements View.OnLayoutChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f11402a;

            a(View view) {
                this.f11402a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f11402a.getVisibility() == 0) {
                    i.this.s(this.f11402a);
                }
            }
        }

        public i(Context context) {
            super(context);
            u(context);
            d0.H0(this, TabLayout.this.f11342d, TabLayout.this.f11343e, TabLayout.this.f11344f, TabLayout.this.f11345g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            d0.I0(this, z.b(getContext(), 1002));
        }

        private void f(View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new a(view));
            }
        }

        private float g(Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        private BadgeDrawable getBadge() {
            return this.f11395e;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.f11395e == null) {
                this.f11395e = BadgeDrawable.c(getContext());
            }
            r();
            BadgeDrawable badgeDrawable = this.f11395e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Canvas canvas) {
            Drawable drawable = this.f11399i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f11399i.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            if ((view == this.f11393c || view == this.f11392b) && com.google.android.material.badge.a.f10444a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return this.f11395e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.f10444a) {
                frameLayout = i();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(d7.h.f25287e, (ViewGroup) frameLayout, false);
            this.f11393c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void n() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.f10444a) {
                frameLayout = i();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(d7.h.f25288f, (ViewGroup) frameLayout, false);
            this.f11392b = textView;
            frameLayout.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                com.google.android.material.badge.a.a(this.f11395e, view, k(view));
                this.f11394d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.f11394d;
                if (view != null) {
                    com.google.android.material.badge.a.d(this.f11395e, view);
                    this.f11394d = null;
                }
            }
        }

        private void r() {
            g gVar;
            g gVar2;
            if (l()) {
                if (this.f11396f != null) {
                    q();
                } else if (this.f11393c != null && (gVar2 = this.f11391a) != null && gVar2.f() != null) {
                    View view = this.f11394d;
                    ImageView imageView = this.f11393c;
                    if (view != imageView) {
                        q();
                        p(this.f11393c);
                        return;
                    }
                    s(imageView);
                } else if (this.f11392b == null || (gVar = this.f11391a) == null || gVar.h() != 1) {
                    q();
                } else {
                    View view2 = this.f11394d;
                    TextView textView = this.f11392b;
                    if (view2 != textView) {
                        q();
                        p(this.f11392b);
                        return;
                    }
                    s(textView);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            if (l() && view == this.f11394d) {
                com.google.android.material.badge.a.e(this.f11395e, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void u(Context context) {
            int i10 = TabLayout.this.f11355q;
            GradientDrawable gradientDrawable = null;
            if (i10 != 0) {
                Drawable b10 = e.a.b(context, i10);
                this.f11399i = b10;
                if (b10 != null && b10.isStateful()) {
                    this.f11399i.setState(getDrawableState());
                }
            } else {
                this.f11399i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f11349k != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a10 = u7.b.a(TabLayout.this.f11349k);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z10 = TabLayout.this.E;
                    if (z10) {
                        gradientDrawable2 = null;
                    }
                    if (!z10) {
                        gradientDrawable = gradientDrawable3;
                    }
                    gradientDrawable2 = new RippleDrawable(a10, gradientDrawable2, gradientDrawable);
                } else {
                    Drawable r10 = androidx.core.graphics.drawable.a.r(gradientDrawable3);
                    androidx.core.graphics.drawable.a.o(r10, a10);
                    gradientDrawable2 = new LayerDrawable(new Drawable[]{gradientDrawable2, r10});
                }
            }
            d0.x0(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        private void w(TextView textView, ImageView imageView) {
            g gVar = this.f11391a;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || gVar.f() == null) ? null : androidx.core.graphics.drawable.a.r(this.f11391a.f()).mutate();
            if (mutate != null) {
                androidx.core.graphics.drawable.a.o(mutate, TabLayout.this.f11348j);
                PorterDuff.Mode mode = TabLayout.this.f11352n;
                if (mode != null) {
                    androidx.core.graphics.drawable.a.p(mutate, mode);
                }
            }
            g gVar2 = this.f11391a;
            CharSequence i10 = gVar2 != null ? gVar2.i() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(i10);
            if (textView != null) {
                if (z10) {
                    textView.setText(i10);
                    if (this.f11391a.f11384f == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int b10 = (!z10 || imageView.getVisibility() != 0) ? 0 : (int) m.b(getContext(), 8);
                if (TabLayout.this.A) {
                    if (b10 != androidx.core.view.i.a(marginLayoutParams)) {
                        androidx.core.view.i.c(marginLayoutParams, b10);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (b10 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b10;
                    androidx.core.view.i.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f11391a;
            if (gVar3 != null) {
                charSequence = gVar3.f11381c;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 21 || i11 > 23) {
                if (!z10) {
                    i10 = charSequence;
                }
                a1.a(this, i10);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f11399i;
            boolean z10 = false;
            if (drawable != null && drawable.isStateful()) {
                z10 = false | this.f11399i.setState(drawableState);
            }
            if (z10) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f11392b, this.f11393c, this.f11396f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    i11 = z10 ? Math.min(i11, view.getTop()) : view.getTop();
                    i10 = z10 ? Math.max(i10, view.getBottom()) : view.getBottom();
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f11392b, this.f11393c, this.f11396f};
            int i10 = 0;
            int i11 = 0;
            boolean z10 = false;
            for (int i12 = 0; i12 < 3; i12++) {
                View view = viewArr[i12];
                if (view != null && view.getVisibility() == 0) {
                    i11 = z10 ? Math.min(i11, view.getLeft()) : view.getLeft();
                    i10 = z10 ? Math.max(i10, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return i10 - i11;
        }

        public g getTab() {
            return this.f11391a;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f11395e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f11395e.h()));
            }
            k0.c D0 = k0.c.D0(accessibilityNodeInfo);
            D0.d0(c.C0359c.a(0, 1, this.f11391a.g(), 1, false, isSelected()));
            if (isSelected()) {
                D0.b0(false);
                D0.S(c.a.f29697g);
            }
            D0.r0(getResources().getString(d7.j.f25317h));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f11356r, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f11392b != null) {
                float f10 = TabLayout.this.f11353o;
                int i12 = this.f11400j;
                ImageView imageView = this.f11393c;
                boolean z10 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f11392b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f11354p;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f11392b.getTextSize();
                int lineCount = this.f11392b.getLineCount();
                int d10 = androidx.core.widget.j.d(this.f11392b);
                int i13 = (f10 > textSize ? 1 : (f10 == textSize ? 0 : -1));
                if (i13 != 0 || (d10 >= 0 && i12 != d10)) {
                    if (TabLayout.this.f11364z == 1 && i13 > 0 && lineCount == 1 && ((layout = this.f11392b.getLayout()) == null || g(layout, 0, f10) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f11392b.setTextSize(0, f10);
                        this.f11392b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f11391a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f11391a.l();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10 && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f11392b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f11393c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f11396f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        void setTab(g gVar) {
            if (gVar != this.f11391a) {
                this.f11391a = gVar;
                t();
            }
        }

        final void t() {
            g gVar = this.f11391a;
            View e10 = gVar != null ? gVar.e() : null;
            if (e10 != null) {
                ViewParent parent = e10.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(e10);
                    }
                    addView(e10);
                }
                this.f11396f = e10;
                TextView textView = this.f11392b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f11393c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f11393c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) e10.findViewById(16908308);
                this.f11397g = textView2;
                if (textView2 != null) {
                    this.f11400j = androidx.core.widget.j.d(textView2);
                }
                this.f11398h = (ImageView) e10.findViewById(16908294);
            } else {
                View view = this.f11396f;
                if (view != null) {
                    removeView(view);
                    this.f11396f = null;
                }
                this.f11397g = null;
                this.f11398h = null;
            }
            if (this.f11396f == null) {
                if (this.f11393c == null) {
                    m();
                }
                if (this.f11392b == null) {
                    n();
                    this.f11400j = androidx.core.widget.j.d(this.f11392b);
                }
                androidx.core.widget.j.q(this.f11392b, TabLayout.this.f11346h);
                ColorStateList colorStateList = TabLayout.this.f11347i;
                if (colorStateList != null) {
                    this.f11392b.setTextColor(colorStateList);
                }
                w(this.f11392b, this.f11393c);
                r();
                f(this.f11393c);
                f(this.f11392b);
            } else {
                TextView textView3 = this.f11397g;
                if (!(textView3 == null && this.f11398h == null)) {
                    w(textView3, this.f11398h);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f11381c)) {
                setContentDescription(gVar.f11381c);
            }
            setSelected(gVar != null && gVar.j());
        }

        final void v() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f11397g;
            if (textView == null && this.f11398h == null) {
                w(this.f11392b, this.f11393c);
            } else {
                w(textView, this.f11398h);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class j implements d {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f11404a;

        public j(ViewPager viewPager) {
            this.f11404a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.f11404a.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.X);
    }

    private void E(int i10) {
        i iVar = (i) this.f11341c.getChildAt(i10);
        this.f11341c.removeViewAt(i10);
        if (iVar != null) {
            iVar.o();
            this.Q.a(iVar);
        }
        requestLayout();
    }

    private void L(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.K;
        if (viewPager2 != null) {
            h hVar = this.N;
            if (hVar != null) {
                viewPager2.N(hVar);
            }
            b bVar = this.O;
            if (bVar != null) {
                this.K.M(bVar);
            }
        }
        c cVar = this.I;
        if (cVar != null) {
            D(cVar);
            this.I = null;
        }
        if (viewPager != null) {
            this.K = viewPager;
            if (this.N == null) {
                this.N = new h(this);
            }
            this.N.a();
            viewPager.c(this.N);
            j jVar = new j(viewPager);
            this.I = jVar;
            c(jVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                H(adapter, z10);
            }
            if (this.O == null) {
                this.O = new b();
            }
            this.O.b(z10);
            viewPager.b(this.O);
            I(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.K = null;
            H(null, false);
        }
        this.P = z11;
    }

    private void M() {
        int size = this.f11339a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11339a.get(i10).t();
        }
    }

    private void N(LinearLayout.LayoutParams layoutParams) {
        if (this.f11364z == 1 && this.f11361w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int getDefaultHeight() {
        int size = this.f11339a.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                g gVar = this.f11339a.get(i10);
                if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        return (!z10 || this.A) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i10 = this.f11357s;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.f11364z;
        if (i11 == 0 || i11 == 2) {
            return this.f11359u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f11341c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(TabItem tabItem) {
        g z10 = z();
        CharSequence charSequence = tabItem.f11336a;
        if (charSequence != null) {
            z10.s(charSequence);
        }
        Drawable drawable = tabItem.f11337b;
        if (drawable != null) {
            z10.q(drawable);
        }
        int i10 = tabItem.f11338c;
        if (i10 != 0) {
            z10.n(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            z10.m(tabItem.getContentDescription());
        }
        e(z10);
    }

    private void i(g gVar) {
        i iVar = gVar.f11386h;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f11341c.addView(iVar, gVar.g(), q());
    }

    private void j(View view) {
        if (view instanceof TabItem) {
            h((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void k(int i10) {
        if (i10 != -1) {
            if (getWindowToken() == null || !d0.X(this) || this.f11341c.d()) {
                I(i10, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int n10 = n(i10, 0.0f);
            if (scrollX != n10) {
                w();
                this.J.setIntValues(scrollX, n10);
                this.J.start();
            }
            this.f11341c.c(i10, this.f11362x);
        }
    }

    private void l(int i10) {
        if (i10 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i10 == 1) {
            this.f11341c.setGravity(1);
            return;
        } else if (i10 != 2) {
            return;
        }
        this.f11341c.setGravity(8388611);
    }

    private void m() {
        int i10 = this.f11364z;
        d0.H0(this.f11341c, (i10 == 0 || i10 == 2) ? Math.max(0, this.f11360v - this.f11342d) : 0, 0, 0, 0);
        int i11 = this.f11364z;
        if (i11 == 0) {
            l(this.f11361w);
        } else if (i11 == 1 || i11 == 2) {
            if (this.f11361w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f11341c.setGravity(1);
        }
        O(true);
    }

    private int n(int i10, float f10) {
        View childAt;
        int i11 = this.f11364z;
        int i12 = 0;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f11341c.getChildAt(i10)) == null) {
            return 0;
        }
        int i13 = i10 + 1;
        View childAt2 = i13 < this.f11341c.getChildCount() ? this.f11341c.getChildAt(i13) : null;
        int width = childAt.getWidth();
        if (childAt2 != null) {
            i12 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i14 = (int) ((width + i12) * 0.5f * f10);
        return d0.E(this) == 0 ? left + i14 : left - i14;
    }

    private void o(g gVar, int i10) {
        gVar.r(i10);
        this.f11339a.add(i10, gVar);
        int size = this.f11339a.size();
        while (true) {
            i10++;
            if (i10 < size) {
                this.f11339a.get(i10).r(i10);
            } else {
                return;
            }
        }
    }

    private static ColorStateList p(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    private LinearLayout.LayoutParams q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        N(layoutParams);
        return layoutParams;
    }

    private i s(g gVar) {
        j0.e<i> eVar = this.Q;
        i b10 = eVar != null ? eVar.b() : null;
        if (b10 == null) {
            b10 = new i(getContext());
        }
        b10.setTab(gVar);
        b10.setFocusable(true);
        b10.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.f11381c)) {
            b10.setContentDescription(gVar.f11380b);
        } else {
            b10.setContentDescription(gVar.f11381c);
        }
        return b10;
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.f11341c.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = this.f11341c.getChildAt(i11);
                boolean z10 = true;
                childAt.setSelected(i11 == i10);
                if (i11 != i10) {
                    z10 = false;
                }
                childAt.setActivated(z10);
                i11++;
            }
        }
    }

    private void t(g gVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).a(gVar);
        }
    }

    private void u(g gVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).b(gVar);
        }
    }

    private void v(g gVar) {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            this.H.get(size).c(gVar);
        }
    }

    private void w() {
        if (this.J == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.J = valueAnimator;
            valueAnimator.setInterpolator(e7.a.f25834b);
            this.J.setDuration(this.f11362x);
            this.J.addUpdateListener(new a());
        }
    }

    void A() {
        int currentItem;
        C();
        androidx.viewpager.widget.a aVar = this.L;
        if (aVar != null) {
            int d10 = aVar.d();
            for (int i10 = 0; i10 < d10; i10++) {
                g(z().s(this.L.f(i10)), false);
            }
            ViewPager viewPager = this.K;
            if (viewPager != null && d10 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                F(x(currentItem));
            }
        }
    }

    protected boolean B(g gVar) {
        return S.a(gVar);
    }

    public void C() {
        for (int childCount = this.f11341c.getChildCount() - 1; childCount >= 0; childCount--) {
            E(childCount);
        }
        Iterator<g> it = this.f11339a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.k();
            B(next);
        }
        this.f11340b = null;
    }

    @Deprecated
    public void D(c cVar) {
        this.H.remove(cVar);
    }

    public void F(g gVar) {
        G(gVar, true);
    }

    public void G(g gVar, boolean z10) {
        g gVar2 = this.f11340b;
        if (gVar2 != gVar) {
            int g10 = gVar != null ? gVar.g() : -1;
            if (z10) {
                if ((gVar2 == null || gVar2.g() == -1) && g10 != -1) {
                    I(g10, 0.0f, true);
                } else {
                    k(g10);
                }
                if (g10 != -1) {
                    setSelectedTabView(g10);
                }
            }
            this.f11340b = gVar;
            if (gVar2 != null) {
                v(gVar2);
            }
            if (gVar != null) {
                u(gVar);
            }
        } else if (gVar2 != null) {
            t(gVar);
            k(gVar.g());
        }
    }

    void H(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.L;
        if (!(aVar2 == null || (dataSetObserver = this.M) == null)) {
            aVar2.s(dataSetObserver);
        }
        this.L = aVar;
        if (z10 && aVar != null) {
            if (this.M == null) {
                this.M = new e();
            }
            aVar.k(this.M);
        }
        A();
    }

    public void I(int i10, float f10, boolean z10) {
        J(i10, f10, z10, true);
    }

    public void J(int i10, float f10, boolean z10, boolean z11) {
        int round = Math.round(i10 + f10);
        if (round >= 0 && round < this.f11341c.getChildCount()) {
            if (z11) {
                this.f11341c.f(i10, f10);
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.J.cancel();
            }
            scrollTo(i10 < 0 ? 0 : n(i10, f10), 0);
            if (z10) {
                setSelectedTabView(round);
            }
        }
    }

    public void K(ViewPager viewPager, boolean z10) {
        L(viewPager, z10, false);
    }

    void O(boolean z10) {
        for (int i10 = 0; i10 < this.f11341c.getChildCount(); i10++) {
            View childAt = this.f11341c.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            N((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        j(view);
    }

    @Deprecated
    public void c(c cVar) {
        if (!this.H.contains(cVar)) {
            this.H.add(cVar);
        }
    }

    public void d(d dVar) {
        c(dVar);
    }

    public void e(g gVar) {
        g(gVar, this.f11339a.isEmpty());
    }

    public void f(g gVar, int i10, boolean z10) {
        if (gVar.f11385g == this) {
            o(gVar, i10);
            i(gVar);
            if (z10) {
                gVar.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void g(g gVar, boolean z10) {
        f(gVar, this.f11339a.size(), z10);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f11340b;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f11339a.size();
    }

    public int getTabGravity() {
        return this.f11361w;
    }

    public ColorStateList getTabIconTint() {
        return this.f11348j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.D;
    }

    public int getTabIndicatorGravity() {
        return this.f11363y;
    }

    int getTabMaxWidth() {
        return this.f11356r;
    }

    public int getTabMode() {
        return this.f11364z;
    }

    public ColorStateList getTabRippleColor() {
        return this.f11349k;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f11350l;
    }

    public ColorStateList getTabTextColors() {
        return this.f11347i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w7.h.e(this);
        if (this.K == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                L((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.P) {
            setupWithViewPager(null);
            this.P = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f11341c.getChildCount(); i10++) {
            View childAt = this.f11341c.getChildAt(i10);
            if (childAt instanceof i) {
                ((i) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        k0.c.D0(accessibilityNodeInfo).c0(c.b.a(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r0 != 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L26;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        int round = Math.round(m.b(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i11);
        boolean z10 = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i11) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != 0) {
            int i12 = this.f11358t;
            if (i12 <= 0) {
                i12 = (int) (size - m.b(getContext(), 56));
            }
            this.f11356r = i12;
        }
        super.onMeasure(i10, i11);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i13 = this.f11364z;
            if (i13 != 0) {
                if (i13 != 1) {
                }
                if (z10) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
        }
    }

    protected g r() {
        g b10 = S.b();
        return b10 == null ? new g() : b10;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        w7.h.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.A != z10) {
            this.A = z10;
            for (int i10 = 0; i10 < this.f11341c.getChildCount(); i10++) {
                View childAt = this.f11341c.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).v();
                }
            }
            m();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        w();
        this.J.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f11350l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f11350l = drawable;
            int i10 = this.C;
            if (i10 == -1) {
                i10 = drawable.getIntrinsicHeight();
            }
            this.f11341c.g(i10);
        }
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f11351m = i10;
        O(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.f11363y != i10) {
            this.f11363y = i10;
            d0.k0(this.f11341c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.C = i10;
        this.f11341c.g(i10);
    }

    public void setTabGravity(int i10) {
        if (this.f11361w != i10) {
            this.f11361w = i10;
            m();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f11348j != colorStateList) {
            this.f11348j = colorStateList;
            M();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(e.a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.D = i10;
        if (i10 == 0) {
            this.F = new com.google.android.material.tabs.b();
        } else if (i10 == 1) {
            this.F = new com.google.android.material.tabs.a();
        } else {
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.B = z10;
        this.f11341c.e();
        d0.k0(this.f11341c);
    }

    public void setTabMode(int i10) {
        if (i10 != this.f11364z) {
            this.f11364z = i10;
            m();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f11349k != colorStateList) {
            this.f11349k = colorStateList;
            for (int i10 = 0; i10 < this.f11341c.getChildCount(); i10++) {
                View childAt = this.f11341c.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(e.a.a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f11347i != colorStateList) {
            this.f11347i = colorStateList;
            M();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        H(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.E != z10) {
            this.E = z10;
            for (int i10 = 0; i10 < this.f11341c.getChildCount(); i10++) {
                View childAt = this.f11341c.getChildAt(i10);
                if (childAt instanceof i) {
                    ((i) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        K(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public g x(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f11339a.get(i10);
    }

    public boolean y() {
        return this.B;
    }

    public g z() {
        g r10 = r();
        r10.f11385g = this;
        r10.f11386h = s(r10);
        if (r10.f11387i != -1) {
            r10.f11386h.setId(r10.f11387i);
        }
        return r10;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = R;
        this.f11339a = new ArrayList<>();
        this.f11350l = new GradientDrawable();
        this.f11351m = 0;
        this.f11356r = Integer.MAX_VALUE;
        this.C = -1;
        this.H = new ArrayList<>();
        this.Q = new j0.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f11341c = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = l.N4;
        int i12 = l.f25456l5;
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, iArr, i10, i11, i12);
        if (getBackground() instanceof ColorDrawable) {
            w7.g gVar = new w7.g();
            gVar.Z(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            gVar.O(context2);
            gVar.Y(d0.y(this));
            d0.x0(this, gVar);
        }
        setSelectedTabIndicator(t7.c.d(context2, h10, l.T4));
        setSelectedTabIndicatorColor(h10.getColor(l.W4, 0));
        fVar.g(h10.getDimensionPixelSize(l.Z4, -1));
        setSelectedTabIndicatorGravity(h10.getInt(l.Y4, 0));
        setTabIndicatorAnimationMode(h10.getInt(l.V4, 0));
        setTabIndicatorFullWidth(h10.getBoolean(l.X4, true));
        int dimensionPixelSize = h10.getDimensionPixelSize(l.f25400e5, 0);
        this.f11345g = dimensionPixelSize;
        this.f11344f = dimensionPixelSize;
        this.f11343e = dimensionPixelSize;
        this.f11342d = dimensionPixelSize;
        this.f11342d = h10.getDimensionPixelSize(l.f25424h5, dimensionPixelSize);
        this.f11343e = h10.getDimensionPixelSize(l.f25432i5, this.f11343e);
        this.f11344f = h10.getDimensionPixelSize(l.f25416g5, this.f11344f);
        this.f11345g = h10.getDimensionPixelSize(l.f25408f5, this.f11345g);
        int resourceId = h10.getResourceId(i12, k.f25339d);
        this.f11346h = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, d.j.V2);
        try {
            this.f11353o = obtainStyledAttributes.getDimensionPixelSize(d.j.W2, 0);
            this.f11347i = t7.c.a(context2, obtainStyledAttributes, d.j.Z2);
            obtainStyledAttributes.recycle();
            int i13 = l.f25464m5;
            if (h10.hasValue(i13)) {
                this.f11347i = t7.c.a(context2, h10, i13);
            }
            int i14 = l.f25448k5;
            if (h10.hasValue(i14)) {
                this.f11347i = p(this.f11347i.getDefaultColor(), h10.getColor(i14, 0));
            }
            this.f11348j = t7.c.a(context2, h10, l.R4);
            this.f11352n = m.e(h10.getInt(l.S4, -1), null);
            this.f11349k = t7.c.a(context2, h10, l.f25440j5);
            this.f11362x = h10.getInt(l.U4, 300);
            this.f11357s = h10.getDimensionPixelSize(l.f25384c5, -1);
            this.f11358t = h10.getDimensionPixelSize(l.f25376b5, -1);
            this.f11355q = h10.getResourceId(l.O4, 0);
            this.f11360v = h10.getDimensionPixelSize(l.P4, 0);
            this.f11364z = h10.getInt(l.f25392d5, 1);
            this.f11361w = h10.getInt(l.Q4, 0);
            this.A = h10.getBoolean(l.f25368a5, false);
            this.E = h10.getBoolean(l.f25472n5, false);
            h10.recycle();
            Resources resources = getResources();
            this.f11354p = resources.getDimensionPixelSize(d7.d.f25210o);
            this.f11359u = resources.getDimensionPixelSize(d7.d.f25208n);
            m();
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.G;
        if (cVar2 != null) {
            D(cVar2);
        }
        this.G = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(e.a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
