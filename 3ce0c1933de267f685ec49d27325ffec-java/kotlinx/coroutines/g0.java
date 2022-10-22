package kotlinx.coroutines;

import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.e;
import qo.l;
/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public abstract class g0 extends kotlin.coroutines.a implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30186a = new a(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes3.dex */
    public static final class a extends b<d, g0> {

        /* compiled from: CoroutineDispatcher.kt */
        /* renamed from: kotlinx.coroutines.g0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0376a extends Lambda implements l<f.b, g0> {
            public static final C0376a INSTANCE = new C0376a();

            C0376a() {
                super(1);
            }

            /* renamed from: a */
            public final g0 invoke(f.b bVar) {
                if (bVar instanceof g0) {
                    return (g0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(d.f30064e0, C0376a.INSTANCE);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public g0() {
        super(d.f30064e0);
    }

    public abstract void Q(f fVar, Runnable runnable);

    public void T(f fVar, Runnable runnable) {
        Q(fVar, runnable);
    }

    public boolean V(f fVar) {
        return true;
    }

    @Override // kotlin.coroutines.d
    public final void d(c<?> cVar) {
        ((e) cVar).r();
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) d.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public final <T> c<T> h(c<? super T> cVar) {
        return new e(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.f
    public f minusKey(f.c<?> cVar) {
        return d.a.b(this, cVar);
    }

    public String toString() {
        return o0.a(this) + '@' + o0.b(this);
    }
}
