package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bjleisen.bluetooth.DeviceInfo;
import com.bjleisen.bluetooth.IBluetoothInterfaceService;
import com.bjleisen.bluetooth.IMultiBluetoothInterface;
import com.bjleisen.iface.sdk.base.IApduBaseHandler;
import com.bjleisen.iface.sdk.bean.AppletFlag;
import com.bjleisen.iface.sdk.bean.CardInfo;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.TradeInfo;
import com.bjleisen.iface.sdk.bean.req.ReservedField;
import com.bjleisen.iface.sdk.bean.resp.ActionBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.AppletDetailBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.AppletListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.BJTCardInfo;
import com.bjleisen.iface.sdk.bean.resp.BaseBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.CardTemplateRespInfo;
import com.bjleisen.iface.sdk.bean.resp.FavorableBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.NoticeRespInfo;
import com.bjleisen.iface.sdk.bean.resp.OrderListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderCalculateBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderStatusBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppType;
import com.bjleisen.iface.sdk.enums.EnumDeviceType;
import com.bjleisen.iface.sdk.enums.EnumEnvType;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import com.bjleisen.iface.sdk.util.BjtCardInfoUtil;
import com.bjleisen.iface.sdk.util.CardInfoParserUtil;
import com.bjleisen.iface.sdk.util.HctCardInfoUtil;
import com.bjleisen.iface.sdk.util.SztCardInfoUtil;
import com.bjleisen.iface.sdk.util.TftCardInfoUtil;
import com.bjleisen.iface.sdk.util.TjtCardInfoUtil;
import com.bjleisen.iface.sdk.util.WhtCardInfoUtil;
import com.bjleisen.iface.sdk.util.YxtCardInfoUtil;
import com.mobvoi.wear.location.FusedLocationConstants;
import f9.a;
import g9.d;
import h9.b;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class LeisenIfaceOperator implements g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile LeisenIfaceOperator f7709a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Object f7710b = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static final String f7711h = "LeisenIfaceOperator";

    /* renamed from: c  reason: collision with root package name */
    private k f7712c;

    /* renamed from: d  reason: collision with root package name */
    private int f7713d = EnumStatusCode.STATUS_SUCCESS.getStatus();

    /* renamed from: e  reason: collision with root package name */
    private String f7714e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f7715f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f7716g = null;

    private LeisenIfaceOperator() {
    }

    private static int a() {
        return 146;
    }

    private static int a(DeviceInfo deviceInfo) {
        IBluetoothInterfaceService iBluetoothInterfaceService = LeisenIfaceConfig.f7683aq;
        if (iBluetoothInterfaceService != null) {
            try {
                return iBluetoothInterfaceService.getDeviceInfo(deviceInfo);
            } catch (RemoteException unused) {
            }
        }
        IMultiBluetoothInterface iMultiBluetoothInterface = LeisenIfaceConfig.ar;
        if (iMultiBluetoothInterface != null) {
            return iMultiBluetoothInterface.getDeviceInfo(deviceInfo);
        }
        return EnumStatusCode.STATUS_CONNECTION_DEVICE_FAILURE.getStatus();
    }

    private static void b(DeviceInfo deviceInfo) {
        LeisenIfaceConfig.aH = deviceInfo;
        LeisenIfaceConfig.aG = deviceInfo.getDeviceModel();
        if (!TextUtils.isEmpty(deviceInfo.getDeviceBaseVersion())) {
            LeisenIfaceConfig.aC = deviceInfo.getDeviceBaseVersion();
        }
    }

    public static LeisenIfaceOperator getInstance() {
        if (f7709a == null) {
            synchronized (f7710b) {
                if (f7709a == null) {
                    f7709a = new LeisenIfaceOperator();
                }
            }
        }
        return f7709a;
    }

    public RespInfo<BaseBusiRespInfo> appletInfoSync(String str, String str2, int i10) {
        RespInfo<BaseBusiRespInfo> b10 = this.f7712c.b(str, str2, i10);
        if (b10 != null) {
            return a(b10.getStatus(), b10.getDesc());
        }
        EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_REQUEST_FAILURE;
        return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
    }

    public RespInfo<BaseBusiRespInfo> applyIssueCard(String str, String str2, String str3) {
        return applyIssueCard(str, str2, null, null, str3, null);
    }

    public RespInfo<BaseBusiRespInfo> applyRefund(String str) {
        if (TextUtils.isEmpty(str)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        }
        RespInfo<BaseBusiRespInfo> c10 = this.f7712c.c(str);
        if (c10 != null) {
            return a(c10.getStatus(), c10.getDesc());
        }
        EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_REQUEST_FAILURE;
        return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
    }

    public void cancelRequest() {
        this.f7712c.i();
    }

    public void clearData() {
        LeisenIfaceConfig.a().clearConfigData();
        this.f7713d = EnumStatusCode.STATUS_SUCCESS.getStatus();
        this.f7714e = null;
        this.f7715f = null;
        this.f7716g = null;
    }

    public void clearDeviceData() {
        LeisenIfaceConfig.a();
        LeisenIfaceConfig.b();
        this.f7713d = EnumStatusCode.STATUS_SUCCESS.getStatus();
        this.f7714e = null;
        this.f7715f = null;
        this.f7716g = null;
    }

    public RespInfo<BaseBusiRespInfo> deleteApplet(String str, String str2) {
        return deleteApplet(str, str2, null, null, null);
    }

    public ApduLocalMultiExeCallback getApduLocalMultiExeCallback() {
        return this.f7712c.h();
    }

    public RespInfo<AppletDetailBusiRespInfo> getAppletDetailInfo(String str, String str2, int i10) {
        return this.f7712c.a(str, str2, i10);
    }

    public RespInfo<AppletListBusiRespInfo> getAppletList() {
        return this.f7712c.b();
    }

    public String getCIN() {
        this.f7712c.f();
        if (!TextUtils.isEmpty(this.f7714e) && !TextUtils.isEmpty(this.f7715f) && this.f7715f.endsWith("9000")) {
            this.f7714e.substring(0, 2);
            this.f7714e = this.f7714e.substring(4, (Integer.parseInt(this.f7714e.substring(2, 4), 16) << 1) + 4);
        }
        return this.f7714e;
    }

    public String getCPLC() {
        LeisenIfaceConfig.aD = "";
        this.f7712c.e();
        if (!TextUtils.isEmpty(this.f7714e) && !TextUtils.isEmpty(this.f7715f) && this.f7715f.endsWith("9000")) {
            setCPLC(this.f7714e);
        }
        return LeisenIfaceConfig.aD;
    }

    public RespInfo<PayOrderCalculateBusiRespInfo> getCalculatePayOrderInfo(String str, String str2, int i10, int i11) {
        return this.f7712c.a(str, str2, i10, i11);
    }

    public synchronized String getCardInfo(String str) {
        Context applicationContext = a.a().getApplicationContext();
        String a10 = d.a(applicationContext, LeisenIfaceConfig.KEY_CARD_TEMPLATE + str);
        if (TextUtils.isEmpty(a10)) {
            RespInfo<CardTemplateRespInfo> a11 = this.f7712c.a(str, 1);
            if (a11 == null) {
                b.f("模板数据获取失败");
                return null;
            } else if (a11.getStatus() != EnumStatusCode.STATUS_SUCCESS.getStatus()) {
                b.f("getCardInfo:" + a11.getDesc());
                return null;
            } else {
                if (a11.getBusiRespInfo() != null && !TextUtils.isEmpty(a11.getBusiRespInfo().getTemplateInfo())) {
                    a10 = a11.getBusiRespInfo().getTemplateInfo();
                    Context applicationContext2 = a.a().getApplicationContext();
                    d.c(applicationContext2, LeisenIfaceConfig.KEY_CARD_TEMPLATE + str, a10);
                }
                b.f("模板数据返回空");
                return null;
            }
        }
        return CardInfoParserUtil.parserCardInfoDelayMatchSw(a10, this.f7712c.h());
    }

    public RespInfo<FavorableBusiRespInfo> getFavoradbleMsgs() {
        return this.f7712c.c();
    }

    public String getIIN() {
        this.f7712c.g();
        if (!TextUtils.isEmpty(this.f7714e) && !TextUtils.isEmpty(this.f7715f) && this.f7715f.endsWith("9000")) {
            this.f7714e.substring(0, 2);
            this.f7714e = this.f7714e.substring(4, (Integer.parseInt(this.f7714e.substring(2, 4), 16) << 1) + 4);
        }
        return this.f7714e;
    }

    public RespInfo<NoticeRespInfo> getOffcialNoticeList() {
        return this.f7712c.d();
    }

    public RespInfo<PayOrderBusiRespInfo> getPayOrder(String str, String str2, int i10, int i11, String str3, int i12, int i13) {
        if (!TextUtils.isEmpty(str)) {
            return this.f7712c.a(str, str2, i10, i11, str3, i12, i13, (String) null);
        }
        throw new NullPointerException("instanceAid is null");
    }

    public RespInfo<PayOrderBusiRespInfo> getRecoverOrder(String str) {
        return getPayOrder(str, null, 0, 11, null, 1, 1);
    }

    public RespInfo<PayOrderBusiRespInfo> getRemovalOrder(String str, String str2) {
        return getPayOrder(str, str2, 0, 10, null, 1, 1);
    }

    public String getSDKVersion() {
        return "1.4.8";
    }

    public String getSEID(String str) {
        if (str == null || str.length() <= 36) {
            return null;
        }
        if (str.startsWith("9f7f") || str.startsWith("9F7F")) {
            str = str.substring(6, str.length());
        }
        setSEID(str.substring(24, 36));
        return LeisenIfaceConfig.aE;
    }

    public synchronized String getTradeInfo(String str) {
        Context applicationContext = a.a().getApplicationContext();
        String a10 = d.a(applicationContext, LeisenIfaceConfig.KEY_TRADE_TEMPLATE + str);
        if (TextUtils.isEmpty(a10)) {
            RespInfo<CardTemplateRespInfo> a11 = this.f7712c.a(str, 2);
            if (a11 == null) {
                b.f("模板数据获取失败");
                return null;
            } else if (a11.getStatus() != EnumStatusCode.STATUS_SUCCESS.getStatus()) {
                b.f("getTradeInfo:" + a11.getDesc());
                return null;
            } else {
                if (a11.getBusiRespInfo() != null && !TextUtils.isEmpty(a11.getBusiRespInfo().getTemplateInfo())) {
                    a10 = a11.getBusiRespInfo().getTemplateInfo();
                    Context applicationContext2 = a.a().getApplicationContext();
                    d.c(applicationContext2, LeisenIfaceConfig.KEY_TRADE_TEMPLATE + str, a10);
                }
                b.f("模板数据返回空");
                return null;
            }
        }
        return CardInfoParserUtil.parserTradeInfo(a10, this.f7712c.h());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RespInfo<BaseBusiRespInfo> getVerificationCode(String str, String str2, String str3, int i10, String str4) {
        LeisenIfaceOperator leisenIfaceOperator;
        RespInfo<BaseBusiRespInfo> a10;
        setMsisdn(str);
        int i11 = h.f7757b[LeisenIfaceConfig.getCardTypeByInstanceAid(str2).ordinal()];
        int i12 = 0;
        if (i11 != 1) {
            if (i11 == 2) {
                leisenIfaceOperator = this;
                i12 = 1;
            } else if (i11 == 3) {
                leisenIfaceOperator = this;
                i12 = 2;
            }
            a10 = leisenIfaceOperator.f7712c.a(str, str2, i12, str3, i10, str4);
            if (a10 == null) {
                return a(a10.getStatus(), a10.getDesc());
            }
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_REQUEST_FAILURE;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        }
        leisenIfaceOperator = this;
        a10 = leisenIfaceOperator.f7712c.a(str, str2, i12, str3, i10, str4);
        if (a10 == null) {
        }
    }

    public void init(Context context, EnumDeviceType enumDeviceType) {
        init(context, enumDeviceType, FusedLocationConstants.DEFAULT_INTERVAL);
    }

    public int initBluetoothDeviceInfo() {
        DeviceInfo deviceInfo = new DeviceInfo();
        if (a(deviceInfo) != 0) {
            return EnumStatusCode.STATUS_GET_DEVICEINFO_FAILURE.getStatus();
        }
        b(deviceInfo);
        return EnumStatusCode.STATUS_SUCCESS.getStatus();
    }

    public RespInfo<BaseBusiRespInfo> installApplet(String str, String str2, String str3) {
        return installApplet(str, str2, str3, null, null, new AppletFlag(str));
    }

    public RespInfo<BaseBusiRespInfo> lockApplet(String str, String str2) {
        return lockApplet(str, str2, null, null, null);
    }

    @Override // com.bjleisen.iface.sdk.apdu.g
    public void onOperFailure(int i10, Error error) {
        this.f7714e = null;
        this.f7715f = null;
        this.f7713d = i10;
        this.f7716g = error.getMessage();
    }

    @Override // com.bjleisen.iface.sdk.apdu.g
    public void onOperSuccess(Rapdu rapdu) {
        EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_SUCCESS;
        this.f7713d = enumStatusCode.getStatus();
        this.f7716g = enumStatusCode.getMsg();
        if (rapdu != null) {
            this.f7714e = rapdu.getRapdu();
            this.f7715f = rapdu.getSw();
        }
    }

    public RespInfo<BaseBusiRespInfo> personalApplet(String str, String str2, String str3) {
        return personalApplet(str, str2, str3, null);
    }

    public RespInfo<ActionBusiRespInfo> queryActivities(String str, int i10) {
        return this.f7712c.b(str, i10);
    }

    public RespInfo<BJTCardInfo> queryBJTCardNum(String str) {
        return this.f7712c.a(str);
    }

    public RespInfo<OrderListBusiRespInfo> queryBusinessOrderLists(String str, int i10, int i11, int i12) {
        if (!TextUtils.isEmpty(str)) {
            return this.f7712c.a(str, i10, i11, i12);
        }
        b.f("appletAid must not be null");
        return null;
    }

    public RespInfo<PayOrderStatusBusiRespInfo> queryPayOrderStatus(String str) {
        return this.f7712c.b(str);
    }

    public RespInfo<BaseBusiRespInfo> recharge(String str) {
        return recharge(str, null);
    }

    public RespInfo<BaseBusiRespInfo> recoverApplet(String str, String str2, String str3) {
        return recoverApplet(str, str2, str3, null);
    }

    public RespInfo<BaseBusiRespInfo> recoverAppletByRemovalCode(String str, String str2, String str3) {
        return recoverAppletByRemovalCode(str, str2, str3, null);
    }

    public RespInfo<BaseBusiRespInfo> registerNew() {
        if (!(LeisenIfaceConfig.f7683aq == null && LeisenIfaceConfig.ar == null)) {
            DeviceInfo deviceInfo = new DeviceInfo();
            if (a(deviceInfo) == 0) {
                b(deviceInfo);
            } else {
                EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_GET_DEVICEINFO_FAILURE;
                return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
            }
        }
        if (TextUtils.isEmpty(LeisenIfaceConfig.aD) || TextUtils.isEmpty(LeisenIfaceConfig.aE)) {
            String cplc = getCPLC();
            if (TextUtils.isEmpty(cplc)) {
                EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
                return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
            }
            setSEID(getSEID(cplc));
        }
        RespInfo<BaseBusiRespInfo> a10 = this.f7712c.a();
        if (a10 != null) {
            return a(a10.getStatus(), a10.getDesc());
        }
        EnumStatusCode enumStatusCode3 = EnumStatusCode.STATUS_REQUEST_FAILURE;
        return a(enumStatusCode3.getStatus(), enumStatusCode3.getMsg());
    }

    public RespInfo<BaseBusiRespInfo> removeApplet(String str, String str2, String str3) {
        return removeApplet(str, str2, str3, null, null, null);
    }

    public RespInfo<BaseBusiRespInfo> requestUserAuthentication() {
        if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        }
        RespInfo<BaseBusiRespInfo> a10 = this.f7712c.a();
        if (a10 != null) {
            return a(a10.getStatus(), a10.getDesc());
        }
        EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_REQUEST_FAILURE;
        return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
    }

    public void setApduHandler(IApduBaseHandler iApduBaseHandler) {
        LeisenIfaceConfig.f7682ap = iApduBaseHandler;
    }

    public void setCPLC(String str) {
        if (str != null) {
            if (str.startsWith("9f7f") || str.startsWith("9F7F")) {
                str = str.substring(6, (Integer.parseInt(str.substring(4, 6), 16) << 1) + 6);
            }
            LeisenIfaceConfig.aD = str;
        }
        b.f("cplc: " + str);
    }

    public void setDeviceBasePhoneVersion(String str) {
        LeisenIfaceConfig.aC = str;
    }

    public void setDeviceModel(String str) {
        LeisenIfaceConfig.aG = str;
    }

    public void setDeviceOSVersion(String str) {
        LeisenIfaceConfig.aA = str;
    }

    public void setIBluetoothInterfaceService(IBluetoothInterfaceService iBluetoothInterfaceService) {
        Objects.requireNonNull(iBluetoothInterfaceService, "bluetoothInterfaceService is null");
        LeisenIfaceConfig.f7683aq = iBluetoothInterfaceService;
    }

    public void setIMultiBluetoothInterfaceService(IMultiBluetoothInterface iMultiBluetoothInterface) {
        Objects.requireNonNull(iMultiBluetoothInterface, "bluetoothInterfaceService is null");
        LeisenIfaceConfig.ar = iMultiBluetoothInterface;
    }

    public void setMsisdn(String str) {
        LeisenIfaceConfig.at = str;
    }

    public void setRequestUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            LeisenIfaceConfig.f7681ao = str;
        }
    }

    public void setSEID(String str) {
        if (str != null) {
            LeisenIfaceConfig.aE = str;
        }
    }

    public void setSeTsmId(String str) {
        LeisenIfaceConfig.au = str;
    }

    public void setSelectISDApdu(String str) {
        if (TextUtils.isEmpty(str)) {
            LeisenIfaceConfig.V = str;
        }
    }

    public void setUserId(String str) {
        LeisenIfaceConfig.aF = str;
    }

    public String subSeidFromCplc(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 36) {
            return null;
        }
        if (str.startsWith("9f7f") || str.startsWith("9F7F")) {
            str = str.substring(6, (Integer.parseInt(str.substring(4, 6), 16) << 1) + 6);
        }
        String substring = str.substring(0, 4);
        String substring2 = str.substring(20, 36);
        setSEID(substring + substring2);
        return LeisenIfaceConfig.aE;
    }

    public void switchEnv(EnumEnvType enumEnvType) {
        int i10 = h.f7756a[enumEnvType.ordinal()];
        if (i10 == 1) {
            LeisenIfaceConfig.f7681ao = "http://219.239.243.149:10009/apkp/LaserOpenTsmServer/applicationBusiness.action";
        } else if (i10 == 2) {
            LeisenIfaceConfig.f7681ao = "https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action";
        } else if (i10 == 3) {
            LeisenIfaceConfig.f7681ao = "http://219.239.243.149:10014/apkp/LaserOpenTsmServer/applicationBusiness.action";
        } else if (i10 != 4) {
            LeisenIfaceConfig.f7681ao = "https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action";
        } else {
            LeisenIfaceConfig.f7681ao = "https://www.opentsm.cn:7004/apkp/LaserOpenTsmServer/applicationBusiness.action";
        }
    }

    public RespInfo<BaseBusiRespInfo> unlockApplet(String str, String str2) {
        return unlockApplet(str, str2, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0 != 3) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RespInfo<BaseBusiRespInfo> verifyMessageCode(String str, String str2) {
        RespInfo<BaseBusiRespInfo> a10;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        }
        int i10 = h.f7757b[LeisenIfaceConfig.getCardTypeByInstanceAid(str).ordinal()];
        int i11 = 2;
        i11 = 0;
        if (i10 != 1) {
            if (i10 == 2) {
                i11 = 1;
            }
            a10 = this.f7712c.a(str, i11, str2);
            if (a10 == null) {
                return a(a10.getStatus(), a10.getDesc());
            }
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_REQUEST_FAILURE;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        }
        a10 = this.f7712c.a(str, i11, str2);
        if (a10 == null) {
        }
    }

    public RespInfo<BaseBusiRespInfo> verifyRemovalCode(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        }
        RespInfo<BaseBusiRespInfo> a10 = this.f7712c.a(str, str2);
        if (a10 != null) {
            return a(a10.getStatus(), a10.getDesc());
        }
        EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_REQUEST_FAILURE;
        return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
    }

    public RespInfo<BaseBusiRespInfo> applyIssueCard(String str, String str2, String str3, String str4, String str5, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(6, str, str2, str5, str3, str4, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> deleteApplet(String str, String str2, String str3, String str4, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(2, str, str2, (String) null, str3, str4, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public void init(Context context, EnumDeviceType enumDeviceType, int i10) {
        init(context, enumDeviceType, "", i10);
    }

    public RespInfo<BaseBusiRespInfo> lockApplet(String str, String str2, String str3, String str4, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(3, str, str2, (String) null, str3, str4, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> personalApplet(String str, String str2, String str3, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(5, str, str2, str3, (String) null, (String) null, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> recharge(String str, ReservedField reservedField) {
        if (TextUtils.isEmpty(str)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(str, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> recoverApplet(String str, String str2, String str3, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(9, str, str2, str3, (String) null, (String) null, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> recoverAppletByRemovalCode(String str, String str2, String str3, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(7, str, str2, (String) null, (String) null, (String) null, str3, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> removeApplet(String str, String str2, String str3, String str4, String str5, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(8, str, str2, str3, str4, str5, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<BaseBusiRespInfo> unlockApplet(String str, String str2, String str3, String str4, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(4, str, str2, (String) null, str3, str4, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public void init(Context context, EnumDeviceType enumDeviceType, String str, int i10) {
        Objects.requireNonNull(context, "context must not be null");
        Objects.requireNonNull(enumDeviceType, "deviceType must not be null");
        LeisenIfaceConfig.a();
        LeisenIfaceConfig.a(str, i10);
        k kVar = new k(context, enumDeviceType);
        this.f7712c = kVar;
        kVar.a(this);
    }

    public RespInfo<BaseBusiRespInfo> installApplet(String str, String str2, String str3, String str4, String str5, ReservedField reservedField) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_NULL_PARAMS;
            return a(enumStatusCode.getStatus(), enumStatusCode.getMsg());
        } else if (TextUtils.isEmpty(LeisenIfaceConfig.aD)) {
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_CPLC_IS_NULL;
            return a(enumStatusCode2.getStatus(), enumStatusCode2.getMsg());
        } else {
            this.f7712c.a(1, str, str2, str3, str4, str5, (String) null, reservedField);
            return a(this.f7713d, this.f7716g);
        }
    }

    public RespInfo<PayOrderBusiRespInfo> getPayOrder(String str, String str2, int i10, int i11, String str3) {
        return this.f7712c.a(str, str2, i10, i11, "", 5, 1, str3);
    }

    public RespInfo<PayOrderBusiRespInfo> getPayOrder(String str, String str2, int i10, int i11, String str3, int i12, int i13, String str4) {
        return this.f7712c.a(str, str2, i10, i11, str3, i12, i13, str4);
    }

    private static RespInfo<BaseBusiRespInfo> a(int i10, String str) {
        RespInfo<BaseBusiRespInfo> respInfo = new RespInfo<>();
        respInfo.setDesc(str);
        respInfo.setStatus(i10);
        return respInfo;
    }

    public synchronized CardInfo getCardInfo(EnumCardAppType enumCardAppType) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        switch (h.f7757b[enumCardAppType.ordinal()]) {
            case 1:
                return BjtCardInfoUtil.getBjtCardInfo(this.f7712c.h());
            case 2:
                return SztCardInfoUtil.getSztCardInfo(this.f7712c.h());
            case 3:
                return WhtCardInfoUtil.getWhtCardInfo(this.f7712c.h());
            case 4:
                return TftCardInfoUtil.getTftCardInfo(this.f7712c.h());
            case 5:
                return TjtCardInfoUtil.getTjtCardInfo(this.f7712c.h());
            case 6:
                return YxtCardInfoUtil.getWhtCardInfo(this.f7712c.h());
            case 7:
                return HctCardInfoUtil.getHctCardInfo(this.f7712c.h());
            default:
                return null;
        }
    }

    public synchronized List<TradeInfo> getTradeInfo(EnumCardAppType enumCardAppType) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        switch (h.f7757b[enumCardAppType.ordinal()]) {
            case 1:
                return BjtCardInfoUtil.getBjtTradeInfo(this.f7712c.h());
            case 2:
                return SztCardInfoUtil.getSztTradeInfo(this.f7712c.h());
            case 3:
                return WhtCardInfoUtil.getWhtTradeInfo(this.f7712c.h());
            case 4:
                return TftCardInfoUtil.getTftTradeInfo(this.f7712c.h());
            case 5:
                return TjtCardInfoUtil.getTjtTradeInfo(this.f7712c.h());
            case 6:
                return WhtCardInfoUtil.getWhtTradeInfo(this.f7712c.h());
            case 7:
                return HctCardInfoUtil.getHctTradeInfo(this.f7712c.h());
            default:
                return null;
        }
    }
}
