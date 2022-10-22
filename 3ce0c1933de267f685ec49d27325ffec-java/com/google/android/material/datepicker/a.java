package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.view.d0;
import d7.l;
import j0.h;
import t7.c;
import w7.g;
import w7.k;
/* compiled from: CalendarItemStyle.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f10757a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f10758b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f10759c;

    /* renamed from: d  reason: collision with root package name */
    private final ColorStateList f10760d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10761e;

    /* renamed from: f  reason: collision with root package name */
    private final k f10762f;

    private a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, k kVar, Rect rect) {
        h.d(rect.left);
        h.d(rect.top);
        h.d(rect.right);
        h.d(rect.bottom);
        this.f10757a = rect;
        this.f10758b = colorStateList2;
        this.f10759c = colorStateList;
        this.f10760d = colorStateList3;
        this.f10761e = i10;
        this.f10762f = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context, int i10) {
        h.b(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, l.G2);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(l.H2, 0), obtainStyledAttributes.getDimensionPixelOffset(l.J2, 0), obtainStyledAttributes.getDimensionPixelOffset(l.I2, 0), obtainStyledAttributes.getDimensionPixelOffset(l.K2, 0));
        ColorStateList a10 = c.a(context, obtainStyledAttributes, l.L2);
        ColorStateList a11 = c.a(context, obtainStyledAttributes, l.Q2);
        ColorStateList a12 = c.a(context, obtainStyledAttributes, l.O2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.P2, 0);
        k m10 = k.b(context, obtainStyledAttributes.getResourceId(l.M2, 0), obtainStyledAttributes.getResourceId(l.N2, 0)).m();
        obtainStyledAttributes.recycle();
        return new a(a10, a11, a12, dimensionPixelSize, m10, rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10757a.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f10757a.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f10762f);
        gVar2.setShapeAppearanceModel(this.f10762f);
        gVar.Z(this.f10759c);
        gVar.h0(this.f10761e, this.f10760d);
        textView.setTextColor(this.f10758b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f10758b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.f10757a;
        d0.x0(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
