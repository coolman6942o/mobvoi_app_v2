package aq;

import rx.d;
import rx.exceptions.OnErrorNotImplementedException;
/* compiled from: Observers.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final d<Object> f4907a = new C0060a();

    /* compiled from: Observers.java */
    /* renamed from: aq.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0060a implements d<Object> {
        C0060a() {
        }

        @Override // rx.d
        public final void onCompleted() {
        }

        @Override // rx.d
        public final void onError(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }

        @Override // rx.d
        public final void onNext(Object obj) {
        }
    }

    public static <T> d<T> a() {
        return (d<T>) f4907a;
    }
}
