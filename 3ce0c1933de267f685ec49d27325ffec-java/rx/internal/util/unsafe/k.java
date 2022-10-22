package rx.internal.util.unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
public abstract class k<E> extends m<E> {

    /* renamed from: g  reason: collision with root package name */
    protected static final long f34171g = f0.a(k.class, "consumerIndex");
    private volatile long consumerIndex;

    public k(int i10) {
        super(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean j(long j10, long j11) {
        return f0.f34169a.compareAndSwapLong(this, f34171g, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long k() {
        return this.consumerIndex;
    }
}
