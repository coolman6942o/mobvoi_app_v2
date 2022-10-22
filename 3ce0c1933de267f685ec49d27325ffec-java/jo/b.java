package jo;

import java.util.Comparator;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Comparisons.kt */
/* loaded from: classes3.dex */
public class b {
    public static <T extends Comparable<?>> int a(T t10, T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    public static <T extends Comparable<? super T>> Comparator<T> b() {
        e eVar = e.f29652a;
        Objects.requireNonNull(eVar, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return eVar;
    }
}
