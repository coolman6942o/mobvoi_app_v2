package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
/* compiled from: ViewfinderView.java */
/* loaded from: classes2.dex */
class G implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewfinderView f14083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(ViewfinderView viewfinderView) {
        this.f14083a = viewfinderView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f14083a.f14096m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f14083a.invalidate();
    }
}
