package kotlin.text;

import io.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.h;
import kotlin.collections.k;
import kotlin.collections.n;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
import qo.p;
import vo.f;
import xo.e;
import xo.m;
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public class u extends t {

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z10) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z10;
        }

        public final Pair<Integer, Integer> a(CharSequence receiver, int i10) {
            i.f(receiver, "$receiver");
            int U = u.U(receiver, this.$delimiters, i10, this.$ignoreCase);
            if (U < 0) {
                return null;
            }
            return j.a(Integer.valueOf(U), 1);
        }

        @Override // qo.p
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, boolean z10) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z10;
        }

        public final Pair<Integer, Integer> a(CharSequence receiver, int i10) {
            i.f(receiver, "$receiver");
            Pair L = u.L(receiver, this.$delimitersList, i10, this.$ignoreCase, false);
            if (L != null) {
                return j.a(L.getFirst(), Integer.valueOf(((String) L.getSecond()).length()));
            }
            return null;
        }

        @Override // qo.p
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements l<vo.c, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        /* renamed from: a */
        public final String invoke(vo.c it) {
            i.f(it, "it");
            return u.t0(this.$this_splitToSequence, it);
        }
    }

    public static final String A0(String substringBefore, char c10, String missingDelimiterValue) {
        int S;
        i.f(substringBefore, "$this$substringBefore");
        i.f(missingDelimiterValue, "missingDelimiterValue");
        S = S(substringBefore, c10, 0, false, 6, null);
        if (S == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, S);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String B0(String substringBefore, String delimiter, String missingDelimiterValue) {
        int T;
        i.f(substringBefore, "$this$substringBefore");
        i.f(delimiter, "delimiter");
        i.f(missingDelimiterValue, "missingDelimiterValue");
        T = T(substringBefore, delimiter, 0, false, 6, null);
        if (T == -1) {
            return missingDelimiterValue;
        }
        String substring = substringBefore.substring(0, T);
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String C0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return A0(str, c10, str2);
    }

    public static /* synthetic */ String D0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return B0(str, str2, str3);
    }

    public static CharSequence E0(CharSequence trim) {
        i.f(trim, "$this$trim");
        int length = trim.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean c10 = kotlin.text.b.c(trim.charAt(!z10 ? i10 : length));
            if (!z10) {
                if (!c10) {
                    z10 = true;
                } else {
                    i10++;
                }
            } else if (!c10) {
                break;
            } else {
                length--;
            }
        }
        return trim.subSequence(i10, length + 1);
    }

    public static final boolean F(CharSequence contains, char c10, boolean z10) {
        int S;
        i.f(contains, "$this$contains");
        S = S(contains, c10, 0, z10, 2, null);
        return S >= 0;
    }

    public static boolean G(CharSequence contains, CharSequence other, boolean z10) {
        int T;
        i.f(contains, "$this$contains");
        i.f(other, "other");
        if (other instanceof String) {
            T = T(contains, (String) other, 0, z10, 2, null);
            if (T >= 0) {
                return true;
            }
        } else if (R(contains, other, 0, contains.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean H(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return F(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        boolean G;
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        G = G(charSequence, charSequence2, z10);
        return G;
    }

    public static final boolean J(CharSequence endsWith, CharSequence suffix, boolean z10) {
        boolean o10;
        i.f(endsWith, "$this$endsWith");
        i.f(suffix, "suffix");
        if (z10 || !(endsWith instanceof String) || !(suffix instanceof String)) {
            return g0(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), z10);
        }
        o10 = t.o((String) endsWith, (String) suffix, false, 2, null);
        return o10;
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return J(charSequence, charSequence2, z10);
    }

    public static final Pair<Integer, String> L(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        vo.a aVar;
        Object obj;
        Object obj2;
        int f10;
        int c10;
        if (z10 || collection.size() != 1) {
            if (!z11) {
                c10 = f.c(i10, 0);
                aVar = new vo.c(c10, charSequence.length());
            } else {
                f10 = f.f(i10, N(charSequence));
                aVar = f.i(f10, 0);
            }
            if (charSequence instanceof String) {
                int a10 = aVar.a();
                int b10 = aVar.b();
                int d10 = aVar.d();
                if (d10 < 0 ? a10 >= b10 : a10 <= b10) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (t.t(str, 0, (String) charSequence, a10, str.length(), z10)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (a10 == b10) {
                                break;
                            }
                            a10 += d10;
                        } else {
                            return j.a(Integer.valueOf(a10), str2);
                        }
                    }
                }
            } else {
                int a11 = aVar.a();
                int b11 = aVar.b();
                int d11 = aVar.d();
                if (d11 < 0 ? a11 >= b11 : a11 <= b11) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (g0(str3, 0, charSequence, a11, str3.length(), z10)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (a11 == b11) {
                                break;
                            }
                            a11 += d11;
                        } else {
                            return j.a(Integer.valueOf(a11), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) k.P(collection);
        int T = !z11 ? T(charSequence, str5, i10, false, 4, null) : Y(charSequence, str5, i10, false, 4, null);
        if (T < 0) {
            return null;
        }
        return j.a(Integer.valueOf(T), str5);
    }

    public static final vo.c M(CharSequence indices) {
        i.f(indices, "$this$indices");
        return new vo.c(0, indices.length() - 1);
    }

    public static final int N(CharSequence lastIndex) {
        i.f(lastIndex, "$this$lastIndex");
        return lastIndex.length() - 1;
    }

    public static final int O(CharSequence indexOf, char c10, int i10, boolean z10) {
        i.f(indexOf, "$this$indexOf");
        if (z10 || !(indexOf instanceof String)) {
            return U(indexOf, new char[]{c10}, i10, z10);
        }
        return ((String) indexOf).indexOf(c10, i10);
    }

    public static final int P(CharSequence indexOf, String string, int i10, boolean z10) {
        i.f(indexOf, "$this$indexOf");
        i.f(string, "string");
        if (z10 || !(indexOf instanceof String)) {
            return R(indexOf, string, i10, indexOf.length(), z10, false, 16, null);
        }
        return ((String) indexOf).indexOf(string, i10);
    }

    private static final int Q(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        vo.a aVar;
        int f10;
        int c10;
        int c11;
        int f11;
        if (!z11) {
            c11 = f.c(i10, 0);
            f11 = f.f(i11, charSequence.length());
            aVar = new vo.c(c11, f11);
        } else {
            f10 = f.f(i10, N(charSequence));
            c10 = f.c(i11, 0);
            aVar = f.i(f10, c10);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a10 = aVar.a();
            int b10 = aVar.b();
            int d10 = aVar.d();
            if (d10 >= 0) {
                if (a10 > b10) {
                    return -1;
                }
            } else if (a10 < b10) {
                return -1;
            }
            while (!g0(charSequence2, 0, charSequence, a10, charSequence2.length(), z10)) {
                if (a10 == b10) {
                    return -1;
                }
                a10 += d10;
            }
            return a10;
        }
        int a11 = aVar.a();
        int b11 = aVar.b();
        int d11 = aVar.d();
        if (d11 >= 0) {
            if (a11 > b11) {
                return -1;
            }
        } else if (a11 < b11) {
            return -1;
        }
        while (!t.t((String) charSequence2, 0, (String) charSequence, a11, charSequence2.length(), z10)) {
            if (a11 == b11) {
                return -1;
            }
            a11 += d11;
        }
        return a11;
    }

    static /* synthetic */ int R(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return Q(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static /* synthetic */ int S(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return O(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return P(charSequence, str, i10, z10);
    }

    public static final int U(CharSequence indexOfAny, char[] chars, int i10, boolean z10) {
        int c10;
        boolean z11;
        char y10;
        i.f(indexOfAny, "$this$indexOfAny");
        i.f(chars, "chars");
        if (z10 || chars.length != 1 || !(indexOfAny instanceof String)) {
            c10 = f.c(i10, 0);
            int N = N(indexOfAny);
            if (c10 > N) {
                return -1;
            }
            while (true) {
                char charAt = indexOfAny.charAt(c10);
                int length = chars.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z11 = false;
                        break;
                    } else if (kotlin.text.c.d(chars[i11], charAt, z10)) {
                        z11 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return c10;
                }
                if (c10 == N) {
                    return -1;
                }
                c10++;
            }
        } else {
            y10 = kotlin.collections.i.y(chars);
            return ((String) indexOfAny).indexOf(y10, i10);
        }
    }

    public static final int V(CharSequence lastIndexOf, char c10, int i10, boolean z10) {
        i.f(lastIndexOf, "$this$lastIndexOf");
        if (z10 || !(lastIndexOf instanceof String)) {
            return Z(lastIndexOf, new char[]{c10}, i10, z10);
        }
        return ((String) lastIndexOf).lastIndexOf(c10, i10);
    }

    public static final int W(CharSequence lastIndexOf, String string, int i10, boolean z10) {
        i.f(lastIndexOf, "$this$lastIndexOf");
        i.f(string, "string");
        if (z10 || !(lastIndexOf instanceof String)) {
            return Q(lastIndexOf, string, i10, 0, z10, true);
        }
        return ((String) lastIndexOf).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int X(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = N(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return V(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = N(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return W(charSequence, str, i10, z10);
    }

    public static final int Z(CharSequence lastIndexOfAny, char[] chars, int i10, boolean z10) {
        int f10;
        char y10;
        i.f(lastIndexOfAny, "$this$lastIndexOfAny");
        i.f(chars, "chars");
        if (z10 || chars.length != 1 || !(lastIndexOfAny instanceof String)) {
            for (f10 = f.f(i10, N(lastIndexOfAny)); f10 >= 0; f10--) {
                char charAt = lastIndexOfAny.charAt(f10);
                int length = chars.length;
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (kotlin.text.c.d(chars[i11], charAt, z10)) {
                        z11 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return f10;
                }
            }
            return -1;
        }
        y10 = kotlin.collections.i.y(chars);
        return ((String) lastIndexOfAny).lastIndexOf(y10, i10);
    }

    public static final e<String> a0(CharSequence lineSequence) {
        i.f(lineSequence, "$this$lineSequence");
        return q0(lineSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> b0(CharSequence lines) {
        List<String> m10;
        i.f(lines, "$this$lines");
        m10 = m.m(a0(lines));
        return m10;
    }

    private static final e<vo.c> c0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11) {
        j0(i11);
        return new e(charSequence, i10, i11, new a(cArr, z10));
    }

    private static final e<vo.c> d0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        List b10;
        j0(i11);
        b10 = h.b(strArr);
        return new e(charSequence, i10, i11, new b(b10, z10));
    }

    static /* synthetic */ e e0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return c0(charSequence, cArr, i10, z10, i11);
    }

    static /* synthetic */ e f0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return d0(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean g0(CharSequence regionMatchesImpl, int i10, CharSequence other, int i11, int i12, boolean z10) {
        i.f(regionMatchesImpl, "$this$regionMatchesImpl");
        i.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > regionMatchesImpl.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!kotlin.text.c.d(regionMatchesImpl.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String h0(String removePrefix, CharSequence prefix) {
        i.f(removePrefix, "$this$removePrefix");
        i.f(prefix, "prefix");
        if (!s0(removePrefix, prefix, false, 2, null)) {
            return removePrefix;
        }
        String substring = removePrefix.substring(prefix.length());
        i.e(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static String i0(String removeSuffix, CharSequence suffix) {
        i.f(removeSuffix, "$this$removeSuffix");
        i.f(suffix, "suffix");
        if (!K(removeSuffix, suffix, false, 2, null)) {
            return removeSuffix;
        }
        String substring = removeSuffix.substring(0, removeSuffix.length() - suffix.length());
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final void j0(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
        }
    }

    public static final List<String> k0(CharSequence split, char[] delimiters, boolean z10, int i10) {
        Iterable<vo.c> f10;
        int p10;
        i.f(split, "$this$split");
        i.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return m0(split, String.valueOf(delimiters[0]), z10, i10);
        }
        f10 = m.f(e0(split, delimiters, 0, z10, i10, 2, null));
        p10 = n.p(f10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (vo.c cVar : f10) {
            arrayList.add(t0(split, cVar));
        }
        return arrayList;
    }

    public static final List<String> l0(CharSequence split, String[] delimiters, boolean z10, int i10) {
        Iterable<vo.c> f10;
        int p10;
        i.f(split, "$this$split");
        i.f(delimiters, "delimiters");
        boolean z11 = true;
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                z11 = false;
            }
            if (!z11) {
                return m0(split, str, z10, i10);
            }
        }
        f10 = m.f(f0(split, delimiters, 0, z10, i10, 2, null));
        p10 = n.p(f10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (vo.c cVar : f10) {
            arrayList.add(t0(split, cVar));
        }
        return arrayList;
    }

    private static final List<String> m0(CharSequence charSequence, String str, boolean z10, int i10) {
        List<String> b10;
        j0(i10);
        int i11 = 0;
        int P = P(charSequence, str, 0, z10);
        if (P == -1 || i10 == 1) {
            b10 = kotlin.collections.l.b(charSequence.toString());
            return b10;
        }
        boolean z11 = i10 > 0;
        int i12 = 10;
        if (z11) {
            i12 = f.f(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i12);
        do {
            arrayList.add(charSequence.subSequence(i11, P).toString());
            i11 = str.length() + P;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            P = P(charSequence, str, i11, z10);
        } while (P != -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List n0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return k0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List o0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return l0(charSequence, strArr, z10, i10);
    }

    public static final e<String> p0(CharSequence splitToSequence, String[] delimiters, boolean z10, int i10) {
        e<String> k10;
        i.f(splitToSequence, "$this$splitToSequence");
        i.f(delimiters, "delimiters");
        k10 = m.k(f0(splitToSequence, delimiters, 0, z10, i10, 2, null), new c(splitToSequence));
        return k10;
    }

    public static /* synthetic */ e q0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return p0(charSequence, strArr, z10, i10);
    }

    public static final boolean r0(CharSequence startsWith, CharSequence prefix, boolean z10) {
        boolean D;
        i.f(startsWith, "$this$startsWith");
        i.f(prefix, "prefix");
        if (z10 || !(startsWith instanceof String) || !(prefix instanceof String)) {
            return g0(startsWith, 0, prefix, 0, prefix.length(), z10);
        }
        D = t.D((String) startsWith, (String) prefix, false, 2, null);
        return D;
    }

    public static /* synthetic */ boolean s0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r0(charSequence, charSequence2, z10);
    }

    public static final String t0(CharSequence substring, vo.c range) {
        i.f(substring, "$this$substring");
        i.f(range, "range");
        return substring.subSequence(range.h().intValue(), range.g().intValue() + 1).toString();
    }

    public static final String u0(String substringAfter, char c10, String missingDelimiterValue) {
        int S;
        i.f(substringAfter, "$this$substringAfter");
        i.f(missingDelimiterValue, "missingDelimiterValue");
        S = S(substringAfter, c10, 0, false, 6, null);
        if (S == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(S + 1, substringAfter.length());
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String v0(String substringAfter, String delimiter, String missingDelimiterValue) {
        int T;
        i.f(substringAfter, "$this$substringAfter");
        i.f(delimiter, "delimiter");
        i.f(missingDelimiterValue, "missingDelimiterValue");
        T = T(substringAfter, delimiter, 0, false, 6, null);
        if (T == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfter.substring(T + delimiter.length(), substringAfter.length());
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String w0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return u0(str, c10, str2);
    }

    public static /* synthetic */ String x0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return v0(str, str2, str3);
    }

    public static final String y0(String substringAfterLast, char c10, String missingDelimiterValue) {
        int X;
        i.f(substringAfterLast, "$this$substringAfterLast");
        i.f(missingDelimiterValue, "missingDelimiterValue");
        X = X(substringAfterLast, c10, 0, false, 6, null);
        if (X == -1) {
            return missingDelimiterValue;
        }
        String substring = substringAfterLast.substring(X + 1, substringAfterLast.length());
        i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String z0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return y0(str, c10, str2);
    }
}
