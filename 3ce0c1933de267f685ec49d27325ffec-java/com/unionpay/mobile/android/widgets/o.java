package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
/* loaded from: classes2.dex */
public final class o extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24427a;

    /* renamed from: b  reason: collision with root package name */
    private int f24428b;

    public o(Context context) {
        this(context, -7829368, 0);
    }

    public o(Context context, int i10, int i11) {
        super(context);
        Paint paint = new Paint();
        this.f24427a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f24427a.setStrokeWidth(4.0f);
        this.f24427a.setColor(i10);
        this.f24427a.setPathEffect(null);
        this.f24428b = i11;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.f24428b;
        if (i10 == 0) {
            float height = getHeight() >> 1;
            canvas.drawLine(0.0f, height, getWidth(), height, this.f24427a);
        } else if (1 == i10) {
            float width = getWidth() >> 1;
            canvas.drawLine(width, 0.0f, width, getHeight(), this.f24427a);
        }
    }
}
