package ne;

import kotlin.jvm.internal.i;
/* compiled from: DeviceType.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f31144a;

    /* renamed from: b  reason: collision with root package name */
    private String f31145b;

    /* renamed from: c  reason: collision with root package name */
    private int f31146c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31147d;

    /* renamed from: e  reason: collision with root package name */
    private int f31148e;

    public b(String title, String source, int i10, boolean z10, int i11) {
        i.f(title, "title");
        i.f(source, "source");
        this.f31144a = title;
        this.f31145b = source;
        this.f31146c = i10;
        this.f31147d = z10;
        this.f31148e = i11;
    }

    public final int a() {
        return this.f31148e;
    }

    public final int b() {
        return this.f31146c;
    }

    public final String c() {
        return this.f31145b;
    }

    public final String d() {
        return this.f31144a;
    }

    public final boolean e() {
        return this.f31147d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.b(this.f31144a, bVar.f31144a) && i.b(this.f31145b, bVar.f31145b) && this.f31146c == bVar.f31146c && this.f31147d == bVar.f31147d && this.f31148e == bVar.f31148e;
    }

    public int hashCode() {
        int hashCode = ((((this.f31144a.hashCode() * 31) + this.f31145b.hashCode()) * 31) + this.f31146c) * 31;
        boolean z10 = this.f31147d;
        if (z10) {
            z10 = true;
        }
        int i10 = z10 ? 1 : 0;
        int i11 = z10 ? 1 : 0;
        return ((hashCode + i10) * 31) + this.f31148e;
    }

    public String toString() {
        return "DeviceType(title=" + this.f31144a + ", source=" + this.f31145b + ", iconId=" + this.f31146c + ", isMultiCountDevice=" + this.f31147d + ", deviceCount=" + this.f31148e + ')';
    }
}
