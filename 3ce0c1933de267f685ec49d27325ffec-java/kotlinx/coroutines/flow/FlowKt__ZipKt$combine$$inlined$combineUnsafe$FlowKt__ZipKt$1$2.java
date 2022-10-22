package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import qo.q;
import qo.r;
/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {333, 333}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 extends SuspendLambda implements q<c<Object>, Object[], c<? super m>, Object> {
    final /* synthetic */ r $transform$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(c cVar, r rVar) {
        super(3, cVar);
        this.$transform$inlined = rVar;
    }

    public final Object invoke(c<Object> cVar, Object[] objArr, c<? super m> cVar2) {
        FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 = new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2(cVar2, this.$transform$inlined);
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.L$0 = cVar;
        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.L$1 = objArr;
        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2.invokeSuspend(m.f28349a);
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
            Object[] objArr = (Object[]) this.L$1;
            r rVar = this.$transform$inlined;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Object obj4 = objArr[2];
            this.L$0 = cVar;
            this.label = 1;
            kotlin.jvm.internal.h.c(6);
            obj = rVar.invoke(obj2, obj3, obj4, this);
            kotlin.jvm.internal.h.c(7);
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
}
