package com.mobvoi.health.common.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.DimensionUtils;
import mf.e;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private String A;
    private boolean B;
    private int C;

    /* renamed from: a  reason: collision with root package name */
    private Path f18033a;

    /* renamed from: b  reason: collision with root package name */
    private Path f18034b;

    /* renamed from: c  reason: collision with root package name */
    private Path f18035c;

    /* renamed from: d  reason: collision with root package name */
    private Path f18036d;

    /* renamed from: e  reason: collision with root package name */
    private float f18037e;

    /* renamed from: f  reason: collision with root package name */
    private float f18038f;

    /* renamed from: g  reason: collision with root package name */
    private float f18039g;

    /* renamed from: h  reason: collision with root package name */
    private float f18040h;

    /* renamed from: i  reason: collision with root package name */
    private float f18041i;

    /* renamed from: j  reason: collision with root package name */
    private float f18042j;

    /* renamed from: k  reason: collision with root package name */
    private float f18043k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18044l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18045m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f18046n;

    /* renamed from: o  reason: collision with root package name */
    private b f18047o;

    /* renamed from: p  reason: collision with root package name */
    private SparseArray<d> f18048p;

    /* renamed from: q  reason: collision with root package name */
    private RectF f18049q;

    /* renamed from: r  reason: collision with root package name */
    private RectF f18050r;

    /* renamed from: s  reason: collision with root package name */
    private int f18051s;

    /* renamed from: t  reason: collision with root package name */
    private int f18052t;

    /* renamed from: u  reason: collision with root package name */
    private final Paint f18053u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f18054v;

    /* renamed from: w  reason: collision with root package name */
    private float f18055w;

    /* renamed from: x  reason: collision with root package name */
    private int f18056x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f18057y;

    /* renamed from: z  reason: collision with root package name */
    private long f18058z;

    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private float f18059a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18060b;

        /* renamed from: c  reason: collision with root package name */
        private float f18061c;

        /* renamed from: d  reason: collision with root package name */
        private long f18062d;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            float elapsedRealtime = ((float) (SystemClock.elapsedRealtime() - this.f18062d)) / this.f18061c;
            this.f18059a = elapsedRealtime;
            if (elapsedRealtime >= 1.0f) {
                this.f18059a = 1.0f;
                this.f18060b = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        public static MaskFilter a(int i10) {
            return new BlurMaskFilter(i10, BlurMaskFilter.Blur.NORMAL);
        }

        public static Shader b(int i10, ProgressView progressView) {
            float size = 1.0f / progressView.f18048p.size();
            return new SweepGradient(progressView.f18051s, progressView.f18052t, new int[]{0, i10, 0}, new float[]{0.0f, size / 2.0f, size});
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        Shader f18063a;

        /* renamed from: b  reason: collision with root package name */
        MaskFilter f18064b;

        /* renamed from: c  reason: collision with root package name */
        public float f18065c;

        /* renamed from: f  reason: collision with root package name */
        public String f18068f;

        /* renamed from: d  reason: collision with root package name */
        public int f18066d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f18067e = -1;

        /* renamed from: g  reason: collision with root package name */
        public String f18069g = "0";

        MaskFilter a(ProgressView progressView) {
            if (this.f18065c < 1.0f) {
                return null;
            }
            if (this.f18064b == null) {
                this.f18064b = c.a((int) progressView.f18042j);
            }
            return this.f18064b;
        }

        Shader b(ProgressView progressView) {
            if (this.f18065c < 1.0f) {
                return null;
            }
            if (this.f18063a == null) {
                this.f18063a = c.b(this.f18066d, progressView);
            }
            return this.f18063a;
        }
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private d e(int i10) {
        if (h()) {
            return this.f18048p.get(i10);
        }
        return null;
    }

    private boolean f() {
        return this.f18058z <= System.currentTimeMillis();
    }

    private boolean h() {
        SparseArray<d> sparseArray = this.f18048p;
        if (sparseArray != null && sparseArray.size() > 0) {
            return true;
        }
        k.q("health.progressview", "please init item style");
        return false;
    }

    public void g(int i10, float f10, String str) {
        d e10 = e(i10);
        if (e10 != null) {
            e10.f18069g = str;
            e10.f18065c = f10;
            invalidate();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DefaultLocale"})
    protected void onDraw(Canvas canvas) {
        float f10;
        Path path;
        Path path2;
        super.onDraw(canvas);
        if (h()) {
            if (this.f18047o.f18060b) {
                this.f18047o.d();
            }
            float size = 360 / this.f18048p.size();
            float f11 = size - this.f18039g;
            float width = (float) ((((this.f18049q.width() * 3.141592653589793d) * f11) / 360.0d) / 2.0d);
            if (this.f18044l) {
                RectF rectF = this.f18050r;
                this.f18053u.setColor(this.C);
                this.f18053u.setAlpha(160);
                this.f18053u.setStrokeWidth(2.0f);
                this.f18053u.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(this.f18051s, this.f18052t, (((rectF.right - rectF.left) + this.f18042j) / 2.0f) + 0.5f, this.f18053u);
            }
            int i10 = 0;
            while (i10 < this.f18048p.size()) {
                d valueAt = this.f18048p.valueAt(i10);
                canvas.save();
                int i11 = i10 + 1;
                float f12 = (i11 * size) - (size / 2.0f);
                canvas.rotate(f12, this.f18051s, this.f18052t);
                if (!this.f18044l || valueAt.f18065c < 1.0f) {
                    f10 = f12;
                } else {
                    float f13 = ((-size) / 2.0f) - 90.0f;
                    canvas.rotate(f13, this.f18051s, this.f18052t);
                    this.f18053u.setStyle(Paint.Style.STROKE);
                    this.f18053u.setStrokeCap(Paint.Cap.BUTT);
                    this.f18053u.setShader(valueAt.b(this));
                    this.f18053u.setStrokeWidth(this.f18042j);
                    this.f18053u.setMaskFilter(valueAt.a(this));
                    f10 = f12;
                    canvas.drawArc(this.f18050r, 0.0f, size, false, this.f18053u);
                    canvas.rotate(-f13, this.f18051s, this.f18052t);
                    this.f18053u.setShader(null);
                    this.f18053u.setMaskFilter(null);
                }
                this.f18053u.setStrokeCap(Paint.Cap.ROUND);
                this.f18053u.setStrokeWidth(this.f18040h);
                this.f18053u.setStyle(Paint.Style.STROKE);
                this.f18053u.setColor(valueAt.f18066d);
                this.f18053u.setAlpha(60);
                float f14 = (-90.0f) - (f11 / 2.0f);
                canvas.drawArc(this.f18049q, f14, f11, false, this.f18053u);
                this.f18053u.setAlpha(255);
                float f15 = valueAt.f18065c;
                if (f15 > 1.0f) {
                    f15 = 1.0f;
                }
                if (this.f18047o.f18060b) {
                    f15 *= this.f18047o.f18059a;
                }
                canvas.drawArc(this.f18049q, f14, f11 * f15, false, this.f18053u);
                this.f18053u.setStyle(Paint.Style.FILL);
                if (this.f18045m) {
                    this.f18053u.setTextAlign(Paint.Align.CENTER);
                    this.f18053u.setTextSize(this.f18038f);
                    float measureText = this.f18053u.measureText(valueAt.f18069g);
                    this.f18053u.setTextSize((this.f18038f / 3.0f) * 2.0f);
                    float measureText2 = this.f18053u.measureText(valueAt.f18068f);
                    int i12 = (f10 > 90.0f ? 1 : (f10 == 90.0f ? 0 : -1));
                    boolean z10 = true;
                    if (i12 <= 0 || f10 > 270.0f) {
                        z10 = false;
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        canvas.rotate(90.0f, getHeight() / 2, getWidth() / 2);
                    }
                    if (z10) {
                        path = this.f18034b;
                    } else {
                        path = this.f18033a;
                    }
                    Path path3 = path;
                    float f16 = this.f18038f;
                    if (!z10) {
                        f16 = (-f16) / 3.0f;
                    }
                    float f17 = f16;
                    this.f18053u.setTextSize(this.f18038f);
                    canvas.drawTextOnPath(valueAt.f18069g, path3, (-measureText2) / 2.0f, f17, this.f18053u);
                    this.f18053u.setTextSize((this.f18038f / 3.0f) * 2.0f);
                    canvas.drawTextOnPath(valueAt.f18068f, path3, measureText / 2.0f, f17, this.f18053u);
                    float f18 = valueAt.f18065c;
                    if (f18 >= 1.0f) {
                        String format = String.format("%d%%", Integer.valueOf(eg.b.c(f18)));
                        if (z10) {
                            path2 = this.f18036d;
                        } else {
                            path2 = this.f18035c;
                        }
                        Path path4 = path2;
                        this.f18053u.setColor(valueAt.f18067e);
                        this.f18053u.setTextSize((this.f18040h / 3.0f) * 2.0f);
                        canvas.drawTextOnPath(format, path4, (z10 ? -1 : 1) * (width - (this.f18053u.measureText(format) / 2.0f)), this.f18040h / 4.0f, this.f18053u);
                        canvas.restore();
                        i10 = i11;
                    }
                }
                canvas.restore();
                i10 = i11;
            }
            if (this.B) {
                if (f()) {
                    this.f18054v.setAlpha(255);
                } else {
                    this.f18054v.setAlpha(128);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    canvas.drawText(this.A, getWidth() / 2, (getHeight() / 2) - ((this.f18054v.descent() + this.f18054v.ascent()) / 2.0f), this.f18054v);
                }
            }
            if (this.f18047o.f18060b) {
                postInvalidateOnAnimation();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f18046n) {
            this.f18040h = i10 * this.f18043k;
        }
        int min = Math.min(i10, i11);
        int i14 = i10 >> 1;
        this.f18051s = i14;
        this.f18052t = i11 >> 1;
        float f10 = this.f18040h;
        float f11 = f10 / 2.0f;
        float f12 = (1.0f - this.f18037e) * i14;
        if (f10 / 2.0f > f12) {
            f12 = f10 / 2.0f;
        }
        float f13 = min;
        float f14 = f13 - f12;
        this.f18049q = new RectF(f12, f12, f14, f14);
        float f15 = this.f18042j * 1.5f;
        if (this.f18044l) {
            float f16 = f13 - f15;
            this.f18050r = new RectF(f15, f15, f16, f16);
        }
        RectF rectF = this.f18049q;
        RectF rectF2 = new RectF(rectF.left - f11, rectF.top - f11, rectF.right + f11, rectF.bottom + f11);
        Path path = new Path();
        this.f18033a = path;
        path.addArc(rectF2, -270.0f, 360.0f);
        Path path2 = new Path();
        this.f18034b = path2;
        path2.addArc(rectF2, 90.0f, -360.0f);
        Path path3 = new Path();
        this.f18035c = path3;
        path3.addArc(this.f18049q, -270.0f, 360.0f);
        Path path4 = new Path();
        this.f18036d = path4;
        path4.addArc(this.f18049q, 90.0f, -360.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f18055w = motionEvent.getX();
            this.f18057y = true;
        } else if (action == 2 && Math.abs(this.f18055w - motionEvent.getX()) > this.f18056x) {
            this.f18057y = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f18057y) {
            return super.performClick();
        }
        return true;
    }

    public void setActivePercent(float f10) {
        d e10 = e(2);
        if (e10 != null) {
            e10.f18065c = f10;
        }
        invalidate();
    }

    public void setDayStart(long j10) {
        this.f18058z = j10;
        invalidate();
    }

    public void setExercisePercent(float f10) {
        d e10 = e(1);
        if (e10 != null) {
            e10.f18065c = f10;
        }
        invalidate();
    }

    public void setStepPercent(float f10) {
        d e10 = e(0);
        if (e10 != null) {
            e10.f18065c = f10;
        }
        invalidate();
    }

    public void setWeekText(String str) {
        this.A = str;
        invalidate();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18047o = new b();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.f30771x, i10, 0);
        if (obtainStyledAttributes != null) {
            this.f18040h = obtainStyledAttributes.getDimension(e.F, DimensionUtils.dp2px(context, 20.0f));
            this.f18044l = obtainStyledAttributes.getBoolean(e.f30772y, false);
            float dimension = obtainStyledAttributes.getDimension(e.f30773z, DimensionUtils.dp2px(context, 20.0f));
            this.f18041i = dimension;
            this.f18042j = dimension / 3.0f;
            this.f18038f = obtainStyledAttributes.getDimension(e.H, DimensionUtils.dp2px(context, 16.0f));
            this.f18045m = obtainStyledAttributes.getBoolean(e.G, false);
            this.f18046n = obtainStyledAttributes.getBoolean(e.E, false);
            this.B = obtainStyledAttributes.getBoolean(e.B, false);
            this.f18039g = obtainStyledAttributes.getFloat(e.C, 30.0f);
            this.f18043k = obtainStyledAttributes.getFloat(e.D, 0.09f);
            this.f18037e = obtainStyledAttributes.getFloat(e.A, 0.7f);
            obtainStyledAttributes.recycle();
        }
        this.f18048p = com.mobvoi.health.common.ui.view.a.d(context);
        this.C = context.getResources().getColor(mf.b.f30664b);
        Paint paint = new Paint();
        this.f18053u = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f18054v = paint2;
        paint2.setAntiAlias(true);
        this.f18054v.setColor(-1);
        this.f18054v.setStyle(Paint.Style.FILL);
        this.f18054v.setTextAlign(Paint.Align.CENTER);
        this.f18054v.setTextSize(this.f18038f);
        this.f18056x = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
