package com.google.common.hash;
/* compiled from: AbstractHasher.java */
/* loaded from: classes.dex */
abstract class b implements j {
    @Override // com.google.common.hash.j
    public <T> j a(T t10, Funnel<? super T> funnel) {
        funnel.funnel(t10, this);
        return this;
    }
}
