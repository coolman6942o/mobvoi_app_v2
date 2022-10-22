package com.mobvoi.companion.health;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.b;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: HomePressureChart.kt */
/* loaded from: classes2.dex */
public final class HomePressureChart extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f16748a;

    /* renamed from: b  reason: collision with root package name */
    private float f16749b;

    /* renamed from: c  reason: collision with root package name */
    private float f16750c;

    /* renamed from: d  reason: collision with root package name */
    private float f16751d;

    /* renamed from: e  reason: collision with root package name */
    private float f16752e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16753f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16754g;

    /* renamed from: h  reason: collision with root package name */
    private final int f16755h;

    /* renamed from: i  reason: collision with root package name */
    private final int f16756i;

    /* renamed from: j  reason: collision with root package name */
    private int f16757j;

    /* compiled from: HomePressureChart.kt */
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
    public HomePressureChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f16748a = new Paint(1);
        this.f16753f = b.c(context, R.color.home_tab_pressure_low_color);
        this.f16754g = b.c(context, R.color.home_tab_pressure_middle_color);
        this.f16755h = b.c(context, R.color.home_tab_pressure_normal_color);
        this.f16756i = b.c(context, R.color.home_tab_pressure_high_color);
    }

    private final float a(boolean z10) {
        float f10;
        float f11;
        if (z10) {
            f10 = getHeight();
            f11 = this.f16751d;
        } else {
            f10 = getHeight();
            f11 = this.f16752e;
        }
        return f10 - f11;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        this.f16748a.setColor(this.f16753f);
        boolean z10 = false;
        canvas.drawRect(0.0f, a(this.f16757j == 1), this.f16749b, getHeight(), this.f16748a);
        this.f16748a.setColor(this.f16754g);
        float f10 = 2;
        canvas.drawRect(this.f16749b + this.f16750c, a(this.f16757j == 2), (this.f16749b * f10) + this.f16750c, getHeight(), this.f16748a);
        this.f16748a.setColor(this.f16755h);
        float f11 = 3;
        canvas.drawRect((this.f16749b * f10) + (this.f16750c * f10), a(this.f16757j == 3), (this.f16749b * f11) + (f10 * this.f16750c), getHeight(), this.f16748a);
        this.f16748a.setColor(this.f16756i);
        float f12 = (this.f16749b * f11) + (f11 * this.f16750c);
        if (this.f16757j == 4) {
            z10 = true;
        }
        canvas.drawRect(f12, a(z10), getWidth(), getHeight(), this.f16748a);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        setMeasuredDimension(size, (int) (size * 0.11188811f));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = i10;
        this.f16750c = 0.006993007f * f10;
        this.f16749b = 0.24475524f * f10;
        this.f16751d = 0.11188811f * f10;
        this.f16752e = f10 * 0.04195804f;
    }

    public final void setPressureLevel(int i10) {
        this.f16757j = i10;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomePressureChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
