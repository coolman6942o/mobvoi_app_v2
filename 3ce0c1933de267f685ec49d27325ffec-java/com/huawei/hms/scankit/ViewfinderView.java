package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alipay.sdk.app.PayTask;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.scankit.aiscan.common.z;
/* loaded from: classes2.dex */
public final class ViewfinderView extends View {
    private int[] A;
    private float[] B;
    private Rect C;
    private boolean D;
    Point E;
    private boolean F;

    /* renamed from: a  reason: collision with root package name */
    private Paint f14084a;

    /* renamed from: b  reason: collision with root package name */
    private TextPaint f14085b;

    /* renamed from: c  reason: collision with root package name */
    private int f14086c;

    /* renamed from: d  reason: collision with root package name */
    private int f14087d;

    /* renamed from: e  reason: collision with root package name */
    private int f14088e;

    /* renamed from: f  reason: collision with root package name */
    private int f14089f;

    /* renamed from: g  reason: collision with root package name */
    private int f14090g;

    /* renamed from: h  reason: collision with root package name */
    private float f14091h;

    /* renamed from: i  reason: collision with root package name */
    private b f14092i;

    /* renamed from: j  reason: collision with root package name */
    private String f14093j;

    /* renamed from: k  reason: collision with root package name */
    private int f14094k;

    /* renamed from: l  reason: collision with root package name */
    private float f14095l;

    /* renamed from: m  reason: collision with root package name */
    public int f14096m;

    /* renamed from: n  reason: collision with root package name */
    public int f14097n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f14098o;

    /* renamed from: p  reason: collision with root package name */
    private int f14099p;

    /* renamed from: q  reason: collision with root package name */
    private int f14100q;

    /* renamed from: r  reason: collision with root package name */
    private int f14101r;

    /* renamed from: s  reason: collision with root package name */
    private int f14102s;

    /* renamed from: t  reason: collision with root package name */
    private a f14103t;

    /* renamed from: u  reason: collision with root package name */
    private int f14104u;

    /* renamed from: v  reason: collision with root package name */
    private int f14105v;

    /* renamed from: w  reason: collision with root package name */
    private Rect f14106w;

    /* renamed from: x  reason: collision with root package name */
    private int f14107x;

    /* renamed from: y  reason: collision with root package name */
    private ValueAnimator f14108y;

    /* renamed from: z  reason: collision with root package name */
    Paint f14109z;

    /* loaded from: classes2.dex */
    public enum a {
        NONE(0),
        LINE(1),
        GRID(2);
        

        /* renamed from: e  reason: collision with root package name */
        private int f14114e;

        a(int i10) {
            this.f14114e = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(int i10) {
            a[] values;
            for (a aVar : values()) {
                if (aVar.f14114e == i10) {
                    return aVar;
                }
            }
            return LINE;
        }
    }

    /* loaded from: classes2.dex */
    public enum b {
        TOP(0),
        BOTTOM(1);
        

        /* renamed from: d  reason: collision with root package name */
        private int f14118d;

        b(int i10) {
            this.f14118d = i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(int i10) {
            b[] values;
            for (b bVar : values()) {
                if (bVar.f14118d == i10) {
                    return bVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.f14086c = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_maskColor, b(context, R.color.scankit_viewfinder_mask));
        this.f14087d = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_frameColor, b(context, R.color.scankit_viewfinder_frame));
        this.f14089f = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_cornerColor, b(context, R.color.scankit_viewfinder_corner));
        this.f14088e = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_laserColor, b(context, R.color.scankit_viewfinder_lasers));
        this.f14090g = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_resultPointColor, b(context, R.color.scankit_viewfinder_result_point_color));
        this.f14093j = obtainStyledAttributes.getString(R.styleable.ViewfinderView_scankit_labelText);
        this.f14094k = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_labelTextColor, b(context, R.color.scankit_viewfinder_text_color));
        this.f14095l = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.f14091h = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.f14092i = b.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_labelTextLocation, 0));
        this.f14098o = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_showResultPoint, false);
        this.f14101r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameWidth, 0);
        this.f14102s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameHeight, 0);
        this.f14103t = a.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_laserStyle, a.LINE.f14114e));
        this.f14104u = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_gridColumn, 20);
        this.f14105v = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.F = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_line_anim, true);
        obtainStyledAttributes.recycle();
        this.f14084a = new Paint(1);
        this.f14085b = new TextPaint(1);
        this.f14107x = a(context, 136);
        this.f14100q = getDisplayMetrics().heightPixels;
        this.f14099p = getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i10) {
        try {
            return Build.VERSION.SDK_INT >= 23 ? context.getColor(i10) : context.getResources().getColor(i10);
        } catch (Resources.NotFoundException unused) {
            Log.e("ViewfinderView", "getColor: Resources.NotFoundException");
            return 16777215;
        } catch (Exception unused2) {
            Log.e("ViewfinderView", "getColor: Exception");
            return 16777215;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public void a(z zVar) {
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f14108y;
        if (valueAnimator != null) {
            valueAnimator.pause();
            this.f14108y.removeAllListeners();
            this.f14108y.cancel();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.F) {
            canvas.save();
            String str = Build.DEVICE;
            a(canvas, "HWTAH".equals(str) || str.equals("HWTAH-C"));
            canvas.restore();
        }
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f14099p = i10;
        this.f14100q = i11;
        a();
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f14096m = 0;
        this.f14097n = 0;
        this.f14106w = new Rect();
        this.f14109z = new Paint();
        this.A = new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#72FFFFFF"), Color.parseColor("#58FFFFFF"), Color.parseColor("#40FFFFFF"), Color.parseColor("#28FFFFFF"), Color.parseColor("#13FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.B = new float[]{0.0f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
        this.D = true;
        this.F = true;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, boolean z10) {
        int i10;
        this.f14084a.setStyle(Paint.Style.FILL);
        this.f14084a.setColor(this.f14088e);
        if (q.f15048b || z10) {
            Rect rect = this.f14106w;
            int i11 = this.f14099p / 2;
            rect.left = i11 - 540;
            int i12 = this.f14096m;
            rect.top = i12;
            rect.bottom = i12 + this.f14107x;
            rect.right = i11 + 540;
        } else {
            Rect rect2 = this.f14106w;
            rect2.left = 0;
            int i13 = this.f14096m;
            rect2.top = i13;
            rect2.bottom = i13 + this.f14107x;
            rect2.right = this.f14099p;
        }
        float f10 = this.f14099p / 2;
        float f11 = this.f14106w.bottom + AGCServerException.UNKNOW_EXCEPTION;
        this.f14084a.setShader(new RadialGradient(f10, f11, 690, this.A, this.B, Shader.TileMode.CLAMP));
        this.f14084a.setStrokeWidth(10.0f);
        Rect rect3 = this.f14106w;
        float f12 = rect3.left;
        float f13 = rect3.bottom;
        canvas.drawLine(f12, f13, rect3.right, f13, this.f14084a);
        canvas.clipRect(this.f14106w);
        canvas.drawCircle(f10, f11, i10 + 200, this.f14084a);
    }

    public void a() {
        if (q.f15048b) {
            this.f14097n = this.f14100q;
        } else {
            this.f14097n = this.f14100q - a(getContext(), 139);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.f14097n - this.f14107x);
        this.f14108y = ofInt;
        ofInt.setDuration(PayTask.f6879j);
        this.f14108y.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f14108y.setRepeatMode(1);
        this.f14108y.setRepeatCount(-1);
        this.f14108y.addUpdateListener(new G(this));
        this.f14108y.start();
    }

    public void a(Rect rect, boolean z10, Point point) {
        this.D = z10;
        this.E = point;
        if (this.C == null) {
            this.C = rect;
            invalidate();
        }
    }

    public static int a(Context context, int i10) {
        return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(Canvas canvas) {
        Point point;
        int i10;
        int i11;
        int i12;
        if (this.C != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (this.D) {
                Point point2 = this.E;
                point = new Point(point2.y, point2.x);
            } else {
                Point point3 = this.E;
                point = new Point(point3.x, point3.y);
            }
            int i13 = point.x;
            float f10 = width / i13;
            int i14 = point.y;
            float f11 = height / i14;
            int i15 = (int) (i14 * 0.1d);
            int i16 = (int) ((i13 * 0.15d) / 2.0d);
            RectF rectF = new RectF();
            if (this.D) {
                if (f10 > f11) {
                    i11 = (int) (point.y * f10);
                    canvas.translate(0.0f, (height / 2) - (i11 / 2));
                    i10 = width;
                } else {
                    i12 = (int) (point.x * f11);
                    canvas.translate((width / 2) - (i12 / 2), 0.0f);
                    i10 = i12;
                    i11 = height;
                }
            } else if (f10 > f11) {
                i11 = (int) (point.y * f10);
                canvas.translate(0.0f, (height / 2) - (i11 / 2));
                i10 = width;
            } else {
                i12 = (int) (point.x * f11);
                canvas.translate((width / 2) - (i12 / 2), 0.0f);
                i10 = i12;
                i11 = height;
            }
            Rect rect = this.C;
            float f12 = point.x;
            float f13 = point.y;
            float f14 = (rect.top + i15) / f13;
            float f15 = (rect.bottom + i15) / f13;
            float f16 = i10;
            float f17 = ((rect.left + i16) / f12) * f16;
            rectF.left = f17;
            float f18 = ((rect.right + i16) / f12) * f16;
            rectF.right = f18;
            float f19 = i11;
            float f20 = f14 * f19;
            rectF.top = f20;
            float f21 = f15 * f19;
            rectF.bottom = f21;
            float f22 = (f17 + f18) / 2.0f;
            float f23 = (f20 + f21) / 2.0f;
            this.f14109z.setStyle(Paint.Style.FILL);
            this.f14109z.setColor(-1);
            canvas.drawCircle(f22, f23, ((int) ((getDisplayMetrics().density * 24.0f) + 0.5d)) / 2, this.f14109z);
            this.f14109z.setColor(Color.parseColor("#007DFF"));
            canvas.drawCircle(f22, f23, ((int) ((getDisplayMetrics().density * 22.0f) + 0.5d)) / 2, this.f14109z);
            if (this.D) {
                if (f10 > f11) {
                    canvas.translate(0.0f, (i11 / 2) - (height / 2));
                } else {
                    canvas.translate((i10 / 2) - (width / 2), 0.0f);
                }
            } else if (f10 > f11) {
                canvas.translate(0.0f, (i11 / 2) - (height / 2));
            } else {
                canvas.translate((i10 / 2) - (width / 2), 0.0f);
            }
        }
    }
}
