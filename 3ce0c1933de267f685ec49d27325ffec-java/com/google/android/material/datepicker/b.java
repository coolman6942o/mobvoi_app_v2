package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import d7.l;
import t7.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CalendarStyle.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    final a f10763a;

    /* renamed from: b  reason: collision with root package name */
    final a f10764b;

    /* renamed from: c  reason: collision with root package name */
    final a f10765c;

    /* renamed from: d  reason: collision with root package name */
    final a f10766d;

    /* renamed from: e  reason: collision with root package name */
    final a f10767e;

    /* renamed from: f  reason: collision with root package name */
    final a f10768f;

    /* renamed from: g  reason: collision with root package name */
    final a f10769g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f10770h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(t7.b.d(context, d7.b.C, f.class.getCanonicalName()), l.f25548x2);
        this.f10763a = a.a(context, obtainStyledAttributes.getResourceId(l.A2, 0));
        this.f10769g = a.a(context, obtainStyledAttributes.getResourceId(l.f25556y2, 0));
        this.f10764b = a.a(context, obtainStyledAttributes.getResourceId(l.f25564z2, 0));
        this.f10765c = a.a(context, obtainStyledAttributes.getResourceId(l.B2, 0));
        ColorStateList a10 = c.a(context, obtainStyledAttributes, l.C2);
        this.f10766d = a.a(context, obtainStyledAttributes.getResourceId(l.E2, 0));
        this.f10767e = a.a(context, obtainStyledAttributes.getResourceId(l.D2, 0));
        this.f10768f = a.a(context, obtainStyledAttributes.getResourceId(l.F2, 0));
        Paint paint = new Paint();
        this.f10770h = paint;
        paint.setColor(a10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
