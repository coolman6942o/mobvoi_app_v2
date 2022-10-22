package com.mobvoi.wear.util;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class MtkLogUtil {
    private static final String MTK_LOG_CMD_ACTION = "com.mediatek.mtklogger.ADB_CMD";
    private static final int MTK_LOG_CMD_TARGET_VALUE = 17;

    public static Intent getStartMtkLogIntent() {
        Intent intent = new Intent(MTK_LOG_CMD_ACTION);
        intent.putExtra("cmd_name", "start");
        intent.putExtra("cmd_target", 17);
        return intent;
    }

    public static void startTestMtkLog(Context context) {
        context.sendBroadcast(getStartMtkLogIntent());
    }
}
