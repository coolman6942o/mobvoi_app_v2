package kotlin.jvm.internal;

import java.io.Serializable;
/* compiled from: Lambda.kt */
/* loaded from: classes3.dex */
public abstract class Lambda<R> implements g<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String k10 = l.k(this);
        i.e(k10, "Reflection.renderLambdaToString(this)");
        return k10;
    }
}
