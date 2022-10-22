package rx.subjects;

import rx.c;
import rx.i;
/* compiled from: SerializedSubject.java */
/* loaded from: classes3.dex */
public class c<T, R> extends d<T, R> {

    /* renamed from: b  reason: collision with root package name */
    private final aq.c<T> f34187b;

    /* renamed from: c  reason: collision with root package name */
    private final d<T, R> f34188c;

    /* compiled from: SerializedSubject.java */
    /* loaded from: classes3.dex */
    class a implements c.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f34189a;

        a(d dVar) {
            this.f34189a = dVar;
        }

        /* renamed from: a */
        public void call(i<? super R> iVar) {
            this.f34189a.j0(iVar);
        }
    }

    public c(d<T, R> dVar) {
        super(new a(dVar));
        this.f34188c = dVar;
        this.f34187b = new aq.c<>(dVar);
    }

    @Override // rx.subjects.d
    public boolean m0() {
        return this.f34188c.m0();
    }

    @Override // rx.d
    public void onCompleted() {
        this.f34187b.onCompleted();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f34187b.onError(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f34187b.onNext(t10);
    }
}
