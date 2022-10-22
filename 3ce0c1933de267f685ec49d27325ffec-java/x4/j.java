package x4;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<i>> f36386b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Map<String, String> f36387c;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        private static final String f36388b;

        /* renamed from: c  reason: collision with root package name */
        private static final Map<String, List<i>> f36389c;

        /* renamed from: a  reason: collision with root package name */
        private Map<String, List<i>> f36390a = f36389c;

        static {
            String b10 = b();
            f36388b = b10;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b10)));
            }
            f36389c = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb2.append(charAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        public j a() {
            return new j(this.f36390a);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f36391a;

        b(String str) {
            this.f36391a = str;
        }

        @Override // x4.i
        public String a() {
            return this.f36391a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f36391a.equals(((b) obj).f36391a);
            }
            return false;
        }

        public int hashCode() {
            return this.f36391a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f36391a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f36386b = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String a10 = list.get(i10).a();
            if (!TextUtils.isEmpty(a10)) {
                sb2.append(a10);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f36386b.entrySet()) {
            String b10 = b(entry.getValue());
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put(entry.getKey(), b10);
            }
        }
        return hashMap;
    }

    @Override // x4.h
    public Map<String, String> a() {
        if (this.f36387c == null) {
            synchronized (this) {
                if (this.f36387c == null) {
                    this.f36387c = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f36387c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f36386b.equals(((j) obj).f36386b);
        }
        return false;
    }

    public int hashCode() {
        return this.f36386b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f36386b + '}';
    }
}
