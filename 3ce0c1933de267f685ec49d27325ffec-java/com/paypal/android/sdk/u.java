package com.paypal.android.sdk;

import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ t f22006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f22006a = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        String str;
        int i10;
        String str2;
        String str3;
        long j10;
        Timer timer;
        t.a(this.f22006a);
        str = t.f21948v;
        StringBuilder sb2 = new StringBuilder("****** LogRiskMetadataTask #");
        i10 = this.f22006a.f21956e;
        sb2.append(i10);
        m0.l(str, sb2.toString());
        if (t.o(this.f22006a)) {
            str3 = t.f21948v;
            StringBuilder sb3 = new StringBuilder("No host activity in the last ");
            j10 = this.f22006a.f21955d;
            sb3.append(j10 / 1000);
            sb3.append(" seconds. Stopping update interval.");
            m0.l(str3, sb3.toString());
            timer = this.f22006a.f21966o;
            timer.cancel();
            return;
        }
        try {
            t.u(this.f22006a);
        } catch (Exception e10) {
            str2 = t.f21948v;
            m0.m(str2, "Error in logRiskMetadataTask: ", e10);
        }
    }
}
