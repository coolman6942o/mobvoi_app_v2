package tm;
/* compiled from: DimensionStatus.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f35209c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f35210d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f35211e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f35212f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f35213g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f35214h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f35215i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f35216j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f35217k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f35218l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f35219m;

    /* renamed from: n  reason: collision with root package name */
    public static final a f35220n;

    /* renamed from: o  reason: collision with root package name */
    public static final a[] f35221o;

    /* renamed from: a  reason: collision with root package name */
    public final int f35222a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f35223b;

    static {
        a aVar = new a(0, false);
        f35209c = aVar;
        a aVar2 = new a(1, true);
        f35210d = aVar2;
        a aVar3 = new a(2, false);
        f35211e = aVar3;
        a aVar4 = new a(3, true);
        f35212f = aVar4;
        a aVar5 = new a(4, false);
        f35213g = aVar5;
        a aVar6 = new a(5, true);
        f35214h = aVar6;
        a aVar7 = new a(6, false);
        f35215i = aVar7;
        a aVar8 = new a(7, true);
        f35216j = aVar8;
        a aVar9 = new a(8, false);
        f35217k = aVar9;
        a aVar10 = new a(9, true);
        f35218l = aVar10;
        a aVar11 = new a(10, false);
        f35219m = aVar11;
        a aVar12 = new a(10, true);
        f35220n = aVar12;
        f35221o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    private a(int i10, boolean z10) {
        this.f35222a = i10;
        this.f35223b = z10;
    }

    public boolean a(a aVar) {
        int i10 = this.f35222a;
        int i11 = aVar.f35222a;
        return i10 < i11 || ((!this.f35223b || f35218l == this) && i10 == i11);
    }

    public a b() {
        return !this.f35223b ? f35221o[this.f35222a + 1] : this;
    }
}
