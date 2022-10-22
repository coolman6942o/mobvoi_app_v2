package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScanDrawable.java */
/* loaded from: classes2.dex */
public class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDrawable f14345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ScanDrawable scanDrawable) {
        this.f14345a = scanDrawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        boolean z10;
        super.onAnimationRepeat(animator);
        ScanDrawable scanDrawable = this.f14345a;
        z10 = scanDrawable.f14329s;
        scanDrawable.f14329s = !z10;
    }
}
