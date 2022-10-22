package com.mobvoi.companion.health.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.u1;
import kc.f;
import kotlin.jvm.internal.i;
/* compiled from: HealthTitleContainer.kt */
/* loaded from: classes2.dex */
public final class HealthTitleContainer extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f17128a;

    /* renamed from: b  reason: collision with root package name */
    private int f17129b;

    /* renamed from: c  reason: collision with root package name */
    private float f17130c;

    /* renamed from: d  reason: collision with root package name */
    private float f17131d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthTitleContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HealthTitleContainer, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.HealthTitleContainer, defStyleAttr, 0)");
        this.f17130c = u1.b(context, obtainStyledAttributes.getInt(R.styleable.HealthTitleContainer_container_reference_total_width_dp, 0));
        this.f17131d = u1.b(context, obtainStyledAttributes.getInt(R.styleable.HealthTitleContainer_container_reference_padding_dp, 0));
        obtainStyledAttributes.recycle();
    }

    public final void a(Context context, int i10) {
        i.f(context, "context");
        this.f17129b = b.c(context, i10);
        requestLayout();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        int i10 = this.f17129b;
        if (i10 != 0) {
            canvas.drawColor(i10);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.f17130c > 0.0f && getChildCount() > 0) {
            int i10 = 0;
            int childCount = getChildCount();
            if (childCount > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    ViewGroup.LayoutParams layoutParams = getChildAt(i10).getLayoutParams();
                    float f10 = layoutParams.height / this.f17130c;
                    Context context = getContext();
                    i.e(context, "context");
                    layoutParams.height = (int) (f10 * u1.a(context));
                    if (i11 >= childCount) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        this.f17128a = f.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View childAt = getChildAt(0);
        float f10 = this.f17131d / this.f17130c;
        Context context = getContext();
        i.e(context, "context");
        childAt.layout((int) (f10 * u1.a(context)), this.f17128a, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = this.f17128a;
        int childCount = getChildCount();
        if (childCount > 0) {
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                View childAt = getChildAt(i13);
                measureChild(childAt, i10, i11);
                i12 += childAt.getMeasuredHeight();
                if (i14 >= childCount) {
                    break;
                }
                i13 = i14;
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), i12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthTitleContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
