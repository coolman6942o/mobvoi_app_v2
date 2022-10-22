package com.mobvoi.wear.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.wear.info.AccountInfoHelper;
/* loaded from: classes2.dex */
public class AccountWearUtil {
    public static final String ACTION_ACCOUNT_INFO = "com.mobvoi.wear.action.ACCOUNT_INFO";
    public static final String ACTION_ACCOUNT_LOGIN = "com.mobvoi.wear.action.ACCOUNT_LOGIN";
    public static final String CAN_CANCEL = "can_cancel";
    private static final String TAG = "AccountWearUtil";

    public static Intent getLoginIntent(boolean z10) {
        Intent intent = new Intent(ACTION_ACCOUNT_LOGIN);
        intent.putExtra(CAN_CANCEL, z10);
        return intent;
    }

    public static boolean isAccountLoginEnable(Context context) {
        return AccountInfoHelper.isAccountInfoProviderExist(context);
    }

    public static void jumpToAccountInfoPage(Context context) {
        Intent intent = new Intent(ACTION_ACCOUNT_INFO);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startLogin(Context context) {
        startLogin(context, true);
    }

    public static void startLogin(Context context, boolean z10) {
        startLogin(context, z10, Integer.MIN_VALUE);
    }

    public static void startLogin(Context context, boolean z10, int i10) {
        Intent loginIntent = getLoginIntent(z10);
        if (i10 == Integer.MIN_VALUE || !(context instanceof Activity)) {
            loginIntent.setFlags(268435456);
            context.startActivity(loginIntent);
            return;
        }
        ((Activity) context).startActivityForResult(loginIntent, i10);
    }

    public static void startLogin(Fragment fragment, boolean z10, int i10) {
        fragment.startActivityForResult(getLoginIntent(z10), i10);
    }
}
