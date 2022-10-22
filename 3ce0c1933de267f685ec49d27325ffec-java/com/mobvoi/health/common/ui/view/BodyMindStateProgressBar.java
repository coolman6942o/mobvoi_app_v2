package com.mobvoi.health.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import mf.c;
import mf.e;
/* loaded from: classes2.dex */
public class BodyMindStateProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f17987a;

    /* renamed from: b  reason: collision with root package name */
    private int f17988b;

    /* renamed from: c  reason: collision with root package name */
    private int f17989c;

    /* renamed from: d  reason: collision with root package name */
    private int f17990d;

    /* renamed from: e  reason: collision with root package name */
    private int f17991e;

    /* renamed from: f  reason: collision with root package name */
    protected Paint f17992f;

    /* renamed from: g  reason: collision with root package name */
    protected Paint f17993g;

    /* renamed from: h  reason: collision with root package name */
    private float f17994h;

    /* renamed from: i  reason: collision with root package name */
    private float f17995i;

    /* renamed from: j  reason: collision with root package name */
    private float f17996j;

    /* renamed from: k  reason: collision with root package name */
    private float f17997k;

    /* renamed from: l  reason: collision with root package name */
    private float f17998l;

    /* renamed from: m  reason: collision with root package name */
    private PorterDuffXfermode f17999m;

    /* renamed from: n  reason: collision with root package name */
    private RectF f18000n;

    /* renamed from: o  reason: collision with root package name */
    private Bitmap f18001o;

    public BodyMindStateProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        this.f17992f.setStyle(Paint.Style.FILL);
        this.f17992f.setAntiAlias(true);
        this.f17992f.setColor(this.f17991e);
        Paint paint = new Paint();
        this.f17993g = paint;
        paint.setColor(-16776961);
        this.f17993g.setAntiAlias(true);
        this.f17993g.setStyle(Paint.Style.FILL);
        this.f17999m = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.f17997k, this.f17998l, this.f17993g);
        int i10 = this.f17988b;
        int i11 = i10 / 10;
        int i12 = i10 % 10;
        for (int i13 = 0; i13 < 5; i13++) {
            float f10 = this.f17994h;
            float f11 = i13;
            float f12 = (this.f17995i * f11) + (f10 * f11) + 0.0f;
            float f13 = f12 + f10;
            if (i13 < i11) {
                this.f17992f.setColor(this.f17991e);
                canvas.drawRect(f12, 0.0f, f13, this.f17998l, this.f17992f);
            } else if (i13 > i11) {
                this.f17992f.setColor(this.f17990d);
                canvas.drawRect(f12, 0.0f, f13, this.f17998l, this.f17992f);
            } else if (i12 == 0) {
                this.f17992f.setColor(this.f17990d);
                canvas.drawRect(f12, 0.0f, f13, this.f17998l, this.f17992f);
            } else {
                this.f17992f.setColor(this.f17991e);
                float f14 = f12 + ((f10 * i12) / 10.0f);
                canvas.drawRect(f12, 0.0f, f14, this.f17998l, this.f17992f);
                this.f17992f.setColor(this.f17990d);
                canvas.drawRect(f14, 0.0f, f13, this.f17998l, this.f17992f);
            }
        }
        this.f17992f.setXfermode(this.f17999m);
        Bitmap bitmap = this.f18001o;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f17992f);
        }
        this.f17992f.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f17997k = (i10 - getPaddingRight()) - getPaddingLeft();
        this.f17998l = getHeight();
        this.f17994h = (this.f17997k - (this.f17995i * 4.0f)) / 5.0f;
        this.f18000n = new RectF(0.0f, 0.0f, this.f17997k, this.f17998l);
        this.f18001o = Bitmap.createBitmap((int) this.f17997k, (int) this.f17998l, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f18001o);
        RectF rectF = this.f18000n;
        float f10 = this.f17996j;
        canvas.drawRoundRect(rectF, f10, f10, this.f17993g);
    }

    public void setMax(int i10) {
        this.f17987a = i10;
        invalidate();
    }

    public void setProgress(int i10) {
        int i11 = this.f17987a;
        if (i10 > i11) {
            i10 = i11;
        }
        this.f17988b = i10;
        invalidate();
    }

    public void setSegment(int i10) {
        this.f17989c = i10;
        invalidate();
    }

    public BodyMindStateProgressBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public BodyMindStateProgressBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f17989c = 5;
        this.f17992f = new Paint();
        this.f17993g = new Paint();
        this.f17994h = 0.0f;
        this.f17995i = 0.0f;
        this.f17996j = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f30748a, i10, i10);
        if (obtainStyledAttributes != null) {
            this.f17988b = obtainStyledAttributes.getInt(e.f30750c, 0);
            int i12 = obtainStyledAttributes.getInt(e.f30754g, 5);
            this.f17989c = i12;
            this.f17987a = obtainStyledAttributes.getInt(e.f30749b, i12 * 10);
            this.f17995i = obtainStyledAttributes.getDimension(e.f30755h, getResources().getDimensionPixelSize(c.f30673a));
            this.f17996j = obtainStyledAttributes.getDimension(e.f30753f, 0.0f);
            this.f17990d = obtainStyledAttributes.getColor(e.f30751d, Color.parseColor("#DDE4F4"));
            this.f17991e = obtainStyledAttributes.getColor(e.f30752e, Color.parseColor("#3D7EFE"));
        }
        obtainStyledAttributes.recycle();
        a();
    }
}
