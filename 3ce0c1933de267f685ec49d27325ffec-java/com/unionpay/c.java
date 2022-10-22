package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.a.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        d dVar;
        Context context;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        try {
            handler = UPPayAssistEx.U;
            handler.sendEmptyMessageDelayed(1001, 800L);
            dVar = UPPayAssistEx.T;
            context = UPPayAssistEx.I;
            com.unionpay.a.c cVar = new com.unionpay.a.c(dVar, context);
            cVar.a();
            String b10 = cVar.b();
            handler2 = UPPayAssistEx.U;
            if (handler2 != null) {
                handler3 = UPPayAssistEx.U;
                Message obtainMessage = handler3.obtainMessage();
                obtainMessage.what = 1002;
                obtainMessage.obj = b10;
                handler4 = UPPayAssistEx.U;
                handler4.removeMessages(1001);
                handler5 = UPPayAssistEx.U;
                handler5.sendMessage(obtainMessage);
            }
        } catch (Exception unused) {
        }
    }
}
