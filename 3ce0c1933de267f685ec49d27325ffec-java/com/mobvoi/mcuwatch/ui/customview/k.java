package com.mobvoi.mcuwatch.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.mobvoi.wear.util.DimensionUtils;
import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.d;
/* compiled from: ArtyTipsDrawable.kt */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public final class k extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f19661a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f19662b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f19663c;

    /* renamed from: d  reason: collision with root package name */
    private final float f19664d;

    public /* synthetic */ k(Context context, AttributeSet attributeSet, int i10, f fVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i.f(canvas, "canvas");
        this.f19662b.reset();
        this.f19662b.moveTo(0.0f, 0.0f);
        RectF rectF = this.f19663c;
        float f10 = this.f19664d;
        double d10 = 0.0f;
        rectF.set(0.0f - ((3 * f10) / 2.0f), (float) (d10 - (f10 * 0.134d)), (f10 / 2.0f) + 0.0f, (float) (d10 + (f10 * 1.866d)));
        this.f19662b.arcTo(this.f19663c, 300.0f, 60.0f);
        this.f19662b.lineTo((this.f19664d / 2.0f) + 0.0f, getBounds().height() - this.f19664d);
        float f11 = 2;
        float f12 = this.f19664d;
        this.f19663c.set((this.f19664d / 2.0f) + 0.0f, getBounds().height() - (f11 * f12), (f12 * f11) + 0.0f, getBounds().height());
        this.f19662b.arcTo(this.f19663c, 180.0f, -90.0f);
        this.f19662b.lineTo(getBounds().width() - this.f19664d, getBounds().height());
        this.f19663c.set(getBounds().width() - (this.f19664d * f11), getBounds().height() - (this.f19664d * f11), getBounds().width(), getBounds().height());
        this.f19662b.arcTo(this.f19663c, 90.0f, -90.0f);
        this.f19662b.lineTo(getBounds().width(), getBounds().height() - this.f19664d);
        this.f19663c.set(getBounds().width() - (this.f19664d * f11), 0.0f, getBounds().width(), (f11 * this.f19664d) + 0.0f);
        this.f19662b.arcTo(this.f19663c, 0.0f, -90.0f);
        this.f19662b.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.f19662b, this.f19661a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        i.f(bounds, "bounds");
        super.onBoundsChange(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public k(Context context, AttributeSet attributeSet) {
        i.f(context, "context");
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(d.f34446f));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        m mVar = m.f28349a;
        this.f19661a = paint;
        this.f19662b = new Path();
        this.f19663c = new RectF();
        this.f19664d = DimensionUtils.dp2px(context, 15.0f);
    }
}
