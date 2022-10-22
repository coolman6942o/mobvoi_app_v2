package com.mobvoi.companion.health;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: PercentLayout.kt */
/* loaded from: classes2.dex */
public final class PercentLayout extends ConstraintLayout {

    /* renamed from: u  reason: collision with root package name */
    private float f16796u;

    /* renamed from: v  reason: collision with root package name */
    private float f16797v;

    /* compiled from: PercentLayout.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PercentLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f16796u = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PercentLayout, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.PercentLayout, defStyleAttr, 0)");
        this.f16796u = obtainStyledAttributes.getFloat(R.styleable.PercentLayout_width_height_percent, 1.0f);
        this.f16797v = u1.b(context, obtainStyledAttributes.getInt(R.styleable.PercentLayout_reference_total_width_dp, 0));
        u1.b(context, obtainStyledAttributes.getInt(R.styleable.PercentLayout_reference_padding_dp, 0));
        if (this.f16796u <= 0.0f) {
            this.f16796u = 1.0f;
        }
        obtainStyledAttributes.recycle();
    }

    private final int E(int i10) {
        float f10 = i10 / this.f16797v;
        Context context = getContext();
        i.e(context, "context");
        return (int) (f10 * u1.a(context));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f16797v > 0.0f && getChildCount() > 0) {
            int i10 = 0;
            int childCount = getChildCount();
            if (childCount > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    ViewGroup.LayoutParams layoutParams = getChildAt(i10).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.leftMargin = E(marginLayoutParams.leftMargin);
                        marginLayoutParams.rightMargin = E(marginLayoutParams.rightMargin);
                        marginLayoutParams.topMargin = E(marginLayoutParams.topMargin);
                        marginLayoutParams.bottomMargin = E(marginLayoutParams.bottomMargin);
                        marginLayoutParams.setMarginStart(E(marginLayoutParams.getMarginStart()));
                        marginLayoutParams.setMarginEnd(E(marginLayoutParams.getMarginEnd()));
                    }
                    if (i11 < childCount) {
                        i10 = i11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (200 / this.f16796u), 1073741824));
        } else if (mode != Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (size / this.f16796u), 1073741824));
        } else if (mode != Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (size / this.f16796u), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (size2 * this.f16796u), 1073741824), i11);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PercentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
