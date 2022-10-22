package com.paypal.android.sdk;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import okhttp3.Headers;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.f;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
/* loaded from: classes2.dex */
public class h1 extends d1 {

    /* renamed from: i  reason: collision with root package name */
    private static final String f21323i = "h1";

    /* renamed from: j  reason: collision with root package name */
    private static final w f21324j = w.f("charset=utf-8");

    /* renamed from: a  reason: collision with root package name */
    private final a f21325a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21326b;

    /* renamed from: c  reason: collision with root package name */
    private final s1 f21327c;

    /* renamed from: d  reason: collision with root package name */
    private final y f21328d;

    /* renamed from: e  reason: collision with root package name */
    private final y f21329e;

    /* renamed from: f  reason: collision with root package name */
    private final z f21330f;

    /* renamed from: g  reason: collision with root package name */
    private final ScheduledExecutorService f21331g;

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentLinkedQueue f21332h;

    public h1(a aVar, String str, z zVar, s1 s1Var, int i10, boolean z10, List list) {
        this.f21325a = aVar;
        this.f21326b = str;
        this.f21330f = zVar;
        this.f21327c = s1Var;
        boolean d10 = n0.d(str);
        boolean z11 = d10 && !z10;
        boolean z12 = !d10;
        y.a a10 = z0.a(90, z11, z12, zVar.b(), s1Var.e());
        a10.L().addAll(list);
        a10.L().add(new e1());
        this.f21328d = a10.c();
        y.a a11 = z0.a(90, z11, z12, zVar.b(), s1Var.e());
        a11.L().add(new e1());
        this.f21329e = a11.c();
        this.f21331g = Executors.newSingleThreadScheduledExecutor();
        this.f21332h = new ConcurrentLinkedQueue();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(h1 h1Var, r1 r1Var, b0 b0Var, IOException iOException) {
        r1Var.v();
        if (b0Var != null) {
            Log.e("paypal.sdk", "request failure with http statusCode:" + b0Var.n() + ",exception:" + b0Var.I());
            d1.c(r1Var, b0Var.n());
            if (r1Var.y()) {
                String str = by.INTERNAL_SERVER_ERROR.toString();
                r1Var.f(str, b0Var.n() + " http response received.  Response not parsable.", null);
            }
        } else if (iOException != null) {
            r1Var.b((!(iOException instanceof SSLException) || !"Connection closed by peer".equals(iOException.getMessage())) ? new x0(by.SERVER_COMMUNICATION_ERROR, iOException) : new x0(by.DEVICE_OS_TOO_OLD, iOException));
        } else {
            throw new RuntimeException("Both Response or Exception cannot be null");
        }
        Log.e("paypal.sdk", "request failed with server response:" + r1Var.o());
        h1Var.f21327c.a(r1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(r1 r1Var, String str, y yVar, f fVar) {
        z.a p10;
        z.a i10;
        int i11 = k1.f21405a[r1Var.p().b().ordinal()];
        if (i11 == 1) {
            p10 = new z.a().p(d(str, r1Var.n()));
        } else if (i11 == 2) {
            p10 = new z.a().p(str).l(a0.create(f21324j, r1Var.n()));
        } else if (i11 == 3) {
            i10 = new z.a().p(d(str, r1Var.n())).i(l(r1Var)).d();
            yVar.a(i10.b()).h(fVar);
        } else {
            throw new RuntimeException(r1Var.p().b() + " not supported.");
        }
        i10 = p10.i(l(r1Var));
        yVar.a(i10.b()).h(fVar);
    }

    private static Headers l(r1 r1Var) {
        Headers.a aVar = new Headers.a();
        for (Map.Entry entry : r1Var.q().entrySet()) {
            aVar.b((String) entry.getKey(), (String) entry.getValue());
        }
        return aVar.f();
    }

    @Override // com.paypal.android.sdk.o1
    public final void a() {
        this.f21328d.m().a();
        this.f21329e.m().a();
    }

    @Override // com.paypal.android.sdk.o1
    public final boolean a(r1 r1Var) {
        if (!this.f21325a.c()) {
            r1Var.b(new x0(by.SERVER_COMMUNICATION_ERROR.toString()));
            return false;
        }
        r1.s();
        String a10 = r1Var.a(r1Var.p());
        try {
            if (r1Var.g()) {
                r1Var.v();
                r1Var.v();
                r1Var.n();
                this.f21332h.offer(new i1(this, r1Var, a10));
                this.f21331g.schedule(new j1(this), new Random().nextInt(190) + 10, TimeUnit.SECONDS);
                return true;
            }
            r1Var.v();
            r1Var.v();
            r1Var.n();
            h(r1Var, a10, this.f21328d, new l1(this, r1Var, (byte) 0));
            return true;
        } catch (UnsupportedEncodingException e10) {
            Log.e(f21323i, "encoding failure", e10);
            r1Var.b(new x0(by.INTERNAL_ERROR, e10));
            return false;
        } catch (IOException e11) {
            Log.e(f21323i, "communication failure", e11);
            r1Var.b(new x0(by.SERVER_COMMUNICATION_ERROR, e11));
            return false;
        }
    }
}
