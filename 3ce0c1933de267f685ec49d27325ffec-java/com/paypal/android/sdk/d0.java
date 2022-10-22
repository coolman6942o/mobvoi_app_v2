package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class d0 extends h0 {

    /* renamed from: d  reason: collision with root package name */
    private static final String f21100d = d0.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Context f21101a;

    /* renamed from: b  reason: collision with root package name */
    private String f21102b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f21103c;

    public d0(Context context, String str, Handler handler) {
        this.f21101a = context;
        this.f21102b = str;
        this.f21103c = handler;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.paypal.android.sdk.h0, java.lang.Runnable
    public void run() {
        m0.l(f21100d, "entering LoadConfigurationRequest.");
        Handler handler = this.f21103c;
        if (handler != null) {
            try {
                try {
                    handler.sendMessage(Message.obtain(handler, 10, this.f21102b));
                    p pVar = new p(this.f21101a, this.f21102b);
                    Handler handler2 = this.f21103c;
                    handler2.sendMessage(Message.obtain(handler2, 12, pVar));
                } catch (Exception e10) {
                    m0.m(f21100d, "LoadConfigurationRequest loading remote config failed.", e10);
                    Handler handler3 = this.f21103c;
                    handler3.sendMessage(Message.obtain(handler3, 11, e10));
                }
                i0.a().d(this);
                m0.l(f21100d, "leaving LoadConfigurationRequest.");
            } catch (Throwable th2) {
                i0.a().d(this);
                throw th2;
            }
        }
    }
}
