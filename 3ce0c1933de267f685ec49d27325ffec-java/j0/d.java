package j0;
/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f29364a;

    /* renamed from: b  reason: collision with root package name */
    public final S f29365b;

    public d(F f10, S s10) {
        this.f29364a = f10;
        this.f29365b = s10;
    }

    public static <A, B> d<A, B> a(A a10, B b10) {
        return new d<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f29364a, this.f29364a) && c.a(dVar.f29365b, this.f29365b);
    }

    public int hashCode() {
        F f10 = this.f29364a;
        int i10 = 0;
        int hashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f29365b;
        if (s10 != null) {
            i10 = s10.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + this.f29364a + " " + this.f29365b + "}";
    }
}
