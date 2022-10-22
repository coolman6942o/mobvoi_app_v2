package s7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.u;
import androidx.core.widget.d;
import d7.b;
import d7.k;
import d7.l;
import t7.c;
/* compiled from: MaterialRadioButton.java */
/* loaded from: classes.dex */
public class a extends u {

    /* renamed from: g  reason: collision with root package name */
    private static final int f34332g = k.f25357v;

    /* renamed from: h  reason: collision with root package name */
    private static final int[][] f34333h = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f34334e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34335f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.N);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f34334e == null) {
            int d10 = j7.a.d(this, b.f25156l);
            int d11 = j7.a.d(this, b.f25158n);
            int d12 = j7.a.d(this, b.f25161q);
            int[][] iArr = f34333h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = j7.a.h(d12, d10, 1.0f);
            iArr2[1] = j7.a.h(d12, d11, 0.54f);
            iArr2[2] = j7.a.h(d12, d11, 0.38f);
            iArr2[3] = j7.a.h(d12, d11, 0.38f);
            this.f34334e = new ColorStateList(iArr, iArr2);
        }
        return this.f34334e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f34335f && d.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.f34335f = z10;
        if (z10) {
            d.c(this, getMaterialThemeColorsTintList());
        } else {
            d.c(this, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f34332g;
        Context context2 = getContext();
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.f25438j3, i10, i11, new int[0]);
        int i12 = l.f25446k3;
        if (h10.hasValue(i12)) {
            d.c(this, c.a(context2, h10, i12));
        }
        this.f34335f = h10.getBoolean(l.f25454l3, false);
        h10.recycle();
    }
}
