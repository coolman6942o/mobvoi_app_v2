package jl;

import android.text.TextUtils;
import java.io.File;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {
    public static boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e10) {
            il.b.e(e10.getMessage());
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(".")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1).toLowerCase(Locale.US) : "";
    }
}
