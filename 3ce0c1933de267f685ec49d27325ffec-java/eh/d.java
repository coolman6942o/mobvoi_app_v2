package eh;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.sport.viewmodel.pojo.UiTrain;
import ef.a0;
import ef.b0;
import ef.d0;
import ef.e0;
import ef.f0;
import ef.p;
import ef.q;
import ef.u;
import ef.y;
import ef.z;
import fh.e;
import gh.a;
import hf.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import nf.c;
import nf.g;
import nf.j;
import nf.m;
import we.b;
import we.f;
import xf.h;
import xf.i;
/* compiled from: DetailsViewModel.java */
/* loaded from: classes2.dex */
public class d extends g {
    private final b[] A;

    /* renamed from: b  reason: collision with root package name */
    private final String f26051b;

    /* renamed from: c  reason: collision with root package name */
    private final c<u> f26052c = new c<>();

    /* renamed from: d  reason: collision with root package name */
    private final c<Boolean> f26053d = new c<>();

    /* renamed from: e  reason: collision with root package name */
    private final c<List<h>> f26054e = new c<>();

    /* renamed from: f  reason: collision with root package name */
    private final c<List<b0>> f26055f = new c<>();

    /* renamed from: g  reason: collision with root package name */
    private final c<List<a0>> f26056g = new c<>();

    /* renamed from: h  reason: collision with root package name */
    private final c<List<d0>> f26057h = new c<>();

    /* renamed from: i  reason: collision with root package name */
    private final c<List<e0>> f26058i = new c<>();

    /* renamed from: j  reason: collision with root package name */
    private final c<List<z>> f26059j = new c<>();

    /* renamed from: k  reason: collision with root package name */
    private final c<List<UiTrain>> f26060k = new c<>();

    /* renamed from: l  reason: collision with root package name */
    private final c<List<a>> f26061l = new c<>();

    /* renamed from: m  reason: collision with root package name */
    private final c<List<f0>> f26062m = new c<>();

    /* renamed from: n  reason: collision with root package name */
    private final c<List<y>> f26063n = new c<>();

    /* renamed from: o  reason: collision with root package name */
    private final c<Iterable<p>> f26064o = new c<>();

    /* renamed from: p  reason: collision with root package name */
    private u f26065p;

    /* renamed from: q  reason: collision with root package name */
    private Iterable<p> f26066q;

    /* renamed from: r  reason: collision with root package name */
    private final fh.a f26067r;

    /* renamed from: s  reason: collision with root package name */
    private final b<b0> f26068s;

    /* renamed from: t  reason: collision with root package name */
    private final b<a0> f26069t;

    /* renamed from: u  reason: collision with root package name */
    private final b<d0> f26070u;

    /* renamed from: v  reason: collision with root package name */
    private final b<e0> f26071v;

    /* renamed from: w  reason: collision with root package name */
    private final b<z> f26072w;

    /* renamed from: x  reason: collision with root package name */
    private final b<a> f26073x;

    /* renamed from: y  reason: collision with root package name */
    private final b<f0> f26074y;

    /* renamed from: z  reason: collision with root package name */
    private final b<y> f26075z;

    public d(String str) {
        fh.a aVar = new fh.a();
        this.f26067r = aVar;
        fh.d dVar = new fh.d();
        this.f26068s = dVar;
        fh.c cVar = new fh.c();
        this.f26069t = cVar;
        f fVar = new f();
        this.f26070u = fVar;
        e eVar = new e();
        this.f26071v = eVar;
        fh.b bVar = new fh.b();
        this.f26072w = bVar;
        fh.f fVar2 = new fh.f();
        this.f26073x = fVar2;
        fh.g gVar = new fh.g();
        this.f26074y = gVar;
        we.c cVar2 = new we.c();
        this.f26075z = cVar2;
        this.A = new b[]{aVar, dVar, cVar, fVar, eVar, bVar, fVar2, gVar, cVar2};
        this.f26051b = str;
    }

    private void B() {
        u uVar = this.f26065p;
        if (uVar != null) {
            this.f26052c.f(uVar);
            Iterable<p> iterable = this.f26066q;
            if (iterable != null) {
                this.f26063n.f(this.f26075z.a(iterable));
                this.f26054e.f(this.f26067r.a(this.f26066q));
                this.f26055f.f(this.f26068s.a(this.f26066q));
                this.f26056g.f(this.f26069t.a(this.f26066q));
                this.f26057h.f(this.f26070u.a(this.f26066q));
                this.f26058i.f(this.f26071v.a(this.f26066q));
                this.f26059j.f(this.f26072w.a(this.f26066q));
                this.f26060k.f(h(this.f26065p));
                ((fh.f) this.f26073x).g(this.f26065p.A);
                this.f26061l.f(this.f26073x.a(this.f26066q));
                ((fh.g) this.f26074y).g(this.f26065p.A);
                this.f26062m.f(this.f26074y.a(this.f26066q));
            }
        }
    }

    private List<UiTrain> h(u uVar) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        long j10 = 0;
        for (Long l10 : uVar.f26007z) {
            arrayList.add(new UiTrain(z10 ? UiTrain.Type.Train : UiTrain.Type.Relax, l10.longValue() - j10));
            j10 = l10.longValue();
            z10 = !z10;
        }
        arrayList.add(new UiTrain(z10 ? UiTrain.Type.Train : UiTrain.Type.Relax, uVar.f25991j - j10));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(q qVar, Throwable th2) {
        if (qVar == null) {
            qVar = new q();
        }
        this.f26064o.f(qVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(nf.h hVar, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            if (TextUtils.equals(uVar.f25984c, this.f26051b)) {
                this.f26065p = uVar;
                B();
                return;
            }
        }
        this.f26053d.f(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(nf.h hVar, Iterable iterable) {
        this.f26066q = iterable;
        B();
    }

    public void A(i iVar) {
        this.f26067r.k(iVar.f36548d);
    }

    @Override // nf.g
    protected void c(m mVar) {
        k.c("fit.vm.details", "load sport details for %s", this.f26051b);
        if (this.f26051b.isEmpty()) {
            this.f26052c.f(null);
            return;
        }
        yg.f.X().E(this.f26051b, new o() { // from class: eh.a
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                d.this.w((q) obj, th2);
            }
        });
        mVar.a(j.c(yg.f.X().N(), new nf.k() { // from class: eh.c
            @Override // nf.k
            public final void i(nf.h hVar, Object obj) {
                d.this.x(hVar, (Collection) obj);
            }
        }));
        mVar.a(j.c(this.f26064o, new nf.k() { // from class: eh.b
            @Override // nf.k
            public final void i(nf.h hVar, Object obj) {
                d.this.y(hVar, (Iterable) obj);
            }
        }));
    }

    public void i() {
        k.c("fit.vm.details", "delete sport %s", this.f26051b);
        if (!this.f26051b.isEmpty()) {
            yg.f.X().n(this.f26051b);
        }
    }

    public nf.h<List<h>> j() {
        return this.f26054e;
    }

    public nf.h<List<y>> k() {
        return this.f26063n;
    }

    public nf.h<List<z>> l() {
        return this.f26059j;
    }

    public nf.h<List<a0>> m() {
        return this.f26056g;
    }

    public nf.h<List<b0>> n() {
        return this.f26055f;
    }

    public nf.h<Boolean> o() {
        return this.f26053d;
    }

    public nf.h<Iterable<p>> p() {
        return this.f26064o;
    }

    public nf.h<u> q() {
        return this.f26052c;
    }

    public nf.h<List<d0>> r() {
        return this.f26057h;
    }

    public nf.h<List<e0>> s() {
        return this.f26058i;
    }

    public nf.h<List<a>> t() {
        return this.f26061l;
    }

    public nf.h<List<f0>> u() {
        return this.f26062m;
    }

    public nf.h<List<UiTrain>> v() {
        return this.f26060k;
    }

    public void z(boolean z10) {
        b[] bVarArr;
        for (b bVar : this.A) {
            if (bVar instanceof we.a) {
                ((we.a) bVar).e(z10);
            }
        }
        B();
    }
}
