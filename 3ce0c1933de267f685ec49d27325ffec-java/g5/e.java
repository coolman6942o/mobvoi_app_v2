package g5;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import g5.c;
import n5.j;
/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f27263a;

    /* renamed from: b  reason: collision with root package name */
    final c.a f27264b;

    /* renamed from: c  reason: collision with root package name */
    boolean f27265c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27266d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f27267e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z10 = eVar.f27265c;
            eVar.f27265c = eVar.i(context);
            if (z10 != e.this.f27265c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f27265c);
                }
                e eVar2 = e.this;
                eVar2.f27264b.a(eVar2.f27265c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, c.a aVar) {
        this.f27263a = context.getApplicationContext();
        this.f27264b = aVar;
    }

    private void j() {
        if (!this.f27266d) {
            this.f27265c = i(this.f27263a);
            try {
                this.f27263a.registerReceiver(this.f27267e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f27266d = true;
            } catch (SecurityException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e10);
                }
            }
        }
    }

    private void k() {
        if (this.f27266d) {
            this.f27263a.unregisterReceiver(this.f27267e);
            this.f27266d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
            }
            return true;
        }
    }

    @Override // g5.i
    public void onDestroy() {
    }

    @Override // g5.i
    public void onStart() {
        j();
    }

    @Override // g5.i
    public void onStop() {
        k();
    }
}
