package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ t f22030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.f22030a = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        String str;
        int i10;
        Context context;
        String str2;
        Handler handler;
        t.v(this.f22030a);
        str = t.f21948v;
        StringBuilder sb2 = new StringBuilder("****** LoadConfigurationTask #");
        i10 = this.f22030a.f21957f;
        sb2.append(i10);
        m0.l(str, sb2.toString());
        context = this.f22030a.f21952a;
        str2 = this.f22030a.f21959h;
        handler = this.f22030a.f21967p;
        i0.a().b(new d0(context, str2, handler));
    }
}
