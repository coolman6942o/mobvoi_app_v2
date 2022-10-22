package cn;
/* loaded from: classes2.dex */
public class i implements Comparable<i> {

    /* renamed from: a  reason: collision with root package name */
    private String f6266a;

    /* renamed from: b  reason: collision with root package name */
    private String f6267b;

    /* renamed from: c  reason: collision with root package name */
    private int f6268c;

    /* renamed from: d  reason: collision with root package name */
    private int f6269d;

    /* renamed from: e  reason: collision with root package name */
    private int f6270e;

    /* renamed from: f  reason: collision with root package name */
    private int f6271f;

    /* renamed from: g  reason: collision with root package name */
    private int f6272g;

    /* renamed from: h  reason: collision with root package name */
    private int f6273h;

    /* renamed from: i  reason: collision with root package name */
    private String f6274i;

    /* renamed from: j  reason: collision with root package name */
    private String f6275j;

    /* renamed from: k  reason: collision with root package name */
    private int f6276k;

    /* renamed from: l  reason: collision with root package name */
    private int f6277l;

    /* renamed from: m  reason: collision with root package name */
    private String f6278m;

    public i() {
    }

    public i(i iVar, String str) {
        if (iVar != null) {
            q(iVar.b());
            u(iVar.c());
            D(iVar.l());
            v(iVar.d());
            x(iVar.f());
            B(iVar.j());
            z(iVar.h());
            w(iVar.e());
            E(iVar.m());
            F(iVar.n());
            y(iVar.g());
            C(iVar.k());
        }
        A(str);
    }

    public i(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, String str3) {
        q(str);
        u(str2);
        D(i10);
        v(i11);
        x(i12);
        B(i13);
        z(i14);
        w(i15);
        E(i16);
        C(str3);
    }

    public i(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, String str3, int i16, int i17, String str4, String str5) {
        q(str);
        u(str2);
        D(i10);
        v(i11);
        x(i12);
        B(i13);
        z(i14);
        w(i15);
        A(str3);
        E(i16);
        F(i17);
        y(str4);
        C(str5);
    }

    public void A(String str) {
        this.f6274i = str;
    }

    public void B(int i10) {
        this.f6273h = i10;
    }

    public void C(String str) {
        this.f6275j = str;
    }

    public void D(int i10) {
        this.f6268c = i10;
    }

    public void E(int i10) {
        this.f6276k = i10;
    }

    public void F(int i10) {
        this.f6277l = i10;
    }

    /* renamed from: a */
    public int compareTo(i iVar) {
        return iVar.b().compareTo(b());
    }

    public String b() {
        return this.f6266a;
    }

    public String c() {
        return this.f6267b;
    }

    public int d() {
        return this.f6269d;
    }

    public int e() {
        return this.f6272g;
    }

    public int f() {
        return this.f6270e;
    }

    public String g() {
        return this.f6278m;
    }

    public int h() {
        return this.f6271f;
    }

    public String i() {
        return this.f6274i;
    }

    public int j() {
        return this.f6273h;
    }

    public String k() {
        return this.f6275j;
    }

    public int l() {
        return this.f6268c;
    }

    public int m() {
        return this.f6276k;
    }

    public int n() {
        return this.f6277l;
    }

    public void q(String str) {
        this.f6266a = str;
    }

    public void u(String str) {
        this.f6267b = str;
    }

    public void v(int i10) {
        this.f6269d = i10;
    }

    public void w(int i10) {
        this.f6272g = i10;
    }

    public void x(int i10) {
        this.f6270e = i10;
    }

    public void y(String str) {
        this.f6278m = str;
    }

    public void z(int i10) {
        this.f6271f = i10;
    }
}
