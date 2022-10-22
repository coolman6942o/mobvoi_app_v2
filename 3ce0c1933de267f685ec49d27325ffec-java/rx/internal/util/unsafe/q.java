package rx.internal.util.unsafe;
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
abstract class q<E> extends o<E> {

    /* renamed from: h  reason: collision with root package name */
    private volatile long f34173h;

    public q(int i10) {
        super(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long l() {
        return this.f34173h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(long j10) {
        this.f34173h = j10;
    }
}
