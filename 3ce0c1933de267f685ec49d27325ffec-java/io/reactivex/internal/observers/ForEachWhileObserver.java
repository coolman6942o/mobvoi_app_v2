package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.a;
import zn.g;
import zn.p;
/* loaded from: classes2.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<b> implements r<T>, b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final a onComplete;
    final g<? super Throwable> onError;
    final p<? super T> onNext;

    public ForEachWhileObserver(p<? super T> pVar, g<? super Throwable> gVar, a aVar) {
        this.onNext = pVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // xn.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                fo.a.s(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.done) {
            fo.a.s(th2);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th2);
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            fo.a.s(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!this.done) {
            try {
                if (!this.onNext.test(t10)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                onError(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
