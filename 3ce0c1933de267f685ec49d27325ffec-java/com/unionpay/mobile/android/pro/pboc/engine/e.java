package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f23900a = bVar;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void a() {
        this.f23900a.b(4);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f23900a.f23879h;
        if (handler != null) {
            handler2 = this.f23900a.f23879h;
            Message obtainMessage = handler2.obtainMessage(4, null);
            handler3 = this.f23900a.f23879h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
