package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.collect.u7;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractSortedMultiset.java */
/* loaded from: classes.dex */
public abstract class v<E> extends p<E> implements t7<E> {
    final Comparator<? super E> comparator;
    private transient t7<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractSortedMultiset.java */
    /* loaded from: classes.dex */
    public class a extends g3<E> {
        a() {
        }

        @Override // com.google.common.collect.m3, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return v.this.descendingIterator();
        }

        @Override // com.google.common.collect.g3
        Iterator<j6.a<E>> n() {
            return v.this.i();
        }

        @Override // com.google.common.collect.g3
        t7<E> o() {
            return v.this;
        }
    }

    v() {
        this(q6.g());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    Iterator<E> descendingIterator() {
        return m6.i(descendingMultiset());
    }

    public t7<E> descendingMultiset() {
        t7<E> t7Var = this.descendingMultiset;
        if (t7Var != null) {
            return t7Var;
        }
        t7<E> g10 = g();
        this.descendingMultiset = g10;
        return g10;
    }

    public j6.a<E> firstEntry() {
        Iterator<j6.a<E>> d10 = d();
        if (d10.hasNext()) {
            return d10.next();
        }
        return null;
    }

    t7<E> g() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public NavigableSet<E> a() {
        return new u7.b(this);
    }

    abstract Iterator<j6.a<E>> i();

    public j6.a<E> lastEntry() {
        Iterator<j6.a<E>> i10 = i();
        if (i10.hasNext()) {
            return i10.next();
        }
        return null;
    }

    public j6.a<E> pollFirstEntry() {
        Iterator<j6.a<E>> d10 = d();
        if (!d10.hasNext()) {
            return null;
        }
        j6.a<E> next = d10.next();
        j6.a<E> g10 = m6.g(next.a(), next.getCount());
        d10.remove();
        return g10;
    }

    public j6.a<E> pollLastEntry() {
        Iterator<j6.a<E>> i10 = i();
        if (!i10.hasNext()) {
            return null;
        }
        j6.a<E> next = i10.next();
        j6.a<E> g10 = m6.g(next.a(), next.getCount());
        i10.remove();
        return g10;
    }

    public t7<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2) {
        p.o(boundType);
        p.o(boundType2);
        return tailMultiset(e10, boundType).headMultiset(e11, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Comparator<? super E> comparator) {
        this.comparator = (Comparator) p.o(comparator);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
