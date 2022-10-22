package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {

    /* renamed from: h  reason: collision with root package name */
    e<K, V> f1439h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMap.java */
    /* renamed from: androidx.collection.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0009a extends e<K, V> {
        C0009a() {
        }

        @Override // androidx.collection.e
        protected void a() {
            a.this.clear();
        }

        @Override // androidx.collection.e
        protected Object b(int i10, int i11) {
            return a.this.f1480b[(i10 << 1) + i11];
        }

        @Override // androidx.collection.e
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // androidx.collection.e
        protected int d() {
            return a.this.f1481c;
        }

        @Override // androidx.collection.e
        protected int e(Object obj) {
            return a.this.g(obj);
        }

        @Override // androidx.collection.e
        protected int f(Object obj) {
            return a.this.i(obj);
        }

        @Override // androidx.collection.e
        protected void g(K k10, V v10) {
            a.this.put(k10, v10);
        }

        @Override // androidx.collection.e
        protected void h(int i10) {
            a.this.l(i10);
        }

        @Override // androidx.collection.e
        protected V i(int i10, V v10) {
            return a.this.m(i10, v10);
        }
    }

    public a() {
    }

    private e<K, V> o() {
        if (this.f1439h == null) {
            this.f1439h = new C0009a();
        }
        return this.f1439h;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return o().m();
    }

    public boolean p(Collection<?> collection) {
        return e.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        d(this.f1481c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return o().n();
    }

    public a(int i10) {
        super(i10);
    }

    public a(f fVar) {
        super(fVar);
    }
}
