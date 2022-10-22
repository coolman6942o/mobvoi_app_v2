package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1", f = "Limit.kt", l = {136, 137, 139}, m = "emit")
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$lambda-4$$inlined$collect$1$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c0 this$0;

    public FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1$1(c0 c0Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
