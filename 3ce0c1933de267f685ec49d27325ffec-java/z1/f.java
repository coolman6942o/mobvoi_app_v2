package z1;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.a;
import androidx.work.k;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: ProcessUtils.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f37221a = k.f("ProcessUtils");

    private f() {
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object obj;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return Application.getProcessName();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread", false, f.class.getClassLoader());
            if (i10 >= 18) {
                Method declaredMethod = cls.getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(null, new Object[0]);
            } else {
                Method declaredMethod2 = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("getProcessName", new Class[0]);
                declaredMethod3.setAccessible(true);
                obj = declaredMethod3.invoke(declaredMethod2.invoke(null, new Object[0]), new Object[0]);
            }
            if (obj instanceof String) {
                return (String) obj;
            }
        } catch (Throwable th2) {
            k.c().a(f37221a, "Unable to check ActivityThread for processName", th2);
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.isEmpty())) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean b(Context context, a aVar) {
        String a10 = a(context);
        if (!TextUtils.isEmpty(aVar.c())) {
            return TextUtils.equals(a10, aVar.c());
        }
        return TextUtils.equals(a10, context.getApplicationInfo().processName);
    }
}
