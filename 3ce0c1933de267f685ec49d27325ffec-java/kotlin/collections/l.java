package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes3.dex */
public class l {
    public static final <T> Object[] a(T[] copyToArrayOfAny, boolean z10) {
        i.f(copyToArrayOfAny, "$this$copyToArrayOfAny");
        if (z10 && i.b(copyToArrayOfAny.getClass(), Object[].class)) {
            return copyToArrayOfAny;
        }
        Object[] copyOf = Arrays.copyOf(copyToArrayOfAny, copyToArrayOfAny.length, Object[].class);
        i.e(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t10) {
        List<T> singletonList = Collections.singletonList(t10);
        i.e(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
