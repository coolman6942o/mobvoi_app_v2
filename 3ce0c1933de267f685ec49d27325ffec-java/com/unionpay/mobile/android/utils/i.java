package com.unionpay.mobile.android.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
/* loaded from: classes2.dex */
public final class i {
    public static SpannableString a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!b(str)) {
            str5 = str5 + str;
        }
        if (!b(str3)) {
            str5 = str5 + str3;
        }
        if (!b(str4)) {
            str5 = str5 + str4;
        }
        SpannableString spannableString = new SpannableString(str5);
        int length = b(str) ? 0 : str.length();
        int length2 = (b(str3) ? 0 : str3.length()) + length;
        spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, str5.length(), 33);
        if (!b(str2)) {
            if (str2.length() == 6 || !c(str2)) {
                str2 = "#" + str2;
            }
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), length, length2, 33);
        }
        return spannableString;
    }

    public static final String a(String str) {
        return (str == null || str.length() <= 2) ? "" : str.substring(1, str.length() - 1);
    }

    public static final boolean b(String str) {
        return str == null || str.length() == 0;
    }

    private static final boolean c(String str) {
        if (b(str)) {
            return false;
        }
        String[] strArr = {"black", "darkgray", "gray", "lightgray", "white", "red", "green", "blue", "yellow", "cyan", "magenta"};
        for (int i10 = 0; i10 < 11; i10++) {
            if (strArr[i10].equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
