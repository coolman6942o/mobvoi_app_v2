package okhttp3;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
/* compiled from: CacheControl.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31819a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31820b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31821c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31822d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f31823e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f31824f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f31825g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31826h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31827i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f31828j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f31829k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f31830l;

    /* renamed from: m  reason: collision with root package name */
    private String f31831m;

    /* renamed from: o  reason: collision with root package name */
    public static final b f31818o = new b(null);

    /* renamed from: n  reason: collision with root package name */
    public static final d f31817n = new a().e().c(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* compiled from: CacheControl.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f31832a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f31833b;

        /* renamed from: c  reason: collision with root package name */
        private int f31834c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f31835d = -1;

        /* renamed from: e  reason: collision with root package name */
        private int f31836e = -1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f31837f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f31838g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f31839h;

        private final int b(long j10) {
            if (j10 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }

        public final d a() {
            return new d(this.f31832a, this.f31833b, this.f31834c, -1, false, false, false, this.f31835d, this.f31836e, this.f31837f, this.f31838g, this.f31839h, null, null);
        }

        public final a c(int i10, TimeUnit timeUnit) {
            i.f(timeUnit, "timeUnit");
            if (i10 >= 0) {
                this.f31835d = b(timeUnit.toSeconds(i10));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i10).toString());
        }

        public final a d() {
            this.f31832a = true;
            return this;
        }

        public final a e() {
            this.f31837f = true;
            return this;
        }
    }

    /* compiled from: CacheControl.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        private final int a(String str, String str2, int i10) {
            boolean H;
            int length = str.length();
            while (i10 < length) {
                H = u.H(str2, str.charAt(i10), false, 2, null);
                if (H) {
                    return i10;
                }
                i10++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final d b(Headers headers) {
            boolean p10;
            int i10;
            int i11;
            CharSequence E0;
            boolean z10;
            int i12;
            String str;
            boolean p11;
            boolean p12;
            boolean p13;
            boolean p14;
            boolean p15;
            boolean p16;
            boolean p17;
            boolean p18;
            boolean p19;
            boolean p20;
            boolean p21;
            boolean p22;
            CharSequence E02;
            int S;
            boolean p23;
            Headers headers2 = headers;
            i.f(headers2, "headers");
            int size = headers.size();
            boolean z11 = true;
            boolean z12 = true;
            int i13 = 0;
            String str2 = null;
            boolean z13 = false;
            boolean z14 = false;
            int i14 = -1;
            int i15 = -1;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            int i16 = -1;
            int i17 = -1;
            boolean z18 = false;
            boolean z19 = false;
            boolean z20 = false;
            while (i13 < size) {
                String name = headers2.name(i13);
                String value = headers2.value(i13);
                p10 = t.p(name, "Cache-Control", z11);
                if (!p10) {
                    p23 = t.p(name, "Pragma", z11);
                    if (!p23) {
                        i10 = size;
                        i13++;
                        headers2 = headers;
                        size = i10;
                    }
                } else if (str2 == null) {
                    str2 = value;
                    i11 = 0;
                    while (i11 < value.length()) {
                        int a10 = a(value, "=,;", i11);
                        String substring = value.substring(i11, a10);
                        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        Objects.requireNonNull(substring, "null cannot be cast to non-null type kotlin.CharSequence");
                        E0 = u.E0(substring);
                        String obj = E0.toString();
                        size = size;
                        if (a10 != value.length()) {
                            z10 = z12;
                            if (!(value.charAt(a10) == ',' || value.charAt(a10) == ';')) {
                                int A = gp.b.A(value, a10 + 1);
                                if (A >= value.length() || value.charAt(A) != '\"') {
                                    i12 = a(value, ",;", A);
                                    String substring2 = value.substring(A, i12);
                                    i.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    Objects.requireNonNull(substring2, "null cannot be cast to non-null type kotlin.CharSequence");
                                    E02 = u.E0(substring2);
                                    str = E02.toString();
                                } else {
                                    int i18 = A + 1;
                                    S = u.S(value, '\"', i18, false, 4, null);
                                    str = value.substring(i18, S);
                                    i.e(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i12 = S + 1;
                                }
                                z11 = true;
                                p11 = t.p("no-cache", obj, true);
                                if (!p11) {
                                    z13 = true;
                                } else {
                                    p12 = t.p("no-store", obj, true);
                                    if (p12) {
                                        z14 = true;
                                    } else {
                                        p13 = t.p("max-age", obj, true);
                                        if (p13) {
                                            i14 = gp.b.R(str, -1);
                                        } else {
                                            p14 = t.p("s-maxage", obj, true);
                                            if (p14) {
                                                i15 = gp.b.R(str, -1);
                                            } else {
                                                p15 = t.p("private", obj, true);
                                                if (p15) {
                                                    z15 = true;
                                                } else {
                                                    p16 = t.p("public", obj, true);
                                                    if (p16) {
                                                        z16 = true;
                                                    } else {
                                                        p17 = t.p("must-revalidate", obj, true);
                                                        if (p17) {
                                                            z17 = true;
                                                        } else {
                                                            p18 = t.p("max-stale", obj, true);
                                                            if (p18) {
                                                                i16 = gp.b.R(str, Integer.MAX_VALUE);
                                                            } else {
                                                                p19 = t.p("min-fresh", obj, true);
                                                                if (p19) {
                                                                    i17 = gp.b.R(str, -1);
                                                                } else {
                                                                    p20 = t.p("only-if-cached", obj, true);
                                                                    if (p20) {
                                                                        z18 = true;
                                                                    } else {
                                                                        p21 = t.p("no-transform", obj, true);
                                                                        if (p21) {
                                                                            z19 = true;
                                                                        } else {
                                                                            p22 = t.p("immutable", obj, true);
                                                                            if (p22) {
                                                                                z20 = true;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i11 = i12;
                                        z12 = z10;
                                    }
                                }
                                i11 = i12;
                                z12 = z10;
                            }
                        } else {
                            z10 = z12;
                        }
                        i12 = a10 + 1;
                        str = null;
                        z11 = true;
                        p11 = t.p("no-cache", obj, true);
                        if (!p11) {
                        }
                        i11 = i12;
                        z12 = z10;
                    }
                    i10 = size;
                    i13++;
                    headers2 = headers;
                    size = i10;
                }
                z12 = false;
                i11 = 0;
                while (i11 < value.length()) {
                }
                i10 = size;
                i13++;
                headers2 = headers;
                size = i10;
            }
            return new d(z13, z14, i14, i15, z15, z16, z17, i16, i17, z18, z19, z20, !z12 ? null : str2, null);
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    static {
        new a().d().a();
    }

    private d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f31819a = z10;
        this.f31820b = z11;
        this.f31821c = i10;
        this.f31822d = i11;
        this.f31823e = z12;
        this.f31824f = z13;
        this.f31825g = z14;
        this.f31826h = i12;
        this.f31827i = i13;
        this.f31828j = z15;
        this.f31829k = z16;
        this.f31830l = z17;
        this.f31831m = str;
    }

    public final boolean a() {
        return this.f31823e;
    }

    public final boolean b() {
        return this.f31824f;
    }

    public final int c() {
        return this.f31821c;
    }

    public final int d() {
        return this.f31826h;
    }

    public final int e() {
        return this.f31827i;
    }

    public final boolean f() {
        return this.f31825g;
    }

    public final boolean g() {
        return this.f31819a;
    }

    public final boolean h() {
        return this.f31820b;
    }

    public final boolean i() {
        return this.f31828j;
    }

    public String toString() {
        String str = this.f31831m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f31819a) {
            sb2.append("no-cache, ");
        }
        if (this.f31820b) {
            sb2.append("no-store, ");
        }
        if (this.f31821c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f31821c);
            sb2.append(", ");
        }
        if (this.f31822d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f31822d);
            sb2.append(", ");
        }
        if (this.f31823e) {
            sb2.append("private, ");
        }
        if (this.f31824f) {
            sb2.append("public, ");
        }
        if (this.f31825g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f31826h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f31826h);
            sb2.append(", ");
        }
        if (this.f31827i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f31827i);
            sb2.append(", ");
        }
        if (this.f31828j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f31829k) {
            sb2.append("no-transform, ");
        }
        if (this.f31830l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        this.f31831m = sb3;
        return sb3;
    }

    public /* synthetic */ d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str, f fVar) {
        this(z10, z11, i10, i11, z12, z13, z14, i12, i13, z15, z16, z17, str);
    }
}
