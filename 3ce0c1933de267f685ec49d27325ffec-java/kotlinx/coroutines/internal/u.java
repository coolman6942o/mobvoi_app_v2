package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.a;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.s;
/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public class u<T> extends a<T> implements c {

    /* renamed from: c  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f30242c;

    /* JADX WARN: Multi-variable type inference failed */
    public u(f fVar, kotlin.coroutines.c<? super T> cVar) {
        super(fVar, true, true);
        this.f30242c = cVar;
    }

    @Override // kotlinx.coroutines.p1
    protected final boolean T() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public final c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f30242c;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.p1
    public void n(Object obj) {
        kotlin.coroutines.c c10;
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f30242c);
        f.c(c10, d0.a(obj, this.f30242c), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    protected void s0(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f30242c;
        cVar.resumeWith(d0.a(obj, cVar));
    }

    public final j1 w0() {
        s M = M();
        if (M == null) {
            return null;
        }
        return M.getParent();
    }
}
