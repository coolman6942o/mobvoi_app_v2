package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__CollectKt$collectIndexed$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ p this$0;

    public FlowKt__CollectKt$collectIndexed$2$emit$1(p pVar, c<? super FlowKt__CollectKt$collectIndexed$2$emit$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
