package com.mobvoi.wear.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.wear.info.AppInfo;
import com.mobvoi.wear.providers.AppUpdateColumn;
import com.mobvoi.wear.providers.ContentUris;
/* loaded from: classes2.dex */
public class AppUpdateUtil {
    public static final String ACTION_APP_UPDATE = "com.mobvoi.wear.action.APP_UPDATE";
    public static final String APP_INFO = "app_info";
    public static final int REMIND_DISABLE = 0;
    public static final int REMIND_ENABLE = 1;

    public static AppInfo checkUpdate(Context context, String str) {
        Cursor query = context.getApplicationContext().getContentResolver().query(ContentUris.APP_UPDATE_URI, AppUpdateColumn.COLUMN_NAMES, "package_name=?", new String[]{str}, null);
        if (query == null) {
            return null;
        }
        try {
            if (!query.moveToNext()) {
                return null;
            }
            AppInfo appInfo = new AppInfo();
            appInfo.packageName = query.getString(0);
            appInfo.versionCode = query.getInt(1);
            appInfo.versionName = query.getString(2);
            appInfo.iconUrl = query.getString(3);
            appInfo.changeLog = query.getString(4);
            appInfo.remindEnable = query.getInt(5);
            return appInfo;
        } finally {
            query.close();
        }
    }

    public static void checkUpgrade(Context context) {
        AppInfo checkUpdate = checkUpdate(context, context.getPackageName());
        if (checkUpdate != null && checkUpdate.versionCode > b.b(context) && checkUpdate.remindEnable == 1) {
            notifyAppUpdate(context, checkUpdate);
        }
    }

    public static Intent getAppUpdateIntent(AppInfo appInfo) {
        Intent intent = new Intent(ACTION_APP_UPDATE);
        intent.putExtra(APP_INFO, appInfo);
        return intent;
    }

    public static boolean isRemindEnable(AppInfo appInfo) {
        return appInfo != null && appInfo.remindEnable == 1;
    }

    public static boolean needUpdate(Context context, AppInfo appInfo) {
        return appInfo != null && appInfo.versionCode > b.b(context);
    }

    public static void notifyAppUpdate(Context context, AppInfo appInfo) {
        Intent appUpdateIntent = getAppUpdateIntent(appInfo);
        appUpdateIntent.setFlags(268435456);
        context.startActivity(appUpdateIntent);
    }
}
