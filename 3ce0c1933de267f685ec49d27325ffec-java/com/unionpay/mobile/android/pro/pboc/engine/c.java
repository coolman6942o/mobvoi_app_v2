package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f23898a = bVar;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void a() {
        this.f23898a.b(1);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f23898a.f23879h;
        if (handler != null) {
            k.c("UPCardEngine", "mSDInitCallback.initFailed!!!!");
            handler2 = this.f23898a.f23879h;
            Message obtainMessage = handler2.obtainMessage(1, null);
            handler3 = this.f23898a.f23879h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
