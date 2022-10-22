package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import d7.l;
/* compiled from: ForegroundLinearLayout.java */
/* loaded from: classes.dex */
public class d extends LinearLayoutCompat {

    /* renamed from: p  reason: collision with root package name */
    private Drawable f11057p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f11058q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f11059r;

    /* renamed from: s  reason: collision with root package name */
    private int f11060s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f11061t;

    /* renamed from: u  reason: collision with root package name */
    boolean f11062u;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f11057p;
        if (drawable != null) {
            if (this.f11062u) {
                this.f11062u = false;
                Rect rect = this.f11058q;
                Rect rect2 = this.f11059r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f11061t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f11060s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f11057p;
        if (drawable != null) {
            drawable.setHotspot(f10, f11);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f11057p;
        if (drawable != null && drawable.isStateful()) {
            this.f11057p.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f11057p;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f11060s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f11057p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f11062u = z10 | this.f11062u;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f11062u = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f11057p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f11057p);
            }
            this.f11057p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f11060s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i10) {
        if (this.f11060s != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f11060s = i10;
            if (i10 == 119 && this.f11057p != null) {
                this.f11057p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f11057p;
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11058q = new Rect();
        this.f11059r = new Rect();
        this.f11060s = 119;
        this.f11061t = true;
        this.f11062u = false;
        TypedArray h10 = k.h(context, attributeSet, l.O1, i10, 0, new int[0]);
        this.f11060s = h10.getInt(l.Q1, this.f11060s);
        Drawable drawable = h10.getDrawable(l.P1);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f11061t = h10.getBoolean(l.R1, true);
        h10.recycle();
    }
}
