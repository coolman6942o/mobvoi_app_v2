package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.f;
import java.io.File;
import java.util.List;
import q4.b;
import r4.d;
import x4.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
public class s implements f, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final f.a f8035a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f8036b;

    /* renamed from: c  reason: collision with root package name */
    private int f8037c;

    /* renamed from: d  reason: collision with root package name */
    private int f8038d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f8039e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f8040f;

    /* renamed from: g  reason: collision with root package name */
    private int f8041g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f8042h;

    /* renamed from: i  reason: collision with root package name */
    private File f8043i;

    /* renamed from: j  reason: collision with root package name */
    private t f8044j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(g<?> gVar, f.a aVar) {
        this.f8036b = gVar;
        this.f8035a = aVar;
    }

    private boolean a() {
        return this.f8041g < this.f8040f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        List<b> c10 = this.f8036b.c();
        boolean z10 = false;
        if (c10.isEmpty()) {
            return false;
        }
        List<Class<?>> m10 = this.f8036b.m();
        if (!m10.isEmpty()) {
            while (true) {
                if (this.f8040f == null || !a()) {
                    int i10 = this.f8038d + 1;
                    this.f8038d = i10;
                    if (i10 >= m10.size()) {
                        int i11 = this.f8037c + 1;
                        this.f8037c = i11;
                        if (i11 >= c10.size()) {
                            return false;
                        }
                        this.f8038d = 0;
                    }
                    b bVar = c10.get(this.f8037c);
                    Class<?> cls = m10.get(this.f8038d);
                    this.f8044j = new t(this.f8036b.b(), bVar, this.f8036b.o(), this.f8036b.s(), this.f8036b.f(), this.f8036b.r(cls), cls, this.f8036b.k());
                    File b10 = this.f8036b.d().b(this.f8044j);
                    this.f8043i = b10;
                    if (b10 != null) {
                        this.f8039e = bVar;
                        this.f8040f = this.f8036b.j(b10);
                        this.f8041g = 0;
                    }
                } else {
                    this.f8042h = null;
                    while (!z10 && a()) {
                        List<n<File, ?>> list = this.f8040f;
                        int i12 = this.f8041g;
                        this.f8041g = i12 + 1;
                        this.f8042h = list.get(i12).b(this.f8043i, this.f8036b.s(), this.f8036b.f(), this.f8036b.k());
                        if (this.f8042h != null && this.f8036b.t(this.f8042h.f36404c.a())) {
                            this.f8042h.f36404c.e(this.f8036b.l(), this);
                            z10 = true;
                        }
                    }
                    return z10;
                }
            }
        } else if (File.class.equals(this.f8036b.q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f8036b.i() + " to " + this.f8036b.q());
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f8042h;
        if (aVar != null) {
            aVar.f36404c.cancel();
        }
    }

    @Override // r4.d.a
    public void d(Exception exc) {
        this.f8035a.a(this.f8044j, exc, this.f8042h.f36404c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // r4.d.a
    public void f(Object obj) {
        this.f8035a.e(this.f8039e, obj, this.f8042h.f36404c, DataSource.RESOURCE_DISK_CACHE, this.f8044j);
    }
}
