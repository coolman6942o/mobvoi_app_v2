package com.mobvoi.companion.view.crop;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
/* compiled from: CropImageAnimation.java */
/* loaded from: classes2.dex */
final class d extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f17787a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f17788b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f17789c = new float[8];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f17790d = new float[8];

    /* renamed from: e  reason: collision with root package name */
    private final RectF f17791e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f17792f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f17793g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    private final float[] f17794h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    private final RectF f17795i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f17796j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    private final float[] f17797k = new float[9];

    public d(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f17787a = imageView;
        this.f17788b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void a(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f17790d, 0, 8);
        this.f17792f.set(this.f17788b.getCropWindowRect());
        matrix.getValues(this.f17794h);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f10, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.f17795i;
        RectF rectF2 = this.f17791e;
        float f11 = rectF2.left;
        RectF rectF3 = this.f17792f;
        rectF.left = f11 + ((rectF3.left - f11) * f10);
        float f12 = rectF2.top;
        rectF.top = f12 + ((rectF3.top - f12) * f10);
        float f13 = rectF2.right;
        rectF.right = f13 + ((rectF3.right - f13) * f10);
        float f14 = rectF2.bottom;
        rectF.bottom = f14 + ((rectF3.bottom - f14) * f10);
        this.f17788b.setCropWindowRect(rectF);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            fArr = this.f17796j;
            if (i11 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.f17789c;
            fArr[i11] = fArr2[i11] + ((this.f17790d[i11] - fArr2[i11]) * f10);
            i11++;
        }
        this.f17788b.s(fArr, this.f17787a.getWidth(), this.f17787a.getHeight());
        while (true) {
            float[] fArr3 = this.f17797k;
            if (i10 < fArr3.length) {
                float[] fArr4 = this.f17793g;
                fArr3[i10] = fArr4[i10] + ((this.f17794h[i10] - fArr4[i10]) * f10);
                i10++;
            } else {
                Matrix imageMatrix = this.f17787a.getImageMatrix();
                imageMatrix.setValues(this.f17797k);
                this.f17787a.setImageMatrix(imageMatrix);
                this.f17787a.invalidate();
                this.f17788b.invalidate();
                return;
            }
        }
    }

    public void b(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f17789c, 0, 8);
        this.f17791e.set(this.f17788b.getCropWindowRect());
        matrix.getValues(this.f17793g);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f17787a.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
