package g3;

import j0.d;
/* compiled from: MutablePair.java */
/* loaded from: classes.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    T f27245a;

    /* renamed from: b  reason: collision with root package name */
    T f27246b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t10, T t11) {
        this.f27245a = t10;
        this.f27246b = t11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a(dVar.f29364a, this.f27245a) && a(dVar.f29365b, this.f27246b);
    }

    public int hashCode() {
        T t10 = this.f27245a;
        int i10 = 0;
        int hashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.f27246b;
        if (t11 != null) {
            i10 = t11.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f27245a) + " " + String.valueOf(this.f27246b) + "}";
    }
}
