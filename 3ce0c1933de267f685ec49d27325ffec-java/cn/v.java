package cn;
/* loaded from: classes2.dex */
public class v implements Comparable<v> {

    /* renamed from: a  reason: collision with root package name */
    private String f6356a;

    /* renamed from: b  reason: collision with root package name */
    private String f6357b;

    /* renamed from: c  reason: collision with root package name */
    private String f6358c;

    /* renamed from: d  reason: collision with root package name */
    private int f6359d;

    public v() {
    }

    public v(String str, String str2, String str3, int i10) {
        this.f6356a = str;
        this.f6357b = str2;
        this.f6358c = str3;
        this.f6359d = i10;
    }

    /* renamed from: a */
    public int compareTo(v vVar) {
        return vVar.e().compareTo(e());
    }

    public String b() {
        return this.f6356a;
    }

    public int c() {
        return this.f6359d;
    }

    public String d() {
        return this.f6358c;
    }

    public String e() {
        return this.f6357b;
    }
}
