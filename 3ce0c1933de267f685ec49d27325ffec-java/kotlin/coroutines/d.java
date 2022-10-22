package kotlin.coroutines;

import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes3.dex */
public interface d extends f.b {

    /* renamed from: e0  reason: collision with root package name */
    public static final b f30064e0 = b.f30065a;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static <E extends f.b> E a(d dVar, f.c<E> key) {
            i.f(key, "key");
            if (key instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                E e10 = (E) bVar.b(dVar);
                if (!(e10 instanceof f.b)) {
                    return null;
                }
                return e10;
            } else if (d.f30064e0 != key) {
                return null;
            } else {
                Objects.requireNonNull(dVar, "null cannot be cast to non-null type E");
                return dVar;
            }
        }

        public static f b(d dVar, f.c<?> key) {
            i.f(key, "key");
            if (!(key instanceof kotlin.coroutines.b)) {
                return d.f30064e0 == key ? EmptyCoroutineContext.INSTANCE : dVar;
            }
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
            return (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) ? dVar : EmptyCoroutineContext.INSTANCE;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class b implements f.c<d> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f30065a = new b();

        private b() {
        }
    }

    void d(c<?> cVar);

    <T> c<T> h(c<? super T> cVar);
}
