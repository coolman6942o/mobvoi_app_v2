package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.f;
import qo.p;
/* compiled from: SafeCollector.kt */
/* loaded from: classes3.dex */
public final class c implements f.b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f30178c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f30179a;

    /* renamed from: b  reason: collision with root package name */
    private final f.c<?> f30180b = f30178c;

    /* compiled from: SafeCollector.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f.c<c> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public c(Throwable th2) {
        this.f30179a = th2;
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
        return this.f30180b;
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
