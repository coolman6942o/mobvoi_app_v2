package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f = "Merge.kt", l = {136}, m = "emit")
/* loaded from: classes3.dex */
public final class ChannelFlowMerge$collectTo$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public ChannelFlowMerge$collectTo$$inlined$collect$1$1(a aVar, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
