package com.google.common.base;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Absent.java */
/* loaded from: classes.dex */
public final class a<T> extends Optional<T> {
    static final a<Object> INSTANCE = new a<>();
    private static final long serialVersionUID = 0;

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Optional<T> a() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T t10) {
        return (T) p.p(t10, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(h<? super T, V> hVar) {
        p.o(hVar);
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        return (Optional) p.o(optional);
    }

    @Override // com.google.common.base.Optional
    public T or(v<? extends T> vVar) {
        return (T) p.p(vVar.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }
}
