package com.unionpay.mobile.android.widgets;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ar extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f24323a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ap f24324b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar, int i10) {
        this.f24324b = apVar;
        this.f24323a = i10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        int i10;
        Handler handler3;
        Handler handler4;
        handler = this.f24324b.f24320p;
        if (handler != null) {
            long currentTimeMillis = System.currentTimeMillis() + (this.f24323a * 1000);
            while (true) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 > currentTimeMillis || (i10 = (int) (((currentTimeMillis - currentTimeMillis2) + this.f24323a) / 1000)) <= 0) {
                    break;
                }
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.arg1 = i10;
                handler3 = this.f24324b.f24320p;
                handler3.sendMessage(obtain);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    handler4 = this.f24324b.f24320p;
                    handler4.sendEmptyMessage(1);
                    return;
                }
            }
            handler2 = this.f24324b.f24320p;
            handler2.sendEmptyMessage(1);
        }
    }
}
