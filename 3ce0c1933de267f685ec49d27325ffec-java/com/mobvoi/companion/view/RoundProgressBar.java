package com.mobvoi.companion.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import gc.h;
/* loaded from: classes2.dex */
public class RoundProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f17661a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f17662b;

    /* renamed from: c  reason: collision with root package name */
    private int f17663c;

    /* renamed from: d  reason: collision with root package name */
    private int f17664d;

    /* renamed from: e  reason: collision with root package name */
    private int f17665e;

    /* renamed from: f  reason: collision with root package name */
    private float f17666f;

    /* renamed from: g  reason: collision with root package name */
    private float f17667g;

    /* renamed from: h  reason: collision with root package name */
    private int f17668h;

    /* renamed from: i  reason: collision with root package name */
    private int f17669i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17670j;

    /* renamed from: k  reason: collision with root package name */
    private int f17671k;

    /* renamed from: l  reason: collision with root package name */
    private int f17672l;

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getCricleColor() {
        return this.f17663c;
    }

    public int getCricleProgressColor() {
        return this.f17664d;
    }

    public int getMax() {
        return this.f17668h;
    }

    public int getProgress() {
        return this.f17669i;
    }

    public float getRoundWidth() {
        return this.f17667g;
    }

    public int getTextColor() {
        return this.f17665e;
    }

    public float getTextSize() {
        return this.f17666f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f10 = width;
        int i11 = (int) (f10 - (this.f17667g / 2.0f));
        this.f17661a.setColor(this.f17663c);
        this.f17661a.setStyle(Paint.Style.STROKE);
        this.f17661a.setStrokeWidth(this.f17667g);
        this.f17661a.setAntiAlias(true);
        canvas.drawCircle(f10, f10, i11, this.f17661a);
        this.f17661a.setStrokeWidth(0.0f);
        this.f17661a.setColor(this.f17665e);
        this.f17661a.setTextSize(this.f17666f);
        this.f17661a.setTypeface(Typeface.DEFAULT_BOLD);
        int i12 = (int) ((this.f17669i / this.f17668h) * 100.0f);
        float measureText = this.f17661a.measureText(i12 + "%");
        if (this.f17670j && i12 >= 0 && this.f17671k == 0) {
            canvas.drawText(i12 + "%", f10 - (measureText / 2.0f), f10 + (this.f17666f / 2.0f), this.f17661a);
        }
        this.f17661a.setStrokeWidth(this.f17667g);
        this.f17661a.setColor(this.f17664d);
        float f11 = width - i11;
        float f12 = width + i11;
        this.f17662b.set(f11, f11, f12, f12);
        int i13 = this.f17671k;
        if (i13 == 0) {
            this.f17661a.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.f17662b, this.f17672l, (this.f17669i * 360) / this.f17668h, false, this.f17661a);
        } else if (i13 == 1) {
            this.f17661a.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.f17669i != 0) {
                canvas.drawArc(this.f17662b, this.f17672l, (i10 * 360) / this.f17668h, true, this.f17661a);
            }
        }
    }

    public void setCricleColor(int i10) {
        this.f17663c = i10;
    }

    public void setCricleProgressColor(int i10) {
        this.f17664d = i10;
    }

    public void setMax(int i10) {
        if (i10 >= 0) {
            this.f17668h = i10;
            return;
        }
        throw new IllegalArgumentException("max not less than 0");
    }

    public void setProgress(int i10) {
        if (i10 >= 0) {
            int i11 = this.f17668h;
            if (i10 > i11) {
                i10 = i11;
            }
            if (i10 <= i11) {
                this.f17669i = i10;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("progress not less than 0");
    }

    public void setRoundWidth(float f10) {
        this.f17667g = f10;
    }

    public void setTextColor(int i10) {
        this.f17665e = i10;
    }

    public void setTextSize(float f10) {
        this.f17666f = f10;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17661a = new Paint();
        this.f17662b = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.f27387n);
        this.f17663c = obtainStyledAttributes.getColor(h.f27389p, 0);
        this.f17664d = obtainStyledAttributes.getColor(h.f27390q, -16711936);
        this.f17665e = obtainStyledAttributes.getColor(h.f27392s, -16711936);
        this.f17666f = obtainStyledAttributes.getDimension(h.f27393t, 15.0f);
        this.f17667g = obtainStyledAttributes.getDimension(h.f27394u, 5.0f);
        this.f17668h = obtainStyledAttributes.getInteger(h.f27388o, 100);
        this.f17672l = obtainStyledAttributes.getInteger(h.f27395v, 0);
        this.f17670j = obtainStyledAttributes.getBoolean(h.f27396w, true);
        this.f17671k = obtainStyledAttributes.getInt(h.f27391r, 0);
        obtainStyledAttributes.recycle();
    }
}
