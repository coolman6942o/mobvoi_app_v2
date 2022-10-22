package kotlinx.coroutines.flow;

import io.h;
import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.flow.internal.CombineKt;
import qo.a;
import qo.p;
import qo.q;
/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", l = {251}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combineTransform$6 extends SuspendLambda implements p<c<Object>, c<? super m>, Object> {
    final /* synthetic */ b<T>[] $flows;
    final /* synthetic */ q<c<Object>, T[], c<? super m>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: Zip.kt */
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements a<T[]> {
        final /* synthetic */ b<T>[] $flows;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(b<? extends T>[] bVarArr) {
            super(0);
            this.$flows = bVarArr;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
        @Override // qo.a
        public final T[] invoke() {
            int length = this.$flows.length;
            i.k(0, "T?");
            return new Object[length];
        }
    }

    /* compiled from: Zip.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", l = {251}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements q<c<Object>, T[], c<? super m>, Object> {
        final /* synthetic */ q<c<Object>, T[], c<? super m>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(q<? super c<Object>, ? super T[], ? super c<? super m>, ? extends Object> qVar, c<? super AnonymousClass2> cVar) {
            super(3, cVar);
            this.$transform = qVar;
        }

        public final Object invoke(c<Object> cVar, T[] tArr, c<? super m> cVar2) {
            AnonymousClass2 r02 = new AnonymousClass2(this.$transform, cVar2);
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
    public FlowKt__ZipKt$combineTransform$6(b<? extends T>[] bVarArr, q<? super c<Object>, ? super T[], ? super c<? super m>, ? extends Object> qVar, c<? super FlowKt__ZipKt$combineTransform$6> cVar) {
        super(2, cVar);
        this.$flows = bVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.$flows, this.$transform, cVar);
        flowKt__ZipKt$combineTransform$6.L$0 = obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    public final Object invoke(c<Object> cVar, c<? super m> cVar2) {
        return ((FlowKt__ZipKt$combineTransform$6) create(cVar, cVar2)).invokeSuspend(m.f28349a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d10;
        d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            h.b(obj);
            b<T>[] bVarArr = this.$flows;
            i.j();
            AnonymousClass1 r32 = new AnonymousClass1(this.$flows);
            i.j();
            AnonymousClass2 r42 = new AnonymousClass2(this.$transform, null);
            this.label = 1;
            if (CombineKt.a((c) this.L$0, bVarArr, r32, r42, this) == d10) {
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
        b<T>[] bVarArr = this.$flows;
        i.j();
        AnonymousClass1 r12 = new AnonymousClass1(this.$flows);
        i.j();
        AnonymousClass2 r22 = new AnonymousClass2(this.$transform, null);
        kotlin.jvm.internal.h.c(0);
        CombineKt.a((c) this.L$0, bVarArr, r12, r22, this);
        kotlin.jvm.internal.h.c(1);
        return m.f28349a;
    }
}
