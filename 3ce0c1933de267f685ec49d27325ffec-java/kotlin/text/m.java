package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.k;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
public class m extends l {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements l<String, String> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String line) {
            i.f(line, "line");
            return line;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements l<String, String> {
        final /* synthetic */ String $indent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$indent = str;
        }

        /* renamed from: a */
        public final String invoke(String line) {
            i.f(line, "line");
            return this.$indent + line;
        }
    }

    private static final l<String, String> b(String str) {
        return str.length() == 0 ? a.INSTANCE : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (!kotlin.text.b.c(str.charAt(i10))) {
                break;
            } else {
                i10++;
            }
        }
        return i10 == -1 ? str.length() : i10;
    }

    public static final String d(String replaceIndent, String newIndent) {
        String str;
        String invoke;
        i.f(replaceIndent, "$this$replaceIndent");
        i.f(newIndent, "newIndent");
        List<String> b02 = u.b0(replaceIndent);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : b02) {
            if (!k.s((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(k.p(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str2)));
        }
        Integer num = (Integer) k.M(arrayList2);
        int i10 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = replaceIndent.length() + (newIndent.length() * b02.size());
        l<String, String> b10 = b(newIndent);
        int i11 = k.i(b02);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : b02) {
            i10++;
            if (i10 < 0) {
                k.o();
            }
            String str3 = (String) obj2;
            if ((i10 == 0 || i10 == i11) && k.s(str3)) {
                str = null;
            } else {
                String F0 = w.F0(str3, intValue);
                if (!(F0 == null || (invoke = b10.invoke(F0)) == null)) {
                    str3 = invoke;
                }
                str = str3;
            }
            if (str != null) {
                arrayList3.add(str);
            }
        }
        String sb2 = ((StringBuilder) k.I(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        i.e(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static final String e(String replaceIndentByMargin, String newIndent, String marginPrefix) {
        int i10;
        String invoke;
        i.f(replaceIndentByMargin, "$this$replaceIndentByMargin");
        i.f(newIndent, "newIndent");
        i.f(marginPrefix, "marginPrefix");
        if (!k.s(marginPrefix)) {
            List<String> b02 = u.b0(replaceIndentByMargin);
            int length = replaceIndentByMargin.length() + (newIndent.length() * b02.size());
            l<String, String> b10 = b(newIndent);
            int i11 = k.i(b02);
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            for (Object obj : b02) {
                i12++;
                if (i12 < 0) {
                    k.o();
                }
                String str = (String) obj;
                String str2 = null;
                if (!(i12 == 0 || i12 == i11) || !k.s(str)) {
                    int length2 = str.length();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length2) {
                            i10 = -1;
                            break;
                        } else if (!kotlin.text.b.c(str.charAt(i13))) {
                            i10 = i13;
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (i10 != -1) {
                        int i14 = i10;
                        if (k.C(str, marginPrefix, i10, false, 4, null)) {
                            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                            str2 = str.substring(i14 + marginPrefix.length());
                            i.e(str2, "(this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (!(str2 == null || (invoke = b10.invoke(str2)) == null)) {
                        str = invoke;
                    }
                    str2 = str;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
            }
            String sb2 = ((StringBuilder) k.I(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            i.e(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String trimIndent) {
        i.f(trimIndent, "$this$trimIndent");
        return d(trimIndent, "");
    }

    public static final String g(String trimMargin, String marginPrefix) {
        i.f(trimMargin, "$this$trimMargin");
        i.f(marginPrefix, "marginPrefix");
        return e(trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
