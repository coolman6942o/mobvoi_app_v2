package un;

import ho.a;
/* compiled from: SingleCheck.java */
/* loaded from: classes2.dex */
public final class c<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f35548c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile a<T> f35549a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f35550b = f35548c;

    private c(a<T> aVar) {
        this.f35549a = aVar;
    }

    public static <P extends a<T>, T> a<T> a(P p10) {
        return ((p10 instanceof c) || (p10 instanceof a)) ? p10 : new c((a) b.b(p10));
    }

    @Override // ho.a
    public T get() {
        T t10 = (T) this.f35550b;
        if (t10 != f35548c) {
            return t10;
        }
        a<T> aVar = this.f35549a;
        if (aVar == null) {
            return (T) this.f35550b;
        }
        T t11 = aVar.get();
        this.f35550b = t11;
        this.f35549a = null;
        return t11;
    }
}
