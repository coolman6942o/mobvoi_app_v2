package com.google.common.collect;

import java.lang.Comparable;
/* compiled from: AbstractRangeSet.java */
/* loaded from: classes.dex */
abstract class r<C extends Comparable> implements w6<C> {
    @Override // com.google.common.collect.w6
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(w6<C> w6Var) {
        addAll(w6Var.asRanges());
    }

    @Override // com.google.common.collect.w6
    public /* synthetic */ void addAll(Iterable iterable) {
        v6.a(this, iterable);
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c10) {
        return rangeContaining(c10) != null;
    }

    @Override // com.google.common.collect.w6
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(w6<C> w6Var) {
        return enclosesAll(w6Var.asRanges());
    }

    @Override // com.google.common.collect.w6
    public /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return v6.b(this, iterable);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w6) {
            return asRanges().equals(((w6) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.common.collect.w6
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c10);

    @Override // com.google.common.collect.w6
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.w6
    public void removeAll(w6<C> w6Var) {
        removeAll(w6Var.asRanges());
    }

    @Override // com.google.common.collect.w6
    public /* synthetic */ void removeAll(Iterable iterable) {
        v6.c(this, iterable);
    }

    public final String toString() {
        return asRanges().toString();
    }
}
