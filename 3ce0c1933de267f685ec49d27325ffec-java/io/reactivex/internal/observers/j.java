package io.reactivex.internal.observers;

import co.f;
import io.reactivex.internal.util.h;
import io.reactivex.internal.util.k;
import io.reactivex.r;
import xn.b;
/* compiled from: QueueDrainObserver.java */
/* loaded from: classes2.dex */
public abstract class j<T, U, V> extends l implements r<T>, h<U, V> {

    /* renamed from: b  reason: collision with root package name */
    protected final r<? super V> f28373b;

    /* renamed from: c  reason: collision with root package name */
    protected final f<U> f28374c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile boolean f28375d;

    /* renamed from: e  reason: collision with root package name */
    protected volatile boolean f28376e;

    /* renamed from: f  reason: collision with root package name */
    protected Throwable f28377f;

    public j(r<? super V> rVar, f<U> fVar) {
        this.f28373b = rVar;
        this.f28374c = fVar;
    }

    @Override // io.reactivex.internal.util.h
    public final boolean a() {
        return this.f28376e;
    }

    @Override // io.reactivex.internal.util.h
    public final boolean b() {
        return this.f28375d;
    }

    @Override // io.reactivex.internal.util.h
    public void c(r<? super V> rVar, U u10) {
    }

    @Override // io.reactivex.internal.util.h
    public final Throwable d() {
        return this.f28377f;
    }

    @Override // io.reactivex.internal.util.h
    public final int e(int i10) {
        return this.f28378a.addAndGet(i10);
    }

    public final boolean f() {
        return this.f28378a.getAndIncrement() == 0;
    }

    public final boolean g() {
        return this.f28378a.get() == 0 && this.f28378a.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(U u10, boolean z10, b bVar) {
        r<? super V> rVar = this.f28373b;
        f<U> fVar = this.f28374c;
        if (this.f28378a.get() != 0 || !this.f28378a.compareAndSet(0, 1)) {
            fVar.offer(u10);
            if (!f()) {
                return;
            }
        } else {
            c(rVar, u10);
            if (e(-1) == 0) {
                return;
            }
        }
        k.c(fVar, rVar, z10, bVar, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(U u10, boolean z10, b bVar) {
        r<? super V> rVar = this.f28373b;
        f<U> fVar = this.f28374c;
        if (this.f28378a.get() != 0 || !this.f28378a.compareAndSet(0, 1)) {
            fVar.offer(u10);
            if (!f()) {
                return;
            }
        } else if (fVar.isEmpty()) {
            c(rVar, u10);
            if (e(-1) == 0) {
                return;
            }
        } else {
            fVar.offer(u10);
        }
        k.c(fVar, rVar, z10, bVar, this);
    }
}
