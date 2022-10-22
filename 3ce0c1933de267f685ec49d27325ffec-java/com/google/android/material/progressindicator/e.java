package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.k;
import d7.b;
import d7.d;
import d7.l;
import t7.c;
/* compiled from: CircularProgressIndicatorSpec.java */
/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f11223g;

    /* renamed from: h  reason: collision with root package name */
    public int f11224h;

    /* renamed from: i  reason: collision with root package name */
    public int f11225i;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f25155k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.b
    public void e() {
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, CircularProgressIndicator.f11179o);
    }

    public e(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f25217r0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(d.f25215q0);
        TypedArray h10 = k.h(context, attributeSet, l.f25404f1, i10, i11, new int[0]);
        this.f11223g = Math.max(c.c(context, h10, l.f25428i1, dimensionPixelSize), this.f11198a * 2);
        this.f11224h = c.c(context, h10, l.f25420h1, dimensionPixelSize2);
        this.f11225i = h10.getInt(l.f25412g1, 0);
        h10.recycle();
        e();
    }
}
