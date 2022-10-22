package okhttp3;

import com.tendcloud.tenddata.aa;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.i0;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.t;
import okio.c;
/* compiled from: HttpUrl.kt */
/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32276a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32277b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32278c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32279d;

    /* renamed from: e  reason: collision with root package name */
    private final String f32280e;

    /* renamed from: f  reason: collision with root package name */
    private final int f32281f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f32282g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f32283h;

    /* renamed from: i  reason: collision with root package name */
    private final String f32284i;

    /* renamed from: j  reason: collision with root package name */
    private final String f32285j;

    /* renamed from: l  reason: collision with root package name */
    public static final b f32275l = new b(null);

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f32274k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: i  reason: collision with root package name */
        public static final C0444a f32286i = new C0444a(null);

        /* renamed from: a  reason: collision with root package name */
        private String f32287a;

        /* renamed from: d  reason: collision with root package name */
        private String f32290d;

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f32292f;

        /* renamed from: g  reason: collision with root package name */
        private List<String> f32293g;

        /* renamed from: h  reason: collision with root package name */
        private String f32294h;

        /* renamed from: b  reason: collision with root package name */
        private String f32288b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f32289c = "";

        /* renamed from: e  reason: collision with root package name */
        private int f32291e = -1;

        /* compiled from: HttpUrl.kt */
        /* renamed from: okhttp3.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0444a {
            private C0444a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String str, int i10, int i11) {
                try {
                    int parseInt = Integer.parseInt(b.b(u.f32275l, str, i10, i11, "", false, false, false, false, null, 248, null));
                    if (1 <= parseInt && 65535 >= parseInt) {
                        return parseInt;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String str, int i10, int i11) {
                while (i10 < i11) {
                    char charAt = str.charAt(i10);
                    if (charAt == ':') {
                        return i10;
                    }
                    if (charAt == '[') {
                        do {
                            i10++;
                            if (i10 < i11) {
                            }
                        } while (str.charAt(i10) != ']');
                    }
                    i10++;
                }
                return i11;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String str, int i10, int i11) {
                if (i11 - i10 < 2) {
                    return -1;
                }
                char charAt = str.charAt(i10);
                if ((i.h(charAt, 97) < 0 || i.h(charAt, 122) > 0) && (i.h(charAt, 65) < 0 || i.h(charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i10);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (!(charAt2 == '+' || charAt2 == '-' || charAt2 == '.')) {
                                    if (charAt2 == ':') {
                                        return i10;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    char charAt = str.charAt(i10);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i12++;
                    i10++;
                }
                return i12;
            }

            public /* synthetic */ C0444a(f fVar) {
                this();
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f32292f = arrayList;
            arrayList.add("");
        }

        private final a c(String str, boolean z10) {
            int i10 = 0;
            do {
                int n10 = gp.b.n(str, "/\\", i10, str.length());
                p(str, i10, n10, n10 < str.length(), z10);
                i10 = n10 + 1;
            } while (i10 <= str.length());
            return this;
        }

        private final int f() {
            int i10 = this.f32291e;
            if (i10 != -1) {
                return i10;
            }
            b bVar = u.f32275l;
            String str = this.f32287a;
            i.d(str);
            return bVar.c(str);
        }

        private final boolean j(String str) {
            boolean p10;
            if (i.b(str, ".")) {
                return true;
            }
            p10 = t.p(str, "%2e", true);
            return p10;
        }

        private final boolean k(String str) {
            boolean p10;
            boolean p11;
            boolean p12;
            if (i.b(str, "..")) {
                return true;
            }
            p10 = t.p(str, "%2e.", true);
            if (p10) {
                return true;
            }
            p11 = t.p(str, ".%2e", true);
            if (p11) {
                return true;
            }
            p12 = t.p(str, "%2e%2e", true);
            return p12;
        }

        private final void n() {
            List<String> list = this.f32292f;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.f32292f.isEmpty())) {
                this.f32292f.add("");
                return;
            }
            List<String> list2 = this.f32292f;
            list2.set(list2.size() - 1, "");
        }

        private final void p(String str, int i10, int i11, boolean z10, boolean z11) {
            String b10 = b.b(u.f32275l, str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, false, null, 240, null);
            if (!j(b10)) {
                if (k(b10)) {
                    n();
                    return;
                }
                List<String> list = this.f32292f;
                if (list.get(list.size() - 1).length() == 0) {
                    List<String> list2 = this.f32292f;
                    list2.set(list2.size() - 1, b10);
                } else {
                    this.f32292f.add(b10);
                }
                if (z10) {
                    this.f32292f.add("");
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0041 -> B:10:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void r(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f32292f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f32292f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f32292f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = gp.b.n(r11, r12, r6, r13)
                if (r12 >= r13) goto L36
                r0 = r3
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.p(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.u.a.r(java.lang.String, int, int):void");
        }

        public final a A(String username) {
            i.f(username, "username");
            this.f32288b = b.b(u.f32275l, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a a(String encodedName, String str) {
            i.f(encodedName, "encodedName");
            if (this.f32293g == null) {
                this.f32293g = new ArrayList();
            }
            List<String> list = this.f32293g;
            i.d(list);
            b bVar = u.f32275l;
            list.add(b.b(bVar, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List<String> list2 = this.f32293g;
            i.d(list2);
            list2.add(str != null ? b.b(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final a b(String pathSegments) {
            i.f(pathSegments, "pathSegments");
            return c(pathSegments, false);
        }

        public final a d(String name, String str) {
            i.f(name, "name");
            if (this.f32293g == null) {
                this.f32293g = new ArrayList();
            }
            List<String> list = this.f32293g;
            i.d(list);
            b bVar = u.f32275l;
            list.add(b.b(bVar, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> list2 = this.f32293g;
            i.d(list2);
            list2.add(str != null ? b.b(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final u e() {
            int p10;
            ArrayList arrayList;
            int p11;
            String str = this.f32287a;
            if (str != null) {
                b bVar = u.f32275l;
                String h10 = b.h(bVar, this.f32288b, 0, 0, false, 7, null);
                String h11 = b.h(bVar, this.f32289c, 0, 0, false, 7, null);
                String str2 = this.f32290d;
                if (str2 != null) {
                    int f10 = f();
                    List<String> list = this.f32292f;
                    p10 = n.p(list, 10);
                    ArrayList arrayList2 = new ArrayList(p10);
                    for (String str3 : list) {
                        arrayList2.add(b.h(u.f32275l, str3, 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.f32293g;
                    if (list2 != null) {
                        p11 = n.p(list2, 10);
                        arrayList = new ArrayList(p11);
                        for (String str4 : list2) {
                            arrayList.add(str4 != null ? b.h(u.f32275l, str4, 0, 0, true, 3, null) : null);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str5 = this.f32294h;
                    return new u(str, h10, h11, str2, f10, arrayList2, arrayList, str5 != null ? b.h(u.f32275l, str5, 0, 0, false, 7, null) : null, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final a g(String str) {
            List<String> list;
            if (str != null) {
                b bVar = u.f32275l;
                String b10 = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (b10 != null) {
                    list = bVar.j(b10);
                    this.f32293g = list;
                    return this;
                }
            }
            list = null;
            this.f32293g = list;
            return this;
        }

        public final List<String> h() {
            return this.f32292f;
        }

        public final a i(String host) {
            i.f(host, "host");
            String e10 = gp.a.e(b.h(u.f32275l, host, 0, 0, false, 7, null));
            if (e10 != null) {
                this.f32290d = e10;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final a l(u uVar, String input) {
            int i10;
            int n10;
            int i11;
            String str;
            int i12;
            boolean z10;
            String str2;
            int i13;
            boolean z11;
            boolean z12;
            boolean A;
            boolean A2;
            i.f(input, "input");
            int x10 = gp.b.x(input, 0, 0, 3, null);
            int z13 = gp.b.z(input, x10, 0, 2, null);
            C0444a aVar = f32286i;
            int g10 = aVar.g(input, x10, z13);
            String str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c10 = 65535;
            boolean z14 = true;
            if (g10 != -1) {
                A = t.A(input, "https:", x10, true);
                if (A) {
                    this.f32287a = "https";
                    x10 += 6;
                } else {
                    A2 = t.A(input, "http:", x10, true);
                    if (A2) {
                        this.f32287a = "http";
                        x10 += 5;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, g10);
                        i.e(substring, str3);
                        sb2.append(substring);
                        sb2.append("'");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
            } else if (uVar != null) {
                this.f32287a = uVar.t();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int h10 = aVar.h(input, x10, z13);
            char c11 = '?';
            char c12 = '#';
            if (h10 >= 2 || uVar == null || (!i.b(uVar.t(), this.f32287a))) {
                int i14 = x10 + h10;
                boolean z15 = false;
                boolean z16 = false;
                while (true) {
                    n10 = gp.b.n(input, "@/\\?#", i14, z13);
                    char charAt = n10 != z13 ? input.charAt(n10) : c10;
                    if (charAt == c10 || charAt == c12 || charAt == '/' || charAt == '\\' || charAt == c11) {
                        break;
                    }
                    if (charAt != '@') {
                        z10 = z14;
                        str2 = str3;
                        i12 = z13;
                    } else {
                        if (!z15) {
                            int m10 = gp.b.m(input, ':', i14, n10);
                            b bVar = u.f32275l;
                            z10 = z14;
                            i12 = z13;
                            str2 = str3;
                            String b10 = b.b(bVar, input, i14, m10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z16) {
                                b10 = this.f32288b + "%40" + b10;
                            }
                            this.f32288b = b10;
                            if (m10 != n10) {
                                this.f32289c = b.b(bVar, input, m10 + 1, n10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z12 = z10;
                            } else {
                                z12 = z15;
                            }
                            z15 = z12;
                            z11 = z10;
                            i13 = n10;
                        } else {
                            z10 = z14;
                            i12 = z13;
                            str2 = str3;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.f32289c);
                            sb3.append("%40");
                            i13 = n10;
                            sb3.append(b.b(u.f32275l, input, i14, n10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f32289c = sb3.toString();
                            z11 = z16;
                        }
                        i14 = i13 + 1;
                        z16 = z11;
                    }
                    str3 = str2;
                    z14 = z10;
                    z13 = i12;
                    c12 = '#';
                    c11 = '?';
                    c10 = 65535;
                }
                boolean z17 = z14;
                String str4 = str3;
                i10 = z13;
                C0444a aVar2 = f32286i;
                int f10 = aVar2.f(input, i14, n10);
                int i15 = f10 + 1;
                if (i15 < n10) {
                    i11 = i14;
                    this.f32290d = gp.a.e(b.h(u.f32275l, input, i14, f10, false, 4, null));
                    int e10 = aVar2.e(input, i15, n10);
                    this.f32291e = e10;
                    if (e10 != -1 ? z17 : false) {
                        str = str4;
                    } else {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String substring2 = input.substring(i15, n10);
                        i.e(substring2, str4);
                        sb4.append(substring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    i11 = i14;
                    str = str4;
                    b bVar2 = u.f32275l;
                    this.f32290d = gp.a.e(b.h(bVar2, input, i11, f10, false, 4, null));
                    String str5 = this.f32287a;
                    i.d(str5);
                    this.f32291e = bVar2.c(str5);
                }
                if (this.f32290d != null ? z17 : false) {
                    x10 = n10;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String substring3 = input.substring(i11, f10);
                    i.e(substring3, str);
                    sb5.append(substring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
            } else {
                this.f32288b = uVar.g();
                this.f32289c = uVar.c();
                this.f32290d = uVar.h();
                this.f32291e = uVar.n();
                this.f32292f.clear();
                this.f32292f.addAll(uVar.e());
                if (x10 == z13 || input.charAt(x10) == '#') {
                    g(uVar.f());
                }
                i10 = z13;
            }
            int i16 = i10;
            int n11 = gp.b.n(input, "?#", x10, i16);
            r(input, x10, n11);
            if (n11 < i16 && input.charAt(n11) == '?') {
                int m11 = gp.b.m(input, '#', n11, i16);
                b bVar3 = u.f32275l;
                this.f32293g = bVar3.j(b.b(bVar3, input, n11 + 1, m11, " \"'<>#", true, false, true, false, null, 208, null));
                n11 = m11;
            }
            if (n11 < i16 && input.charAt(n11) == '#') {
                this.f32294h = b.b(u.f32275l, input, n11 + 1, i16, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final a m(String password) {
            i.f(password, "password");
            this.f32289c = b.b(u.f32275l, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a o(int i10) {
            boolean z10 = true;
            if (1 > i10 || 65535 < i10) {
                z10 = false;
            }
            if (z10) {
                this.f32291e = i10;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i10).toString());
        }

        public final a q() {
            String str = this.f32290d;
            String str2 = null;
            this.f32290d = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.f32292f.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<String> list = this.f32292f;
                list.set(i10, b.b(u.f32275l, list.get(i10), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.f32293g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str3 = list2.get(i11);
                    list2.set(i11, str3 != null ? b.b(u.f32275l, str3, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str4 = this.f32294h;
            if (str4 != null) {
                str2 = b.b(u.f32275l, str4, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
            }
            this.f32294h = str2;
            return this;
        }

        public final a s(String scheme) {
            boolean p10;
            boolean p11;
            i.f(scheme, "scheme");
            p10 = t.p(scheme, "http", true);
            if (p10) {
                this.f32287a = "http";
            } else {
                p11 = t.p(scheme, "https", true);
                if (p11) {
                    this.f32287a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
            }
            return this;
        }

        public final void t(String str) {
            this.f32294h = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
            if ((r6.f32289c.length() > 0) != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
            if (r1 != r3.c(r2)) goto L37;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            boolean H;
            StringBuilder sb2 = new StringBuilder();
            String str = this.f32287a;
            if (str != null) {
                sb2.append(str);
                sb2.append(aa.f22529a);
            } else {
                sb2.append("//");
            }
            boolean z10 = true;
            if (!(this.f32288b.length() > 0)) {
            }
            sb2.append(this.f32288b);
            if (this.f32289c.length() <= 0) {
                z10 = false;
            }
            if (z10) {
                sb2.append(':');
                sb2.append(this.f32289c);
            }
            sb2.append('@');
            String str2 = this.f32290d;
            if (str2 != null) {
                i.d(str2);
                H = kotlin.text.u.H(str2, ':', false, 2, null);
                if (H) {
                    sb2.append('[');
                    sb2.append(this.f32290d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f32290d);
                }
            }
            if (!(this.f32291e == -1 && this.f32287a == null)) {
                int f10 = f();
                String str3 = this.f32287a;
                if (str3 != null) {
                    b bVar = u.f32275l;
                    i.d(str3);
                }
                sb2.append(':');
                sb2.append(f10);
            }
            b bVar2 = u.f32275l;
            bVar2.i(this.f32292f, sb2);
            if (this.f32293g != null) {
                sb2.append('?');
                List<String> list = this.f32293g;
                i.d(list);
                bVar2.k(list, sb2);
            }
            if (this.f32294h != null) {
                sb2.append('#');
                sb2.append(this.f32294h);
            }
            String sb3 = sb2.toString();
            i.e(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }

        public final void u(String str) {
            i.f(str, "<set-?>");
            this.f32289c = str;
        }

        public final void v(String str) {
            i.f(str, "<set-?>");
            this.f32288b = str;
        }

        public final void w(String str) {
            this.f32290d = str;
        }

        public final a x(int i10, String pathSegment) {
            i.f(pathSegment, "pathSegment");
            String b10 = b.b(u.f32275l, pathSegment, 0, 0, " \"<>^`{}|/\\?#", false, false, false, false, null, 251, null);
            if (!j(b10) && !k(b10)) {
                this.f32292f.set(i10, b10);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void y(int i10) {
            this.f32291e = i10;
        }

        public final void z(String str) {
            this.f32287a = str;
        }
    }

    /* compiled from: HttpUrl.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public static /* synthetic */ String b(b bVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            return bVar.a(str, (i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? str.length() : i11, str2, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? false : z12, (i12 & 64) != 0 ? false : z13, (i12 & 128) != 0 ? null : charset);
        }

        private final boolean e(String str, int i10, int i11) {
            int i12 = i10 + 2;
            return i12 < i11 && str.charAt(i10) == '%' && gp.b.E(str.charAt(i10 + 1)) != -1 && gp.b.E(str.charAt(i12)) != -1;
        }

        public static /* synthetic */ String h(b bVar, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return bVar.g(str, i10, i11, z10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
            if (e(r16, r5, r18) == false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void l(c cVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            boolean H;
            int i12 = i10;
            c cVar2 = null;
            while (i12 < i11) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                int codePointAt = str.codePointAt(i12);
                if (!z10 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                    if (codePointAt != 43 || !z12) {
                        if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z13)) {
                            H = kotlin.text.u.H(str2, (char) codePointAt, false, 2, null);
                            if (!H) {
                                if (codePointAt == 37) {
                                    if (z10) {
                                        if (z11) {
                                        }
                                    }
                                }
                                cVar.M0(codePointAt);
                                i12 += Character.charCount(codePointAt);
                            }
                        }
                        if (cVar2 == null) {
                            cVar2 = new c();
                        }
                        if (charset == null || i.b(charset, StandardCharsets.UTF_8)) {
                            cVar2.M0(codePointAt);
                        } else {
                            cVar2.I0(str, i12, Character.charCount(codePointAt) + i12, charset);
                        }
                        while (!cVar2.B()) {
                            int readByte = cVar2.readByte() & 255;
                            cVar.C(37);
                            cVar.C(u.f32274k[(readByte >> 4) & 15]);
                            cVar.C(u.f32274k[readByte & 15]);
                        }
                        i12 += Character.charCount(codePointAt);
                    } else {
                        cVar.R(z10 ? "+" : "%2B");
                    }
                }
                i12 += Character.charCount(codePointAt);
            }
        }

        private final void m(c cVar, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                int codePointAt = str.codePointAt(i10);
                if (codePointAt != 37 || (i12 = i10 + 2) >= i11) {
                    if (codePointAt == 43 && z10) {
                        cVar.C(32);
                        i10++;
                    }
                    cVar.M0(codePointAt);
                    i10 += Character.charCount(codePointAt);
                } else {
                    int E = gp.b.E(str.charAt(i10 + 1));
                    int E2 = gp.b.E(str.charAt(i12));
                    if (!(E == -1 || E2 == -1)) {
                        cVar.C((E << 4) + E2);
                        i10 = Character.charCount(codePointAt) + i12;
                    }
                    cVar.M0(codePointAt);
                    i10 += Character.charCount(codePointAt);
                }
            }
        }

        public final String a(String canonicalize, int i10, int i11, String encodeSet, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            boolean H;
            i.f(canonicalize, "$this$canonicalize");
            i.f(encodeSet, "encodeSet");
            int i12 = i10;
            while (i12 < i11) {
                int codePointAt = canonicalize.codePointAt(i12);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z13)) {
                    H = kotlin.text.u.H(encodeSet, (char) codePointAt, false, 2, null);
                    if (!H) {
                        if (codePointAt == 37) {
                            if (z10) {
                                if (z11) {
                                    if (!e(canonicalize, i12, i11)) {
                                        c cVar = new c();
                                        cVar.a0(canonicalize, i10, i12);
                                        l(cVar, canonicalize, i12, i11, encodeSet, z10, z11, z12, z13, charset);
                                        return cVar.V();
                                    }
                                    if (codePointAt == 43 || !z12) {
                                        i12 += Character.charCount(codePointAt);
                                    } else {
                                        c cVar2 = new c();
                                        cVar2.a0(canonicalize, i10, i12);
                                        l(cVar2, canonicalize, i12, i11, encodeSet, z10, z11, z12, z13, charset);
                                        return cVar2.V();
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i12 += Character.charCount(codePointAt);
                    }
                }
                c cVar22 = new c();
                cVar22.a0(canonicalize, i10, i12);
                l(cVar22, canonicalize, i12, i11, encodeSet, z10, z11, z12, z13, charset);
                return cVar22.V();
            }
            String substring = canonicalize.substring(i10, i11);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int c(String scheme) {
            i.f(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final u d(String toHttpUrl) {
            i.f(toHttpUrl, "$this$toHttpUrl");
            return new a().l(null, toHttpUrl).e();
        }

        public final u f(String toHttpUrlOrNull) {
            i.f(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return d(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String g(String percentDecode, int i10, int i11, boolean z10) {
            i.f(percentDecode, "$this$percentDecode");
            for (int i12 = i10; i12 < i11; i12++) {
                char charAt = percentDecode.charAt(i12);
                if (charAt == '%' || (charAt == '+' && z10)) {
                    c cVar = new c();
                    cVar.a0(percentDecode, i10, i12);
                    m(cVar, percentDecode, i12, i11, z10);
                    return cVar.V();
                }
            }
            String substring = percentDecode.substring(i10, i11);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void i(List<String> toPathString, StringBuilder out) {
            i.f(toPathString, "$this$toPathString");
            i.f(out, "out");
            int size = toPathString.size();
            for (int i10 = 0; i10 < size; i10++) {
                out.append('/');
                out.append(toPathString.get(i10));
            }
        }

        public final List<String> j(String toQueryNamesAndValues) {
            int S;
            int S2;
            i.f(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= toQueryNamesAndValues.length()) {
                S = kotlin.text.u.S(toQueryNamesAndValues, '&', i10, false, 4, null);
                if (S == -1) {
                    S = toQueryNamesAndValues.length();
                }
                int i11 = S;
                S2 = kotlin.text.u.S(toQueryNamesAndValues, '=', i10, false, 4, null);
                if (S2 == -1 || S2 > i11) {
                    String substring = toQueryNamesAndValues.substring(i10, i11);
                    i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = toQueryNamesAndValues.substring(i10, S2);
                    i.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = toQueryNamesAndValues.substring(S2 + 1, i11);
                    i.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i10 = i11 + 1;
            }
            return arrayList;
        }

        public final void k(List<String> toQueryString, StringBuilder out) {
            vo.c k10;
            vo.a j10;
            i.f(toQueryString, "$this$toQueryString");
            i.f(out, "out");
            k10 = vo.f.k(0, toQueryString.size());
            j10 = vo.f.j(k10, 2);
            int a10 = j10.a();
            int b10 = j10.b();
            int d10 = j10.d();
            if (d10 >= 0) {
                if (a10 > b10) {
                    return;
                }
            } else if (a10 < b10) {
                return;
            }
            while (true) {
                String str = toQueryString.get(a10);
                String str2 = toQueryString.get(a10 + 1);
                if (a10 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (a10 != b10) {
                    a10 += d10;
                } else {
                    return;
                }
            }
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public u(String scheme, String username, String password, String host, int i10, List<String> pathSegments, List<String> list, String str, String url) {
        i.f(scheme, "scheme");
        i.f(username, "username");
        i.f(password, "password");
        i.f(host, "host");
        i.f(pathSegments, "pathSegments");
        i.f(url, "url");
        this.f32277b = scheme;
        this.f32278c = username;
        this.f32279d = password;
        this.f32280e = host;
        this.f32281f = i10;
        this.f32282g = pathSegments;
        this.f32283h = list;
        this.f32284i = str;
        this.f32285j = url;
        this.f32276a = i.b(scheme, "https");
    }

    public static final u l(String str) {
        return f32275l.f(str);
    }

    public final String b() {
        int S;
        if (this.f32284i == null) {
            return null;
        }
        S = kotlin.text.u.S(this.f32285j, '#', 0, false, 6, null);
        String str = this.f32285j;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(S + 1);
        i.e(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String c() {
        int S;
        int S2;
        if (this.f32279d.length() == 0) {
            return "";
        }
        S = kotlin.text.u.S(this.f32285j, ':', this.f32277b.length() + 3, false, 4, null);
        S2 = kotlin.text.u.S(this.f32285j, '@', 0, false, 6, null);
        String str = this.f32285j;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(S + 1, S2);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String d() {
        int S;
        S = kotlin.text.u.S(this.f32285j, '/', this.f32277b.length() + 3, false, 4, null);
        String str = this.f32285j;
        int n10 = gp.b.n(str, "?#", S, str.length());
        String str2 = this.f32285j;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String substring = str2.substring(S, n10);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> e() {
        int S;
        S = kotlin.text.u.S(this.f32285j, '/', this.f32277b.length() + 3, false, 4, null);
        String str = this.f32285j;
        int n10 = gp.b.n(str, "?#", S, str.length());
        ArrayList arrayList = new ArrayList();
        while (S < n10) {
            int i10 = S + 1;
            int m10 = gp.b.m(this.f32285j, '/', i10, n10);
            String str2 = this.f32285j;
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String substring = str2.substring(i10, m10);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            S = m10;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && i.b(((u) obj).f32285j, this.f32285j);
    }

    public final String f() {
        int S;
        if (this.f32283h == null) {
            return null;
        }
        S = kotlin.text.u.S(this.f32285j, '?', 0, false, 6, null);
        int i10 = S + 1;
        String str = this.f32285j;
        int m10 = gp.b.m(str, '#', i10, str.length());
        String str2 = this.f32285j;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String substring = str2.substring(i10, m10);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String g() {
        if (this.f32278c.length() == 0) {
            return "";
        }
        int length = this.f32277b.length() + 3;
        String str = this.f32285j;
        int n10 = gp.b.n(str, ":@", length, str.length());
        String str2 = this.f32285j;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        String substring = str2.substring(length, n10);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String h() {
        return this.f32280e;
    }

    public int hashCode() {
        return this.f32285j.hashCode();
    }

    public final boolean i() {
        return this.f32276a;
    }

    public final a j() {
        a aVar = new a();
        aVar.z(this.f32277b);
        aVar.v(g());
        aVar.u(c());
        aVar.w(this.f32280e);
        aVar.y(this.f32281f != f32275l.c(this.f32277b) ? this.f32281f : -1);
        aVar.h().clear();
        aVar.h().addAll(e());
        aVar.g(f());
        aVar.t(b());
        return aVar;
    }

    public final a k(String link) {
        i.f(link, "link");
        try {
            return new a().l(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List<String> m() {
        return this.f32282g;
    }

    public final int n() {
        return this.f32281f;
    }

    public final String o() {
        if (this.f32283h == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        f32275l.k(this.f32283h, sb2);
        return sb2.toString();
    }

    public final String p(String name) {
        vo.c k10;
        vo.a j10;
        i.f(name, "name");
        List<String> list = this.f32283h;
        if (list == null) {
            return null;
        }
        k10 = vo.f.k(0, list.size());
        j10 = vo.f.j(k10, 2);
        int a10 = j10.a();
        int b10 = j10.b();
        int d10 = j10.d();
        if (d10 < 0 ? a10 >= b10 : a10 <= b10) {
            while (!i.b(name, this.f32283h.get(a10))) {
                if (a10 != b10) {
                    a10 += d10;
                }
            }
            return this.f32283h.get(a10 + 1);
        }
        return null;
    }

    public final Set<String> q() {
        vo.c k10;
        vo.a j10;
        Set<String> b10;
        if (this.f32283h == null) {
            b10 = i0.b();
            return b10;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        k10 = vo.f.k(0, this.f32283h.size());
        j10 = vo.f.j(k10, 2);
        int a10 = j10.a();
        int b11 = j10.b();
        int d10 = j10.d();
        if (d10 < 0 ? a10 >= b11 : a10 <= b11) {
            while (true) {
                String str = this.f32283h.get(a10);
                i.d(str);
                linkedHashSet.add(str);
                if (a10 == b11) {
                    break;
                }
                a10 += d10;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        i.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String r() {
        a k10 = k("/...");
        i.d(k10);
        return k10.A("").m("").e().toString();
    }

    public final u s(String link) {
        i.f(link, "link");
        a k10 = k(link);
        if (k10 != null) {
            return k10.e();
        }
        return null;
    }

    public final String t() {
        return this.f32277b;
    }

    public String toString() {
        return this.f32285j;
    }

    public final URI u() {
        String aVar = j().q().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e10) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(aVar, ""));
                i.e(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final URL v() {
        try {
            return new URL(this.f32285j);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }
}
