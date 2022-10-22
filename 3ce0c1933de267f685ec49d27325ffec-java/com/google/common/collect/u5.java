package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.c;
import com.google.common.base.l;
import com.google.common.base.p;
import com.google.common.collect.v5;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* compiled from: MapMaker.java */
/* loaded from: classes.dex */
public final class u5 {

    /* renamed from: a  reason: collision with root package name */
    boolean f12193a;

    /* renamed from: b  reason: collision with root package name */
    int f12194b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f12195c = -1;

    /* renamed from: d  reason: collision with root package name */
    v5.n f12196d;

    /* renamed from: e  reason: collision with root package name */
    v5.n f12197e;

    /* renamed from: f  reason: collision with root package name */
    Equivalence<Object> f12198f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i10 = this.f12195c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i10 = this.f12194b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) l.a(this.f12198f, d().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v5.n d() {
        return (v5.n) l.a(this.f12196d, v5.n.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v5.n e() {
        return (v5.n) l.a(this.f12197e, v5.n.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> f() {
        if (!this.f12193a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return v5.b(this);
    }

    u5 g(v5.n nVar) {
        v5.n nVar2 = this.f12196d;
        p.x(nVar2 == null, "Key strength was already set to %s", nVar2);
        this.f12196d = (v5.n) p.o(nVar);
        if (nVar != v5.n.STRONG) {
            this.f12193a = true;
        }
        return this;
    }

    public u5 h() {
        return g(v5.n.WEAK);
    }

    public String toString() {
        l.b b10 = l.b(this);
        int i10 = this.f12194b;
        if (i10 != -1) {
            b10.b("initialCapacity", i10);
        }
        int i11 = this.f12195c;
        if (i11 != -1) {
            b10.b("concurrencyLevel", i11);
        }
        v5.n nVar = this.f12196d;
        if (nVar != null) {
            b10.d("keyStrength", c.c(nVar.toString()));
        }
        v5.n nVar2 = this.f12197e;
        if (nVar2 != null) {
            b10.d("valueStrength", c.c(nVar2.toString()));
        }
        if (this.f12198f != null) {
            b10.h("keyEquivalence");
        }
        return b10.toString();
    }
}
