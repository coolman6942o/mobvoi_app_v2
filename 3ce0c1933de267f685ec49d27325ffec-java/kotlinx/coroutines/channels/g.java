package kotlinx.coroutines.channels;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class g<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f30154b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private static final c f30155c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f30156a;

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f30157a;

        public a(Throwable th2) {
            this.f30157a = th2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && i.b(this.f30157a, ((a) obj).f30157a);
        }

        public int hashCode() {
            Throwable th2 = this.f30157a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.g.c
        public String toString() {
            return "Closed(" + this.f30157a + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final <E> Object a(Throwable th2) {
            return g.c(new a(th2));
        }

        public final <E> Object b() {
            return g.c(g.f30155c);
        }

        public final <E> Object c(E e10) {
            return g.c(e10);
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ g(Object obj) {
        this.f30156a = obj;
    }

    public static final /* synthetic */ g b(Object obj) {
        return new g(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof g) && i.b(obj, ((g) obj2).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T e(Object obj) {
        if (!(obj instanceof c)) {
            return obj;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String g(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(h(), obj);
    }

    public final /* synthetic */ Object h() {
        return this.f30156a;
    }

    public int hashCode() {
        return f(h());
    }

    public String toString() {
        return g(h());
    }
}
