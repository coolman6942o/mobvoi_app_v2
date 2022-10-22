package h6;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class o {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static boolean a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
