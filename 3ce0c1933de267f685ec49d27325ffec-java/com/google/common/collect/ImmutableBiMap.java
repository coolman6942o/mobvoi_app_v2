package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableBiMap<K, V> extends a4<K, V> implements e0<K, V> {

    /* loaded from: classes.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        /* renamed from: h */
        public ImmutableBiMap<K, V> a() {
            int i10 = this.f11768c;
            if (i10 == 0) {
                return ImmutableBiMap.of();
            }
            if (i10 == 1) {
                return ImmutableBiMap.of((Object) this.f11767b[0].getKey(), (Object) this.f11767b[0].getValue());
            }
            if (this.f11766a != null) {
                if (this.f11769d) {
                    this.f11767b = (Map.Entry[]) Arrays.copyOf(this.f11767b, i10);
                }
                Arrays.sort(this.f11767b, 0, this.f11768c, q6.a(this.f11766a).i(w5.u()));
            }
            this.f11769d = true;
            return z6.u(this.f11768c, this.f11767b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public a<K, V> b(ImmutableMap.b<K, V> bVar) {
            super.b(bVar);
            return this;
        }

        /* renamed from: j */
        public a<K, V> d(K k10, V v10) {
            super.d(k10, v10);
            return this;
        }

        /* renamed from: k */
        public a<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            super.e(entry);
            return this;
        }

        /* renamed from: l */
        public a<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.f(iterable);
            return this;
        }

        /* renamed from: m */
        public a<K, V> g(Map<? extends K, ? extends V> map) {
            super.g(map);
            return this;
        }

        a(int i10) {
            super(i10);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i10) {
        p2.b(i10, "expectedSize");
        return new a<>(i10);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.l()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return z6.EMPTY;
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return o2.N(function, function2);
    }

    @Deprecated
    public final V forcePut(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableBiMap<V, K> inverse();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public final ImmutableSet<V> i() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10) {
        return new m7(k10, v10);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11) {
        return z6.t(ImmutableMap.j(k10, v10), ImmutableMap.j(k11, v11));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        return z6.t(ImmutableMap.j(k10, v10), ImmutableMap.j(k11, v11), ImmutableMap.j(k12, v12));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) h5.l(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return z6.t(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        return z6.t(ImmutableMap.j(k10, v10), ImmutableMap.j(k11, v11), ImmutableMap.j(k12, v12), ImmutableMap.j(k13, v13));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return z6.t(ImmutableMap.j(k10, v10), ImmutableMap.j(k11, v11), ImmutableMap.j(k12, v12), ImmutableMap.j(k13, v13), ImmutableMap.j(k14, v14));
    }
}
