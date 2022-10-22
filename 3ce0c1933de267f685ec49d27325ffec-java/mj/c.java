package mj;

import af.b;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.Message;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.map.g;
import com.mobvoi.companion.map.j;
import com.mobvoi.mcuwatch.pair.service.DataSyncService;
import ef.o;
import ef.p;
import ei.h;
/* compiled from: RecordMcuWatchSportTrack.java */
/* loaded from: classes2.dex */
public class c implements g.a, s.a {

    /* renamed from: i  reason: collision with root package name */
    private static c f30793i;

    /* renamed from: d  reason: collision with root package name */
    private int f30797d;

    /* renamed from: f  reason: collision with root package name */
    private j f30799f;

    /* renamed from: g  reason: collision with root package name */
    private int f30800g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30801h = false;

    /* renamed from: a  reason: collision with root package name */
    private final b f30794a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final g f30795b = cd.g.b().a().b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f30796c = com.mobvoi.android.common.utils.b.e();

    /* renamed from: e  reason: collision with root package name */
    private final s f30798e = new s(this, Looper.getMainLooper());

    private c() {
    }

    public static c e() {
        synchronized (c.class) {
            if (f30793i == null) {
                f30793i = new c();
            }
        }
        return f30793i;
    }

    private void h() {
        this.f30801h = true;
        this.f30797d = 0;
        this.f30800g = 0;
        this.f30794a.d();
        com.mobvoi.ticwear.youngwatch.data.b.c().b();
        this.f30795b.a(this.f30796c, this);
        if (!a.isOversea()) {
            DataSyncService.n(this.f30796c);
        }
        this.f30798e.sendEmptyMessageDelayed(1, 1000L);
    }

    @Override // com.mobvoi.companion.map.g.a
    public boolean a(Location location) {
        o oVar = new o(location.getTime());
        oVar.f25947d = location.getLatitude();
        oVar.f25946c = location.getLongitude();
        oVar.f25948e = location.getAccuracy();
        return this.f30794a.e(oVar);
    }

    @Override // com.mobvoi.companion.map.g.a
    public void b(j jVar) {
        double[] dArr = {jVar.f17284b, jVar.f17283a};
        if (a.isOversea() && !cd.a.b(jVar.f17284b, jVar.f17283a)) {
            dArr = cd.a.a(jVar.f17284b, jVar.f17283a);
        }
        j jVar2 = this.f30799f;
        if (jVar2 != null) {
            this.f30800g += (int) tk.a.a(jVar2.f17283a, jVar2.f17284b, jVar.f17283a, jVar.f17284b);
        }
        this.f30799f = jVar;
        if (this.f30800g != 0) {
            p pVar = new p();
            pVar.f25953c = this.f30800g;
            int i10 = this.f30797d;
            pVar.f25951a = i10 * 1000;
            pVar.f25952b = jVar.f17292j;
            pVar.f25954d = jVar.f17293k;
            o oVar = new o(i10);
            oVar.f25947d = dArr[0];
            oVar.f25946c = dArr[1];
            oVar.f25948e = (float) jVar.f17285c;
            pVar.f25973w = oVar;
            com.mobvoi.ticwear.youngwatch.data.b.c().j(pVar);
        }
    }

    public void c(boolean z10) {
        if (!z10 && this.f30801h) {
            this.f30801h = false;
            com.mobvoi.ticwear.youngwatch.data.b.c().b();
            this.f30795b.b(this);
            if (!a.isOversea()) {
                DataSyncService.u(this.f30796c);
            }
            this.f30798e.removeCallbacksAndMessages(null);
        }
    }

    public void d(int i10, int i11) {
        if (i10 == 1 && !this.f30801h && f(i11)) {
            h();
        } else if (i10 == 0) {
            if (this.f30801h) {
                i();
            }
            this.f30798e.sendEmptyMessageDelayed(2, 100L);
        }
    }

    public boolean f(int i10) {
        return i10 == 1 || i10 == 9 || i10 == 2;
    }

    public boolean g() {
        return this.f30801h;
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            if (i10 == 2) {
                h.a().r();
            }
        } else if (this.f30801h) {
            this.f30798e.removeCallbacksAndMessages(null);
            this.f30797d++;
            this.f30798e.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void i() {
        this.f30801h = false;
        com.mobvoi.ticwear.youngwatch.data.b.c().i();
        this.f30795b.b(this);
        if (!a.isOversea()) {
            DataSyncService.u(this.f30796c);
        }
    }
}
