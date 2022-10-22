package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.f23904a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        Handler handler;
        Handler handler2;
        Handler handler3;
        synchronized (this.f23904a) {
            k.c("UPCardEngine", " ic_return : 4");
            dVar = this.f23904a.f23891t;
            ArrayList<c> b10 = dVar.b();
            handler = this.f23904a.f23879h;
            if (handler != null) {
                handler2 = this.f23904a.f23879h;
                Message obtainMessage = handler2.obtainMessage(4, b10);
                handler3 = this.f23904a.f23879h;
                handler3.sendMessage(obtainMessage);
            }
        }
    }
}
