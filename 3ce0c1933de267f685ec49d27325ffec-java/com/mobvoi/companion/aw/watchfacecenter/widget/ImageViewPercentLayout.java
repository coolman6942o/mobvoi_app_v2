package com.mobvoi.companion.aw.watchfacecenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.aw.watchfacecenter.t;
import kotlin.jvm.internal.i;
/* compiled from: ImageViewPercentLayout.kt */
/* loaded from: classes2.dex */
public final class ImageViewPercentLayout extends ConstraintLayout {

    /* renamed from: u  reason: collision with root package name */
    private final float f16492u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewPercentLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f16476a, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(\n            attrs, R.styleable.ImageViewPercentLayout,\n            defStyleAttr, 0\n        )");
        this.f16492u = obtainStyledAttributes.getFloat(t.f16477b, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (size / this.f16492u), 1073741824));
        } else {
            super.onMeasure(i10, i11);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewPercentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
