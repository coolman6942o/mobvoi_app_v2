package com.mobvoi.assistant.account.data;

import com.mobvoi.android.common.utils.o;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.b;
import java.util.Locale;
import okhttp3.a0;
import okhttp3.x;
import okhttp3.y;
import ra.b;
import ra.f;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.c;
import sa.d;
import sa.e;
import sa.g;
import sa.h;
import sa.i;
import sa.j;
import sa.k;
import sa.l;
import sa.m;
import sa.n;
/* compiled from: AccountApiHelperImpl.java */
/* loaded from: classes2.dex */
public class a extends f implements b {

    /* renamed from: d  reason: collision with root package name */
    private static a f15639d;

    /* renamed from: b  reason: collision with root package name */
    private final ra.a f15640b = (ra.a) this.f33485a.create(ra.a.class);

    /* renamed from: c  reason: collision with root package name */
    private final ra.a f15641c = (ra.a) new Retrofit.Builder().baseUrl(u()).client(r()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(ra.a.class);

    private a() {
    }

    private String u() {
        return "https://ticwear-account.ekswaizei.xyz/";
    }

    public static synchronized a v() {
        a aVar;
        synchronized (a.class) {
            if (f15639d == null) {
                f15639d = new a();
            }
            aVar = f15639d;
        }
        return aVar;
    }

    private ra.a w() {
        return ta.a.y() ? this.f15641c : this.f15640b;
    }

    public c<sa.c> A(String str, String str2) {
        o.e(str);
        return w().m(str, str2);
    }

    @Override // ra.b
    public c<sa.c> a(k kVar) {
        o.e(kVar);
        return w().a(kVar);
    }

    @Override // ra.b
    public c<g> b(e eVar) {
        o.e(eVar);
        return w().b(eVar);
    }

    @Override // ra.b
    public c<sa.c> c(String str) {
        o.e(str);
        return w().c(str);
    }

    @Override // ra.b
    public c<sa.c> d(i iVar) {
        o.e(iVar);
        return w().d(iVar);
    }

    @Override // ra.b
    public c<sa.c> e(sa.a aVar) {
        o.e(aVar);
        return w().e(aVar);
    }

    @Override // ra.b
    public c<sa.c> f(String str, boolean z10) {
        o.e(str);
        return w().f(str, z10);
    }

    @Override // ra.b
    public c<g> g(l lVar) {
        o.e(lVar);
        return w().g(lVar);
    }

    @Override // ra.b
    public c<g> h(sa.f fVar) {
        o.e(fVar);
        return w().h(fVar);
    }

    @Override // ra.b
    public c<sa.c> i(String str, String str2, String str3, String str4, String str5) {
        return w().i(str, str2, str3, str4, str5);
    }

    @Override // ra.b
    public c<g> j(String str, String str2, String str3) {
        return w().j(str, str2, str3);
    }

    @Override // ra.b
    public c<d> k(a0 a0Var, x.c cVar) {
        o.e(a0Var);
        o.e(cVar);
        return w().k(a0Var, cVar);
    }

    @Override // ra.b
    public c<sa.c> l(m mVar) {
        o.e(mVar);
        return w().s(lb.c.j(), lb.c.k(), mVar);
    }

    @Override // ra.b
    public c<sa.c> m(String str, h hVar) {
        o.e(str);
        o.e(hVar);
        return w().q(str, hVar);
    }

    @Override // ra.b
    public c<sa.c> n(j jVar) {
        o.e(jVar);
        return w().o(lb.c.j(), lb.c.k(), jVar);
    }

    @Override // ra.f
    protected void p(y.a aVar) {
        super.p(aVar);
        Locale locale = com.mobvoi.android.common.utils.b.e().getResources().getConfiguration().locale;
        String str = locale.getLanguage() + "-" + locale.getCountry();
        com.mobvoi.android.common.utils.k.h("AccountApiHelperImpl", str);
        aVar.a(new b.C0196b().b(AccountConstant.b().a()).a("Accept-Language", str).c());
        aVar.a(new d());
        aVar.a(new c());
    }

    public c<sa.b> t(String str, boolean z10) {
        return w().r(str, z10);
    }

    public c<sa.o> x(String str) {
        return w().p(new n(ta.a.x(), ta.a.d(), str));
    }

    public c<sa.b> y(String str) {
        return w().l(str);
    }

    public c<sa.c> z(String str, boolean z10) {
        o.e(str);
        return w().n(str, z10);
    }
}
