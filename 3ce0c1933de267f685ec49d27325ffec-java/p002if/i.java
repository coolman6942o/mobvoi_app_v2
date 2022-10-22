package p002if;

import android.content.Context;
import bf.c;
import com.mobvoi.companion.common.analytics.Module;
import ef.r;
import hf.j;
import hf.k;
import hf.l;
import hf.m;
import hf.n;
import hf.o;
import java.util.List;
/* compiled from: NetSyncClient.java */
/* renamed from: if.i  reason: invalid package */
/* loaded from: classes2.dex */
public class i implements j, hf.i, l, k {

    /* renamed from: a  reason: collision with root package name */
    private final e f28263a;

    /* renamed from: b  reason: collision with root package name */
    private final c f28264b;

    /* renamed from: c  reason: collision with root package name */
    private final h f28265c;

    public i(Context context, c cVar, int i10) {
        this.f28263a = new e(context, cVar, i10, a());
        this.f28264b = new c(context, cVar, a());
        this.f28265c = new h(context, cVar, i10, a());
    }

    @Override // hf.p
    public String a() {
        return Module.MAIN;
    }

    @Override // hf.i
    public void b(List<String> list) {
        this.f28264b.b(list);
    }

    @Override // hf.k
    public void c(String str, o<r> oVar) {
        this.f28265c.c(str, oVar);
    }

    @Override // hf.j
    public void d(List<r> list) {
        this.f28263a.d(list);
    }

    @Override // hf.j
    public void e(o<List<String>> oVar) {
        this.f28263a.e(oVar);
    }

    @Override // hf.l
    public void f(m mVar) {
        this.f28265c.f(mVar);
    }

    @Override // hf.i
    public void g(o<List<String>> oVar) {
        this.f28264b.g(oVar);
    }

    @Override // hf.l
    public void h(o<n> oVar) {
        this.f28265c.h(oVar);
    }

    public void i(String str, boolean z10) {
        this.f28265c.q(str, z10);
    }

    @Override // hf.a
    public boolean isConnected() {
        return this.f28263a.isConnected();
    }
}
