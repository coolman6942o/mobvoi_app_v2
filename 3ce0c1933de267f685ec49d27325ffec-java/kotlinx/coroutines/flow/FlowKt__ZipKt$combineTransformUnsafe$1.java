package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.internal.CombineKt;
import qo.a;
import qo.p;
import qo.q;
/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1 extends SuspendLambda implements p<c<Object>, c<? super m>, Object> {
    final /* synthetic */ b<T>[] $flows;
    final /* synthetic */ q<c<Object>, T[], c<? super m>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", l = {273}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements q<c<Object>, T[], c<? super m>, Object> {
        final /* synthetic */ q<c<Object>, T[], c<? super m>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super c<Object>, ? super T[], ? super c<? super m>, ? extends Object> qVar, c<? super AnonymousClass1> cVar) {
            super(3, cVar);
            this.$transform = qVar;
        }

        public final Object invoke(c<Object> cVar, T[] tArr, c<? super m> cVar2) {
            AnonymousClass1 r02 = new AnonymousClass1(this.$transform, cVar2);
            r02.L$0 = cVar;
            r02.L$1 = tArr;
            return r02.invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                h.b(obj);
                q<c<Object>, T[], c<? super m>, Object> qVar = this.$transform;
                this.L$0 = null;
                this.label = 1;
                if (qVar.invoke((c) this.L$0, (Object[]) this.L$1, this) == d10) {
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
            this.$transform.invoke((c) this.L$0, (Object[]) this.L$1, this);
            return m.f28349a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(b<? extends T>[] bVarArr, q<? super c<Object>, ? super T[], ? super c<? super m>, ? extends Object> qVar, c<? super FlowKt__ZipKt$combineTransformUnsafe$1> cVar) {
        super(2, cVar);
        this.$flows = bVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, cVar);
        flowKt__ZipKt$combineTransformUnsafe$1.L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    public final Object invoke(c<Object> cVar, c<? super m> cVar2) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(cVar, cVar2)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        a b10;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            b<T>[] bVarArr = this.$flows;
            b10 = f1.b();
            i.j();
            AnonymousClass1 r42 = new AnonymousClass1(this.$transform, null);
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

    public final Object invokeSuspend$$forInline(Object obj) {
        a b10;
        b<T>[] bVarArr = this.$flows;
        b10 = f1.b();
        i.j();
        AnonymousClass1 r22 = new AnonymousClass1(this.$transform, null);
        kotlin.jvm.internal.h.c(0);
        CombineKt.a((c) this.L$0, bVarArr, b10, r22, this);
        kotlin.jvm.internal.h.c(1);
        return m.f28349a;
    }
}
