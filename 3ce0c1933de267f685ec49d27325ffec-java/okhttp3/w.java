package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import vo.c;
/* compiled from: MediaType.kt */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a */
    private final String f32298a;

    /* renamed from: b */
    private final String f32299b;

    /* renamed from: c */
    private final String f32300c;

    /* renamed from: d */
    private final String[] f32301d;

    /* renamed from: g */
    public static final a f32297g = new a(null);

    /* renamed from: e */
    private static final Pattern f32295e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: f */
    private static final Pattern f32296f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: MediaType.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final w a(String toMediaType) {
            boolean D;
            boolean o10;
            i.f(toMediaType, "$this$toMediaType");
            Matcher matcher = w.f32295e.matcher(toMediaType);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                i.e(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                i.e(locale, "Locale.US");
                Objects.requireNonNull(group, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = group.toLowerCase(locale);
                i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String group2 = matcher.group(2);
                i.e(group2, "typeSubtype.group(2)");
                i.e(locale, "Locale.US");
                Objects.requireNonNull(group2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase2 = group2.toLowerCase(locale);
                i.e(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                ArrayList arrayList = new ArrayList();
                Matcher matcher2 = w.f32296f.matcher(toMediaType);
                int end = matcher.end();
                while (end < toMediaType.length()) {
                    matcher2.region(end, toMediaType.length());
                    if (matcher2.lookingAt()) {
                        String group3 = matcher2.group(1);
                        if (group3 == null) {
                            end = matcher2.end();
                        } else {
                            String group4 = matcher2.group(2);
                            if (group4 == null) {
                                group4 = matcher2.group(3);
                            } else {
                                D = t.D(group4, "'", false, 2, null);
                                if (D) {
                                    o10 = t.o(group4, "'", false, 2, null);
                                    if (o10 && group4.length() > 2) {
                                        group4 = group4.substring(1, group4.length() - 1);
                                        i.e(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                }
                            }
                            arrayList.add(group3);
                            arrayList.add(group4);
                            end = matcher2.end();
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Parameter is not formatted correctly: \"");
                        String substring = toMediaType.substring(end);
                        i.e(substring, "(this as java.lang.String).substring(startIndex)");
                        sb2.append(substring);
                        sb2.append("\" for: \"");
                        sb2.append(toMediaType);
                        sb2.append('\"');
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return new w(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
        }

        public final w b(String toMediaTypeOrNull) {
            i.f(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return a(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private w(String str, String str2, String str3, String[] strArr) {
        this.f32298a = str;
        this.f32299b = str2;
        this.f32300c = str3;
        this.f32301d = strArr;
    }

    public static /* synthetic */ Charset d(w wVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return wVar.c(charset);
    }

    public static final w f(String str) {
        return f32297g.b(str);
    }

    public final Charset c(Charset charset) {
        String e10 = e("charset");
        if (e10 == null) {
            return charset;
        }
        try {
            return Charset.forName(e10);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x002c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(String name) {
        c r10;
        vo.a j10;
        boolean p10;
        i.f(name, "name");
        r10 = kotlin.collections.i.r(this.f32301d);
        j10 = vo.f.j(r10, 2);
        int a10 = j10.a();
        int b10 = j10.b();
        int d10 = j10.d();
        if (d10 >= 0) {
            if (a10 > b10) {
                return null;
            }
        } else if (a10 < b10) {
            return null;
        }
        while (!p10) {
            if (a10 == b10) {
                return null;
            }
            a10 += d10;
        }
        return this.f32301d[a10 + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && i.b(((w) obj).f32298a, this.f32298a);
    }

    public final String g() {
        return this.f32300c;
    }

    public final String h() {
        return this.f32299b;
    }

    public int hashCode() {
        return this.f32298a.hashCode();
    }

    public String toString() {
        return this.f32298a;
    }

    public /* synthetic */ w(String str, String str2, String str3, String[] strArr, f fVar) {
        this(str, str2, str3, strArr);
    }
}
