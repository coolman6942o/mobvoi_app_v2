package com.mobvoi.companion.health;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import so.c;
/* compiled from: HealthCircleView.kt */
/* loaded from: classes2.dex */
public final class HealthCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f16699a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f16700b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16701c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16702d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16703e;

    /* renamed from: f  reason: collision with root package name */
    private int f16704f;

    /* renamed from: g  reason: collision with root package name */
    private int f16705g;

    /* renamed from: h  reason: collision with root package name */
    private int f16706h;

    /* compiled from: HealthCircleView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthCircleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f16699a = new Paint(1);
        this.f16700b = new RectF();
        this.f16701c = b.c(context, R.color.home_tab_exercise_color);
        this.f16702d = b.c(context, R.color.home_tab_move_color);
        this.f16703e = b.c(context, R.color.home_tab_steps_color);
    }

    private final int a(int i10) {
        if (i10 < 0) {
            return 0;
        }
        if (i10 > 100) {
            return 100;
        }
        return i10;
    }

    public final void b(int i10, int i11, int i12) {
        this.f16704f = a(i11);
        this.f16705g = a(i10);
        this.f16706h = a(i12);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int b10;
        int b11;
        int b12;
        i.f(canvas, "canvas");
        this.f16699a.setColor(this.f16703e);
        Paint paint = this.f16699a;
        b10 = c.b(76.5f);
        paint.setAlpha(b10);
        canvas.save();
        canvas.rotate(-75.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawArc(this.f16700b, 0.0f, 90.0f, false, this.f16699a);
        int i10 = this.f16706h;
        boolean z10 = false;
        if (1 <= i10 && i10 <= 100) {
            this.f16699a.setAlpha(255);
            canvas.drawArc(this.f16700b, 0.0f, (this.f16706h / 100.0f) * 90.0f, false, this.f16699a);
        }
        canvas.restore();
        this.f16699a.setColor(this.f16701c);
        Paint paint2 = this.f16699a;
        b11 = c.b(76.5f);
        paint2.setAlpha(b11);
        canvas.save();
        canvas.rotate(45.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawArc(this.f16700b, 0.0f, 90.0f, false, this.f16699a);
        int i11 = this.f16704f;
        if (1 <= i11 && i11 <= 100) {
            this.f16699a.setAlpha(255);
            canvas.drawArc(this.f16700b, 0.0f, (this.f16704f / 100.0f) * 90.0f, false, this.f16699a);
        }
        canvas.restore();
        this.f16699a.setColor(this.f16702d);
        Paint paint3 = this.f16699a;
        b12 = c.b(76.5f);
        paint3.setAlpha(b12);
        canvas.save();
        canvas.rotate(165.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawArc(this.f16700b, 0.0f, 90.0f, false, this.f16699a);
        int i12 = this.f16705g;
        if (1 <= i12 && i12 <= 100) {
            z10 = true;
        }
        if (z10) {
            this.f16699a.setAlpha(255);
            canvas.drawArc(this.f16700b, 0.0f, (this.f16705g / 100.0f) * 90.0f, false, this.f16699a);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        setMeasuredDimension(size, size);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f16699a.setStyle(Paint.Style.STROKE);
        this.f16699a.setStrokeCap(Paint.Cap.ROUND);
        float f10 = i10;
        float f11 = 0.125f * f10;
        this.f16699a.setStrokeWidth(f11);
        RectF rectF = this.f16700b;
        float f12 = f11 / 2;
        rectF.left = f12;
        rectF.right = f10 - f12;
        rectF.top = f12;
        rectF.bottom = i11 - f12;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HealthCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
