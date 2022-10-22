package com.mobvoi.wear.util;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class TelephonyUtil {
    public static final String ACTION_SIM_CHECK = "com.mobvoi.ticwear.action.ACTION_SIM_CHECK";
    public static final String ACTION_SIM_HOW_ACTIVITIED = "com.mobvoi.ticwear.action.ACTION_SIM_HOW_ACTIVITIED";
    public static final String CARD_ID = "card_id";
    public static final String KEY_SIM_ACTION = "action";
    public static final String KEY_SIM_ACTIVITIED_CHANNLE = "subtype";
    public static final String KEY_SIM_ACTIVITIED_SOURCE = "source";
    public static final String KEY_SIM_TIME = "time";
    public static final String NEW_USER = "new_user";
    public static final String REGULAR_USER = "regular_user";
    public static final int SIM_ACTION_HOW_TO = 1;
    public static final int SIM_ACTION_IGNORE = 0;
    public static final int SIM_ACTIVITIED_AUTO = 1;
    public static final String SIM_ACTIVITIED_CHANNEL_MINSHENG = "minsheng";
    public static final String SIM_ACTIVITIED_CHANNEL_UNICOM = "unicom";
    public static final int SIM_ACTIVITIED_FROM_USER = 0;
    public static final String TRACE_TAG = "sim_check";

    private static Object invoke(Context context, String str, Object[] objArr, Class[] clsArr) {
        try {
            return context.getClassLoader().loadClass("android.telephony.TelephonyManager").getMethod(str, clsArr).invoke((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE), objArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean isRadioOn(Context context) {
        Object invoke = invoke(context, "isRadioOn", null, null);
        if (invoke != null) {
            return ((Boolean) invoke).booleanValue();
        }
        return false;
    }

    public static boolean isSimActivitied(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Constants.Setting.SIM_ACTIVITIED, 0) == 1;
    }

    public static boolean setRadio(Context context, boolean z10) {
        Object invoke = invoke(context, "setRadio", new Object[]{Boolean.valueOf(z10)}, new Class[]{Boolean.TYPE});
        if (invoke != null) {
            return ((Boolean) invoke).booleanValue();
        }
        return false;
    }

    public static void setSimActivitied(Context context, boolean z10) {
        Settings.System.putInt(context.getContentResolver(), Constants.Setting.SIM_ACTIVITIED, z10 ? 1 : 0);
    }
}
