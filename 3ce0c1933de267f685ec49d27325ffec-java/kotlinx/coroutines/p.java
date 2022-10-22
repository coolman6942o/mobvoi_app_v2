package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.l;
/* compiled from: CancellableContinuation.kt */
/* loaded from: classes3.dex */
public final class p {
    public static final <T> n<T> a(c<? super T> cVar) {
        if (!(cVar instanceof e)) {
            return new n<>(cVar, 1);
        }
        n<T> m10 = ((e) cVar).m();
        m10 = null;
        if (m10 == null || !m10.F()) {
        }
        return m10 == null ? new n<>(cVar, 2) : m10;
    }

    public static final void b(m<?> mVar, l lVar) {
        mVar.j(new x1(lVar));
    }
}
