package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import qo.p;
import qo.q;
/* compiled from: Emitters.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", l = {223}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements p<c<Object>, c<? super m>, Object> {
    final /* synthetic */ b<Object> $this_transform;
    final /* synthetic */ q<c<Object>, Object, c<? super m>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(b<Object> bVar, q<? super c<Object>, Object, ? super c<? super m>, ? extends Object> qVar, c<? super FlowKt__EmittersKt$transform$1> cVar) {
        super(2, cVar);
        this.$this_transform = bVar;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, cVar);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    public final Object invoke(c<Object> cVar, c<? super m> cVar2) {
        return ((FlowKt__EmittersKt$transform$1) create(cVar, cVar2)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            b<Object> bVar = this.$this_transform;
            FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this.$transform, (c) this.L$0);
            this.label = 1;
            if (bVar.a(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            h.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return m.f28349a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        b<Object> bVar = this.$this_transform;
        FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this.$transform, (c) this.L$0);
        kotlin.jvm.internal.h.c(0);
        bVar.a(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this);
        kotlin.jvm.internal.h.c(1);
        return m.f28349a;
    }
}
