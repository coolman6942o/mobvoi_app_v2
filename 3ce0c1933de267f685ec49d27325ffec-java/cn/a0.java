package cn;
/* loaded from: classes2.dex */
public class a0 implements Comparable<a0> {

    /* renamed from: a  reason: collision with root package name */
    private String f6026a;

    /* renamed from: b  reason: collision with root package name */
    private String f6027b;

    /* renamed from: c  reason: collision with root package name */
    private int f6028c;

    /* renamed from: d  reason: collision with root package name */
    private float f6029d;

    /* renamed from: e  reason: collision with root package name */
    private float f6030e;

    /* renamed from: f  reason: collision with root package name */
    private float f6031f;

    /* renamed from: g  reason: collision with root package name */
    private int f6032g;

    public a0() {
    }

    public a0(int i10, String str, String str2, int i11, float f10) {
        this.f6032g = i10;
        this.f6026a = str;
        this.f6027b = str2;
        this.f6028c = i11;
        this.f6030e = f10;
    }

    public a0(int i10, String str, String str2, int i11, float f10, float f11, float f12) {
        this.f6032g = i10;
        this.f6026a = str;
        this.f6027b = str2;
        this.f6028c = i11;
        this.f6029d = f10;
        this.f6030e = f11;
        this.f6031f = f12;
    }

    /* renamed from: a */
    public int compareTo(a0 a0Var) {
        return a0Var.g().compareTo(g());
    }

    public float b() {
        return this.f6031f;
    }

    public float c() {
        return this.f6029d;
    }

    public float d() {
        return this.f6030e;
    }

    public String e() {
        return this.f6026a;
    }

    public int f() {
        return this.f6028c;
    }

    public String g() {
        return this.f6027b;
    }

    public int h() {
        return this.f6032g;
    }
}
