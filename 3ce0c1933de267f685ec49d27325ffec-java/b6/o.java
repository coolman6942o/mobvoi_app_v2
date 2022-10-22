package b6;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import j6.c;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5073a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5074b;

    /* renamed from: c  reason: collision with root package name */
    private static String f5075c;

    /* renamed from: d  reason: collision with root package name */
    private static int f5076d;

    public static String a(Context context) {
        c(context);
        return f5075c;
    }

    public static int b(Context context) {
        c(context);
        return f5076d;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (f5073a) {
            if (!f5074b) {
                f5074b = true;
                try {
                    bundle = c.a(context).b(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e10) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e10);
                }
                if (bundle != null) {
                    f5075c = bundle.getString("com.google.app.id");
                    f5076d = bundle.getInt("com.google.android.gms.version");
                }
            }
        }
    }
}
