package kotlinx.coroutines;
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final class u1 implements u0, s {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f30338a = new u1();

    private u1() {
    }

    @Override // kotlinx.coroutines.s
    public boolean b(Throwable th2) {
        return false;
    }

    @Override // kotlinx.coroutines.u0
    public void dispose() {
    }

    @Override // kotlinx.coroutines.s
    public j1 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
