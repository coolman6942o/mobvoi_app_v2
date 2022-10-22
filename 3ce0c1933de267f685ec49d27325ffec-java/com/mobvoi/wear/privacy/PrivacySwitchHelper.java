package com.mobvoi.wear.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes2.dex */
public class PrivacySwitchHelper {
    private static final String TAG = "priv.SwitchHelper";

    public static boolean start(Context context, String str, String... strArr) {
        return start(context, str, strArr, 0, false);
    }

    public static boolean startWithResult(Context context, int i10, String str, String... strArr) {
        return start(context, str, strArr, i10, true);
    }

    private static boolean start(Context context, String str, String[] strArr, int i10, boolean z10) {
        if (strArr.length == 0) {
            return false;
        }
        Intent intent = new Intent(Constants.Privacy.ACTION_SWITCH);
        intent.putExtra(Constants.Privacy.KEY_CHECK_PRIVACY_LIST, strArr);
        intent.putExtra(Constants.Privacy.KEY_SWITCH_DESCRIPTION, str);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            if (!z10 || !(context instanceof Activity)) {
                intent.addFlags(268435456);
                context.startActivity(intent);
            } else {
                k.c(TAG, "Has privacy switch activity, start with requestCode %d", Integer.valueOf(i10));
                intent.addFlags(4194304);
                ((Activity) context).startActivityForResult(intent, i10);
            }
            return true;
        }
        k.q(TAG, "Privacy switch activity not found, skip show.");
        return false;
    }
}
