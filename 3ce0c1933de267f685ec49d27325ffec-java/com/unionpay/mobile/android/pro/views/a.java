package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.OtaColumn;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.model.f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.ResultCode;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends b implements Handler.Callback, a.b {
    private static Date M = new Date(System.currentTimeMillis());
    private static String N = new SimpleDateFormat("yyyyMMddhhmmss").format((java.util.Date) M);
    private static HashMap<String, String> P = new HashMap<>();
    private static HashMap<String, String> Q = new HashMap<>();
    private ay A;
    private String B;
    private String E;

    /* renamed from: s  reason: collision with root package name */
    UPPayEngine f23907s;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23911w;

    /* renamed from: z  reason: collision with root package name */
    private Handler f23914z;

    /* renamed from: t  reason: collision with root package name */
    private int f23908t = 20;

    /* renamed from: u  reason: collision with root package name */
    private int f23909u = 100;

    /* renamed from: r  reason: collision with root package name */
    public String f23906r = "1.9";

    /* renamed from: v  reason: collision with root package name */
    private TextView f23910v = null;

    /* renamed from: x  reason: collision with root package name */
    private com.unionpay.mobile.android.upviews.a f23912x = null;

    /* renamed from: y  reason: collision with root package name */
    private com.unionpay.mobile.android.upviews.a f23913y = null;
    private int D = 5;
    private boolean F = false;
    private Handler.Callback G = new b(this);
    private Handler H = new Handler(this.G);
    private View.OnClickListener I = new c(this);
    private View.OnClickListener J = new d(this);
    private View.OnClickListener K = new e(this);
    private View.OnClickListener L = new f(this);
    private String O = null;
    private c C = (c) com.unionpay.mobile.android.model.b.f23492bb.get(this.f23639a.f23516bc);

    public a(Context context, e eVar, UPPayEngine uPPayEngine) {
        super(context, eVar);
        this.f23911w = false;
        this.f23914z = null;
        this.f23644f = 6;
        this.f23655q = "hcepay";
        this.f23907s = uPPayEngine;
        this.f23914z = new Handler(this);
        this.f23911w = this.f23639a.K;
        setBackgroundColor(-1052684);
        e();
    }

    private void a(LinearLayout linearLayout) {
        com.unionpay.mobile.android.upviews.a aVar = this.f23913y;
        z c10 = aVar != null ? aVar.c("instalment") : null;
        int length = this.f23639a.f23550z.length();
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < length; i10++) {
            Object b10 = j.b(this.f23639a.f23550z, i10);
            if (b10 != null) {
                try {
                    JSONObject jSONObject = (JSONObject) b10;
                    if (Constant.KEY_PAN.equals(j.a(jSONObject, "type"))) {
                        jSONObject.put("label", this.C.b() + this.C.c());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
        this.f23912x = new com.unionpay.mobile.android.upviews.a(this.f23642d, jSONArray, this.f23643e.c(), this, this.C.a(), true, false, c10, this.f23639a.f23501ad, this.f23655q);
        linearLayout.addView(this.f23912x, new LinearLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, String str, String str2) {
        aVar.f23909u = 8;
        aVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        aVar.f23643e.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, String str, HashMap hashMap) {
        Object a10 = ((PayActivity) aVar.f23642d).a(com.unionpay.mobile.android.pro.pboc.engine.b.class.toString());
        if ((a10 != null ? (com.unionpay.mobile.android.pro.pboc.engine.b) a10 : null) == null) {
            aVar.b(5);
        } else {
            new Thread(new g(aVar, str, hashMap)).start();
        }
    }

    private static void a(StringBuffer stringBuffer) {
        for (String str : P.keySet()) {
            String str2 = P.get(str);
            if (!TextUtils.isEmpty(str2)) {
                String a10 = com.unionpay.mobile.android.pboctransaction.e.a(new byte[]{(byte) (str2.length() / 2)}, 1);
                stringBuffer.append(str);
                stringBuffer.append(a10);
                stringBuffer.append(str2);
            }
        }
    }

    private boolean b(HashMap<String, String> hashMap) {
        String substring = N.substring(2, 8);
        long time = new Date(System.currentTimeMillis()).getTime();
        String valueOf = String.valueOf(time);
        String format = valueOf.length() < 8 ? String.format("%08d", Long.valueOf(time)) : valueOf.substring(valueOf.length() - 8, valueOf.length());
        P.put("9F26", "");
        P.put("9F27", "80");
        P.put("9F10", "");
        P.put("9F37", format);
        P.put("9F36", "");
        P.put("95", "0000000800");
        P.put("9A", substring);
        P.put("9C", "45");
        P.put("9F02", Constant.DEFAULT_BALANCE);
        P.put("5F2A", "0156");
        P.put("82", "");
        P.put("9F1A", "0156");
        P.put("9F03", Constant.DEFAULT_BALANCE);
        P.put("9F33", "A04000");
        P.put("9F34", "420300");
        P.put("9F35", "34");
        P.put("9F1E", "3030303030303030");
        P.put("84", "");
        P.put("9F09", "0001");
        P.put("9F41", "");
        P.put("91", "");
        P.put("71", "");
        P.put("72", "");
        P.put("DF31", "");
        P.put("9F74", "");
        P.put("9F63", "");
        P.put("8A", "");
        Q.put("9F66", "26C00000");
        t();
        P.put("9F02", hashMap.get("trans_amt"));
        P.put("9F1A", "0156");
        P.put("5F2A", hashMap.get("trans currcy code"));
        P.put("9C", hashMap.get("trans_type"));
        Q.put("CUR", P.get("5F2A"));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("9F66", Q.get("9F66"));
            jSONObject.put("9F02", P.get("9F02"));
            jSONObject.put("9F03", P.get("9F03"));
            jSONObject.put("9F1A", P.get("9F1A"));
            jSONObject.put("95", P.get("95"));
            jSONObject.put("5F2A", P.get("5F2A"));
            jSONObject.put("9A", P.get("9A"));
            jSONObject.put("9C", P.get("9C"));
            jSONObject.put("9F37", P.get("9F37"));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String f10 = this.C.f();
        try {
            this.C.g().a(com.unionpay.mobile.android.hce.a.b(this.C.a(), f10), com.unionpay.mobile.android.hce.a.b(jSONObject.toString(), f10), "", new com.unionpay.mobile.android.hce.b(2004, "", this.H));
            this.H.sendMessageDelayed(this.H.obtainMessage(2006), this.f23639a.f23518be);
            return true;
        } catch (RemoteException e11) {
            e11.printStackTrace();
            a(this.f23639a.f23513ap, false);
            return false;
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

    private static String d(String str, String str2) {
        byte[] a10 = com.unionpay.mobile.android.pboctransaction.e.a(str);
        byte[] a11 = com.unionpay.mobile.android.pboctransaction.e.a(str2);
        for (int i10 = 0; i10 < a10.length; i10++) {
            a10[i10] = (byte) (a10[i10] ^ a11[i10]);
        }
        return com.unionpay.mobile.android.pboctransaction.e.a(a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean d(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String a10 = j.a(jSONObject, next);
            if (!TextUtils.isEmpty(a10)) {
                (("5F34".equals(next) || "57".equals(next) || "9F6C".equals(next) || "9F5D".equals(next) || "5F20".equals(next)) ? Q : P).put(next, a10);
            }
        }
        String str = P.get("9F10");
        return TextUtils.isEmpty(str) || ((byte) (com.unionpay.mobile.android.pboctransaction.e.a(str)[4] & 48)) == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        this.f23909u = 9;
        if (TextUtils.isEmpty(str2)) {
            this.f23643e.c(str, "");
        } else {
            this.f23643e.a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.D--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashMap f(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        com.unionpay.mobile.android.upviews.a aVar2 = aVar.f23912x;
        if (aVar2 != null) {
            hashMap = aVar2.c();
        }
        com.unionpay.mobile.android.upviews.a aVar3 = aVar.f23913y;
        if (aVar3 != null) {
            HashMap<String, String> c10 = aVar3.c();
            if (c10 != null && hashMap != null) {
                hashMap.putAll(c10);
            } else if (c10 != null && hashMap == null) {
                return c10;
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(a aVar) {
        aVar.f23909u = 104;
        aVar.f23648j = false;
        aVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        k.c("uppay", "");
        aVar.f23643e.c("cardsecret", "");
    }

    private void s() {
        this.f23909u = 103;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23908t--;
    }

    private static Bundle t() {
        Bundle bundle = new Bundle();
        bundle.putString("action_resp_code", "0000");
        return bundle;
    }

    public final synchronized Bundle a(String str, HashMap<String, String> hashMap) {
        Bundle t10;
        t10 = t();
        Q.put("PIN", str);
        Q.put("AN1", this.C.a());
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer);
        Q.put("DCD", stringBuffer.toString());
        this.B = d(this.f23639a.f23519bf, this.f23907s.b());
        if (Q.get("5F34") != null) {
            StringBuffer stringBuffer2 = new StringBuffer(Q.get("5F34"));
            stringBuffer2.insert(0, "0");
            Q.put("5F34", stringBuffer2.toString());
        } else {
            Q.put("5F34", "");
        }
        if (Q.get("57") != null) {
            String upperCase = Q.get("57").toUpperCase();
            while (true) {
                if (!upperCase.substring(upperCase.length() - 1, upperCase.length()).equalsIgnoreCase("f") && !upperCase.substring(upperCase.length() - 1, upperCase.length()).equalsIgnoreCase("F")) {
                    break;
                }
                upperCase = upperCase.substring(0, upperCase.length() - 1);
            }
            Q.put("TD2", upperCase);
            int indexOf = upperCase.indexOf("D");
            String substring = upperCase.substring(0, indexOf);
            if (substring.endsWith("F") || substring.endsWith("f")) {
                substring = substring.substring(0, substring.length() - 1);
            }
            Q.put("AN1", substring);
            Q.put("ED", upperCase.substring(indexOf + 1, indexOf + 5));
        }
        Q.put("AMT", P.get("9F02"));
        String str2 = (((("pan=" + Q.get("AN1")) + "&pin=" + Q.get("PIN")) + "&icc_data=" + Q.get("DCD")) + "&card_seq_id=" + Q.get("5F34")) + "&auth_id=" + this.f23639a.f23520bg;
        k.c(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC, str2);
        String d10 = d(str2);
        k.c(OtaColumn.COLUMN_MD5, d10);
        String g10 = this.f23643e.g(d10);
        k.c("sig", g10);
        String a10 = this.f23643e.a(str2 + ContainerUtils.FIELD_DELIMITER + g10, this.B);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("v", this.f23906r);
            jSONObject.put("cmd", "pay");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Constant.KEY_PARAMS, jSONObject2);
            jSONObject2.put("encrypt_key_field", a10);
            jSONObject2.put("pay_type", "2");
            jSONObject2.put("pay_mode", "1");
            jSONObject2.put("bind", "no");
            jSONObject2.put("carrier_tp", "9");
            jSONObject2.put("carrier_app_tp", "0");
            jSONObject2.put("sign", g10);
            jSONObject2.put(Constant.KEY_PAN, Q.get("AN1"));
            if (Q.get("ED") != null) {
                jSONObject2.put("expire", Q.get("ED"));
            }
            if (Q.get("TD2") != null) {
                jSONObject2.put("track2_data", Q.get("TD2"));
            }
            if (!(hashMap == null || hashMap.keySet() == null || hashMap.keySet().size() <= 0)) {
                hashMap.remove(Constant.KEY_PAN);
                hashMap.remove(Constant.KEY_PIN);
                for (String str3 : hashMap.keySet()) {
                    jSONObject2.put(str3, hashMap.get(str3));
                }
            }
            t10.putString("action_resp_message", this.f23907s.a(jSONObject.toString()));
        } catch (JSONException unused) {
            t10.putString("action_resp_code", ResultCode.ERROR_INTERFACE_GET_SMS_AUTH_CODE);
            return t10;
        }
        return t10;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        int i10 = this.f23909u;
        if (i10 == 8) {
            i();
            JSONArray d10 = j.d(jSONObject, "options");
            com.unionpay.mobile.android.upviews.a aVar = this.f23913y;
            if (aVar != null) {
                aVar.a(d10);
            }
        } else if (i10 == 9) {
            String a10 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            if (a10 == null || !"01".equals(a10)) {
                JSONArray d11 = j.d(jSONObject, "options");
                String a11 = j.a(jSONObject, "empty_info");
                com.unionpay.mobile.android.upviews.a aVar2 = this.f23913y;
                if (aVar2 != null) {
                    aVar2.a(d11, a11);
                    return;
                }
                return;
            }
            String a12 = j.a(jSONObject, "uuid");
            if (this.D >= 0) {
                e(this.E, a12);
                return;
            }
            String str = com.unionpay.mobile.android.languages.c.bD.D;
            com.unionpay.mobile.android.upviews.a aVar3 = this.f23913y;
            if (aVar3 != null) {
                aVar3.a((JSONArray) null, str);
            }
        } else if (i10 == 101) {
            this.f23639a.f23507aj = i.a(jSONObject.toString());
            String a13 = j.a(jSONObject, "qn");
            if (!TextUtils.isEmpty(a13)) {
                this.f23639a.f23538n = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a13));
            }
            String str2 = this.f23639a.f23507aj;
            if (str2 == null || str2.length() <= 0) {
                b(2);
                return;
            }
            this.f23908t = 20;
            s();
        } else if (i10 == 103) {
            String a14 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            String a15 = j.a(jSONObject, "fail_msg");
            if (this.f23908t <= 0 || !a14.equalsIgnoreCase("01")) {
                this.f23909u = 100;
                boolean equalsIgnoreCase = a14.equalsIgnoreCase("00");
                i();
                if (equalsIgnoreCase) {
                    this.f23909u = 100;
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
                    com.unionpay.mobile.android.upviews.a aVar4 = this.f23912x;
                    if (aVar4 != null) {
                        aVar4.f();
                    }
                    Iterator<d> it = com.unionpay.mobile.android.model.b.f23492bb.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f23642d.unbindService(((c) it.next()).h());
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    com.unionpay.mobile.android.model.b bVar = this.f23639a;
                    if (bVar.f23530f) {
                        bVar.I.f23866f = Constant.CASH_LOAD_SUCCESS;
                        j();
                        return;
                    }
                    d(8);
                    return;
                }
                this.F = true;
                if (a14.equalsIgnoreCase("03")) {
                    String[] strArr = o.f24168j;
                    a(a15);
                } else if (this.f23908t <= 0) {
                    b(19);
                }
            } else {
                s();
            }
        } else if (i10 == 104) {
            try {
                this.f23639a.f23519bf = (String) jSONObject.get("encrypt_key");
                this.f23639a.f23520bg = (String) jSONObject.get("auth_id");
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (this.f23639a.f23540p != null) {
                a.C0266a a16 = this.f23912x.a();
                if (!a16.a()) {
                    this.F = true;
                    a(a16.f23995b);
                    return;
                }
                this.f23909u = 101;
                a(this.f23639a.f23540p);
            }
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23910v;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    public final boolean a(HashMap<String, String> hashMap) {
        M = new Date(System.currentTimeMillis());
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format((java.util.Date) M);
        N = format;
        this.O = new String(format);
        return b(hashMap);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.A = new ay(getContext(), com.unionpay.mobile.android.languages.c.bD.f23460bq, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(this.A, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
        int i11 = this.f23909u;
        if (i11 == 101 || i11 == 103 || i11 == 104) {
            this.F = true;
        }
        super.b(i10);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        this.f23651m.removeAllViews();
        this.f23653o.a(this);
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        boolean z10 = true;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams.addRule(10, -1);
        this.f23651m.addView(linearLayout, layoutParams);
        JSONArray jSONArray = new JSONArray();
        e eVar = this.f23654p;
        if (eVar != null) {
            f fVar = (f) eVar;
            jSONArray.put(fVar.a("promotion"));
            jSONArray.put(fVar.a("instalment"));
            this.f23639a.aU = fVar.a("promotion_instalment_msgbox");
        }
        if (jSONArray.length() > 0) {
            com.unionpay.mobile.android.upviews.a aVar = new com.unionpay.mobile.android.upviews.a(this.f23642d, jSONArray, this, this.f23655q);
            this.f23913y = aVar;
            aVar.a(this.I);
            this.f23913y.b(this.J);
            this.f23913y.c(this.K);
            this.f23913y.a(this.f23640b, this.f23639a.aU);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout.addView(this.f23913y, layoutParams2);
        }
        a(linearLayout);
        new LinearLayout.LayoutParams(-1, -2);
        TextView textView = new TextView(this.f23642d);
        this.f23910v = textView;
        textView.setText(j.a(this.f23639a.C, "label"));
        this.f23910v.setTextSize(com.unionpay.mobile.android.global.b.f23344i);
        this.f23910v.setTextColor(b.o());
        this.f23910v.setGravity(17);
        TextView textView2 = this.f23910v;
        com.unionpay.mobile.android.upviews.a aVar2 = this.f23912x;
        if (aVar2 != null && !aVar2.e()) {
            z10 = false;
        }
        textView2.setEnabled(z10);
        int i10 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23910v.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23910v.setOnClickListener(this.L);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, i10);
        layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a10 = g.a(this.f23642d, 10.0f);
        layoutParams3.rightMargin = a10;
        layoutParams3.leftMargin = a10;
        linearLayout.addView(this.f23910v, layoutParams3);
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
        com.unionpay.mobile.android.upviews.a aVar = this.f23912x;
        if (aVar == null || !aVar.d()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (!bVar.K || !this.f23911w) {
                bVar.K = false;
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
        com.unionpay.mobile.android.upviews.a aVar = this.f23912x;
        if (aVar != null) {
            aVar.d();
        }
        this.f23640b = null;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
