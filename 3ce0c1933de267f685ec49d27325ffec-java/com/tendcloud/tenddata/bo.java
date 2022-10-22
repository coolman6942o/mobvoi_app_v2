package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bo {
    public static boolean a(Context context) {
        PackageManager packageManager;
        try {
            if (bk.i() && (packageManager = context.getPackageManager()) != null) {
                if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void reflectMEiZU(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query != null) {
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex(HealthDataProviderContracts.NAME_VALUE));
                if (string != null) {
                    co.a().setOAID(string);
                }
                query.close();
            }
        } catch (Throwable unused) {
        }
    }
}
