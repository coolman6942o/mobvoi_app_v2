package com.paypal.android.sdk.payments;

import java.util.TimerTask;
/* loaded from: classes2.dex */
final class p1 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ o1 f21792a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1(o1 o1Var) {
        this.f21792a = o1Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f21792a.f21785a.f();
    }
}
