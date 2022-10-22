package com.mobvoi.health.companion.pressure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import fg.p;
import java.util.List;
import rg.a;
/* loaded from: classes2.dex */
public class PressureLevelPercentBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f18465a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f18466b;

    /* renamed from: c  reason: collision with root package name */
    private float f18467c;

    /* renamed from: d  reason: collision with root package name */
    private float f18468d;

    /* renamed from: e  reason: collision with root package name */
    private float f18469e;

    /* renamed from: f  reason: collision with root package name */
    private float f18470f;

    /* renamed from: g  reason: collision with root package name */
    private float f18471g;

    /* renamed from: h  reason: collision with root package name */
    private int f18472h;

    public PressureLevelPercentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f18467c = getPaddingTop();
        this.f18468d = getHeight() - getPaddingBottom();
        this.f18469e = getPaddingLeft();
        this.f18470f = getWidth() - getPaddingRight();
        List<a> list = this.f18466b;
        if (list != null && list.size() > 0) {
            float size = (this.f18470f - this.f18469e) - ((this.f18466b.size() - 1) * this.f18471g);
            float f10 = this.f18469e;
            for (a aVar : this.f18466b) {
                int i10 = aVar.f33510a;
                if (i10 > 0) {
                    aVar.f33512c = f10;
                    float f11 = f10 + ((i10 * size) / 100.0f);
                    aVar.f33513d = f11;
                    f10 = f11 + this.f18471g;
                }
            }
        }
    }

    private void b() {
        this.f18472h = j7.a.e(this, 16843820, -7829368);
        this.f18471g = getResources().getDimension(p.f26504e0);
        Paint paint = new Paint(1);
        this.f18465a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18465a.setStrokeWidth(getResources().getDimensionPixelSize(p.f26527q));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<a> list = this.f18466b;
        if (list == null || list.size() <= 0) {
            this.f18465a.setColor(this.f18472h);
            canvas.drawRect(this.f18469e, this.f18467c, this.f18470f, this.f18468d, this.f18465a);
            return;
        }
        for (int i10 = 0; i10 < this.f18466b.size(); i10++) {
            a aVar = this.f18466b.get(i10);
            this.f18465a.setColor(getResources().getColor(aVar.a()));
            canvas.drawRect(aVar.f33512c, this.f18467c, aVar.f33513d, this.f18468d, this.f18465a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setPercents(List<a> list) {
        this.f18466b = list;
        a();
        invalidate();
    }

    public PressureLevelPercentBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18465a = new Paint();
        b();
    }
}
