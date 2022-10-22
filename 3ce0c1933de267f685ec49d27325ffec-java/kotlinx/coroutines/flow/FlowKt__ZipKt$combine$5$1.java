package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: Zip.kt */
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$5$1 extends Lambda implements a<T[]> {
    final /* synthetic */ b<T>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(b<? extends T>[] bVarArr) {
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
