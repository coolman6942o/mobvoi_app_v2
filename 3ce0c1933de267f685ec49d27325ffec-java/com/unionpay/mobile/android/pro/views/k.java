package com.unionpay.mobile.android.pro.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.OtaColumn;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.UPRadiationView;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.tsmservice.data.ResultCode;
import com.unionpay.tsmservice.mi.data.Constant;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class k extends b implements Handler.Callback, a.b {

    /* renamed from: ac  reason: collision with root package name */
    private static Date f23935ac = new Date(System.currentTimeMillis());

    /* renamed from: ad  reason: collision with root package name */
    private static String f23936ad = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) f23935ac);
    private ay F;
    private UPRadiationView G;
    private ImageView H;
    private String I;
    private String J;
    private String P;
    private NfcAdapter R;
    private FrameLayout S;

    /* renamed from: s  reason: collision with root package name */
    UPPayEngine f23942s;

    /* renamed from: t  reason: collision with root package name */
    com.unionpay.mobile.android.pboctransaction.nfc.a f23943t;

    /* renamed from: x  reason: collision with root package name */
    private boolean f23947x;

    /* renamed from: z  reason: collision with root package name */
    private Handler f23949z;

    /* renamed from: u  reason: collision with root package name */
    private int f23944u = 20;

    /* renamed from: v  reason: collision with root package name */
    private int f23945v = 100;

    /* renamed from: r  reason: collision with root package name */
    public String f23941r = "1.8";

    /* renamed from: w  reason: collision with root package name */
    private TextView f23946w = null;

    /* renamed from: y  reason: collision with root package name */
    private a f23948y = null;
    private LinearLayout A = null;
    private LinearLayout B = null;
    private RelativeLayout C = null;
    private LinearLayout D = null;
    private LinearLayout E = null;
    private com.unionpay.mobile.android.upwidget.a K = null;
    private com.unionpay.mobile.android.upwidget.a L = null;
    private boolean M = true;
    private boolean N = false;
    private a O = null;
    private int Q = 5;
    private View.OnClickListener T = new l(this);
    private View.OnClickListener U = new n(this);
    private View.OnClickListener V = new o(this);
    private View.OnClickListener W = new p(this);

    /* renamed from: aa  reason: collision with root package name */
    private View.OnClickListener f23937aa = new q(this);

    /* renamed from: ab  reason: collision with root package name */
    private View.OnClickListener f23938ab = new r(this);

    /* renamed from: ae  reason: collision with root package name */
    private String f23939ae = null;

    /* renamed from: af  reason: collision with root package name */
    private HashMap<String, String> f23940af = new HashMap<>();

    public k(Context context, e eVar, UPPayEngine uPPayEngine) {
        super(context, eVar);
        this.f23947x = false;
        this.f23949z = null;
        this.f23644f = 6;
        this.f23655q = "nfcpay";
        this.f23942s = uPPayEngine;
        this.f23949z = new Handler(this);
        this.f23947x = this.f23639a.K;
        setBackgroundColor(-11495169);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(k kVar, String str, String str2) {
        kVar.f23945v = 7;
        kVar.f23640b.a(c.bD.U);
        kVar.f23643e.c(str, str2);
    }

    private void a(String str, StringBuffer stringBuffer) {
        String str2 = this.f23940af.get(str);
        String a10 = com.unionpay.mobile.android.pboctransaction.e.a(new byte[]{(byte) (str2.length() / 2)}, 1);
        stringBuffer.append(str);
        stringBuffer.append(a10);
        stringBuffer.append(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, HashMap<String, String> hashMap) {
        Object a10 = ((PayActivity) this.f23642d).a(com.unionpay.mobile.android.pro.pboc.engine.b.class.toString());
        if ((a10 != null ? (com.unionpay.mobile.android.pro.pboc.engine.b) a10 : null) == null) {
            super.b(5);
        } else {
            new Thread(new s(this, str, hashMap)).start();
        }
    }

    private static final String d(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return com.unionpay.mobile.android.pboctransaction.e.a(messageDigest.digest());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        this.f23945v = 8;
        if (TextUtils.isEmpty(str2)) {
            this.f23643e.c(str, "");
        } else {
            this.f23643e.a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.Q--;
    }

    private static String e(String str, String str2) {
        byte[] a10 = com.unionpay.mobile.android.pboctransaction.e.a(str);
        byte[] a11 = com.unionpay.mobile.android.pboctransaction.e.a(str2);
        for (int i10 = 0; i10 < a10.length; i10++) {
            a10[i10] = (byte) (a10[i10] ^ a11[i10]);
        }
        return com.unionpay.mobile.android.pboctransaction.e.a(a10);
    }

    private void s() {
        this.f23945v = 103;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23944u--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> t() {
        HashMap<String, String> hashMap = new HashMap<>();
        a aVar = this.f23948y;
        if (aVar != null) {
            hashMap = aVar.c();
        }
        a aVar2 = this.O;
        if (aVar2 != null) {
            HashMap<String, String> c10 = aVar2.c();
            if (c10 != null && hashMap != null) {
                hashMap.putAll(c10);
            } else if (c10 != null && hashMap == null) {
                return c10;
            }
        }
        return hashMap;
    }

    private static Bundle u() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    private int v() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f23642d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final synchronized Bundle a(String str, HashMap<String, String> hashMap) {
        Bundle u10;
        u10 = u();
        this.f23940af.put("PIN", str);
        StringBuffer stringBuffer = new StringBuffer();
        a("9F26", stringBuffer);
        a("9F27", stringBuffer);
        a("9F10", stringBuffer);
        a("9F37", stringBuffer);
        a("9F36", stringBuffer);
        a("95", stringBuffer);
        a("9A", stringBuffer);
        a("9C", stringBuffer);
        a("9F02", stringBuffer);
        a("5F2A", stringBuffer);
        a("82", stringBuffer);
        a("9F1A", stringBuffer);
        a("9F03", stringBuffer);
        a("9F33", stringBuffer);
        a("9F34", stringBuffer);
        a("9F35", stringBuffer);
        a("9F1E", stringBuffer);
        if (this.f23940af.get("9F63") != null && !TextUtils.isEmpty(this.f23940af.get("9F63"))) {
            a("9F63", stringBuffer);
        }
        this.f23940af.put("DCD", stringBuffer.toString());
        this.I = e(this.I, this.f23942s.b());
        String str2 = (((("pan=" + this.f23940af.get("AN1")) + "&pin=" + this.f23940af.get("PIN")) + "&icc_data=" + this.f23940af.get("DCD")) + "&card_seq_id=" + this.f23940af.get("5F34")) + "&auth_id=" + this.J;
        com.unionpay.mobile.android.utils.k.c(Constant.KEY_MAC, str2);
        String d10 = d(str2);
        com.unionpay.mobile.android.utils.k.c(OtaColumn.COLUMN_MD5, d10);
        String g10 = this.f23643e.g(d10);
        com.unionpay.mobile.android.utils.k.c("sig", g10);
        String a10 = this.f23643e.a(str2 + ContainerUtils.FIELD_DELIMITER + g10, this.I);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f23941r);
            jSONObject.put("cmd", "pay");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(com.unionpay.tsmservice.data.Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("encrypt_key_field", a10);
            jSONObject2.put("pay_type", "2");
            jSONObject2.put("pay_mode", "1");
            jSONObject2.put("bind", "no");
            jSONObject2.put("carrier_tp", "7");
            jSONObject2.put("carrier_app_tp", "0");
            jSONObject2.put("sign", g10);
            jSONObject2.put(com.unionpay.tsmservice.data.Constant.KEY_PAN, this.f23940af.get("AN1"));
            if (this.f23940af.get("ED") != null) {
                jSONObject2.put("expire", this.f23940af.get("ED"));
            }
            if (this.f23940af.get("TD2") != null) {
                jSONObject2.put("track2_data", this.f23940af.get("TD2"));
            }
            if (!(hashMap == null || hashMap.keySet() == null || hashMap.keySet().size() <= 0)) {
                hashMap.remove(com.unionpay.tsmservice.data.Constant.KEY_PAN);
                hashMap.remove(com.unionpay.tsmservice.data.Constant.KEY_PIN);
                for (String str3 : hashMap.keySet()) {
                    jSONObject2.put(str3, hashMap.get(str3));
                }
            }
            u10.putString("action_resp_message", this.f23942s.a(jSONObject.toString()));
        } catch (JSONException unused) {
            u10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return u10;
        }
        return u10;
    }

    public final void a(NfcAdapter nfcAdapter) {
        this.R = nfcAdapter;
        if (nfcAdapter.isEnabled()) {
            this.B.setVisibility(8);
            if (this.M) {
                this.D.setVisibility(0);
            }
            this.E.setVisibility(8);
            UPRadiationView uPRadiationView = this.G;
            if (uPRadiationView != null) {
                uPRadiationView.setVisibility(0);
                return;
            }
            return;
        }
        this.B.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(0);
        UPRadiationView uPRadiationView2 = this.G;
        if (uPRadiationView2 != null) {
            uPRadiationView2.setVisibility(4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.unionpay.mobile.android.pboctransaction.nfc.a aVar) {
        String str;
        this.f23943t = aVar;
        HashMap<String, String> hashMap = this.f23639a.f23540p;
        String substring = f23936ad.substring(2, 8);
        long time = new Date(System.currentTimeMillis()).getTime();
        String valueOf = String.valueOf(time);
        boolean z10 = true;
        String format = valueOf.length() < 8 ? String.format("%08d", Long.valueOf(time)) : valueOf.substring(valueOf.length() - 8, valueOf.length());
        this.f23940af.put("9F26", "");
        this.f23940af.put("9F27", "80");
        this.f23940af.put("9F10", "");
        this.f23940af.put("9F37", format);
        this.f23940af.put("9F36", "");
        this.f23940af.put("95", "0000000800");
        this.f23940af.put("9A", substring);
        this.f23940af.put("9C", "45");
        this.f23940af.put("9F02", com.unionpay.tsmservice.data.Constant.DEFAULT_BALANCE);
        this.f23940af.put("5F2A", "0156");
        this.f23940af.put("82", "");
        this.f23940af.put("9F1A", "0156");
        this.f23940af.put("9F03", com.unionpay.tsmservice.data.Constant.DEFAULT_BALANCE);
        this.f23940af.put("9F33", "A04000");
        this.f23940af.put("9F34", "420300");
        this.f23940af.put("9F35", "34");
        this.f23940af.put("9F1E", "3030303030303030");
        this.f23940af.put("84", "");
        this.f23940af.put("9F09", "0001");
        this.f23940af.put("9F74", "");
        this.f23940af.put("9F63", "");
        this.f23940af.put("9F7A", "00");
        this.f23940af.put("9F21", f23936ad.substring(8));
        this.f23940af.put("9F4E", "0000000000000000000000000000000000000000");
        this.f23940af.put("DF31", "0100000000");
        this.f23940af.put("9F66", "36800000");
        this.f23940af.put("DF60", "00");
        this.f23940af.put("9F02", hashMap.get("trans_amt"));
        this.f23940af.put("9F1A", "0156");
        this.f23940af.put("5F2A", hashMap.get("trans currcy code"));
        this.f23940af.put("9C", hashMap.get("trans_type"));
        HashMap<String, String> hashMap2 = this.f23940af;
        hashMap2.put("CUR", hashMap2.get("5F2A"));
        Bundle u10 = u();
        f23935ac = new Date(System.currentTimeMillis());
        String format2 = new SimpleDateFormat("yyyyMMddHHmmss").format((java.util.Date) f23935ac);
        f23936ad = format2;
        this.f23939ae = new String(format2);
        String a10 = this.f23943t.a();
        if (a10 == null || a10.length() == 0) {
            str = ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE;
        } else if ("noSupUnionpay".equals(a10)) {
            str = ResultCode.ERROR_INTERFACE_GET_CARD_INFO;
        } else {
            String a11 = this.f23943t.a(a10, this.f23940af);
            if (a11 == null || a11.length() == 0) {
                str = ResultCode.ERROR_INTERFACE_ECASH_TOPUP;
            } else {
                com.unionpay.mobile.android.pboctransaction.nfc.a.b(a11, this.f23940af);
                if (u10.getString("action_resp_code") != "0000") {
                    Handler handler = this.f23949z;
                    handler.sendMessage(handler.obtainMessage(0, u10));
                    z10 = false;
                }
                if (z10 && this.M) {
                    this.f23945v = 102;
                    this.f23648j = false;
                    this.f23640b.a(c.bD.U);
                    this.f23643e.c("cardrules", "\"pan\":\"" + this.f23940af.get("AN1") + "\",\"carrier_tp\":\"7\"");
                    return;
                }
            }
        }
        u10.putString("action_resp_code", str);
        if (u10.getString("action_resp_code") != "0000") {
        }
        if (z10) {
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void a(String str, boolean z10) {
        this.f23640b.a(new m(this, z10), null);
        m mVar = this.f23640b;
        c cVar = c.bD;
        mVar.a(cVar.Y, str, cVar.W);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x025d, code lost:
        if (r2.f23510am == null) goto L73;
     */
    @Override // com.unionpay.mobile.android.nocard.views.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject) {
        int i10 = this.f23945v;
        if (i10 == 7) {
            i();
            JSONArray d10 = j.d(jSONObject, "options");
            a aVar = this.O;
            if (aVar != null) {
                aVar.a(d10);
            }
        } else if (i10 != 8) {
            switch (i10) {
                case 101:
                    this.f23639a.f23507aj = i.a(jSONObject.toString());
                    String a10 = j.a(jSONObject, "qn");
                    if (!TextUtils.isEmpty(a10)) {
                        this.f23639a.f23538n = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a10));
                    }
                    String str = this.f23639a.f23507aj;
                    if (str == null || str.length() <= 0) {
                        super.b(2);
                        return;
                    }
                    this.f23944u = 20;
                    s();
                    return;
                case 102:
                    this.f23640b.c();
                    try {
                        this.I = (String) jSONObject.get("encrypt_key");
                        this.J = (String) jSONObject.get("auth_id");
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                    boolean z10 = false;
                    int a11 = f.a(this.f23639a, jSONObject, false);
                    this.f23654p = f.a(jSONObject);
                    if (a11 != 0) {
                        super.b(a11);
                        return;
                    }
                    this.M = false;
                    this.S.setBackgroundColor(-1052684);
                    setBackgroundColor(-1052684);
                    this.F.setBackgroundColor(com.unionpay.mobile.android.global.a.M);
                    this.F.a(8);
                    this.A.removeAllViews();
                    this.B.setVisibility(8);
                    this.f23651m.setBackgroundColor(-1052684);
                    this.f23650l.setVisibility(0);
                    this.H.setVisibility(8);
                    this.D.setVisibility(8);
                    new LinearLayout.LayoutParams(-1, -2);
                    JSONArray jSONArray = new JSONArray();
                    e eVar = this.f23654p;
                    if (eVar != null) {
                        com.unionpay.mobile.android.model.f fVar = (com.unionpay.mobile.android.model.f) eVar;
                        jSONArray.put(fVar.a("promotion"));
                        jSONArray.put(fVar.a("instalment"));
                        this.f23639a.aU = fVar.a("promotion_instalment_msgbox");
                    }
                    if (jSONArray.length() > 0) {
                        a aVar2 = new a(this.f23642d, jSONArray, this, this.f23655q);
                        this.O = aVar2;
                        aVar2.a(this.f23640b, this.f23639a.aU);
                        this.O.a(this.U);
                        this.O.b(this.V);
                        this.O.c(this.W);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                        this.A.addView(this.O, layoutParams);
                    }
                    a aVar3 = this.O;
                    if (aVar3 != null) {
                        aVar3.c("instalment");
                    }
                    this.f23948y = new a(this.f23642d, this.f23639a.f23550z, this.f23643e.c(), this, this.f23940af.get("AN1"), true, this.f23655q);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                    this.A.addView(this.f23948y, layoutParams2);
                    LinearLayout linearLayout = new LinearLayout(this.f23642d);
                    linearLayout.setOrientation(1);
                    linearLayout.setId(linearLayout.hashCode());
                    new LinearLayout.LayoutParams(-1, -2);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                    layoutParams3.leftMargin = g.a(this.f23642d, 10.0f);
                    this.A.addView(linearLayout, layoutParams3);
                    if (!h()) {
                        com.unionpay.mobile.android.model.b bVar = this.f23639a;
                        if (bVar.f23509al == null) {
                            break;
                        }
                    }
                    if (this.f23639a.f23509al != null) {
                        com.unionpay.mobile.android.upwidget.a aVar4 = new com.unionpay.mobile.android.upwidget.a(this.f23642d, this.f23639a.f23509al, this.f23938ab, this.f23655q + "_agree_user_protocol");
                        this.L = aVar4;
                        linearLayout.addView(aVar4);
                    }
                    if (this.f23639a.f23510am != null) {
                        this.K = new com.unionpay.mobile.android.upwidget.a(this.f23642d, this.f23639a.f23510am, null, this.f23655q + "_remember_bankNO");
                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams4.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                        linearLayout.addView(this.K, layoutParams4);
                    }
                    new LinearLayout.LayoutParams(-1, -2);
                    TextView textView = new TextView(this.f23642d);
                    this.f23946w = textView;
                    textView.setText(j.a(this.f23639a.C, "label"));
                    this.f23946w.setTextSize(com.unionpay.mobile.android.global.b.f23344i);
                    this.f23946w.setTextColor(b.o());
                    this.f23946w.setGravity(17);
                    TextView textView2 = this.f23946w;
                    a aVar5 = this.f23948y;
                    if (aVar5 == null || aVar5.e()) {
                        z10 = true;
                    }
                    textView2.setEnabled(z10);
                    int i11 = com.unionpay.mobile.android.global.a.f23323n;
                    this.f23946w.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
                    this.f23946w.setOnClickListener(this.T);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, i11);
                    layoutParams5.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                    int a12 = g.a(this.f23642d, 10.0f);
                    layoutParams5.rightMargin = a12;
                    layoutParams5.leftMargin = a12;
                    this.A.addView(this.f23946w, layoutParams5);
                    return;
                case 103:
                    String a13 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                    String a14 = j.a(jSONObject, "fail_msg");
                    if (this.f23944u <= 0 || !a13.equalsIgnoreCase("01")) {
                        this.f23945v = 100;
                        boolean equalsIgnoreCase = a13.equalsIgnoreCase("00");
                        i();
                        if (equalsIgnoreCase) {
                            this.f23945v = 100;
                            this.f23639a.H = j.d(jSONObject, "result");
                            this.f23639a.P = j.a(jSONObject, "openupgrade_flag");
                            this.f23639a.Q = j.a(jSONObject, "temporary_pay_flag");
                            this.f23639a.R = j.a(jSONObject, "temporary_pay_info");
                            this.f23639a.V = j.a(jSONObject, "front_url");
                            this.f23639a.W = j.a(jSONObject, "front_request");
                            this.f23639a.A = j.a(jSONObject, "title");
                            this.f23639a.B = j.a(jSONObject, "succ_info");
                            com.unionpay.mobile.android.nocard.utils.b.b(jSONObject, this.f23639a);
                            com.unionpay.mobile.android.nocard.utils.b.a(jSONObject, this.f23639a);
                            a aVar6 = this.f23948y;
                            if (aVar6 != null) {
                                aVar6.f();
                            }
                            com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
                            if (bVar2.f23530f) {
                                bVar2.I.f23866f = com.unionpay.tsmservice.data.Constant.CASH_LOAD_SUCCESS;
                                j();
                                return;
                            }
                            d(8);
                            return;
                        } else if (a13.equalsIgnoreCase("03")) {
                            String[] strArr = o.f24168j;
                            a(a14);
                            return;
                        } else if (this.f23944u <= 0) {
                            a(this.f23639a.f23508ak);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        s();
                        return;
                    }
                case 104:
                    try {
                        this.I = (String) jSONObject.get("encrypt_key");
                        this.J = (String) jSONObject.get("auth_id");
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                    if (this.f23639a.f23540p != null) {
                        a.C0266a a15 = this.f23948y.a();
                        if (!a15.a()) {
                            a(a15.f23995b);
                            return;
                        }
                        this.f23945v = 101;
                        b(this.f23948y.a().f23995b, t());
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            String a16 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            if (a16 == null || !"01".equals(a16)) {
                JSONArray d11 = j.d(jSONObject, "options");
                String a17 = j.a(jSONObject, "empty_info");
                a aVar7 = this.O;
                if (aVar7 != null) {
                    aVar7.a(d11, a17);
                    return;
                }
                return;
            }
            String a18 = j.a(jSONObject, "uuid");
            if (this.Q >= 0) {
                d(this.P, a18);
                return;
            }
            String str2 = c.bD.D;
            a aVar8 = this.O;
            if (aVar8 != null) {
                aVar8.a((JSONArray) null, str2);
            }
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23946w;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.F = this.f23639a.aD ? new ay(this.f23642d, c.bD.f23458bo, this.f23641c.a(1030, -1, -1), g.a(this.f23642d, 20.0f), this) : new ay(getContext(), c.bD.f23458bo, this);
        this.F.setBackgroundColor(-16686660);
        this.F.a(0);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(this.F, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
        super.b(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void c() {
        setBackgroundColor(-11495169);
        this.f23650l.setVisibility(8);
        this.S = new FrameLayout(this.f23642d);
        this.f23651m.addView(this.S, new RelativeLayout.LayoutParams(-1, -1));
        int v10 = v();
        int i10 = com.unionpay.mobile.android.global.b.f23349n;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (v10 - i10) - (i10 / 2));
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        this.A = linearLayout;
        linearLayout.setId(linearLayout.hashCode());
        this.A.setOrientation(1);
        this.S.addView(this.A, layoutParams);
        int i11 = com.unionpay.mobile.android.global.b.f23349n;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i11 * 2, i11 * 2);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f23642d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams2.leftMargin = (displayMetrics.widthPixels / 2) - com.unionpay.mobile.android.global.b.f23349n;
        layoutParams2.topMargin = (v() / 2) - (com.unionpay.mobile.android.global.b.f23349n * 2);
        ImageView imageView = new ImageView(this.f23642d);
        this.H = imageView;
        imageView.setBackgroundDrawable(this.f23641c.a(1032, -1, -1));
        this.S.addView(this.H, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        this.E = linearLayout2;
        linearLayout2.setBackgroundColor(-1342177280);
        this.S.addView(this.E, new FrameLayout.LayoutParams(-1, -1));
        this.C = new RelativeLayout(this.f23642d);
        this.S.addView(this.C, new FrameLayout.LayoutParams(-1, -1));
        this.f23651m.setBackgroundColor(-11495169);
        LinearLayout linearLayout3 = this.A;
        linearLayout3.removeAllViews();
        this.G = new UPRadiationView(this.f23642d);
        linearLayout3.addView(this.G, new LinearLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = this.C;
        relativeLayout.setGravity(1);
        int a10 = g.a(this.f23642d, 10.0f);
        LinearLayout linearLayout4 = new LinearLayout(this.f23642d);
        this.B = linearLayout4;
        linearLayout4.setId(linearLayout4.hashCode());
        this.B.setOrientation(0);
        int i12 = a10 * 2;
        this.B.setPadding(i12, a10, i12, a10);
        Drawable a11 = this.f23641c.a(1033, -1, -1);
        this.B.setBackgroundDrawable(a11);
        String str = c.bD.f23455bl;
        TextView textView = new TextView(this.f23642d);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        this.B.addView(textView);
        String str2 = c.bD.f23456bm;
        TextView textView2 = new TextView(this.f23642d);
        textView2.setTextColor(-16729682);
        textView2.setText(str2);
        textView2.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        textView2.setOnClickListener(this.f23937aa);
        this.B.addView(textView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10, -1);
        layoutParams3.topMargin = com.unionpay.mobile.android.global.b.f23349n;
        relativeLayout.addView(this.B, layoutParams3);
        LinearLayout linearLayout5 = new LinearLayout(this.f23642d);
        this.D = linearLayout5;
        linearLayout5.setId(linearLayout5.hashCode());
        this.D.setOrientation(0);
        this.D.setGravity(17);
        this.D.setPadding(i12, a10, i12, a10);
        this.D.setBackgroundDrawable(a11);
        String str3 = c.bD.f23457bn;
        TextView textView3 = new TextView(this.f23642d);
        textView3.setTextColor(-1);
        textView3.setText(str3);
        textView3.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        this.D.addView(textView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(12, -1);
        layoutParams4.bottomMargin = com.unionpay.mobile.android.global.b.f23349n;
        relativeLayout.addView(this.D, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Object obj = message.obj;
        if (obj == null) {
            return true;
        }
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("action_resp_code");
        String string2 = bundle.getString("action_resp_message");
        if (!"0000".equalsIgnoreCase(string)) {
            ResultCode.ERROR_INTERFACE_GET_CARD_INFO.equalsIgnoreCase(string);
            a(this.f23639a.f23513ap, false);
            return true;
        } else if (string2 == null) {
            return true;
        } else {
            a(0, string2);
            return true;
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        if (this.f23639a.aD) {
            this.f23640b.a(new t(this), new u(this));
            m mVar = this.f23640b;
            c cVar = c.bD;
            mVar.a(cVar.Y, cVar.av, cVar.W, cVar.X);
            return;
        }
        a aVar = this.f23948y;
        if (aVar == null || !aVar.d()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (!bVar.K || !this.f23947x) {
                bVar.K = false;
                this.M = false;
                a(2);
                return;
            }
            bVar.K = false;
            m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f23948y;
        if (aVar != null) {
            aVar.d();
        }
        UPRadiationView uPRadiationView = this.G;
        if (uPRadiationView != null) {
            uPRadiationView.a();
        }
        this.G = null;
        this.f23640b = null;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
