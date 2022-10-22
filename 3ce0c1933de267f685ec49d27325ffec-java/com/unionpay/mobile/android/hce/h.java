package com.unionpay.mobile.android.hce;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23404a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f23405b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f23406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, String str, String str2) {
        this.f23406c = fVar;
        this.f23404a = str;
        this.f23405b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean a10;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        int i10;
        a10 = this.f23406c.a(this.f23404a, this.f23405b);
        if (a10) {
            handler4 = this.f23406c.f23402y;
            if (handler4 != null) {
                handler5 = this.f23406c.f23402y;
                Message obtainMessage = handler5.obtainMessage(2006, this.f23404a);
                handler6 = this.f23406c.f23402y;
                i10 = this.f23406c.f23387i;
                handler6.sendMessageDelayed(obtainMessage, i10);
                return;
            }
            return;
        }
        handler = this.f23406c.f23402y;
        if (handler != null) {
            handler2 = this.f23406c.f23402y;
            Message obtainMessage2 = handler2.obtainMessage(2005, this.f23404a);
            handler3 = this.f23406c.f23402y;
            handler3.sendMessage(obtainMessage2);
        }
    }
}
