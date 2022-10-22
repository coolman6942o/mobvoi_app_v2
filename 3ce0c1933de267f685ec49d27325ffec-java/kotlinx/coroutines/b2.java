package kotlinx.coroutines;

import kotlin.coroutines.f;
/* compiled from: Unconfined.kt */
/* loaded from: classes3.dex */
public final class b2 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    public static final b2 f30123b = new b2();

    private b2() {
    }

    @Override // kotlinx.coroutines.g0
    public void Q(f fVar, Runnable runnable) {
        e2 e2Var = (e2) fVar.get(e2.f30167b);
        if (e2Var != null) {
            e2Var.f30168a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.g0
    public boolean V(f fVar) {
        return false;
    }

    @Override // kotlinx.coroutines.g0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
