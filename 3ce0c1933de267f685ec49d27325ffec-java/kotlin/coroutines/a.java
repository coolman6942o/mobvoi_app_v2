package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class a implements f.b {
    private final f.c<?> key;

    public a(f.c<?> key) {
        i.f(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> operation) {
        i.f(operation, "operation");
        return (R) f.b.a.a(this, r10, operation);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        i.f(key, "key");
        return (E) f.b.a.b(this, key);
    }

    @Override // kotlin.coroutines.f.b
    public f.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        i.f(key, "key");
        return f.b.a.c(this, key);
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        i.f(context, "context");
        return f.b.a.d(this, context);
    }
}
