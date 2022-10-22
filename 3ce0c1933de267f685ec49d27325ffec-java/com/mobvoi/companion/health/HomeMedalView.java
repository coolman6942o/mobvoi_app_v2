package com.mobvoi.companion.health;

import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.b;
import com.mobvoi.companion.R;
import j7.a;
import java.util.ArrayList;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
import so.c;
/* compiled from: HomeMedalView.kt */
/* loaded from: classes2.dex */
public final class HomeMedalView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f16724a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f16725b;

    /* renamed from: c  reason: collision with root package name */
    private final TextPaint f16726c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f16727d;

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f16728e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f16729f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f16730g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f16731h;

    /* renamed from: i  reason: collision with root package name */
    private final Drawable f16732i;

    /* renamed from: j  reason: collision with root package name */
    private Shader f16733j;

    /* renamed from: k  reason: collision with root package name */
    private final String f16734k;

    /* renamed from: l  reason: collision with root package name */
    private final String f16735l;

    /* renamed from: m  reason: collision with root package name */
    private String f16736m;

    /* renamed from: n  reason: collision with root package name */
    private String f16737n;

    /* renamed from: o  reason: collision with root package name */
    private int f16738o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16739p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f16740q;

    /* renamed from: r  reason: collision with root package name */
    private final ArrayList<RectF> f16741r;

    /* renamed from: s  reason: collision with root package name */
    private l3 f16742s;

    /* renamed from: t  reason: collision with root package name */
    private int f16743t;

    /* renamed from: u  reason: collision with root package name */
    private int f16744u;

    /* renamed from: v  reason: collision with root package name */
    private int f16745v;

    /* renamed from: w  reason: collision with root package name */
    private final PorterDuffXfermode f16746w;

    /* renamed from: x  reason: collision with root package name */
    private final Typeface f16747x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMedalView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        ArrayList<RectF> c10;
        b4 b4Var;
        b4 b4Var2;
        b4 b4Var3;
        b4 b4Var4;
        i.f(context, "context");
        this.f16724a = new Paint(1);
        this.f16725b = new TextPaint(1);
        this.f16726c = new TextPaint(1);
        this.f16727d = new Paint(1);
        this.f16728e = b.e(context, R.drawable.bg_home_tab_shadow_mask);
        this.f16731h = b.e(context, R.drawable.ic_home_tab_medal_explain);
        this.f16732i = b.e(context, R.drawable.ic_home_tab_medal_arrow);
        String string = context.getString(R.string.home_tab_medal_title);
        i.e(string, "context.getString(R.string.home_tab_medal_title)");
        this.f16734k = string;
        String string2 = context.getString(R.string.home_tab_medal_center_name);
        i.e(string2, "context.getString(R.string.home_tab_medal_center_name)");
        this.f16735l = string2;
        this.f16736m = "0";
        this.f16737n = "0";
        this.f16740q = new Rect();
        c10 = m.c(new RectF(), new RectF(), new RectF());
        this.f16741r = c10;
        this.f16746w = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.f16747x = h.h(context, R.font.sfuitext_medium);
        b4Var = s1.f16951a;
        this.f16729f = b.e(context, b4Var.f());
        b4Var2 = s1.f16951a;
        this.f16730g = b.e(context, b4Var2.a());
        b4Var3 = s1.f16951a;
        this.f16743t = b.c(context, b4Var3.d());
        b4Var4 = s1.f16951a;
        this.f16744u = b.c(context, b4Var4.b());
        this.f16745v = a.b(context, 16842801, -1);
    }

    private final void a(int i10, int i11) {
        Drawable drawable = this.f16728e;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, (int) (drawable.getIntrinsicHeight() * ((i10 * 1.0f) / drawable.getIntrinsicWidth())));
        }
        Drawable drawable2 = this.f16729f;
        if (drawable2 != null) {
            float f10 = i10 * 0.664f;
            drawable2.setBounds(0, 0, (int) f10, (int) (f10 * ((drawable2.getIntrinsicHeight() * 1.0f) / drawable2.getIntrinsicWidth())));
        }
        Drawable drawable3 = this.f16730g;
        if (drawable3 != null) {
            float f11 = i10 * 0.664f;
            drawable3.setBounds(0, 0, (int) f11, (int) (f11 * ((drawable3.getIntrinsicHeight() * 1.0f) / drawable3.getIntrinsicWidth())));
        }
        Drawable drawable4 = this.f16731h;
        if (drawable4 != null) {
            int i12 = (int) (i10 * 0.037333332f);
            drawable4.setBounds(0, 0, i12, i12);
        }
        Drawable drawable5 = this.f16732i;
        if (drawable5 != null) {
            float f12 = i10 * 0.013333334f;
            drawable5.setBounds(0, 0, (int) f12, (int) (f12 * ((drawable5.getIntrinsicHeight() * 1.0f) / drawable5.getIntrinsicWidth())));
        }
    }

    private final void c(Canvas canvas) {
        Drawable drawable;
        if (this.f16739p) {
            drawable = this.f16730g;
        } else {
            drawable = this.f16729f;
        }
        if (drawable != null) {
            canvas.save();
            canvas.translate(getWidth() - drawable.getBounds().width(), getWidth() * 0.104f);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    private final void d(Canvas canvas) {
        Drawable drawable;
        canvas.save();
        canvas.drawColor(this.f16745v);
        this.f16724a.setXfermode(this.f16746w);
        canvas.drawRect(0.0f, 0.0f, getWidth(), (getWidth() * 389.0f) / 375, this.f16724a);
        this.f16724a.setXfermode(null);
        canvas.restore();
        if (this.f16739p && (drawable = this.f16728e) != null) {
            drawable.draw(canvas);
        }
    }

    private final void e(Canvas canvas) {
        canvas.save();
        float f10 = 375;
        float width = (getWidth() * 16.0f) / f10;
        float width2 = (getWidth() * 120.0f) / f10;
        canvas.translate(width, (getWidth() * 52.0f) / f10);
        this.f16725b.setColor(-1);
        this.f16725b.setTextSize(h(14.0f));
        TextPaint textPaint = this.f16725b;
        String str = this.f16734k;
        textPaint.getTextBounds(str, 0, str.length(), this.f16740q);
        String str2 = this.f16734k;
        canvas.drawText(str2, 0, str2.length(), 0.0f, (this.f16740q.height() / 2) + g(this.f16725b), (Paint) this.f16725b);
        canvas.restore();
        Drawable drawable = this.f16731h;
        if (drawable != null) {
            canvas.save();
            canvas.translate(this.f16740q.width() + ((getWidth() * 20.0f) / f10), (getWidth() * 51.0f) / f10);
            drawable.draw(canvas);
            canvas.restore();
        }
        this.f16726c.setTypeface(this.f16747x);
        this.f16726c.setColor(-1);
        this.f16726c.setTextSize(h(36.0f));
        TextPaint textPaint2 = this.f16726c;
        String str3 = this.f16736m;
        textPaint2.getTextBounds(str3, 0, str3.length(), this.f16740q);
        float width3 = (getWidth() * 105.0f) / f10;
        String str4 = this.f16736m;
        canvas.drawText(str4, 0, str4.length(), width, width3, (Paint) this.f16726c);
        this.f16726c.setTextSize(h(20.0f));
        String n10 = i.n("/", this.f16737n);
        float f11 = 8;
        float width4 = width + this.f16740q.width() + f11;
        this.f16726c.getTextBounds(n10, 0, n10.length(), this.f16740q);
        float f12 = width3 - 4;
        canvas.drawText(n10, 0, n10.length(), width4, f12, (Paint) this.f16726c);
        String string = getContext().getString(R.string.home_tab_minutes);
        i.e(string, "context.getString(R.string.home_tab_minutes)");
        this.f16725b.setTextSize(h(16.0f));
        canvas.drawText(string, 0, string.length(), width4 + this.f16740q.width() + f11, f12, (Paint) this.f16725b);
        float width5 = (getWidth() * 137.0f) / f10;
        float width6 = (getWidth() * 12.0f) / f10;
        float f13 = width5 + width;
        float f14 = width6 + width2;
        float f15 = 2;
        float f16 = width6 / f15;
        this.f16727d.setStrokeWidth(1.0f);
        this.f16727d.setStyle(Paint.Style.STROKE);
        this.f16727d.setColor(-1);
        canvas.drawRoundRect(width, width2, f13, f14, f16, f16, this.f16727d);
        this.f16727d.setStyle(Paint.Style.FILL);
        this.f16727d.setColor(-1);
        int i10 = this.f16738o;
        if (i10 > 100) {
            i10 = 100;
        }
        canvas.save();
        canvas.clipRect(width, width2, ((width5 * i10) / 100) + width, f14);
        canvas.drawRoundRect(width + f15, width2 + f15, f13 - f15, f14 - f15, f16, f16, this.f16727d);
        canvas.restore();
        String str5 = getContext().getString(R.string.home_tab_complete_percent_prefix) + ' ' + this.f16738o + '%';
        this.f16725b.setTextSize(h(12.0f));
        canvas.drawText(str5, 0, str5.length(), width, (getWidth() * 153.0f) / f10, (Paint) this.f16725b);
        canvas.save();
        canvas.translate(width, (getWidth() * 217.0f) / f10);
        this.f16725b.setTextSize(h(14.0f));
        this.f16725b.setColor(a.b(getContext(), 16842806, -16777216));
        TextPaint textPaint3 = this.f16725b;
        String str6 = this.f16735l;
        textPaint3.getTextBounds(str6, 0, str6.length(), this.f16740q);
        String str7 = this.f16735l;
        canvas.drawText(str7, 0, str7.length(), 0.0f, g(this.f16725b) + (this.f16740q.height() / 2), (Paint) this.f16725b);
        canvas.restore();
        Drawable drawable2 = this.f16732i;
        if (drawable2 != null) {
            canvas.save();
            canvas.translate(((getWidth() * 21.0f) / f10) + this.f16740q.width(), (getWidth() * 220.0f) / f10);
            drawable2.draw(canvas);
            canvas.restore();
        }
    }

    private final void f(RectF rectF, int i10) {
        float f10 = (i10 * 15.0f) / 375;
        rectF.left -= f10;
        rectF.right += f10;
        rectF.top -= f10;
        rectF.bottom += f10;
    }

    private final float g(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f10 = fontMetrics.descent;
        return ((f10 - fontMetrics.ascent) / 2) - f10;
    }

    private final float h(float f10) {
        return TypedValue.applyDimension(2, f10, Resources.getSystem().getDisplayMetrics());
    }

    public final void b(int i10) {
        if (i10 >= 0 && i10 < s1.b().length) {
            b4 b4Var = s1.b()[i10];
            Context context = getContext();
            i.e(context, "context");
            this.f16743t = b4Var.e(context);
            Context context2 = getContext();
            i.e(context2, "context");
            this.f16744u = b4Var.c(context2);
            Drawable e10 = b.e(getContext(), b4Var.f());
            this.f16729f = e10;
            if (e10 != null) {
                e10.setBounds(0, 0, (int) (getWidth() * 0.664f), (int) (getWidth() * 0.664f * ((e10.getIntrinsicHeight() * 1.0f) / e10.getIntrinsicWidth())));
            }
            Drawable e11 = b.e(getContext(), b4Var.a());
            this.f16730g = e11;
            if (e11 != null) {
                e11.setBounds(0, 0, (int) (getWidth() * 0.664f), (int) (getWidth() * 0.664f * ((e11.getIntrinsicHeight() * 1.0f) / e11.getIntrinsicWidth())));
            }
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (getWidth() * 389.0f) / 375, new int[]{this.f16743t, this.f16744u}, (float[]) null, Shader.TileMode.CLAMP);
            this.f16733j = linearGradient;
            this.f16724a.setShader(linearGradient);
            invalidate();
        }
    }

    public final void i(int i10, int i11) {
        int i12 = 0;
        this.f16739p = i10 >= i11;
        this.f16736m = String.valueOf(i10);
        this.f16737n = String.valueOf(i11);
        if (i11 != 0) {
            i12 = c.b((i10 * 100) / i11);
        }
        this.f16738o = i12;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        d(canvas);
        c(canvas);
        e(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        Rect bounds;
        Rect bounds2;
        Rect bounds3;
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = i10;
        float f11 = 375;
        int i14 = 0;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (389.0f * f10) / f11, new int[]{this.f16743t, this.f16744u}, (float[]) null, Shader.TileMode.CLAMP);
        this.f16733j = linearGradient;
        this.f16724a.setShader(linearGradient);
        a(i10, i11);
        this.f16725b.setTextSize(h(14.0f));
        TextPaint textPaint = this.f16725b;
        String str = this.f16734k;
        textPaint.getTextBounds(str, 0, str.length(), this.f16740q);
        RectF rectF = this.f16741r.get(0);
        float width = this.f16740q.width() + ((5.0f * f10) / f11);
        rectF.left = width;
        Drawable drawable = this.f16731h;
        rectF.right = width + ((drawable == null || (bounds3 = drawable.getBounds()) == null) ? 0 : bounds3.width());
        float f12 = (51.0f * f10) / f11;
        rectF.top = f12;
        Drawable drawable2 = this.f16731h;
        rectF.bottom = f12 + ((drawable2 == null || (bounds2 = drawable2.getBounds()) == null) ? 0 : bounds2.height());
        RectF rectF2 = this.f16741r.get(0);
        i.e(rectF2, "clickArea[0]");
        f(rectF2, i10);
        TextPaint textPaint2 = this.f16725b;
        String str2 = this.f16735l;
        textPaint2.getTextBounds(str2, 0, str2.length(), this.f16740q);
        RectF rectF3 = this.f16741r.get(1);
        rectF3.left = (16.0f * f10) / f11;
        float f13 = (77.0f * f10) / f11;
        Drawable drawable3 = this.f16732i;
        if (!(drawable3 == null || (bounds = drawable3.getBounds()) == null)) {
            i14 = bounds.width();
        }
        rectF3.right = f13 + i14;
        float f14 = (217.0f * f10) / f11;
        rectF3.top = f14;
        rectF3.bottom = f14 + this.f16740q.height();
        RectF rectF4 = this.f16741r.get(1);
        i.e(rectF4, "clickArea[1]");
        f(rectF4, i10);
        RectF rectF5 = this.f16741r.get(2);
        rectF5.left = (140.0f * f10) / f11;
        rectF5.right = f10;
        rectF5.top = (52.0f * f10) / f11;
        rectF5.bottom = (f10 * 231.0f) / f11;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l3 l3Var;
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 1) {
            if (this.f16741r.get(0).contains(motionEvent.getX(), motionEvent.getY())) {
                l3 l3Var2 = this.f16742s;
                if (l3Var2 != null) {
                    l3Var2.a();
                }
            } else if ((this.f16741r.get(1).contains(motionEvent.getX(), motionEvent.getY()) || this.f16741r.get(2).contains(motionEvent.getX(), motionEvent.getY())) && (l3Var = this.f16742s) != null) {
                l3Var.b();
            }
        }
        return true;
    }

    public final void setOnClickListener(l3 listener) {
        i.f(listener, "listener");
        this.f16742s = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeMedalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
