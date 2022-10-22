package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.d0;
import d.f;
import d.j;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f792a;

    /* renamed from: b  reason: collision with root package name */
    private View f793b;

    /* renamed from: c  reason: collision with root package name */
    private View f794c;

    /* renamed from: d  reason: collision with root package name */
    private View f795d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f796e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f797f;

    /* renamed from: g  reason: collision with root package name */
    Drawable f798g;

    /* renamed from: h  reason: collision with root package name */
    boolean f799h;

    /* renamed from: i  reason: collision with root package name */
    boolean f800i;

    /* renamed from: j  reason: collision with root package name */
    private int f801j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d0.x0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f24854a);
        this.f796e = obtainStyledAttributes.getDrawable(j.f24859b);
        this.f797f = obtainStyledAttributes.getDrawable(j.f24869d);
        this.f801j = obtainStyledAttributes.getDimensionPixelSize(j.f24899j, -1);
        boolean z10 = true;
        if (getId() == f.H) {
            this.f799h = true;
            this.f798g = obtainStyledAttributes.getDrawable(j.f24864c);
        }
        obtainStyledAttributes.recycle();
        z10 = false;
        if (!this.f799h ? !(this.f796e == null && this.f797f == null) : this.f798g != null) {
        }
        setWillNotDraw(z10);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f796e;
        if (drawable != null && drawable.isStateful()) {
            this.f796e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f797f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f797f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f798g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f798g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f793b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f796e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f797f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f798g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f794c = findViewById(f.f24789a);
        this.f795d = findViewById(f.f24794f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f792a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f793b;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i14 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i10, (measuredHeight - view.getMeasuredHeight()) - i14, i12, measuredHeight - i14);
        }
        if (this.f799h) {
            Drawable drawable2 = this.f798g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z11 = z12;
        } else {
            if (this.f796e != null) {
                if (this.f794c.getVisibility() == 0) {
                    this.f796e.setBounds(this.f794c.getLeft(), this.f794c.getTop(), this.f794c.getRight(), this.f794c.getBottom());
                } else {
                    View view2 = this.f795d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f796e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f796e.setBounds(this.f795d.getLeft(), this.f795d.getTop(), this.f795d.getRight(), this.f795d.getBottom());
                    }
                }
                z12 = true;
            }
            this.f800i = z13;
            if (z13 && (drawable = this.f797f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            z11 = z12;
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        if (this.f794c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i13 = this.f801j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i13, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f794c != null) {
            int mode = View.MeasureSpec.getMode(i11);
            View view = this.f793b;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.f794c)) {
                    i12 = a(this.f794c);
                } else {
                    i12 = !b(this.f795d) ? a(this.f795d) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i12 + a(this.f793b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f796e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f796e);
        }
        this.f796e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f794c;
            if (view != null) {
                this.f796e.setBounds(view.getLeft(), this.f794c.getTop(), this.f794c.getRight(), this.f794c.getBottom());
            }
        }
        boolean z10 = true;
        z10 = false;
        if (!this.f799h ? !(this.f796e == null && this.f797f == null) : this.f798g != null) {
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f798g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f798g);
        }
        this.f798g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f799h && (drawable2 = this.f798g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        z10 = true;
        if (!this.f799h ? this.f796e == null && this.f797f == null : this.f798g == null) {
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f797f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f797f);
        }
        this.f797f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f800i && (drawable2 = this.f797f) != null) {
                drawable2.setBounds(this.f793b.getLeft(), this.f793b.getTop(), this.f793b.getRight(), this.f793b.getBottom());
            }
        }
        boolean z10 = true;
        z10 = false;
        if (!this.f799h ? !(this.f796e == null && this.f797f == null) : this.f798g != null) {
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(q0 q0Var) {
        View view = this.f793b;
        if (view != null) {
            removeView(view);
        }
        this.f793b = q0Var;
        if (q0Var != null) {
            addView(q0Var);
            ViewGroup.LayoutParams layoutParams = q0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            q0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f792a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f796e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f797f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f798g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f796e && !this.f799h) || (drawable == this.f797f && this.f800i) || ((drawable == this.f798g && this.f799h) || super.verifyDrawable(drawable));
    }
}
