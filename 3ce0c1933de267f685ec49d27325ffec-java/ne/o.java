package ne;

import java.util.regex.Pattern;
/* compiled from: FeedbackHelper.java */
/* loaded from: classes2.dex */
public class o {
    public static boolean a(String str) {
        try {
            return Pattern.compile("^\\s*?(.+)@(.+?)\\s*$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            return Pattern.compile("^1\\d{10}$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }
}
