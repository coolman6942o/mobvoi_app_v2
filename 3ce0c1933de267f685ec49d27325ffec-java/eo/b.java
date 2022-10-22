package eo;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.e;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableObserver.java */
/* loaded from: classes3.dex */
public abstract class b<T> implements r<T>, xn.b {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<xn.b> f26229a = new AtomicReference<>();

    protected void a() {
    }

    @Override // xn.b
    public final void dispose() {
        DisposableHelper.dispose(this.f26229a);
    }

    @Override // xn.b
    public final boolean isDisposed() {
        return this.f26229a.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.r
    public final void onSubscribe(xn.b bVar) {
        if (e.c(this.f26229a, bVar, getClass())) {
            a();
        }
    }
}
