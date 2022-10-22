package com.mobvoi.companion.aw.watchfacecenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.q;
import com.mobvoi.companion.aw.watchfacecenter.t;
import kotlin.jvm.internal.i;
/* compiled from: SquareImageView.kt */
/* loaded from: classes2.dex */
public final class SquareImageView extends q {

    /* renamed from: d  reason: collision with root package name */
    private final int f16521d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f16485j, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.SquareImageView, defStyleAttr, 0)");
        this.f16521d = obtainStyledAttributes.getInt(t.f16486k, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f16521d == 0) {
            int size = View.MeasureSpec.getSize(i11);
            setMeasuredDimension(size, size);
            return;
        }
        int size2 = View.MeasureSpec.getSize(i10);
        setMeasuredDimension(size2, size2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
