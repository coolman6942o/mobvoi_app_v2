package lk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: PermissionCompatUtils.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f30497a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f30498b;

    /* compiled from: PermissionCompatUtils.java */
    /* renamed from: lk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0384a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f30499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f30500b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f30501c;

        RunnableC0384a(String[] strArr, Activity activity, int i10) {
            this.f30499a = strArr;
            this.f30500b = activity;
            this.f30501c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f30499a.length];
            PackageManager packageManager = this.f30500b.getPackageManager();
            String packageName = this.f30500b.getPackageName();
            int length = this.f30499a.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f30499a[i10], packageName);
            }
            ((b) this.f30500b).onRequestPermissionsResult(this.f30501c, this.f30499a, iArr);
        }
    }

    /* compiled from: PermissionCompatUtils.java */
    /* loaded from: classes2.dex */
    public interface b {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private static void b() {
        if (f30497a == null) {
            try {
                f30497a = Activity.class.getMethod("shouldShowRequestPermissionRationale", String.class);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }
        if (f30498b == null) {
            try {
                f30498b = Activity.class.getMethod("requestPermissions", String[].class, Integer.TYPE);
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void c(Activity activity, String[] strArr, int i10) {
        b();
        Method method = f30498b;
        if (method != null) {
            try {
                method.invoke(activity, strArr, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0384a(strArr, activity, i10));
        }
    }

    public static boolean d(Activity activity, String str) {
        b();
        Method method = f30497a;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(activity, str)).booleanValue();
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }
}
