package com.mobvoi.companion.browser;

import android.os.Message;
import android.os.Process;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
/* compiled from: WebProcessHandlerWrapper.java */
/* loaded from: classes2.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b() {
        k.a("WebProcessHandler", "close WebView process");
        Process.killProcess(Process.myPid());
    }

    public static void c() {
        d(4096);
    }

    public static void d(int i10) {
        b.i().removeMessages(i10);
    }

    public static void e(int i10) {
        f(4096, i10, d.f16661a);
    }

    public static void f(int i10, int i11, Runnable runnable) {
        Message obtain = Message.obtain(b.i(), runnable);
        obtain.what = i10;
        b.i().sendMessageDelayed(obtain, i11 >= 0 ? i11 : 120000L);
    }
}
