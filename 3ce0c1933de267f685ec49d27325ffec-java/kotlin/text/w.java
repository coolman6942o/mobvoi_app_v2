package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.i;
import vo.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
/* loaded from: classes3.dex */
public class w extends v {
    public static final String F0(String drop, int i10) {
        int f10;
        i.f(drop, "$this$drop");
        if (i10 >= 0) {
            f10 = f.f(i10, drop.length());
            String substring = drop.substring(f10);
            i.e(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char G0(CharSequence first) {
        i.f(first, "$this$first");
        if (!(first.length() == 0)) {
            return first.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String H0(String take, int i10) {
        int f10;
        i.f(take, "$this$take");
        if (i10 >= 0) {
            f10 = f.f(i10, take.length());
            String substring = take.substring(0, f10);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}
