package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* compiled from: VisibilityAwareImageButton.java */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class n extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f11104a;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f11104a = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f11104a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        a(i10, true);
    }

    public n(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11104a = getVisibility();
    }
}
