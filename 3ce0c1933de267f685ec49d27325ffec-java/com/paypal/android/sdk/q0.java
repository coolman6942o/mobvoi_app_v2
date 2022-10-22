package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f21858a;

    public q0(p0 p0Var) {
        this.f21858a = new WeakReference(p0Var);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        p0 p0Var;
        if (message.what == 2 && (p0Var = (p0) this.f21858a.get()) != null) {
            p0Var.f21498c.c((r1) message.obj, 0L);
        }
    }
}
