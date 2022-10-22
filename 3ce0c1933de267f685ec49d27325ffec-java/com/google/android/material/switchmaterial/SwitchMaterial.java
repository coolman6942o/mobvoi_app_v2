package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.m;
import d7.b;
import d7.d;
import d7.k;
import d7.l;
import n7.a;
/* loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {

    /* renamed from: j0  reason: collision with root package name */
    private static final int f11334j0 = k.f25358w;

    /* renamed from: k0  reason: collision with root package name */
    private static final int[][] f11335k0 = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private final a T;
    private ColorStateList U;
    private ColorStateList V;
    private boolean W;

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.W);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.U == null) {
            int d10 = j7.a.d(this, b.f25161q);
            int d11 = j7.a.d(this, b.f25156l);
            float dimension = getResources().getDimension(d.f25225v0);
            if (this.T.d()) {
                dimension += m.c(this);
            }
            int c10 = this.T.c(d10, dimension);
            int[][] iArr = f11335k0;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = j7.a.h(d10, d11, 1.0f);
            iArr2[1] = c10;
            iArr2[2] = j7.a.h(d10, d11, 0.38f);
            iArr2[3] = c10;
            this.U = new ColorStateList(iArr, iArr2);
        }
        return this.U;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.V == null) {
            int[][] iArr = f11335k0;
            int[] iArr2 = new int[iArr.length];
            int d10 = j7.a.d(this, b.f25161q);
            int d11 = j7.a.d(this, b.f25156l);
            int d12 = j7.a.d(this, b.f25158n);
            iArr2[0] = j7.a.h(d10, d11, 0.54f);
            iArr2[1] = j7.a.h(d10, d12, 0.32f);
            iArr2[2] = j7.a.h(d10, d11, 0.12f);
            iArr2[3] = j7.a.h(d10, d12, 0.12f);
            this.V = new ColorStateList(iArr, iArr2);
        }
        return this.V;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.W && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z10) {
        this.W = z10;
        if (z10) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
            return;
        }
        setThumbTintList(null);
        setTrackTintList(null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SwitchMaterial(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f11334j0;
        Context context2 = getContext();
        this.T = new a(context2);
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.H4, i10, i11, new int[0]);
        this.W = h10.getBoolean(l.I4, false);
        h10.recycle();
    }
}
