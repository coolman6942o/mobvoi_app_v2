package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.f;
import java.util.Collections;
import java.util.List;
import q4.a;
import q4.b;
import r4.d;
import x4.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class v implements f, d.a<Object>, f.a {

    /* renamed from: a  reason: collision with root package name */
    private final g<?> f8056a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f8057b;

    /* renamed from: c  reason: collision with root package name */
    private int f8058c;

    /* renamed from: d  reason: collision with root package name */
    private c f8059d;

    /* renamed from: e  reason: collision with root package name */
    private Object f8060e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n.a<?> f8061f;

    /* renamed from: g  reason: collision with root package name */
    private d f8062g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g<?> gVar, f.a aVar) {
        this.f8056a = gVar;
        this.f8057b = aVar;
    }

    /* JADX WARN: Finally extract failed */
    private void g(Object obj) {
        long b10 = n5.f.b();
        try {
            a<X> p10 = this.f8056a.p(obj);
            e eVar = new e(p10, obj, this.f8056a.k());
            this.f8062g = new d(this.f8061f.f36402a, this.f8056a.o());
            this.f8056a.d().a(this.f8062g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f8062g + ", data: " + obj + ", encoder: " + p10 + ", duration: " + n5.f.a(b10));
            }
            this.f8061f.f36404c.c();
            this.f8059d = new c(Collections.singletonList(this.f8061f.f36402a), this.f8056a, this);
        } catch (Throwable th2) {
            this.f8061f.f36404c.c();
            throw th2;
        }
    }

    private boolean h() {
        return this.f8058c < this.f8056a.g().size();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(b bVar, Exception exc, d<?> dVar, DataSource dataSource) {
        this.f8057b.a(bVar, exc, dVar, this.f8061f.f36404c.b());
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        Object obj = this.f8060e;
        if (obj != null) {
            this.f8060e = null;
            g(obj);
        }
        c cVar = this.f8059d;
        if (cVar != null && cVar.b()) {
            return true;
        }
        this.f8059d = null;
        this.f8061f = null;
        boolean z10 = false;
        while (!z10 && h()) {
            List<n.a<?>> g10 = this.f8056a.g();
            int i10 = this.f8058c;
            this.f8058c = i10 + 1;
            this.f8061f = g10.get(i10);
            if (this.f8061f != null && (this.f8056a.e().c(this.f8061f.f36404c.b()) || this.f8056a.t(this.f8061f.f36404c.a()))) {
                this.f8061f.f36404c.e(this.f8056a.l(), this);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f8061f;
        if (aVar != null) {
            aVar.f36404c.cancel();
        }
    }

    @Override // r4.d.a
    public void d(Exception exc) {
        this.f8057b.a(this.f8062g, exc, this.f8061f.f36404c, this.f8061f.f36404c.b());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void e(b bVar, Object obj, d<?> dVar, DataSource dataSource, b bVar2) {
        this.f8057b.e(bVar, obj, dVar, this.f8061f.f36404c.b(), bVar);
    }

    @Override // r4.d.a
    public void f(Object obj) {
        t4.a e10 = this.f8056a.e();
        if (obj == null || !e10.c(this.f8061f.f36404c.b())) {
            this.f8057b.e(this.f8061f.f36402a, obj, this.f8061f.f36404c, this.f8061f.f36404c.b(), this.f8062g);
            return;
        }
        this.f8060e = obj;
        this.f8057b.c();
    }
}
