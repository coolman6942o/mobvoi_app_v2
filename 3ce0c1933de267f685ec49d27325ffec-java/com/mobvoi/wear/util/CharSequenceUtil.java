package com.mobvoi.wear.util;

import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class CharSequenceUtil {
    public static String charSequenceToHtml(CharSequence charSequence) {
        return charSequenceToHtml(charSequence, null);
    }

    public static CharSequence htmlToCharSequence(String str) {
        if (str == null) {
            return null;
        }
        return trimTrailingWhitespace(Html.fromHtml(str));
    }

    private static CharSequence trimTrailingWhitespace(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        int length = charSequence.length();
        while (length > 0 && Character.isWhitespace(charSequence.charAt(length - 1))) {
            length--;
        }
        return charSequence.subSequence(0, length);
    }

    public static String charSequenceToHtml(CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(charSequence)) {
            return str;
        }
        if (charSequence instanceof SpannableString) {
            return Html.toHtml((SpannableString) charSequence).toString();
        }
        if (!(charSequence instanceof String)) {
            return charSequence.toString();
        }
        String[] split = ((String) charSequence).split("\\r?\\n");
        if (split.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < split.length - 1; i10++) {
            sb2.append(Html.escapeHtml(split[i10]));
            sb2.append("<br>");
        }
        sb2.append(Html.escapeHtml(split[split.length - 1]));
        return sb2.toString();
    }
}
