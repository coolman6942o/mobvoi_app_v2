package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public final class EmptyCoroutineContext implements f, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> operation) {
        i.f(operation, "operation");
        return r10;
    }

    @Override // kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        i.f(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        i.f(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        i.f(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
