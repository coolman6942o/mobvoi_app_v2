package com.bumptech.glide.load.engine;

import n5.j;
import q4.b;
import t4.c;
/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class o<Z> implements c<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8018a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8019b;

    /* renamed from: c  reason: collision with root package name */
    private final c<Z> f8020c;

    /* renamed from: d  reason: collision with root package name */
    private final a f8021d;

    /* renamed from: e  reason: collision with root package name */
    private final b f8022e;

    /* renamed from: f  reason: collision with root package name */
    private int f8023f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8024g;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    interface a {
        void d(b bVar, o<?> oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c<Z> cVar, boolean z10, boolean z11, b bVar, a aVar) {
        this.f8020c = (c) j.d(cVar);
        this.f8018a = z10;
        this.f8019b = z11;
        this.f8022e = bVar;
        this.f8021d = (a) j.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f8024g) {
            this.f8023f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // t4.c
    public synchronized void b() {
        if (this.f8023f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f8024g) {
            this.f8024g = true;
            if (this.f8019b) {
                this.f8020c.b();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    @Override // t4.c
    public int c() {
        return this.f8020c.c();
    }

    @Override // t4.c
    public Class<Z> d() {
        return this.f8020c.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<Z> e() {
        return this.f8020c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f8018a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f8023f;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.f8023f = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            this.f8021d.d(this.f8022e, this);
        }
    }

    @Override // t4.c
    public Z get() {
        return this.f8020c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f8018a + ", listener=" + this.f8021d + ", key=" + this.f8022e + ", acquired=" + this.f8023f + ", isRecycled=" + this.f8024g + ", resource=" + this.f8020c + '}';
    }
}
