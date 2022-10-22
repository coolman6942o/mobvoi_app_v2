package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import q6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y0 extends i {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w0 f8793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(w0 w0Var, Looper looper) {
        super(looper);
        this.f8793a = w0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            ((x0) message.obj).b(this.f8793a);
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i10);
            Log.w("GACStateManager", sb2.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
