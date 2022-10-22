package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public final class i1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f8631a;

    /* renamed from: b  reason: collision with root package name */
    private final j1 f8632b;

    public i1(j1 j1Var) {
        this.f8632b = j1Var;
    }

    public final synchronized void a() {
        Context context = this.f8631a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f8631a = null;
    }

    public final void b(Context context) {
        this.f8631a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f8632b.a();
            a();
        }
    }
}
