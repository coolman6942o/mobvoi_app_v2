package com.mobvoi.companion.view.crop;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.mobvoi.android.common.utils.k;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class CropOverlayView extends View {

    /* renamed from: a  reason: collision with root package name */
    private ScaleGestureDetector f17710a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17711b;

    /* renamed from: d  reason: collision with root package name */
    private b f17713d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f17714e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f17715f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f17716g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f17717h;

    /* renamed from: l  reason: collision with root package name */
    private int f17721l;

    /* renamed from: m  reason: collision with root package name */
    private int f17722m;

    /* renamed from: n  reason: collision with root package name */
    private float f17723n;

    /* renamed from: o  reason: collision with root package name */
    private float f17724o;

    /* renamed from: p  reason: collision with root package name */
    private float f17725p;

    /* renamed from: q  reason: collision with root package name */
    private float f17726q;

    /* renamed from: r  reason: collision with root package name */
    private float f17727r;

    /* renamed from: s  reason: collision with root package name */
    private CropWindowMoveHandler f17728s;

    /* renamed from: y  reason: collision with root package name */
    private boolean f17734y;

    /* renamed from: c  reason: collision with root package name */
    private final e f17712c = new e();

    /* renamed from: i  reason: collision with root package name */
    private final Path f17718i = new Path();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f17719j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    private final RectF f17720k = new RectF();

    /* renamed from: t  reason: collision with root package name */
    private boolean f17729t = true;

    /* renamed from: u  reason: collision with root package name */
    private int f17730u;

    /* renamed from: v  reason: collision with root package name */
    private int f17731v;

    /* renamed from: w  reason: collision with root package name */
    private float f17732w = this.f17730u / this.f17731v;

    /* renamed from: x  reason: collision with root package name */
    private final Rect f17733x = new Rect();

    /* loaded from: classes2.dex */
    public interface b {
        void a(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF g10 = CropOverlayView.this.f17712c.g();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f10 = focusY - currentSpanY;
            float f11 = focusX - currentSpanX;
            float f12 = focusX + currentSpanX;
            float f13 = focusY + currentSpanY;
            if (f11 >= f12 || f10 > f13 || f11 < 0.0f || f12 > CropOverlayView.this.f17712c.c() || f10 < 0.0f || f13 > CropOverlayView.this.f17712c.b()) {
                return true;
            }
            g10.set(f11, f10, f12, f13);
            CropOverlayView.this.f17712c.q(g10);
            CropOverlayView.this.invalidate();
            return true;
        }
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean b(RectF rectF) {
        float u10 = com.mobvoi.companion.view.crop.c.u(this.f17719j);
        float w10 = com.mobvoi.companion.view.crop.c.w(this.f17719j);
        float v10 = com.mobvoi.companion.view.crop.c.v(this.f17719j);
        float p10 = com.mobvoi.companion.view.crop.c.p(this.f17719j);
        if (!n()) {
            this.f17720k.set(u10, w10, v10, p10);
            return false;
        }
        float[] fArr = this.f17719j;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[4];
        float f13 = fArr[5];
        float f14 = fArr[6];
        float f15 = fArr[7];
        if (fArr[7] < fArr[1]) {
            if (fArr[1] < fArr[3]) {
                f10 = fArr[6];
                f11 = fArr[7];
                f12 = fArr[2];
                f13 = fArr[3];
                f14 = fArr[4];
                f15 = fArr[5];
            } else {
                f10 = fArr[4];
                f11 = fArr[5];
                f12 = fArr[0];
                f13 = fArr[1];
                f14 = fArr[2];
                f15 = fArr[3];
            }
        } else if (fArr[1] > fArr[3]) {
            f10 = fArr[2];
            f11 = fArr[3];
            f12 = fArr[6];
            f13 = fArr[7];
            f14 = fArr[0];
            f15 = fArr[1];
        }
        float f16 = (f15 - f11) / (f14 - f10);
        float f17 = (-1.0f) / f16;
        float f18 = f11 - (f16 * f10);
        float f19 = f11 - (f10 * f17);
        float f20 = f13 - (f16 * f12);
        float f21 = f13 - (f12 * f17);
        float centerY = rectF.centerY() - rectF.top;
        float centerX = rectF.centerX();
        float f22 = rectF.left;
        float f23 = centerY / (centerX - f22);
        float f24 = -f23;
        float f25 = rectF.top;
        float f26 = f25 - (f22 * f23);
        float f27 = rectF.right;
        float f28 = f25 - (f24 * f27);
        float f29 = f16 - f23;
        float f30 = (f26 - f18) / f29;
        float max = Math.max(u10, f30 < f27 ? f30 : u10);
        float f31 = (f26 - f19) / (f17 - f23);
        if (f31 >= rectF.right) {
            f31 = max;
        }
        float max2 = Math.max(max, f31);
        float f32 = f17 - f24;
        float f33 = (f28 - f21) / f32;
        if (f33 >= rectF.right) {
            f33 = max2;
        }
        float max3 = Math.max(max2, f33);
        float f34 = (f28 - f19) / f32;
        if (f34 <= rectF.left) {
            f34 = v10;
        }
        float min = Math.min(v10, f34);
        float f35 = (f28 - f20) / (f16 - f24);
        if (f35 <= rectF.left) {
            f35 = min;
        }
        float min2 = Math.min(min, f35);
        float f36 = (f26 - f20) / f29;
        if (f36 <= rectF.left) {
            f36 = min2;
        }
        float min3 = Math.min(min2, f36);
        float max4 = Math.max(w10, Math.max((f16 * max3) + f18, (f17 * min3) + f19));
        float min4 = Math.min(p10, Math.min((f17 * max3) + f21, (f16 * min3) + f20));
        RectF rectF2 = this.f17720k;
        rectF2.left = max3;
        rectF2.top = max4;
        rectF2.right = min3;
        rectF2.bottom = min4;
        return true;
    }

    private void c(boolean z10) {
        try {
            b bVar = this.f17713d;
            if (bVar != null) {
                bVar.a(z10);
            }
        } catch (Exception e10) {
            k.e("AIC", "Exception in crop window changed", e10);
        }
    }

    private void d(Canvas canvas) {
        int i10;
        RectF g10 = this.f17712c.g();
        float max = Math.max(com.mobvoi.companion.view.crop.c.u(this.f17719j), 0.0f);
        float max2 = Math.max(com.mobvoi.companion.view.crop.c.w(this.f17719j), 0.0f);
        float min = Math.min(com.mobvoi.companion.view.crop.c.v(this.f17719j), getWidth());
        float min2 = Math.min(com.mobvoi.companion.view.crop.c.p(this.f17719j), getHeight());
        if (!n() || (i10 = Build.VERSION.SDK_INT) <= 17) {
            canvas.drawRect(max, max2, min, g10.top, this.f17717h);
            canvas.drawRect(max, g10.bottom, min, min2, this.f17717h);
            canvas.drawRect(max, g10.top, g10.left, g10.bottom, this.f17717h);
            canvas.drawRect(g10.right, g10.top, min, g10.bottom, this.f17717h);
            return;
        }
        this.f17718i.reset();
        Path path = this.f17718i;
        float[] fArr = this.f17719j;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.f17718i;
        float[] fArr2 = this.f17719j;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.f17718i;
        float[] fArr3 = this.f17719j;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.f17718i;
        float[] fArr4 = this.f17719j;
        path4.lineTo(fArr4[6], fArr4[7]);
        this.f17718i.close();
        canvas.save();
        if (i10 >= 26) {
            canvas.clipOutPath(this.f17718i);
        } else {
            canvas.clipPath(this.f17718i, Region.Op.INTERSECT);
        }
        canvas.clipRect(g10, Region.Op.XOR);
        canvas.drawRect(max, max2, min, min2, this.f17717h);
        canvas.restore();
    }

    private void e(Canvas canvas) {
        Paint paint = this.f17714e;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF g10 = this.f17712c.g();
            float f10 = strokeWidth / 2.0f;
            g10.inset(f10, f10);
            canvas.drawRect(g10, this.f17714e);
        }
    }

    private void f(Canvas canvas) {
        if (this.f17715f != null) {
            Paint paint = this.f17714e;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f17715f.getStrokeWidth();
            float f10 = strokeWidth2 / 2.0f;
            float f11 = this.f17723n + f10;
            RectF g10 = this.f17712c.g();
            g10.inset(f11, f11);
            float f12 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f13 = f10 + f12;
            float f14 = g10.left;
            float f15 = g10.top;
            canvas.drawLine(f14 - f12, f15 - f13, f14 - f12, f15 + this.f17724o, this.f17715f);
            float f16 = g10.left;
            float f17 = g10.top;
            canvas.drawLine(f16 - f13, f17 - f12, f16 + this.f17724o, f17 - f12, this.f17715f);
            float f18 = g10.right;
            float f19 = g10.top;
            canvas.drawLine(f18 + f12, f19 - f13, f18 + f12, f19 + this.f17724o, this.f17715f);
            float f20 = g10.right;
            float f21 = g10.top;
            canvas.drawLine(f20 + f13, f21 - f12, f20 - this.f17724o, f21 - f12, this.f17715f);
            float f22 = g10.left;
            float f23 = g10.bottom;
            canvas.drawLine(f22 - f12, f23 + f13, f22 - f12, f23 - this.f17724o, this.f17715f);
            float f24 = g10.left;
            float f25 = g10.bottom;
            canvas.drawLine(f24 - f13, f25 + f12, f24 + this.f17724o, f25 + f12, this.f17715f);
            float f26 = g10.right;
            float f27 = g10.bottom;
            canvas.drawLine(f26 + f12, f27 + f13, f26 + f12, f27 - this.f17724o, this.f17715f);
            float f28 = g10.right;
            float f29 = g10.bottom;
            canvas.drawLine(f28 + f13, f29 + f12, f28 - this.f17724o, f29 + f12, this.f17715f);
        }
    }

    private void g(Canvas canvas) {
        if (this.f17716g != null) {
            Paint paint = this.f17714e;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF g10 = this.f17712c.g();
            g10.inset(strokeWidth, strokeWidth);
            float width = g10.width() / 3.0f;
            float height = g10.height() / 3.0f;
            float f10 = g10.left + width;
            float f11 = g10.right - width;
            canvas.drawLine(f10, g10.top, f10, g10.bottom, this.f17716g);
            canvas.drawLine(f11, g10.top, f11, g10.bottom, this.f17716g);
            float f12 = g10.top + height;
            float f13 = g10.bottom - height;
            canvas.drawLine(g10.left, f12, g10.right, f12, this.f17716g);
            canvas.drawLine(g10.left, f13, g10.right, f13, this.f17716g);
        }
    }

    private void h(RectF rectF) {
        if (rectF.width() < this.f17712c.e()) {
            float e10 = (this.f17712c.e() - rectF.width()) / 2.0f;
            rectF.left -= e10;
            rectF.right += e10;
        }
        if (rectF.height() < this.f17712c.d()) {
            float d10 = (this.f17712c.d() - rectF.height()) / 2.0f;
            rectF.top -= d10;
            rectF.bottom += d10;
        }
        if (rectF.width() > this.f17712c.c()) {
            float width = (rectF.width() - this.f17712c.c()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.f17712c.b()) {
            float height = (rectF.height() - this.f17712c.b()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        b(rectF);
        if (this.f17720k.width() > 0.0f && this.f17720k.height() > 0.0f) {
            float max = Math.max(this.f17720k.left, 0.0f);
            float max2 = Math.max(this.f17720k.top, 0.0f);
            float min = Math.min(this.f17720k.right, getWidth());
            float min2 = Math.min(this.f17720k.bottom, getHeight());
            if (rectF.left < max) {
                rectF.left = max;
            }
            if (rectF.top < max2) {
                rectF.top = max2;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.f17729t && Math.abs(rectF.width() - (rectF.height() * this.f17732w)) > 0.1d) {
            if (rectF.width() > rectF.height() * this.f17732w) {
                float abs = Math.abs((rectF.height() * this.f17732w) - rectF.width()) / 2.0f;
                rectF.left += abs;
                rectF.right -= abs;
                return;
            }
            float abs2 = Math.abs((rectF.width() / this.f17732w) - rectF.height()) / 2.0f;
            rectF.top += abs2;
            rectF.bottom -= abs2;
        }
    }

    private static Paint j(int i10) {
        Paint paint = new Paint();
        paint.setColor(i10);
        return paint;
    }

    private static Paint k(float f10, int i10) {
        if (f10 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i10);
        paint.setStrokeWidth(f10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void l() {
        float max = Math.max(com.mobvoi.companion.view.crop.c.u(this.f17719j), 0.0f);
        float max2 = Math.max(com.mobvoi.companion.view.crop.c.w(this.f17719j), 0.0f);
        float min = Math.min(com.mobvoi.companion.view.crop.c.v(this.f17719j), getWidth());
        float min2 = Math.min(com.mobvoi.companion.view.crop.c.p(this.f17719j), getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.f17734y = true;
            float f10 = this.f17725p;
            float f11 = min - max;
            float f12 = f10 * f11;
            float f13 = min2 - max2;
            float f14 = f10 * f13;
            if (this.f17733x.width() > 0 && this.f17733x.height() > 0) {
                rectF.left = (this.f17733x.left / this.f17712c.j()) + max;
                rectF.top = (this.f17733x.top / this.f17712c.i()) + max2;
                rectF.right = rectF.left + (this.f17733x.width() / this.f17712c.j());
                rectF.bottom = rectF.top + (this.f17733x.height() / this.f17712c.i());
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.f17729t || min <= max || min2 <= max2) {
                rectF.left = max + f12;
                rectF.top = max2 + f14;
                rectF.right = min - f12;
                rectF.bottom = min2 - f14;
            } else if (f11 / f13 > this.f17732w) {
                rectF.top = max2 + f14;
                rectF.bottom = min2 - f14;
                float width = getWidth() / 2.0f;
                this.f17732w = this.f17730u / this.f17731v;
                float max3 = Math.max(this.f17712c.e(), rectF.height() * this.f17732w) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f12;
                rectF.right = min - f12;
                float height = getHeight() / 2.0f;
                float max4 = Math.max(this.f17712c.d(), rectF.width() / this.f17732w) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
            h(rectF);
            this.f17712c.q(rectF);
        }
    }

    private boolean n() {
        float[] fArr = this.f17719j;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void o(float f10, float f11) {
        CropWindowMoveHandler f12 = this.f17712c.f(f10, f11, this.f17726q);
        this.f17728s = f12;
        if (f12 != null) {
            invalidate();
        }
    }

    private void p(float f10, float f11) {
        if (this.f17728s != null) {
            float f12 = this.f17727r;
            RectF g10 = this.f17712c.g();
            if (b(g10)) {
                f12 = 0.0f;
            }
            this.f17728s.m(g10, f10, f11, this.f17720k, this.f17721l, this.f17722m, f12, this.f17729t, this.f17732w);
            this.f17712c.q(g10);
            c(true);
            invalidate();
        }
    }

    private void q() {
        if (this.f17728s != null) {
            this.f17728s = null;
            c(false);
            invalidate();
        }
    }

    public int getAspectRatioX() {
        return this.f17730u;
    }

    public int getAspectRatioY() {
        return this.f17731v;
    }

    public RectF getCropWindowRect() {
        return this.f17712c.g();
    }

    public Rect getInitialCropWindowRect() {
        return this.f17733x;
    }

    public void i() {
        RectF cropWindowRect = getCropWindowRect();
        h(cropWindowRect);
        this.f17712c.q(cropWindowRect);
    }

    public boolean m() {
        return this.f17729t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        if (this.f17712c.r()) {
            g(canvas);
        }
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f17711b) {
            this.f17710a.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    p(motionEvent.getX(), motionEvent.getY());
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                } else if (action != 3) {
                    return false;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            q();
            return true;
        }
        o(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public void r() {
        if (this.f17734y) {
            setCropWindowRect(com.mobvoi.companion.view.crop.c.f17777b);
            l();
            invalidate();
        }
    }

    public void s(float[] fArr, int i10, int i11) {
        if (fArr == null || !Arrays.equals(this.f17719j, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f17719j, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f17719j, 0, fArr.length);
            }
            this.f17721l = i10;
            this.f17722m = i11;
            RectF g10 = this.f17712c.g();
            if (g10.width() == 0.0f || g10.height() == 0.0f) {
                l();
            }
        }
    }

    public void setAspectRatioX(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f17730u != i10) {
            this.f17730u = i10;
            this.f17732w = i10 / this.f17731v;
            if (this.f17734y) {
                l();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f17731v != i10) {
            this.f17731v = i10;
            this.f17732w = this.f17730u / i10;
            if (this.f17734y) {
                l();
                invalidate();
            }
        }
    }

    public void setCropWindowChangeListener(b bVar) {
        this.f17713d = bVar;
    }

    public void setCropWindowRect(RectF rectF) {
        this.f17712c.q(rectF);
    }

    public void setFixedAspectRatio(boolean z10) {
        if (this.f17729t != z10) {
            this.f17729t = z10;
            if (this.f17734y) {
                l();
                invalidate();
            }
        }
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.f17733x;
        if (rect == null) {
            rect = com.mobvoi.companion.view.crop.c.f17776a;
        }
        rect2.set(rect);
        if (this.f17734y) {
            l();
            invalidate();
            c(false);
        }
    }

    public void setSnapRadius(float f10) {
        this.f17727r = f10;
    }

    public void t(float f10, float f11, float f12, float f13) {
        this.f17712c.o(f10, f11, f12, f13);
    }

    public void u() {
        this.f17712c.p();
        setSnapRadius(3.0f);
        setFixedAspectRatio(true);
        setAspectRatioX(1);
        setAspectRatioY(1);
        v(false);
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f17726q = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f17725p = 0.1f;
        this.f17714e = k(TypedValue.applyDimension(1, 1.0f, displayMetrics), -1);
        this.f17723n = -TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f17724o = TypedValue.applyDimension(1, 18.0f, displayMetrics);
        this.f17715f = k(TypedValue.applyDimension(1, 3.0f, displayMetrics), -1);
        this.f17716g = k(TypedValue.applyDimension(1, 1.0f, displayMetrics), -1);
        this.f17717h = j(Color.argb(204, 0, 0, 0));
    }

    public boolean v(boolean z10) {
        if (this.f17711b == z10) {
            return false;
        }
        this.f17711b = z10;
        if (!z10 || this.f17710a != null) {
            return true;
        }
        this.f17710a = new ScaleGestureDetector(getContext(), new c());
        return true;
    }
}
