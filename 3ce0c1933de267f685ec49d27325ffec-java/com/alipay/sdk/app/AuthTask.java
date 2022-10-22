package com.alipay.sdk.app;

import a4.d;
import a4.h;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.util.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import r3.a;
import y3.a;
import y3.b;
/* loaded from: classes.dex */
public class AuthTask {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f6857c = com.alipay.sdk.util.a.class;

    /* renamed from: a  reason: collision with root package name */
    public Activity f6858a;

    /* renamed from: b  reason: collision with root package name */
    public b4.a f6859b;

    /* loaded from: classes.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // com.alipay.sdk.util.a.e
        public void a() {
            AuthTask.this.c();
        }

        @Override // com.alipay.sdk.util.a.e
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.f6858a = activity;
        b.e().b(this.f6858a);
        this.f6859b = new b4.a(activity, "去支付宝授权");
    }

    private String b(y3.a aVar, x3.a aVar2) {
        String[] f10 = aVar2.f();
        Bundle bundle = new Bundle();
        bundle.putString("url", f10[0]);
        Intent intent = new Intent(this.f6858a, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0536a.c(aVar, intent);
        this.f6858a.startActivity(intent);
        Object obj = f6857c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return o3.b.a();
            }
        }
        String g10 = o3.b.g();
        return TextUtils.isEmpty(g10) ? o3.b.a() : g10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b4.a aVar = this.f6859b;
        if (aVar != null) {
            aVar.c();
        }
    }

    private a.e d() {
        return new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String e(Activity activity, String str, y3.a aVar) {
        f();
        c cVar = null;
        try {
            try {
                List<x3.a> b10 = x3.a.b(new w3.a().h(aVar, activity, str).c().optJSONObject("form").optJSONObject("onload"));
                c();
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    if (b10.get(i10).a() == com.alipay.sdk.protocol.a.WapPay) {
                        return b(aVar, b10.get(i10));
                    }
                }
                c();
            } finally {
                c();
            }
        } catch (IOException e10) {
            cVar = c.b(c.NETWORK_ERROR.b());
            p3.a.f(aVar, "net", e10);
            if (cVar == null) {
            }
            return o3.b.b(cVar.b(), cVar.a(), "");
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "H5AuthDataAnalysisError", th2);
            if (cVar == null) {
            }
            return o3.b.b(cVar.b(), cVar.a(), "");
        }
        if (cVar == null) {
            cVar = c.b(c.FAILED.b());
        }
        return o3.b.b(cVar.b(), cVar.a(), "");
    }

    private void f() {
        b4.a aVar = this.f6859b;
        if (aVar != null) {
            aVar.f();
        }
    }

    public synchronized String auth(String str, boolean z10) {
        return innerAuth(new y3.a(this.f6858a, str, "auth"), str, z10);
    }

    public synchronized Map<String, String> authV2(String str, boolean z10) {
        y3.a aVar;
        aVar = new y3.a(this.f6858a, str, "authV2");
        return h.d(aVar, innerAuth(aVar, str, z10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00be, code lost:
        if (r3.a.G().B() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c0, code lost:
        r3.a.G().g(r6, r5.f6858a, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c9, code lost:
        c();
        p3.a.g(r5.f6858a, r6, r7, r6.f36738d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006a, code lost:
        if (r3.a.G().B() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String innerAuth(y3.a aVar, String str, boolean z10) {
        String a10;
        if (z10) {
            f();
        }
        b.e().b(this.f6858a);
        a10 = o3.b.a();
        o3.a.b("");
        try {
            a10 = a(this.f6858a, str, aVar);
            p3.a.c(aVar, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
            p3.a.c(aVar, "biz", "PgReturnV", h.a(a10, "resultStatus") + "|" + h.a(a10, "memo"));
        } catch (Exception e10) {
            d.d(e10);
            p3.a.c(aVar, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
            p3.a.c(aVar, "biz", "PgReturnV", h.a(a10, "resultStatus") + "|" + h.a(a10, "memo"));
        }
        return a10;
    }

    private String a(Activity activity, String str, y3.a aVar) {
        String b10 = aVar.b(str);
        List<a.b> v10 = r3.a.G().v();
        if (!r3.a.G().f33373g || v10 == null) {
            v10 = o3.a.f31407d;
        }
        if (com.alipay.sdk.util.b.A(aVar, this.f6858a, v10)) {
            String d10 = new com.alipay.sdk.util.a(activity, aVar, d()).d(b10);
            if (!TextUtils.equals(d10, "failed") && !TextUtils.equals(d10, "scheme_failed")) {
                return TextUtils.isEmpty(d10) ? o3.b.a() : d10;
            }
            p3.a.b(aVar, "biz", "LogBindCalledH5");
            return e(activity, b10, aVar);
        }
        p3.a.b(aVar, "biz", "LogCalledH5");
        return e(activity, b10, aVar);
    }
}
