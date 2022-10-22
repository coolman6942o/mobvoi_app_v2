package dq;

import java.util.concurrent.atomic.AtomicReference;
import rx.j;
/* compiled from: BooleanSubscription.java */
/* loaded from: classes3.dex */
public final class a implements j {

    /* renamed from: b  reason: collision with root package name */
    static final yp.a f25691b = new C0277a();

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<yp.a> f25692a;

    /* compiled from: BooleanSubscription.java */
    /* renamed from: dq.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0277a implements yp.a {
        C0277a() {
        }

        @Override // yp.a
        public void call() {
        }
    }

    public a() {
        this.f25692a = new AtomicReference<>();
    }

    public static a a() {
        return new a();
    }

    public static a b(yp.a aVar) {
        return new a(aVar);
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f25692a.get() == f25691b;
    }

    @Override // rx.j
    public void unsubscribe() {
        yp.a andSet;
        yp.a aVar = this.f25692a.get();
        yp.a aVar2 = f25691b;
        if (aVar != aVar2 && (andSet = this.f25692a.getAndSet(aVar2)) != null && andSet != aVar2) {
            andSet.call();
        }
    }

    private a(yp.a aVar) {
        this.f25692a = new AtomicReference<>(aVar);
    }
}
