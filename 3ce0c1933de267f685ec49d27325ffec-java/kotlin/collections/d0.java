package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes3.dex */
public class d0 extends c0 {
    public static <K, V> Map<K, V> e() {
        w wVar = w.INSTANCE;
        Objects.requireNonNull(wVar, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return wVar;
    }

    public static <K, V> V f(Map<K, ? extends V> getValue, K k10) {
        i.f(getValue, "$this$getValue");
        return (V) b0.a(getValue, k10);
    }

    public static <K, V> HashMap<K, V> g(Pair<? extends K, ? extends V>... pairs) {
        i.f(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(a0.b(pairs.length));
        k(hashMap, pairs);
        return hashMap;
    }

    public static <K, V> Map<K, V> h(Pair<? extends K, ? extends V>... pairs) {
        i.f(pairs, "pairs");
        return pairs.length > 0 ? o(pairs, new LinkedHashMap(a0.b(pairs.length))) : a0.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> i(Map<K, ? extends V> optimizeReadOnlyMap) {
        i.f(optimizeReadOnlyMap, "$this$optimizeReadOnlyMap");
        int size = optimizeReadOnlyMap.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlyMap : c0.d(optimizeReadOnlyMap);
        }
        return a0.e();
    }

    public static final <K, V> void j(Map<? super K, ? super V> putAll, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        i.f(putAll, "$this$putAll");
        i.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            putAll.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V> void k(Map<? super K, ? super V> putAll, Pair<? extends K, ? extends V>[] pairs) {
        i.f(putAll, "$this$putAll");
        i.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            putAll.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static <K, V> Map<K, V> l(Iterable<? extends Pair<? extends K, ? extends V>> toMap) {
        i.f(toMap, "$this$toMap");
        if (!(toMap instanceof Collection)) {
            return i(m(toMap, new LinkedHashMap()));
        }
        Collection collection = (Collection) toMap;
        int size = collection.size();
        if (size == 0) {
            return a0.e();
        }
        if (size != 1) {
            return m(toMap, new LinkedHashMap(a0.b(collection.size())));
        }
        return c0.c(toMap instanceof List ? (Pair<? extends K, ? extends V>) ((List) toMap).get(0) : toMap.iterator().next());
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M m(Iterable<? extends Pair<? extends K, ? extends V>> toMap, M destination) {
        i.f(toMap, "$this$toMap");
        i.f(destination, "destination");
        j(destination, toMap);
        return destination;
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> toMap) {
        i.f(toMap, "$this$toMap");
        int size = toMap.size();
        if (size == 0) {
            return a0.e();
        }
        if (size != 1) {
            return a0.p(toMap);
        }
        return c0.d(toMap);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M o(Pair<? extends K, ? extends V>[] toMap, M destination) {
        i.f(toMap, "$this$toMap");
        i.f(destination, "destination");
        k(destination, toMap);
        return destination;
    }

    public static <K, V> Map<K, V> p(Map<? extends K, ? extends V> toMutableMap) {
        i.f(toMutableMap, "$this$toMutableMap");
        return new LinkedHashMap(toMutableMap);
    }
}
