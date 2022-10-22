package aq;

import rx.d;
import rx.i;
/* compiled from: Subscribers.java */
/* loaded from: classes3.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Subscribers.java */
    /* loaded from: classes3.dex */
    public static class a extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f4917a;

        a(d dVar) {
            this.f4917a = dVar;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f4917a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f4917a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f4917a.onNext(t10);
        }
    }

    /* compiled from: Subscribers.java */
    /* loaded from: classes3.dex */
    static class b extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f4918a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i iVar, i iVar2) {
            super(iVar);
            this.f4918a = iVar2;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f4918a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f4918a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f4918a.onNext(t10);
        }
    }

    public static <T> i<T> a() {
        return b(aq.a.a());
    }

    public static <T> i<T> b(d<? super T> dVar) {
        return new a(dVar);
    }

    public static <T> i<T> c(i<? super T> iVar) {
        return new b(iVar, iVar);
    }
}
