package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1", f = "Limit.kt", l = {144, 145}, m = "emit")
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-9$$inlined$collectWhile$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f0 this$0;

    public FlowKt__LimitKt$takeWhile$lambda9$$inlined$collectWhile$1$1(f0 f0Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
