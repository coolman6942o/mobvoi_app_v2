package com.google.common.collect;

import com.google.common.base.h;
import java.util.Comparator;
import java.util.Map;
/* compiled from: Ordering.java */
/* loaded from: classes.dex */
public abstract class q6<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public static <T> q6<T> a(Comparator<T> comparator) {
        if (comparator instanceof q6) {
            return (q6) comparator;
        }
        return new z2(comparator);
    }

    public static <C extends Comparable> q6<C> g() {
        return o6.INSTANCE;
    }

    public <E extends T> ImmutableList<E> b(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E c(E e10, E e11) {
        return compare(e10, e11) >= 0 ? e10 : e11;
    }

    @Override // java.util.Comparator
    public abstract int compare(T t10, T t11);

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E d(E e10, E e11) {
        return compare(e10, e11) <= 0 ? e10 : e11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T2 extends T> q6<Map.Entry<T2, ?>> h() {
        return (q6<Map.Entry<T2, ?>>) i(w5.g());
    }

    public <F> q6<F> i(h<F, ? extends T> hVar) {
        return new f0(hVar, this);
    }

    public <S extends T> q6<S> j() {
        return new j7(this);
    }
}
