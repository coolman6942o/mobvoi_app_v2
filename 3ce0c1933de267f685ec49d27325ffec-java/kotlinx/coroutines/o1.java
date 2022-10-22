package kotlinx.coroutines;

import kotlin.jvm.internal.i;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public abstract class o1 extends c0 implements u0, e1 {

    /* renamed from: d  reason: collision with root package name */
    public p1 f30263d;

    @Override // kotlinx.coroutines.e1
    public boolean c() {
        return true;
    }

    @Override // kotlinx.coroutines.e1
    public t1 d() {
        return null;
    }

    @Override // kotlinx.coroutines.u0
    public void dispose() {
        x().g0(this);
    }

    @Override // kotlinx.coroutines.internal.l
    public String toString() {
        return o0.a(this) + '@' + o0.b(this) + "[job@" + o0.b(x()) + ']';
    }

    public final p1 x() {
        p1 p1Var = this.f30263d;
        if (p1Var != null) {
            return p1Var;
        }
        i.u("job");
        throw null;
    }

    public final void y(p1 p1Var) {
        this.f30263d = p1Var;
    }
}
