package kotlin.coroutines.intrinsics;

import io.h;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qo.l;
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {
    final /* synthetic */ l $block;
    final /* synthetic */ c $completion;
    final /* synthetic */ f $context;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(l lVar, c cVar, f fVar, c cVar2, f fVar2) {
        super(cVar2, fVar2);
        this.$block = lVar;
        this.$completion = cVar;
        this.$context = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) {
        int i10 = this.label;
        if (i10 == 0) {
            this.label = 1;
            h.b(obj);
            return this.$block.invoke(this);
        } else if (i10 == 1) {
            this.label = 2;
            h.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
