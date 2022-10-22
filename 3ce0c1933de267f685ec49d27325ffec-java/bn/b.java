package bn;
/* loaded from: classes2.dex */
public class b implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    int f5279a = -1;

    /* renamed from: b  reason: collision with root package name */
    boolean f5280b = true;

    /* renamed from: c  reason: collision with root package name */
    int f5281c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f5282d = -1;

    public int a() {
        return this.f5279a;
    }

    public int b() {
        return this.f5281c;
    }

    public int c() {
        return this.f5282d;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        int i10 = this.f5279a;
        int i11 = ((b) obj).f5279a;
        if (i10 > i11) {
            return 1;
        }
        return i10 < i11 ? -1 : 0;
    }

    public boolean d() {
        return this.f5280b;
    }
}
