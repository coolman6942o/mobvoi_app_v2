package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializedSubject.java */
/* loaded from: classes3.dex */
public final class b<T> extends c<T> implements a.AbstractC0348a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f29293a;

    /* renamed from: b  reason: collision with root package name */
    boolean f29294b;

    /* renamed from: c  reason: collision with root package name */
    a<Object> f29295c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f29296d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c<T> cVar) {
        this.f29293a = cVar;
    }

    void c() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f29295c;
                if (aVar == null) {
                    this.f29294b = false;
                    return;
                }
                this.f29295c = null;
            }
            aVar.c(this);
        }
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f29296d) {
            synchronized (this) {
                if (!this.f29296d) {
                    this.f29296d = true;
                    if (this.f29294b) {
                        a<Object> aVar = this.f29295c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f29295c = aVar;
                        }
                        aVar.b(NotificationLite.complete());
                        return;
                    }
                    this.f29294b = true;
                    this.f29293a.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.f29296d) {
            fo.a.s(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f29296d) {
                this.f29296d = true;
                if (this.f29294b) {
                    a<Object> aVar = this.f29295c;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.f29295c = aVar;
                    }
                    aVar.d(NotificationLite.error(th2));
                    return;
                }
                z10 = false;
                this.f29294b = true;
            }
            if (z10) {
                fo.a.s(th2);
            } else {
                this.f29293a.onError(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!this.f29296d) {
            synchronized (this) {
                if (!this.f29296d) {
                    if (this.f29294b) {
                        a<Object> aVar = this.f29295c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f29295c = aVar;
                        }
                        aVar.b(NotificationLite.next(t10));
                        return;
                    }
                    this.f29294b = true;
                    this.f29293a.onNext(t10);
                    c();
                }
            }
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(xn.b bVar) {
        boolean z10 = true;
        if (!this.f29296d) {
            synchronized (this) {
                if (!this.f29296d) {
                    if (this.f29294b) {
                        a<Object> aVar = this.f29295c;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f29295c = aVar;
                        }
                        aVar.b(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.f29294b = true;
                    z10 = false;
                }
            }
        }
        if (z10) {
            bVar.dispose();
            return;
        }
        this.f29293a.onSubscribe(bVar);
        c();
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f29293a.subscribe(rVar);
    }

    @Override // io.reactivex.internal.util.a.AbstractC0348a, zn.p
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f29293a);
    }
}
