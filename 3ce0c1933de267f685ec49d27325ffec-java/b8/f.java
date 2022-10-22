package b8;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f5085a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5086b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5087c;

    private f(Class<?> cls, int i10, int i11) {
        this.f5085a = (Class) q.b(cls, "Null dependency interface.");
        this.f5086b = i10;
        this.f5087c = i11;
    }

    public static f a(Class<?> cls) {
        return new f(cls, 1, 0);
    }

    public final Class<?> b() {
        return this.f5085a;
    }

    public final boolean c() {
        return this.f5086b == 1;
    }

    public final boolean d() {
        return this.f5087c == 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f5085a == fVar.f5085a && this.f5086b == fVar.f5086b && this.f5087c == fVar.f5087c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f5085a.hashCode() ^ 1000003) * 1000003) ^ this.f5086b) * 1000003) ^ this.f5087c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Dependency{interface=");
        sb2.append(this.f5085a);
        sb2.append(", required=");
        boolean z10 = false;
        sb2.append(this.f5086b == 1);
        sb2.append(", direct=");
        if (this.f5087c == 0) {
            z10 = true;
        }
        sb2.append(z10);
        sb2.append("}");
        return sb2.toString();
    }
}
