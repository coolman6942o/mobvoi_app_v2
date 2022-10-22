package go;

import java.util.concurrent.TimeUnit;
/* compiled from: Timed.java */
/* loaded from: classes3.dex */
public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    final T f27622a;

    /* renamed from: b  reason: collision with root package name */
    final long f27623b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f27624c;

    public b(T t10, long j10, TimeUnit timeUnit) {
        this.f27622a = t10;
        this.f27623b = j10;
        this.f27624c = (TimeUnit) bo.b.e(timeUnit, "unit is null");
    }

    public long a() {
        return this.f27623b;
    }

    public T b() {
        return this.f27622a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bo.b.c(this.f27622a, bVar.f27622a) && this.f27623b == bVar.f27623b && bo.b.c(this.f27624c, bVar.f27624c);
    }

    public int hashCode() {
        T t10 = this.f27622a;
        int hashCode = t10 != null ? t10.hashCode() : 0;
        long j10 = this.f27623b;
        return (((hashCode * 31) + ((int) (j10 ^ (j10 >>> 31)))) * 31) + this.f27624c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f27623b + ", unit=" + this.f27624c + ", value=" + this.f27622a + "]";
    }
}
