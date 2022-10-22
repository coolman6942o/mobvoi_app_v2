package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
/* loaded from: classes.dex */
final class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private o f12513a;

    public p(o oVar) {
        this.f12513a = oVar;
    }

    public final void a() {
        if (FirebaseInstanceId.u()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f12513a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        o oVar = this.f12513a;
        if (oVar != null && oVar.d()) {
            if (FirebaseInstanceId.u()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.j(this.f12513a, 0L);
            this.f12513a.a().unregisterReceiver(this);
            this.f12513a = null;
        }
    }
}
