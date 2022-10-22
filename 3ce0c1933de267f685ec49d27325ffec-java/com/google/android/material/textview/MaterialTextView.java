package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.b0;
import d7.l;
import t7.b;
import t7.c;
import x7.a;
/* loaded from: classes.dex */
public class MaterialTextView extends b0 {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private void f(Resources.Theme theme, int i10) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i10, l.f25486p3);
        int i11 = i(getContext(), obtainStyledAttributes, l.f25501r3, l.f25509s3);
        obtainStyledAttributes.recycle();
        if (i11 >= 0) {
            setLineHeight(i11);
        }
    }

    private static boolean g(Context context) {
        return b.b(context, d7.b.Y, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.f25517t3, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(l.f25525u3, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int i(Context context, TypedArray typedArray, int... iArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < iArr.length && i10 < 0; i11++) {
            i10 = c.c(context, typedArray, iArr[i11], -1);
        }
        return i10;
    }

    private static boolean j(Context context, Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.f25517t3, i10, i11);
        int i12 = i(context, obtainStyledAttributes, l.f25533v3, l.f25541w3);
        obtainStyledAttributes.recycle();
        return i12 != -1;
    }

    @Override // androidx.appcompat.widget.b0, android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (g(context)) {
            f(context.getTheme(), i10);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(a.c(context, attributeSet, i10, i11), attributeSet, i10);
        int h10;
        Context context2 = getContext();
        if (g(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (!j(context2, theme, attributeSet, i10, i11) && (h10 = h(theme, attributeSet, i10, i11)) != -1) {
                f(theme, h10);
            }
        }
    }
}
