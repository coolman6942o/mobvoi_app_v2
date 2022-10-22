package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.internal.CombineKt;
import qo.a;
import qo.p;
import qo.q;
import qo.t;
/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4", f = "Zip.kt", l = {273}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4 extends SuspendLambda implements p<c<Object>, c<? super m>, Object> {
    final /* synthetic */ b[] $flows;
    final /* synthetic */ t $transform$inlined;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1", f = "Zip.kt", l = {333}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements q<c<Object>, Object[], c<? super m>, Object> {
        final /* synthetic */ t $transform$inlined;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(c cVar, t tVar) {
            super(3, cVar);
            this.$transform$inlined = tVar;
        }

        public final Object invoke(c<Object> cVar, Object[] objArr, c<? super m> cVar2) {
            AnonymousClass1 r02 = new AnonymousClass1(cVar2, this.$transform$inlined);
            r02.L$0 = cVar;
            r02.L$1 = objArr;
            return r02.invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                h.b(obj);
                c cVar = (c) this.L$0;
                Object[] objArr = (Object[]) this.L$1;
                t tVar = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                this.label = 1;
                kotlin.jvm.internal.h.c(6);
                Object invoke = tVar.invoke(cVar, obj2, obj3, obj4, obj5, this);
                kotlin.jvm.internal.h.c(7);
                if (invoke == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                h.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return m.f28349a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(b[] bVarArr, c cVar, t tVar) {
        super(2, cVar);
        this.$flows = bVarArr;
        this.$transform$inlined = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4 flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4(this.$flows, cVar, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4.L$0 = obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4;
    }

    public final Object invoke(c<Object> cVar, c<? super m> cVar2) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4) create(cVar, cVar2)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        a b10;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            b[] bVarArr = this.$flows;
            b10 = f1.b();
            AnonymousClass1 r42 = new AnonymousClass1(null, this.$transform$inlined);
            this.label = 1;
            if (CombineKt.a((c) this.L$0, bVarArr, b10, r42, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            h.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return m.f28349a;
    }
}
