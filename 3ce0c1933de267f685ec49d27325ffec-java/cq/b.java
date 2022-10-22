package cq;
/* compiled from: Timestamped.java */
/* loaded from: classes3.dex */
public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final long f24711a;

    /* renamed from: b  reason: collision with root package name */
    private final T f24712b;

    public b(long j10, T t10) {
        this.f24712b = t10;
        this.f24711a = j10;
    }

    public long a() {
        return this.f24711a;
    }

    public T b() {
        return this.f24712b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f24711a == bVar.f24711a) {
            T t10 = this.f24712b;
            T t11 = bVar.f24712b;
            if (t10 == t11) {
                return true;
            }
            if (t10 != null && t10.equals(t11)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f24711a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) + 31) * 31;
        T t10 = this.f24712b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f24711a), this.f24712b.toString());
    }
}
