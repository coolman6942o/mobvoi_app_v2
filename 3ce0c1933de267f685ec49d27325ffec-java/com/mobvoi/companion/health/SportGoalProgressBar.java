package com.mobvoi.companion.health;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.i;
/* compiled from: SportGoalProgressBar.kt */
/* loaded from: classes2.dex */
public final class SportGoalProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f16798a;

    /* renamed from: b  reason: collision with root package name */
    private int f16799b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f16800c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f16801d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportGoalProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f16799b = 100;
        this.f16800c = new Path();
        this.f16801d = new Paint(1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth() - 1.0f;
        float height = getHeight() - 1.0f;
        this.f16801d.setStrokeWidth(1.0f);
        this.f16801d.setStyle(Paint.Style.STROKE);
        this.f16801d.setColor(-1);
        canvas.drawRoundRect(1.0f, 1.0f, width, height, height, height, this.f16801d);
        this.f16801d.setStyle(Paint.Style.FILL);
        this.f16801d.setColor(-1);
        this.f16801d.setStrokeWidth(height);
        this.f16800c.addRoundRect(3.0f, 3.0f, width - 2.0f, height - 2.0f, height, height, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.f16800c);
        int i10 = this.f16798a;
        int i11 = this.f16799b;
        float f10 = height / 2;
        canvas.drawLine(1.0f, f10, ((i10 > i11 ? i11 : i10) / 100.0f) * width, f10, this.f16801d);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    public final void setMaxProgress(int i10) {
        this.f16799b = i10;
        invalidate();
    }

    public final void setProgress(int i10) {
        this.f16798a = i10;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SportGoalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
