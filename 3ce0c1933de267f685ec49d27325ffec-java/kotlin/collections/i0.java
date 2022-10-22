package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sets.kt */
/* loaded from: classes3.dex */
public class i0 extends h0 {
    public static <T> Set<T> b() {
        return EmptySet.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> optimizeReadOnlySet) {
        i.f(optimizeReadOnlySet, "$this$optimizeReadOnlySet");
        int size = optimizeReadOnlySet.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlySet : h0.a(optimizeReadOnlySet.iterator().next());
        }
        return g0.b();
    }
}
