package com.google.common.collect;

import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Spliterator;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableEnumSet.java */
/* loaded from: classes.dex */
public final class d4<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> delegate;
    private transient int hashCode;

    private d4(EnumSet<E> enumSet) {
        this.delegate = enumSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableSet r(EnumSet enumSet) {
        int size = enumSet.size();
        if (size == 0) {
            return ImmutableSet.of();
        }
        if (size != 1) {
            return new d4(enumSet);
        }
        return ImmutableSet.of(h5.h(enumSet));
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof d4) {
            collection = ((d4) collection).delegate;
        }
        return this.delegate.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d4) {
            obj = ((d4) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.delegate.forEach(consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.delegate.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean o() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return this.delegate.spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return j5.z(this.delegate.iterator());
    }
}
