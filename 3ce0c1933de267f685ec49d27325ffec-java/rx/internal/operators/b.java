package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.c;
import rx.e;
import rx.i;
/* compiled from: DeferredScalarSubscriber.java */
/* loaded from: classes3.dex */
public abstract class b<T, R> extends i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final i<? super R> f33725a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f33726b;

    /* renamed from: c  reason: collision with root package name */
    protected R f33727c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicInteger f33728d = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeferredScalarSubscriber.java */
    /* loaded from: classes3.dex */
    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final b<?, ?> f33729a;

        public a(b<?, ?> bVar) {
            this.f33729a = bVar;
        }

        @Override // rx.e
        public void request(long j10) {
            this.f33729a.d(j10);
        }
    }

    public b(i<? super R> iVar) {
        this.f33725a = iVar;
    }

    protected final void b() {
        this.f33725a.onCompleted();
    }

    protected final void c(R r10) {
        i<? super R> iVar = this.f33725a;
        do {
            int i10 = this.f33728d.get();
            if (i10 != 2 && i10 != 3 && !iVar.isUnsubscribed()) {
                if (i10 == 1) {
                    iVar.onNext(r10);
                    if (!iVar.isUnsubscribed()) {
                        iVar.onCompleted();
                    }
                    this.f33728d.lazySet(3);
                    return;
                }
                this.f33727c = r10;
            } else {
                return;
            }
        } while (!this.f33728d.compareAndSet(0, 2));
    }

    final void d(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j10);
        } else if (i10 != 0) {
            i<? super R> iVar = this.f33725a;
            do {
                int i11 = this.f33728d.get();
                if (i11 != 1 && i11 != 3 && !iVar.isUnsubscribed()) {
                    if (i11 == 2) {
                        if (this.f33728d.compareAndSet(2, 3)) {
                            iVar.onNext((R) this.f33727c);
                            if (!iVar.isUnsubscribed()) {
                                iVar.onCompleted();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f33728d.compareAndSet(0, 1));
        }
    }

    final void e() {
        i<? super R> iVar = this.f33725a;
        iVar.add(this);
        iVar.setProducer(new a(this));
    }

    public final void f(c<? extends T> cVar) {
        e();
        cVar.j0(this);
    }

    @Override // rx.d
    public void onCompleted() {
        if (this.f33726b) {
            c(this.f33727c);
        } else {
            b();
        }
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f33727c = null;
        this.f33725a.onError(th2);
    }

    @Override // rx.i
    public final void setProducer(e eVar) {
        eVar.request(Long.MAX_VALUE);
    }
}
