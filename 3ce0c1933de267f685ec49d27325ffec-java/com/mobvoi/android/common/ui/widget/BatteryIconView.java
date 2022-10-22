package com.mobvoi.android.common.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import y9.k;
/* loaded from: classes2.dex */
public class BatteryIconView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f15362a;

    /* renamed from: b  reason: collision with root package name */
    private float f15363b;

    /* renamed from: h  reason: collision with root package name */
    private float f15369h;

    /* renamed from: i  reason: collision with root package name */
    private float f15370i;

    /* renamed from: j  reason: collision with root package name */
    private float f15371j;

    /* renamed from: q  reason: collision with root package name */
    private RectF f15378q;

    /* renamed from: c  reason: collision with root package name */
    private float f15364c = 20.0f;

    /* renamed from: d  reason: collision with root package name */
    private int f15365d = -16777216;

    /* renamed from: e  reason: collision with root package name */
    private int f15366e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    private int f15367f = -16777216;

    /* renamed from: g  reason: collision with root package name */
    private String f15368g = "1";

    /* renamed from: k  reason: collision with root package name */
    private int f15372k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f15373l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f15374m = 20;

    /* renamed from: n  reason: collision with root package name */
    private Path f15375n = new Path();

    /* renamed from: o  reason: collision with root package name */
    private Paint f15376o = new Paint();

    /* renamed from: p  reason: collision with root package name */
    private Paint f15377p = new Paint();

    public BatteryIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    private void b(Canvas canvas) {
        Path path = this.f15375n;
        int i10 = this.f15374m;
        path.moveTo(i10 + this.f15369h, i10);
        this.f15375n.lineTo(this.f15362a - this.f15369h, this.f15374m);
        float f10 = this.f15362a;
        float f11 = this.f15369h;
        int i11 = this.f15374m;
        RectF rectF = new RectF(f10 - f11, i11, f10, i11 + f11);
        this.f15378q = rectF;
        this.f15375n.arcTo(rectF, 270.0f, 90.0f);
        this.f15375n.lineTo(this.f15362a, ((this.f15363b - this.f15371j) / 2.0f) + this.f15374m);
        this.f15375n.lineTo((this.f15362a + this.f15370i) - (this.f15369h / 2.0f), ((this.f15363b - this.f15371j) / 2.0f) + this.f15374m);
        float f12 = this.f15362a;
        float f13 = this.f15370i;
        float f14 = this.f15369h;
        float f15 = this.f15363b;
        float f16 = this.f15371j;
        int i12 = this.f15374m;
        RectF rectF2 = new RectF((f12 + f13) - (f14 / 2.0f), ((f15 - f16) / 2.0f) + i12, f12 + f13, ((f15 - f16) / 2.0f) + (f14 / 2.0f) + i12);
        this.f15378q = rectF2;
        this.f15375n.arcTo(rectF2, 270.0f, 90.0f);
        Path path2 = this.f15375n;
        float f17 = this.f15362a;
        float f18 = this.f15370i;
        path2.lineTo(f17 + f18, (((this.f15363b / 2.0f) + (f18 / 2.0f)) - (this.f15369h / 2.0f)) + this.f15374m);
        float f19 = this.f15362a;
        float f20 = this.f15370i;
        float f21 = this.f15369h;
        float f22 = (f19 + f20) - (f21 / 2.0f);
        float f23 = this.f15363b;
        float f24 = ((f23 / 2.0f) + (f20 / 2.0f)) - (f21 / 2.0f);
        int i13 = this.f15374m;
        RectF rectF3 = new RectF(f22, f24 + i13, f19 + f20, (f23 / 2.0f) + (f20 / 2.0f) + i13);
        this.f15378q = rectF3;
        this.f15375n.arcTo(rectF3, 0.0f, 90.0f);
        this.f15375n.lineTo(this.f15362a, (this.f15363b / 2.0f) + (this.f15370i / 2.0f) + this.f15374m);
        this.f15375n.lineTo(this.f15362a, this.f15363b - this.f15369h);
        float f25 = this.f15362a;
        float f26 = this.f15369h;
        float f27 = this.f15363b;
        int i14 = this.f15374m;
        RectF rectF4 = new RectF(f25 - f26, (f27 - f26) + i14, f25, f27 + i14);
        this.f15378q = rectF4;
        this.f15375n.arcTo(rectF4, 0.0f, 90.0f);
        Path path3 = this.f15375n;
        int i15 = this.f15374m;
        path3.lineTo(i15 + this.f15369h, this.f15363b + i15);
        int i16 = this.f15374m;
        float f28 = this.f15363b;
        float f29 = this.f15369h;
        RectF rectF5 = new RectF(i16, (f28 - f29) + i16, i16 + f29, f28 + i16);
        this.f15378q = rectF5;
        this.f15375n.arcTo(rectF5, 90.0f, 90.0f);
        Path path4 = this.f15375n;
        int i17 = this.f15374m;
        path4.lineTo(i17, i17 + this.f15369h + i17);
        int i18 = this.f15374m;
        float f30 = this.f15369h;
        RectF rectF6 = new RectF(i18, i18, i18 + f30, i18 + f30);
        this.f15378q = rectF6;
        this.f15375n.arcTo(rectF6, 180.0f, 90.0f);
        this.f15375n.close();
        canvas.drawPath(this.f15375n, this.f15377p);
        int i19 = this.f15372k;
        if (i19 == -1) {
            this.f15376o.setStrokeWidth(this.f15364c);
            this.f15376o.setColor(this.f15365d);
            int i20 = this.f15374m;
            float f31 = this.f15364c;
            canvas.drawLine(i20 + f31, this.f15363b, this.f15362a - i20, i20 + f31, this.f15376o);
            return;
        }
        RectF rectF7 = this.f15378q;
        int i21 = this.f15374m;
        float f32 = this.f15364c;
        float f33 = i21 + f32;
        rectF7.left = f33;
        rectF7.top = i21 + f32;
        rectF7.right = f33 + ((((this.f15362a - (i21 * 2)) - f32) * i19) / 100.0f);
        rectF7.bottom = this.f15363b;
        if (i19 <= this.f15373l) {
            this.f15376o.setColor(this.f15367f);
        } else {
            this.f15376o.setColor(this.f15366e);
        }
        RectF rectF8 = this.f15378q;
        float f34 = this.f15369h;
        canvas.drawRoundRect(rectF8, f34 / 3.0f, f34 / 3.0f, this.f15376o);
    }

    private void c(Canvas canvas) {
        Path path = this.f15375n;
        int i10 = this.f15374m;
        path.moveTo(i10 + this.f15369h, i10 + this.f15371j);
        Path path2 = this.f15375n;
        int i11 = this.f15374m;
        path2.lineTo(i11 + ((this.f15362a - this.f15370i) / 2.0f), i11 + this.f15371j);
        Path path3 = this.f15375n;
        int i12 = this.f15374m;
        path3.lineTo(i12 + ((this.f15362a - this.f15370i) / 2.0f), i12 + (this.f15369h / 2.0f));
        int i13 = this.f15374m;
        float f10 = this.f15362a;
        float f11 = this.f15370i;
        float f12 = i13 + ((f10 - f11) / 2.0f);
        float f13 = this.f15369h;
        RectF rectF = new RectF(i13 + ((f10 - f11) / 2.0f), i13, f12 + (f13 / 2.0f), i13 + (f13 / 2.0f));
        this.f15378q = rectF;
        this.f15375n.arcTo(rectF, 180.0f, 90.0f);
        Path path4 = this.f15375n;
        int i14 = this.f15374m;
        path4.lineTo((i14 + ((this.f15362a / 2.0f) + (this.f15370i / 2.0f))) - (this.f15369h / 2.0f), i14);
        int i15 = this.f15374m;
        float f14 = this.f15362a;
        float f15 = this.f15370i;
        float f16 = this.f15369h;
        RectF rectF2 = new RectF((i15 + ((f14 / 2.0f) + (f15 / 2.0f))) - (f16 / 2.0f), i15, i15 + (f14 / 2.0f) + (f15 / 2.0f), i15 + (f16 / 2.0f));
        this.f15378q = rectF2;
        this.f15375n.arcTo(rectF2, 270.0f, 90.0f);
        Path path5 = this.f15375n;
        int i16 = this.f15374m;
        path5.lineTo(i16 + (this.f15362a / 2.0f) + (this.f15370i / 2.0f), i16 + this.f15371j);
        Path path6 = this.f15375n;
        int i17 = this.f15374m;
        path6.lineTo((i17 + this.f15362a) - this.f15369h, i17 + this.f15371j);
        int i18 = this.f15374m;
        float f17 = this.f15362a;
        float f18 = this.f15369h;
        float f19 = this.f15371j;
        RectF rectF3 = new RectF((i18 + f17) - f18, i18 + f19, i18 + f17, i18 + f19 + f18);
        this.f15378q = rectF3;
        this.f15375n.arcTo(rectF3, 270.0f, 90.0f);
        Path path7 = this.f15375n;
        int i19 = this.f15374m;
        path7.lineTo(i19 + this.f15362a, (i19 + this.f15363b) - this.f15369h);
        int i20 = this.f15374m;
        float f20 = this.f15362a;
        float f21 = this.f15369h;
        float f22 = this.f15363b;
        RectF rectF4 = new RectF((i20 + f20) - f21, (i20 + f22) - f21, i20 + f20, i20 + f22);
        this.f15378q = rectF4;
        this.f15375n.arcTo(rectF4, 0.0f, 90.0f);
        Path path8 = this.f15375n;
        int i21 = this.f15374m;
        path8.lineTo(i21 + this.f15369h, i21 + this.f15363b);
        int i22 = this.f15374m;
        float f23 = this.f15363b;
        float f24 = this.f15369h;
        RectF rectF5 = new RectF(i22, (f23 - f24) + i22, i22 + f24, f23 + i22);
        this.f15378q = rectF5;
        this.f15375n.arcTo(rectF5, 90.0f, 90.0f);
        Path path9 = this.f15375n;
        int i23 = this.f15374m;
        path9.lineTo(i23, i23 + this.f15371j + this.f15369h);
        int i24 = this.f15374m;
        float f25 = this.f15371j;
        float f26 = this.f15369h;
        RectF rectF6 = new RectF(i24, i24 + f25, i24 + f26, f25 + i24 + f26);
        this.f15378q = rectF6;
        this.f15375n.arcTo(rectF6, 180.0f, 90.0f);
        this.f15375n.close();
        canvas.drawPath(this.f15375n, this.f15377p);
        RectF rectF7 = this.f15378q;
        int i25 = this.f15374m;
        float f27 = this.f15364c;
        float f28 = this.f15371j;
        rectF7.top = i25 + f27 + f28;
        int i26 = this.f15372k;
        if (i26 == -1) {
            this.f15376o.setStrokeWidth(f27);
            this.f15376o.setColor(this.f15365d);
            int i27 = this.f15374m;
            float f29 = this.f15364c;
            canvas.drawLine(i27 + f29, (this.f15363b - f29) + i27, i27 + f29 + this.f15371j, (this.f15378q.left + this.f15362a) - (f29 * 2.0f), this.f15376o);
            return;
        }
        float f30 = this.f15363b;
        rectF7.top = i25 + f27 + f28 + ((((f30 - (i25 * 2)) - f28) * (100 - i26)) / 100.0f);
        float f31 = i25 + f27;
        rectF7.left = f31;
        rectF7.right = (f31 + this.f15362a) - (f27 * 2.0f);
        rectF7.bottom = (f30 - f27) + i25;
        if (i26 <= this.f15373l) {
            this.f15376o.setColor(this.f15367f);
        } else {
            this.f15376o.setColor(this.f15366e);
        }
        RectF rectF8 = this.f15378q;
        float f32 = this.f15369h;
        canvas.drawRoundRect(rectF8, f32 / 2.0f, f32 / 2.0f, this.f15376o);
    }

    private void d(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f36860a);
            float dimension = obtainStyledAttributes.getDimension(k.f36862c, 20.0f);
            this.f15373l = obtainStyledAttributes.getInteger(k.f36867h, -1);
            this.f15364c = a(dimension);
            this.f15365d = obtainStyledAttributes.getColor(k.f36861b, -16777216);
            this.f15367f = obtainStyledAttributes.getColor(k.f36866g, -16777216);
            this.f15366e = obtainStyledAttributes.getColor(k.f36863d, -16777216);
            this.f15368g = obtainStyledAttributes.getString(k.f36864e);
            this.f15374m = (int) obtainStyledAttributes.getDimension(k.f36865f, this.f15364c);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.f15377p = paint;
        paint.setStrokeWidth(this.f15364c);
        this.f15377p.setAntiAlias(true);
        this.f15377p.setColor(this.f15365d);
        this.f15377p.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f15376o = paint2;
        paint2.setAntiAlias(true);
        this.f15376o.setColor(this.f15366e);
        this.f15376o.setStyle(Paint.Style.FILL);
    }

    protected int a(float f10) {
        return (int) TypedValue.applyDimension(1, f10, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f15368g.equals("1")) {
            if (getWidth() <= getHeight()) {
                this.f15370i = getWidth() / 3;
                this.f15371j = getHeight() / 12;
                this.f15362a = getWidth() - (this.f15364c * 2.0f);
                this.f15363b = getHeight() - (this.f15364c * 2.0f);
                this.f15369h = this.f15362a / 5.0f;
                c(canvas);
                return;
            }
            throw new IllegalStateException("vertical state height must be bigger than width");
        } else if (getHeight() <= getWidth()) {
            this.f15362a = (getWidth() - (getWidth() / 10)) - (this.f15364c * 2.0f);
            float width = (getWidth() / 2) - (this.f15364c * 2.0f);
            this.f15363b = width;
            this.f15370i = this.f15362a / 10.0f;
            this.f15371j = width / 3.0f;
            this.f15369h = width / 5.0f;
            b(canvas);
        } else {
            throw new IllegalStateException("Horizontal state width must be bigger than height");
        }
    }

    public void setBattery(int i10) {
        this.f15372k = i10;
        invalidate();
    }

    public void setBatteryColor(int i10) {
        Paint paint = this.f15376o;
        if (paint != null) {
            this.f15366e = i10;
            paint.setColor(i10);
        }
        invalidate();
    }

    public void setBorderColor(int i10) {
        Paint paint = this.f15377p;
        if (paint != null) {
            this.f15365d = i10;
            paint.setColor(i10);
        }
        invalidate();
    }
}
