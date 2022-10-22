package com.mobvoi.wear.privacy;

import android.content.Context;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class PrivacyNames {
    public static String getName(Context context, String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1505707541:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_MOTION)) {
                    c10 = 0;
                    break;
                }
                break;
            case -1151817222:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_BLOOD_OXYGEN)) {
                    c10 = 1;
                    break;
                }
                break;
            case -700033222:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_PRESSURE)) {
                    c10 = 2;
                    break;
                }
                break;
            case -363394495:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_STEP)) {
                    c10 = 3;
                    break;
                }
                break;
            case -363389424:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_SYNC)) {
                    c10 = 4;
                    break;
                }
                break;
            case -66203426:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_STEP_SHARING)) {
                    c10 = 5;
                    break;
                }
                break;
            case 397884467:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_CALENDAR)) {
                    c10 = 6;
                    break;
                }
                break;
            case 1057124575:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_MICROPHONE)) {
                    c10 = 7;
                    break;
                }
                break;
            case 1789381269:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_GPS)) {
                    c10 = '\b';
                    break;
                }
                break;
            case 1789382286:
                if (str.equals(SharedWearInfoHelper.GdprInfo.KEY_DATA_HRM)) {
                    c10 = '\t';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return context.getString(R.string.privacy_item_motion);
            case 1:
                return context.getString(R.string.privacy_item_blood_oxygen);
            case 2:
                return context.getString(R.string.privacy_item_pressure);
            case 3:
                return context.getString(R.string.privacy_item_step);
            case 4:
                return context.getString(R.string.privacy_item_data_sync);
            case 5:
                return context.getString(R.string.privacy_item_step_sharing);
            case 6:
                return context.getString(R.string.privacy_item_calendar);
            case 7:
                return context.getString(R.string.privacy_item_microphone);
            case '\b':
                return context.getString(R.string.privacy_item_gps);
            case '\t':
                return context.getString(R.string.privacy_item_heart_rate);
            default:
                return "";
        }
    }
}
