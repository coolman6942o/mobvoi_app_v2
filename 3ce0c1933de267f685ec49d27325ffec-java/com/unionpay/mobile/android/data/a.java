package com.unionpay.mobile.android.data;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.unionpay.mobile.android.utils.i;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, Integer> f23309a = new HashMap<>();

    public static SpannableString a(String str, String str2) {
        String[] split;
        SpannableString spannableString = new SpannableString(str);
        int i10 = -10066330;
        spannableString.setSpan(new ForegroundColorSpan(-10066330), 0, str.length(), 33);
        if (str2 == null) {
            return spannableString;
        }
        for (String str3 : str2.split(";")) {
            if (a(str3)) {
                break;
            }
            try {
                i10 = Color.parseColor("#" + str3);
            } catch (Exception unused) {
            }
        }
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, str.length(), 33);
        return spannableString;
    }

    public static final boolean a(String str) {
        if (i.b(str)) {
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
