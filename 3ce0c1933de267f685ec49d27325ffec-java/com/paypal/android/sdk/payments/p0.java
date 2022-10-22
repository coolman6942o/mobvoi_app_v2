package com.paypal.android.sdk.payments;

import java.util.TimerTask;
/* loaded from: classes2.dex */
final class p0 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ o0 f21791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(o0 o0Var) {
        this.f21791a = o0Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f21791a.f21784a.f();
    }
}
