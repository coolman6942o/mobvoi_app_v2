package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes3.dex */
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ j this$0;

    public SafeCollector_commonKt$unsafeFlow$1$collect$1(j jVar, c<? super SafeCollector_commonKt$unsafeFlow$1$collect$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
