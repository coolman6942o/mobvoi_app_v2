package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes3.dex */
public class c0 extends b0 {
    public static int b(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> c(Pair<? extends K, ? extends V> pair) {
        i.f(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        i.e(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> d(Map<? extends K, ? extends V> toSingletonMap) {
        i.f(toSingletonMap, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = toSingletonMap.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        i.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
