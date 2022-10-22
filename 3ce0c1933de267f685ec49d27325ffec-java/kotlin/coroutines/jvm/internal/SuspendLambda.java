package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class SuspendLambda extends ContinuationImpl implements g<Object> {
    private final int arity;

    public SuspendLambda(int i10, c<Object> cVar) {
        super(cVar);
        this.arity = i10;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String j10 = l.j(this);
        i.e(j10, "Reflection.renderLambdaToString(this)");
        return j10;
    }

    public SuspendLambda(int i10) {
        this(i10, null);
    }
}
