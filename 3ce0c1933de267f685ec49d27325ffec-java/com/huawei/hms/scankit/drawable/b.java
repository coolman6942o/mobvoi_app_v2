package com.huawei.hms.scankit.drawable;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.animation.Interpolator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScanDrawable.java */
/* loaded from: classes2.dex */
public class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDrawable f14344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ScanDrawable scanDrawable) {
        this.f14344a = scanDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2;
        Rect rect;
        Rect rect2;
        Interpolator interpolator;
        Interpolator interpolator2;
        Interpolator interpolator3;
        valueAnimator2 = this.f14344a.f14316f;
        float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
        ScanDrawable scanDrawable = this.f14344a;
        rect = scanDrawable.f14325o;
        int i10 = rect.top;
        rect2 = this.f14344a.f14325o;
        interpolator = ScanDrawable.f14312b;
        scanDrawable.f14331u = i10 + ((int) (rect2.height() * interpolator.getInterpolation(floatValue)));
        if (floatValue < 0.389f) {
            ScanDrawable scanDrawable2 = this.f14344a;
            interpolator3 = ScanDrawable.f14313c;
            scanDrawable2.f14330t = interpolator3.getInterpolation(floatValue / 0.389f);
        } else {
            ScanDrawable scanDrawable3 = this.f14344a;
            interpolator2 = ScanDrawable.f14314d;
            scanDrawable3.f14330t = 1.0f - interpolator2.getInterpolation((floatValue - 0.389f) / 0.611f);
        }
        this.f14344a.invalidateSelf();
    }
}
