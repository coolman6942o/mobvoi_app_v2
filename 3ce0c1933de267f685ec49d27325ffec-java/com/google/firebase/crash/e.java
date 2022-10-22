package com.google.firebase.crash;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.measurement.m7;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.zzxs;
import com.google.firebase.a;
import com.google.firebase.b;
import h6.g;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k6.d;
/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Future f12447a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f12448b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ g f12449c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ c f12450d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, Future future, long j10, g gVar) {
        this.f12450d = cVar;
        this.f12447a = future;
        this.f12449c = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m7 m7Var;
        Context context;
        a aVar;
        Context context2;
        Context context3;
        boolean z10 = true;
        try {
            m7Var = (m7) this.f12447a.get(this.f12448b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            Log.e("FirebaseCrash", "Failed to load crash reporting in time", e10);
            this.f12447a.cancel(true);
            m7Var = null;
        }
        if (m7Var == null) {
            this.f12449c.a();
            return;
        }
        try {
            aVar = this.f12450d.f12444a;
            b e11 = aVar.e();
            zzxs zzxsVar = new zzxs(e11.c(), e11.b());
            context2 = this.f12450d.f12445b;
            m7Var.Y(d.A2(context2), zzxsVar);
            m7Var.s(new ArrayList());
            context3 = this.f12450d.f12445b;
            com.google.android.gms.common.api.internal.b.c((Application) context3.getApplicationContext());
            if (com.google.android.gms.common.api.internal.b.b().d()) {
                z10 = false;
            }
            m7Var.l0(z10);
            com.google.android.gms.common.api.internal.b.b().a(new f(this));
            String valueOf = String.valueOf(o7.b());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 36);
            sb2.append("FirebaseCrash reporting initialized ");
            sb2.append(valueOf);
            Log.i("FirebaseCrash", sb2.toString());
            this.f12449c.b(m7Var);
        } catch (Exception e12) {
            Log.e("FirebaseCrash", "Failed to initialize crash reporting", e12);
            context = this.f12450d.f12445b;
            g.a(context, e12);
            this.f12449c.a();
        }
    }
}
