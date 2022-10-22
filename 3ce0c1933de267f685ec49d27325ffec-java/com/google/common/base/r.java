package com.google.common.base;

import java.util.function.Predicate;
/* compiled from: Predicate.java */
@FunctionalInterface
/* loaded from: classes.dex */
public interface r<T> extends Predicate<T> {
    boolean apply(T t10);

    boolean equals(Object obj);

    @Override // java.util.function.Predicate
    boolean test(T t10);
}
