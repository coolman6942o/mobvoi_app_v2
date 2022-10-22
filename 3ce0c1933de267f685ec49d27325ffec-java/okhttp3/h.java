package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.i;
/* compiled from: Challenge.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f31851a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31852b;

    public h(String scheme, Map<String, String> authParams) {
        String str;
        i.f(scheme, "scheme");
        i.f(authParams, "authParams");
        this.f31852b = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                i.e(US, "US");
                str = key.toLowerCase(US);
                i.e(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.e(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f31851a = unmodifiableMap;
    }

    public final Charset a() {
        String str = this.f31851a.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                i.e(forName, "Charset.forName(charset)");
                return forName;
            } catch (Exception unused) {
            }
        }
        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
        i.e(ISO_8859_1, "ISO_8859_1");
        return ISO_8859_1;
    }

    public final String b() {
        return this.f31851a.get("realm");
    }

    public final String c() {
        return this.f31852b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (i.b(hVar.f31852b, this.f31852b) && i.b(hVar.f31851a, this.f31851a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f31852b.hashCode()) * 31) + this.f31851a.hashCode();
    }

    public String toString() {
        return this.f31852b + " authParams=" + this.f31851a;
    }
}
