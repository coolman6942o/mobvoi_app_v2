package com.huawei.hms.framework.common;
/* loaded from: classes.dex */
public class EmuiUtil {
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    private static final int EMUI_3_0 = 7;
    private static final int EMUI_3_1 = 8;
    private static final int EMUI_4_0 = 9;
    private static final int EMUI_4_1 = 10;
    private static final int EMUI_5_0 = 11;
    private static final int EMUI_6_0 = 14;
    private static final int EMUI_8_0_1 = 15;
    private static final int EMUI_9_0 = 17;
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    private static final int EMUI_TYPE_UNKOWN = -1;
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    private static final String TAG = "KPMS_Util_Emui";
    private static final int TYPE_EMUI_30 = 30;
    private static final int TYPE_EMUI_31 = 31;
    private static final int TYPE_EMUI_40 = 40;
    private static final int TYPE_EMUI_41 = 41;
    private static final int TYPE_EMUI_50 = 50;
    private static final int TYPE_EMUI_60 = 60;
    private static final int TYPE_EMUI_801 = 81;
    private static final int TYPE_EMUI_90 = 90;
    private static int emuiType = -1;
    private static int emuiVersionCode;

    static {
        initEmuiType();
    }

    private static int getEMUIVersionCode() {
        int intValue;
        Object staticFieldObj = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
        if (staticFieldObj != null) {
            try {
                intValue = ((Integer) staticFieldObj).intValue();
            } catch (ClassCastException e10) {
                Logger.e(TAG, "getEMUIVersionCode ClassCastException:", e10);
            }
            Logger.d(TAG, "the emui version code is::" + intValue);
            return intValue;
        }
        intValue = 0;
        Logger.d(TAG, "the emui version code is::" + intValue);
        return intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initEmuiType() {
        int i10;
        emuiVersionCode = getEMUIVersionCode();
        Logger.d(TAG, "getEmuiType emuiVersionCode=" + emuiVersionCode);
        int i11 = emuiVersionCode;
        if (i11 >= 17) {
            i10 = 90;
        } else if (i11 >= 15) {
            i10 = 81;
        } else if (i11 >= 14) {
            i10 = 60;
        } else if (i11 >= 11) {
            i10 = 50;
        } else if (i11 >= 10) {
            i10 = 41;
        } else if (i11 >= 9) {
            i10 = 40;
        } else if (i11 >= 8) {
            i10 = 31;
        } else {
            if (i11 >= 7) {
                i10 = 30;
            }
            if (emuiType != -1) {
                Logger.i(TAG, "emuiType is unkown");
                return;
            }
            return;
        }
        emuiType = i10;
        if (emuiType != -1) {
        }
    }

    public static boolean isEMUI() {
        return -1 != emuiType;
    }
}
