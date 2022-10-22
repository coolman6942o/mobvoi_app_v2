package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class d1 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    private final t1 f30165a;

    public d1(t1 t1Var) {
        this.f30165a = t1Var;
    }

    @Override // kotlinx.coroutines.e1
    public boolean c() {
        return false;
    }

    @Override // kotlinx.coroutines.e1
    public t1 d() {
        return this.f30165a;
    }

    public String toString() {
        return n0.c() ? d().w("New") : super.toString();
    }
}
