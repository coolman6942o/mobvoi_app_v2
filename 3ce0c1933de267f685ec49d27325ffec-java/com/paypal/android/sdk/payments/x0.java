package com.paypal.android.sdk.payments;

import java.util.TimerTask;
/* loaded from: classes2.dex */
final class x0 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ w0 f21845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(w0 w0Var) {
        this.f21845a = w0Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        ProfileSharingConsentActivity.y(r0, 1, this.f21845a.f21821a.f21584c.S());
    }
}
