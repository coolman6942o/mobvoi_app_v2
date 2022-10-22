package com.mobvoi.companion.aw.watchfacecenter.widget;

import a0.h;
import aa.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.q;
import com.mobvoi.companion.aw.watchfacecenter.n;
import com.mobvoi.companion.aw.watchfacecenter.o;
import com.mobvoi.companion.aw.watchfacecenter.s;
import com.mobvoi.companion.aw.watchfacecenter.t;
import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ImageWatchFaceMask.kt */
/* loaded from: classes2.dex */
public final class ImageWatchFaceMask extends q {

    /* renamed from: w  reason: collision with root package name */
    private static final b[] f16493w = {new b(0.51578945f, 0.17324561f, 0.06140351f), new b(0.3002193f, 0.17763157f, 0.07236842f), new b(0.18311404f, 0.42543858f, 0.25877193f), new b(0.49122807f, 0.91885966f, 0.06140351f), new b(0.42105263f, 0.89912283f, 0.0f)};

    /* renamed from: x  reason: collision with root package name */
    private static final b[] f16494x = {new b(0.51578945f, 0.57236844f, 0.06140351f), new b(0.3002193f, 0.5767544f, 0.07236842f), new b(0.18311404f, 0.82894737f, 0.25877193f), new b(0.49122807f, 0.91885966f, 0.06140351f), new b(0.42105263f, 0.89912283f, 0.0f)};

    /* renamed from: y  reason: collision with root package name */
    private static final b[] f16495y = {new b(0.51578945f, 0.37280703f, 0.06140351f), new b(0.3002193f, 0.37719297f, 0.07236842f), new b(0.18311404f, 0.62938595f, 0.25877193f), new b(0.49122807f, 0.91885966f, 0.06140351f), new b(0.42105263f, 0.89912283f, 0.0f)};

    /* renamed from: d  reason: collision with root package name */
    private int f16496d;

    /* renamed from: e  reason: collision with root package name */
    private Typeface f16497e;

    /* renamed from: f  reason: collision with root package name */
    private Typeface f16498f;

    /* renamed from: g  reason: collision with root package name */
    private final String f16499g;

    /* renamed from: h  reason: collision with root package name */
    private final String f16500h;

    /* renamed from: i  reason: collision with root package name */
    private final String f16501i;

    /* renamed from: j  reason: collision with root package name */
    private final String f16502j;

    /* renamed from: k  reason: collision with root package name */
    private final int f16503k;

    /* renamed from: l  reason: collision with root package name */
    private final Drawable f16504l;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f16505m;

    /* renamed from: n  reason: collision with root package name */
    private final Paint f16506n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f16507o;

    /* renamed from: p  reason: collision with root package name */
    private final Path f16508p;

    /* renamed from: q  reason: collision with root package name */
    private final RectF f16509q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16510r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f16511s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f16512t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f16513u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f16514v;

    /* compiled from: ImageWatchFaceMask.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageWatchFaceMask.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final float f16515a;

        /* renamed from: b  reason: collision with root package name */
        private final float f16516b;

        /* renamed from: c  reason: collision with root package name */
        private final float f16517c;

        public b(float f10, float f11, float f12) {
            this.f16515a = f10;
            this.f16516b = f11;
            this.f16517c = f12;
        }

        public final float a() {
            return this.f16517c;
        }

        public final float b() {
            return this.f16515a;
        }

        public final float c() {
            return this.f16516b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return i.b(Float.valueOf(this.f16515a), Float.valueOf(bVar.f16515a)) && i.b(Float.valueOf(this.f16516b), Float.valueOf(bVar.f16516b)) && i.b(Float.valueOf(this.f16517c), Float.valueOf(bVar.f16517c));
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.f16515a) * 31) + Float.floatToIntBits(this.f16516b)) * 31) + Float.floatToIntBits(this.f16517c);
        }

        public String toString() {
            return "Position(xRatio=" + this.f16515a + ", yRatio=" + this.f16516b + ", textSizeRatio=" + this.f16517c + ')';
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWatchFaceMask(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f16505m = new Paint(1);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        m mVar = m.f28349a;
        this.f16506n = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.f16507o = paint2;
        this.f16508p = new Path();
        this.f16509q = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f16478c, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ImageWatchFaceMask, defStyleAttr, 0)");
        this.f16496d = obtainStyledAttributes.getInt(t.f16479d, 0);
        this.f16511s = obtainStyledAttributes.getBoolean(t.f16481f, false);
        this.f16512t = obtainStyledAttributes.getBoolean(t.f16480e, false);
        obtainStyledAttributes.recycle();
        k(context);
        this.f16503k = androidx.core.content.b.c(context, com.mobvoi.companion.aw.watchfacecenter.m.f16457e);
        this.f16504l = androidx.core.content.b.e(context, n.a_res_0x7f0802e1);
        String string = context.getString(s.j_res_0x7f1408a0);
        i.e(string, "context.getString(R.string.image_watchface_battery_sample)");
        this.f16502j = string;
        String string2 = context.getString(s.p_res_0x7f1408ab);
        i.e(string2, "context.getString(R.string.image_watchface_week_sample)");
        this.f16501i = string2;
        String string3 = context.getString(s.k_res_0x7f1408a2);
        i.e(string3, "context.getString(R.string.image_watchface_date_sample)");
        this.f16500h = string3;
        String string4 = context.getString(s.o_res_0x7f1408aa);
        i.e(string4, "context.getString(R.string.image_watchface_time_sample)");
        this.f16499g = string4;
        paint.setStrokeWidth(d.a(2.0f));
        paint.setColor(androidx.core.content.b.c(context, com.mobvoi.companion.aw.watchfacecenter.m.a_res_0x7f060300));
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(androidx.core.content.b.c(context, com.mobvoi.companion.aw.watchfacecenter.m.f16456b));
    }

    private final void c(Canvas canvas) {
        RectF rectF = this.f16509q;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        float width = getWidth();
        rectF.right = width;
        rectF.bottom = width;
        this.f16508p.reset();
        this.f16508p.addCircle(getWidth() / 2.0f, getWidth() / 2.0f, getWidth() / 2.0f, Path.Direction.CCW);
        canvas.clipPath(this.f16508p);
    }

    private final void d(Canvas canvas) {
        b bVar = getDirectionArray()[4];
        Drawable drawable = this.f16504l;
        if (drawable != null) {
            float intrinsicWidth = (drawable.getIntrinsicWidth() * getWidth()) / 456.0f;
            float intrinsicHeight = (drawable.getIntrinsicHeight() * getWidth()) / 456.0f;
            drawable.setBounds(0, 0, (int) intrinsicWidth, (int) intrinsicHeight);
            canvas.save();
            float f10 = 2;
            canvas.translate((getWidth() * bVar.b()) - (intrinsicWidth / f10), (getWidth() * bVar.c()) - (intrinsicHeight / f10));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    private final void e(Canvas canvas) {
        b bVar = getDirectionArray()[3];
        this.f16505m.reset();
        this.f16505m.setAntiAlias(true);
        this.f16505m.setTextSize(getWidth() * bVar.a());
        this.f16505m.setColor(this.f16503k);
        Paint paint = this.f16505m;
        Typeface typeface = this.f16497e;
        if (typeface != null) {
            paint.setTypeface(typeface);
            canvas.drawText(this.f16502j, getWidth() * bVar.b(), getWidth() * bVar.c(), this.f16505m);
            return;
        }
        i.u("fontDINRegular");
        throw null;
    }

    private final void f(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getWidth() / 2.0f, (getWidth() / 2.0f) - this.f16507o.getStrokeWidth(), this.f16507o);
    }

    private final void g(Canvas canvas) {
        if (this.f16510r) {
            canvas.drawCircle(getWidth() / 2.0f, getWidth() / 2.0f, (getWidth() / 2.0f) - (this.f16506n.getStrokeWidth() / 2), this.f16506n);
        }
    }

    private final b[] getDirectionArray() {
        int i10 = this.f16496d;
        if (i10 == 0) {
            return f16493w;
        }
        if (i10 == 1) {
            return f16494x;
        }
        if (i10 != 2) {
            return f16495y;
        }
        return f16495y;
    }

    private final void h(Canvas canvas) {
        b bVar = getDirectionArray()[1];
        this.f16505m.reset();
        this.f16505m.setAntiAlias(true);
        this.f16505m.setTextSize(getWidth() * bVar.a());
        this.f16505m.setColor(this.f16503k);
        Paint paint = this.f16505m;
        Typeface typeface = this.f16498f;
        if (typeface != null) {
            paint.setTypeface(typeface);
            canvas.drawText(this.f16500h, getWidth() * bVar.b(), getWidth() * bVar.c(), this.f16505m);
            return;
        }
        i.u("fontDINMedium");
        throw null;
    }

    private final void i(Canvas canvas) {
        b bVar = getDirectionArray()[2];
        this.f16505m.reset();
        this.f16505m.setAntiAlias(true);
        this.f16505m.setTextSize(getWidth() * bVar.a());
        this.f16505m.setColor(this.f16503k);
        Paint paint = this.f16505m;
        Typeface typeface = this.f16498f;
        if (typeface != null) {
            paint.setTypeface(typeface);
            canvas.drawText(this.f16499g, getWidth() * bVar.b(), getWidth() * bVar.c(), this.f16505m);
            return;
        }
        i.u("fontDINMedium");
        throw null;
    }

    private final void j(Canvas canvas) {
        b bVar = getDirectionArray()[0];
        this.f16505m.reset();
        this.f16505m.setAntiAlias(true);
        this.f16505m.setTextSize(getWidth() * bVar.a());
        this.f16505m.setColor(this.f16503k);
        canvas.drawText(this.f16501i, getWidth() * bVar.b(), getWidth() * bVar.c(), this.f16505m);
    }

    private final void k(Context context) {
        int i10 = o.f16464a;
        Typeface h10 = h.h(context, i10);
        i.d(h10);
        i.e(h10, "getFont(context, R.font.din_regular)!!");
        this.f16497e = h10;
        Typeface h11 = h.h(context, i10);
        i.d(h11);
        i.e(h11, "getFont(context, R.font.din_regular)!!");
        this.f16498f = h11;
    }

    public final void l(boolean z10, boolean z11) {
        this.f16513u = z10;
        this.f16514v = z11;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        c(canvas);
        super.onDraw(canvas);
        if (this.f16511s) {
            if (this.f16514v) {
                h(canvas);
                j(canvas);
            }
            i(canvas);
            if (this.f16513u) {
                e(canvas);
                d(canvas);
            }
            g(canvas);
        }
        if (this.f16512t) {
            f(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            size = 50;
        }
        setMeasuredDimension(size, size);
    }

    public final void setChosenState(boolean z10) {
        this.f16510r = z10;
        invalidate();
    }

    public final void setDirection(int i10) {
        this.f16496d = i10;
        invalidate();
    }

    public final void setNeedShowBattery(boolean z10) {
        this.f16513u = z10;
        invalidate();
    }

    public final void setNeedShowDateAndWeek(boolean z10) {
        this.f16514v = z10;
        invalidate();
    }

    public final void setNeedShowMask(boolean z10) {
        this.f16511s = z10;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWatchFaceMask(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
