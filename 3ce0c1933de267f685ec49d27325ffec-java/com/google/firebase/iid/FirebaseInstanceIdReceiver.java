package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import c8.i;
import com.mobvoi.wear.common.base.Constants;
import h6.n;
import y0.a;
/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends a {

    /* renamed from: c  reason: collision with root package name */
    private static i f12460c;

    /* renamed from: d  reason: collision with root package name */
    private static i f12461d;

    private static synchronized i e(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (f12461d == null) {
                    f12461d = new i(context, str);
                }
                return f12461d;
            }
            if (f12460c == null) {
                f12460c = new i(context, str);
            }
            return f12460c;
        }
    }

    private final void f(Context context, Intent intent, String str) {
        String str2 = null;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        boolean z10 = false;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("google.com/iid".equals(intent.getStringExtra(Constants.WatchfaceMarket.MARKET_ENTER_FROM)) || "com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
            str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(str) || "com.google.firebase.MESSAGING_EVENT".equals(str)) {
            str2 = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
        }
        int i10 = -1;
        if (str2 != null) {
            if (n.i() && context.getApplicationInfo().targetSdkVersion >= 26) {
                z10 = true;
            }
            if (z10) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                e(context, str2).a(intent, goAsync());
            } else {
                i10 = l.c().a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i10);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                f(context, (Intent) parcelableExtra, intent.getAction());
            } else {
                f(context, intent, intent.getAction());
            }
        }
    }
}
