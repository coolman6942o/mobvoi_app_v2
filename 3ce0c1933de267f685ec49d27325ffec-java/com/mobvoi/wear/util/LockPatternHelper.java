package com.mobvoi.wear.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class LockPatternHelper {
    private static final String TAG = "LockPatternHelper";
    private static Class<?> sClass_LockPatternUtils;
    private static Constructor<?> sCtor_default;
    private static Method sMtd_isLockPatternEnabled;
    private static Method sMtd_savedPatternExists;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils", false, Thread.currentThread().getContextClassLoader());
            sClass_LockPatternUtils = cls;
            sCtor_default = cls.getConstructor(Context.class);
            sMtd_isLockPatternEnabled = sClass_LockPatternUtils.getMethod("isLockPatternEnabled", new Class[0]);
            sMtd_savedPatternExists = sClass_LockPatternUtils.getMethod("savedPatternExists", new Class[0]);
        } catch (ClassNotFoundException e10) {
            k.r(TAG, "class not found", e10, new Object[0]);
        } catch (NoSuchMethodException e11) {
            k.r(TAG, "method not found", e11, new Object[0]);
        }
    }

    @TargetApi(19)
    public static boolean hasKeyguard(Context context) {
        try {
            Object newInstance = sCtor_default.newInstance(context);
            return ((Boolean) sMtd_isLockPatternEnabled.invoke(newInstance, new Object[0])).booleanValue() && ((Boolean) sMtd_savedPatternExists.invoke(newInstance, new Object[0])).booleanValue();
        } catch (Exception e10) {
            k.r(TAG, "failed to get keyguard state", e10, new Object[0]);
            return false;
        }
    }
}
