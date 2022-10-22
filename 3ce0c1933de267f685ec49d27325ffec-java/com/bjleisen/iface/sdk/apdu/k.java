package com.bjleisen.iface.sdk.apdu;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bjleisen.bluetooth.IBluetoothInterfaceService;
import com.bjleisen.bluetooth.IMultiBluetoothInterface;
import com.bjleisen.iface.sdk.a.a;
import com.bjleisen.iface.sdk.a.j;
import com.bjleisen.iface.sdk.base.IApduBaseHandler;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.req.ReservedField;
import com.bjleisen.iface.sdk.bean.resp.AbnormalOrderDetailBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.AbnormalOrderListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.ActionBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.AppletDetailBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.AppletListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.BJTCardInfo;
import com.bjleisen.iface.sdk.bean.resp.BaseBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.CardTemplateRespInfo;
import com.bjleisen.iface.sdk.bean.resp.CompletedOrderListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.FAQSBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.FavorableBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.InvoicesState;
import com.bjleisen.iface.sdk.bean.resp.NextBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.NoticeRespInfo;
import com.bjleisen.iface.sdk.bean.resp.OrderListBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderCalculateBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.PayOrderStatusBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.RespInfo;
import com.bjleisen.iface.sdk.bean.resp.SuggestReplyBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.VersionUpgradeBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.ZytBindingCardBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.ZytRechargeBusiRespInfo;
import com.bjleisen.iface.sdk.bean.resp.ZytSearchTradeBusiRespInfo;
import com.bjleisen.iface.sdk.enums.EnumDeviceType;
import com.bjleisen.iface.sdk.enums.EnumStatusCode;
import com.bjleisen.iface.sdk.nfc.NfcOperator;
import com.bjleisen.iface.sdk.oma.ErrorInfo;
import com.bjleisen.iface.sdk.oma.SmartCard;
import com.google.gson.e;
import com.laser.tsm.sdk.AppConfig;
import h9.b;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.entity.StringEntity;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public final class k extends j {

    /* renamed from: a  reason: collision with root package name */
    public EnumDeviceType f7759a;

    /* renamed from: k  reason: collision with root package name */
    private Context f7760k;

    /* renamed from: m  reason: collision with root package name */
    private c f7762m;

    /* renamed from: n  reason: collision with root package name */
    private String f7763n = null;

    /* renamed from: o  reason: collision with root package name */
    private String f7764o = null;

    /* renamed from: p  reason: collision with root package name */
    private int f7765p = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f7766q = -1;

    /* renamed from: r  reason: collision with root package name */
    private e f7767r = new e();

    /* renamed from: s  reason: collision with root package name */
    private Error f7768s = null;

    /* renamed from: t  reason: collision with root package name */
    private g f7769t = null;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7770u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f7771v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7772w = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f7773x = false;

    /* renamed from: y  reason: collision with root package name */
    private Rapdu f7774y = null;

    /* renamed from: z  reason: collision with root package name */
    private final String f7775z = "RequestManager";
    private ApduLocalMultiExeCallback A = new l(this);
    private d B = new w(this);

    /* renamed from: l  reason: collision with root package name */
    private a f7761l = new a();

    /* JADX INFO: Access modifiers changed from: protected */
    public k(Context context, EnumDeviceType enumDeviceType) {
        this.f7759a = EnumDeviceType.DEVICE_TYPE_MOBILE;
        this.f7760k = context;
        this.f7759a = enumDeviceType;
        int i10 = am.f7730a[enumDeviceType.ordinal()];
        if (i10 == 1) {
            this.f7762m = new b(this.f7760k, this.B);
        } else if (i10 == 2) {
            this.f7762m = new e(this.f7760k, this.B);
        } else if (i10 == 3) {
            this.f7762m = new j(this.f7760k, this.B);
        } else if (i10 == 4) {
            this.f7762m = new i(this.f7760k, this.B);
        } else if (i10 == 5) {
            this.f7762m = new a(this.f7760k, this.B);
        }
    }

    private RespInfo<VersionUpgradeBusiRespInfo> q() {
        this.f7772w = false;
        this.f7765p = 4097;
        i(f.a(4097));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new ar(this).getType());
    }

    private RespInfo<SuggestReplyBusiRespInfo> r() {
        this.f7772w = false;
        this.f7765p = 4100;
        i(f.a(4100));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new m(this).getType());
    }

    private RespInfo<FAQSBusiRespInfo> s() {
        this.f7772w = false;
        this.f7765p = 8194;
        i(f.a(8194));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new o(this).getType());
    }

    private RespInfo<AbnormalOrderListBusiRespInfo> t() {
        this.f7772w = false;
        this.f7765p = 20481;
        i(f.a(20481));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new s(this).getType());
    }

    private void u() {
        if (this.f7772w) {
            this.B.a(-1, new Error("execute apdu interrupt"));
            this.f7772w = false;
            return;
        }
        String str = this.f7763n;
        if (str == null) {
            d dVar = this.B;
            EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_REQUEST_FAILURE;
            dVar.a(enumStatusCode.getStatus(), new Error(enumStatusCode.getMsg()));
            return;
        }
        RespInfo respInfo = (RespInfo) this.f7767r.k(str, new aj(this).getType());
        if (respInfo == null) {
            d dVar2 = this.B;
            EnumStatusCode enumStatusCode2 = EnumStatusCode.STATUS_DATA_PARSE_FAILURE;
            dVar2.a(enumStatusCode2.getStatus(), new Error(enumStatusCode2.getMsg()));
        } else if (EnumStatusCode.STATUS_SUCCESS.getStatus() != respInfo.getStatus()) {
            Error error = this.f7768s;
            if (error != null) {
                if (error instanceof ErrorInfo) {
                    this.B.a(((ErrorInfo) error).getErrorCode(), this.f7768s);
                } else {
                    this.B.a(EnumStatusCode.STATUS_SMARTCARD_OPER_FAILURE.getStatus(), this.f7768s);
                }
                this.f7768s = null;
                return;
            }
            d dVar3 = this.B;
            int status = respInfo.getStatus();
            dVar3.a(status, new Error(respInfo.getDesc()));
        } else {
            NextBusiRespInfo nextBusiRespInfo = (NextBusiRespInfo) respInfo.getBusiRespInfo();
            if (1 == nextBusiRespInfo.getFinishFlag()) {
                this.B.a((Rapdu) null);
                return;
            }
            this.f7770u = false;
            this.f7766q = nextBusiRespInfo.getRapduRespFlag();
            this.f7764o = nextBusiRespInfo.getTaskSeqNum();
            this.f7762m.a(nextBusiRespInfo.getCapdus());
            this.f7762m.run();
        }
    }

    private void v() {
        IApduBaseHandler iApduBaseHandler;
        this.f7765p = -1;
        this.f7766q = -1;
        this.f7764o = null;
        this.f7763n = null;
        this.f7772w = false;
        this.f7771v = false;
        try {
            int i10 = am.f7730a[this.f7759a.ordinal()];
            if (i10 == 1) {
                IBluetoothInterfaceService iBluetoothInterfaceService = LeisenIfaceConfig.f7683aq;
                if (iBluetoothInterfaceService != null) {
                    iBluetoothInterfaceService.closeSEChannel();
                }
            } else if (i10 == 2) {
                SmartCard.getInstance().closeService();
            } else if (i10 == 3) {
                NfcOperator.getInstance().closeChannel();
            } else if (i10 == 4) {
                IMultiBluetoothInterface iMultiBluetoothInterface = LeisenIfaceConfig.ar;
                if (iMultiBluetoothInterface != null) {
                    iMultiBluetoothInterface.closeSEChannel();
                }
            } else if (i10 == 5 && (iApduBaseHandler = LeisenIfaceConfig.f7682ap) != null) {
                iApduBaseHandler.closeChannel();
            }
        } catch (RemoteException | Exception unused) {
        }
    }

    private void w() {
        this.f7772w = false;
        this.f7765p = -1;
        i(f.a(1));
        u();
    }

    private static String x() {
        String str = LeisenIfaceConfig.f7681ao;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1123296418:
                if (str.equals("http://219.239.243.149:10009/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                    c10 = 0;
                    break;
                }
                break;
            case -126704072:
                if (str.equals("https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                    c10 = 1;
                    break;
                }
                break;
            case 312282591:
                if (str.equals("https://www.opentsm.cn:7004/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1695254788:
                if (str.equals("http://219.239.243.149:10014/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return "开发环境";
            case 1:
                return "测试环境";
            case 2:
                return "生产环境";
            case 3:
                return "预生产环境";
            default:
                return "IMPOSSIBLE";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<NoticeRespInfo> d() {
        this.f7772w = false;
        this.f7765p = 4098;
        i(f.a(4098));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new p(this).getType());
    }

    private RespInfo<BaseBusiRespInfo> e(String str) {
        this.f7772w = false;
        this.f7765p = 8193;
        i(f.d(str));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new n(this).getType());
    }

    private RespInfo<AbnormalOrderDetailBusiRespInfo> f(String str) {
        this.f7772w = false;
        this.f7765p = 20481;
        i(f.b(str));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new v(this).getType());
    }

    private static String h(String str) {
        String hexString;
        String str2 = "00".substring(0, 2 - hexString.length()) + Integer.toHexString(str.length() / 2);
        if (str.equalsIgnoreCase("3f00")) {
            return "00A40000" + str2 + str;
        }
        return "00A40400" + str2 + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r4.equals("http://219.239.243.149:10009/apkp/LaserOpenTsmServer/applicationBusiness.action") == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(String str) {
        String str2;
        if (str != null) {
            char c10 = 0;
            if (this.f7772w) {
                this.B.a(-1, new Error("request server failure"));
                this.f7772w = false;
                return;
            }
            if (TextUtils.isEmpty(LeisenIfaceConfig.f7681ao)) {
                LeisenIfaceConfig.f7681ao = "https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action";
            }
            StringBuilder sb2 = new StringBuilder("Request Address:");
            String str3 = LeisenIfaceConfig.f7681ao;
            str3.hashCode();
            switch (str3.hashCode()) {
                case -1123296418:
                    break;
                case -126704072:
                    if (str3.equals("https://demo.bjleisen.com/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 312282591:
                    if (str3.equals("https://www.opentsm.cn:7004/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1695254788:
                    if (str3.equals("http://219.239.243.149:10014/apkp/LaserOpenTsmServer/applicationBusiness.action")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    str2 = "开发环境";
                    break;
                case 1:
                    str2 = "测试环境";
                    break;
                case 2:
                    str2 = "生产环境";
                    break;
                case 3:
                    str2 = "预生产环境";
                    break;
                default:
                    str2 = "IMPOSSIBLE";
                    break;
            }
            sb2.append(str2);
            b.d(sb2.toString());
            b.d("Request Content:" + str);
            try {
                this.f7761l.a(this.f7760k, LeisenIfaceConfig.f7681ao, new StringEntity(str, "UTF-8"), "text/json", this);
            } catch (Exception e10) {
                b.d("Reqeust Error:" + e10.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<AppletListBusiRespInfo> b() {
        this.f7772w = false;
        this.f7765p = 2;
        i(f.a(2));
        String str = this.f7763n;
        if (str != null) {
            return (RespInfo) this.f7767r.k(str, new ap(this).getType());
        }
        RespInfo<AppletListBusiRespInfo> respInfo = new RespInfo<>();
        EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_REQUEST_FAILURE;
        respInfo.setStatus(enumStatusCode.getStatus());
        respInfo.setDesc(enumStatusCode.getMsg());
        return respInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<FavorableBusiRespInfo> c() {
        this.f7772w = false;
        this.f7765p = 4099;
        i(f.a(4099));
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new as(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        this.f7762m.b();
        String[] strArr = {LeisenIfaceConfig.V, AppConfig.APDU_GETIIN};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.f7762m.a(arrayList);
        this.f7762m.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> a() {
        this.f7772w = false;
        this.f7765p = 1;
        i(f.a());
        String str = this.f7763n;
        if (str == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str, new ah(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApduLocalMultiExeCallback h() {
        return this.A;
    }

    private void g(String str) {
        String hexString;
        String str2;
        this.f7762m.b();
        String str3 = "00".substring(0, 2 - hexString.length()) + Integer.toHexString(str.length() / 2);
        if (str.equalsIgnoreCase("3f00")) {
            str2 = "00A40000" + str3 + str;
        } else {
            str2 = "00A40400" + str3 + str;
        }
        this.f7762m.a(new Capdu(0, str2, new String[]{"9000"}));
        this.f7762m.run();
    }

    @Override // com.bjleisen.iface.sdk.a.j
    public final void d(String str) {
        b.d("onSuccess Response:" + str);
        this.f7763n = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> c(String str) {
        this.f7772w = false;
        this.f7765p = 20488;
        i(f.e(str));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new ad(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        this.f7762m.b();
        String[] strArr = {LeisenIfaceConfig.V, "80CA9F7F00"};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.f7762m.a(arrayList);
        this.f7762m.run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        this.f7762m.b();
        String[] strArr = {LeisenIfaceConfig.V, AppConfig.APDU_GETCIN};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            arrayList.add(new Capdu(i10, strArr[i10], new String[]{"9000"}));
        }
        this.f7762m.a(arrayList);
        this.f7762m.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(k kVar) {
        IApduBaseHandler iApduBaseHandler;
        kVar.f7765p = -1;
        kVar.f7766q = -1;
        kVar.f7764o = null;
        kVar.f7763n = null;
        kVar.f7772w = false;
        kVar.f7771v = false;
        try {
            int i10 = am.f7730a[kVar.f7759a.ordinal()];
            if (i10 == 1) {
                IBluetoothInterfaceService iBluetoothInterfaceService = LeisenIfaceConfig.f7683aq;
                if (iBluetoothInterfaceService != null) {
                    iBluetoothInterfaceService.closeSEChannel();
                }
            } else if (i10 == 2) {
                SmartCard.getInstance().closeService();
            } else if (i10 == 3) {
                NfcOperator.getInstance().closeChannel();
            } else if (i10 == 4) {
                IMultiBluetoothInterface iMultiBluetoothInterface = LeisenIfaceConfig.ar;
                if (iMultiBluetoothInterface != null) {
                    iMultiBluetoothInterface.closeSEChannel();
                }
            } else if (i10 == 5 && (iApduBaseHandler = LeisenIfaceConfig.f7682ap) != null) {
                iApduBaseHandler.closeChannel();
            }
        } catch (RemoteException | Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BJTCardInfo> a(String str) {
        this.f7772w = false;
        this.f7765p = 4101;
        i(f.a(str));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new an(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> b(String str, String str2, int i10) {
        this.f7772w = false;
        this.f7765p = 8;
        i(f.c(str, str2, i10));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new q(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        b.d("Request Cancel");
        this.f7761l.a(this.f7760k);
        this.f7762m.c();
        this.f7771v = true;
        this.f7772w = true;
    }

    private RespInfo<BaseBusiRespInfo> c(String str, String str2, int i10) {
        this.f7772w = false;
        this.f7765p = 7;
        i(f.a(str, str2, i10));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new af(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<CardTemplateRespInfo> a(String str, int i10) {
        this.f7772w = false;
        this.f7765p = 20489;
        i(f.a(str, i10));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new ao(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<PayOrderStatusBusiRespInfo> b(String str) {
        this.f7772w = false;
        this.f7765p = 12291;
        i(f.c(str));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new y(this).getType());
    }

    private RespInfo<InvoicesState> c(String str, int i10) {
        this.f7772w = false;
        this.f7765p = 20485;
        i(f.b(str, i10));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new al(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<AppletDetailBusiRespInfo> a(String str, String str2, int i10) {
        this.f7772w = false;
        this.f7765p = 3;
        i(f.b(str, str2, i10));
        String str3 = this.f7763n;
        if (str3 != null) {
            return (RespInfo) this.f7767r.k(str3, new aq(this).getType());
        }
        RespInfo<AppletDetailBusiRespInfo> respInfo = new RespInfo<>();
        EnumStatusCode enumStatusCode = EnumStatusCode.STATUS_REQUEST_FAILURE;
        respInfo.setStatus(enumStatusCode.getStatus());
        respInfo.setDesc(enumStatusCode.getMsg());
        return respInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<ActionBusiRespInfo> b(String str, int i10) {
        this.f7772w = false;
        this.f7765p = 4099;
        i(f.c(str, i10));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new z(this).getType());
    }

    private RespInfo<ZytBindingCardBusiRespInfo> b(String str, String str2) {
        this.f7772w = false;
        this.f7765p = 9;
        i(f.a(str, str2));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new ae(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<PayOrderBusiRespInfo> a(String str, String str2, int i10, int i11, String str3, int i12, int i13, String str4) {
        this.f7772w = false;
        this.f7765p = 12289;
        i(f.a(str, str2, i10, i11, str3, i12, i13, str4));
        String str5 = this.f7763n;
        if (str5 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str5, new r(this).getType());
    }

    private RespInfo<BaseBusiRespInfo> b(String str, int i10, String str2) {
        this.f7772w = false;
        this.f7765p = 20484;
        i(f.a(str, i10, str2));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new ak(this).getType());
    }

    private RespInfo<CompletedOrderListBusiRespInfo> a(String str, int i10, int i11) {
        this.f7772w = false;
        this.f7765p = 20483;
        i(f.a(str, i10, i11));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new t(this).getType());
    }

    public final RespInfo<OrderListBusiRespInfo> a(String str, int i10, int i11, int i12) {
        this.f7772w = false;
        this.f7765p = 20487;
        i(f.a(str, i10, i11, i12));
        String str2 = this.f7763n;
        if (str2 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str2, new u(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<PayOrderCalculateBusiRespInfo> a(String str, String str2, int i10, int i11) {
        this.f7772w = false;
        this.f7765p = 12290;
        i(f.a(str, str2, i10, i11));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new x(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> a(String str, String str2, int i10, String str3, int i11, String str4) {
        this.f7772w = false;
        this.f7765p = 16;
        i(f.a(16, str, str2, i10, str3, i11, str4));
        String str5 = this.f7763n;
        if (str5 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str5, new aa(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> a(String str, int i10, String str2) {
        this.f7772w = false;
        this.f7765p = 17;
        i(f.b(str, i10, str2));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new ab(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RespInfo<BaseBusiRespInfo> a(String str, String str2) {
        this.f7772w = false;
        this.f7765p = 20486;
        i(f.b(str, str2));
        String str3 = this.f7763n;
        if (str3 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str3, new ac(this).getType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i10, String str, String str2, String str3, String str4, String str5, String str6, ReservedField reservedField) {
        this.f7772w = false;
        this.f7765p = 4;
        i(f.a(i10, str, str2, str3, str4, str5, str6, reservedField));
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, ReservedField reservedField) {
        this.f7772w = false;
        this.f7765p = 5;
        this.f7773x = false;
        i(f.a(str, this.f7759a.getValue(), reservedField));
        u();
    }

    private RespInfo<ZytRechargeBusiRespInfo> a(String str, String str2, String str3) {
        this.f7772w = false;
        this.f7765p = 12292;
        i(f.a(str, str2, str3));
        String str4 = this.f7763n;
        if (str4 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str4, new ag(this).getType());
    }

    private RespInfo<ZytSearchTradeBusiRespInfo> a(String str, String str2, String str3, String str4, int i10, String str5, String str6, int i11) {
        this.f7772w = false;
        this.f7765p = 12293;
        i(f.a(str, str2, str3, str4, i10, str5, str6, i11));
        String str7 = this.f7763n;
        if (str7 == null) {
            return null;
        }
        return (RespInfo) this.f7767r.k(str7, new ai(this).getType());
    }

    private void a(String str, List<Rapdu> list) {
        this.f7765p = 6;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i10 = this.f7766q;
            if (i10 == 1 || i10 == -1) {
                arrayList.addAll(list);
            } else if (i10 == 2) {
                arrayList.add(list.get(list.size() - 1));
            }
        }
        b.d("rapdus temp size:" + arrayList.size());
        i(f.a(str, arrayList));
        u();
    }

    @Override // com.bjleisen.iface.sdk.a.j
    public final void a(String str, Throwable th2) {
        b.d("OnFailure Response:" + str);
        b.f("Error Info:" + th2.getMessage());
        this.f7763n = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(g gVar) {
        this.f7769t = gVar;
    }

    private void a(EnumDeviceType enumDeviceType) {
        this.f7759a = enumDeviceType;
        int i10 = am.f7730a[enumDeviceType.ordinal()];
        if (i10 == 1) {
            this.f7762m = new b(this.f7760k, this.B);
        } else if (i10 == 2) {
            this.f7762m = new e(this.f7760k, this.B);
        } else if (i10 == 3) {
            this.f7762m = new j(this.f7760k, this.B);
        } else if (i10 == 4) {
            this.f7762m = new i(this.f7760k, this.B);
        } else if (i10 == 5) {
            this.f7762m = new a(this.f7760k, this.B);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(k kVar, String str, List list) {
        kVar.f7765p = 6;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i10 = kVar.f7766q;
            if (i10 == 1 || i10 == -1) {
                arrayList.addAll(list);
            } else if (i10 == 2) {
                arrayList.add(list.get(list.size() - 1));
            }
        }
        b.d("rapdus temp size:" + arrayList.size());
        kVar.i(f.a(str, arrayList));
        kVar.u();
    }
}
