package nh;
/* compiled from: ObserveRange.java */
/* loaded from: classes2.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public final long f31252a;

    /* renamed from: b  reason: collision with root package name */
    public final long f31253b;

    public b() {
        this(-1L, -1L);
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return Long.compare(this.f31252a, bVar.f31252a);
    }

    public boolean b() {
        return this.f31252a < 0 || this.f31253b < 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    public String toString() {
        return "[" + this.f31252a + ", " + this.f31253b + ")";
    }

    public b(long j10, long j11) {
        this.f31252a = j10;
        this.f31253b = j11;
    }
}
