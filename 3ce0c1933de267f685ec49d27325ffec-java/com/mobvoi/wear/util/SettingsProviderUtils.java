package com.mobvoi.wear.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.provider.Settings;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.p;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@TargetApi(19)
/* loaded from: classes2.dex */
public class SettingsProviderUtils {
    private static final String TAG = "SettingsProviderUtils";
    private static int UserHandle_USER_CURRENT = -2;
    private static Method sMtd_global_getIntForUser;
    private static Method sMtd_system_getIntForUser;

    static {
        try {
            UserHandle_USER_CURRENT = p.a(UserHandle.class, "USER_CURRENT").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException e10) {
            k.r(TAG, "failed to get value of UserHandle#USER_CURRENT", e10, new Object[0]);
        }
    }

    public static int getIntForUserFromGlobal(Context context, String str, int i10) {
        if (!"TIC".equals(Build.BRAND)) {
            return Settings.Global.getInt(context.getContentResolver(), str, i10);
        }
        reflect_global_getIntForUser();
        Method method = sMtd_global_getIntForUser;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, context.getContentResolver(), str, Integer.valueOf(i10), Integer.valueOf(UserHandle_USER_CURRENT))).intValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                k.r(TAG, "failed to invoke reflected method", e10, new Object[0]);
            }
        } else {
            k.q(TAG, "#getIntForUser() not found");
        }
        return Settings.Global.getInt(context.getContentResolver(), str, i10);
    }

    public static int getIntForUserFromSystem(Context context, String str, int i10) {
        if (!"TIC".equals(Build.BRAND)) {
            return Settings.System.getInt(context.getContentResolver(), str, i10);
        }
        reflect_system_getIntForUser();
        Method method = sMtd_system_getIntForUser;
        if (method != null) {
            try {
                return ((Integer) method.invoke(null, context.getContentResolver(), str, Integer.valueOf(i10), Integer.valueOf(UserHandle_USER_CURRENT))).intValue();
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
                k.r(TAG, "failed to invoke reflected method", e10, new Object[0]);
            }
        } else {
            k.q(TAG, "#getIntForUser() not found");
        }
        return Settings.System.getInt(context.getContentResolver(), str, i10);
    }

    static Method reflect_global_getIntForUser() {
        Method method = sMtd_global_getIntForUser;
        if (method != null) {
            return method;
        }
        try {
            Class cls = Integer.TYPE;
            sMtd_global_getIntForUser = Settings.Global.class.getMethod("getIntForUser", ContentResolver.class, String.class, cls, cls);
        } catch (NoSuchMethodException e10) {
            k.r(TAG, "failed to find method", e10, new Object[0]);
        }
        return sMtd_global_getIntForUser;
    }

    static Method reflect_system_getIntForUser() {
        Method method = sMtd_system_getIntForUser;
        if (method != null) {
            return method;
        }
        try {
            Class cls = Integer.TYPE;
            sMtd_system_getIntForUser = Settings.System.class.getMethod("getIntForUser", ContentResolver.class, String.class, cls, cls);
        } catch (NoSuchMethodException e10) {
            k.r(TAG, "failed to find method", e10, new Object[0]);
        }
        return sMtd_system_getIntForUser;
    }
}
