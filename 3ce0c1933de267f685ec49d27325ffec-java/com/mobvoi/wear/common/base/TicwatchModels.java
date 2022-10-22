package com.mobvoi.wear.common.base;

import android.content.Context;
import android.os.Build;
import com.mobvoi.android.common.utils.h;
import com.mobvoi.android.common.utils.r;
import com.mobvoi.wear.info.AwSkuInfo;
import com.mobvoi.wear.util.WatchInfoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u9.b;
/* loaded from: classes2.dex */
public class TicwatchModels {
    private static final int BLACK = 1;
    public static final String TICWATCH1 = "Ticwatch";
    public static final String TICWATCH1_G = "Ticwatch_G";
    public static final String TICWATCH1_I18N = "Ticwatch-i18n";
    public static final String TICWATCH2 = "Ticwatch2";
    public static final String TICWATCH2_3G = "Ticwatch2_3G";
    public static final String TICWATCH2_I18N = "Ticwatch2i";
    public static final String TICWATCH2_I18N_OLD = "Ticwatch2-i18n";
    public static final String TICWATCH2_LILY = "Ticwatch_S";
    public static final String TICWATCH2_LOTUS = "Ticwatch_E";
    public static final String TICWATCH2_NFC = "Ticwatch2_NFC";
    public static final String TICWATCH_C2 = "TicWatch C2";
    public static final String TICWATCH_C2_2020 = "TicWatch C2+";
    public static final String TICWATCH_E = "Ticwatch E";
    public static final String TICWATCH_E2 = "TicWatch E2";
    public static final String TICWATCH_E3 = "TicWatch E3";
    public static final String TICWATCH_GTH = "TicWatch GTH";
    public static final String TICWATCH_GTW_eSIM = "TicWatch GTW eSIM";
    public static final String TICWATCH_GTX = "TicWatch GTX";
    public static final String TICWATCH_PRO3U_4G = "TicWatch Pro 3 Ultra";
    public static final String TICWATCH_PRO3U_4G_BACKUP = "TicWatch Pro 3U";
    public static final String TICWATCH_PRO3U_BT = "TicWatch Pro 3 Ultra GPS";
    public static final String TICWATCH_PRO3U_BT_BACKUP = "TicWatch Pro 3U GPS";
    public static final String TICWATCH_PRO3X = "TicWatch Pro 3X";
    public static final String TICWATCH_PRO3_4G_LE = "TicWatch Pro 3";
    public static final String TICWATCH_PRO3_4G_ROW = "TicWatch Pro 3";
    public static final String TICWATCH_PRO3_BT = "TicWatch Pro 3 GPS";
    public static final String TICWATCH_PROX = "TicWatch Pro X";
    public static final String TICWATCH_PRO_2021 = "TicWatch Pro S";
    public static final String TICWATCH_PRO_4G = "TicWatch Pro 4G";
    public static final String TICWATCH_PRO_BT = "TicWatch Pro";
    public static final String TICWATCH_PRO_BT_2020 = "TicWatch Pro 2020";
    public static final String TICWATCH_S = "Ticwatch S";
    public static final String TICWATCH_S2 = "TicWatch S2";
    private static final int UNKNOWN = -1;
    private static final int WHITE = 2;
    private static final int YELLOW = 3;
    private static final Map<String, String> sFixedModelsChina;
    private static final Map<String, String> sFixedModelsGlobal;
    private static Map<String, String> sModelToNfcBusModel;
    private static Set<String> sNfcModels;
    private static Set<String> sTelephonyModels;
    private static Set<String> sWaterproofModels;

    /* loaded from: classes2.dex */
    public interface CertModels {
        public static final String C2_FEMALE = "WG12056";
        public static final String C2_MALE = "WG12036";
        public static final String E2 = "WG12026";
        public static final String PRO3_4G = "WH11013";
        public static final String PRO3_BT = "WH12018";
        public static final String PRO_4G_CN = "WF11016";
        public static final String PRO_4G_EU = "WF11018";
        public static final String PRO_4G_US_OPEN = "WF11026";
        public static final String PRO_4G_US_VERIZON = "WF11026V";
        public static final String PRO_BT_NEW = "WF12106";
        public static final String PRO_BT_OLD = "WF12096";
        public static final String S2 = "WG12016";
    }

    static {
        HashMap hashMap = new HashMap();
        sFixedModelsChina = hashMap;
        hashMap.put(TICWATCH_PRO_BT, "TicWatch_Pro_LE");
        hashMap.put(TICWATCH_PRO3_BT, "TicWatch_Pro3_LE");
        hashMap.put(TICWATCH_PRO_BT_2020, "TicWatch_Pro_LE_2020");
        hashMap.put(TICWATCH_PRO_4G, "TicWatch_Pro4G_LE");
        hashMap.put("TicWatch Pro 3", "TicWatch_Pro3_4G_LE");
        hashMap.put(TICWATCH_S2, "TicWatch_S2_LE");
        hashMap.put(TICWATCH_E2, "TicWatch_E2_LE");
        hashMap.put(TICWATCH_C2, "TicWatch_C2_LE");
        hashMap.put(TICWATCH_C2_2020, "TicWatch_C2+_LE");
        HashMap hashMap2 = new HashMap();
        sFixedModelsGlobal = hashMap2;
        hashMap2.put(TICWATCH_PRO_BT, "TicWatch_Pro_RoW");
        hashMap2.put(TICWATCH_PRO3_BT, "TicWatch_Pro3_RoW");
        hashMap2.put(TICWATCH_PRO_BT_2020, "TicWatch_Pro_RoW_2020");
        hashMap2.put(TICWATCH_PRO_4G, "TicWatch_Pro4G_RoW");
        hashMap2.put("TicWatch Pro 3", "TicWatch_Pro3_4G_RoW");
        hashMap2.put(TICWATCH_S2, "TicWatch_S2_RoW");
        hashMap2.put(TICWATCH_E2, "TicWatch_E2_RoW");
        hashMap2.put(TICWATCH_C2, "TicWatch_C2_RoW");
        hashMap2.put(TICWATCH_C2_2020, "TicWatch_C2+_RoW");
        HashSet hashSet = new HashSet();
        sNfcModels = hashSet;
        hashSet.add(TICWATCH2_NFC);
        sNfcModels.add(TICWATCH2_LILY);
        sNfcModels.add(TICWATCH2_LOTUS);
        sNfcModels.add(TICWATCH_PRO_BT);
        sNfcModels.add(TICWATCH_PRO_4G);
        sNfcModels.add(TICWATCH_PRO3_BT);
        sNfcModels.add("TicWatch Pro 3");
        sNfcModels.add("TicWatch Pro 3");
        sNfcModels.add(TICWATCH_C2);
        sNfcModels.add(TICWATCH_C2_2020);
        sNfcModels.add(TICWATCH_PRO3U_4G);
        sNfcModels.add(TICWATCH_PRO3U_BT);
        sNfcModels.add(TICWATCH_PRO3U_4G_BACKUP);
        sNfcModels.add(TICWATCH_PRO3U_BT_BACKUP);
        sNfcModels.add(TICWATCH_PRO3X);
        sNfcModels.add(TICWATCH_PROX);
        HashSet hashSet2 = new HashSet();
        sTelephonyModels = hashSet2;
        hashSet2.add(TICWATCH2_3G);
        sTelephonyModels.add(TICWATCH2_NFC);
        sTelephonyModels.add(TICWATCH2_LILY);
        sTelephonyModels.add(TICWATCH2_LOTUS);
        sTelephonyModels.add(TICWATCH_PRO_4G);
        sTelephonyModels.add("TicWatch Pro 3");
        sTelephonyModels.add("TicWatch Pro 3");
        sTelephonyModels.add(TICWATCH_PRO3U_4G);
        sTelephonyModels.add(TICWATCH_PRO3U_4G_BACKUP);
        sTelephonyModels.add(TICWATCH_PRO3X);
        sTelephonyModels.add(TICWATCH_PROX);
        HashSet hashSet3 = new HashSet();
        sWaterproofModels = hashSet3;
        hashSet3.add(TICWATCH_S2);
        sWaterproofModels.add(TICWATCH_E2);
        sWaterproofModels.add(TICWATCH_C2);
        sWaterproofModels.add(TICWATCH_C2_2020);
        HashMap hashMap3 = new HashMap();
        sModelToNfcBusModel = hashMap3;
        hashMap3.put(TICWATCH2_NFC, "WE11108");
        sModelToNfcBusModel.put(TICWATCH2_LILY, "WE11078");
        sModelToNfcBusModel.put(TICWATCH2_LOTUS, "WE11098");
        sModelToNfcBusModel.put(TICWATCH_PRO_4G, "TicWatch AW");
        sModelToNfcBusModel.put(TICWATCH_PRO_BT, "TicWatch AW");
        sModelToNfcBusModel.put("TicWatch Pro 3", "TicWatch Pro 3");
        sModelToNfcBusModel.put("TicWatch Pro 3", "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PRO3_BT, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_C2, "TicWatch AW");
        sModelToNfcBusModel.put(TICWATCH_C2_2020, "TicWatch AW");
        sModelToNfcBusModel.put(TICWATCH_PRO3U_4G, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PRO3U_BT, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PRO3U_4G_BACKUP, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PRO3U_BT_BACKUP, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PRO3X, "TicWatch Pro 3");
        sModelToNfcBusModel.put(TICWATCH_PROX, "TicWatch Pro 3");
    }

    static List<String> getAllModels() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TICWATCH1);
        arrayList.add(TICWATCH1_G);
        arrayList.add(TICWATCH2);
        arrayList.add(TICWATCH2_3G);
        arrayList.add(TICWATCH2_NFC);
        arrayList.add(TICWATCH2_I18N_OLD);
        arrayList.add(TICWATCH2_I18N);
        arrayList.add(TICWATCH2_LILY);
        arrayList.add(TICWATCH2_LOTUS);
        arrayList.add(TICWATCH_S);
        arrayList.add(TICWATCH_E);
        arrayList.add(TICWATCH_PRO_BT);
        arrayList.add(TICWATCH_PRO_4G);
        arrayList.add(TICWATCH_PRO3_BT);
        arrayList.add("TicWatch Pro 3");
        arrayList.add("TicWatch Pro 3");
        arrayList.add(TICWATCH_S2);
        arrayList.add(TICWATCH_E2);
        arrayList.add(TICWATCH_C2);
        arrayList.add(TICWATCH_C2_2020);
        arrayList.add(TICWATCH_PRO3U_4G);
        arrayList.add(TICWATCH_PRO3U_BT);
        arrayList.add(TICWATCH_PRO3U_4G_BACKUP);
        arrayList.add(TICWATCH_PRO3U_BT_BACKUP);
        arrayList.add(TICWATCH_PRO3X);
        arrayList.add(TICWATCH_PROX);
        return arrayList;
    }

    private static String getDeviceModel() {
        return h.c();
    }

    public static String getFixedModel(Context context) {
        String deviceModel = getDeviceModel();
        if (deviceModel.equals(TICWATCH_PRO_BT) && Build.DEVICE.startsWith("catfish_ext")) {
            deviceModel = TICWATCH_PRO_BT_2020;
        }
        return getFixedModel(WatchInfoUtils.getRegion(context), deviceModel);
    }

    public static String getModelForNfcBus() {
        String deviceModel = getDeviceModel();
        String str = sModelToNfcBusModel.get(deviceModel);
        return !r.b(str) ? str : deviceModel;
    }

    private static int getWatchColor() {
        return b.c("hw.ticwatch2.case_color_id", -1);
    }

    public static boolean isBlackWatch() {
        return getWatchColor() == 1 || AwSkuInfo.getColor() == AwSkuInfo.DeviceColor.BLACK;
    }

    public static boolean isC2(String str) {
        return TICWATCH_C2.equals(str);
    }

    public static boolean isChinaRoverU() {
        String deviceModel = getDeviceModel();
        return TICWATCH_PRO3X.equals(deviceModel) || TICWATCH_PROX.equals(deviceModel);
    }

    public static boolean isE2(String str) {
        return TICWATCH_E2.equals(str);
    }

    public static boolean isE3(String str) {
        return TICWATCH_E3.equals(str);
    }

    private static boolean isGlobalVersion(Context context) {
        return WatchInfoUtils.isGlobalVersion(context);
    }

    public static boolean isGoldenWatch() {
        return AwSkuInfo.getColor() == AwSkuInfo.DeviceColor.GOLDEN;
    }

    public static boolean isJupiter() {
        String deviceModel = getDeviceModel();
        return TICWATCH_PRO_BT.equals(deviceModel) || TICWATCH_PRO_4G.equals(deviceModel);
    }

    public static boolean isJupiter4G() {
        return TICWATCH_PRO_4G.equals(getDeviceModel());
    }

    public static boolean isJupiterBt() {
        return TICWATCH_PRO_BT.equals(getDeviceModel());
    }

    public static boolean isLily(String str) {
        return TICWATCH2_LILY.equals(str) || TICWATCH_S.equals(str);
    }

    public static boolean isLotus(String str) {
        return TICWATCH2_LOTUS.equals(str) || TICWATCH_E.equals(str);
    }

    public static boolean isMercuryNfc() {
        return TICWATCH2_NFC.equals(getDeviceModel());
    }

    public static boolean isMooneye() {
        String deviceModel = getDeviceModel();
        return TICWATCH_S.equals(deviceModel) || TICWATCH_E.equals(deviceModel);
    }

    public static boolean isOverseaRoverU() {
        return isOverseaRoverU(getDeviceModel());
    }

    public static boolean isPro2021(String str) {
        return TICWATCH_PRO_2021.equals(str);
    }

    public static boolean isRover(String str) {
        return isRover4G(str) || isRoverBt(str);
    }

    public static boolean isRover3U_4G(String str) {
        return TICWATCH_PRO3U_4G.equals(str) || TICWATCH_PRO3U_4G_BACKUP.equals(str);
    }

    public static boolean isRover3U_BT(String str) {
        return TICWATCH_PRO3U_BT.equals(str) || TICWATCH_PRO3U_BT_BACKUP.equals(str);
    }

    public static boolean isRover3X() {
        return isRover3X(getDeviceModel());
    }

    public static boolean isRover4G(String str) {
        return "TicWatch Pro 3".equals(str) || "TicWatch Pro 3".equals(str);
    }

    public static boolean isRoverBt(String str) {
        return TICWATCH_PRO3_BT.equals(str);
    }

    public static boolean isRoverU() {
        return isRoverU(getDeviceModel());
    }

    public static boolean isSakura(String str) {
        return TICWATCH_C2.equals(str);
    }

    public static boolean isSakura2020(String str) {
        return TICWATCH_C2_2020.equals(str);
    }

    public static boolean isTicPayJupiter() {
        return isJupiterBt() || isJupiter4G();
    }

    public static boolean isTicPayRover() {
        return isRover() || isRoverU();
    }

    public static boolean isTicwatch() {
        return isTicwatch(getDeviceModel());
    }

    public static boolean isTicwatch1() {
        return isTicwatch1(getDeviceModel());
    }

    public static boolean isTicwatch2() {
        return isTicwatch2(getDeviceModel());
    }

    public static boolean isTulip(String str) {
        return TICWATCH_S2.equals(str) || TICWATCH_E2.equals(str);
    }

    public static boolean isWhiteWatch() {
        return getWatchColor() == 2 || AwSkuInfo.getColor() == AwSkuInfo.DeviceColor.WHITE;
    }

    public static boolean isYellowWatch() {
        return getWatchColor() == 3 || AwSkuInfo.getColor() == AwSkuInfo.DeviceColor.YELLOW;
    }

    public static boolean supportAutoMotion() {
        return isRover() || isE3(Build.MODEL) || isRoverU();
    }

    public static boolean supportBankCard() {
        return supportBankCard(getDeviceModel());
    }

    public static boolean supportDoorCard() {
        return supportDoorCard(getDeviceModel());
    }

    public static boolean supportESim() {
        return supportESim(Build.MODEL, TicwatchSysProperties.getCertModel());
    }

    public static boolean supportNewMcuSleepType() {
        return isRover() || isE3(Build.MODEL) || isRoverU();
    }

    public static boolean supportNfc(String str) {
        return sNfcModels.contains(str);
    }

    public static boolean supportTelephony(String str) {
        return sTelephonyModels.contains(str);
    }

    public static boolean supportWaterproof(String str) {
        return TicwatchChannels.isTicWatchPro2021() || TicwatchChannels.isTicWatchPro2020() || sWaterproofModels.contains(str);
    }

    public static String toConvertDeviceModel(String str) {
        if (isRover3X(str)) {
            return TICWATCH_PROX;
        }
        if ("TicWatch_Pro3_4G_LE".equals(str) || "TicWatch Pro 3".equals(str)) {
            return "TicWatch Pro 3";
        }
        if (str.startsWith(TICWATCH_GTW_eSIM)) {
            return TICWATCH_GTW_eSIM;
        }
        return null;
    }

    public static boolean isE3() {
        return isE3(getDeviceModel());
    }

    public static boolean isLily() {
        return isLily(getDeviceModel());
    }

    public static boolean isLotus() {
        return isLotus(getDeviceModel());
    }

    public static boolean isRover() {
        return isRover(getDeviceModel());
    }

    public static boolean isRover3X(String str) {
        return TICWATCH_PRO3X.equals(str) || TICWATCH_PROX.equals(str);
    }

    public static boolean isRover4G() {
        return isRover4G(getDeviceModel());
    }

    public static boolean isRoverBt() {
        return isRoverBt(getDeviceModel());
    }

    public static boolean isSakura() {
        return isSakura(getDeviceModel());
    }

    public static boolean isSakura2020() {
        return isSakura2020(getDeviceModel());
    }

    public static boolean isTicwatch(String str) {
        return str.startsWith(TICWATCH1) || str.startsWith("TicWatch");
    }

    public static boolean isTicwatch1(String str) {
        return TICWATCH1_G.equals(str) | TICWATCH1.equals(str);
    }

    public static boolean isTicwatch2(String str) {
        return str.startsWith(TICWATCH2);
    }

    public static boolean isTulip() {
        return isTulip(getDeviceModel());
    }

    public static boolean supportESim(String str, String str2) {
        if (str.equals(TICWATCH_PRO_4G)) {
            return !CertModels.PRO_4G_US_VERIZON.equals(str2);
        }
        return supportTelephony(str);
    }

    public static boolean supportTelephony() {
        return supportTelephony(getDeviceModel());
    }

    public static boolean isJupiter(String str) {
        return TICWATCH_PRO_BT.equals(str) || TICWATCH_PRO_4G.equals(str);
    }

    public static boolean isOverseaRoverU(String str) {
        return TICWATCH_PRO3U_4G.equals(str) || TICWATCH_PRO3U_BT.equals(str) || TICWATCH_PRO3U_4G_BACKUP.equals(str) || TICWATCH_PRO3U_BT_BACKUP.equals(str);
    }

    public static boolean isRoverU(String str) {
        return TICWATCH_PRO3U_4G.equals(str) || TICWATCH_PRO3U_BT.equals(str) || TICWATCH_PRO3U_4G_BACKUP.equals(str) || TICWATCH_PRO3U_BT_BACKUP.equals(str) || TICWATCH_PRO3X.equals(str) || TICWATCH_PROX.equals(str);
    }

    public static boolean supportBankCard(String str) {
        return isTicwatch2(str) || isC2(str) || isSakura2020(str) || TICWATCH_PRO_BT.equals(str) || TICWATCH_PRO_4G.equals(str);
    }

    public static boolean supportDoorCard(String str) {
        return "TicWatch Pro 3".equals(str) || TICWATCH_PRO3_BT.equals(str) || TICWATCH_PRO3U_4G.equals(str) || TICWATCH_PRO3U_BT.equals(str) || TICWATCH_PRO3U_4G_BACKUP.equals(str) || TICWATCH_PRO3U_BT_BACKUP.equals(str) || TICWATCH_PRO3X.equals(str) || TICWATCH_PROX.equals(str);
    }

    static String getFixedModel(Context context, String str) {
        return getFixedModel(WatchInfoUtils.getRegion(context), str);
    }

    public static String getFixedModel(String str, String str2) {
        String str3 = (WatchInfoUtils.isGlobalVersion(str) ? sFixedModelsGlobal : sFixedModelsChina).get(str2);
        return !r.b(str3) ? str3 : str2;
    }
}
