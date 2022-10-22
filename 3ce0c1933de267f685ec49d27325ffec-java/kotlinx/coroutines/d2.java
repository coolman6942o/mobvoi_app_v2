package kotlinx.coroutines;

import kotlin.coroutines.f;
import qo.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class d2 implements f.b, f.c<d2> {

    /* renamed from: a  reason: collision with root package name */
    public static final d2 f30166a = new d2();

    private d2() {
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r10, p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) f.b.a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) f.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.f.b
    public f.c<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> cVar) {
        return f.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.f
    public f plus(f fVar) {
        return f.b.a.d(this, fVar);
    }
}
