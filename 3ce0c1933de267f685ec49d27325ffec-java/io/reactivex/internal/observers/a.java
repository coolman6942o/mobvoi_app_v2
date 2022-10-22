package io.reactivex.internal.observers;

import co.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes2.dex */
public abstract class a<T, R> implements r<T>, b<R> {

    /* renamed from: a  reason: collision with root package name */
    protected final r<? super R> f28353a;

    /* renamed from: b  reason: collision with root package name */
    protected xn.b f28354b;

    /* renamed from: c  reason: collision with root package name */
    protected b<T> f28355c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f28356d;

    /* renamed from: e  reason: collision with root package name */
    protected int f28357e;

    public a(r<? super R> rVar) {
        this.f28353a = rVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th2) {
        io.reactivex.exceptions.a.b(th2);
        this.f28354b.dispose();
        onError(th2);
    }

    @Override // co.g
    public void clear() {
        this.f28355c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i10) {
        b<T> bVar = this.f28355c;
        if (bVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int requestFusion = bVar.requestFusion(i10);
        if (requestFusion != 0) {
            this.f28357e = requestFusion;
        }
        return requestFusion;
    }

    @Override // xn.b
    public void dispose() {
        this.f28354b.dispose();
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f28354b.isDisposed();
    }

    @Override // co.g
    public boolean isEmpty() {
        return this.f28355c.isEmpty();
    }

    @Override // co.g
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f28356d) {
            this.f28356d = true;
            this.f28353a.onComplete();
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.f28356d) {
            fo.a.s(th2);
            return;
        }
        this.f28356d = true;
        this.f28353a.onError(th2);
    }

    @Override // io.reactivex.r
    public final void onSubscribe(xn.b bVar) {
        if (DisposableHelper.validate(this.f28354b, bVar)) {
            this.f28354b = bVar;
            if (bVar instanceof b) {
                this.f28355c = (b) bVar;
            }
            if (b()) {
                this.f28353a.onSubscribe(this);
                a();
            }
        }
    }
}
