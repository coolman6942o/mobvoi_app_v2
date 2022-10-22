package com.huawei.hms.scankit.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class b {
    public static boolean a(int[][] iArr, int i10) {
        return i10 >= 0 && i10 < iArr.length;
    }

    public static int b(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i10 == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i10 == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i10 == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i10 == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i10 == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i10 == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i10 == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i10 == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i10 == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i10 == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i10 == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i10 == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        return i10;
    }

    public static boolean c(Context context) {
        try {
            return "CN".equalsIgnoreCase(SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    public static boolean a(int[] iArr, int i10) {
        return i10 >= 0 && i10 < iArr.length;
    }

    public static boolean a(byte[] bArr, int i10) {
        return i10 >= 0 && i10 < bArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(byte[][] bArr, int i10) {
        return i10 >= 0 && i10 < bArr.length;
    }

    public static boolean a(String[] strArr, int i10) {
        return i10 >= 0 && i10 < strArr.length;
    }

    public static boolean a(float[] fArr, int i10) {
        return i10 >= 0 && i10 < fArr.length;
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (!(hmsScanArr == null || hmsScanArr.length == 0)) {
            for (int i10 = 0; i10 < hmsScanArr.length; i10++) {
                if (hmsScanArr[i10] != null) {
                    hmsScanArr[i10].scanType = b(hmsScanArr[i10].scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i10) {
        int i11 = 0;
        if (i10 <= 0 || i10 >= 8192) {
            return 0;
        }
        if (((i10 - 1) & i10) == 0) {
            return i10;
        }
        int i12 = HmsScanBase.AZTEC_SCAN_TYPE;
        if ((i10 & i12) != 0) {
            i11 = 0 | b(i12);
        }
        int i13 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i10 & i13) != 0) {
            i11 |= b(i13);
        }
        int i14 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i10 & i14) != 0) {
            i11 |= b(i14);
        }
        int i15 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i10 & i15) != 0) {
            i11 |= b(i15);
        }
        int i16 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i10 & i16) != 0) {
            i11 |= b(i16);
        }
        int i17 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i10 & i17) != 0) {
            i11 |= b(i17);
        }
        int i18 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i10 & i18) != 0) {
            i11 |= b(i18);
        }
        int i19 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i10 & i19) != 0) {
            i11 |= b(i19);
        }
        int i20 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i10 & i20) != 0) {
            i11 |= b(i20);
        }
        int i21 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i10 & i21) != 0) {
            i11 |= b(i21);
        }
        int i22 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i10 & i22) != 0) {
            i11 |= b(i22);
        }
        int i23 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i10 & i23) != 0) {
            i11 |= b(i23);
        }
        int i24 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        return (i10 & i24) != 0 ? i11 | b(i24) : i11;
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static Bitmap a(Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
    }

    public static Bitmap a(Bitmap bitmap, float f10, float f11) {
        if (f10 <= 0.0f || f11 <= 0.0f) {
            return null;
        }
        float f12 = 1.0f / f10;
        float f13 = 1.0f / f11;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = (int) (width * f10);
        int i11 = (int) (height * f11);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[i10 * i11];
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                iArr2[(i12 * i10) + i13] = iArr[(((int) (i12 * f13)) * width) + ((int) (i13 * f12))];
            }
        }
        Log.d(">>>", "dstPixels:" + i10 + " x " + i11);
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, i10, 0, 0, i10, i11);
        return createBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public static boolean a(Context context) {
        String str;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z10 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class);
            Object[] objArr = new Object[1];
            objArr[0] = "qemu.hw.mainkeys";
            str = (String) method.invoke(cls, objArr);
        } catch (Exception unused) {
            a.c("Uuils", "checkDeviceHasNavigationBar Exception");
        }
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        return z10;
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0);
        }
        return null;
    }

    public static int a(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.app.ActivityManagerEx");
            Method declaredMethod = cls.getDeclaredMethod("getActivityWindowMode", Activity.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, activity);
            if (invoke == null) {
                return -1;
            }
            return Integer.valueOf(String.valueOf(invoke)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NumberFormatException | InvocationTargetException unused) {
            return -1;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f10) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f10, width / 2, height / 2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!createBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i10) {
        if (i10 == 0) {
            return a(bitmap, 90.0f);
        }
        if (i10 != 2) {
            return i10 != 3 ? bitmap : a(bitmap, 180.0f);
        }
        return a(bitmap, 270.0f);
    }
}
