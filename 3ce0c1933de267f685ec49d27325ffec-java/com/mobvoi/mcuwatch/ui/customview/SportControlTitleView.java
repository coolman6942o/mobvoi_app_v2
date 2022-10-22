package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import j7.a;
import mj.b;
import mj.n;
import sh.c;
import sh.d;
import sh.e;
import sh.k;
/* loaded from: classes2.dex */
public class SportControlTitleView extends View implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f19602a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f19603b;

    /* renamed from: c  reason: collision with root package name */
    private int f19604c;

    /* renamed from: d  reason: collision with root package name */
    private final float f19605d;

    /* renamed from: e  reason: collision with root package name */
    private final float f19606e;

    /* renamed from: f  reason: collision with root package name */
    private final float f19607f;

    /* renamed from: g  reason: collision with root package name */
    private final float f19608g;

    /* renamed from: h  reason: collision with root package name */
    private final float f19609h;

    /* renamed from: i  reason: collision with root package name */
    private final float f19610i;

    /* renamed from: j  reason: collision with root package name */
    private int f19611j;

    /* renamed from: k  reason: collision with root package name */
    private String f19612k;

    /* renamed from: l  reason: collision with root package name */
    private n f19613l;

    /* renamed from: m  reason: collision with root package name */
    Paint.FontMetrics f19614m;

    /* renamed from: n  reason: collision with root package name */
    private int f19615n;

    public SportControlTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(int i10) {
        n nVar = this.f19613l;
        if (nVar != null) {
            nVar.j(i10);
        }
    }

    @Override // mj.b
    public void a(int i10) {
        this.f19611j = i10;
        if (i10 == 4) {
            postInvalidate();
        }
    }

    @Override // mj.b
    public void d(int i10) {
        this.f19604c = i10;
        if (i10 == 0) {
            this.f19612k = getResources().getString(k.f34835m2);
        } else if (i10 == 1) {
            this.f19612k = getResources().getString(k.T2);
        } else if (i10 == 2) {
            this.f19612k = getResources().getString(k.f34830l2);
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f19611j == 4) {
            this.f19603b.setColor(this.f19615n);
            Paint.FontMetrics fontMetrics = this.f19614m;
            canvas.drawText(this.f19612k, getWidth() / 2.0f, (getHeight() / 2.0f) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f), this.f19603b);
            return;
        }
        for (int i10 = 0; i10 < this.f19602a.length; i10++) {
            float f10 = (this.f19605d / 2.0f) + (i10 * this.f19608g);
            if (i10 == this.f19604c) {
                this.f19603b.setColor(getResources().getColor(d.Z, null));
                this.f19603b.setStrokeWidth(this.f19610i);
                canvas.drawLine(f10 - (this.f19609h / 2.0f), getHeight() - (this.f19610i / 2.0f), f10 + (this.f19609h / 2.0f), getHeight() - (this.f19610i / 2.0f), this.f19603b);
            } else {
                this.f19603b.setColor(this.f19615n);
            }
            String str = this.f19602a[i10];
            Paint.FontMetrics fontMetrics2 = this.f19614m;
            canvas.drawText(str, f10, (getHeight() / 2.0f) + ((fontMetrics2.descent - fontMetrics2.ascent) / 2.0f), this.f19603b);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) ((this.f19605d / 2.0f) + (this.f19608g * 2.0f) + (this.f19607f / 2.0f)), Integer.MIN_VALUE), i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 && this.f19611j == 0) {
            float x10 = motionEvent.getX();
            if (x10 < 0.0f || x10 > this.f19605d) {
                float f10 = this.f19605d;
                float f11 = this.f19608g;
                float f12 = this.f19606e;
                if (x10 < ((f10 / 2.0f) + f11) - (f12 / 2.0f) || x10 > (f10 / 2.0f) + f11 + (f12 / 2.0f)) {
                    if (x10 >= getWidth() - this.f19607f && x10 <= getWidth() && this.f19604c != 2) {
                        b(2);
                    }
                } else if (this.f19604c != 1) {
                    b(1);
                }
            } else if (this.f19604c != 0) {
                b(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setWorkShortPresenter(n nVar) {
        this.f19613l = nVar;
    }

    public SportControlTitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19615n = a.b(context, c.f34440b, -7829368);
        float dimension = getResources().getDimension(e.f34496j1);
        this.f19608g = getResources().getDimension(e.f34493i1);
        this.f19609h = getResources().getDimension(e.f34475c1);
        this.f19610i = getResources().getDimension(e.f34472b1);
        Paint paint = new Paint(1);
        this.f19603b = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(dimension);
        paint.setTextAlign(Paint.Align.CENTER);
        String[] strArr = {getResources().getString(k.D1), getResources().getString(k.E1), getResources().getString(k.C1)};
        this.f19602a = strArr;
        this.f19605d = paint.measureText(strArr[0]);
        this.f19606e = paint.measureText(strArr[1]);
        this.f19607f = paint.measureText(strArr[2]);
        this.f19614m = paint.getFontMetrics();
    }
}
