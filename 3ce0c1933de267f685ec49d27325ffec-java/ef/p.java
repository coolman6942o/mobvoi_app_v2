package ef;
/* compiled from: SportPoint.java */
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public long f25951a;

    /* renamed from: b  reason: collision with root package name */
    public long f25952b;

    /* renamed from: c  reason: collision with root package name */
    public int f25953c;

    /* renamed from: d  reason: collision with root package name */
    public float f25954d;

    /* renamed from: e  reason: collision with root package name */
    public int f25955e;

    /* renamed from: f  reason: collision with root package name */
    public int f25956f;

    /* renamed from: g  reason: collision with root package name */
    public float f25957g;

    /* renamed from: h  reason: collision with root package name */
    public float f25958h;

    /* renamed from: i  reason: collision with root package name */
    public float f25959i;

    /* renamed from: j  reason: collision with root package name */
    public float f25960j;

    /* renamed from: k  reason: collision with root package name */
    public float f25961k;

    /* renamed from: l  reason: collision with root package name */
    public float f25962l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f25963m;

    /* renamed from: n  reason: collision with root package name */
    public float f25964n;

    /* renamed from: o  reason: collision with root package name */
    public int f25965o;

    /* renamed from: p  reason: collision with root package name */
    public int f25966p;

    /* renamed from: q  reason: collision with root package name */
    public int f25967q;

    /* renamed from: r  reason: collision with root package name */
    public int f25968r;

    /* renamed from: s  reason: collision with root package name */
    public int f25969s;

    /* renamed from: t  reason: collision with root package name */
    public int f25970t;

    /* renamed from: u  reason: collision with root package name */
    public int f25971u;

    /* renamed from: v  reason: collision with root package name */
    public int f25972v;

    /* renamed from: w  reason: collision with root package name */
    public o f25973w;

    public p() {
        this.f25951a = -1L;
        this.f25952b = -1L;
        this.f25953c = -1;
        this.f25954d = -1.0f;
        this.f25955e = -1;
        this.f25956f = -1;
        this.f25957g = -2.14748365E9f;
        this.f25958h = -2.14748365E9f;
        this.f25959i = 2.14748365E9f;
        this.f25960j = -1.0f;
        this.f25961k = -1.0f;
        this.f25962l = -1.0f;
        this.f25963m = false;
        this.f25973w = null;
        this.f25964n = -1.0f;
        this.f25965o = -1;
        this.f25966p = -1;
        this.f25967q = -1;
        this.f25968r = -1;
        this.f25969s = -1;
        this.f25970t = -1;
        this.f25971u = -1;
        this.f25972v = -1;
    }

    public boolean a() {
        return this.f25973w == null && this.f25953c <= 0 && this.f25954d <= 0.0f && this.f25955e <= 0 && this.f25956f <= 0 && this.f25957g == -2.14748365E9f && this.f25958h == -2.14748365E9f && this.f25959i == 2.14748365E9f && this.f25960j <= 0.0f && this.f25961k <= 0.0f && this.f25962l <= 0.0f && !this.f25963m && this.f25964n <= 0.0f && this.f25965o <= 0 && this.f25967q <= 0 && this.f25968r <= 0 && this.f25969s <= 0 && this.f25970t <= 0 && this.f25972v <= 0 && this.f25971u < 0 && this.f25966p <= 0;
    }

    public p b(p pVar) {
        int i10 = pVar.f25953c;
        if (i10 > this.f25953c) {
            this.f25953c = i10;
        }
        float f10 = pVar.f25954d;
        if (f10 >= 0.0f) {
            this.f25954d = f10;
        }
        int i11 = pVar.f25955e;
        if (i11 >= 0) {
            this.f25955e = i11;
        }
        int i12 = pVar.f25956f;
        if (i12 > this.f25956f) {
            this.f25956f = i12;
        }
        float f11 = pVar.f25957g;
        if (f11 != -2.14748365E9f) {
            this.f25957g = f11;
        }
        float f12 = pVar.f25958h;
        if (f12 != -2.14748365E9f) {
            this.f25958h = f12;
        }
        float f13 = pVar.f25959i;
        if (f13 != 2.14748365E9f) {
            this.f25959i = f13;
        }
        float f14 = pVar.f25960j;
        if (f14 > 0.0f) {
            this.f25960j = f14;
        }
        float f15 = pVar.f25961k;
        if (f15 > 0.0f) {
            this.f25961k = f15;
        }
        float f16 = pVar.f25962l;
        if (f16 > this.f25962l) {
            this.f25962l = f16;
        }
        o oVar = pVar.f25973w;
        if (oVar != null) {
            this.f25973w = oVar;
        }
        if (pVar.f25963m) {
            this.f25963m = true;
        }
        float f17 = pVar.f25964n;
        if (f17 > 0.0f) {
            this.f25964n = f17;
        }
        int i13 = pVar.f25965o;
        if (i13 > 0) {
            this.f25965o = i13;
        }
        int i14 = pVar.f25966p;
        if (i14 > 0) {
            this.f25966p = i14;
        }
        int i15 = pVar.f25967q;
        if (i15 > this.f25967q) {
            this.f25967q = i15;
        }
        int i16 = pVar.f25968r;
        if (i16 > this.f25968r) {
            this.f25968r = i16;
        }
        int i17 = pVar.f25969s;
        if (i17 > this.f25969s) {
            this.f25969s = i17;
        }
        int i18 = pVar.f25971u;
        if (i18 > this.f25971u) {
            this.f25971u = i18;
            this.f25970t = pVar.f25970t;
            this.f25972v = pVar.f25972v;
        }
        return this;
    }

    public String toString() {
        return "SportPoint{time=" + this.f25951a + ", distance=" + this.f25953c + ", speed=" + this.f25954d + ", heart=" + this.f25955e + ", steps=" + this.f25956f + ", elevation=" + this.f25957g + ", maxElevation=" + this.f25958h + ", minElevation=" + this.f25959i + ", cumulativeUp=" + this.f25960j + ", cumulativeDown=" + this.f25961k + ", calorie=" + this.f25962l + ", resume=" + this.f25963m + ", swimTrips=" + this.f25964n + ", swimStroke=" + this.f25965o + ", swimType=" + this.f25966p + ", location=" + this.f25973w + ", elevation=" + this.f25957g + ", lapCount=" + this.f25967q + ", lapTime=" + this.f25968r + ", lapDistance=" + this.f25969s + ", hiitType =" + this.f25970t + ", hiitIndex =" + this.f25971u + ", hiitStartTime =" + this.f25972v + '}';
    }

    public p(p pVar) {
        this.f25951a = pVar.f25951a;
        this.f25952b = pVar.f25952b;
        this.f25953c = pVar.f25953c;
        this.f25954d = pVar.f25954d;
        this.f25955e = pVar.f25955e;
        this.f25956f = pVar.f25956f;
        this.f25957g = pVar.f25957g;
        this.f25958h = pVar.f25958h;
        this.f25959i = pVar.f25959i;
        this.f25960j = pVar.f25960j;
        this.f25961k = pVar.f25961k;
        this.f25962l = pVar.f25962l;
        this.f25963m = pVar.f25963m;
        this.f25973w = pVar.f25973w;
        this.f25964n = pVar.f25964n;
        this.f25965o = pVar.f25965o;
        this.f25966p = pVar.f25966p;
        this.f25967q = pVar.f25967q;
        this.f25968r = pVar.f25968r;
        this.f25969s = pVar.f25969s;
        this.f25970t = pVar.f25970t;
        this.f25971u = pVar.f25971u;
        this.f25972v = pVar.f25972v;
    }
}
