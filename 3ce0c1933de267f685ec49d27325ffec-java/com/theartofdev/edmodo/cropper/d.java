package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropImageAnimation.java */
/* loaded from: classes2.dex */
public final class d extends Animation implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f23200a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f23201b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f23202c = new float[8];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f23203d = new float[8];

    /* renamed from: e  reason: collision with root package name */
    private final RectF f23204e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f23205f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f23206g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    private final float[] f23207h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    private final RectF f23208i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f23209j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    private final float[] f23210k = new float[9];

    public d(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f23200a = imageView;
        this.f23201b = cropOverlayView;
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void a(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f23203d, 0, 8);
        this.f23205f.set(this.f23201b.getCropWindowRect());
        matrix.getValues(this.f23207h);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f10, Transformation transformation) {
        float[] fArr;
        RectF rectF = this.f23208i;
        RectF rectF2 = this.f23204e;
        float f11 = rectF2.left;
        RectF rectF3 = this.f23205f;
        rectF.left = f11 + ((rectF3.left - f11) * f10);
        float f12 = rectF2.top;
        rectF.top = f12 + ((rectF3.top - f12) * f10);
        float f13 = rectF2.right;
        rectF.right = f13 + ((rectF3.right - f13) * f10);
        float f14 = rectF2.bottom;
        rectF.bottom = f14 + ((rectF3.bottom - f14) * f10);
        this.f23201b.setCropWindowRect(rectF);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            fArr = this.f23209j;
            if (i11 >= fArr.length) {
                break;
            }
            float[] fArr2 = this.f23202c;
            fArr[i11] = fArr2[i11] + ((this.f23203d[i11] - fArr2[i11]) * f10);
            i11++;
        }
        this.f23201b.s(fArr, this.f23200a.getWidth(), this.f23200a.getHeight());
        while (true) {
            float[] fArr3 = this.f23210k;
            if (i10 < fArr3.length) {
                float[] fArr4 = this.f23206g;
                fArr3[i10] = fArr4[i10] + ((this.f23207h[i10] - fArr4[i10]) * f10);
                i10++;
            } else {
                Matrix imageMatrix = this.f23200a.getImageMatrix();
                imageMatrix.setValues(this.f23210k);
                this.f23200a.setImageMatrix(imageMatrix);
                this.f23200a.invalidate();
                this.f23201b.invalidate();
                return;
            }
        }
    }

    public void b(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f23202c, 0, 8);
        this.f23204e.set(this.f23201b.getCropWindowRect());
        matrix.getValues(this.f23206g);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f23200a.clearAnimation();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
