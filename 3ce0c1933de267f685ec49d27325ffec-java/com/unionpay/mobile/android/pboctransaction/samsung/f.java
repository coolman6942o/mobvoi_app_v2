package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.mobvoi.wear.util.LogCleaner;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.Amount;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f implements c {
    private GetVendorPayStatusRequestParams C;
    private final Handler.Callback F;
    private final Handler G;
    private InitRequestParams H;
    private SendApduRequestParams I;

    /* renamed from: k  reason: collision with root package name */
    private Context f23820k;

    /* renamed from: l  reason: collision with root package name */
    private b f23821l;

    /* renamed from: m  reason: collision with root package name */
    private a f23822m;

    /* renamed from: n  reason: collision with root package name */
    private UPTsmAddon f23823n;

    /* renamed from: a  reason: collision with root package name */
    String f23810a = "19999741583305435775450371903957622252895007857586703985696530069777024392884287211670048223494223356836139331264745305488035196420545843046674853984852305228918004888414759300445308845681087472809487791392726663269247999482633231304479943902981311338709709401000108625221857486530967716878328228310703650408575058288784573884262229674701501842066793928002725038356122707147929560460157457327696696471785787505023643000687928051333648369477362945785046976181683285277919023274376124429148429078602516462345014971452220809120399264066736558357572250447243744965533695780751271768398207631002867947152625578881506566297";

    /* renamed from: b  reason: collision with root package name */
    String f23811b = "65537";

    /* renamed from: c  reason: collision with root package name */
    String f23812c = "5929703506495688276130676968213384164609348882017291684789802337394713840702726472221198819456433069055388915357817202968369194525956730949539025096963015440180443916974948318765778051794088998339276397676916425744003507605582286608745438301704836361482343765671805403004194772735755889141443700570750608527755694790475628670051863813384800013641474007746161600969180035295709344887092512089121125289090881005234379649440422346798246278284328310221953743757037875834557694749810951089453346522229122216198442376081589767583019062954875861469699069474707285206935898628020341168773624455554331118138151051364372906861";

    /* renamed from: d  reason: collision with root package name */
    String f23813d = "UnionPay";

    /* renamed from: i  reason: collision with root package name */
    private final String f23818i = "A0000003334355502D4D4F42494C45";

    /* renamed from: j  reason: collision with root package name */
    private final int f23819j = 10000;

    /* renamed from: o  reason: collision with root package name */
    private Handler f23824o = null;

    /* renamed from: p  reason: collision with root package name */
    private int f23825p = 0;

    /* renamed from: q  reason: collision with root package name */
    private final int f23826q = 8;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23827r = false;

    /* renamed from: s  reason: collision with root package name */
    private String f23828s = "-1";

    /* renamed from: t  reason: collision with root package name */
    private String f23829t = "";

    /* renamed from: u  reason: collision with root package name */
    private boolean f23830u = false;

    /* renamed from: v  reason: collision with root package name */
    private String f23831v = null;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23832w = false;

    /* renamed from: x  reason: collision with root package name */
    private String f23833x = "";

    /* renamed from: y  reason: collision with root package name */
    private String f23834y = "-1";

    /* renamed from: z  reason: collision with root package name */
    private String f23835z = "-1";
    private String A = "";
    private String B = "";

    /* renamed from: e  reason: collision with root package name */
    String f23814e = "";

    /* renamed from: f  reason: collision with root package name */
    boolean f23815f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f23816g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f23817h = false;
    private long D = 8000;
    private boolean E = false;
    private final UPTsmAddon.UPTsmConnectionListener J = new h(this);

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z10);
    }

    public f(a aVar) {
        g gVar = new g(this);
        this.F = gVar;
        this.G = new Handler(gVar);
        this.f23822m = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(f fVar, int i10, String str) {
        if (i10 != 1000) {
            if (i10 != 1018) {
                switch (i10) {
                    case AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS /* 1011 */:
                        k.c("uppay", "open channel fail");
                        fVar.f23828s = null;
                        fVar.f23829t = "";
                        fVar.f23827r = true;
                        return;
                    case AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES /* 1012 */:
                        k.c("uppay", "apdu fail");
                        fVar.G.removeMessages(3);
                        fVar.f23830u = true;
                        return;
                    case AMapException.CODE_AMAP_USER_KEY_RECYCLED /* 1013 */:
                        k.c("uppay", "close channel fail");
                        fVar.f23832w = true;
                        return;
                    case 1014:
                        fVar.f23824o.sendMessage(fVar.G.obtainMessage(8, null));
                        return;
                    case 1015:
                        k.c("uppay-spay", "get spay list call back");
                        fVar.f23824o.sendMessage(fVar.f23824o.obtainMessage(2001, str));
                        return;
                    case 1016:
                        break;
                    default:
                        return;
                }
            }
            k.c("uppay-spay", "check spay support fail");
            fVar.f23822m.a(false);
            return;
        }
        fVar.a(false);
    }

    private void a(String str, String str2) {
        SendApduRequestParams sendApduRequestParams = new SendApduRequestParams();
        this.I = sendApduRequestParams;
        sendApduRequestParams.setChannel(str2);
        this.I.setHexApdu(str);
        if (this.f23815f) {
            this.I.setReserve(g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        b bVar = this.f23821l;
        if (bVar == null) {
            return;
        }
        if (z10) {
            bVar.a();
        } else {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.H == null) {
            InitRequestParams initRequestParams = new InitRequestParams();
            this.H = initRequestParams;
            if (this.f23815f) {
                initRequestParams.setSignature(g());
                this.H.setReserve(g());
            }
        }
        try {
            int init = this.f23823n.init(this.H, new e(1000, this.G));
            if (init != 0) {
                Handler handler = this.G;
                handler.sendMessage(Message.obtain(handler, 1, 1000, 0, ""));
            } else {
                Handler handler2 = this.G;
                handler2.sendMessageDelayed(Message.obtain(handler2, 4, 1000, 0, ""), this.D);
            }
            k.c("uppay", "ret = " + init);
        } catch (RemoteException e10) {
            a(false);
            e10.printStackTrace();
        }
    }

    private String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("signature", this.f23814e);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.f23829t = "";
        this.f23827r = false;
        try {
            OpenChannelRequestParams openChannelRequestParams = new OpenChannelRequestParams();
            openChannelRequestParams.setAppAID(str);
            if (this.f23815f) {
                openChannelRequestParams.setReserve(g());
            }
            if (this.f23823n.openChannel(openChannelRequestParams, new e(AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, this.G)) != 0) {
                Handler handler = this.G;
                handler.sendMessage(Message.obtain(handler, 1, AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, 0, ""));
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
        while (TextUtils.isEmpty(this.f23829t) && !this.f23827r) {
        }
        if ("A0000003334355502D4D4F42494C45".equals(str)) {
            this.f23834y = this.f23828s;
        } else {
            this.f23835z = this.f23828s;
        }
        this.f23827r = false;
        return this.f23829t;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        if (this.f23823n == null) {
            return null;
        }
        try {
            if (!com.unionpay.mobile.android.model.b.aB || !com.unionpay.mobile.android.model.b.aA || !com.unionpay.mobile.android.model.b.f23496bo) {
                GetSeAppListRequestParams getSeAppListRequestParams = new GetSeAppListRequestParams();
                if (this.f23815f) {
                    getSeAppListRequestParams.setReserve(g());
                }
                if (this.f23823n.getSEAppList(getSeAppListRequestParams, new e(1014, this.G)) != 0) {
                    Handler handler = this.G;
                    handler.sendMessage(Message.obtain(handler, 1, 1014, 0, ""));
                } else {
                    Handler handler2 = this.G;
                    handler2.sendMessageDelayed(Message.obtain(handler2, 4, 1014, 0, ""), this.D);
                }
            } else {
                GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams = new GetCardInfoBySpayRequestParams();
                Amount amount = new Amount();
                amount.setProductPrice(this.A);
                String e10 = e.e(this.B);
                if (!TextUtils.isEmpty(e10)) {
                    amount.setCurrencyType(e10);
                }
                getCardInfoBySpayRequestParams.setAmount(amount);
                if (this.f23815f) {
                    getCardInfoBySpayRequestParams.setReserve(g());
                }
                int cardInfoBySamsungPay = this.f23823n.getCardInfoBySamsungPay(getCardInfoBySpayRequestParams, new e(1015, this.G));
                if (cardInfoBySamsungPay != 0) {
                    Handler handler3 = this.G;
                    handler3.sendMessage(Message.obtain(handler3, 1, 1015, 0, ""));
                } else {
                    Handler handler4 = this.G;
                    handler4.sendMessageDelayed(Message.obtain(handler4, 4, 1015, 0, ""), 8000L);
                }
                k.c("uppay", "readList: " + cardInfoBySamsungPay);
            }
        } catch (RemoteException e11) {
            a(false);
            e11.printStackTrace();
        } catch (Exception e12) {
            a(false);
            e12.printStackTrace();
        }
        k.c("uppay", "readList");
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
        UPTsmAddon uPTsmAddon = this.f23823n;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.J);
            this.f23823n.unbind();
        }
    }

    public final void a(Handler handler) {
        this.f23824o = handler;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(b bVar, Context context) {
        this.f23821l = bVar;
        this.f23820k = context;
        try {
            this.f23814e = com.unionpay.mobile.android.pboctransaction.samsung.a.a(KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(new BigInteger(this.f23810a), new BigInteger(this.f23812c))), this.f23813d);
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
        } catch (InvalidKeySpecException e11) {
            e11.printStackTrace();
        }
        if (com.unionpay.mobile.android.model.b.f23494bm) {
            this.D = LogCleaner.ONE_MINUTE;
        }
        this.f23815f = !"com.unionpay.uppay".equals(com.unionpay.mobile.android.utils.f.a(this.f23820k));
        UPTsmAddon uPTsmAddon = UPTsmAddon.getInstance(context);
        this.f23823n = uPTsmAddon;
        if (!this.f23816g) {
            uPTsmAddon.addConnectionListener(this.J);
            this.f23816g = true;
        }
        k.c("uppay-spay", "type se  bind service");
        UPTsmAddon uPTsmAddon2 = this.f23823n;
        if (uPTsmAddon2 == null || uPTsmAddon2.isConnected()) {
            UPTsmAddon uPTsmAddon3 = this.f23823n;
            if (uPTsmAddon3 != null && uPTsmAddon3.isConnected()) {
                k.c("uppay", "tem service already connected");
                if (!this.f23817h) {
                    f();
                } else {
                    a(true);
                }
            }
        } else {
            k.c("uppay", "bind service");
            if (!this.f23823n.bind()) {
                a(false);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:2|(1:4)(10:(1:7)|23|8|(1:10)|13|(1:14)|18|(1:20)|21|22)|5|23|8|(0)|13|(2:16|(1:14))|25|18|(0)|21|22) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0046 A[Catch: RemoteException -> 0x0052, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0052, blocks: (B:8:0x0033, B:10:0x0046), top: B:23:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    @Override // com.unionpay.mobile.android.pboctransaction.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] a(byte[] bArr, int i10) {
        String str;
        String a10;
        String str2;
        byte[] bArr2 = null;
        this.f23831v = null;
        this.f23830u = false;
        k.a("uppay", "--->" + e.a(bArr));
        if (i10 == 0) {
            a10 = e.a(bArr);
            str2 = this.f23835z;
        } else {
            if (i10 == 1) {
                a10 = e.a(bArr);
                str2 = this.f23834y;
            }
            if (this.f23823n.sendApdu(this.I, new e(AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, this.G)) != 0) {
                Handler handler = this.G;
                handler.sendMessage(Message.obtain(handler, 1, AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, 0, ""));
            }
            Handler handler2 = this.G;
            handler2.sendMessageDelayed(Message.obtain(handler2, 3), 10000L);
            while (TextUtils.isEmpty(this.f23831v) && !this.f23830u) {
            }
            k.a("uppay", "mApduResult: " + this.f23831v + ",mApduReturn:" + this.f23830u);
            str = this.f23831v;
            if (str != null) {
                bArr2 = e.a(str);
                k.a("uppay", "ret1 <---" + bArr2);
            }
            k.a("uppay", "<---" + this.f23831v);
            this.f23830u = false;
            k.a("uppay", "ret2 <---" + bArr2);
            return bArr2;
        }
        a(a10, str2);
        if (this.f23823n.sendApdu(this.I, new e(AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, this.G)) != 0) {
        }
        Handler handler22 = this.G;
        handler22.sendMessageDelayed(Message.obtain(handler22, 3), 10000L);
        while (TextUtils.isEmpty(this.f23831v)) {
            while (TextUtils.isEmpty(this.f23831v)) {
            }
        }
        k.a("uppay", "mApduResult: " + this.f23831v + ",mApduReturn:" + this.f23830u);
        str = this.f23831v;
        if (str != null) {
        }
        k.a("uppay", "<---" + this.f23831v);
        this.f23830u = false;
        k.a("uppay", "ret2 <---" + bArr2);
        return bArr2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void b() {
    }

    public final void b(String str) {
        this.A = str;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void c() {
        String str = this.f23834y;
        if (str != null && !"-1".equals(str)) {
            this.f23833x = "";
            this.f23832w = false;
            try {
                CloseChannelRequestParams closeChannelRequestParams = new CloseChannelRequestParams();
                closeChannelRequestParams.setChannel(this.f23834y);
                if (this.f23815f) {
                    closeChannelRequestParams.setReserve(g());
                }
                if (this.f23823n.closeChannel(closeChannelRequestParams, new e(AMapException.CODE_AMAP_USER_KEY_RECYCLED, this.G)) != 0) {
                    Handler handler = this.G;
                    handler.sendMessage(Message.obtain(handler, 1, AMapException.CODE_AMAP_USER_KEY_RECYCLED, 0, ""));
                }
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
            while (TextUtils.isEmpty(this.f23833x) && !this.f23832w) {
            }
            this.f23834y = "-1";
            this.f23832w = false;
        }
        String str2 = this.f23835z;
        if (str2 != null && !"-1".equals(str2)) {
            this.f23833x = "";
            this.f23832w = false;
            try {
                CloseChannelRequestParams closeChannelRequestParams2 = new CloseChannelRequestParams();
                closeChannelRequestParams2.setChannel(this.f23835z);
                if (this.f23815f) {
                    closeChannelRequestParams2.setReserve(g());
                }
                if (this.f23823n.closeChannel(closeChannelRequestParams2, new e(AMapException.CODE_AMAP_USER_KEY_RECYCLED, this.G)) != 0) {
                    Handler handler2 = this.G;
                    handler2.sendMessage(Message.obtain(handler2, 1, AMapException.CODE_AMAP_USER_KEY_RECYCLED, 0, ""));
                }
            } catch (RemoteException e11) {
                e11.printStackTrace();
            }
            while (TextUtils.isEmpty(this.f23833x) && !this.f23832w) {
            }
            this.f23835z = "-1";
            this.f23832w = false;
        }
    }

    public final void c(String str) {
        this.B = str;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void d() {
    }

    public final boolean e() {
        try {
            k.c("uppay", "getVendorPayStatus()");
            if (this.C == null) {
                GetVendorPayStatusRequestParams getVendorPayStatusRequestParams = new GetVendorPayStatusRequestParams();
                this.C = getVendorPayStatusRequestParams;
                if (this.f23815f) {
                    getVendorPayStatusRequestParams.setReserve(g());
                }
            }
            if (this.f23823n.getVendorPayStatus(this.C, new e(1018, this.G)) == 0) {
                return true;
            }
            Handler handler = this.G;
            handler.sendMessage(Message.obtain(handler, 1, 1018, 0, ""));
            return false;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
