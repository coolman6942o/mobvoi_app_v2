package cn;
/* loaded from: classes2.dex */
public class k implements Comparable<k> {

    /* renamed from: a  reason: collision with root package name */
    private String f6279a;

    /* renamed from: b  reason: collision with root package name */
    private String f6280b;

    /* renamed from: c  reason: collision with root package name */
    private int f6281c;

    /* renamed from: d  reason: collision with root package name */
    private int f6282d;

    public k() {
    }

    public k(String str, String str2, int i10, int i11) {
        this.f6279a = str;
        this.f6280b = str2;
        this.f6281c = i10;
        this.f6282d = i11;
    }

    /* renamed from: a */
    public int compareTo(k kVar) {
        return kVar.d().compareTo(d());
    }

    public String b() {
        return this.f6279a;
    }

    public int c() {
        return this.f6282d;
    }

    public String d() {
        return this.f6280b;
    }

    public int e() {
        return this.f6281c;
    }

    public void f(String str) {
        this.f6279a = str;
    }

    public void g(int i10) {
        this.f6282d = i10;
    }

    public void h(String str) {
        this.f6280b = str;
    }

    public void i(int i10) {
        this.f6281c = i10;
    }
}
