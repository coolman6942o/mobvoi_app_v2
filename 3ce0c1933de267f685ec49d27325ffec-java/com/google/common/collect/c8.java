package com.google.common.collect;

import java.util.Map;
import java.util.Set;
/* compiled from: Table.java */
/* loaded from: classes.dex */
public interface c8<R, C, V> {

    /* compiled from: Table.java */
    /* loaded from: classes.dex */
    public interface a<R, C, V> {
        C a();

        R b();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    V get(Object obj, Object obj2);

    V put(R r10, C c10, V v10);

    Map<C, V> row(R r10);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();
}
