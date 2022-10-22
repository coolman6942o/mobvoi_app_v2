package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import qo.p;
import qo.q;
/* compiled from: Merge.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", l = {193, 193}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements q<c<Object>, Object, c<? super m>, Object> {
    final /* synthetic */ p<Object, c<? super b<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(p<Object, ? super c<? super b<Object>>, ? extends Object> pVar, c<? super FlowKt__MergeKt$flatMapLatest$1> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    public final Object invoke(c<Object> cVar, Object obj, c<? super m> cVar2) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, cVar2);
        flowKt__MergeKt$flatMapLatest$1.L$0 = cVar;
        flowKt__MergeKt$flatMapLatest$1.L$1 = obj;
        return flowKt__MergeKt$flatMapLatest$1.invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        c cVar;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            cVar = (c) this.L$0;
            Object obj2 = this.L$1;
            p<Object, c<? super b<Object>>, Object> pVar = this.$transform;
            this.L$0 = cVar;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            cVar = (c) this.L$0;
            h.b(obj);
        } else if (i10 == 2) {
            h.b(obj);
            return m.f28349a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.label = 2;
        if (d.a(cVar, (b) obj, this) == d10) {
            return d10;
        }
        return m.f28349a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object obj2 = this.L$1;
        kotlin.jvm.internal.h.c(0);
        d.a((c) this.L$0, (b) this.$transform.invoke(obj2, this), this);
        kotlin.jvm.internal.h.c(1);
        return m.f28349a;
    }
}
