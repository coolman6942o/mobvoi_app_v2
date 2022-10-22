package kotlinx.coroutines.flow.internal;

import io.h;
import io.m;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.x;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.l0;
import qo.a;
import qo.p;
import qo.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {57, 79, 82}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements p<l0, c<? super m>, Object> {
    final /* synthetic */ a<T[]> $arrayFactory;
    final /* synthetic */ b<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.c<R> $this_combineInternal;
    final /* synthetic */ q<kotlinx.coroutines.flow.c<? super R>, T[], c<? super m>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {147}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<l0, c<? super m>, Object> {
        final /* synthetic */ b<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ e<x<Object>> $resultChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(b<? extends T>[] bVarArr, int i10, AtomicInteger atomicInteger, e<x<Object>> eVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$flows = bVarArr;
            this.$i = i10;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<m> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, cVar);
        }

        public final Object invoke(l0 l0Var, c<? super m> cVar) {
            return ((AnonymousClass1) create(l0Var, cVar)).invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            AtomicInteger atomicInteger;
            d10 = kotlin.coroutines.intrinsics.b.d();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    h.b(obj);
                    b[] bVarArr = this.$flows;
                    int i11 = this.$i;
                    b bVar = bVarArr[i11];
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this.$resultChannel, i11);
                    this.label = 1;
                    if (bVar.a(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == d10) {
                        return d10;
                    }
                } else if (i10 == 1) {
                    h.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    p.a.a(this.$resultChannel, null, 1, null);
                }
                return m.f28349a;
            } finally {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    p.a.a(this.$resultChannel, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(b<? extends T>[] bVarArr, a<T[]> aVar, q<? super kotlinx.coroutines.flow.c<? super R>, ? super T[], ? super c<? super m>, ? extends Object> qVar, kotlinx.coroutines.flow.c<? super R> cVar, c<? super CombineKt$combineInternal$2> cVar2) {
        super(2, cVar2);
        this.$flows = bVarArr;
        this.$arrayFactory = aVar;
        this.$transform = qVar;
        this.$this_combineInternal = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<m> create(Object obj, c<?> cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, cVar);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(l0 l0Var, c<? super m> cVar) {
        return ((CombineKt$combineInternal$2) create(l0Var, cVar)).invokeSuspend(m.f28349a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1 A[LOOP:1: B:31:0x00f1->B:37:0x0115, LOOP_START, PHI: r3 r10 
      PHI: (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:28:0x00ec, B:37:0x0115] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.x) = (r10v2 kotlin.collections.x), (r10v16 kotlin.collections.x) binds: [B:28:0x00ec, B:37:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v10, types: [kotlinx.coroutines.flow.b<T>[], kotlinx.coroutines.flow.b[]] */
    /* JADX WARN: Type inference failed for: r7v6, types: [kotlinx.coroutines.flow.b<T>[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x013a -> B:23:0x00cc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x016f -> B:48:0x016b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object d10;
        Object[] objArr;
        int i10;
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        e eVar;
        byte b10;
        byte[] bArr;
        Object[] objArr2;
        Object obj2;
        CombineKt$combineInternal$2 combineKt$combineInternal$22;
        e eVar2;
        byte b11;
        int i11;
        x xVar;
        Object[] objArr3;
        d10 = kotlin.coroutines.intrinsics.b.d();
        int i12 = this.label;
        int i13 = 2;
        if (i12 == 0) {
            h.b(obj);
            l0 l0Var = (l0) this.L$0;
            i10 = this.$flows.length;
            if (i10 == 0) {
                return m.f28349a;
            }
            objArr = new Object[i10];
            kotlin.collections.h.j(objArr, g.f30183a, 0, 0, 6, null);
            e b12 = f.b(i10, null, null, 6, null);
            AtomicInteger atomicInteger = new AtomicInteger(i10);
            if (i10 > 0) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    atomicInteger = atomicInteger;
                    kotlinx.coroutines.h.b(l0Var, null, null, new AnonymousClass1(this.$flows, i14, atomicInteger, b12, null), 3, null);
                    if (i15 >= i10) {
                        break;
                    }
                    i14 = i15;
                }
            }
            bArr = new byte[i10];
            combineKt$combineInternal$2 = this;
            eVar = b12;
            b10 = 0;
        } else if (i12 == 1) {
            ?? r22 = this.I$1;
            i11 = this.I$0;
            bArr = (byte[]) this.L$2;
            eVar2 = (e) this.L$1;
            objArr2 = (Object[]) this.L$0;
            h.b(obj);
            obj2 = ((g) obj).h();
            combineKt$combineInternal$22 = this;
            b11 = r22;
            xVar = (x) g.e(obj2);
            if (xVar != null) {
                return m.f28349a;
            }
            do {
                int a10 = xVar.a();
                Object obj3 = objArr2[a10];
                objArr2[a10] = xVar.b();
                if (obj3 == g.f30183a) {
                    i11--;
                }
                if (bArr[a10] == b11) {
                    break;
                }
                bArr[a10] = b11;
                xVar = (x) g.e(eVar2.a());
            } while (xVar != null);
            if (i11 != 0) {
                objArr3 = objArr2;
            } else {
                Object[] objArr4 = (Object[]) combineKt$combineInternal$22.$arrayFactory.invoke();
                if (objArr4 == null) {
                    q qVar = combineKt$combineInternal$22.$transform;
                    Object obj4 = combineKt$combineInternal$22.$this_combineInternal;
                    combineKt$combineInternal$22.L$0 = objArr2;
                    combineKt$combineInternal$22.L$1 = eVar2;
                    combineKt$combineInternal$22.L$2 = bArr;
                    combineKt$combineInternal$22.I$0 = i11;
                    combineKt$combineInternal$22.I$1 = b11;
                    combineKt$combineInternal$22.label = i13;
                    if (qVar.invoke(obj4, objArr2, combineKt$combineInternal$22) == d10) {
                        return d10;
                    }
                    i10 = i11;
                    b10 = b11;
                    eVar = eVar2;
                    combineKt$combineInternal$2 = combineKt$combineInternal$22;
                    objArr = objArr2;
                } else {
                    objArr3 = objArr2;
                    kotlin.collections.h.f(objArr2, objArr4, 0, 0, 0, 14, null);
                    q qVar2 = combineKt$combineInternal$22.$transform;
                    Object obj5 = combineKt$combineInternal$22.$this_combineInternal;
                    combineKt$combineInternal$22.L$0 = objArr3;
                    combineKt$combineInternal$22.L$1 = eVar2;
                    combineKt$combineInternal$22.L$2 = bArr;
                    combineKt$combineInternal$22.I$0 = i11;
                    combineKt$combineInternal$22.I$1 = b11;
                    combineKt$combineInternal$22.label = 3;
                    if (qVar2.invoke(obj5, objArr4, combineKt$combineInternal$22) == d10) {
                        return d10;
                    }
                }
            }
            i10 = i11;
            objArr = objArr3;
            b10 = b11;
            eVar = eVar2;
            combineKt$combineInternal$2 = combineKt$combineInternal$22;
            i13 = 2;
        } else if (i12 == 2) {
            ?? r23 = this.I$1;
            int i16 = this.I$0;
            bArr = (byte[]) this.L$2;
            eVar = (e) this.L$1;
            objArr = (Object[]) this.L$0;
            h.b(obj);
            i10 = i16;
            b10 = r23;
            combineKt$combineInternal$2 = this;
        } else if (i12 == 3) {
            ?? r24 = this.I$1;
            int i17 = this.I$0;
            bArr = (byte[]) this.L$2;
            eVar = (e) this.L$1;
            objArr = (Object[]) this.L$0;
            h.b(obj);
            i10 = i17;
            b10 = r24;
            combineKt$combineInternal$2 = this;
            i13 = 2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        byte b13 = (byte) (b10 + 1);
        combineKt$combineInternal$2.L$0 = objArr;
        combineKt$combineInternal$2.L$1 = eVar;
        combineKt$combineInternal$2.L$2 = bArr;
        combineKt$combineInternal$2.I$0 = i10;
        combineKt$combineInternal$2.I$1 = b13;
        combineKt$combineInternal$2.label = 1;
        obj2 = eVar.b(combineKt$combineInternal$2);
        if (obj2 == d10) {
            return d10;
        }
        combineKt$combineInternal$22 = combineKt$combineInternal$2;
        objArr2 = objArr;
        eVar2 = eVar;
        b11 = b13;
        i11 = i10;
        xVar = (x) g.e(obj2);
        if (xVar != null) {
        }
    }
}
