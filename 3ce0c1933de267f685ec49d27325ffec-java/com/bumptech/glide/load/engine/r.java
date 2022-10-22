package com.bumptech.glide.load.engine;

import j0.e;
import n5.j;
import o5.a;
import t4.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockedResource.java */
/* loaded from: classes.dex */
public final class r<Z> implements c<Z>, a.f {

    /* renamed from: e  reason: collision with root package name */
    private static final e<r<?>> f8030e = o5.a.d(20, new a());

    /* renamed from: a  reason: collision with root package name */
    private final o5.c f8031a = o5.c.a();

    /* renamed from: b  reason: collision with root package name */
    private c<Z> f8032b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8033c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8034d;

    /* compiled from: LockedResource.java */
    /* loaded from: classes.dex */
    class a implements a.d<r<?>> {
        a() {
        }

        /* renamed from: b */
        public r<?> a() {
            return new r<>();
        }
    }

    r() {
    }

    private void a(c<Z> cVar) {
        this.f8034d = false;
        this.f8033c = true;
        this.f8032b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> r<Z> e(c<Z> cVar) {
        r<Z> rVar = (r) j.d(f8030e.b());
        rVar.a(cVar);
        return rVar;
    }

    private void g() {
        this.f8032b = null;
        f8030e.a(this);
    }

    @Override // t4.c
    public synchronized void b() {
        this.f8031a.c();
        this.f8034d = true;
        if (!this.f8033c) {
            this.f8032b.b();
            g();
        }
    }

    @Override // t4.c
    public int c() {
        return this.f8032b.c();
    }

    @Override // t4.c
    public Class<Z> d() {
        return this.f8032b.d();
    }

    @Override // o5.a.f
    public o5.c f() {
        return this.f8031a;
    }

    @Override // t4.c
    public Z get() {
        return this.f8032b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void h() {
        this.f8031a.c();
        if (this.f8033c) {
            this.f8033c = false;
            if (this.f8034d) {
                b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}
