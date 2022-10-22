package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.f;
import java.io.File;
import java.util.List;
import q4.b;
import r4.d;
import x4.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
public class c implements f, d.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f7877a;

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f7878b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f7879c;

    /* renamed from: d  reason: collision with root package name */
    private int f7880d;

    /* renamed from: e  reason: collision with root package name */
    private b f7881e;

    /* renamed from: f  reason: collision with root package name */
    private List<n<File, ?>> f7882f;

    /* renamed from: g  reason: collision with root package name */
    private int f7883g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f7884h;

    /* renamed from: i  reason: collision with root package name */
    private File f7885i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        return this.f7883g < this.f7882f.size();
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        while (true) {
            boolean z10 = false;
            if (this.f7882f == null || !a()) {
                int i10 = this.f7880d + 1;
                this.f7880d = i10;
                if (i10 >= this.f7877a.size()) {
                    return false;
                }
                b bVar = this.f7877a.get(this.f7880d);
                File b10 = this.f7878b.d().b(new d(bVar, this.f7878b.o()));
                this.f7885i = b10;
                if (b10 != null) {
                    this.f7881e = bVar;
                    this.f7882f = this.f7878b.j(b10);
                    this.f7883g = 0;
                }
            } else {
                this.f7884h = null;
                while (!z10 && a()) {
                    List<n<File, ?>> list = this.f7882f;
                    int i11 = this.f7883g;
                    this.f7883g = i11 + 1;
                    this.f7884h = list.get(i11).b(this.f7885i, this.f7878b.s(), this.f7878b.f(), this.f7878b.k());
                    if (this.f7884h != null && this.f7878b.t(this.f7884h.f36404c.a())) {
                        this.f7884h.f36404c.e(this.f7878b.l(), this);
                        z10 = true;
                    }
                }
                return z10;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f7884h;
        if (aVar != null) {
            aVar.f36404c.cancel();
        }
    }

    @Override // r4.d.a
    public void d(Exception exc) {
        this.f7879c.a(this.f7881e, exc, this.f7884h.f36404c, DataSource.DATA_DISK_CACHE);
    }

    @Override // r4.d.a
    public void f(Object obj) {
        this.f7879c.e(this.f7881e, obj, this.f7884h.f36404c, DataSource.DATA_DISK_CACHE, this.f7881e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(List<b> list, g<?> gVar, f.a aVar) {
        this.f7880d = -1;
        this.f7877a = list;
        this.f7878b = gVar;
        this.f7879c = aVar;
    }
}
