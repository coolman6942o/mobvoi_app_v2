package wk;

import al.c;
import android.content.Context;
import android.os.Build;
import bl.a;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f36298a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f36299b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f36300c = false;

    public static synchronized void a(Context context, a aVar) {
        String str;
        synchronized (b.class) {
            if (f36298a == null) {
                f36298a = context.getApplicationContext();
            }
            f36299b = aVar.c();
            il.b.i(aVar.b(), aVar.d(), aVar.a());
            il.b.c(aVar.toString());
            if (c.k() == null) {
                c.l(f36298a);
            }
            if (a.b() == null) {
                a.c(f36298a);
            }
            al.b.i(f36298a);
            il.b.j(String.format("%s:%s:%s", "com.realsil.sdk", "rtk-core", "1.2.9"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DeviceInfo{");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SDK_INT: ");
            int i10 = Build.VERSION.SDK_INT;
            sb3.append(i10);
            sb2.append(sb3.toString());
            sb2.append("\nDevice name: " + Build.DEVICE);
            sb2.append("\nAndroid Version: " + Build.VERSION.RELEASE);
            sb2.append("\nManufacture: " + Build.MANUFACTURER);
            sb2.append("\nModel: " + Build.MODEL);
            if (i10 >= 21) {
                str = "\nsupportedABIS: " + Arrays.toString(Build.SUPPORTED_ABIS);
            } else {
                str = "\ncupABI: " + Build.CPU_ABI;
            }
            sb2.append(str);
            sb2.append("}");
            il.b.c(sb2.toString());
        }
    }
}
