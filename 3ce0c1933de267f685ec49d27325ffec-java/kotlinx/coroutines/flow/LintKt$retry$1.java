package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import qo.p;
/* compiled from: Lint.kt */
@d(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LintKt$retry$1 extends SuspendLambda implements p<Throwable, c<? super Boolean>, Object> {
    int label;

    public LintKt$retry$1(c<? super LintKt$retry$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        return new LintKt$retry$1(cVar);
    }

    public final Object invoke(Throwable th2, c<? super Boolean> cVar) {
        return ((LintKt$retry$1) create(th2, cVar)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.d();
        if (this.label == 0) {
            h.b(obj);
            return a.a(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
