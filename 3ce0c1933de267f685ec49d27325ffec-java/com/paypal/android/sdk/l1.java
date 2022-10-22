package com.paypal.android.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
/* loaded from: classes2.dex */
final class l1 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final r1 f21429a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ h1 f21430b;

    private l1(h1 h1Var, r1 r1Var) {
        this.f21430b = h1Var;
        this.f21429a = r1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l1(h1 h1Var, r1 r1Var, byte b10) {
        this(h1Var, r1Var);
    }

    private String a(String str) {
        String str2;
        z zVar;
        z unused;
        Locale locale = Locale.US;
        String str3 = this.f21429a.v() + " PayPal Debug-ID: %s [%s, %s]";
        str2 = this.f21430b.f21326b;
        StringBuilder sb2 = new StringBuilder();
        zVar = this.f21430b.f21330f;
        sb2.append(zVar.a());
        sb2.append(";");
        unused = this.f21430b.f21330f;
        sb2.append("release");
        return String.format(locale, str3, str, str2, sb2.toString());
    }

    @Override // okhttp3.f
    public final void onFailure(e eVar, IOException iOException) {
        try {
            this.f21429a.i(iOException.getMessage());
            String d10 = eVar.request().d("PayPal-Debug-Id");
            if (!TextUtils.isEmpty(d10)) {
                Log.w("paypal.sdk", a(d10));
            }
            h1.g(this.f21430b, this.f21429a, null, iOException);
        } catch (Throwable th2) {
            Log.e("paypal.sdk", "exception in response handler", th2);
            throw th2;
        }
    }

    @Override // okhttp3.f
    public final void onResponse(e eVar, b0 b0Var) {
        s1 s1Var;
        String unused;
        try {
            String u10 = b0Var.u("paypal-debug-id");
            this.f21429a.i(b0Var.c().string());
            if (!b0Var.E()) {
                if (!TextUtils.isEmpty(u10)) {
                    Log.w("paypal.sdk", a(u10));
                }
                h1.g(this.f21430b, this.f21429a, b0Var, null);
                return;
            }
            this.f21429a.k(u10);
            unused = h1.f21323i;
            this.f21429a.v();
            this.f21429a.o();
            if (!TextUtils.isEmpty(u10)) {
                Log.w("paypal.sdk", a(u10));
            }
            if (this.f21429a.y()) {
                d1.b(this.f21429a);
            }
            s1Var = this.f21430b.f21327c;
            s1Var.a(this.f21429a);
        } catch (Throwable th2) {
            Log.e("paypal.sdk", "exception in response handler", th2);
            throw th2;
        }
    }
}
