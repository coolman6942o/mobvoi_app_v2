package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
@d(c = "kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1", f = "SharingStarted.kt", l = {137}, m = "emit")
/* loaded from: classes3.dex */
public final class StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g1 this$0;

    public StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1(g1 g1Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
