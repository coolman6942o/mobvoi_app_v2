package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.util.TelephonyUtil;
import z7.a;
/* loaded from: classes.dex */
final class b {
    private static void a(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra(Constants.WatchfaceMarket.MARKET_ENTER_FROM);
        if (stringExtra4 == null || !stringExtra4.startsWith("/topics/")) {
            stringExtra4 = null;
        }
        if (stringExtra4 != null) {
            bundle.putString("_nt", stringExtra4);
        }
        try {
            bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra("google.c.a.ts")));
        } catch (NumberFormatException e10) {
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e10);
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra("google.c.a.udt")));
            } catch (NumberFormatException e11) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e11);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22 + valueOf.length());
            sb2.append("Sending event=");
            sb2.append(str);
            sb2.append(" params=");
            sb2.append(valueOf);
            Log.d("FirebaseMessaging", sb2.toString());
        }
        a aVar = (a) com.google.firebase.a.c().a(a.class);
        if (aVar != null) {
            aVar.a(AppMeasurement.FCM_ORIGIN, str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    public static void b(Context context, Intent intent) {
        a(context, "_nr", intent);
    }

    public static void c(Context context, Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                a aVar = (a) com.google.firebase.a.c().a(a.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aVar.b(AppMeasurement.FCM_ORIGIN, "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    aVar.a(AppMeasurement.FCM_ORIGIN, "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        a(context, "_no", intent);
    }

    public static void d(Context context, Intent intent) {
        a(context, "_nd", intent);
    }

    public static void e(Context context, Intent intent) {
        a(context, "_nf", intent);
    }
}
