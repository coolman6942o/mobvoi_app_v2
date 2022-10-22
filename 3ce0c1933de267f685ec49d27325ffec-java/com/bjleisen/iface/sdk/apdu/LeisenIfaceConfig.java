package com.bjleisen.iface.sdk.apdu;

import android.os.Build;
import android.os.RemoteException;
import com.bjleisen.bluetooth.DeviceInfo;
import com.bjleisen.bluetooth.IBluetoothInterfaceService;
import com.bjleisen.bluetooth.IMultiBluetoothInterface;
import com.bjleisen.iface.sdk.base.IApduBaseHandler;
import com.bjleisen.iface.sdk.enums.EnumCardAppType;
import g9.a;
import g9.c;
import h9.b;
/* loaded from: classes.dex */
public class LeisenIfaceConfig {
    protected static final int A = 20482;
    protected static final int B = 20483;
    protected static final int C = 20484;
    public static final String CARD_DATE_FORMAT = "yyyyMMdd";
    protected static final int D = 20485;
    protected static final int E = 20486;
    protected static final int F = 20487;
    protected static final int G = 20488;
    protected static final int H = 20489;
    protected static final int I = 1;
    protected static final int J = 2;
    protected static final int K = 3;
    public static final String KEY_CARD_TEMPLATE = "card_info_template";
    public static final String KEY_TRADE_TEMPLATE = "trade_info_template";
    protected static final int L = 4;
    protected static final int M = 5;
    public static final int MONEY_TYPE_PAY = 1;
    public static final int MONEY_TYPE_RECHARGE = 2;
    protected static final int N = 6;
    public static final int NOTIFY_TYPE_OPENCARD = 0;
    public static final int NOTIFY_TYPE_RESET = 1;
    protected static final int O = 7;
    public static final int ORDER_STATUS_ALLOW_REFUND = 30;
    public static final int ORDER_STATUS_INSTALL_FAILURE = 22;
    public static final int ORDER_STATUS_INSTALL_SUCCESS = 21;
    public static final int ORDER_STATUS_NOT_PAID = 1;
    public static final int ORDER_STATUS_OPENCARD_ABNORMAL = 13;
    public static final int ORDER_STATUS_OPENCARD_FAILURE = 12;
    public static final int ORDER_STATUS_OPENCARD_SUCCESS = 11;
    public static final int ORDER_STATUS_PAID = 2;
    public static final int ORDER_STATUS_RECHARGE_ABNORMAL = 5;
    public static final int ORDER_STATUS_RECHARGE_FAILURE = 4;
    public static final int ORDER_STATUS_RECHARGE_SUCCESS = 3;
    public static final int ORDER_STATUS_REFUNDED = 32;
    public static final int ORDER_STATUS_REFUND_CHECK = 31;
    public static final int ORDER_STATUS_TO_BE_CONFIRMED = 6;
    protected static final int P = 8;
    public static final int PAYWAY_ALIPAY = 1;
    public static final int PAYWAY_BAIDU_WALLET = 2;
    public static final int PAYWAY_MONEY = 7;
    public static final int PAYWAY_OTHER_PARTNER = 5;
    public static final int PAYWAY_UNIONPAY = 4;
    public static final int PAYWAY_WEIXIN_WALLET = 3;
    protected static final int Q = 9;
    protected static final int R = 0;
    public static final int RECHARGE_TYPE_ABNORMAL = 2;
    public static final int RECHARGE_TYPE_FAILURE = 1;
    public static final int RECHARGE_TYPE_MOVE_BALANCE = 3;
    public static final int RECHARGE_TYPE_NORMAL = 0;
    public static final int RECHARGE_TYPE_ONLINE = 4;
    public static final int RECHARGE_TYPE_TRANSFER_BALANCE = 5;
    protected static final int S = 1;
    protected static final int T = 1;
    public static int TIME_OUT = 40000;
    public static final int TRANSSTATUS_OPEN_AND_RECHARGE = 3;
    public static final int TRANSSTATUS_OPEN_CARD = 1;
    public static final int TRANSSTATUS_RECHARGE = 2;
    public static final int TRANSSTATUS_RECOVER = 11;
    public static final int TRANSSTATUS_REMOVAL = 10;
    protected static final int U = 2;
    protected static String V = "00A4040007A0000001510000";
    protected static final String W = "80CA9F7F00";
    protected static final String X = "80CA004200";
    protected static final String Y = "80CA004500";
    protected static final String Z = "9156000014010001";

    /* renamed from: a  reason: collision with root package name */
    protected static final int f7666a = 1;
    protected static String aA = null;
    protected static String aB = null;
    protected static String aC = null;
    protected static String aD = null;
    protected static String aE = null;
    protected static String aF = null;
    protected static String aG = null;
    protected static DeviceInfo aH = null;
    private static volatile LeisenIfaceConfig aI = null;
    private static Object aJ = new Object();

    /* renamed from: aa  reason: collision with root package name */
    protected static final String f7667aa = "A00000063201010510009156000014A1";

    /* renamed from: ab  reason: collision with root package name */
    protected static final String f7668ab = "535A542E57414C4C45542E454E56";

    /* renamed from: ac  reason: collision with root package name */
    protected static final String f7669ac = "A00000000386980701";

    /* renamed from: ad  reason: collision with root package name */
    protected static final String f7670ad = "D1560001360103000057485401000001";

    /* renamed from: ae  reason: collision with root package name */
    protected static final String f7671ae = "D1560001360103898884877201000001";

    /* renamed from: af  reason: collision with root package name */
    protected static final String f7672af = "D156000015CCECB8AECDA8BFA8";

    /* renamed from: ag  reason: collision with root package name */
    protected static final String f7673ag = "A00000063201010501592610FF000000";

    /* renamed from: ah  reason: collision with root package name */
    protected static final String f7674ah = "A00000063201010601131121FF000000";

    /* renamed from: ai  reason: collision with root package name */
    protected static final String f7675ai = "D1560001360103887789847501000001";

    /* renamed from: aj  reason: collision with root package name */
    protected static final String f7676aj = "A00000063201010501131121FF000000";

    /* renamed from: ak  reason: collision with root package name */
    protected static final String f7677ak = "http://219.239.243.149:10014/apkp/LaserOpenTsmServer/applicationBusiness.action";

    /* renamed from: al  reason: collision with root package name */
    protected static final String f7678al = "https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action";

    /* renamed from: am  reason: collision with root package name */
    protected static final String f7679am = "http://219.239.243.149:10009/apkp/LaserOpenTsmServer/applicationBusiness.action";

    /* renamed from: an  reason: collision with root package name */
    protected static final String f7680an = "https://www.opentsm.cn:7004/apkp/LaserOpenTsmServer/applicationBusiness.action";

    /* renamed from: ao  reason: collision with root package name */
    protected static String f7681ao = "";

    /* renamed from: ap  reason: collision with root package name */
    protected static IApduBaseHandler f7682ap = null;

    /* renamed from: aq  reason: collision with root package name */
    protected static IBluetoothInterfaceService f7683aq = null;
    protected static IMultiBluetoothInterface ar = null;
    protected static String as = null;
    protected static String at = "00000000000";
    protected static String au = "";
    protected static int av = 1;
    protected static String aw = "1.0";
    protected static String ax = null;
    protected static String ay = null;
    protected static String az = null;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f7684b = 2;

    /* renamed from: c  reason: collision with root package name */
    protected static final int f7685c = 3;

    /* renamed from: d  reason: collision with root package name */
    protected static final int f7686d = 4;

    /* renamed from: e  reason: collision with root package name */
    protected static final int f7687e = 5;

    /* renamed from: f  reason: collision with root package name */
    protected static final int f7688f = 6;

    /* renamed from: g  reason: collision with root package name */
    protected static final int f7689g = 7;

    /* renamed from: h  reason: collision with root package name */
    protected static final int f7690h = 8;

    /* renamed from: i  reason: collision with root package name */
    protected static final int f7691i = 9;

    /* renamed from: j  reason: collision with root package name */
    protected static final int f7692j = 16;

    /* renamed from: k  reason: collision with root package name */
    protected static final int f7693k = 17;

    /* renamed from: l  reason: collision with root package name */
    protected static final int f7694l = 4097;

    /* renamed from: m  reason: collision with root package name */
    protected static final int f7695m = 4098;

    /* renamed from: n  reason: collision with root package name */
    protected static final int f7696n = 4099;

    /* renamed from: o  reason: collision with root package name */
    protected static final int f7697o = 4100;

    /* renamed from: p  reason: collision with root package name */
    protected static final int f7698p = 4101;

    /* renamed from: q  reason: collision with root package name */
    protected static final int f7699q = 8193;

    /* renamed from: r  reason: collision with root package name */
    protected static final int f7700r = 8194;

    /* renamed from: s  reason: collision with root package name */
    protected static final int f7701s = 12289;

    /* renamed from: t  reason: collision with root package name */
    protected static final int f7702t = 12290;

    /* renamed from: u  reason: collision with root package name */
    protected static final int f7703u = 12291;

    /* renamed from: v  reason: collision with root package name */
    protected static final int f7704v = 12292;

    /* renamed from: w  reason: collision with root package name */
    protected static final int f7705w = 12293;

    /* renamed from: x  reason: collision with root package name */
    protected static final int f7706x = 16385;

    /* renamed from: y  reason: collision with root package name */
    protected static final int f7707y = 16386;

    /* renamed from: z  reason: collision with root package name */
    protected static final int f7708z = 20481;

    private LeisenIfaceConfig() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LeisenIfaceConfig a() {
        if (aI == null) {
            synchronized (aJ) {
                if (aI == null) {
                    aI = new LeisenIfaceConfig();
                }
            }
        }
        return aI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b() {
        aD = null;
        aE = null;
        aG = null;
        aH = null;
        aF = null;
    }

    public static EnumCardAppType getCardTypeByInstanceAid(String str) {
        if (f7668ab.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_SZT;
        }
        if (Z.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_BJT;
        }
        if (f7670ad.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_WHT;
        }
        if (f7672af.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_TFT;
        }
        if (f7674ah.equalsIgnoreCase(str) || f7676aj.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_TJT;
        }
        if (f7671ae.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_WHT2;
        }
        if (f7673ag.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_HCT;
        }
        if (f7669ac.equalsIgnoreCase(str)) {
            return EnumCardAppType.CARD_APP_TYPE_SHT;
        }
        return null;
    }

    public void clearConfigData() {
        b.d("clearConfigData");
        as = null;
        at = "";
        au = "";
        b();
        IBluetoothInterfaceService iBluetoothInterfaceService = f7683aq;
        if (iBluetoothInterfaceService != null) {
            try {
                iBluetoothInterfaceService.disconnectBluetoothDevice();
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
            f7683aq = null;
            b.d("clearConfigData:" + f7683aq);
        }
        IMultiBluetoothInterface iMultiBluetoothInterface = ar;
        if (iMultiBluetoothInterface != null) {
            iMultiBluetoothInterface.disconnectBluetoothDevice();
            ar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, int i10) {
        b.d("init base info");
        au = str;
        TIME_OUT = i10;
        ax = a.b();
        ay = c.b();
        aA = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        aB = str2;
        aG = str2;
        as = a.c();
        aC = c.a();
        az = a.a(as);
    }
}
