package rx.internal.operators;

import rx.c;
import rx.i;
import yp.f;
/* compiled from: OnSubscribeCollect.java */
/* loaded from: classes3.dex */
public final class e<T, R> implements c.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f33753a;

    /* renamed from: b  reason: collision with root package name */
    final f<R> f33754b;

    /* renamed from: c  reason: collision with root package name */
    final yp.c<R, ? super T> f33755c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCollect.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends c<T, R> {

        /* renamed from: f  reason: collision with root package name */
        final yp.c<R, ? super T> f33756f;

        public a(i<? super R> iVar, R r10, yp.c<R, ? super T> cVar) {
            super(iVar);
            this.f33727c = r10;
            this.f33726b = true;
            this.f33756f = cVar;
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33737e) {
                try {
                    this.f33756f.a(this.f33727c, t10);
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    unsubscribe();
                    onError(th2);
                }
            }
        }
    }

    public e(c<T> cVar, f<R> fVar, yp.c<R, ? super T> cVar2) {
        this.f33753a = cVar;
        this.f33754b = fVar;
        this.f33755c = cVar2;
    }

    /* renamed from: a */
    public void call(i<? super R> iVar) {
        try {
            new a(iVar, this.f33754b.call(), this.f33755c).f(this.f33753a);
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            iVar.onError(th2);
        }
    }
}
