package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import c8.b;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.e;
import com.google.firebase.a;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class FirebaseInstanceId {

    /* renamed from: g  reason: collision with root package name */
    private static final long f12451g = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: h  reason: collision with root package name */
    private static m f12452h;

    /* renamed from: i  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f12453i;

    /* renamed from: a  reason: collision with root package name */
    private final a f12454a;

    /* renamed from: b  reason: collision with root package name */
    private final b f12455b;

    /* renamed from: c  reason: collision with root package name */
    private final v f12456c;

    /* renamed from: d  reason: collision with root package name */
    private final f f12457d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12458e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12459f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstanceId(a aVar) {
        this(aVar, new b(aVar.b()));
    }

    private FirebaseInstanceId(a aVar, b bVar) {
        this.f12457d = new f();
        this.f12458e = false;
        if (b.a(aVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f12452h == null) {
                    f12452h = new m(aVar.b());
                }
            }
            this.f12454a = aVar;
            this.f12455b = bVar;
            this.f12456c = new s(aVar, this, bVar);
            this.f12459f = x();
            if (z()) {
                o();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId b() {
        return getInstance(a.c());
    }

    private final synchronized void e() {
        if (!this.f12458e) {
            i(0L);
        }
    }

    private static <T> T f(com.google.android.gms.tasks.b<T> bVar) throws IOException {
        try {
            return (T) e.a(bVar);
        } catch (InterruptedException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw new IOException(cause);
            } else {
                throw new IOException(e10);
            }
        }
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(a aVar) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) aVar.a(FirebaseInstanceId.class);
        }
        return firebaseInstanceId;
    }

    private final String h(String str, String str2, Bundle bundle) throws IOException {
        return ((s) this.f12456c).d(str, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Runnable runnable, long j10) {
        synchronized (FirebaseInstanceId.class) {
            if (f12453i == null) {
                f12453i = new ScheduledThreadPoolExecutor(1);
            }
            f12453i.schedule(runnable, j10, TimeUnit.SECONDS);
        }
    }

    private static String n(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN) || str.equalsIgnoreCase("gcm")) ? MessageProxyConstants.NODE_ID_ANY : str;
    }

    private final void o() {
        n r10 = r();
        if (r10 == null || r10.c(this.f12455b.g()) || f12452h.d() != null) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String q() {
        return b.b(f12452h.i("").a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m t() {
        return f12452h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    private final boolean x() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context b10 = this.f12454a.b();
        SharedPreferences sharedPreferences = b10.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return sharedPreferences.getBoolean("auto_init", true);
        }
        try {
            PackageManager packageManager = b10.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(b10.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return y();
    }

    private final boolean y() {
        try {
            int i10 = g8.a.f27303a;
            return true;
        } catch (ClassNotFoundException unused) {
            Context b10 = this.f12454a.b();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(b10.getPackageName());
            ResolveInfo resolveService = b10.getPackageManager().resolveService(intent, 0);
            return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
        }
    }

    public String a() {
        o();
        return q();
    }

    public String c() {
        n r10 = r();
        if (r10 == null || r10.c(this.f12455b.g())) {
            e();
        }
        if (r10 != null) {
            return r10.f12506a;
        }
        return null;
    }

    public String d(final String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            final String n10 = n(str2);
            n f10 = f12452h.f("", str, n10);
            return (f10 == null || f10.c(this.f12455b.g())) ? this.f12457d.d(str, n10, new i(this, str, n10) { // from class: com.google.firebase.iid.r

                /* renamed from: a  reason: collision with root package name */
                private final FirebaseInstanceId f12514a;

                /* renamed from: b  reason: collision with root package name */
                private final String f12515b;

                /* renamed from: c  reason: collision with root package name */
                private final String f12516c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12514a = this;
                    this.f12515b = str;
                    this.f12516c = n10;
                }

                @Override // com.google.firebase.iid.i
                public final String a() {
                    return this.f12514a.g(this.f12515b, this.f12516c);
                }
            }) : f10.f12506a;
        }
        throw new IOException("MAIN_THREAD");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String g(String str, String str2) throws IOException {
        String str3 = (String) f(this.f12456c.a(str, str2));
        f12452h.c("", str, str2, str3, this.f12455b.g());
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void i(long j10) {
        j(new o(this, this.f12455b, Math.min(Math.max(30L, j10 << 1), f12451g)), j10);
        this.f12458e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void k(boolean z10) {
        this.f12458e = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(String str) throws IOException {
        n r10 = r();
        if (r10 == null || r10.c(this.f12455b.g())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String str2 = r10.f12506a;
        String valueOf2 = String.valueOf(str);
        h(str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(String str) throws IOException {
        n r10 = r();
        if (r10 == null || r10.c(this.f12455b.g())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String str2 = r10.f12506a;
        String valueOf2 = String.valueOf(str);
        h(str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a p() {
        return this.f12454a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n r() {
        return f12452h.f("", b.a(this.f12454a), MessageProxyConstants.NODE_ID_ANY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String s() throws IOException {
        return d(b.a(this.f12454a), MessageProxyConstants.NODE_ID_ANY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void v() {
        f12452h.e();
        if (z()) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void w() {
        f12452h.j("");
        e();
    }

    public final synchronized boolean z() {
        return this.f12459f;
    }
}
