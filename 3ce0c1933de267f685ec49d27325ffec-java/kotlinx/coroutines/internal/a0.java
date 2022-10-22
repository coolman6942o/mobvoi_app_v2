package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.z1;
import qo.p;
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static final w f30198a = new w("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final p<Object, f.b, Object> f30199b = a.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    private static final p<z1<?>, f.b, z1<?>> f30200c = b.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    private static final p<d0, f.b, d0> f30201d = c.INSTANCE;

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements p<Object, f.b, Object> {
        public static final a INSTANCE = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Object invoke(Object obj, f.b bVar) {
            if (!(bVar instanceof z1)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements p<z1<?>, f.b, z1<?>> {
        public static final b INSTANCE = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final z1<?> invoke(z1<?> z1Var, f.b bVar) {
            if (z1Var != null) {
                return z1Var;
            }
            if (bVar instanceof z1) {
                return (z1) bVar;
            }
            return null;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements p<d0, f.b, d0> {
        public static final c INSTANCE = new c();

        c() {
            super(2);
        }

        /* renamed from: a */
        public final d0 invoke(d0 d0Var, f.b bVar) {
            if (bVar instanceof z1) {
                z1<?> z1Var = (z1) bVar;
                d0Var.a(z1Var, z1Var.I(d0Var.f30206a));
            }
            return d0Var;
        }
    }

    public static final void a(f fVar, Object obj) {
        if (obj != f30198a) {
            if (obj instanceof d0) {
                ((d0) obj).b(fVar);
                return;
            }
            Object fold = fVar.fold(null, f30200c);
            Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((z1) fold).v(fVar, obj);
        }
    }

    public static final Object b(f fVar) {
        Object fold = fVar.fold(0, f30199b);
        i.d(fold);
        return fold;
    }

    public static final Object c(f fVar, Object obj) {
        if (obj == null) {
            obj = b(fVar);
        }
        if (obj == 0) {
            return f30198a;
        }
        if (obj instanceof Integer) {
            return fVar.fold(new d0(fVar, ((Number) obj).intValue()), f30201d);
        }
        return ((z1) obj).I(fVar);
    }
}
