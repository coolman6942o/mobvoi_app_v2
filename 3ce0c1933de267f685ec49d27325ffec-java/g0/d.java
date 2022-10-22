package g0;

import android.content.res.Configuration;
import android.os.Build;
/* compiled from: ConfigurationCompat.java */
/* loaded from: classes.dex */
public final class d {
    public static f a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? f.e(configuration.getLocales()) : f.a(configuration.locale);
    }
}
