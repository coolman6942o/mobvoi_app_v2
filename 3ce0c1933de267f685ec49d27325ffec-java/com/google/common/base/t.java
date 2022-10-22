package com.google.common.base;

import java.util.Collections;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Present.java */
/* loaded from: classes.dex */
public final class t<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(T t10) {
        this.reference = t10;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof t) {
            return this.reference.equals(((t) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T t10) {
        p.p(t10, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        String valueOf = String.valueOf(this.reference);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
        sb2.append("Optional.of(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(h<? super T, V> hVar) {
        return new t(p.p(hVar.apply((T) this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        p.o(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(v<? extends T> vVar) {
        p.o(vVar);
        return this.reference;
    }
}
