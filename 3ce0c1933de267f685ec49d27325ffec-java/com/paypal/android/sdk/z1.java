package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
final class z1 implements Executor {
    private z1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z1(byte b10) {
        this();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
