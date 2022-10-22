package com.mobvoi.wear.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class IdleAlarmManager {
    private static final String TAG = "IdleAlarmManager";
    private static Method sMtd_setAndAllowWhileIdle;
    private static Method sMtd_setExactAndAllowWhileIdle;

    private static Method get_setAndAllowWhileIdle() {
        if (sMtd_setAndAllowWhileIdle == null) {
            try {
                sMtd_setAndAllowWhileIdle = AlarmManager.class.getMethod("setAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
            } catch (NoSuchMethodException unused) {
                sMtd_setAndAllowWhileIdle = null;
                Log.w(TAG, "current sdk version may lower than '23'");
            }
        }
        return sMtd_setAndAllowWhileIdle;
    }

    private static Method get_setExactAndAllowWhileIdle() {
        if (sMtd_setExactAndAllowWhileIdle == null) {
            try {
                sMtd_setExactAndAllowWhileIdle = AlarmManager.class.getMethod("setExactAndAllowWhileIdle", Integer.TYPE, Long.TYPE, PendingIntent.class);
            } catch (NoSuchMethodException unused) {
                sMtd_setExactAndAllowWhileIdle = null;
                Log.w(TAG, "current sdk version may lower than '23'");
            }
        }
        return sMtd_setExactAndAllowWhileIdle;
    }

    @SuppressLint({"NewApi"})
    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
        try {
            get_setAndAllowWhileIdle().invoke(alarmManager, Integer.valueOf(i10), Long.valueOf(j10), pendingIntent);
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException unused) {
            alarmManager.set(i10, j10, pendingIntent);
        }
    }

    @SuppressLint({"NewApi"})
    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
        try {
            get_setExactAndAllowWhileIdle().invoke(alarmManager, Integer.valueOf(i10), Long.valueOf(j10), pendingIntent);
        } catch (IllegalAccessException | NullPointerException | InvocationTargetException unused) {
            alarmManager.setExact(i10, j10, pendingIntent);
        }
    }
}
