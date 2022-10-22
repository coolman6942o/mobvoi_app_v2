package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: NavDeepLink.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f3485i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f3486a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f3487b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Pattern f3488c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3489d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3490e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3491f;

    /* renamed from: g  reason: collision with root package name */
    private Pattern f3492g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3493h;

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f3494a;

        /* renamed from: b  reason: collision with root package name */
        private String f3495b;

        /* renamed from: c  reason: collision with root package name */
        private String f3496c;

        public h a() {
            return new h(this.f3494a, this.f3495b, this.f3496c);
        }

        public a b(String str) {
            if (!str.isEmpty()) {
                this.f3495b = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public a c(String str) {
            this.f3496c = str;
            return this;
        }

        public a d(String str) {
            this.f3494a = str;
            return this;
        }
    }

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    private static class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        String f3497a;

        /* renamed from: b  reason: collision with root package name */
        String f3498b;

        b(String str) {
            String[] split = str.split("/", -1);
            this.f3497a = split[0];
            this.f3498b = split[1];
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int i10 = this.f3497a.equals(bVar.f3497a) ? 2 : 0;
            return this.f3498b.equals(bVar.f3498b) ? i10 + 1 : i10;
        }
    }

    /* compiled from: NavDeepLink.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f3499a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f3500b = new ArrayList<>();

        c() {
        }

        void a(String str) {
            this.f3500b.add(str);
        }

        String b(int i10) {
            return this.f3500b.get(i10);
        }

        String c() {
            return this.f3499a;
        }

        void d(String str) {
            this.f3499a = str;
        }

        public int e() {
            return this.f3500b.size();
        }
    }

    h(String str, String str2, String str3) {
        this.f3488c = null;
        int i10 = 0;
        this.f3489d = false;
        this.f3490e = false;
        this.f3492g = null;
        this.f3491f = str2;
        this.f3493h = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.f3490e = parse.getQuery() != null;
            StringBuilder sb2 = new StringBuilder("^");
            if (!f3485i.matcher(str).find()) {
                sb2.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f3490e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb2, compile);
                }
                this.f3489d = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb3 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    c cVar = new c();
                    int i11 = i10;
                    while (matcher2.find()) {
                        cVar.a(matcher2.group(1));
                        sb3.append(Pattern.quote(queryParameter.substring(i11, matcher2.start())));
                        sb3.append("(.+?)?");
                        i11 = matcher2.end();
                    }
                    if (i11 < queryParameter.length()) {
                        sb3.append(Pattern.quote(queryParameter.substring(i11)));
                    }
                    cVar.d(sb3.toString().replace(".*", "\\E.*\\Q"));
                    this.f3487b.put(str4, cVar);
                    i10 = 0;
                }
            } else {
                this.f3489d = a(str, sb2, compile);
            }
            this.f3488c = Pattern.compile(sb2.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str3 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
            b bVar = new b(str3);
            this.f3492g = Pattern.compile(("^(" + bVar.f3497a + "|[*]+)/(" + bVar.f3498b + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
    }

    private boolean a(String str, StringBuilder sb2, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z10 = !str.contains(".*");
        int i10 = 0;
        while (matcher.find()) {
            this.f3486a.add(matcher.group(1));
            sb2.append(Pattern.quote(str.substring(i10, matcher.start())));
            sb2.append("(.+?)");
            i10 = matcher.end();
            z10 = false;
        }
        if (i10 < str.length()) {
            sb2.append(Pattern.quote(str.substring(i10)));
        }
        sb2.append("($|(\\?(.)*))");
        return z10;
    }

    private boolean f(Bundle bundle, String str, String str2, e eVar) {
        if (eVar != null) {
            try {
                eVar.b().g(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }

    public String b() {
        return this.f3491f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c(Uri uri, Map<String, e> map) {
        Matcher matcher;
        Matcher matcher2 = this.f3488c.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f3486a.size();
        int i10 = 0;
        while (i10 < size) {
            String str = this.f3486a.get(i10);
            i10++;
            if (f(bundle, str, Uri.decode(matcher2.group(i10)), map.get(str))) {
                return null;
            }
        }
        if (this.f3490e) {
            for (String str2 : this.f3487b.keySet()) {
                c cVar = this.f3487b.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(cVar.c()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i11 = 0; i11 < cVar.e(); i11++) {
                    String decode = matcher != null ? Uri.decode(matcher.group(i11 + 1)) : null;
                    String b10 = cVar.b(i11);
                    e eVar = map.get(b10);
                    if (!(decode == null || decode.replaceAll("[{}]", "").equals(b10) || !f(bundle, b10, decode, eVar))) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(String str) {
        if (this.f3493h == null || !this.f3492g.matcher(str).matches()) {
            return -1;
        }
        return new b(this.f3493h).compareTo(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f3489d;
    }
}
