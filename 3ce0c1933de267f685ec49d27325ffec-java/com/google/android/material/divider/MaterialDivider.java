package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import androidx.core.view.d0;
import d7.d;
import d7.k;
import d7.l;
import t7.c;
import w7.g;
import x7.a;
/* loaded from: classes.dex */
public class MaterialDivider extends View {

    /* renamed from: f  reason: collision with root package name */
    private static final int f10863f = k.f25361z;

    /* renamed from: a  reason: collision with root package name */
    private final g f10864a;

    /* renamed from: b  reason: collision with root package name */
    private int f10865b;

    /* renamed from: c  reason: collision with root package name */
    private int f10866c;

    /* renamed from: d  reason: collision with root package name */
    private int f10867d;

    /* renamed from: e  reason: collision with root package name */
    private int f10868e;

    public MaterialDivider(Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.f10866c;
    }

    public int getDividerInsetEnd() {
        return this.f10868e;
    }

    public int getDividerInsetStart() {
        return this.f10867d;
    }

    public int getDividerThickness() {
        return this.f10865b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        int i11;
        super.onDraw(canvas);
        boolean z10 = true;
        if (d0.E(this) != 1) {
            z10 = false;
        }
        int i12 = z10 ? this.f10868e : this.f10867d;
        if (z10) {
            i11 = getWidth();
            i10 = this.f10867d;
        } else {
            i11 = getWidth();
            i10 = this.f10868e;
        }
        this.f10864a.setBounds(i12, 0, i11 - i10, getBottom() - getTop());
        this.f10864a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i12 = this.f10865b;
            if (i12 > 0 && measuredHeight != i12) {
                measuredHeight = i12;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i10) {
        if (this.f10866c != i10) {
            this.f10866c = i10;
            this.f10864a.Z(ColorStateList.valueOf(i10));
            invalidate();
        }
    }

    public void setDividerColorResource(int i10) {
        setDividerColor(b.c(getContext(), i10));
    }

    public void setDividerInsetEnd(int i10) {
        this.f10868e = i10;
    }

    public void setDividerInsetEndResource(int i10) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerInsetStart(int i10) {
        this.f10867d = i10;
    }

    public void setDividerInsetStartResource(int i10) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i10));
    }

    public void setDividerThickness(int i10) {
        if (this.f10865b != i10) {
            this.f10865b = i10;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i10) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i10));
    }

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.G);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialDivider(Context context, AttributeSet attributeSet, int i10) {
        super(a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f10863f;
        Context context2 = getContext();
        this.f10864a = new g();
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.f25398e3, i10, i11, new int[0]);
        this.f10865b = h10.getDimensionPixelSize(l.f25430i3, getResources().getDimensionPixelSize(d.A));
        this.f10867d = h10.getDimensionPixelOffset(l.f25422h3, 0);
        this.f10868e = h10.getDimensionPixelOffset(l.f25414g3, 0);
        setDividerColor(c.a(context2, h10, l.f25406f3).getDefaultColor());
        h10.recycle();
    }
}
