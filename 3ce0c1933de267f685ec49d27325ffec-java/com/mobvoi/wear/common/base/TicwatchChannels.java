package com.mobvoi.wear.common.base;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.h;
import com.mobvoi.android.common.utils.k;
/* loaded from: classes2.dex */
public class TicwatchChannels {
    private static final String CHANNEL_KEY = "ro.oem.tw.channel";
    public static final String CHANNEL_NAME_CERT = "cert";
    public static final String CHANNEL_NAME_CMCC_DM = "cmcc_dm";
    public static final String CHANNEL_NAME_CTCC_DM = "ctcc_dm";
    public static final String CHANNEL_NAME_GUGONG = "gugong";
    public static final String CHANNEL_NAME_MINSHENG = "minsheng";
    public static final String CHANNEL_NAME_MLGB = "mlgb";
    public static final String CHANNEL_NAME_NORMAL = "normal";
    public static final String CHANNEL_NAME_PRO2020 = "pro2020";
    public static final String CHANNEL_NAME_PRO2021 = "pro2021";
    public static final String CHANNEL_NAME_UNICOM = "unicom";
    public static final String CHANNEL_NAME_UNICOM_DM = "unicom_dm";
    public static final String CHANNEL_NAME_UNKNOWN = "unknown";
    public static final String CHANNEL_NAME_YUANCHUAN = "yuanchuan";
    static final int CUSTOM_CHANNEL_MINSHENG = 1;
    static final int CUSTOM_CHANNEL_MLGB = 2;
    static final int CUSTOM_CHANNEL_NORMAL = 0;
    static final int CUSTOM_CHANNEL_UNICOM = 3;
    static final int CUSTOM_CHANNEL_UNKNOWN = -1;
    static final int CUSTOM_CHANNEL_YUANCHUAN = 4;
    private static final char SN_CERT_LAB_FLAG = 'Z';
    private static final String TAG = "TicwatchChannels";

    public static String getChannelName() {
        String channel = TicwatchSysProperties.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        int parseCustomChannel = parseCustomChannel(h.f());
        return parseCustomChannel == 0 ? CHANNEL_NAME_NORMAL : parseCustomChannel == 1 ? "minsheng" : parseCustomChannel == 2 ? CHANNEL_NAME_MLGB : parseCustomChannel == 3 ? "unicom" : parseCustomChannel == 4 ? CHANNEL_NAME_YUANCHUAN : "unknown";
    }

    public static boolean isCertLabVersion() {
        if (!TicwatchModels.isTicwatch()) {
            return false;
        }
        if (TicwatchSysProperties.getChannel().equals(CHANNEL_NAME_CERT)) {
            return true;
        }
        String f10 = h.f();
        return f10 != null && 6 < f10.length() && f10.charAt(6) == 'Z';
    }

    public static boolean isGugong() {
        return getChannelName().equalsIgnoreCase(CHANNEL_NAME_GUGONG);
    }

    public static boolean isMinshengBankCustom() {
        return parseCustomChannel(h.f()) == 1;
    }

    public static boolean isMlgbCustom() {
        return parseCustomChannel(h.f()) == 2;
    }

    public static boolean isTicWatchPro2020() {
        return getChannelName().equalsIgnoreCase(CHANNEL_NAME_PRO2020);
    }

    public static boolean isTicWatchPro2021() {
        return getChannelName().equalsIgnoreCase(CHANNEL_NAME_PRO2021);
    }

    public static boolean isUnicomCustom() {
        return parseCustomChannel(h.f()) == 3;
    }

    public static boolean isYuanchuanCustom() {
        return parseCustomChannel(h.f()) == 4;
    }

    static int parseCustomChannel(String str) {
        if (!TicwatchModels.isMercuryNfc() && !TicwatchModels.isLily() && !TicwatchModels.isLotus()) {
            return 0;
        }
        if (str.length() >= 4) {
            char charAt = str.charAt(3);
            if (charAt == '0') {
                return 0;
            }
            if (charAt == '1') {
                return 1;
            }
            if (charAt == '2') {
                return 2;
            }
            if (charAt == '3') {
                return 3;
            }
            if (charAt == '4') {
                return 4;
            }
        }
        k.f(TAG, "unknown custom channel in '%s'", str);
        return -1;
    }
}
