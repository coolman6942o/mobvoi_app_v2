package kotlinx.coroutines.flow;

import io.m;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qo.q;
/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements c<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f30173a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f30174b;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(q qVar, c cVar) {
        this.f30173a = qVar;
        this.f30174b = cVar;
    }

    @Override // kotlinx.coroutines.flow.c
    public Object emit(Object obj, c<? super m> cVar) {
        Object d10;
        Object invoke = this.f30173a.invoke(this.f30174b, obj, cVar);
        d10 = b.d();
        return invoke == d10 ? invoke : m.f28349a;
    }
}
