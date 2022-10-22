package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
import xn.b;
import zn.a;
import zn.g;
import zn.p;
/* loaded from: classes3.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<c> implements f<T>, b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final a onComplete;
    final g<? super Throwable> onError;
    final p<? super T> onNext;

    public ForEachWhileSubscriber(p<? super T> pVar, g<? super Throwable> gVar, a aVar) {
        this.onNext = pVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // xn.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // vp.b
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

    @Override // vp.b
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

    @Override // vp.b
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

    @Override // vp.b
    public void onSubscribe(c cVar) {
        SubscriptionHelper.setOnce(this, cVar, Long.MAX_VALUE);
    }
}
