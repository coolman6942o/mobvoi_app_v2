package rx.internal.util.unsafe;
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
abstract class p<E> extends l<E> {

    /* renamed from: f  reason: collision with root package name */
    protected static final long f34172f = f0.a(p.class, "producerIndex");
    private volatile long producerIndex;

    public p(int i10) {
        super(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long h() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(long j10) {
        f0.f34169a.putOrderedLong(this, f34172f, j10);
    }
}
