package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.a1;
import androidx.core.view.d0;
import androidx.core.view.z;
import com.google.android.material.badge.BadgeDrawable;
import d7.f;
import d7.j;
import k0.c;
/* compiled from: NavigationBarItemView.java */
/* loaded from: classes.dex */
public abstract class a extends FrameLayout implements k.a {
    private static final int[] C = {16842912};
    private static final d D = new d(null);
    private static final d E = new e(null);
    private BadgeDrawable B;

    /* renamed from: c  reason: collision with root package name */
    private int f11123c;

    /* renamed from: d  reason: collision with root package name */
    private float f11124d;

    /* renamed from: e  reason: collision with root package name */
    private float f11125e;

    /* renamed from: f  reason: collision with root package name */
    private float f11126f;

    /* renamed from: g  reason: collision with root package name */
    private int f11127g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11128h;

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f11131k;

    /* renamed from: l  reason: collision with root package name */
    private final ViewGroup f11132l;

    /* renamed from: m  reason: collision with root package name */
    private final TextView f11133m;

    /* renamed from: n  reason: collision with root package name */
    private final TextView f11134n;

    /* renamed from: p  reason: collision with root package name */
    private g f11136p;

    /* renamed from: q  reason: collision with root package name */
    private ColorStateList f11137q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f11138r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f11139s;

    /* renamed from: t  reason: collision with root package name */
    private ValueAnimator f11140t;

    /* renamed from: a  reason: collision with root package name */
    private boolean f11121a = false;

    /* renamed from: o  reason: collision with root package name */
    private int f11135o = -1;

    /* renamed from: u  reason: collision with root package name */
    private d f11141u = D;

    /* renamed from: v  reason: collision with root package name */
    private float f11142v = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11143w = false;

    /* renamed from: x  reason: collision with root package name */
    private int f11144x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f11145y = 0;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11146z = false;
    private int A = 0;

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f11129i = (FrameLayout) findViewById(f.V);

    /* renamed from: j  reason: collision with root package name */
    private final View f11130j = findViewById(f.U);

    /* renamed from: b  reason: collision with root package name */
    private int f11122b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());

    /* compiled from: NavigationBarItemView.java */
    /* renamed from: com.google.android.material.navigation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnLayoutChangeListenerC0126a implements View.OnLayoutChangeListener {
        View$OnLayoutChangeListenerC0126a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (a.this.f11131k.getVisibility() == 0) {
                a aVar = a.this;
                aVar.t(aVar.f11131k);
            }
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f11148a;

        b(int i10) {
            this.f11148a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.u(this.f11148a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f11150a;

        c(float f10) {
            this.f11150a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f11150a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes.dex */
    public static class d {
        private d() {
        }

        protected float a(float f10, float f11) {
            int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            return e7.a.b(0.0f, 1.0f, i10 == 0 ? 0.8f : 0.0f, i10 == 0 ? 1.0f : 0.2f, f10);
        }

        protected float b(float f10, float f11) {
            return e7.a.a(0.4f, 1.0f, f10);
        }

        protected float c(float f10, float f11) {
            return 1.0f;
        }

        public void d(float f10, float f11, View view) {
            view.setScaleX(b(f10, f11));
            view.setScaleY(c(f10, f11));
            view.setAlpha(a(f10, f11));
        }

        /* synthetic */ d(View$OnLayoutChangeListenerC0126a aVar) {
            this();
        }
    }

    /* compiled from: NavigationBarItemView.java */
    /* loaded from: classes.dex */
    private static class e extends d {
        private e() {
            super(null);
        }

        @Override // com.google.android.material.navigation.a.d
        protected float c(float f10, float f11) {
            return b(f10, f11);
        }

        /* synthetic */ e(View$OnLayoutChangeListenerC0126a aVar) {
            this();
        }
    }

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(f.W);
        this.f11131k = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(f.X);
        this.f11132l = viewGroup;
        TextView textView = (TextView) findViewById(f.Z);
        this.f11133m = textView;
        TextView textView2 = (TextView) findViewById(f.Y);
        this.f11134n = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f11123c = viewGroup.getPaddingBottom();
        d0.E0(textView, 2);
        d0.E0(textView2, 2);
        setFocusable(true);
        g(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC0126a());
        }
    }

    private void g(float f10, float f11) {
        this.f11124d = f10 - f11;
        this.f11125e = (f11 * 1.0f) / f10;
        this.f11126f = (f10 * 1.0f) / f11;
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f11129i;
        return frameLayout != null ? frameLayout : this.f11131k;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < indexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof a) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable = this.B;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.f11131k.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.B;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.B.j();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f11131k.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private FrameLayout i(View view) {
        ImageView imageView = this.f11131k;
        if (view != imageView || !com.google.android.material.badge.a.f10444a) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private boolean j() {
        return this.B != null;
    }

    private boolean k() {
        return this.f11146z && this.f11127g == 2;
    }

    private void l(float f10) {
        if (!this.f11143w || !this.f11121a || !d0.W(this)) {
            o(f10, f10);
            return;
        }
        ValueAnimator valueAnimator = this.f11140t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f11140t = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f11142v, f10);
        this.f11140t = ofFloat;
        ofFloat.addUpdateListener(new c(f10));
        this.f11140t.setInterpolator(q7.a.e(getContext(), d7.b.L, e7.a.f25834b));
        this.f11140t.setDuration(q7.a.d(getContext(), d7.b.K, getResources().getInteger(d7.g.f25281b)));
        this.f11140t.start();
    }

    private void m() {
        g gVar = this.f11136p;
        if (gVar != null) {
            setChecked(gVar.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(float f10, float f11) {
        View view = this.f11130j;
        if (view != null) {
            this.f11141u.d(f10, f11, view);
        }
        this.f11142v = f10;
    }

    private static void p(View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    private static void q(View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    private void r(View view) {
        if (j() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.B, view, i(view));
        }
    }

    private void s(View view) {
        if (j()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.d(this.B, view);
            }
            this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view) {
        if (j()) {
            com.google.android.material.badge.a.e(this.B, view, i(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i10) {
        if (this.f11130j != null) {
            int min = Math.min(this.f11144x, i10 - (this.A * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11130j.getLayoutParams();
            layoutParams.height = k() ? min : this.f11145y;
            layoutParams.width = min;
            this.f11130j.setLayoutParams(layoutParams);
        }
    }

    private void v() {
        if (k()) {
            this.f11141u = E;
        } else {
            this.f11141u = D;
        }
    }

    private static void w(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i10) {
        CharSequence charSequence;
        this.f11136p = gVar;
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setIcon(gVar.getIcon());
        setTitle(gVar.getTitle());
        setId(gVar.getItemId());
        if (!TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(gVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(gVar.getTooltipText())) {
            charSequence = gVar.getTooltipText();
        } else {
            charSequence = gVar.getTitle();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21 || i11 > 23) {
            a1.a(this, charSequence);
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        this.f11121a = true;
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f11130j;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public BadgeDrawable getBadge() {
        return this.B;
    }

    protected int getItemBackgroundResId() {
        return d7.e.f25240g;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f11136p;
    }

    protected int getItemDefaultMarginResId() {
        return d7.d.f25213p0;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f11135o;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11132l.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f11132l.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11132l.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f11132l.getMeasuredWidth() + layoutParams.rightMargin);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        n();
        this.f11136p = null;
        this.f11142v = 0.0f;
        this.f11121a = false;
    }

    void n() {
        s(this.f11131k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        g gVar = this.f11136p;
        if (gVar != null && gVar.isCheckable() && this.f11136p.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, C);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.B;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f11136p.getTitle();
            if (!TextUtils.isEmpty(this.f11136p.getContentDescription())) {
                title = this.f11136p.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.B.h()));
        }
        k0.c D0 = k0.c.D0(accessibilityNodeInfo);
        D0.d0(c.C0359c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            D0.b0(false);
            D0.S(c.a.f29697g);
        }
        D0.r0(getResources().getString(j.f25317h));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new b(i10));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f11130j;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        this.f11143w = z10;
        View view = this.f11130j;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.f11145y = i10;
        u(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i10) {
        this.A = i10;
        u(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.f11146z = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.f11144x = i10;
        u(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable) {
        this.B = badgeDrawable;
        ImageView imageView = this.f11131k;
        if (imageView != null) {
            r(imageView);
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        TextView textView = this.f11134n;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f11134n;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f11133m;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f11133m;
        textView4.setPivotY(textView4.getBaseline());
        l(z10 ? 1.0f : 0.0f);
        int i10 = this.f11127g;
        if (i10 != -1) {
            if (i10 == 0) {
                if (z10) {
                    q(getIconOrContainer(), this.f11122b, 49);
                    w(this.f11132l, this.f11123c);
                    this.f11134n.setVisibility(0);
                } else {
                    q(getIconOrContainer(), this.f11122b, 17);
                    w(this.f11132l, 0);
                    this.f11134n.setVisibility(4);
                }
                this.f11133m.setVisibility(4);
            } else if (i10 == 1) {
                w(this.f11132l, this.f11123c);
                if (z10) {
                    q(getIconOrContainer(), (int) (this.f11122b + this.f11124d), 49);
                    p(this.f11134n, 1.0f, 1.0f, 0);
                    TextView textView5 = this.f11133m;
                    float f10 = this.f11125e;
                    p(textView5, f10, f10, 4);
                } else {
                    q(getIconOrContainer(), this.f11122b, 49);
                    TextView textView6 = this.f11134n;
                    float f11 = this.f11126f;
                    p(textView6, f11, f11, 4);
                    p(this.f11133m, 1.0f, 1.0f, 0);
                }
            } else if (i10 == 2) {
                q(getIconOrContainer(), this.f11122b, 17);
                this.f11134n.setVisibility(8);
                this.f11133m.setVisibility(8);
            }
        } else if (this.f11128h) {
            if (z10) {
                q(getIconOrContainer(), this.f11122b, 49);
                w(this.f11132l, this.f11123c);
                this.f11134n.setVisibility(0);
            } else {
                q(getIconOrContainer(), this.f11122b, 17);
                w(this.f11132l, 0);
                this.f11134n.setVisibility(4);
            }
            this.f11133m.setVisibility(4);
        } else {
            w(this.f11132l, this.f11123c);
            if (z10) {
                q(getIconOrContainer(), (int) (this.f11122b + this.f11124d), 49);
                p(this.f11134n, 1.0f, 1.0f, 0);
                TextView textView7 = this.f11133m;
                float f12 = this.f11125e;
                p(textView7, f12, f12, 4);
            } else {
                q(getIconOrContainer(), this.f11122b, 49);
                TextView textView8 = this.f11134n;
                float f13 = this.f11126f;
                p(textView8, f13, f13, 4);
                p(this.f11133m, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f11133m.setEnabled(z10);
        this.f11134n.setEnabled(z10);
        this.f11131k.setEnabled(z10);
        if (z10) {
            d0.I0(this, z.b(getContext(), 1002));
        } else {
            d0.I0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.f11138r) {
            this.f11138r = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                this.f11139s = drawable;
                ColorStateList colorStateList = this.f11137q;
                if (colorStateList != null) {
                    androidx.core.graphics.drawable.a.o(drawable, colorStateList);
                }
            }
            this.f11131k.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f11131k.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f11131k.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f11137q = colorStateList;
        if (this.f11136p != null && (drawable = this.f11139s) != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            this.f11139s.invalidateSelf();
        }
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : androidx.core.content.b.e(getContext(), i10));
    }

    public void setItemPaddingBottom(int i10) {
        if (this.f11123c != i10) {
            this.f11123c = i10;
            m();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.f11122b != i10) {
            this.f11122b = i10;
            m();
        }
    }

    public void setItemPosition(int i10) {
        this.f11135o = i10;
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f11127g != i10) {
            this.f11127g = i10;
            v();
            u(getWidth());
            m();
        }
    }

    public void setShifting(boolean z10) {
        if (this.f11128h != z10) {
            this.f11128h = z10;
            m();
        }
    }

    public void setTextAppearanceActive(int i10) {
        androidx.core.widget.j.q(this.f11134n, i10);
        g(this.f11133m.getTextSize(), this.f11134n.getTextSize());
    }

    public void setTextAppearanceInactive(int i10) {
        androidx.core.widget.j.q(this.f11133m, i10);
        g(this.f11133m.getTextSize(), this.f11134n.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f11133m.setTextColor(colorStateList);
            this.f11134n.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f11133m.setText(charSequence);
        this.f11134n.setText(charSequence);
        g gVar = this.f11136p;
        if (gVar == null || TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        g gVar2 = this.f11136p;
        if (gVar2 != null && !TextUtils.isEmpty(gVar2.getTooltipText())) {
            charSequence = this.f11136p.getTooltipText();
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21 || i10 > 23) {
            a1.a(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        d0.x0(this, drawable);
    }
}
