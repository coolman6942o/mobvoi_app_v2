package com.paypal.android.sdk.payments;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ c f21692a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, Looper looper) {
        super(looper);
        this.f21692a = cVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            c.d(this.f21692a);
        }
    }
}
