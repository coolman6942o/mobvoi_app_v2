package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes3.dex */
public class n extends m {
    public static <T> int p(Iterable<? extends T> collectionSizeOrDefault, int i10) {
        i.f(collectionSizeOrDefault, "$this$collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection) collectionSizeOrDefault).size() : i10;
    }
}
