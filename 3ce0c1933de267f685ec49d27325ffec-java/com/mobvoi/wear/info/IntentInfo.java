package com.mobvoi.wear.info;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.android.common.utils.k;
import java.util.List;
/* loaded from: classes2.dex */
public class IntentInfo implements JsonBean {
    public static final String ACTION_DATA_SYNC_REQUEST = "com.mobvoi.health.action.DATA_SYNC";
    public static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 16777216;
    public static final String PACKAGE_AW = "com.mobvoi.wear.health.aw";
    public static final String TAG = "IntentInfo";
    public static final int TYPE_ACTIVITY = 0;
    public static final int TYPE_BROADCAST_RECEIVER = 2;
    public static final int TYPE_SERVICE = 1;
    public String intent;
    public String permission;
    public int type;

    @SuppressLint({"WrongConstant"})
    public static void launchIntent(Context context, IntentInfo intentInfo) {
        try {
            k.c(TAG, "launchIntent: %s", intentInfo);
            Intent parseUri = Intent.parseUri(intentInfo.intent, 1);
            PackageManager packageManager = context.getPackageManager();
            int i10 = intentInfo.type;
            if (i10 == 0) {
                if (packageManager.resolveActivity(parseUri, 0) == null) {
                    k.c(TAG, "activity not exist: %s", intentInfo.intent);
                    return;
                }
                parseUri.addFlags(268435456);
                context.startActivity(parseUri);
            } else if (i10 == 1) {
                if (packageManager.resolveService(parseUri, 0) == null) {
                    k.c(TAG, "service not exist: %s", intentInfo.intent);
                } else {
                    context.startService(parseUri);
                }
            } else if (i10 == 2) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(parseUri, 0);
                if (!queryBroadcastReceivers.isEmpty()) {
                    ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
                    if (activityInfo != null) {
                        parseUri.setClassName(activityInfo.packageName, activityInfo.name);
                    } else if (ACTION_DATA_SYNC_REQUEST.equals(parseUri.getAction())) {
                        parseUri.setPackage(PACKAGE_AW);
                    }
                }
                parseUri.addFlags(FLAG_RECEIVER_INCLUDE_BACKGROUND);
                if (!TextUtils.isEmpty(intentInfo.permission)) {
                    context.sendBroadcast(parseUri, intentInfo.permission);
                } else {
                    context.sendBroadcast(parseUri);
                }
            }
        } catch (Exception e10) {
            k.r(TAG, "parse intent error", e10, new Object[0]);
        }
    }

    public String toString() {
        return "IntentInfo{type=" + this.type + ", intent='" + this.intent + "', permission='" + this.permission + "'}";
    }
}
