package n5;

import androidx.collection.a;
import androidx.collection.f;
/* compiled from: CachedHashCodeArrayMap.java */
/* loaded from: classes.dex */
public final class b<K, V> extends a<K, V> {

    /* renamed from: i  reason: collision with root package name */
    private int f31028i;

    @Override // androidx.collection.f, java.util.Map
    public void clear() {
        this.f31028i = 0;
        super.clear();
    }

    @Override // androidx.collection.f, java.util.Map
    public int hashCode() {
        if (this.f31028i == 0) {
            this.f31028i = super.hashCode();
        }
        return this.f31028i;
    }

    @Override // androidx.collection.f
    public void k(f<? extends K, ? extends V> fVar) {
        this.f31028i = 0;
        super.k(fVar);
    }

    @Override // androidx.collection.f
    public V l(int i10) {
        this.f31028i = 0;
        return (V) super.l(i10);
    }

    @Override // androidx.collection.f
    public V m(int i10, V v10) {
        this.f31028i = 0;
        return (V) super.m(i10, v10);
    }

    @Override // androidx.collection.f, java.util.Map
    public V put(K k10, V v10) {
        this.f31028i = 0;
        return (V) super.put(k10, v10);
    }
}
