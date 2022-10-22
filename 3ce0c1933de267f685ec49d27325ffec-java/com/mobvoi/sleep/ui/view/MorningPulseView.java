package com.mobvoi.sleep.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.android.common.utils.k;
import wj.a;
import wj.b;
import wj.c;
/* loaded from: classes2.dex */
public class MorningPulseView extends View {

    /* renamed from: a  reason: collision with root package name */
    Paint f20772a;

    /* renamed from: b  reason: collision with root package name */
    Paint f20773b;

    /* renamed from: c  reason: collision with root package name */
    Paint f20774c;

    /* renamed from: d  reason: collision with root package name */
    Paint f20775d;

    /* renamed from: e  reason: collision with root package name */
    Paint f20776e;

    /* renamed from: f  reason: collision with root package name */
    float f20777f;

    /* renamed from: g  reason: collision with root package name */
    int f20778g = -1;

    /* renamed from: h  reason: collision with root package name */
    int f20779h = 4;

    /* renamed from: i  reason: collision with root package name */
    float f20780i = 30.0f;

    /* renamed from: j  reason: collision with root package name */
    float f20781j = 12.0f;

    /* renamed from: k  reason: collision with root package name */
    int f20782k = -1;

    public MorningPulseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    private String a(int i10) {
        int i11;
        if (i10 < 50) {
            i11 = c.f36277g;
        } else if (i10 < 70) {
            i11 = c.f36276f;
        } else if (i10 < 80) {
            i11 = c.f36275e;
        } else if (i10 < 95) {
            i11 = c.f36274d;
        } else {
            i11 = c.f36278h;
        }
        return getContext().getString(i11);
    }

    private String b(int i10) {
        int i11;
        if (i10 == 0) {
            i11 = c.f36277g;
        } else if (i10 == 1) {
            i11 = c.f36276f;
        } else if (i10 == 2) {
            i11 = c.f36275e;
        } else if (i10 == 3) {
            i11 = c.f36274d;
        } else if (i10 != 4) {
            i11 = c.f36278h;
        } else {
            i11 = c.f36278h;
        }
        return getContext().getString(i11);
    }

    private int c(int i10) {
        if (i10 < 50) {
            return 0;
        }
        if (i10 < 70) {
            return 1;
        }
        if (i10 < 80) {
            return 2;
        }
        return i10 < 95 ? 3 : 4;
    }

    private String d(int i10) {
        int i11;
        if (i10 <= 5) {
            i11 = c.f36281k;
        } else {
            i11 = c.f36280j;
        }
        return getContext().getString(i11);
    }

    private void e() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(b.f36270d);
        Paint paint = new Paint(1);
        this.f20773b = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f20772a = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f20772a.setColor(getResources().getColor(a.f36259f));
        this.f20772a.setStrokeWidth(getResources().getDimension(b.f36267a));
        Paint paint3 = new Paint(1);
        this.f20775d = paint3;
        paint3.setColor(getResources().getColor(17170443));
        this.f20775d.setTextSize((dimensionPixelSize * 2) / 3);
        this.f20775d.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.f20774c = paint4;
        paint4.setColor(getResources().getColor(17170443));
        float f10 = dimensionPixelSize;
        this.f20774c.setTextSize(f10);
        this.f20774c.setTextAlign(Paint.Align.LEFT);
        Paint paint5 = new Paint(1);
        this.f20776e = paint5;
        paint5.setColor(getResources().getColor(17170443));
        this.f20776e.setTextSize(f10);
        this.f20776e.setTextAlign(Paint.Align.RIGHT);
        this.f20773b.setStyle(Paint.Style.FILL);
        this.f20773b.setStrokeWidth(0.0f);
        float dimension = getResources().getDimension(b.f36268b);
        this.f20777f = dimension;
        this.f20780i = Math.max(this.f20780i, dimension);
        new Path();
    }

    private void f(Canvas canvas) {
        float f10;
        int width = getWidth() / 5;
        float textSize = this.f20775d.getTextSize();
        float f11 = this.f20777f;
        float height = (((((getHeight() / 4) - f11) - this.f20781j) - textSize) / 2.0f) + f11;
        for (int i10 = 0; i10 < 5; i10++) {
            float f12 = width * i10;
            this.f20773b.setColor(zj.a.a(getContext(), i10));
            if (i10 == this.f20779h) {
                f10 = this.f20777f;
                this.f20773b.setAlpha(255);
            } else {
                f10 = this.f20777f / 2.0f;
                this.f20773b.setAlpha(128);
            }
            canvas.drawRect(f12, height - f10, f12 + width, height, this.f20773b);
            canvas.drawText(b(i10), f12 + (width / 2), this.f20781j + height + (textSize / 2.0f), this.f20775d);
        }
    }

    private void g(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float ascent = (this.f20774c.ascent() - this.f20774c.descent()) / 2.0f;
        int i10 = height / 8;
        float f10 = (i10 * 3) - ascent;
        canvas.drawText(getResources().getString(c.f36273c), 0.0f, f10, this.f20774c);
        float f11 = (i10 * 5) - ascent;
        canvas.drawText(getResources().getString(c.f36282l), 0.0f, f11, this.f20774c);
        float f12 = (i10 * 7) - ascent;
        canvas.drawText(getResources().getString(c.f36279i), 0.0f, f12, this.f20774c);
        float f13 = width;
        canvas.drawText(this.f20778g > 0 ? getResources().getString(c.f36272b, String.valueOf(this.f20778g)) : getResources().getString(c.f36271a), f13, f10, this.f20776e);
        int i11 = this.f20778g;
        canvas.drawText(i11 > 0 ? a(i11) : getResources().getString(c.f36271a), f13, f11, this.f20776e);
        int i12 = this.f20782k;
        canvas.drawText(i12 >= 0 ? d(i12) : getResources().getString(c.f36271a), f13, f12, this.f20776e);
        k.c("MorningPulseView", "width is %d, height is %d", Integer.valueOf(width), Integer.valueOf(height));
    }

    public void h(int i10, int i11) {
        this.f20778g = i10;
        this.f20779h = c(i10);
        this.f20782k = i11;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
        g(canvas);
    }
}
