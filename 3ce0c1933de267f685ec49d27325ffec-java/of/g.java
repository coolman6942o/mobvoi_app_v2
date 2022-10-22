package of;

import ag.d;
import ag.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.health.common.data.db.b;
import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.sync.net.h;
import com.mobvoi.health.common.data.sync.net.i;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import qf.f;
import zf.c;
/* compiled from: CommonStorage.java */
/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: o  reason: collision with root package name */
    private static final long f31612o = TimeUnit.MINUTES.toMillis(60);

    /* renamed from: a  reason: collision with root package name */
    private final com.mobvoi.health.common.data.db.a f31613a;

    /* renamed from: b  reason: collision with root package name */
    private final b f31614b;

    /* renamed from: c  reason: collision with root package name */
    private final f f31615c;

    /* renamed from: d  reason: collision with root package name */
    private final c<ag.g, e, ag.f, DataType, qf.a> f31616d;

    /* renamed from: e  reason: collision with root package name */
    private final c<d, ag.b, ag.c, ActivityType, qf.c> f31617e;

    /* renamed from: f  reason: collision with root package name */
    private final uf.a f31618f;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f31620h;

    /* renamed from: i  reason: collision with root package name */
    private final ThreadPoolExecutor f31621i;

    /* renamed from: j  reason: collision with root package name */
    private long f31622j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31623k = false;

    /* renamed from: l  reason: collision with root package name */
    private String f31624l = "";

    /* renamed from: m  reason: collision with root package name */
    private String f31625m = "";

    /* renamed from: n  reason: collision with root package name */
    private boolean f31626n = false;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f31619g = l.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonStorage.java */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.c("health.storage", "Connectivity changed to connected? %s", Boolean.valueOf(g.this.G(context)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        HandlerThread handlerThread = new HandlerThread("HealthWorker");
        handlerThread.start();
        this.f31620h = new Handler(handlerThread.getLooper());
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.f31621i = new ThreadPoolExecutor(availableProcessors / 2, availableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        com.mobvoi.health.common.data.db.a q5 = com.mobvoi.health.common.data.db.a.q(context);
        this.f31613a = q5;
        b l10 = b.l(context);
        this.f31614b = l10;
        this.f31615c = new f(context);
        this.f31616d = zf.d.b(context, q5, new i(this), new com.mobvoi.health.common.data.sync.net.f(this), new zf.k() { // from class: of.f
            @Override // zf.k
            public final void a(Throwable th2) {
                g.this.y(th2);
            }
        }, new zf.k() { // from class: of.f
            @Override // zf.k
            public final void a(Throwable th2) {
                g.this.y(th2);
            }
        });
        this.f31617e = zf.d.a(context, l10, new h(this), new com.mobvoi.health.common.data.sync.net.e(this), new zf.k() { // from class: of.f
            @Override // zf.k
            public final void a(Throwable th2) {
                g.this.y(th2);
            }
        }, new zf.k() { // from class: of.f
            @Override // zf.k
            public final void a(Throwable th2) {
                g.this.y(th2);
            }
        });
        this.f31618f = g(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(Context context) {
        boolean b10 = m.b(context);
        if (b10 && !this.f31626n) {
            B(false);
        }
        this.f31626n = b10;
        return b10;
    }

    private boolean q() {
        return this.f31623k || SystemClock.elapsedRealtime() - this.f31622j > f31612o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(ag.f fVar, ag.c cVar) {
        this.f31616d.e(fVar);
        this.f31617e.e(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(ag.f fVar) {
        this.f31616d.e(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(nf.h hVar, boolean z10) {
        hVar.f(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(boolean z10, final nf.h hVar) {
        boolean z11 = true;
        final boolean z12 = false;
        if ((z10 || q()) && !TextUtils.isEmpty(this.f31624l)) {
            long currentTimeMillis = System.currentTimeMillis();
            k.c("health.storage", "sync data before: %s", Long.valueOf(currentTimeMillis));
            if (!this.f31616d.j(null, currentTimeMillis) || !this.f31617e.j(null, currentTimeMillis)) {
                z11 = false;
            }
            z12 = z11;
        }
        if (z12) {
            this.f31622j = SystemClock.elapsedRealtime();
        }
        this.f31619g.post(new Runnable() { // from class: of.a
            @Override // java.lang.Runnable
            public final void run() {
                g.u(nf.h.this, z12);
            }
        });
    }

    public nf.h<Boolean> A() {
        return B(true);
    }

    public nf.h<Boolean> B(final boolean z10) {
        final nf.c cVar = new nf.c();
        this.f31620h.post(new Runnable() { // from class: of.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.v(z10, cVar);
            }
        });
        return cVar;
    }

    public b C() {
        return this.f31614b;
    }

    public void D(String str) {
        this.f31625m = str;
    }

    public void E(String str, boolean z10) {
        if (str == null) {
            str = "";
        }
        this.f31624l = str;
        this.f31613a.r(str);
        this.f31614b.m(str);
        this.f31615c.d(str);
        this.f31616d.i(str);
        this.f31617e.i(str);
        this.f31618f.d(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(Context context, boolean z10) {
        this.f31623k = z10;
        context.registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        k.c("health.storage", "Connectivity initial to connected? %s", Boolean.valueOf(G(context)));
    }

    public abstract uf.a g(Context context);

    public f h() {
        return this.f31615c;
    }

    public uf.a i() {
        return this.f31618f;
    }

    public Handler j() {
        return this.f31619g;
    }

    public ThreadPoolExecutor k() {
        return this.f31621i;
    }

    public String l(String str) {
        return this.f31618f.c(str);
    }

    public Handler m() {
        return this.f31620h;
    }

    public void n(DataType dataType, float f10) {
        qf.a aVar = new qf.a(dataType, System.currentTimeMillis());
        aVar.h(f10);
        o(aVar);
    }

    public void o(final qf.a aVar) {
        this.f31620h.post(new Runnable() { // from class: of.d
            @Override // java.lang.Runnable
            public final void run() {
                g.this.r(aVar);
            }
        });
    }

    /* renamed from: p */
    public void r(qf.a aVar) {
        try {
            if (aVar.f33126b.isEmpty()) {
                aVar.f33126b = this.f31624l;
            }
            if (aVar.f33125a.isEmpty()) {
                aVar.f33125a = this.f31625m;
            }
            this.f31613a.d(aVar);
        } catch (Exception e10) {
            k.r("health.storage", "Failed to insert data", e10, new Object[0]);
        }
    }

    public void w(Long l10, Long l11) {
        final ag.f fVar = new ag.f();
        fVar.type = null;
        fVar.time_from = l10;
        fVar.time_to = l11;
        final ag.c cVar = new ag.c();
        cVar.activity = null;
        cVar.time_from = l10;
        cVar.time_to = l11;
        this.f31620h.post(new Runnable() { // from class: of.c
            @Override // java.lang.Runnable
            public final void run() {
                g.this.s(fVar, cVar);
            }
        });
    }

    public void x(Long l10, Long l11, DataType dataType) {
        final ag.f fVar = new ag.f();
        fVar.type = dataType == null ? null : Integer.valueOf(dataType.typeCode);
        fVar.time_from = l10;
        fVar.time_to = l11;
        this.f31620h.post(new Runnable() { // from class: of.b
            @Override // java.lang.Runnable
            public final void run() {
                g.this.t(fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(Throwable th2) {
    }

    public com.mobvoi.health.common.data.db.a z() {
        return this.f31613a;
    }
}
