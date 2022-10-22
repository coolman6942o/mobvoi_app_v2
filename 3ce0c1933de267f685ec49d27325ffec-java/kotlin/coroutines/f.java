package kotlin.coroutines;

import kotlin.coroutines.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0372a extends Lambda implements p<f, b, f> {
            public static final C0372a INSTANCE = new C0372a();

            C0372a() {
                super(2);
            }

            /* renamed from: a */
            public final f invoke(f acc, b element) {
                CombinedContext combinedContext;
                i.f(acc, "acc");
                i.f(element, "element");
                f minusKey = acc.minusKey(element.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (minusKey == emptyCoroutineContext) {
                    return element;
                }
                d.b bVar = d.f30064e0;
                d dVar = (d) minusKey.get(bVar);
                if (dVar == null) {
                    combinedContext = new CombinedContext(minusKey, element);
                } else {
                    f minusKey2 = minusKey.minusKey(bVar);
                    if (minusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(element, dVar);
                    }
                    combinedContext = new CombinedContext(new CombinedContext(minusKey2, element), dVar);
                }
                return combinedContext;
            }
        }

        public static f a(f fVar, f context) {
            i.f(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? fVar : (f) context.fold(fVar, C0372a.INSTANCE);
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface b extends f {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            public static <R> R a(b bVar, R r10, p<? super R, ? super b, ? extends R> operation) {
                i.f(operation, "operation");
                return operation.invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                i.f(key, "key");
                if (i.b(bVar.getKey(), key)) {
                    return bVar;
                }
                return null;
            }

            public static f c(b bVar, c<?> key) {
                i.f(key, "key");
                return i.b(bVar.getKey(), key) ? EmptyCoroutineContext.INSTANCE : bVar;
            }

            public static f d(b bVar, f context) {
                i.f(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // kotlin.coroutines.f
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes3.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r10, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);

    f plus(f fVar);
}
