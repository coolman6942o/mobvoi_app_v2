package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: Zip.kt */
/* loaded from: classes3.dex */
public final class FlowKt__ZipKt$combine$6$1 extends Lambda implements a<T[]> {
    final /* synthetic */ b<T>[] $flowArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(b<T>[] bVarArr) {
        super(0);
        this.$flowArray = bVarArr;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
    @Override // qo.a
    public final T[] invoke() {
        int length = this.$flowArray.length;
        i.k(0, "T?");
        return new Object[length];
    }
}
