package com.mobvoi.android.common.utils;
/* compiled from: StringUtils.java */
/* loaded from: classes2.dex */
public class r {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean c(char c10) {
        return c10 == 0 || c10 == '\t' || c10 == '\n' || c10 == '\r' || (c10 >= ' ' && c10 <= 55295) || ((c10 >= 57344 && c10 <= 65533) || (c10 >= 0 && c10 <= 65535));
    }
}
