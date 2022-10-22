package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f23901a = bVar;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void a() {
        com.unionpay.mobile.android.pboctransaction.samsung.f fVar;
        com.unionpay.mobile.android.pboctransaction.samsung.f fVar2;
        k.c("uppay-spay", "tsmservice  init success");
        com.unionpay.mobile.android.model.b.f23495bn = false;
        fVar = this.f23901a.f23896y;
        if (fVar != null) {
            fVar2 = this.f23901a.f23896y;
            if (!fVar2.e()) {
                com.unionpay.mobile.android.model.b.aB = false;
                this.f23901a.b(8);
                return;
            }
            return;
        }
        this.f23901a.b(8);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.b
    public final void b() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        k.c("UPCardEngine", "mSE init failed");
        k.c("uppay-spay", "tsmservice  init fail");
        handler = this.f23901a.f23879h;
        if (handler != null) {
            handler2 = this.f23901a.f23879h;
            Message obtainMessage = handler2.obtainMessage(8, null);
            handler3 = this.f23901a.f23879h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
