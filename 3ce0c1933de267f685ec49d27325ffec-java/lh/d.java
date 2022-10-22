package lh;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.SparseArray;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.db.c;
import java.util.Date;
import nf.h;
import nf.j;
import nf.l;
import of.g;
import oh.b;
/* compiled from: HealthStorage.java */
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f30472a;

    /* renamed from: b  reason: collision with root package name */
    protected final b f30473b;

    /* renamed from: c  reason: collision with root package name */
    protected final com.mobvoi.health.common.data.db.a f30474c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f30475d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f30476e;

    /* renamed from: f  reason: collision with root package name */
    private nh.a f30477f = new nh.a();

    /* renamed from: g  reason: collision with root package name */
    private h<Long> f30478g = new h<>();

    /* renamed from: h  reason: collision with root package name */
    private Runnable f30479h = new Runnable() { // from class: lh.a
        @Override // java.lang.Runnable
        public final void run() {
            d.this.j();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final BroadcastReceiver f30480i;

    /* compiled from: HealthStorage.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(g gVar) {
        a aVar = new a();
        this.f30480i = aVar;
        Application e10 = com.mobvoi.android.common.utils.b.e();
        this.f30472a = e10;
        this.f30473b = new b(e10, gVar);
        this.f30475d = gVar.j();
        Handler m10 = gVar.m();
        this.f30476e = m10;
        com.mobvoi.health.common.data.db.a z10 = gVar.z();
        this.f30474c = z10;
        j.b(z10.t(), new j.a() { // from class: lh.c
            @Override // nf.j.a
            public final void call(Object obj) {
                d.this.f((c.a) obj);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        e10.registerReceiver(aVar, intentFilter);
        m10.post(new Runnable() { // from class: lh.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(c.a aVar) {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SparseArray sparseArray) {
        this.f30477f.f(sparseArray);
    }

    private void k() {
        if (this.f30477f.l()) {
            long currentTimeMillis = System.currentTimeMillis();
            k.i("health.data.storage", "Day changed to %s, refreshed today data observations", new Date(currentTimeMillis));
            m();
            this.f30478g.f(Long.valueOf(currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f30478g.f(Long.valueOf(System.currentTimeMillis()));
        h();
    }

    private void m() {
        nh.b h10 = this.f30477f.h();
        k.c("health.data.storage", "Refresh DataStore with range %s", h10);
        this.f30473b.e(h10.f31252a, h10.f31253b);
        h();
    }

    private void n(nh.b bVar) {
        this.f30473b.e(bVar.f31252a, bVar.f31253b);
        h();
    }

    public void d(String str, String str2) {
        this.f30473b.d(str, str2);
        i();
    }

    public h<SparseArray<oh.a>> e() {
        return this.f30477f;
    }

    public void h() {
        k();
        this.f30476e.removeCallbacks(this.f30479h);
        this.f30476e.postDelayed(this.f30479h, 300L);
    }

    public void i() {
        final SparseArray<oh.a> b10 = this.f30473b.b();
        this.f30475d.post(new Runnable() { // from class: lh.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.g(b10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.f30473b.d(null, null);
        i();
    }

    public void o(nf.k<SparseArray<oh.a>> kVar, long j10, long j11) {
        nh.b bVar = new nh.b(j10, j11);
        this.f30477f.m(kVar, bVar);
        n(bVar);
    }

    public l p(nf.k<SparseArray<oh.a>> kVar) {
        j c10 = j.c(this.f30477f, kVar);
        this.f30477f.n(kVar);
        m();
        return c10;
    }
}
