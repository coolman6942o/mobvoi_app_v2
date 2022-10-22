package w1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.k;
/* compiled from: NetworkStateTracker.java */
/* loaded from: classes.dex */
public class e extends d<u1.b> {

    /* renamed from: j  reason: collision with root package name */
    static final String f35935j = k.f("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    private final ConnectivityManager f35936g = (ConnectivityManager) this.f35929b.getSystemService("connectivity");

    /* renamed from: h  reason: collision with root package name */
    private b f35937h;

    /* renamed from: i  reason: collision with root package name */
    private a f35938i;

    /* compiled from: NetworkStateTracker.java */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                k.c().a(e.f35935j, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.d(eVar.g());
            }
        }
    }

    /* compiled from: NetworkStateTracker.java */
    /* loaded from: classes.dex */
    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            k.c().a(e.f35935j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.d(eVar.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            k.c().a(e.f35935j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.d(eVar.g());
        }
    }

    public e(Context context, a2.a aVar) {
        super(context, aVar);
        if (j()) {
            this.f35937h = new b();
        } else {
            this.f35938i = new a();
        }
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // w1.d
    public void e() {
        if (j()) {
            try {
                k.c().a(f35935j, "Registering network callback", new Throwable[0]);
                this.f35936g.registerDefaultNetworkCallback(this.f35937h);
            } catch (IllegalArgumentException | SecurityException e10) {
                k.c().b(f35935j, "Received exception while registering network callback", e10);
            }
        } else {
            k.c().a(f35935j, "Registering broadcast receiver", new Throwable[0]);
            this.f35929b.registerReceiver(this.f35938i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // w1.d
    public void f() {
        if (j()) {
            try {
                k.c().a(f35935j, "Unregistering network callback", new Throwable[0]);
                this.f35936g.unregisterNetworkCallback(this.f35937h);
            } catch (IllegalArgumentException | SecurityException e10) {
                k.c().b(f35935j, "Received exception while unregistering network callback", e10);
            }
        } else {
            k.c().a(f35935j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f35929b.unregisterReceiver(this.f35938i);
        }
    }

    u1.b g() {
        NetworkInfo activeNetworkInfo = this.f35936g.getActiveNetworkInfo();
        boolean z10 = true;
        boolean z11 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean i10 = i();
        boolean a10 = f0.a.a(this.f35936g);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z10 = false;
        }
        return new u1.b(z11, i10, a10, z10);
    }

    /* renamed from: h */
    public u1.b b() {
        return g();
    }

    boolean i() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.f35936g.getNetworkCapabilities(this.f35936g.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e10) {
            k.c().b(f35935j, "Unable to validate active network", e10);
            return false;
        }
    }
}
