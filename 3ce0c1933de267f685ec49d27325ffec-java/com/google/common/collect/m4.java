package com.google.common.collect;

import com.google.common.base.p;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* compiled from: ImmutableMapValues.java */
/* loaded from: classes.dex */
final class m4<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmutableMapValues.java */
    /* loaded from: classes.dex */
    public class a extends p8<V> {

        /* renamed from: a  reason: collision with root package name */
        final p8<Map.Entry<K, V>> f12119a;

        a() {
            this.f12119a = m4.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12119a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f12119a.next().getValue();
        }
    }

    /* compiled from: ImmutableMapValues.java */
    /* loaded from: classes.dex */
    class b extends z3<V> {
        final /* synthetic */ ImmutableList val$entryList;

        b(ImmutableList immutableList) {
            this.val$entryList = immutableList;
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) ((Map.Entry) this.val$entryList.get(i10)).getValue();
        }

        @Override // com.google.common.collect.z3
        ImmutableCollection<V> l() {
            return m4.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        return new b(this.map.entrySet().asList());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && j5.f(iterator(), obj);
    }

    @Override // java.lang.Iterable
    public void forEach(final Consumer<? super V> consumer) {
        p.o(consumer);
        this.map.forEach(new BiConsumer() { // from class: com.google.common.collect.k4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                consumer.accept(obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<V> spliterator() {
        return s2.e(this.map.entrySet().spliterator(), l4.f12095a);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<V> iterator() {
        return new a();
    }
}
