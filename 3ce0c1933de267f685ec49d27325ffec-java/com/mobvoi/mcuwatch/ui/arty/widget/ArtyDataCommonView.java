package com.mobvoi.mcuwatch.ui.arty.widget;

import a0.h;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.companion.health.widget.arty.a;
import com.mobvoi.mcuwatch.ui.arty.ArtyDetailActivity;
import com.mobvoi.wear.util.DimensionUtils;
import gg.c;
import sh.d;
import sh.e;
import sh.f;
import sh.g;
import sh.k;
import sh.m;
/* loaded from: classes2.dex */
public class ArtyDataCommonView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19349a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f19350b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f19351c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f19352d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19353e;

    /* renamed from: f  reason: collision with root package name */
    private String f19354f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19355g;

    /* renamed from: h  reason: collision with root package name */
    private String f19356h;

    /* renamed from: i  reason: collision with root package name */
    private String f19357i;

    /* renamed from: j  reason: collision with root package name */
    private final float f19358j;

    /* renamed from: k  reason: collision with root package name */
    private int f19359k;

    /* renamed from: l  reason: collision with root package name */
    private int f19360l;

    /* renamed from: m  reason: collision with root package name */
    private float f19361m;

    /* renamed from: n  reason: collision with root package name */
    private int f19362n;

    /* renamed from: o  reason: collision with root package name */
    private int f19363o;

    /* renamed from: p  reason: collision with root package name */
    private int f19364p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19365q;

    /* renamed from: r  reason: collision with root package name */
    private int[] f19366r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f19367s;

    /* renamed from: t  reason: collision with root package name */
    private final int[] f19368t;

    public ArtyDataCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setShortCutBitmap(int i10) {
        int i11 = this.f19359k;
        if (i11 == 1) {
            this.f19352d = BitmapFactory.decodeResource(getResources(), f.f34567m1);
        } else if (i11 == 4) {
            this.f19352d = BitmapFactory.decodeResource(getResources(), f.G0);
        } else {
            int l10 = a.f17142a.l(i11, i10);
            int i12 = this.f19359k;
            if (i12 == 2) {
                this.f19352d = BitmapFactory.decodeResource(getResources(), this.f19366r[l10]);
            } else if (i12 == 3) {
                this.f19352d = BitmapFactory.decodeResource(getResources(), this.f19367s[l10]);
            }
        }
    }

    public int a(int i10, int i11) {
        int i12;
        int i13 = d.f34457q;
        if (i10 == 1) {
            return i13;
        }
        if (i10 != 2) {
            if (i10 != 3 || i11 <= 0) {
                return i13;
            }
            i12 = d.f34458r;
        } else if (i11 > 0) {
            return i13;
        } else {
            i12 = d.f34458r;
        }
        return i12;
    }

    public void b() {
        Intent intent = new Intent();
        intent.setClass(this.f19349a, ArtyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("data_type", this.f19359k);
        bundle.putInt("extra_diff_value", this.f19360l);
        intent.putExtras(bundle);
        this.f19349a.startActivity(intent);
    }

    public void c(int i10) {
        this.f19359k = i10;
        this.f19352d = BitmapFactory.decodeResource(getResources(), this.f19368t[i10]);
        this.f19354f = "- ";
        postInvalidate();
    }

    public void d(int i10, c cVar) {
        this.f19359k = i10;
        int a10 = gg.d.a(i10, cVar.f27461e);
        this.f19360l = a10;
        this.f19362n = a(this.f19359k, a10);
        setShortCutBitmap(cVar.f27461e);
        if (cVar instanceof gg.a) {
            gg.a aVar = (gg.a) cVar;
            boolean j10 = ad.a.f168a.j();
            this.f19365q = j10;
            if (j10) {
                this.f19354f = aVar.f27457a + "-" + aVar.f27452h;
            } else {
                this.f19354f = aVar.f27461e + "-" + aVar.f27455k;
            }
        } else {
            this.f19354f = String.valueOf(cVar.f27461e);
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        this.f19350b.setColor(getResources().getColor(d.f34444b0, null));
        Bitmap bitmap = this.f19352d;
        float f10 = this.f19358j;
        canvas.drawBitmap(bitmap, f10, f10, this.f19350b);
        Paint paint = this.f19350b;
        Resources resources = getResources();
        int i10 = e.f34506o;
        paint.setTextSize(resources.getDimension(i10));
        this.f19350b.setColor(this.f19363o);
        float measureText = this.f19350b.measureText(this.f19353e);
        Paint.FontMetrics fontMetrics = this.f19350b.getFontMetrics();
        canvas.drawText(this.f19353e, this.f19358j + (measureText / 2.0f), (getResources().getDimension(e.f34504n) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f), this.f19350b);
        this.f19350b.setTextSize(this.f19361m);
        Paint.FontMetrics fontMetrics2 = this.f19350b.getFontMetrics();
        canvas.drawText(this.f19356h, this.f19358j + measureText + getResources().getDimension(e.E0) + (this.f19350b.measureText(this.f19356h) / 2.0f), (getResources().getDimension(e.F0) + ((fontMetrics2.bottom - fontMetrics2.top) / 2.0f)) - ((fontMetrics2.descent + fontMetrics2.ascent) / 2.0f), this.f19350b);
        this.f19351c.setTextSize(getResources().getDimension(e.f34510q));
        this.f19351c.setColor(this.f19363o);
        Paint.FontMetrics fontMetrics3 = this.f19351c.getFontMetrics();
        float dimension = (getResources().getDimension(e.f34512r) + ((fontMetrics3.bottom - fontMetrics3.top) / 2.0f)) - ((fontMetrics3.descent + fontMetrics3.ascent) / 2.0f);
        this.f19350b.setTextSize(getResources().getDimension(e.f34508p));
        this.f19350b.setColor(this.f19364p);
        if (this.f19359k == 4 && !TextUtils.equals(this.f19354f, "- ")) {
            this.f19351c.setTextSize(getResources().getDimension(e.f34502m));
            if (this.f19365q) {
                dimension -= DimensionUtils.dp2px(this.f19349a, 10.0f);
                float measureText2 = this.f19350b.measureText(this.f19357i);
                Paint.FontMetrics fontMetrics4 = this.f19351c.getFontMetrics();
                canvas.drawText(this.f19357i, this.f19358j + (measureText2 / 2.0f), ((fontMetrics4.bottom - fontMetrics4.top) / 2.0f) + dimension, this.f19350b);
            }
        }
        float measureText3 = this.f19351c.measureText(this.f19354f);
        canvas.drawText(this.f19354f, this.f19358j + (measureText3 / 2.0f), dimension, this.f19351c);
        canvas.drawText(this.f19355g, this.f19358j + measureText3 + getResources().getDimension(e.I0) + (this.f19350b.measureText(this.f19355g) / 2.0f), dimension, this.f19350b);
        if (this.f19360l != 0) {
            this.f19351c.setTextSize(getResources().getDimension(i10));
            this.f19351c.setColor(getResources().getColor(this.f19362n, null));
            float width = (getWidth() - this.f19358j) - (this.f19350b.measureText(String.valueOf(this.f19360l)) / 2.0f);
            int i11 = this.f19360l;
            if (i11 > 0) {
                str = "+" + this.f19360l;
            } else {
                str = String.valueOf(i11);
            }
            canvas.drawText(str, width, getResources().getDimension(e.f34524x) - this.f19351c.getFontMetrics().ascent, this.f19351c);
        }
    }

    public ArtyDataCommonView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19360l = 0;
        this.f19362n = 0;
        this.f19365q = false;
        this.f19366r = new int[]{f.O, f.N, f.Q, f.P};
        this.f19367s = new int[]{f.T, f.S, f.V, f.U};
        this.f19368t = new int[]{f.K0, f.f34564l1, f.W0, f.f34534b1, f.F0};
        this.f19349a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f34907a);
        int resourceId = obtainStyledAttributes.getResourceId(m.f34909c, -1);
        this.f19353e = obtainStyledAttributes.getString(m.f34908b);
        this.f19354f = obtainStyledAttributes.getString(m.f34911e);
        this.f19355g = obtainStyledAttributes.getString(m.f34910d);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f19350b = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f19351c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        this.f19363o = j7.a.e(this, sh.c.f34441c, -16777216);
        this.f19364p = j7.a.e(this, sh.c.f34440b, -7829368);
        paint.setTypeface(h.h(context, g.f34608b));
        paint2.setTypeface(h.h(context, g.f34607a));
        setElevation(DimensionUtils.dp2px(context, 2.0f));
        this.f19352d = BitmapFactory.decodeResource(getResources(), resourceId);
        this.f19358j = getResources().getDimension(e.f34479e);
        this.f19356h = getResources().getString(k.K);
        this.f19357i = getResources().getString(k.z_res_0x7f140107);
        this.f19361m = getResources().getDimension(e.G0);
    }
}
