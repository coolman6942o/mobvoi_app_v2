package jd;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.companion.device.PiiAlterActivity;
import com.mobvoi.companion.profile.h;
import jd.k;
import kd.a;
/* compiled from: HealthChangePresenter.java */
/* loaded from: classes2.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private k f29529a;

    /* renamed from: b  reason: collision with root package name */
    private final h f29530b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f29531c;

    /* renamed from: d  reason: collision with root package name */
    private final k.a f29532d;

    public d(Context context, h hVar, k.a aVar) {
        this.f29530b = hVar;
        this.f29531c = context;
        this.f29532d = aVar;
    }

    @Override // jd.h
    public void a(String str) {
        l lVar = new l(this.f29530b, str);
        this.f29529a = lVar;
        lVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void b(int i10) {
        m mVar = new m(this.f29530b, i10);
        this.f29529a = mVar;
        mVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void c(long j10) {
        a aVar = new a(this.f29530b, j10);
        this.f29529a = aVar;
        aVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void d(float f10) {
        if (!com.mobvoi.companion.base.settings.a.isUnitMetric(this.f29531c)) {
            this.f29529a = new f(this.f29530b, f10);
        } else {
            this.f29529a = new g(this.f29530b, f10);
        }
        this.f29529a.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void e() {
        n nVar = new n(this.f29530b);
        this.f29529a = nVar;
        nVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void f(int i10) {
        a aVar = new a(this.f29530b, i10);
        this.f29529a = aVar;
        aVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void g(boolean z10) {
        this.f29530b.i(z10);
    }

    @Override // jd.h
    public void h(int i10) {
        c cVar = new c(this.f29530b, i10);
        this.f29529a = cVar;
        cVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void i(int i10) {
        b bVar = new b(this.f29530b, i10);
        this.f29529a = bVar;
        bVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }

    @Override // jd.h
    public void j() {
        this.f29531c.startActivity(new Intent(this.f29531c, PiiAlterActivity.class));
    }

    @Override // jd.h
    public void k(float f10) {
        o oVar = new o(this.f29530b, f10);
        this.f29529a = oVar;
        oVar.k(this.f29532d);
        this.f29529a.l(this.f29531c);
    }
}
