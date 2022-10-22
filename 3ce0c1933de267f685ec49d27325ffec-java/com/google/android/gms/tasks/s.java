package com.google.android.gms.tasks;

import b6.i;
import b7.a;
import b7.b;
import b7.c;
import b7.d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s<TResult> extends b<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f10181a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final q<TResult> f10182b = new q<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f10183c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f10184d;

    /* renamed from: e  reason: collision with root package name */
    private TResult f10185e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f10186f;

    private final void u() {
        i.o(this.f10183c, "Task is not yet complete");
    }

    private final void v() {
        i.o(!this.f10183c, "Task is already complete");
    }

    private final void w() {
        if (this.f10184d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void x() {
        synchronized (this.f10181a) {
            if (this.f10183c) {
                this.f10182b.a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> a(Executor executor, a aVar) {
        this.f10182b.b(new h(executor, aVar));
        x();
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> b(b<TResult> bVar) {
        return c(d.f10150a, bVar);
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> c(Executor executor, b<TResult> bVar) {
        this.f10182b.b(new j(executor, bVar));
        x();
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> d(c cVar) {
        return e(d.f10150a, cVar);
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> e(Executor executor, c cVar) {
        this.f10182b.b(new l(executor, cVar));
        x();
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> f(d<? super TResult> dVar) {
        return g(d.f10150a, dVar);
    }

    @Override // com.google.android.gms.tasks.b
    public final b<TResult> g(Executor executor, d<? super TResult> dVar) {
        this.f10182b.b(new n(executor, dVar));
        x();
        return this;
    }

    @Override // com.google.android.gms.tasks.b
    public final <TContinuationResult> b<TContinuationResult> h(a<TResult, TContinuationResult> aVar) {
        return i(d.f10150a, aVar);
    }

    @Override // com.google.android.gms.tasks.b
    public final <TContinuationResult> b<TContinuationResult> i(Executor executor, a<TResult, TContinuationResult> aVar) {
        s sVar = new s();
        this.f10182b.b(new f(executor, aVar, sVar));
        x();
        return sVar;
    }

    @Override // com.google.android.gms.tasks.b
    public final Exception j() {
        Exception exc;
        synchronized (this.f10181a) {
            exc = this.f10186f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.b
    public final TResult k() {
        TResult tresult;
        synchronized (this.f10181a) {
            u();
            w();
            if (this.f10186f == null) {
                tresult = this.f10185e;
            } else {
                throw new RuntimeExecutionException(this.f10186f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.b
    public final <X extends Throwable> TResult l(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f10181a) {
            u();
            w();
            if (cls.isInstance(this.f10186f)) {
                throw cls.cast(this.f10186f);
            } else if (this.f10186f == null) {
                tresult = this.f10185e;
            } else {
                throw new RuntimeExecutionException(this.f10186f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean m() {
        return this.f10184d;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean n() {
        boolean z10;
        synchronized (this.f10181a) {
            z10 = this.f10183c;
        }
        return z10;
    }

    @Override // com.google.android.gms.tasks.b
    public final boolean o() {
        boolean z10;
        synchronized (this.f10181a) {
            z10 = this.f10183c && !this.f10184d && this.f10186f == null;
        }
        return z10;
    }

    public final void p(Exception exc) {
        i.l(exc, "Exception must not be null");
        synchronized (this.f10181a) {
            v();
            this.f10183c = true;
            this.f10186f = exc;
        }
        this.f10182b.a(this);
    }

    public final void q(TResult tresult) {
        synchronized (this.f10181a) {
            v();
            this.f10183c = true;
            this.f10185e = tresult;
        }
        this.f10182b.a(this);
    }

    public final boolean r(Exception exc) {
        i.l(exc, "Exception must not be null");
        synchronized (this.f10181a) {
            if (this.f10183c) {
                return false;
            }
            this.f10183c = true;
            this.f10186f = exc;
            this.f10182b.a(this);
            return true;
        }
    }

    public final boolean s(TResult tresult) {
        synchronized (this.f10181a) {
            if (this.f10183c) {
                return false;
            }
            this.f10183c = true;
            this.f10185e = tresult;
            this.f10182b.a(this);
            return true;
        }
    }

    public final boolean t() {
        synchronized (this.f10181a) {
            if (this.f10183c) {
                return false;
            }
            this.f10183c = true;
            this.f10184d = true;
            this.f10182b.a(this);
            return true;
        }
    }
}
