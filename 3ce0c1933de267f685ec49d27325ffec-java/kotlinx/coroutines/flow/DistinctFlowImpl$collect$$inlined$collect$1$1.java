package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1", f = "Distinct.kt", l = {139}, m = "emit")
/* loaded from: classes3.dex */
public final class DistinctFlowImpl$collect$$inlined$collect$1$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public DistinctFlowImpl$collect$$inlined$collect$1$1(a aVar, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
