package com.google.android.gms.common;

import android.util.Log;
import h6.a;
import h6.j;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {

    /* renamed from: d  reason: collision with root package name */
    private static final q f8977d = new q(true, null, null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f8978a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8979b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f8980c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(boolean z10, String str, Throwable th2) {
        this.f8978a = z10;
        this.f8979b = str;
        this.f8980c = th2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q b(String str, Throwable th2) {
        return new q(false, str, th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q c(Callable<String> callable) {
        return new s(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q d(String str) {
        return new q(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, j jVar, boolean z10, boolean z11) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z11 ? "debug cert rejected" : "not whitelisted", str, j.a(a.a("SHA-1").digest(jVar.U1())), Boolean.valueOf(z10), "12451009.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q f() {
        return f8977d;
    }

    String a() {
        return this.f8979b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (!this.f8978a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f8980c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f8980c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }
}
