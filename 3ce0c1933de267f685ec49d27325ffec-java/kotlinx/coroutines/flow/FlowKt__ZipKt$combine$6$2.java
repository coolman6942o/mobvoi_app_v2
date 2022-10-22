package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import qo.p;
import qo.q;
/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", l = {292, 292}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$6$2 extends SuspendLambda implements q<c<Object>, T[], c<? super m>, Object> {
    final /* synthetic */ p<T[], c<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(p<? super T[], ? super c<Object>, ? extends Object> pVar, c<? super FlowKt__ZipKt$combine$6$2> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    public final Object invoke(c<Object> cVar, T[] tArr, c<? super m> cVar2) {
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, cVar2);
        flowKt__ZipKt$combine$6$2.L$0 = cVar;
        flowKt__ZipKt$combine$6$2.L$1 = tArr;
        return flowKt__ZipKt$combine$6$2.invokeSuspend(m.f28349a);
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
            p<T[], c<Object>, Object> pVar = this.$transform;
            this.L$0 = cVar;
            this.label = 1;
            obj = pVar.invoke((Object[]) this.L$1, this);
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
        if (cVar.emit(obj, this) == d10) {
            return d10;
        }
        return m.f28349a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        kotlin.jvm.internal.h.c(0);
        ((c) this.L$0).emit(invoke, this);
        kotlin.jvm.internal.h.c(1);
        return m.f28349a;
    }
}
