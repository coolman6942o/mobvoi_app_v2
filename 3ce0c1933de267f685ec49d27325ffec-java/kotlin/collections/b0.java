package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.i;
/* compiled from: MapWithDefault.kt */
/* loaded from: classes3.dex */
class b0 {
    public static final <K, V> V a(Map<K, ? extends V> getOrImplicitDefault, K k10) {
        i.f(getOrImplicitDefault, "$this$getOrImplicitDefault");
        if (getOrImplicitDefault instanceof z) {
            return (V) ((z) getOrImplicitDefault).c(k10);
        }
        V v10 = getOrImplicitDefault.get(k10);
        if (v10 != null || getOrImplicitDefault.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }
}
