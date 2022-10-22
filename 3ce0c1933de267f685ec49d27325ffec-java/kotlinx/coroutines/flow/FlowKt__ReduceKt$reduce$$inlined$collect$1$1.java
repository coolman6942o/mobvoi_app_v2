package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$$inlined$collect$1", f = "Reduce.kt", l = {137}, m = "emit")
/* loaded from: classes3.dex */
public final class FlowKt__ReduceKt$reduce$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m0 this$0;

    public FlowKt__ReduceKt$reduce$$inlined$collect$1$1(m0 m0Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
