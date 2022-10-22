package u1;
/* compiled from: NetworkState.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35265a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35266b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35267c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f35268d;

    public b(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f35265a = z10;
        this.f35266b = z11;
        this.f35267c = z12;
        this.f35268d = z13;
    }

    public boolean a() {
        return this.f35265a;
    }

    public boolean b() {
        return this.f35267c;
    }

    public boolean c() {
        return this.f35268d;
    }

    public boolean d() {
        return this.f35266b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f35265a == bVar.f35265a && this.f35266b == bVar.f35266b && this.f35267c == bVar.f35267c && this.f35268d == bVar.f35268d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public int hashCode() {
        ?? r02 = this.f35265a;
        int i10 = r02;
        if (this.f35266b) {
            i10 = r02 + 16;
        }
        int i11 = i10;
        if (this.f35267c) {
            i11 = i10 + 256;
        }
        return this.f35268d ? i11 + 4096 : i11;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f35265a), Boolean.valueOf(this.f35266b), Boolean.valueOf(this.f35267c), Boolean.valueOf(this.f35268d));
    }
}
