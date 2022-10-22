package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes3.dex */
public class q extends p {
    public static <T extends Comparable<? super T>> void q(List<T> sort) {
        i.f(sort, "$this$sort");
        if (sort.size() > 1) {
            Collections.sort(sort);
        }
    }

    public static <T> void r(List<T> sortWith, Comparator<? super T> comparator) {
        i.f(sortWith, "$this$sortWith");
        i.f(comparator, "comparator");
        if (sortWith.size() > 1) {
            Collections.sort(sortWith, comparator);
        }
    }
}
