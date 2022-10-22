package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q4.b;
import q4.f;
import t4.a;
import t4.c;
import x4.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class g<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f7891a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f7892b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e f7893c;

    /* renamed from: d  reason: collision with root package name */
    private Object f7894d;

    /* renamed from: e  reason: collision with root package name */
    private int f7895e;

    /* renamed from: f  reason: collision with root package name */
    private int f7896f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f7897g;

    /* renamed from: h  reason: collision with root package name */
    private h.e f7898h;

    /* renamed from: i  reason: collision with root package name */
    private q4.e f7899i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, q4.g<?>> f7900j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f7901k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7902l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7903m;

    /* renamed from: n  reason: collision with root package name */
    private b f7904n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f7905o;

    /* renamed from: p  reason: collision with root package name */
    private a f7906p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f7907q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7908r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f7893c = null;
        this.f7894d = null;
        this.f7904n = null;
        this.f7897g = null;
        this.f7901k = null;
        this.f7899i = null;
        this.f7905o = null;
        this.f7900j = null;
        this.f7906p = null;
        this.f7891a.clear();
        this.f7902l = false;
        this.f7892b.clear();
        this.f7903m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u4.b b() {
        return this.f7893c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> c() {
        if (!this.f7903m) {
            this.f7903m = true;
            this.f7892b.clear();
            List<n.a<?>> g10 = g();
            int size = g10.size();
            for (int i10 = 0; i10 < size; i10++) {
                n.a<?> aVar = g10.get(i10);
                if (!this.f7892b.contains(aVar.f36402a)) {
                    this.f7892b.add(aVar.f36402a);
                }
                for (int i11 = 0; i11 < aVar.f36403b.size(); i11++) {
                    if (!this.f7892b.contains(aVar.f36403b.get(i11))) {
                        this.f7892b.add(aVar.f36403b.get(i11));
                    }
                }
            }
        }
        return this.f7892b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v4.a d() {
        return this.f7898h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a e() {
        return this.f7906p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f7896f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.f7902l) {
            this.f7902l = true;
            this.f7891a.clear();
            List i10 = this.f7893c.h().i(this.f7894d);
            int size = i10.size();
            for (int i11 = 0; i11 < size; i11++) {
                n.a<?> b10 = ((n) i10.get(i11)).b(this.f7894d, this.f7895e, this.f7896f, this.f7899i);
                if (b10 != null) {
                    this.f7891a.add(b10);
                }
            }
        }
        return this.f7891a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> q<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f7893c.h().h(cls, this.f7897g, this.f7901k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f7894d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f7893c.h().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4.e k() {
        return this.f7899i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.f7905o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f7893c.h().j(this.f7894d.getClass(), this.f7897g, this.f7901k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> f<Z> n(c<Z> cVar) {
        return this.f7893c.h().k(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b o() {
        return this.f7904n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> q4.a<X> p(X x10) throws Registry.NoSourceEncoderAvailableException {
        return this.f7893c.h().m(x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.f7901k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> q4.g<Z> r(Class<Z> cls) {
        q4.g<Z> gVar = (q4.g<Z>) this.f7900j.get(cls);
        if (gVar == null) {
            Iterator<Map.Entry<Class<?>, q4.g<?>>> it = this.f7900j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, q4.g<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    gVar = (q4.g<Z>) next.getValue();
                    break;
                }
            }
        }
        if (gVar != null) {
            return gVar;
        }
        if (!this.f7900j.isEmpty() || !this.f7907q) {
            return z4.c.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f7895e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(e eVar, Object obj, b bVar, int i10, int i11, a aVar, Class<?> cls, Class<R> cls2, Priority priority, q4.e eVar2, Map<Class<?>, q4.g<?>> map, boolean z10, boolean z11, h.e eVar3) {
        this.f7893c = eVar;
        this.f7894d = obj;
        this.f7904n = bVar;
        this.f7895e = i10;
        this.f7896f = i11;
        this.f7906p = aVar;
        this.f7897g = cls;
        this.f7898h = eVar3;
        this.f7901k = cls2;
        this.f7905o = priority;
        this.f7899i = eVar2;
        this.f7900j = map;
        this.f7907q = z10;
        this.f7908r = z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(c<?> cVar) {
        return this.f7893c.h().n(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f7908r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(b bVar) {
        List<n.a<?>> g10 = g();
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (g10.get(i10).f36402a.equals(bVar)) {
                return true;
            }
        }
        return false;
    }
}
