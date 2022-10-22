package okhttp3;

import com.amap.api.services.core.AMapException;
import com.mobvoi.mcuwatch.ui.contacts.a0;
import gp.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.t;
import kotlin.text.u;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* compiled from: Cookie.kt */
/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f32244a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32245b;

    /* renamed from: c  reason: collision with root package name */
    private final long f32246c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32247d;

    /* renamed from: e  reason: collision with root package name */
    private final String f32248e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f32249f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f32250g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f32251h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f32252i;

    /* renamed from: n  reason: collision with root package name */
    public static final a f32243n = new a(null);

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f32239j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f32240k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f32241l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f32242m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: Cookie.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        private final int a(String str, int i10, int i11, boolean z10) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                boolean z11 = true;
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && (('0' > charAt || '9' < charAt) && (('a' > charAt || 'z' < charAt) && (('A' > charAt || 'Z' < charAt) && charAt != ':')))) {
                    z11 = false;
                }
                if (z11 == (!z10)) {
                    return i10;
                }
                i10++;
            }
            return i11;
        }

        private final boolean b(String str, String str2) {
            boolean o10;
            if (i.b(str, str2)) {
                return true;
            }
            o10 = t.o(str, str2, false, 2, null);
            return o10 && str.charAt((str.length() - str2.length()) - 1) == '.' && !b.f(str);
        }

        private final String f(String str) {
            boolean o10;
            String h02;
            o10 = t.o(str, ".", false, 2, null);
            if (!o10) {
                h02 = u.h0(str, ".");
                String e10 = gp.a.e(h02);
                if (e10 != null) {
                    return e10;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long g(String str, int i10, int i11) {
            int T;
            int a10 = a(str, i10, i11, false);
            Matcher matcher = m.f32242m.matcher(str);
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            int i17 = -1;
            while (a10 < i11) {
                int a11 = a(str, a10 + 1, i11, true);
                matcher.region(a10, a11);
                if (i13 == -1 && matcher.usePattern(m.f32242m).matches()) {
                    String group = matcher.group(1);
                    i.e(group, "matcher.group(1)");
                    i13 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    i.e(group2, "matcher.group(2)");
                    i16 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    i.e(group3, "matcher.group(3)");
                    i17 = Integer.parseInt(group3);
                } else if (i14 == -1 && matcher.usePattern(m.f32241l).matches()) {
                    String group4 = matcher.group(1);
                    i.e(group4, "matcher.group(1)");
                    i14 = Integer.parseInt(group4);
                } else if (i15 == -1 && matcher.usePattern(m.f32240k).matches()) {
                    String group5 = matcher.group(1);
                    i.e(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    i.e(locale, "Locale.US");
                    Objects.requireNonNull(group5, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase = group5.toLowerCase(locale);
                    i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String pattern = m.f32240k.pattern();
                    i.e(pattern, "MONTH_PATTERN.pattern()");
                    T = u.T(pattern, lowerCase, 0, false, 6, null);
                    i15 = T / 4;
                } else if (i12 == -1 && matcher.usePattern(m.f32239j).matches()) {
                    String group6 = matcher.group(1);
                    i.e(group6, "matcher.group(1)");
                    i12 = Integer.parseInt(group6);
                }
                a10 = a(str, a11 + 1, i11, false);
            }
            if (70 <= i12 && 99 >= i12) {
                i12 += AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR;
            }
            if (i12 >= 0 && 69 >= i12) {
                i12 += 2000;
            }
            if (i12 >= 1601) {
                if (i15 != -1) {
                    if (1 <= i14 && 31 >= i14) {
                        if (i13 >= 0 && 23 >= i13) {
                            if (i16 >= 0 && 59 >= i16) {
                                if (i17 >= 0 && 59 >= i17) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(b.f27630f);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i12);
                                    gregorianCalendar.set(2, i15 - 1);
                                    gregorianCalendar.set(5, i14);
                                    gregorianCalendar.set(11, i13);
                                    gregorianCalendar.set(12, i16);
                                    gregorianCalendar.set(13, i17);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final long h(String str) {
            boolean D;
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e10) {
                if (new Regex("-?\\d+").matches(str)) {
                    D = t.D(str, "-", false, 2, null);
                    return D ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e10;
            }
        }

        public final m c(u url, String setCookie) {
            i.f(url, "url");
            i.f(setCookie, "setCookie");
            return d(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0102, code lost:
            if (r1 > 253402300799999L) goto L56;
         */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x015a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final m d(long j10, u url, String setCookie) {
            long j11;
            String h10;
            String str;
            m mVar;
            String str2;
            String str3;
            int X;
            boolean D;
            boolean p10;
            boolean p11;
            boolean p12;
            boolean p13;
            boolean p14;
            boolean p15;
            i.f(url, "url");
            i.f(setCookie, "setCookie");
            int o10 = b.o(setCookie, ';', 0, 0, 6, null);
            int o11 = b.o(setCookie, '=', 0, o10, 2, null);
            if (o11 == o10) {
                return null;
            }
            String T = b.T(setCookie, 0, o11, 1, null);
            if ((T.length() == 0) || b.v(T) != -1) {
                return null;
            }
            String S = b.S(setCookie, o11 + 1, o10);
            if (b.v(S) != -1) {
                return null;
            }
            int i10 = o10 + 1;
            int length = setCookie.length();
            String str4 = null;
            String str5 = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = true;
            long j12 = -1;
            long j13 = 253402300799999L;
            while (i10 < length) {
                int m10 = b.m(setCookie, ';', i10, length);
                int m11 = b.m(setCookie, '=', i10, m10);
                String S2 = b.S(setCookie, i10, m11);
                String S3 = m11 < m10 ? b.S(setCookie, m11 + 1, m10) : "";
                p10 = t.p(S2, "expires", true);
                if (p10) {
                    try {
                        j13 = g(S3, 0, S3.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else {
                    p11 = t.p(S2, "max-age", true);
                    if (p11) {
                        j12 = h(S3);
                    } else {
                        p12 = t.p(S2, "domain", true);
                        if (p12) {
                            str4 = f(S3);
                            z13 = false;
                        } else {
                            p13 = t.p(S2, "path", true);
                            if (p13) {
                                str5 = S3;
                            } else {
                                p14 = t.p(S2, "secure", true);
                                if (p14) {
                                    z10 = true;
                                } else {
                                    p15 = t.p(S2, "httponly", true);
                                    if (p15) {
                                        z11 = true;
                                    }
                                }
                            }
                        }
                        i10 = m10 + 1;
                    }
                }
                z12 = true;
                i10 = m10 + 1;
            }
            long j14 = Long.MIN_VALUE;
            if (j12 != Long.MIN_VALUE) {
                if (j12 != -1) {
                    j14 = j10 + (j12 <= 9223372036854775L ? j12 * 1000 : Long.MAX_VALUE);
                    long j15 = j14 >= j10 ? 253402300799999L : 253402300799999L;
                    j11 = j15;
                } else {
                    j11 = j13;
                }
                h10 = url.h();
                if (str4 != null) {
                    str = h10;
                    mVar = null;
                } else if (!b(h10, str4)) {
                    return null;
                } else {
                    mVar = null;
                    str = str4;
                }
                if (h10.length() == str.length() && PublicSuffixDatabase.f32217h.c().c(str) == null) {
                    return mVar;
                }
                String str6 = "/";
                str2 = str5;
                if (str2 != null) {
                    D = t.D(str2, str6, false, 2, mVar);
                    if (D) {
                        str3 = str2;
                        return new m(T, S, j11, str, str3, z10, z11, z12, z13, null);
                    }
                }
                String d10 = url.d();
                X = u.X(d10, '/', 0, false, 6, null);
                if (X != 0) {
                    Objects.requireNonNull(d10, "null cannot be cast to non-null type java.lang.String");
                    str6 = d10.substring(0, X);
                    i.e(str6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                str3 = str6;
                return new m(T, S, j11, str, str3, z10, z11, z12, z13, null);
            }
            j11 = j14;
            h10 = url.h();
            if (str4 != null) {
            }
            if (h10.length() == str.length()) {
            }
            String str62 = "/";
            str2 = str5;
            if (str2 != null) {
            }
            String d102 = url.d();
            X = u.X(d102, '/', 0, false, 6, null);
            if (X != 0) {
            }
            str3 = str62;
            return new m(T, S, j11, str, str3, z10, z11, z12, z13, null);
        }

        public final List<m> e(u url, Headers headers) {
            List<m> g10;
            i.f(url, "url");
            i.f(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < size; i10++) {
                m c10 = c(url, values.get(i10));
                if (c10 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c10);
                }
            }
            if (arrayList != null) {
                List<m> unmodifiableList = Collections.unmodifiableList(arrayList);
                i.e(unmodifiableList, "Collections.unmodifiableList(cookies)");
                return unmodifiableList;
            }
            g10 = kotlin.collections.m.g();
            return g10;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f32244a = str;
        this.f32245b = str2;
        this.f32246c = j10;
        this.f32247d = str3;
        this.f32248e = str4;
        this.f32249f = z10;
        this.f32250g = z11;
        this.f32251h = z12;
        this.f32252i = z13;
    }

    public final String e() {
        return this.f32244a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (i.b(mVar.f32244a, this.f32244a) && i.b(mVar.f32245b, this.f32245b) && mVar.f32246c == this.f32246c && i.b(mVar.f32247d, this.f32247d) && i.b(mVar.f32248e, this.f32248e) && mVar.f32249f == this.f32249f && mVar.f32250g == this.f32250g && mVar.f32251h == this.f32251h && mVar.f32252i == this.f32252i) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f32244a);
        sb2.append('=');
        sb2.append(this.f32245b);
        if (this.f32251h) {
            if (this.f32246c == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(c.b(new Date(this.f32246c)));
            }
        }
        if (!this.f32252i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f32247d);
        }
        sb2.append("; path=");
        sb2.append(this.f32248e);
        if (this.f32249f) {
            sb2.append("; secure");
        }
        if (this.f32250g) {
            sb2.append("; httponly");
        }
        String sb3 = sb2.toString();
        i.e(sb3, "toString()");
        return sb3;
    }

    public final String g() {
        return this.f32245b;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f32244a.hashCode()) * 31) + this.f32245b.hashCode()) * 31) + ia.a.a(this.f32246c)) * 31) + this.f32247d.hashCode()) * 31) + this.f32248e.hashCode()) * 31) + a0.a(this.f32249f)) * 31) + a0.a(this.f32250g)) * 31) + a0.a(this.f32251h)) * 31) + a0.a(this.f32252i);
    }

    public String toString() {
        return f(false);
    }

    public /* synthetic */ m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, f fVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }
}
