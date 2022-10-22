package com.mobvoi.health.companion.sleep;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import fg.o;
import fg.p;
/* loaded from: classes2.dex */
public class SleepPercentView extends View {

    /* renamed from: e  reason: collision with root package name */
    private float f18593e;

    /* renamed from: f  reason: collision with root package name */
    private float f18594f;

    /* renamed from: h  reason: collision with root package name */
    private float f18596h;

    /* renamed from: a  reason: collision with root package name */
    private Paint f18589a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private Paint f18590b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private int f18591c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f18592d = 0;

    /* renamed from: g  reason: collision with root package name */
    private Rect f18595g = new Rect();

    public SleepPercentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f18596h = getResources().getDimension(p.f26537v);
        this.f18589a.setStyle(Paint.Style.FILL);
        this.f18590b.setColor(getResources().getColor(o.f26460h));
        this.f18590b.setStrokeWidth(2.0f);
        this.f18590b.setTextSize(getResources().getDimension(p.f26539w));
        this.f18590b.setAlpha(135);
        this.f18590b.setTextAlign(Paint.Align.RIGHT);
    }

    public void b(int i10, int i11) {
        this.f18591c = i10;
        this.f18592d = i11;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f18589a.setColor(this.f18591c);
        this.f18589a.setAlpha(51);
        canvas.drawRect(0.0f, 0.0f, this.f18593e, this.f18594f, this.f18589a);
        this.f18589a.setAlpha(225);
        canvas.drawRect(0.0f, 0.0f, (this.f18593e * this.f18592d) / 100.0f, this.f18594f, this.f18589a);
        String str = this.f18592d + "%";
        this.f18590b.getTextBounds(str, 0, str.length(), this.f18595g);
        canvas.drawText(str, this.f18593e - this.f18596h, (this.f18594f / 2.0f) + (this.f18595g.height() / 2), this.f18590b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f18593e = i10;
        this.f18594f = i11;
    }
}
