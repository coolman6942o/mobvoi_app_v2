package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class l1 extends p1 implements y {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30252b = s0();

    public l1(j1 j1Var) {
        super(true);
        R(j1Var);
    }

    private final boolean s0() {
        s M = M();
        t tVar = M instanceof t ? (t) M : null;
        if (tVar == null) {
            return false;
        }
        p1 x10 = tVar.x();
        while (!x10.J()) {
            s M2 = x10.M();
            t tVar2 = M2 instanceof t ? (t) M2 : null;
            if (tVar2 == null) {
                return false;
            }
            x10 = tVar2.x();
        }
        return true;
    }

    @Override // kotlinx.coroutines.p1
    public boolean J() {
        return this.f30252b;
    }

    @Override // kotlinx.coroutines.p1
    public boolean K() {
        return true;
    }
}
