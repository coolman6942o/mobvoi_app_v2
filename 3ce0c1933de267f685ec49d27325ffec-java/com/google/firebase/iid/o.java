package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import c8.b;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f12509a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f12510b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f12511c;

    /* renamed from: d  reason: collision with root package name */
    private final b f12512d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FirebaseInstanceId firebaseInstanceId, b bVar, long j10) {
        this.f12511c = firebaseInstanceId;
        this.f12512d = bVar;
        this.f12509a = j10;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f12510b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private final boolean b() {
        n r10 = this.f12511c.r();
        if (r10 != null && !r10.c(this.f12512d.g())) {
            return true;
        }
        try {
            String s10 = this.f12511c.s();
            if (s10 == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (r10 == null || !s10.equals(r10.f12506a)) {
                Context a10 = a();
                Intent intent = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
                Intent intent2 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
                intent2.setClass(a10, FirebaseInstanceIdReceiver.class);
                intent2.putExtra("wrapped_intent", intent);
                a10.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException | SecurityException e10) {
            String valueOf = String.valueOf(e10.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    private final boolean c() {
        while (true) {
            synchronized (this.f12511c) {
                String d10 = FirebaseInstanceId.t().d();
                if (d10 == null) {
                    Log.d("FirebaseInstanceId", "topic sync succeeded");
                    return true;
                } else if (!e(d10)) {
                    return false;
                } else {
                    FirebaseInstanceId.t().h(d10);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4 == 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        r7.f12511c.m(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (com.google.firebase.iid.FirebaseInstanceId.u() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        r8 = "unsubscribe operation succeeded";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean e(String str) {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c10 = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85 && str2.equals("U")) {
                        c10 = 1;
                    }
                } else if (str2.equals("S")) {
                    c10 = 0;
                }
                this.f12511c.l(str3);
                if (FirebaseInstanceId.u()) {
                    String str4 = "subscribe operation succeeded";
                    Log.d("FirebaseInstanceId", str4);
                }
            } catch (IOException e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Topic sync failed: ".concat(valueOf) : new String("Topic sync failed: "));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.f12511c.p().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseInstanceId firebaseInstanceId;
        this.f12510b.acquire();
        try {
            boolean z10 = true;
            this.f12511c.k(true);
            if (this.f12512d.f() == 0) {
                z10 = false;
            }
            if (!z10) {
                firebaseInstanceId = this.f12511c;
            } else {
                if (!d()) {
                    new p(this).a();
                } else if (!b() || !c()) {
                    this.f12511c.i(this.f12509a);
                } else {
                    firebaseInstanceId = this.f12511c;
                }
            }
            firebaseInstanceId.k(false);
        } finally {
            this.f12510b.release();
        }
    }
}
