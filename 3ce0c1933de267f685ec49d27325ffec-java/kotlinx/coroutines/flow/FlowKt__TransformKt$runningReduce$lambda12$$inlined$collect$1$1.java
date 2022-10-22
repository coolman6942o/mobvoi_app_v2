package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$lambda-12$$inlined$collect$1", f = "Transform.kt", l = {138, 140}, m = "emit")
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$lambda-12$$inlined$collect$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__TransformKt$runningReduce$lambda12$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b1 this$0;

    public FlowKt__TransformKt$runningReduce$lambda12$$inlined$collect$1$1(b1 b1Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
