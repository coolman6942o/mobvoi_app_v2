package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.realsil.sdk.dfu.DfuException;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.a;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l extends b {
    private JSONArray F;
    private e G;
    private long H;
    private Activity I;
    private boolean J;

    /* renamed from: z  reason: collision with root package name */
    private ProgressBar f23713z = null;
    private String A = null;
    private int B = 0;
    private volatile int C = 0;

    /* renamed from: r  reason: collision with root package name */
    public List<c> f23705r = null;

    /* renamed from: s  reason: collision with root package name */
    public List<c> f23706s = null;
    private boolean D = false;
    private boolean E = false;
    private boolean K = false;

    /* renamed from: t  reason: collision with root package name */
    int f23707t = 0;

    /* renamed from: u  reason: collision with root package name */
    String f23708u = "";

    /* renamed from: v  reason: collision with root package name */
    String f23709v = "";

    /* renamed from: w  reason: collision with root package name */
    String f23710w = "";

    /* renamed from: x  reason: collision with root package name */
    int f23711x = AGCServerException.UNKNOW_EXCEPTION;

    /* renamed from: y  reason: collision with root package name */
    int f23712y = 5;

    public l(Context context) {
        super(context);
        this.f23644f = 1;
        this.f23655q = "init";
        d();
        Activity activity = (Activity) context;
        this.I = activity;
        try {
            this.J = a.a(activity.getIntent(), this.f23639a);
        } catch (Exception unused) {
            this.J = false;
        }
        if (this.f23639a.aM) {
            setVisibility(8);
            this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.f23461c);
        }
        r();
    }

    private void b(int i10, String str) {
        if (str != null && str.length() > 0) {
            this.f23639a.I.f23866f = str;
        }
        this.f23713z.setVisibility(4);
        a(c(i10), true);
    }

    private void c(String str, String str2) {
        if (str2.length() > 0) {
            this.f23639a.I.f23866f = str2;
        }
        this.f23713z.setVisibility(4);
        a(str, true);
    }

    private boolean f(int i10) {
        if ((i10 & 2) == 0) {
            return false;
        }
        this.f23639a.aw = true;
        return true;
    }

    private final boolean y() {
        try {
            JSONArray jSONArray = this.F;
            String string = jSONArray != null ? jSONArray.getString(3) : null;
            if (string == null || string.length() <= 0) {
                return false;
            }
            return !LpaConstants.VALUE_NULL.equalsIgnoreCase(string);
        } catch (JSONException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0116 A[Catch: all -> 0x025d, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x001d, B:10:0x0026, B:12:0x0032, B:14:0x003c, B:19:0x0047, B:27:0x0056, B:31:0x005c, B:33:0x0064, B:34:0x0069, B:36:0x0077, B:38:0x007d, B:39:0x0082, B:40:0x0088, B:42:0x008c, B:44:0x0090, B:46:0x0094, B:48:0x0098, B:50:0x009e, B:51:0x00a4, B:53:0x00aa, B:55:0x00b6, B:56:0x00ba, B:58:0x00c6, B:59:0x00ca, B:60:0x00cd, B:62:0x00d3, B:63:0x00d6, B:65:0x00da, B:67:0x00e0, B:68:0x00e9, B:70:0x00ed, B:72:0x00f3, B:73:0x00fc, B:75:0x0102, B:77:0x0108, B:78:0x0110, B:80:0x0116, B:82:0x0122, B:84:0x0129, B:85:0x012d, B:87:0x0139, B:89:0x013f, B:91:0x0145, B:93:0x014b, B:96:0x0156, B:98:0x0162, B:100:0x0166, B:101:0x016b, B:102:0x016f, B:104:0x0173, B:105:0x0178, B:106:0x017c, B:108:0x0180, B:109:0x0185, B:110:0x0189, B:112:0x018f, B:113:0x0197, B:114:0x019b, B:116:0x01a1, B:117:0x01a5, B:119:0x01ab, B:121:0x01b7, B:134:0x01d2, B:136:0x01d7, B:137:0x01da, B:139:0x01de, B:141:0x01e2, B:143:0x01e6, B:145:0x01ea, B:148:0x01f5, B:150:0x01fb, B:152:0x0201, B:154:0x0205, B:156:0x0209, B:157:0x0219, B:159:0x021f, B:161:0x0223, B:163:0x0227, B:164:0x022d, B:166:0x0231, B:168:0x0235, B:170:0x0239, B:172:0x023d, B:174:0x0243, B:175:0x024f, B:176:0x0254), top: B:183:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void z() {
        List<d> list;
        List<c> list2;
        List<c> list3;
        Iterator<c> it;
        b bVar;
        List<c> list4;
        List<c> list5;
        boolean z10;
        k.c("uppay", "showContentView() +++" + this.C);
        if (this.C != 2) {
            boolean z11 = this.E;
            boolean z12 = !z11;
            if (z11 && !"1".equalsIgnoreCase(this.f23639a.f23511an)) {
                int i10 = this.f23639a.f23512ao;
                if (!(f(i10) && (i10 & 69889) == 0) && !this.f23639a.aD) {
                    z10 = true;
                    if (!z12 || z10) {
                        return;
                    }
                }
            }
            z10 = false;
            if (!z12) {
            }
            return;
        }
        if (!this.D) {
            this.D = true;
            if (this.f23639a.aM) {
                this.f23640b.c();
            }
            b bVar2 = this.f23639a;
            int i11 = bVar2.f23512ao;
            if ("1".equalsIgnoreCase(bVar2.f23511an)) {
                b bVar3 = this.f23639a;
                if (bVar3.aC) {
                    bVar3.f23541q = null;
                } else {
                    bVar3.f23541q = this.f23705r;
                }
            } else {
                if (b.aA && b.aB && !b.f23495bn && (list5 = this.f23706s) != null && list5.size() > 0) {
                    Iterator<c> it2 = this.f23706s.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().c() == 1) {
                            it2.remove();
                        }
                    }
                }
                if ("0".equalsIgnoreCase(this.f23639a.f23511an)) {
                    bVar = this.f23639a;
                    list4 = this.f23706s;
                } else {
                    bVar = this.f23639a;
                    if (bVar.aC) {
                        list4 = this.f23706s;
                    } else {
                        List<c> list6 = this.f23706s;
                        if (list6 != null && list6.size() > 0) {
                            this.f23639a.f23541q.addAll(this.f23706s);
                        }
                        List<c> list7 = this.f23705r;
                        if (list7 != null && list7.size() > 0) {
                            this.f23639a.f23541q.addAll(this.f23705r);
                        }
                        list3 = this.f23639a.f23541q;
                        if (list3 != null && list3.size() > 0) {
                            it = this.f23639a.f23541q.iterator();
                            while (it.hasNext()) {
                                c next = it.next();
                                if (next.c() != 0 && (next.c() & i11) == 0) {
                                    it.remove();
                                }
                            }
                        }
                    }
                }
                bVar.f23541q = list4;
                list3 = this.f23639a.f23541q;
                if (list3 != null) {
                    it = this.f23639a.f23541q.iterator();
                    while (it.hasNext()) {
                    }
                }
            }
            if (!"0".equalsIgnoreCase(this.f23639a.f23511an) || (((list2 = this.f23639a.f23541q) != null && list2.size() > 0) || f(i11))) {
                if (!"1".equalsIgnoreCase(this.f23639a.f23511an)) {
                    try {
                        JSONArray jSONArray = this.F;
                        String string = jSONArray != null ? jSONArray.getString(0) : com.unionpay.mobile.android.languages.c.bD.f23436ak;
                        JSONArray jSONArray2 = this.F;
                        String string2 = jSONArray2 != null ? jSONArray2.getString(1) : com.unionpay.mobile.android.languages.c.bD.f23435aj;
                        JSONArray jSONArray3 = this.F;
                        String string3 = jSONArray3 != null ? jSONArray3.getString(2) : com.unionpay.mobile.android.languages.c.bD.f23434ai;
                        String string4 = y() ? this.F.getString(3) : com.unionpay.mobile.android.languages.c.bD.f23437al;
                        List<c> list8 = this.f23639a.f23541q;
                        if (list8 != null) {
                            for (c cVar : list8) {
                                if (cVar.c() != 0) {
                                    String str = "";
                                    int c10 = cVar.c();
                                    if (c10 == 1) {
                                        str = string4;
                                    } else if (c10 == 4) {
                                        str = string2;
                                    } else if (c10 == 8) {
                                        str = string;
                                    } else if (c10 == 16) {
                                        str = string3;
                                    }
                                    cVar.a(str);
                                }
                            }
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
                if ((b.f23495bn || !b.aA || !b.aB) && b.f23494bm) {
                    c(this.f23639a.f23513ap, Constant.CASH_LOAD_FAIL);
                    return;
                }
                if (s()) {
                    b bVar4 = this.f23639a;
                    if (bVar4.az && !bVar4.aC && !bVar4.aD) {
                        a(this.f23707t, this.f23711x, this.f23708u, this.f23709v, this.f23712y, this.f23710w);
                    }
                }
                b bVar5 = this.f23639a;
                if (bVar5.ax && bVar5.aD && bVar5.ay) {
                    d(17);
                } else if (!bVar5.aE || !bVar5.az || !b.f23493bl || ((list = b.f23492bb) != null && list.size() > 0)) {
                    a(2, this.G);
                } else {
                    b(com.unionpay.mobile.android.languages.c.bD.f23460bq, this.f23639a.f23521bh);
                }
                k.c("uppay", "showContentView() ---");
                return;
            }
            c(this.f23639a.f23513ap, Constant.CASH_LOAD_FAIL);
        }
    }

    public void a(int i10, int i11, String str, String str2, int i12, String str3) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        String a10;
        com.unionpay.mobile.android.languages.c cVar;
        k.a("uppay", "init.parserParamJsonObj() +++");
        if (jSONObject == null) {
            b(2);
            return;
        }
        int i10 = this.B;
        if (i10 != 1) {
            if (i10 == 2) {
                f.c(this.f23639a, jSONObject);
                int b10 = f.b(this.f23639a, jSONObject);
                if (b10 != 0) {
                    b(b10);
                } else {
                    if (!TextUtils.isEmpty(j.a(jSONObject, "userId"))) {
                        String[] strArr = o.f24163e;
                    }
                    this.G = f.a(jSONObject);
                    u();
                }
            }
            k.a("uppay", "init.parserParamJsonObj() ---");
        }
        String a11 = j.a(jSONObject, "secret");
        j.a(jSONObject, "sec_sign");
        this.f23643e.d(a11);
        String a12 = j.a(jSONObject, "talking_data_flag");
        if (!TextUtils.isEmpty(a12)) {
            com.unionpay.mobile.android.global.a.L = "0".equals(a12);
        }
        TextUtils.isEmpty(j.a(jSONObject, "mer_id"));
        String[] strArr2 = o.f24159a;
        String str = this.f23639a.f23515b;
        String[] strArr3 = o.f24160b;
        String[] strArr4 = o.f24161c;
        String str2 = com.unionpay.mobile.android.languages.c.bD.f23425a;
        JSONObject c10 = j.c(jSONObject, "upgrade_info");
        this.A = j.a(c10, "type");
        String a13 = j.a(c10, "desc");
        j.a(c10, "url");
        if (this.A.equalsIgnoreCase("02")) {
            this.f23640b.a(new m(this), new n(this));
            m mVar = this.f23640b;
            com.unionpay.mobile.android.languages.c cVar2 = com.unionpay.mobile.android.languages.c.bD;
            mVar.a(cVar2.f23430ae, a13, cVar2.f23431af, cVar2.f23432ag);
        } else {
            this.f23639a.f23539o = j.a(jSONObject, "title");
            this.f23639a.f23534j = j.c(jSONObject, "init_button");
            this.f23639a.f23532h = j.d(jSONObject, "order");
            HashMap hashMap = new HashMap();
            for (int i11 = 0; i11 < this.f23639a.f23532h.length(); i11++) {
                Object b11 = j.b(this.f23639a.f23532h, i11);
                if (b11 != null) {
                    JSONObject jSONObject2 = (JSONObject) b11;
                    hashMap.put(j.a(jSONObject2, "label"), j.a(jSONObject2, HealthDataProviderContracts.NAME_VALUE));
                }
            }
            String[] strArr5 = o.f24162d;
            hashMap.toString();
            this.f23639a.f23533i = j.c(jSONObject, "risk_info");
            List<JSONArray> e10 = j.e(jSONObject, "cards");
            if (e10.size() > 0) {
                this.f23705r = new ArrayList(e10.size());
            }
            for (int i12 = 0; i12 < e10.size(); i12++) {
                this.f23705r.add(new com.unionpay.mobile.android.model.a(j.a(e10.get(i12), 0), j.a(e10.get(i12), 1), j.a(e10.get(i12), 2), (byte) 0));
            }
            this.f23639a.f23543s = j.a(jSONObject, "bank_url");
            this.f23639a.f23544t = j.d(jSONObject, "input_info");
            this.f23639a.f23546v = j.c(jSONObject, "account_info");
            this.f23639a.f23547w = j.c(jSONObject, "other_card_info");
            this.f23639a.f23545u = j.a(jSONObject, "user_id");
            this.f23643e.b(j.a(jSONObject, "sid"));
            this.f23643e.c(j.a(jSONObject, "secret"));
            String a14 = j.a(jSONObject, "sid");
            if (!TextUtils.isEmpty(a14)) {
                this.f23639a.f23535k = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a14));
            }
            String a15 = j.a(jSONObject, "secret");
            if (!TextUtils.isEmpty(a15)) {
                this.f23639a.f23536l = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a15));
                this.f23639a.f23537m = a15;
            }
            String a16 = j.a(jSONObject, "uid");
            if (a16 != null && !TextUtils.isEmpty(a16)) {
                PreferenceUtils.b(this.f23642d, a16);
            }
            if (t()) {
                if (s()) {
                    this.f23639a.f23548x = j.c(jSONObject, "kalefu_info");
                    this.f23639a.f23549y = j.a(jSONObject, "kalefu_button_label");
                    String str3 = this.f23639a.f23549y;
                    if ((str3 == null || str3.length() <= 0) && (cVar = com.unionpay.mobile.android.languages.c.bD) != null) {
                        this.f23639a.f23549y = cVar.f23438am;
                    }
                }
                this.F = j.d(jSONObject, "cards_desc");
                this.f23639a.f23511an = j.a(jSONObject, "trade_privilege");
                this.f23639a.f23513ap = j.a(jSONObject, "upcard_msg");
                this.f23639a.f23512ao = 0;
                String a17 = j.a(jSONObject, "upcard_support_type");
                if (!"1".equalsIgnoreCase(this.f23639a.f23511an) && a17 != null && a17.length() > 0) {
                    this.f23639a.f23512ao = Integer.parseInt(a17, 2);
                }
                f(this.f23639a.f23512ao);
            }
            this.f23639a.ar = j.a(jSONObject, "ad");
            this.f23639a.at = j.a(jSONObject, "pay_tip");
            String a18 = j.a(jSONObject, "sup_pay_method");
            if (!TextUtils.isEmpty(a18)) {
                this.f23639a.aC = "01".equals(a18);
                this.f23639a.aD = "001".equals(a18);
            }
            String a19 = j.a(jSONObject, "default_pay_type");
            if (!TextUtils.isEmpty(a19)) {
                this.f23639a.aE = "0501".equals(a19);
            }
            this.f23639a.au = j.c(jSONObject, "find_pwd_url");
            this.f23639a.Y = j.c(jSONObject, "reg_url");
            this.f23639a.ay = "1".equals(j.a(jSONObject, "sup_nfc"));
            this.f23639a.az = "1".equals(j.a(jSONObject, "sup_hce"));
            b.aA = "1".equals(j.a(jSONObject, "sup_samsung_pay"));
            this.f23639a.f23521bh = j.a(jSONObject, "hce_introduction_url");
            if (s()) {
                b bVar = this.f23639a;
                if (bVar.ay && !bVar.aC) {
                    String a20 = j.a(jSONObject, "nfc_title");
                    if (!TextUtils.isEmpty(a20)) {
                        com.unionpay.mobile.android.languages.c.bD.f23458bo = a20;
                    }
                    JSONObject c11 = j.c(jSONObject, "nfc_button");
                    if (!(c11 == null || (a10 = j.a(c11, "label")) == null || TextUtils.isEmpty(a10))) {
                        com.unionpay.mobile.android.languages.c.bD.f23459bp = a10;
                    }
                }
            }
            if (s()) {
                b bVar2 = this.f23639a;
                if (bVar2.az && !bVar2.aC && !bVar2.aD) {
                    String a21 = j.a(jSONObject, "hce_title");
                    this.f23707t = j.b(jSONObject, "hce_page_size");
                    JSONObject c12 = j.c(jSONObject, "hce_button");
                    String a22 = j.a(c12, "label");
                    String a23 = j.a(c12, "htmlLabel");
                    if (!TextUtils.isEmpty(a21)) {
                        com.unionpay.mobile.android.languages.c.bD.f23460bq = a21;
                    } else {
                        com.unionpay.mobile.android.languages.c.bD.f23460bq = a22;
                    }
                    if (!TextUtils.isEmpty(a23)) {
                        com.unionpay.mobile.android.languages.c.bD.br = a23;
                    } else {
                        com.unionpay.mobile.android.languages.c.bD.br = a22;
                    }
                    this.f23708u = j.a(c12, TelephonyUtil.KEY_SIM_ACTION);
                    this.f23709v = j.a(c12, "reserved");
                    this.f23710w = j.a(jSONObject, "iss_ins_code");
                    this.f23711x = j.b(jSONObject, "hce_bank_timeout");
                    this.f23712y = j.b(jSONObject, "hce_concurrent_count");
                    int b12 = j.b(jSONObject, "hce_pay_timeout");
                    if (b12 != 0) {
                        this.f23639a.f23518be = b12;
                    } else {
                        this.f23639a.f23518be = 5000;
                    }
                    this.f23639a.f23522bi = j.a(jSONObject, "no_hce_card_msg");
                }
            }
            b bVar3 = this.f23639a;
            bVar3.f23540p = new HashMap<>();
            JSONObject c13 = j.c(jSONObject, "f55");
            String a24 = j.a(c13, "order_amount");
            bVar3.f23540p.put("trans_amt", (a24 == null || a24.length() <= 0) ? Constant.DEFAULT_BALANCE : a24);
            bVar3.f23525bp = com.unionpay.mobile.android.utils.c.c(a24);
            String a25 = j.a(c13, "order_currency");
            bVar3.f23540p.put("trans currcy code", (a25 == null || a25.length() <= 0) ? "0156" : a25);
            bVar3.f23526bq = a25;
            String a26 = j.a(c13, "trans_type");
            HashMap<String, String> hashMap2 = bVar3.f23540p;
            if (a26 == null || a26.length() <= 0) {
                a26 = "00";
            }
            hashMap2.put("trans_type", a26);
            String a27 = j.a(c13, "mer_name");
            HashMap<String, String> hashMap3 = bVar3.f23540p;
            if (a27 == null || a27.length() <= 0) {
                a27 = "";
            }
            hashMap3.put("mer_name", a27);
            b bVar4 = this.f23639a;
            if (bVar4.aD) {
                bVar4.f23545u = "";
            }
            if (b.b(bVar4.f23545u)) {
                this.B = 2;
                this.f23643e.m(String.format("\"user_id\":\"%s\"", this.f23639a.f23545u));
            }
            u();
        }
        k.a("uppay", "init.parserParamJsonObj() ---");
    }

    public final void a(boolean z10) {
        this.f23639a.ax = z10;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
        k.a("uppay", toString() + "doErrHappended() +++");
        b(i10, Constant.CASH_LOAD_FAIL);
        k.a("uppay", toString() + "doErrHappended() ---");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void d() {
        super.d();
        this.f23651m.setBackgroundColor(-1);
        setBackgroundDrawable(this.f23641c.a(3008, -1, -1));
        int i10 = com.unionpay.mobile.android.global.a.I / 2;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.f23641c.a(DfuException.ERROR_WRITE_NOT_PERMIT, i10, -1));
        imageView.setId(imageView.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i10, -2);
        layoutParams.addRule(14);
        layoutParams.leftMargin = com.unionpay.mobile.android.global.a.f23319j;
        layoutParams.topMargin = (int) (com.unionpay.mobile.android.global.a.f23329t * 0.3f);
        addView(imageView, layoutParams);
        this.f23713z = new ProgressBar(getContext(), null, 16843399);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, imageView.getId());
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23313d * 3;
        addView(this.f23713z, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(12, -1);
        layoutParams3.bottomMargin = com.unionpay.mobile.android.global.a.f23311b;
        addView(linearLayout, layoutParams3);
        TextView textView = new TextView(this.f23642d);
        textView.setText(com.unionpay.mobile.android.languages.c.bD.f23425a);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setGravity(1);
        new LinearLayout.LayoutParams(-2, -2).gravity = 14;
        linearLayout.addView(textView, layoutParams3);
        TextView textView2 = new TextView(getContext());
        textView2.setText(com.unionpay.mobile.android.languages.c.bD.f23443b);
        textView2.setTextColor(-1);
        textView2.setTextSize(16.0f);
        textView2.setGravity(1);
        new LinearLayout.LayoutParams(-2, -2).gravity = 14;
        linearLayout.addView(textView2, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
    }

    public final void r() {
        int i10;
        UPPayEngine uPPayEngine;
        String str;
        if (!this.K) {
            this.K = true;
            v();
            int i11 = 0;
            this.E = false;
            Activity activity = this.I;
            boolean z10 = this.J;
            this.f23643e.a();
            try {
                i10 = Integer.parseInt(this.f23639a.I.f23863c);
            } catch (NumberFormatException unused) {
                i10 = 0;
            }
            boolean z11 = !"com.unionpay.uppay".equals(com.unionpay.mobile.android.utils.f.a(this.f23642d));
            b bVar = this.f23639a;
            boolean z12 = bVar.f23530f;
            if (z12) {
                i11 = 2;
            } else if (bVar.f23527c) {
                i11 = 1;
            }
            long initJNIEnv = this.f23643e.initJNIEnv(activity, i11, i10, z11, bVar.f23497a, bVar.aO, com.unionpay.mobile.android.utils.c.b(z12 ? bVar.f23528d : bVar.f23515b));
            this.H = initJNIEnv;
            if (z10 && initJNIEnv != 0 && initJNIEnv != -1) {
                this.B = 1;
                this.f23643e.a(initJNIEnv);
                b bVar2 = this.f23639a;
                if (bVar2.f23530f) {
                    uPPayEngine = this.f23643e;
                    str = bVar2.f23529e;
                } else {
                    uPPayEngine = this.f23643e;
                    str = bVar2.f23515b;
                }
                uPPayEngine.b(str, Constant.DEFAULT_CVN2);
                this.f23643e.a(this);
            } else if (initJNIEnv == -1) {
                b(7, (String) null);
            } else if (!z10) {
                b(5, (String) null);
            }
        }
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public final void u() {
        if (this.A.equalsIgnoreCase("02")) {
            j();
            return;
        }
        this.C++;
        this.E = true;
        z();
    }

    public void v() {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        this.C++;
        z();
    }

    public final void x() {
        removeAllViews();
        this.f23713z = null;
    }
}
