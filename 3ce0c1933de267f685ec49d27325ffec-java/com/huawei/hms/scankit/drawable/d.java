package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.huawei.hms.scankit.p.Ic;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScanDrawable.java */
/* loaded from: classes2.dex */
public class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDrawable f14346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ScanDrawable scanDrawable) {
        this.f14346a = scanDrawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        ValueAnimator valueAnimator;
        boolean z10;
        boolean z11;
        super.onAnimationRepeat(animator);
        valueAnimator = this.f14346a.f14316f;
        float abs = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue() - 0.5f);
        ScanDrawable scanDrawable = this.f14346a;
        z10 = scanDrawable.f14334x;
        scanDrawable.f14334x = !z10;
        z11 = this.f14346a.f14334x;
        if (!z11) {
            return;
        }
        if (abs > 0.35f) {
            this.f14346a.f14328r = 0.0f;
            return;
        }
        this.f14346a.f14328r = Ic.a(0.5f);
    }
}
