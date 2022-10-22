package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.internal.a0;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import k6.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a0 f8837a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f8838b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Context f8839c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q a(String str, j jVar, boolean z10, boolean z11) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return d(str, jVar, z10, z11);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ String b(boolean z10, String str, j jVar) throws Exception {
        boolean z11 = true;
        if (z10 || !d(str, jVar, true, false).f8978a) {
            z11 = false;
        }
        return q.e(str, jVar, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c(Context context) {
        synchronized (h.class) {
            if (f8839c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f8839c = context.getApplicationContext();
            }
        }
    }

    private static q d(final String str, final j jVar, final boolean z10, boolean z11) {
        try {
            if (f8837a == null) {
                i.k(f8839c);
                synchronized (f8838b) {
                    if (f8837a == null) {
                        f8837a = b0.m1(DynamiteModule.d(f8839c, DynamiteModule.f9051k, "com.google.android.gms.googlecertificates").c("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            i.k(f8839c);
            try {
                if (f8837a.x2(new zzk(str, jVar, z10, z11), d.A2(f8839c.getPackageManager()))) {
                    return q.f();
                }
                return q.c(new Callable(z10, str, jVar) { // from class: com.google.android.gms.common.i

                    /* renamed from: a  reason: collision with root package name */
                    private final boolean f8840a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f8841b;

                    /* renamed from: c  reason: collision with root package name */
                    private final j f8842c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f8840a = z10;
                        this.f8841b = str;
                        this.f8842c = jVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return h.b(this.f8840a, this.f8841b, this.f8842c);
                    }
                });
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return q.b("module call", e10);
            }
        } catch (DynamiteModule.LoadingException e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            String valueOf = String.valueOf(e11.getMessage());
            return q.b(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e11);
        }
    }
}
