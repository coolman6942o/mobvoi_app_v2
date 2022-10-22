package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class CropOverlayView extends View {
    private boolean B;
    private Integer C;

    /* renamed from: a  reason: collision with root package name */
    private ScaleGestureDetector f23122a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23123b;

    /* renamed from: d  reason: collision with root package name */
    private b f23125d;

    /* renamed from: f  reason: collision with root package name */
    private Paint f23127f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f23128g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f23129h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f23130i;

    /* renamed from: m  reason: collision with root package name */
    private int f23134m;

    /* renamed from: n  reason: collision with root package name */
    private int f23135n;

    /* renamed from: o  reason: collision with root package name */
    private float f23136o;

    /* renamed from: p  reason: collision with root package name */
    private float f23137p;

    /* renamed from: q  reason: collision with root package name */
    private float f23138q;

    /* renamed from: r  reason: collision with root package name */
    private float f23139r;

    /* renamed from: s  reason: collision with root package name */
    private float f23140s;

    /* renamed from: t  reason: collision with root package name */
    private CropWindowMoveHandler f23141t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23142u;

    /* renamed from: y  reason: collision with root package name */
    private CropImageView.Guidelines f23146y;

    /* renamed from: z  reason: collision with root package name */
    private CropImageView.CropShape f23147z;

    /* renamed from: c  reason: collision with root package name */
    private final e f23124c = new e();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f23126e = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private Path f23131j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final float[] f23132k = new float[8];

    /* renamed from: l  reason: collision with root package name */
    private final RectF f23133l = new RectF();

    /* renamed from: v  reason: collision with root package name */
    private int f23143v;

    /* renamed from: w  reason: collision with root package name */
    private int f23144w;

    /* renamed from: x  reason: collision with root package name */
    private float f23145x = this.f23143v / this.f23144w;
    private final Rect A = new Rect();

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
            RectF h10 = CropOverlayView.this.f23124c.h();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f10 = focusY - currentSpanY;
            float f11 = focusX - currentSpanX;
            float f12 = focusX + currentSpanX;
            float f13 = focusY + currentSpanY;
            if (f11 >= f12 || f10 > f13 || f11 < 0.0f || f12 > CropOverlayView.this.f23124c.c() || f10 < 0.0f || f13 > CropOverlayView.this.f23124c.b()) {
                return true;
            }
            h10.set(f11, f10, f12, f13);
            CropOverlayView.this.f23124c.r(h10);
            CropOverlayView.this.invalidate();
            return true;
        }
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean b(RectF rectF) {
        float u10 = com.theartofdev.edmodo.cropper.c.u(this.f23132k);
        float w10 = com.theartofdev.edmodo.cropper.c.w(this.f23132k);
        float v10 = com.theartofdev.edmodo.cropper.c.v(this.f23132k);
        float p10 = com.theartofdev.edmodo.cropper.c.p(this.f23132k);
        if (!n()) {
            this.f23133l.set(u10, w10, v10, p10);
            return false;
        }
        float[] fArr = this.f23132k;
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
        RectF rectF2 = this.f23133l;
        rectF2.left = max3;
        rectF2.top = max4;
        rectF2.right = min3;
        rectF2.bottom = min4;
        return true;
    }

    private void c(boolean z10) {
        try {
            b bVar = this.f23125d;
            if (bVar != null) {
                bVar.a(z10);
            }
        } catch (Exception e10) {
            Log.e("AIC", "Exception in crop window changed", e10);
        }
    }

    private void d(Canvas canvas) {
        RectF h10 = this.f23124c.h();
        float max = Math.max(com.theartofdev.edmodo.cropper.c.u(this.f23132k), 0.0f);
        float max2 = Math.max(com.theartofdev.edmodo.cropper.c.w(this.f23132k), 0.0f);
        float min = Math.min(com.theartofdev.edmodo.cropper.c.v(this.f23132k), getWidth());
        float min2 = Math.min(com.theartofdev.edmodo.cropper.c.p(this.f23132k), getHeight());
        if (this.f23147z != CropImageView.CropShape.RECTANGLE) {
            this.f23131j.reset();
            if (Build.VERSION.SDK_INT > 17 || this.f23147z != CropImageView.CropShape.OVAL) {
                this.f23126e.set(h10.left, h10.top, h10.right, h10.bottom);
            } else {
                this.f23126e.set(h10.left + 2.0f, h10.top + 2.0f, h10.right - 2.0f, h10.bottom - 2.0f);
            }
            this.f23131j.addOval(this.f23126e, Path.Direction.CW);
            canvas.save();
            canvas.clipPath(this.f23131j, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.f23130i);
            canvas.restore();
        } else if (!n() || Build.VERSION.SDK_INT <= 17) {
            canvas.drawRect(max, max2, min, h10.top, this.f23130i);
            canvas.drawRect(max, h10.bottom, min, min2, this.f23130i);
            canvas.drawRect(max, h10.top, h10.left, h10.bottom, this.f23130i);
            canvas.drawRect(h10.right, h10.top, min, h10.bottom, this.f23130i);
        } else {
            this.f23131j.reset();
            Path path = this.f23131j;
            float[] fArr = this.f23132k;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.f23131j;
            float[] fArr2 = this.f23132k;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.f23131j;
            float[] fArr3 = this.f23132k;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.f23131j;
            float[] fArr4 = this.f23132k;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.f23131j.close();
            canvas.save();
            canvas.clipPath(this.f23131j, Region.Op.INTERSECT);
            canvas.clipRect(h10, Region.Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.f23130i);
            canvas.restore();
        }
    }

    private void e(Canvas canvas) {
        Paint paint = this.f23127f;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF h10 = this.f23124c.h();
            float f10 = strokeWidth / 2.0f;
            h10.inset(f10, f10);
            if (this.f23147z == CropImageView.CropShape.RECTANGLE) {
                canvas.drawRect(h10, this.f23127f);
            } else {
                canvas.drawOval(h10, this.f23127f);
            }
        }
    }

    private void f(Canvas canvas) {
        if (this.f23128g != null) {
            Paint paint = this.f23127f;
            float f10 = 0.0f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f23128g.getStrokeWidth();
            float f11 = strokeWidth2 / 2.0f;
            if (this.f23147z == CropImageView.CropShape.RECTANGLE) {
                f10 = this.f23136o;
            }
            float f12 = f10 + f11;
            RectF h10 = this.f23124c.h();
            h10.inset(f12, f12);
            float f13 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f14 = f11 + f13;
            float f15 = h10.left;
            float f16 = h10.top;
            canvas.drawLine(f15 - f13, f16 - f14, f15 - f13, f16 + this.f23137p, this.f23128g);
            float f17 = h10.left;
            float f18 = h10.top;
            canvas.drawLine(f17 - f14, f18 - f13, f17 + this.f23137p, f18 - f13, this.f23128g);
            float f19 = h10.right;
            float f20 = h10.top;
            canvas.drawLine(f19 + f13, f20 - f14, f19 + f13, f20 + this.f23137p, this.f23128g);
            float f21 = h10.right;
            float f22 = h10.top;
            canvas.drawLine(f21 + f14, f22 - f13, f21 - this.f23137p, f22 - f13, this.f23128g);
            float f23 = h10.left;
            float f24 = h10.bottom;
            canvas.drawLine(f23 - f13, f24 + f14, f23 - f13, f24 - this.f23137p, this.f23128g);
            float f25 = h10.left;
            float f26 = h10.bottom;
            canvas.drawLine(f25 - f14, f26 + f13, f25 + this.f23137p, f26 + f13, this.f23128g);
            float f27 = h10.right;
            float f28 = h10.bottom;
            canvas.drawLine(f27 + f13, f28 + f14, f27 + f13, f28 - this.f23137p, this.f23128g);
            float f29 = h10.right;
            float f30 = h10.bottom;
            canvas.drawLine(f29 + f14, f30 + f13, f29 - this.f23137p, f30 + f13, this.f23128g);
        }
    }

    private void g(Canvas canvas) {
        if (this.f23129h != null) {
            Paint paint = this.f23127f;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF h10 = this.f23124c.h();
            h10.inset(strokeWidth, strokeWidth);
            float width = h10.width() / 3.0f;
            float height = h10.height() / 3.0f;
            if (this.f23147z == CropImageView.CropShape.OVAL) {
                float width2 = (h10.width() / 2.0f) - strokeWidth;
                float height2 = (h10.height() / 2.0f) - strokeWidth;
                float f10 = h10.left + width;
                float f11 = h10.right - width;
                float sin = (float) (height2 * Math.sin(Math.acos((width2 - width) / width2)));
                canvas.drawLine(f10, (h10.top + height2) - sin, f10, (h10.bottom - height2) + sin, this.f23129h);
                canvas.drawLine(f11, (h10.top + height2) - sin, f11, (h10.bottom - height2) + sin, this.f23129h);
                float f12 = h10.top + height;
                float f13 = h10.bottom - height;
                float cos = (float) (width2 * Math.cos(Math.asin((height2 - height) / height2)));
                canvas.drawLine((h10.left + width2) - cos, f12, (h10.right - width2) + cos, f12, this.f23129h);
                canvas.drawLine((h10.left + width2) - cos, f13, (h10.right - width2) + cos, f13, this.f23129h);
                return;
            }
            float f14 = h10.left + width;
            float f15 = h10.right - width;
            canvas.drawLine(f14, h10.top, f14, h10.bottom, this.f23129h);
            canvas.drawLine(f15, h10.top, f15, h10.bottom, this.f23129h);
            float f16 = h10.top + height;
            float f17 = h10.bottom - height;
            canvas.drawLine(h10.left, f16, h10.right, f16, this.f23129h);
            canvas.drawLine(h10.left, f17, h10.right, f17, this.f23129h);
        }
    }

    private void h(RectF rectF) {
        if (rectF.width() < this.f23124c.e()) {
            float e10 = (this.f23124c.e() - rectF.width()) / 2.0f;
            rectF.left -= e10;
            rectF.right += e10;
        }
        if (rectF.height() < this.f23124c.d()) {
            float d10 = (this.f23124c.d() - rectF.height()) / 2.0f;
            rectF.top -= d10;
            rectF.bottom += d10;
        }
        if (rectF.width() > this.f23124c.c()) {
            float width = (rectF.width() - this.f23124c.c()) / 2.0f;
            rectF.left += width;
            rectF.right -= width;
        }
        if (rectF.height() > this.f23124c.b()) {
            float height = (rectF.height() - this.f23124c.b()) / 2.0f;
            rectF.top += height;
            rectF.bottom -= height;
        }
        b(rectF);
        if (this.f23133l.width() > 0.0f && this.f23133l.height() > 0.0f) {
            float max = Math.max(this.f23133l.left, 0.0f);
            float max2 = Math.max(this.f23133l.top, 0.0f);
            float min = Math.min(this.f23133l.right, getWidth());
            float min2 = Math.min(this.f23133l.bottom, getHeight());
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
        if (this.f23142u && Math.abs(rectF.width() - (rectF.height() * this.f23145x)) > 0.1d) {
            if (rectF.width() > rectF.height() * this.f23145x) {
                float abs = Math.abs((rectF.height() * this.f23145x) - rectF.width()) / 2.0f;
                rectF.left += abs;
                rectF.right -= abs;
                return;
            }
            float abs2 = Math.abs((rectF.width() / this.f23145x) - rectF.height()) / 2.0f;
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
        float max = Math.max(com.theartofdev.edmodo.cropper.c.u(this.f23132k), 0.0f);
        float max2 = Math.max(com.theartofdev.edmodo.cropper.c.w(this.f23132k), 0.0f);
        float min = Math.min(com.theartofdev.edmodo.cropper.c.v(this.f23132k), getWidth());
        float min2 = Math.min(com.theartofdev.edmodo.cropper.c.p(this.f23132k), getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.B = true;
            float f10 = this.f23138q;
            float f11 = min - max;
            float f12 = f10 * f11;
            float f13 = min2 - max2;
            float f14 = f10 * f13;
            if (this.A.width() > 0 && this.A.height() > 0) {
                rectF.left = (this.A.left / this.f23124c.k()) + max;
                rectF.top = (this.A.top / this.f23124c.j()) + max2;
                rectF.right = rectF.left + (this.A.width() / this.f23124c.k());
                rectF.bottom = rectF.top + (this.A.height() / this.f23124c.j());
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.f23142u || min <= max || min2 <= max2) {
                rectF.left = max + f12;
                rectF.top = max2 + f14;
                rectF.right = min - f12;
                rectF.bottom = min2 - f14;
            } else if (f11 / f13 > this.f23145x) {
                rectF.top = max2 + f14;
                rectF.bottom = min2 - f14;
                float width = getWidth() / 2.0f;
                this.f23145x = this.f23143v / this.f23144w;
                float max3 = Math.max(this.f23124c.e(), rectF.height() * this.f23145x) / 2.0f;
                rectF.left = width - max3;
                rectF.right = width + max3;
            } else {
                rectF.left = max + f12;
                rectF.right = min - f12;
                float height = getHeight() / 2.0f;
                float max4 = Math.max(this.f23124c.d(), rectF.width() / this.f23145x) / 2.0f;
                rectF.top = height - max4;
                rectF.bottom = height + max4;
            }
            h(rectF);
            this.f23124c.r(rectF);
        }
    }

    private boolean n() {
        float[] fArr = this.f23132k;
        return (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
    }

    private void o(float f10, float f11) {
        CropWindowMoveHandler f12 = this.f23124c.f(f10, f11, this.f23139r, this.f23147z);
        this.f23141t = f12;
        if (f12 != null) {
            invalidate();
        }
    }

    private void p(float f10, float f11) {
        if (this.f23141t != null) {
            float f12 = this.f23140s;
            RectF h10 = this.f23124c.h();
            if (b(h10)) {
                f12 = 0.0f;
            }
            this.f23141t.m(h10, f10, f11, this.f23133l, this.f23134m, this.f23135n, f12, this.f23142u, this.f23145x);
            this.f23124c.r(h10);
            c(true);
            invalidate();
        }
    }

    private void q() {
        if (this.f23141t != null) {
            this.f23141t = null;
            c(false);
            invalidate();
        }
    }

    public int getAspectRatioX() {
        return this.f23143v;
    }

    public int getAspectRatioY() {
        return this.f23144w;
    }

    public CropImageView.CropShape getCropShape() {
        return this.f23147z;
    }

    public RectF getCropWindowRect() {
        return this.f23124c.h();
    }

    public CropImageView.Guidelines getGuidelines() {
        return this.f23146y;
    }

    public Rect getInitialCropWindowRect() {
        return this.A;
    }

    public void i() {
        RectF cropWindowRect = getCropWindowRect();
        h(cropWindowRect);
        this.f23124c.r(cropWindowRect);
    }

    public boolean m() {
        return this.f23142u;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        if (this.f23124c.s()) {
            CropImageView.Guidelines guidelines = this.f23146y;
            if (guidelines == CropImageView.Guidelines.ON) {
                g(canvas);
            } else if (guidelines == CropImageView.Guidelines.ON_TOUCH && this.f23141t != null) {
                g(canvas);
            }
        }
        e(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f23123b) {
            this.f23122a.onTouchEvent(motionEvent);
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
        if (this.B) {
            setCropWindowRect(com.theartofdev.edmodo.cropper.c.f23190b);
            l();
            invalidate();
        }
    }

    public void s(float[] fArr, int i10, int i11) {
        if (fArr == null || !Arrays.equals(this.f23132k, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f23132k, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f23132k, 0, fArr.length);
            }
            this.f23134m = i10;
            this.f23135n = i11;
            RectF h10 = this.f23124c.h();
            if (h10.width() == 0.0f || h10.height() == 0.0f) {
                l();
            }
        }
    }

    public void setAspectRatioX(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f23143v != i10) {
            this.f23143v = i10;
            this.f23145x = i10 / this.f23144w;
            if (this.B) {
                l();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f23144w != i10) {
            this.f23144w = i10;
            this.f23145x = this.f23143v / i10;
            if (this.B) {
                l();
                invalidate();
            }
        }
    }

    public void setCropShape(CropImageView.CropShape cropShape) {
        if (this.f23147z != cropShape) {
            this.f23147z = cropShape;
            if (Build.VERSION.SDK_INT <= 17) {
                if (cropShape == CropImageView.CropShape.OVAL) {
                    Integer valueOf = Integer.valueOf(getLayerType());
                    this.C = valueOf;
                    if (valueOf.intValue() != 1) {
                        setLayerType(1, null);
                    } else {
                        this.C = null;
                    }
                } else {
                    Integer num = this.C;
                    if (num != null) {
                        setLayerType(num.intValue(), null);
                        this.C = null;
                    }
                }
            }
            invalidate();
        }
    }

    public void setCropWindowChangeListener(b bVar) {
        this.f23125d = bVar;
    }

    public void setCropWindowRect(RectF rectF) {
        this.f23124c.r(rectF);
    }

    public void setFixedAspectRatio(boolean z10) {
        if (this.f23142u != z10) {
            this.f23142u = z10;
            if (this.B) {
                l();
                invalidate();
            }
        }
    }

    public void setGuidelines(CropImageView.Guidelines guidelines) {
        if (this.f23146y != guidelines) {
            this.f23146y = guidelines;
            if (this.B) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(CropImageOptions cropImageOptions) {
        this.f23124c.q(cropImageOptions);
        setCropShape(cropImageOptions.f23061a);
        setSnapRadius(cropImageOptions.f23062b);
        setGuidelines(cropImageOptions.f23064d);
        setFixedAspectRatio(cropImageOptions.f23072l);
        setAspectRatioX(cropImageOptions.f23073m);
        setAspectRatioY(cropImageOptions.f23074n);
        u(cropImageOptions.f23069i);
        this.f23139r = cropImageOptions.f23063c;
        this.f23138q = cropImageOptions.f23071k;
        this.f23127f = k(cropImageOptions.f23075o, cropImageOptions.f23076p);
        this.f23136o = cropImageOptions.f23078r;
        this.f23137p = cropImageOptions.f23079s;
        this.f23128g = k(cropImageOptions.f23077q, cropImageOptions.f23080t);
        this.f23129h = k(cropImageOptions.f23081u, cropImageOptions.f23082v);
        this.f23130i = j(cropImageOptions.f23083w);
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.A;
        if (rect == null) {
            rect = com.theartofdev.edmodo.cropper.c.f23189a;
        }
        rect2.set(rect);
        if (this.B) {
            l();
            invalidate();
            c(false);
        }
    }

    public void setSnapRadius(float f10) {
        this.f23140s = f10;
    }

    public void t(float f10, float f11, float f12, float f13) {
        this.f23124c.p(f10, f11, f12, f13);
    }

    public boolean u(boolean z10) {
        if (this.f23123b == z10) {
            return false;
        }
        this.f23123b = z10;
        if (!z10 || this.f23122a != null) {
            return true;
        }
        this.f23122a = new ScaleGestureDetector(getContext(), new c());
        return true;
    }
}
