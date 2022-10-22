package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.y;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import vo.c;
import vo.f;
/* compiled from: StringsJVM.kt */
/* loaded from: classes3.dex */
public class t extends s {
    public static boolean A(String startsWith, String prefix, int i10, boolean z10) {
        i.f(startsWith, "$this$startsWith");
        i.f(prefix, "prefix");
        if (!z10) {
            return startsWith.startsWith(prefix, i10);
        }
        return t(startsWith, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean B(String startsWith, String prefix, boolean z10) {
        i.f(startsWith, "$this$startsWith");
        i.f(prefix, "prefix");
        if (!z10) {
            return startsWith.startsWith(prefix);
        }
        return t(startsWith, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean C(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        boolean A;
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        A = A(str, str2, i10, z10);
        return A;
    }

    public static /* synthetic */ boolean D(String str, String str2, boolean z10, int i10, Object obj) {
        boolean B;
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        B = B(str, str2, z10);
        return B;
    }

    public static String m(byte[] decodeToString) {
        i.f(decodeToString, "$this$decodeToString");
        return new String(decodeToString, d.f30092a);
    }

    public static final boolean n(String endsWith, String suffix, boolean z10) {
        i.f(endsWith, "$this$endsWith");
        i.f(suffix, "suffix");
        if (!z10) {
            return endsWith.endsWith(suffix);
        }
        return t(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return n(str, str2, z10);
    }

    public static boolean p(String str, String str2, boolean z10) {
        if (str == null) {
            return str2 == null;
        }
        if (!z10) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean q(String str, String str2, boolean z10, int i10, Object obj) {
        boolean p10;
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        p10 = p(str, str2, z10);
        return p10;
    }

    public static Comparator<String> r(n CASE_INSENSITIVE_ORDER) {
        i.f(CASE_INSENSITIVE_ORDER, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        i.e(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static boolean s(CharSequence isBlank) {
        boolean z10;
        i.f(isBlank, "$this$isBlank");
        if (isBlank.length() != 0) {
            c M = u.M(isBlank);
            if (!(M instanceof Collection) || !((Collection) M).isEmpty()) {
                Iterator<Integer> it = M.iterator();
                while (it.hasNext()) {
                    if (!b.c(isBlank.charAt(((y) it).b()))) {
                        z10 = false;
                        break;
                    }
                }
            }
            z10 = true;
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    public static final boolean t(String regionMatches, int i10, String other, int i11, int i12, boolean z10) {
        i.f(regionMatches, "$this$regionMatches");
        i.f(other, "other");
        if (!z10) {
            return regionMatches.regionMatches(i10, other, i11, i12);
        }
        return regionMatches.regionMatches(z10, i10, other, i11, i12);
    }

    public static /* synthetic */ boolean u(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return t(str, i10, str2, i11, i12, z10);
    }

    public static String v(CharSequence repeat, int i10) {
        i.f(repeat, "$this$repeat");
        int i11 = 1;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        } else if (i10 == 0) {
            return "";
        } else {
            if (i10 == 1) {
                return repeat.toString();
            }
            int length = repeat.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(repeat.length() * i10);
                if (1 <= i10) {
                    while (true) {
                        sb2.append(repeat);
                        if (i11 == i10) {
                            break;
                        }
                        i11++;
                    }
                }
                String sb3 = sb2.toString();
                i.e(sb3, "sb.toString()");
                return sb3;
            }
            char charAt = repeat.charAt(0);
            char[] cArr = new char[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                cArr[i12] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String w(String replace, char c10, char c11, boolean z10) {
        i.f(replace, "$this$replace");
        if (!z10) {
            String replace2 = replace.replace(c10, c11);
            i.e(replace2, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace2;
        }
        StringBuilder sb2 = new StringBuilder(replace.length());
        for (int i10 = 0; i10 < replace.length(); i10++) {
            char charAt = replace.charAt(i10);
            if (c.d(charAt, c10, z10)) {
                charAt = c11;
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public static final String x(String replace, String oldValue, String newValue, boolean z10) {
        int c10;
        i.f(replace, "$this$replace");
        i.f(oldValue, "oldValue");
        i.f(newValue, "newValue");
        int i10 = 0;
        int P = u.P(replace, oldValue, 0, z10);
        if (P < 0) {
            return replace;
        }
        int length = oldValue.length();
        c10 = f.c(length, 1);
        int length2 = (replace.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append((CharSequence) replace, i10, P);
                sb2.append(newValue);
                i10 = P + length;
                if (P >= replace.length()) {
                    break;
                }
                P = u.P(replace, oldValue, P + c10, z10);
            } while (P > 0);
            sb2.append((CharSequence) replace, i10, replace.length());
            String sb3 = sb2.toString();
            i.e(sb3, "stringBuilder.append(this, i, length).toString()");
            return sb3;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String y(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return w(str, c10, c11, z10);
    }

    public static /* synthetic */ String z(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return x(str, str2, str3, z10);
    }
}
