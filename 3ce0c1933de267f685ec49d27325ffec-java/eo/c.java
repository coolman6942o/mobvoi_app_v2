package eo;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.r;
import xn.b;
/* compiled from: SafeObserver.java */
/* loaded from: classes3.dex */
public final class c<T> implements r<T>, b {

    /* renamed from: a  reason: collision with root package name */
    final r<? super T> f26230a;

    /* renamed from: b  reason: collision with root package name */
    b f26231b;

    /* renamed from: c  reason: collision with root package name */
    boolean f26232c;

    public c(r<? super T> rVar) {
        this.f26230a = rVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f26230a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f26230a.onError(nullPointerException);
            } catch (Throwable th2) {
                a.b(th2);
                fo.a.s(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            a.b(th3);
            fo.a.s(new CompositeException(nullPointerException, th3));
        }
    }

    void b() {
        this.f26232c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f26230a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f26230a.onError(nullPointerException);
            } catch (Throwable th2) {
                a.b(th2);
                fo.a.s(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            a.b(th3);
            fo.a.s(new CompositeException(nullPointerException, th3));
        }
    }

    @Override // xn.b
    public void dispose() {
        this.f26231b.dispose();
    }

    @Override // xn.b
    public boolean isDisposed() {
        return this.f26231b.isDisposed();
    }

    @Override // io.reactivex.r
    public void onComplete() {
        if (!this.f26232c) {
            this.f26232c = true;
            if (this.f26231b == null) {
                a();
                return;
            }
            try {
                this.f26230a.onComplete();
            } catch (Throwable th2) {
                a.b(th2);
                fo.a.s(th2);
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        if (this.f26232c) {
            fo.a.s(th2);
            return;
        }
        this.f26232c = true;
        if (this.f26231b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f26230a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f26230a.onError(new CompositeException(th2, nullPointerException));
                } catch (Throwable th3) {
                    a.b(th3);
                    fo.a.s(new CompositeException(th2, nullPointerException, th3));
                }
            } catch (Throwable th4) {
                a.b(th4);
                fo.a.s(new CompositeException(th2, nullPointerException, th4));
            }
        } else {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f26230a.onError(th2);
            } catch (Throwable th5) {
                a.b(th5);
                fo.a.s(new CompositeException(th2, th5));
            }
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        if (!this.f26232c) {
            if (this.f26231b == null) {
                b();
            } else if (t10 == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f26231b.dispose();
                    onError(nullPointerException);
                } catch (Throwable th2) {
                    a.b(th2);
                    onError(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    this.f26230a.onNext(t10);
                } catch (Throwable th3) {
                    a.b(th3);
                    try {
                        this.f26231b.dispose();
                        onError(th3);
                    } catch (Throwable th4) {
                        a.b(th4);
                        onError(new CompositeException(th3, th4));
                    }
                }
            }
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f26231b, bVar)) {
            this.f26231b = bVar;
            try {
                this.f26230a.onSubscribe(this);
            } catch (Throwable th2) {
                a.b(th2);
                this.f26232c = true;
                try {
                    bVar.dispose();
                    fo.a.s(th2);
                } catch (Throwable th3) {
                    a.b(th3);
                    fo.a.s(new CompositeException(th2, th3));
                }
            }
        }
    }
}
