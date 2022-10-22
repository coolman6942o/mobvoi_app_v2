package com.mobvoi.wear.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class PermissionCompat {
    public static final String ACTION_REQUEST_PERMISSIONS = "android.content.pm.action.REQUEST_PERMISSIONS";
    public static final String EXTRA_REQUEST_PERMISSIONS_NAMES = "android.content.pm.extra.REQUEST_PERMISSIONS_NAMES";
    public static final String EXTRA_REQUEST_PERMISSIONS_RESULTS = "android.content.pm.extra.REQUEST_PERMISSIONS_RESULTS";
    private static Method sMethod_Activity_RequestPermissions;
    private static Method sMethod_Activity_ShouldShowRequestPermissionRationale;
    private static Method sMethod_Fragment_RequestPermissions;
    private static Method sMethod_Fragment_ShouldShowRequestPermissionRationale;

    /* loaded from: classes2.dex */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    private static void getActivityMethod() {
        if (sMethod_Activity_ShouldShowRequestPermissionRationale == null) {
            try {
                sMethod_Activity_ShouldShowRequestPermissionRationale = Activity.class.getMethod("shouldShowRequestPermissionRationale", String.class);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }
        if (sMethod_Activity_RequestPermissions == null) {
            try {
                sMethod_Activity_RequestPermissions = Activity.class.getMethod("requestPermissions", String[].class, Integer.TYPE);
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }
    }

    private static void getFragmentMethod() {
        if (sMethod_Fragment_ShouldShowRequestPermissionRationale == null) {
            try {
                sMethod_Fragment_ShouldShowRequestPermissionRationale = Fragment.class.getMethod("shouldShowRequestPermissionRationale", String.class);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }
        if (sMethod_Fragment_RequestPermissions == null) {
            try {
                sMethod_Fragment_RequestPermissions = Fragment.class.getMethod("requestPermissions", String[].class, Integer.TYPE);
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static void requestPermissions(final Activity activity, final String[] strArr, final int i10) {
        getActivityMethod();
        Method method = sMethod_Activity_RequestPermissions;
        if (method != null) {
            try {
                method.invoke(activity, strArr, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mobvoi.wear.app.PermissionCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr[i11] = packageManager.checkPermission(strArr[i11], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i10, strArr, iArr);
                }
            });
        }
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        getActivityMethod();
        Method method = sMethod_Activity_ShouldShowRequestPermissionRationale;
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

    public static boolean shouldShowRequestPermissionRationale(Fragment fragment, String str) {
        getFragmentMethod();
        Method method = sMethod_Fragment_ShouldShowRequestPermissionRationale;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(fragment, str)).booleanValue();
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public static void requestPermissions(final Fragment fragment, final String[] strArr, final int i10) {
        getFragmentMethod();
        Method method = sMethod_Fragment_RequestPermissions;
        if (method != null) {
            try {
                method.invoke(fragment, strArr, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        } else if (fragment instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mobvoi.wear.app.PermissionCompat.2
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    Activity activity = fragment.getActivity();
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr[i11] = packageManager.checkPermission(strArr[i11], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) fragment).onRequestPermissionsResult(i10, strArr, iArr);
                }
            });
        }
    }
}
