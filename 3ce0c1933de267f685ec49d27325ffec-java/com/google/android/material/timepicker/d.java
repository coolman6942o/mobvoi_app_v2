package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.view.d0;
import d7.f;
import d7.h;
import d7.l;
import w7.g;
import w7.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RadialViewGroup.java */
/* loaded from: classes.dex */
public class d extends ConstraintLayout {

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f11635u;

    /* renamed from: v  reason: collision with root package name */
    private int f11636v;

    /* renamed from: w  reason: collision with root package name */
    private g f11637w;

    /* compiled from: RadialViewGroup.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.I();
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Drawable E() {
        g gVar = new g();
        this.f11637w = gVar;
        gVar.X(new i(0.5f));
        this.f11637w.Z(ColorStateList.valueOf(-1));
        return this.f11637w;
    }

    private static boolean H(View view) {
        return "skip".equals(view.getTag());
    }

    private void J() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f11635u);
            handler.post(this.f11635u);
        }
    }

    public int F() {
        return this.f11636v;
    }

    public void G(int i10) {
        this.f11636v = i10;
        I();
    }

    protected void I() {
        int childCount = getChildCount();
        int i10 = 1;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (H(getChildAt(i11))) {
                i10++;
            }
        }
        c cVar = new c();
        cVar.g(this);
        float f10 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            int i13 = f.f25244b;
            if (id2 != i13 && !H(childAt)) {
                cVar.i(childAt.getId(), i13, this.f11636v, f10);
                f10 += 360.0f / (childCount - i10);
            }
        }
        cVar.c(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(d0.m());
        }
        J();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        I();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        J();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f11637w.Z(ColorStateList.valueOf(i10));
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(h.f25294l, this);
        d0.x0(this, E());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.Z3, i10, 0);
        this.f11636v = obtainStyledAttributes.getDimensionPixelSize(l.f25367a4, 0);
        this.f11635u = new a();
        obtainStyledAttributes.recycle();
    }
}
