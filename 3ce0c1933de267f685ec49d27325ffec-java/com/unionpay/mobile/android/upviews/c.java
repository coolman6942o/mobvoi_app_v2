package com.unionpay.mobile.android.upviews;

import com.unionpay.mobile.android.upviews.b;
import java.util.TimerTask;
/* loaded from: classes2.dex */
final class c extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.d f24005a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.d dVar) {
        this.f24005a = dVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        boolean z10;
        z10 = b.this.f24001e;
        if (!z10) {
            b.this.f23998b.sendEmptyMessage(3);
        }
        b.this.f24000d.cancel();
        b.this.f24000d.purge();
    }
}
