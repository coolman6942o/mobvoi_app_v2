package com.mobvoi.companion.health;

import ah.c;
import android.annotation.SuppressLint;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.WearableModule;
import com.mobvoi.health.common.data.db.HealthDatabase;
import com.mobvoi.health.companion.provider.SportLocationReceiver;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import eg.a;
import ig.b;
import yg.f;
/* compiled from: HealthModule.java */
/* loaded from: classes2.dex */
public class k1 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static p0 f16870a;

    /* renamed from: b  reason: collision with root package name */
    private static m3 f16871b;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static q0 f16872c;

    public static void a(a4 a4Var) {
        q0 q0Var = f16872c;
        if (q0Var == null) {
            k.q("health.module", "Health module not initialed.");
        } else {
            q0Var.t(a4Var);
        }
    }

    public static void b() {
        AccountManager.h().p(f16871b);
        AccountManager.h().p(f16870a);
        MessageProxyClient.getInstance().removeListener(f16872c);
        c.c().b();
        com.mobvoi.health.companion.system.c.c().b();
    }

    public static void c(Context context, WearableModule.WearableType wearableType) {
        k.h("health.module", "Init health module.");
        Context applicationContext = context.getApplicationContext();
        HealthDatabase.G(applicationContext);
        f16872c = new q0(applicationContext);
        c.c().d(f16872c);
        com.mobvoi.health.companion.system.c.c().d(f16872c);
        MessageProxyClient.getInstance().addListener(f16872c);
        f16870a = new p0(applicationContext);
        f16871b = new m3();
        boolean z10 = true;
        AccountManager.h().d(f16871b, true);
        AccountManager.h().d(f16870a, true);
        a.h(context);
        a e10 = a.e();
        if (wearableType == WearableModule.WearableType.TicBand) {
            z10 = false;
        }
        e10.q(z10);
        f.Y(context);
        b.L(context);
        SportLocationReceiver.c(context, SportLocationReceiver.b(context));
    }
}
