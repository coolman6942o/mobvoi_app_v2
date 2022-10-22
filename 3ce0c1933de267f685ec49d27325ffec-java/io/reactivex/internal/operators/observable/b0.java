package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableCreate.java */
/* loaded from: classes3.dex */
public final class b0<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final n<T> f28447a;

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<b> implements m<T>, b {
        private static final long serialVersionUID = -3434801548987643227L;
        final r<? super T> observer;

        a(r<? super T> rVar) {
            this.observer = rVar;
        }

        public void a(Throwable th2) {
            if (!b(th2)) {
                fo.a.s(th2);
            }
        }

        /* JADX WARN: Finally extract failed */
        public boolean b(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th2);
                dispose();
                return true;
            } catch (Throwable th3) {
                dispose();
                throw th3;
            }
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b0(n<T> nVar) {
        this.f28447a = nVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        try {
            this.f28447a.a(aVar);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            aVar.a(th2);
        }
    }
}
