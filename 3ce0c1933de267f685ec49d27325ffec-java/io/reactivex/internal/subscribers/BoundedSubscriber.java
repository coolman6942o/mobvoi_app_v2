package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import vp.c;
import xn.b;
import zn.a;
import zn.g;
/* loaded from: classes3.dex */
public final class BoundedSubscriber<T> extends AtomicReference<c> implements f<T>, c, b {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super c> onSubscribe;

    public BoundedSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super c> gVar3, int i10) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
        this.bufferSize = i10;
        this.limit = i10 - (i10 >> 2);
    }

    @Override // vp.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // xn.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != bo.a.f5361e;
    }

    @Override // xn.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // vp.b
    public void onComplete() {
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
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
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                fo.a.s(new CompositeException(th2, th3));
            }
        } else {
            fo.a.s(th2);
        }
    }

    @Override // vp.b
    public void onNext(T t10) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t10);
                int i10 = this.consumed + 1;
                if (i10 == this.limit) {
                    this.consumed = 0;
                    get().request(this.limit);
                } else {
                    this.consumed = i10;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                get().cancel();
                onError(th2);
            }
        }
    }

    @Override // vp.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cVar.cancel();
                onError(th2);
            }
        }
    }

    @Override // vp.c
    public void request(long j10) {
        get().request(j10);
    }
}
