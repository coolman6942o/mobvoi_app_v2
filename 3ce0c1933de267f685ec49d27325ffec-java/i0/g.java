package i0;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f28010a = new Locale("", "");

    private static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f28010a)) {
            return 0;
        }
        String c10 = c.c(locale);
        if (c10 == null) {
            return a(locale);
        }
        return (c10.equalsIgnoreCase("Arab") || c10.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
