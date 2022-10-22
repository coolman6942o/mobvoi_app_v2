package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes3.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {

    /* renamed from: a  reason: collision with root package name */
    private final f.c<?> f30062a;

    /* renamed from: b  reason: collision with root package name */
    private final l<f.b, E> f30063b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [qo.l<kotlin.coroutines.f$b, E extends B>, qo.l<? super kotlin.coroutines.f$b, ? extends E extends B>, java.lang.Object] */
    public b(f.c<B> baseKey, l<? super f.b, ? extends E> safeCast) {
        i.f(baseKey, "baseKey");
        i.f(safeCast, "safeCast");
        this.f30063b = safeCast;
        this.f30062a = baseKey instanceof b ? (f.c<B>) ((b) baseKey).f30062a : baseKey;
    }

    public final boolean a(f.c<?> key) {
        i.f(key, "key");
        return key == this || this.f30062a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/f$b;)TE; */
    public final f.b b(f.b element) {
        i.f(element, "element");
        return (f.b) this.f30063b.invoke(element);
    }
}
