package com.tendcloud.tenddata;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bq {
    public static boolean a(Context context) {
        try {
            return bk.l();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectNUBIA(Context context) {
        Bundle bundle;
        String string;
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i10 = Build.VERSION.SDK_INT;
            if (i10 > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient != null) {
                    bundle = acquireContentProviderClient.call("getOAID", null, null);
                    if (i10 >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    return;
                }
            } else {
                bundle = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (bundle != null && bundle.getInt("code", -1) == 0 && (string = bundle.getString("id")) != null) {
                co.a().setOAID(string);
            }
        } catch (Throwable unused) {
        }
    }
}
