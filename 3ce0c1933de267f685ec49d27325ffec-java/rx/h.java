package rx;

import rx.internal.util.i;
/* compiled from: SingleSubscriber.java */
/* loaded from: classes3.dex */
public abstract class h<T> implements j {

    /* renamed from: a  reason: collision with root package name */
    private final i f33709a = new i();

    public final void a(j jVar) {
        this.f33709a.a(jVar);
    }

    public abstract void b(Throwable th2);

    public abstract void c(T t10);

    @Override // rx.j
    public final boolean isUnsubscribed() {
        return this.f33709a.isUnsubscribed();
    }

    @Override // rx.j
    public final void unsubscribe() {
        this.f33709a.unsubscribe();
    }
}
