package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.core.view.d0;
import d.f;
import d.g;
import d.j;
import i.b;
/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f802i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f803j;

    /* renamed from: k  reason: collision with root package name */
    private View f804k;

    /* renamed from: l  reason: collision with root package name */
    private View f805l;

    /* renamed from: m  reason: collision with root package name */
    private View f806m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f807n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f808o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f809p;

    /* renamed from: q  reason: collision with root package name */
    private int f810q;

    /* renamed from: r  reason: collision with root package name */
    private int f811r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f812s;

    /* renamed from: t  reason: collision with root package name */
    private int f813t;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f814a;

        a(ActionBarContextView actionBarContextView, b bVar) {
            this.f814a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f814a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        if (this.f807n == null) {
            LayoutInflater.from(getContext()).inflate(g.f24815a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f807n = linearLayout;
            this.f808o = (TextView) linearLayout.findViewById(f.f24793e);
            this.f809p = (TextView) this.f807n.findViewById(f.f24792d);
            if (this.f810q != 0) {
                this.f808o.setTextAppearance(getContext(), this.f810q);
            }
            if (this.f811r != 0) {
                this.f809p.setTextAppearance(getContext(), this.f811r);
            }
        }
        this.f808o.setText(this.f802i);
        this.f809p.setText(this.f803j);
        boolean z10 = !TextUtils.isEmpty(this.f802i);
        boolean z11 = !TextUtils.isEmpty(this.f803j);
        int i10 = 0;
        this.f809p.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f807n;
        if (!z10 && !z11) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        if (this.f807n.getParent() == null) {
            addView(this.f807n);
        }
    }

    public void g() {
        if (this.f804k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f803j;
    }

    public CharSequence getTitle() {
        return this.f802i;
    }

    public void h(b bVar) {
        View view = this.f804k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f813t, (ViewGroup) this, false);
            this.f804k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f804k);
        }
        View findViewById = this.f804k.findViewById(f.f24797i);
        this.f805l = findViewById;
        findViewById.setOnClickListener(new a(this, bVar));
        e eVar = (e) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f1063d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1063d = actionMenuPresenter2;
        actionMenuPresenter2.L(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f1063d, this.f1061b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1063d.q(this);
        this.f1062c = actionMenuView;
        d0.x0(actionMenuView, null);
        addView(this.f1062c, layoutParams);
    }

    public boolean j() {
        return this.f812s;
    }

    public void k() {
        removeAllViews();
        this.f806m = null;
        this.f1062c = null;
        this.f1063d = null;
        View view = this.f805l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f1063d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.M();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1063d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.D();
            this.f1063d.E();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean b10 = e1.b(this);
        int paddingRight = b10 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f804k;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f804k.getLayoutParams();
            int i14 = b10 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = b10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d10 = androidx.appcompat.widget.a.d(paddingRight, i14, b10);
            paddingRight = androidx.appcompat.widget.a.d(d10 + e(this.f804k, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingRight;
        LinearLayout linearLayout = this.f807n;
        if (!(linearLayout == null || this.f806m != null || linearLayout.getVisibility() == 8)) {
            i16 += e(this.f807n, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f806m;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        int paddingLeft = b10 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1062c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b10);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = 1073741824;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i11) != 0) {
            int size = View.MeasureSpec.getSize(i10);
            int i13 = this.f1064e;
            if (i13 <= 0) {
                i13 = View.MeasureSpec.getSize(i11);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i14 = i13 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Integer.MIN_VALUE);
            View view = this.f804k;
            if (view != null) {
                int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f804k.getLayoutParams();
                paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1062c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.f1062c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f807n;
            if (linearLayout != null && this.f806m == null) {
                if (this.f812s) {
                    this.f807n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f807n.getMeasuredWidth();
                    boolean z10 = measuredWidth <= paddingLeft;
                    if (z10) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f807n.setVisibility(z10 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f806m;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i15 = layoutParams.width;
                int i16 = i15 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i15 >= 0) {
                    paddingLeft = Math.min(i15, paddingLeft);
                }
                int i17 = layoutParams.height;
                if (i17 == -2) {
                    i12 = Integer.MIN_VALUE;
                }
                if (i17 >= 0) {
                    i14 = Math.min(i17, i14);
                }
                this.f806m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i16), View.MeasureSpec.makeMeasureSpec(i14, i12));
            }
            if (this.f1064e <= 0) {
                int childCount = getChildCount();
                int i18 = 0;
                for (int i19 = 0; i19 < childCount; i19++) {
                    int measuredHeight = getChildAt(i19).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i18) {
                        i18 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i18);
                return;
            }
            setMeasuredDimension(size, i13);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f1064e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f806m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f806m = view;
        if (!(view == null || (linearLayout = this.f807n) == null)) {
            removeView(linearLayout);
            this.f807n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f803j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f802i = charSequence;
        i();
        d0.w0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f812s) {
            requestLayout();
        }
        this.f812s = z10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.f24722j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        x0 v10 = x0.v(context, attributeSet, j.f24969x, i10, 0);
        d0.x0(this, v10.g(j.f24974y));
        this.f810q = v10.n(j.C, 0);
        this.f811r = v10.n(j.B, 0);
        this.f1064e = v10.m(j.A, 0);
        this.f813t = v10.n(j.f24979z, g.f24818d);
        v10.w();
    }
}
