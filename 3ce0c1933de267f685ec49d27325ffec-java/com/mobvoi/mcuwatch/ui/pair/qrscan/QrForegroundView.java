package com.mobvoi.mcuwatch.ui.pair.qrscan;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import sh.d;
import sh.f;
import sh.m;
/* loaded from: classes2.dex */
public class QrForegroundView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f19966a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f19967b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f19968c;

    /* renamed from: d  reason: collision with root package name */
    private int f19969d;

    /* renamed from: e  reason: collision with root package name */
    private int f19970e;

    /* renamed from: f  reason: collision with root package name */
    private float f19971f;

    /* renamed from: g  reason: collision with root package name */
    private float f19972g;

    /* renamed from: h  reason: collision with root package name */
    private float f19973h;

    /* renamed from: i  reason: collision with root package name */
    private float f19974i;

    /* renamed from: j  reason: collision with root package name */
    private float f19975j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f19976k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f19977l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    private String f19978m = null;

    public QrForegroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    private int a(int i10, String str) {
        int indexOf = str.indexOf(" ", i10);
        return indexOf > 0 ? indexOf : i10;
    }

    private void b(AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f19966a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f19966a.setColor(getResources().getColor(d.d_res_0x7f060055));
        this.f19968c = BitmapFactory.decodeResource(getResources(), f.f34554i0);
        Paint paint2 = new Paint();
        this.f19967b = paint2;
        paint2.setTextAlign(Paint.Align.CENTER);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f34916j);
            int color = obtainStyledAttributes.getColor(m.f34918l, -1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m.f34920n, 0);
            this.f19975j = obtainStyledAttributes.getDimensionPixelSize(m.f34919m, 0);
            this.f19978m = obtainStyledAttributes.getString(m.f34917k);
            obtainStyledAttributes.recycle();
            this.f19967b.setColor(color);
            this.f19967b.setTextSize(dimensionPixelSize);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19970e == 0) {
            this.f19969d = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.f19970e = measuredWidth;
            this.f19971f = (measuredWidth - this.f19968c.getWidth()) / 2;
            this.f19972g = (this.f19969d - this.f19968c.getHeight()) / 3;
            this.f19973h = this.f19971f + this.f19968c.getWidth();
            float height = this.f19972g + this.f19968c.getHeight();
            this.f19974i = height;
            this.f19976k = this.f19970e / 2;
            this.f19977l = height + this.f19975j;
        }
        canvas.drawRect(0.0f, 0.0f, this.f19971f, this.f19969d, this.f19966a);
        canvas.drawRect(this.f19973h, 0.0f, this.f19970e, this.f19969d, this.f19966a);
        canvas.drawRect(this.f19971f, 0.0f, this.f19973h, this.f19972g, this.f19966a);
        canvas.drawRect(this.f19971f, this.f19974i, this.f19973h, this.f19969d, this.f19966a);
        canvas.drawBitmap(this.f19968c, this.f19971f, this.f19972g, (Paint) null);
        if (!TextUtils.isEmpty(this.f19978m)) {
            int length = this.f19978m.length();
            if (length < 40) {
                canvas.drawText(this.f19978m, this.f19976k, this.f19977l, this.f19967b);
                return;
            }
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 40;
                if (i11 > length) {
                    i11 = length;
                }
                int a10 = a(i11 - 1, this.f19978m) + 1;
                canvas.drawText(this.f19978m.substring(i10, a10), this.f19976k, this.f19977l + ((i10 / 40) * this.f19967b.getTextSize()), this.f19967b);
                i10 = a10;
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f19969d = 0;
        this.f19970e = 0;
        this.f19971f = 0.0f;
        this.f19972g = 0.0f;
    }
}
