package kotlin.collections;

import jo.b;
import kotlin.jvm.internal.Lambda;
import qo.l;
/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements l<Object, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ l $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [int, java.lang.Integer] */
    @Override // qo.l
    public final Integer invoke(Object obj) {
        ?? a10;
        a10 = b.a((Comparable) this.$selector.invoke(obj), this.$key);
        return a10;
    }
}
