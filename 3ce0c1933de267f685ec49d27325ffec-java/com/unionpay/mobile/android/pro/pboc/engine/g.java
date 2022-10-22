package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.f23902a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        Handler handler;
        Handler handler2;
        Handler handler3;
        k.c("UPCardEngine", " sd_return : 1");
        dVar = this.f23902a.f23885n;
        ArrayList<c> b10 = dVar.b();
        handler = this.f23902a.f23879h;
        if (handler != null) {
            handler2 = this.f23902a.f23879h;
            Message obtainMessage = handler2.obtainMessage(1, b10);
            handler3 = this.f23902a.f23879h;
            handler3.sendMessage(obtainMessage);
        }
    }
}
