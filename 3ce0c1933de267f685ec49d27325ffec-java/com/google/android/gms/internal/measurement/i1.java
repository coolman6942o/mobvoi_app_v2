package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final j5 f9356a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9357b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9358c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(j5 j5Var) {
        i.k(j5Var);
        this.f9356a = j5Var;
    }

    public final void a() {
        this.f9356a.U();
        this.f9356a.p();
        this.f9356a.p();
        if (this.f9357b) {
            this.f9356a.c().R().a("Unregistering connectivity change receiver");
            this.f9357b = false;
            this.f9358c = false;
            try {
                this.f9356a.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f9356a.c().K().d("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    public final void c() {
        this.f9356a.U();
        this.f9356a.p();
        if (!this.f9357b) {
            this.f9356a.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f9358c = this.f9356a.R().C();
            this.f9356a.c().R().d("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f9358c));
            this.f9357b = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f9356a.U();
        String action = intent.getAction();
        this.f9356a.c().R().d("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean C = this.f9356a.R().C();
            if (this.f9358c != C) {
                this.f9358c = C;
                this.f9356a.d().J(new j1(this, C));
                return;
            }
            return;
        }
        this.f9356a.c().N().d("NetworkBroadcastReceiver received unknown action", action);
    }
}
