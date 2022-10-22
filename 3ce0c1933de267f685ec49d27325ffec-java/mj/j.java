package mj;

import android.content.Context;
import android.location.Location;
import cd.d;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.map.h;
import com.mobvoi.companion.map.i;
import ef.o;
import ef.p;
import java.util.ArrayList;
import java.util.List;
import pk.z;
/* compiled from: WorkoutMapWrapper.java */
/* loaded from: classes2.dex */
public class j implements i.a, h.a {

    /* renamed from: b  reason: collision with root package name */
    private final i f30809b;

    /* renamed from: c  reason: collision with root package name */
    private h f30810c;

    /* renamed from: d  reason: collision with root package name */
    private int f30811d;

    /* renamed from: f  reason: collision with root package name */
    private a f30813f;

    /* renamed from: h  reason: collision with root package name */
    private int f30815h;

    /* renamed from: i  reason: collision with root package name */
    private com.mobvoi.companion.map.j f30816i;

    /* renamed from: j  reason: collision with root package name */
    private com.mobvoi.companion.map.j f30817j;

    /* renamed from: e  reason: collision with root package name */
    private List<d> f30812e = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private int f30818k = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f30808a = b.e();

    /* renamed from: g  reason: collision with root package name */
    private final af.b f30814g = new af.b();

    /* compiled from: WorkoutMapWrapper.java */
    /* loaded from: classes2.dex */
    interface a {
        void a(float f10, double d10);
    }

    public j(i iVar) {
        this.f30809b = iVar;
        iVar.a(this);
    }

    private void e() {
        this.f30810c.clear();
        dh.b.d().j(new fh.b().a(com.mobvoi.ticwear.youngwatch.data.b.c().i()), this.f30810c);
        this.f30810c.onStop();
    }

    @Override // com.mobvoi.companion.map.h.a
    public boolean a(Location location) {
        if (this.f30811d == 0) {
            return true;
        }
        o oVar = new o(location.getTime());
        oVar.f25947d = location.getLatitude();
        oVar.f25946c = location.getLongitude();
        oVar.f25948e = location.getAccuracy();
        return this.f30814g.e(oVar);
    }

    @Override // com.mobvoi.companion.map.h.a
    public void b(com.mobvoi.companion.map.j jVar) {
        this.f30816i = jVar;
        com.mobvoi.companion.map.j jVar2 = this.f30817j;
        if (jVar2 != null) {
            this.f30818k += (int) tk.a.a(jVar2.f17283a, jVar2.f17284b, jVar.f17283a, jVar.f17284b);
        }
        this.f30817j = this.f30816i;
        if (this.f30818k != 0) {
            p pVar = new p();
            pVar.f25953c = this.f30818k;
            int i10 = this.f30815h;
            pVar.f25951a = i10 * 1000;
            pVar.f25952b = jVar.f17292j;
            pVar.f25954d = jVar.f17293k;
            o oVar = new o(i10);
            oVar.f25947d = jVar.f17284b;
            oVar.f25946c = jVar.f17283a;
            oVar.f25948e = (float) jVar.f17285c;
            pVar.f25973w = oVar;
            com.mobvoi.ticwear.youngwatch.data.b.c().j(pVar);
            this.f30813f.a(this.f30818k, jVar.f17286d);
            this.f30812e.add(new d(jVar));
            this.f30810c.i(this.f30812e, this.f30808a.getResources().getColor(sh.d.f34466z), 5, 0, false);
        }
    }

    @Override // com.mobvoi.companion.map.h.a
    public boolean c() {
        return this.f30811d == 2;
    }

    @Override // com.mobvoi.companion.map.i.a
    public void d(h hVar) {
        this.f30810c = hVar;
        hVar.j(this);
        this.f30812e.clear();
        this.f30814g.d();
        this.f30818k = 0;
        this.f30810c.m(b.e());
    }

    public void f() {
        this.f30812e.clear();
        this.f30810c.onDestroy();
        this.f30809b.onDestroy();
        this.f30809b.release();
    }

    public void g() {
        this.f30809b.onPause();
    }

    public void h() {
        this.f30809b.onResume();
    }

    public void i(int i10) {
        this.f30811d = i10;
        if (i10 == 4) {
            e();
        }
    }

    public void j(int i10) {
        this.f30815h = i10;
    }

    public void k(int i10) {
        dh.b.d().f(z.a(i10));
    }

    public void l(a aVar) {
        this.f30813f = aVar;
    }
}
