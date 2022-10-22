package com.mobvoi.health.companion.sport.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.wear.util.DimensionUtils;
import fg.o;
import fg.p;
import fg.u;
/* loaded from: classes2.dex */
public class PercentView extends View {

    /* renamed from: a  reason: collision with root package name */
    private RectF f18895a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f18896b;

    /* renamed from: c  reason: collision with root package name */
    private Path f18897c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f18898d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f18899e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f18900f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f18901g;

    /* renamed from: h  reason: collision with root package name */
    private int f18902h;

    /* renamed from: i  reason: collision with root package name */
    private String f18903i;

    /* renamed from: j  reason: collision with root package name */
    private int f18904j;

    /* renamed from: k  reason: collision with root package name */
    private int f18905k;

    /* renamed from: l  reason: collision with root package name */
    private LinearGradient f18906l;

    /* renamed from: m  reason: collision with root package name */
    private LinearGradient f18907m;

    /* renamed from: n  reason: collision with root package name */
    private float f18908n;

    /* renamed from: o  reason: collision with root package name */
    private float f18909o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f18910p;

    /* renamed from: q  reason: collision with root package name */
    private float f18911q;

    public PercentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        Resources resources = getResources();
        this.f18898d.setStyle(Paint.Style.STROKE);
        this.f18898d.setColor(resources.getColor(o.J));
        this.f18898d.setStrokeWidth(resources.getDimensionPixelOffset(p.C));
        this.f18899e.setColor(resources.getColor(o.I));
        this.f18899e.setStyle(Paint.Style.FILL);
        this.f18900f.setTextSize(resources.getDimensionPixelSize(p.I));
        this.f18900f.setStyle(Paint.Style.FILL);
        this.f18900f.setColor(-7829368);
        this.f18905k = resources.getDimensionPixelSize(p.f26525p);
        this.f18903i = this.f18902h + getResources().getString(u.X2);
    }

    public void b(int i10, SportType sportType) {
        this.f18902h = i10;
        this.f18911q = DimensionUtils.dp2px(getContext(), 24.0f);
        this.f18910p = b.e(getContext(), a.d().e(sportType).f18992a);
        this.f18904j = (int) Math.sqrt(Math.pow(this.f18911q / 2.0f, 2.0d) * 2.0d);
        String str = this.f18902h + getResources().getString(u.X2);
        this.f18903i = str;
        this.f18900f.getTextBounds(str, 0, str.length(), this.f18896b);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        canvas.drawArc(this.f18895a, -180.0f, 180.0f, false, this.f18898d);
        canvas.drawPath(this.f18897c, this.f18901g);
        this.f18908n = (width * Math.min(this.f18902h, 100)) / 100.0f;
        float sqrt = height - ((height / 2.0f) * ((float) Math.sqrt(1.0d - Math.pow(0.5d - (f10 / 100.0f), 2.0d))));
        this.f18909o = sqrt;
        int i10 = this.f18902h;
        if (i10 >= 100) {
            this.f18908n -= this.f18904j;
            this.f18909o = sqrt + this.f18905k;
        }
        float f11 = this.f18908n;
        int i11 = this.f18904j;
        if (f11 <= i11) {
            this.f18908n = i11;
            this.f18909o += this.f18905k;
        }
        if (i10 >= 0) {
            canvas.drawCircle(this.f18908n, this.f18909o, i11, this.f18899e);
            Drawable drawable = this.f18910p;
            if (drawable != null) {
                float f12 = this.f18908n;
                float f13 = this.f18911q;
                float f14 = this.f18909o;
                drawable.setBounds((int) (f12 - (f13 / 2.0f)), (int) (f14 - (f13 / 2.0f)), (int) (f12 + (f13 / 2.0f)), (int) (f14 + (f13 / 2.0f)));
                this.f18910p.draw(canvas);
            }
            float measureText = this.f18900f.measureText(this.f18903i);
            float f15 = this.f18908n - (measureText / 2.0f);
            if (f15 < 0.0f) {
                f15 = 0.0f;
            } else if (f15 + measureText > width) {
                f15 = width - measureText;
            }
            canvas.drawText(this.f18903i, f15, (this.f18909o - this.f18904j) - this.f18905k, this.f18900f);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f18906l == null) {
            LinearGradient linearGradient = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + getMeasuredWidth(), getPaddingTop() + getMeasuredHeight(), getResources().getColor(o.J), getResources().getColor(o.I), Shader.TileMode.CLAMP);
            this.f18906l = linearGradient;
            this.f18898d.setShader(linearGradient);
        }
        float f10 = i10;
        float f11 = i11;
        this.f18895a.set(0.0f, i11 / 2, f10, f11);
        this.f18897c.reset();
        this.f18897c.addArc(this.f18895a, -180.0f, 180.0f);
        this.f18897c.lineTo(f10, f11);
        this.f18897c.lineTo(0.0f, f11);
        LinearGradient linearGradient2 = new LinearGradient(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop() + getMeasuredHeight(), getResources().getColor(o.J), getResources().getColor(17170445), Shader.TileMode.CLAMP);
        this.f18907m = linearGradient2;
        this.f18901g.setShader(linearGradient2);
    }

    public PercentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18895a = new RectF();
        this.f18896b = new Rect();
        this.f18897c = new Path();
        this.f18898d = new Paint(1);
        this.f18899e = new Paint(1);
        this.f18900f = new Paint(1);
        this.f18901g = new Paint(1);
        this.f18904j = 30;
        this.f18905k = 10;
        a();
    }
}
