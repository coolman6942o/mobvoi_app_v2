package hf;

import ef.r;
import ef.u;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import xe.b;
import zf.k;
/* compiled from: ClientSyncer.java */
/* loaded from: classes2.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private b f27839a = f();

    /* renamed from: b  reason: collision with root package name */
    private d f27840b = c();

    /* renamed from: c  reason: collision with root package name */
    private g f27841c = d();

    /* renamed from: d  reason: collision with root package name */
    private c f27842d = b();

    private c b() {
        return new c(this.f27839a);
    }

    private d c() {
        return new d(this.f27839a);
    }

    private g d() {
        return new g(this.f27839a);
    }

    public void a() {
        this.f27840b.d(h());
        this.f27841c.k(j());
        this.f27841c.j(i());
        for (i iVar : g()) {
            this.f27842d.b(iVar);
        }
    }

    public void e(String str) {
        this.f27842d.e(Collections.singletonList(str));
    }

    protected abstract b f();

    protected abstract List<i> g();

    protected abstract j h();

    protected abstract k i();

    protected abstract l j();

    public abstract String k();

    public void l(String str, o<r> oVar) {
        this.f27841c.h(str, oVar);
    }

    public void m(Date date, Date date2, int i10) {
        this.f27841c.i(date, date2, i10);
    }

    public boolean n() {
        return q() && r();
    }

    public void o(k kVar) {
        this.f27840b.e(kVar);
        this.f27841c.l(kVar);
        this.f27842d.l(kVar);
    }

    public nf.h<Collection<u>> p() {
        return this.f27839a.b();
    }

    public boolean q() {
        return this.f27842d.m();
    }

    public boolean r() {
        return this.f27840b.f();
    }
}
