package com.mobvoi.mcuwatch.ui.card;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.companion.map.g;
import com.mobvoi.companion.map.j;
import ki.e;
import nj.v;
import v9.b;
import v9.c;
import yh.a;
import yh.d;
/* compiled from: WeatherDataProvider.java */
/* loaded from: classes2.dex */
public class e0 implements g.a {

    /* renamed from: i  reason: collision with root package name */
    private static e0 f19490i;

    /* renamed from: b  reason: collision with root package name */
    private long f19492b;

    /* renamed from: c  reason: collision with root package name */
    private long f19493c;

    /* renamed from: d  reason: collision with root package name */
    private b f19494d;

    /* renamed from: e  reason: collision with root package name */
    private d f19495e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19496f;

    /* renamed from: g  reason: collision with root package name */
    private g f19497g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f19498h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f19491a = com.mobvoi.android.common.utils.b.e();

    /* compiled from: WeatherDataProvider.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a("WeatherDataProvider", "request location timeout.");
            if (e0.this.f19497g != null) {
                e0.this.f19497g.b(e0.this);
            }
            e0.this.f19496f = false;
        }
    }

    private e0() {
    }

    public static e0 g() {
        synchronized (e0.class) {
            if (f19490i == null) {
                f19490i = new e0();
            }
        }
        return f19490i;
    }

    private void h() {
        k.a("WeatherDataProvider", "internalLoadWeatherInfo");
        yh.a aVar = new yh.a();
        String x10 = ta.a.x();
        if (!TextUtils.isEmpty(x10)) {
            aVar.wwid = x10;
        }
        aVar.clientType = "android_vpa";
        a.C0539a aVar2 = new a.C0539a();
        aVar.context = aVar2;
        aVar2.mode = "unknown";
        aVar2.timestamp = System.currentTimeMillis();
        b bVar = this.f19494d;
        if (!(bVar == null || bVar.point == null)) {
            String a10 = bVar.a();
            aVar.context.location = new a.b();
            a.b bVar2 = aVar.context.location;
            c cVar = this.f19494d.point;
            bVar2.latitude = cVar.latitude;
            bVar2.longitude = cVar.longitude;
            bVar2.address = a10;
        }
        e.f29987b.g().a(aVar).D(d0.f19482a).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.card.b0
            @Override // yp.b
            public final void call(Object obj) {
                e0.this.k((d) obj);
            }
        }, new yp.b() { // from class: com.mobvoi.mcuwatch.ui.card.c0
            @Override // yp.b
            public final void call(Object obj) {
                e0.this.l((Throwable) obj);
            }
        });
    }

    private boolean i() {
        return this.f19494d == null || System.currentTimeMillis() - this.f19493c > 1800000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(d dVar) {
        this.f19496f = false;
        if (dVar != null) {
            this.f19492b = System.currentTimeMillis();
            this.f19495e = dVar;
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Throwable th2) {
        this.f19496f = false;
        k.e("WeatherDataProvider", "error fetch weather info", th2);
    }

    private void n() {
        k.a("WeatherDataProvider", "requestLocation");
        this.f19497g = cd.g.b().a().b();
        this.f19494d = new b();
        this.f19497g.a(this.f19491a, this);
        l.a().removeCallbacks(this.f19498h);
        l.a().postDelayed(this.f19498h, 120000L);
    }

    private void o() {
        if (this.f19495e != null && this.f19494d != null && ci.a.b().e()) {
            k.a("WeatherDataProvider", "syncWeatherToBle");
            v.c(this.f19495e, this.f19494d);
        }
    }

    @Override // com.mobvoi.companion.map.g.a
    public boolean a(Location location) {
        return true;
    }

    @Override // com.mobvoi.companion.map.g.a
    public void b(j jVar) {
        this.f19493c = System.currentTimeMillis();
        l.a().removeCallbacks(this.f19498h);
        this.f19497g.b(this);
        this.f19494d.point = c.a(jVar.f17284b, jVar.f17283a);
        b bVar = this.f19494d;
        bVar.country = jVar.f17288f;
        bVar.province = jVar.f17289g;
        if (TextUtils.isEmpty(jVar.f17290h)) {
            this.f19494d.city = "unknown";
        } else {
            this.f19494d.city = jVar.f17290h;
        }
        b bVar2 = this.f19494d;
        bVar2.district = jVar.f17291i;
        k.c("WeatherDataProvider", "location: %s", bVar2);
        h();
    }

    public boolean j() {
        return !this.f19496f && System.currentTimeMillis() - this.f19492b > 14400000;
    }

    public void m() {
        if (!j()) {
            o();
        } else if (!this.f19496f) {
            this.f19496f = true;
            if (i()) {
                n();
            } else {
                h();
            }
        }
    }
}
