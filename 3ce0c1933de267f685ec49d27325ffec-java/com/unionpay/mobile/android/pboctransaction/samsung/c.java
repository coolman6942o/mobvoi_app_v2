package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f23806a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            this.f23806a.a(false);
        }
        return true;
    }
}
