package kotlinx.coroutines;

import io.m;
import kotlinx.coroutines.internal.l;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
final class x1 extends e {

    /* renamed from: a  reason: collision with root package name */
    private final l f30354a;

    public x1(l lVar) {
        this.f30354a = lVar;
    }

    @Override // kotlinx.coroutines.l
    public void a(Throwable th2) {
        this.f30354a.s();
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        a(th2);
        return m.f28349a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.f30354a + ']';
    }
}
