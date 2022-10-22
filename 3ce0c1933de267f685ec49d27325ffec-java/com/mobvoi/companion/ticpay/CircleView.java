package com.mobvoi.companion.ticpay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class CircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f17415a;

    /* renamed from: b  reason: collision with root package name */
    private int f17416b;

    /* renamed from: d  reason: collision with root package name */
    private Paint f17418d;

    /* renamed from: c  reason: collision with root package name */
    private int f17417c = -65536;

    /* renamed from: e  reason: collision with root package name */
    private float f17419e = 7.0f;

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f17418d = new Paint();
    }

    private int b(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode != 1073741824) {
            int paddingTop = (((int) this.f17419e) * 2) + getPaddingTop() + getPaddingBottom();
            size = mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
        }
        this.f17416b = size;
        return size;
    }

    private int c(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode != 1073741824) {
            int paddingLeft = (((int) this.f17419e) * 2) + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        this.f17415a = size;
        return size;
    }

    public int getCircleColor() {
        return this.f17417c;
    }

    public float getCircleRadius() {
        return this.f17419e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f17418d.setColor(this.f17417c);
        this.f17418d.setAntiAlias(true);
        canvas.drawCircle(this.f17415a / 2, this.f17416b / 2, this.f17419e, this.f17418d);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(c(i10), b(i11));
    }

    public void setCircleColor(int i10) {
        this.f17417c = i10;
        invalidate();
    }

    public void setCircleRadius(float f10) {
        this.f17419e = f10;
    }
}
