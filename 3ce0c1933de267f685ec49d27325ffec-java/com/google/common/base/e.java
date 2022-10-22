package com.google.common.base;
/* compiled from: Converter.java */
/* loaded from: classes.dex */
public abstract class e<A, B> implements h<A, B> {
    private final boolean handleNullAutomatically;
    private transient e<B, A> reverse;

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        this(true);
    }

    public final B a(A a10) {
        return b(a10);
    }

    @Override // com.google.common.base.h, java.util.function.Function
    @Deprecated
    public final B apply(A a10) {
        return a(a10);
    }

    B b(A a10) {
        if (!this.handleNullAutomatically) {
            return c(a10);
        }
        if (a10 == null) {
            return null;
        }
        return (B) p.o(c(a10));
    }

    protected abstract B c(A a10);

    @Override // com.google.common.base.h
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    e(boolean z10) {
        this.handleNullAutomatically = z10;
    }
}
