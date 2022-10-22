package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.j1;
import qo.p;
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes3.dex */
public final class i {

    /* compiled from: SafeCollector.common.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements p<Integer, f.b, Integer> {
        final /* synthetic */ SafeCollector<?> $this_checkContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SafeCollector<?> safeCollector) {
            super(2);
            this.$this_checkContext = safeCollector;
        }

        public final int a(int i10, f.b bVar) {
            f.c<?> key = bVar.getKey();
            f.b bVar2 = this.$this_checkContext.collectContext.get(key);
            if (key == j1.f30248g0) {
                j1 j1Var = (j1) bVar2;
                j1 b10 = i.b((j1) bVar, j1Var);
                if (b10 == j1Var) {
                    return j1Var == null ? i10 : i10 + 1;
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b10 + ", expected child of " + j1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            } else if (bVar != bVar2) {
                return Integer.MIN_VALUE;
            } else {
                return i10 + 1;
            }
        }

        @Override // qo.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, f.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    public static final void a(SafeCollector<?> safeCollector, f fVar) {
        if (((Number) fVar.fold(0, new a(safeCollector))).intValue() != safeCollector.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + fVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final j1 b(j1 j1Var, j1 j1Var2) {
        while (j1Var != null) {
            if (j1Var == j1Var2 || !(j1Var instanceof u)) {
                return j1Var;
            }
            j1Var = ((u) j1Var).w0();
        }
        return null;
    }
}
