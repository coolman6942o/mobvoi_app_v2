package com.google.common.collect;

import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.collect.u7;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
/* compiled from: DescendingMultiset.java */
/* loaded from: classes.dex */
abstract class g3<E> extends q3<E> implements t7<E> {

    /* renamed from: a  reason: collision with root package name */
    private transient Comparator<? super E> f11990a;

    /* renamed from: b  reason: collision with root package name */
    private transient NavigableSet<E> f11991b;

    /* renamed from: c  reason: collision with root package name */
    private transient Set<j6.a<E>> f11992c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescendingMultiset.java */
    /* loaded from: classes.dex */
    public class a extends m6.d<E> {
        a() {
        }

        @Override // com.google.common.collect.m6.d
        j6<E> e() {
            return g3.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<j6.a<E>> iterator() {
            return g3.this.n();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g3.this.o().entrySet().size();
        }
    }

    @Override // com.google.common.collect.t7, com.google.common.collect.q7
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f11990a;
        if (comparator != null) {
            return comparator;
        }
        q6 j10 = q6.a(o().comparator()).j();
        this.f11990a = j10;
        return j10;
    }

    @Override // com.google.common.collect.t7
    public t7<E> descendingMultiset() {
        return o();
    }

    @Override // com.google.common.collect.j6
    public Set<j6.a<E>> entrySet() {
        Set<j6.a<E>> set = this.f11992c;
        if (set != null) {
            return set;
        }
        Set<j6.a<E>> m10 = m();
        this.f11992c = m10;
        return m10;
    }

    @Override // com.google.common.collect.t7
    public j6.a<E> firstEntry() {
        return o().lastEntry();
    }

    @Override // com.google.common.collect.t7
    public t7<E> headMultiset(E e10, BoundType boundType) {
        return o().tailMultiset(e10, boundType).descendingMultiset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.q3
    /* renamed from: l */
    public j6<E> b() {
        return o();
    }

    @Override // com.google.common.collect.t7
    public j6.a<E> lastEntry() {
        return o().firstEntry();
    }

    Set<j6.a<E>> m() {
        return new a();
    }

    abstract Iterator<j6.a<E>> n();

    abstract t7<E> o();

    @Override // com.google.common.collect.t7
    public j6.a<E> pollFirstEntry() {
        return o().pollLastEntry();
    }

    @Override // com.google.common.collect.t7
    public j6.a<E> pollLastEntry() {
        return o().pollFirstEntry();
    }

    @Override // com.google.common.collect.t7
    public t7<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2) {
        return o().subMultiset(e11, boundType2, e10, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.t7
    public t7<E> tailMultiset(E e10, BoundType boundType) {
        return o().headMultiset(e10, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return i();
    }

    @Override // com.google.common.collect.r3
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.j6
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f11991b;
        if (navigableSet != null) {
            return navigableSet;
        }
        u7.b bVar = new u7.b(this);
        this.f11991b = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) j(tArr);
    }
}
