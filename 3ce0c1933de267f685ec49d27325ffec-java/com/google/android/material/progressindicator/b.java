package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.k;
import d7.d;
import d7.l;
import j7.a;
import t7.c;
/* compiled from: BaseProgressIndicatorSpec.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public int f11198a;

    /* renamed from: b  reason: collision with root package name */
    public int f11199b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f11200c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    public int f11201d;

    /* renamed from: e  reason: collision with root package name */
    public int f11202e;

    /* renamed from: f  reason: collision with root package name */
    public int f11203f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, AttributeSet attributeSet, int i10, int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f25219s0);
        TypedArray h10 = k.h(context, attributeSet, l.A, i10, i11, new int[0]);
        this.f11198a = c.c(context, h10, l.I, dimensionPixelSize);
        this.f11199b = Math.min(c.c(context, h10, l.H, 0), this.f11198a / 2);
        this.f11202e = h10.getInt(l.E, 0);
        this.f11203f = h10.getInt(l.B, 0);
        c(context, h10);
        d(context, h10);
        h10.recycle();
    }

    private void c(Context context, TypedArray typedArray) {
        int i10 = l.C;
        if (!typedArray.hasValue(i10)) {
            this.f11200c = new int[]{a.b(context, d7.b.f25159o, -1)};
        } else if (typedArray.peekValue(i10).type != 1) {
            this.f11200c = new int[]{typedArray.getColor(i10, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
            this.f11200c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void d(Context context, TypedArray typedArray) {
        int i10 = l.G;
        if (typedArray.hasValue(i10)) {
            this.f11201d = typedArray.getColor(i10, -1);
            return;
        }
        this.f11201d = this.f11200c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f10 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f11201d = a.a(this.f11201d, (int) (f10 * 255.0f));
    }

    public boolean a() {
        return this.f11203f != 0;
    }

    public boolean b() {
        return this.f11202e != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();
}
