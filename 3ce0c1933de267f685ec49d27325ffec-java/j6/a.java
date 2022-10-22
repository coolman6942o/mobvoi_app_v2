package j6;

import android.content.Context;
import h6.n;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f29441a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f29442b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f29441a;
            if (context2 != null && (bool = f29442b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f29442b = null;
            if (n.i()) {
                f29442b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f29442b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f29442b = Boolean.FALSE;
                }
            }
            f29441a = applicationContext;
            return f29442b.booleanValue();
        }
    }
}
