package kotlinx.coroutines;
/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public final class g extends x0 {

    /* renamed from: g  reason: collision with root package name */
    private final Thread f30185g;

    public g(Thread thread) {
        this.f30185g = thread;
    }

    @Override // kotlinx.coroutines.y0
    protected Thread z0() {
        return this.f30185g;
    }
}
