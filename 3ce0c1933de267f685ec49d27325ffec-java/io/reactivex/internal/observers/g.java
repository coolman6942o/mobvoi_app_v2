package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import xn.b;
import zn.a;
/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes2.dex */
public final class g<T> implements r<T>, b {

    /* renamed from: a  reason: collision with root package name */
    final r<? super T> f28366a;

    /* renamed from: b  reason: collision with root package name */
    final zn.g<? super b> f28367b;

    /* renamed from: c  reason: collision with root package name */
    final a f28368c;

    /* renamed from: d  reason: collision with root package name */
    b f28369d;

    public g(r<? super T> rVar, zn.g<? super b> gVar, a aVar) {
        this.f28366a = rVar;
        this.f28367b = gVar;
        this.f28368c = aVar;
    }

    @Override // xn.b
    public void dispose() {
        b bVar = this.f28369d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f28369d = disposableHelper;
            try {
                this.f28368c.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                fo.a.s(th2);
            }
            bVar.dispose();
        }
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f28369d.isDisposed();
    }

    @Override // io.reactivex.r
    public void onComplete() {
        b bVar = this.f28369d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f28369d = disposableHelper;
            this.f28366a.onComplete();
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        b bVar = this.f28369d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f28369d = disposableHelper;
            this.f28366a.onError(th2);
            return;
        }
        fo.a.s(th2);
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        this.f28366a.onNext(t10);
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        try {
            this.f28367b.accept(bVar);
            if (DisposableHelper.validate(this.f28369d, bVar)) {
                this.f28369d = bVar;
                this.f28366a.onSubscribe(this);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            bVar.dispose();
            this.f28369d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th2, this.f28366a);
        }
    }
}
