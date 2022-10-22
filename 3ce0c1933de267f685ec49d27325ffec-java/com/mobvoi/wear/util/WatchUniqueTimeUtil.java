package com.mobvoi.wear.util;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.format.DateFormat;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes2.dex */
public class WatchUniqueTimeUtil {
    private static final String SYNC_TIME_WITH_PHONE = "sync_time_with_phone";
    private static final String TIME_24H_FORMAT = "time_24h_format";
    public static final String WATCH_UNIQUE_TIME_CHANGED = "com.mobvoi.ticwear.settings.action.UNIQUE_TIME_CHANGED";
    private static final String WATCH_UNIQUE_TIME_OFFSET = "watch_unique_time_offset";

    public static long getCurrentWatchTimeMillis(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        return isSyncWithPhone(context) ? currentTimeMillis : currentTimeMillis + getTimeOffset(context);
    }

    public static int getHour(Calendar calendar, boolean z10) {
        if (!z10) {
            return calendar.get(11);
        }
        int i10 = calendar.get(10);
        if (i10 == 0) {
            return 12;
        }
        return i10;
    }

    public static long getTimeOffset(Context context) {
        return Settings.Global.getLong(context.getContentResolver(), WATCH_UNIQUE_TIME_OFFSET, 0L);
    }

    public static boolean is24HourFormat(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), TIME_24H_FORMAT, DateFormat.is24HourFormat(context) ? 1 : 0) != 0;
    }

    public static boolean isAm(Calendar calendar) {
        return calendar.get(9) == 0;
    }

    public static boolean isSyncWithPhone(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), SYNC_TIME_WITH_PHONE, 1) != 0;
    }

    public static String paddingSingleNumber(int i10) {
        return String.format(Locale.getDefault(), "%02d", Integer.valueOf(i10));
    }

    public static void set24HourFormat(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), TIME_24H_FORMAT, z10 ? 1 : 0);
        context.sendBroadcast(new Intent(WATCH_UNIQUE_TIME_CHANGED));
    }

    public static void setSyncWithPhone(Context context, boolean z10) {
        Settings.Global.putInt(context.getContentResolver(), SYNC_TIME_WITH_PHONE, z10 ? 1 : 0);
        if (z10) {
            Settings.Global.putLong(context.getContentResolver(), WATCH_UNIQUE_TIME_OFFSET, 0L);
            Settings.Global.putInt(context.getContentResolver(), TIME_24H_FORMAT, DateFormat.is24HourFormat(context) ? 1 : 0);
        }
        context.sendBroadcast(new Intent(WATCH_UNIQUE_TIME_CHANGED));
    }

    public static void setTimeOffset(Context context, long j10) {
        Settings.Global.putLong(context.getContentResolver(), WATCH_UNIQUE_TIME_OFFSET, j10);
        context.sendBroadcast(new Intent(WATCH_UNIQUE_TIME_CHANGED));
    }
}
