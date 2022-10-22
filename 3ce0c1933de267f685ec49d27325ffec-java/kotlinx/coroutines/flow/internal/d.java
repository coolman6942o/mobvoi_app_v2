package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlinx.coroutines.internal.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowCoroutine.kt */
/* loaded from: classes3.dex */
public final class d<T> extends u<T> {
    public d(f fVar, c<? super T> cVar) {
        super(fVar, cVar);
    }

    @Override // kotlinx.coroutines.p1
    public boolean z(Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return r(th2);
    }
}
