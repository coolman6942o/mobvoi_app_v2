package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", l = {114, 116}, m = "collect")
/* loaded from: classes3.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ z0 this$0;

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1(z0 z0Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
