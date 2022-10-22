package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import q6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t0 extends i {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ n0 f8732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(n0 n0Var, Looper looper) {
        super(looper);
        this.f8732a = n0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            this.f8732a.C();
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i10);
            Log.w("GoogleApiClientImpl", sb2.toString());
        } else {
            this.f8732a.w();
        }
    }
}
