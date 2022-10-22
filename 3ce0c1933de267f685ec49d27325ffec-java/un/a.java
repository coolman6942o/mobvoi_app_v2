package un;
/* compiled from: DoubleCheck.java */
/* loaded from: classes2.dex */
public final class a<T> implements ho.a<T>, kn.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f35545c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile ho.a<T> f35546a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f35547b = f35545c;

    private a(ho.a<T> aVar) {
        this.f35546a = aVar;
    }

    public static <P extends ho.a<T>, T> kn.a<T> a(P p10) {
        if (p10 instanceof kn.a) {
            return (kn.a) p10;
        }
        return new a((ho.a) b.b(p10));
    }

    public static <P extends ho.a<T>, T> ho.a<T> b(P p10) {
        b.b(p10);
        return p10 instanceof a ? p10 : new a(p10);
    }

    private static Object c(Object obj, Object obj2) {
        if (!(obj != f35545c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // ho.a
    public T get() {
        T t10 = (T) this.f35547b;
        Object obj = f35545c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = this.f35547b;
                if (t10 == obj) {
                    t10 = this.f35546a.get();
                    this.f35547b = c(this.f35547b, t10);
                    this.f35546a = null;
                }
            }
        }
        return t10;
    }
}
