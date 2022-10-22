package eo;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.r;
import xn.b;
/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public final class d<T> implements r<T>, b {

    /* renamed from: a  reason: collision with root package name */
    final r<? super T> f26233a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f26234b;

    /* renamed from: c  reason: collision with root package name */
    b f26235c;

    /* renamed from: d  reason: collision with root package name */
    boolean f26236d;

    /* renamed from: e  reason: collision with root package name */
    a<Object> f26237e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f26238f;

    public d(r<? super T> rVar) {
        this(rVar, false);
    }

    void a() {
        a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f26237e;
                if (aVar == null) {
                    this.f26236d = false;
                    return;
                }
                this.f26237e = null;
            }
        } while (!aVar.a((r<? super T>) this.f26233a));
    }

    @Override // xn.b
    public void dispose() {
        this.f26235c.dispose();
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f26235c.isDisposed();
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f26238f) {
            synchronized (this) {
                if (!this.f26238f) {
                    if (this.f26236d) {
                        a<Object> aVar = this.f26237e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f26237e = aVar;
                        }
                        aVar.b(NotificationLite.complete());
                        return;
                    }
                    this.f26238f = true;
                    this.f26236d = true;
                    this.f26233a.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.f26238f) {
            fo.a.s(th2);
            return;
        }
        synchronized (this) {
            boolean z10 = true;
            if (!this.f26238f) {
                if (this.f26236d) {
                    this.f26238f = true;
                    a<Object> aVar = this.f26237e;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.f26237e = aVar;
                    }
                    Object error = NotificationLite.error(th2);
                    if (this.f26234b) {
                        aVar.b(error);
                    } else {
                        aVar.d(error);
                    }
                    return;
                }
                this.f26238f = true;
                this.f26236d = true;
                z10 = false;
            }
            if (z10) {
                fo.a.s(th2);
            } else {
                this.f26233a.onError(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!this.f26238f) {
            if (t10 == null) {
                this.f26235c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f26238f) {
                    if (this.f26236d) {
                        a<Object> aVar = this.f26237e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f26237e = aVar;
                        }
                        aVar.b(NotificationLite.next(t10));
                        return;
                    }
                    this.f26236d = true;
                    this.f26233a.onNext(t10);
                    a();
                }
            }
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f26235c, bVar)) {
            this.f26235c = bVar;
            this.f26233a.onSubscribe(this);
        }
    }

    public d(r<? super T> rVar, boolean z10) {
        this.f26233a = rVar;
        this.f26234b = z10;
    }
}
