package com.unionpay.mobile.android.pro.pboc.engine;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f23905a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        d dVar2;
        boolean a10;
        Handler handler;
        Handler handler2;
        Message obtainMessage;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        synchronized (this.f23905a) {
            k.c("UPCardEngine", " se_return : 8");
            if (b.f23494bm) {
                handler4 = this.f23905a.f23879h;
                if (handler4 != null) {
                    handler5 = this.f23905a.f23879h;
                    obtainMessage = handler5.obtainMessage(8, new ArrayList());
                    handler3 = this.f23905a.f23879h;
                    handler3.sendMessage(obtainMessage);
                }
            } else {
                dVar = this.f23905a.f23894w;
                if (dVar != null) {
                    dVar2 = this.f23905a.f23894w;
                    ArrayList<c> b10 = dVar2.b();
                    a10 = this.f23905a.a("com.unionpay.tsmservice", 18);
                    if (!a10) {
                        handler = this.f23905a.f23879h;
                        if (handler != null) {
                            handler2 = this.f23905a.f23879h;
                            obtainMessage = handler2.obtainMessage(8, b10);
                            handler3 = this.f23905a.f23879h;
                            handler3.sendMessage(obtainMessage);
                        }
                    }
                }
            }
        }
    }
}
