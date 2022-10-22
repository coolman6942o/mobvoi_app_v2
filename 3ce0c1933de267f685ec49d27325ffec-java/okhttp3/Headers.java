package okhttp3;

import io.j;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import jp.c;
import kotlin.Pair;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.text.t;
import kotlin.text.u;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import vo.d;
/* compiled from: Headers.kt */
/* loaded from: classes3.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, ro.a {
    public static final b Companion = new b(null);
    private final String[] namesAndValues;

    /* compiled from: Headers.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f31731a = new ArrayList(20);

        public final a a(String line) {
            int S;
            CharSequence E0;
            i.f(line, "line");
            S = u.S(line, ':', 0, false, 6, null);
            if (S != -1) {
                String substring = line.substring(0, S);
                i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type kotlin.CharSequence");
                E0 = u.E0(substring);
                String obj = E0.toString();
                String substring2 = line.substring(S + 1);
                i.e(substring2, "(this as java.lang.String).substring(startIndex)");
                b(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(("Unexpected header: " + line).toString());
        }

        public final a b(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            b bVar = Headers.Companion;
            bVar.d(name);
            bVar.e(value, name);
            d(name, value);
            return this;
        }

        public final a c(String line) {
            int S;
            i.f(line, "line");
            S = u.S(line, ':', 1, false, 4, null);
            if (S != -1) {
                String substring = line.substring(0, S);
                i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(S + 1);
                i.e(substring2, "(this as java.lang.String).substring(startIndex)");
                d(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                i.e(substring3, "(this as java.lang.String).substring(startIndex)");
                d("", substring3);
            } else {
                d("", line);
            }
            return this;
        }

        public final a d(String name, String value) {
            CharSequence E0;
            i.f(name, "name");
            i.f(value, "value");
            this.f31731a.add(name);
            List<String> list = this.f31731a;
            E0 = u.E0(value);
            list.add(E0.toString());
            return this;
        }

        public final a e(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            Headers.Companion.d(name);
            d(name, value);
            return this;
        }

        public final Headers f() {
            Object[] array = this.f31731a.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new Headers((String[]) array, null);
        }

        /* JADX WARN: Incorrect condition in loop: B:7:0x0036 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String g(String name) {
            boolean p10;
            i.f(name, "name");
            vo.a j10 = d.j(d.i(this.f31731a.size() - 2, 0), 2);
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
            return this.f31731a.get(a10 + 1);
        }

        public final List<String> h() {
            return this.f31731a;
        }

        public final a i(String name) {
            boolean p10;
            i.f(name, "name");
            int i10 = 0;
            while (i10 < this.f31731a.size()) {
                p10 = t.p(name, this.f31731a.get(i10), true);
                if (p10) {
                    this.f31731a.remove(i10);
                    this.f31731a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public final a j(String name, String value) {
            i.f(name, "name");
            i.f(value, "value");
            b bVar = Headers.Companion;
            bVar.d(name);
            bVar.e(value, name);
            i(name);
            d(name, value);
            return this;
        }
    }

    /* compiled from: Headers.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (str.length() > 0) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char charAt = str.charAt(i10);
                    if (!('!' <= charAt && '~' >= charAt)) {
                        throw new IllegalArgumentException(gp.b.q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    throw new IllegalArgumentException(gp.b.q("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str2, str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Incorrect condition in loop: B:7:0x0026 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String f(String[] strArr, String str) {
            boolean p10;
            vo.a j10 = d.j(d.i(strArr.length - 2, 0), 2);
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
            return strArr[a10 + 1];
        }

        public final Headers g(Map<String, String> toHeaders) {
            CharSequence E0;
            CharSequence E02;
            i.f(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i10 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.CharSequence");
                E0 = u.E0(key);
                String obj = E0.toString();
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.CharSequence");
                E02 = u.E0(value);
                String obj2 = E02.toString();
                d(obj);
                e(obj2, obj);
                strArr[i10] = obj;
                strArr[i10 + 1] = obj2;
                i10 += 2;
            }
            return new Headers(strArr, null);
        }

        public final Headers h(String... namesAndValues) {
            CharSequence E0;
            i.f(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                Object clone = namesAndValues.clone();
                Objects.requireNonNull(clone, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                String[] strArr = (String[]) clone;
                int length = strArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    if (strArr[i10] != null) {
                        String str = strArr[i10];
                        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                        E0 = u.E0(str);
                        strArr[i10] = E0.toString();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                vo.a j10 = d.j(d.k(0, strArr.length), 2);
                int a10 = j10.a();
                int b10 = j10.b();
                int d10 = j10.d();
                if (d10 < 0 ? a10 >= b10 : a10 <= b10) {
                    while (true) {
                        String str2 = strArr[a10];
                        String str3 = strArr[a10 + 1];
                        d(str2);
                        e(str3, str2);
                        if (a10 == b10) {
                            break;
                        }
                        a10 += d10;
                    }
                }
                return new Headers(strArr, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.g(map);
    }

    public static final Headers of(String... strArr) {
        return Companion.h(strArr);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m37deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String name) {
        i.f(name, "name");
        return Companion.f(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        i.f(name, "name");
        String str = get(name);
        if (str != null) {
            return c.a(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String name) {
        i.f(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = j.a(name(i10), value(i10));
        }
        return kotlin.jvm.internal.b.a(pairArr);
    }

    public final String name(int i10) {
        return this.namesAndValues[i10 * 2];
    }

    public final Set<String> names() {
        Comparator<String> r10;
        r10 = t.r(n.f30086a);
        TreeSet treeSet = new TreeSet(r10);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        i.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final a newBuilder() {
        a aVar = new a();
        r.t(aVar.h(), this.namesAndValues);
        return aVar;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        Comparator<String> r10;
        r10 = t.r(n.f30086a);
        TreeMap treeMap = new TreeMap(r10);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = name(i10);
            Locale locale = Locale.US;
            i.e(locale, "Locale.US");
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = name.toLowerCase(locale);
            i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i10));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append(name(i10));
            sb2.append(": ");
            sb2.append(value(i10));
            sb2.append("\n");
        }
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String value(int i10) {
        return this.namesAndValues[(i10 * 2) + 1];
    }

    public final List<String> values(String name) {
        List<String> g10;
        boolean p10;
        i.f(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            p10 = t.p(name, name(i10), true);
            if (p10) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            i.e(unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }
        g10 = m.g();
        return g10;
    }

    public /* synthetic */ Headers(String[] strArr, f fVar) {
        this(strArr);
    }
}
