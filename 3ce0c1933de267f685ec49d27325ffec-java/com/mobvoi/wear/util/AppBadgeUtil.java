package com.mobvoi.wear.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.mobvoi.wear.providers.AppBadgeColumn;
import com.mobvoi.wear.providers.ContentUris;
/* loaded from: classes2.dex */
public class AppBadgeUtil {
    private AppBadgeUtil() {
    }

    public static void setAppBadgeCount(final Context context, final String str, final int i10) {
        AsyncTask.execute(new Runnable() { // from class: com.mobvoi.wear.util.AppBadgeUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                ContentValues contentValues = new ContentValues();
                contentValues.put(AppBadgeColumn.BADGE_COUNT, Integer.valueOf(i10));
                String[] strArr = {str};
                Uri uri = ContentUris.APP_BADGE_URI;
                if (contentResolver.update(uri, contentValues, "package_name=?", strArr) == 0) {
                    contentValues.put("package_name", str);
                    contentResolver.insert(uri, contentValues);
                }
            }
        });
    }
}
