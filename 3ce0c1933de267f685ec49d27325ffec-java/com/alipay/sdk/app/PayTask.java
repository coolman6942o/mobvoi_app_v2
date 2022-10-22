package com.alipay.sdk.app;

import a4.d;
import a4.h;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.b;
import com.huawei.hms.framework.common.ContainerUtils;
import com.unionpay.tsmservice.data.Constant;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;
import r3.a;
import w3.e;
import y3.a;
/* loaded from: classes.dex */
public class PayTask {

    /* renamed from: h  reason: collision with root package name */
    public static final Object f6877h = com.alipay.sdk.util.a.class;

    /* renamed from: i  reason: collision with root package name */
    public static long f6878i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final long f6879j = 3000;

    /* renamed from: k  reason: collision with root package name */
    public static long f6880k = -1;

    /* renamed from: a  reason: collision with root package name */
    public Activity f6881a;

    /* renamed from: b  reason: collision with root package name */
    public b4.a f6882b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6883c = "wappaygw.alipay.com/service/rest.htm";

    /* renamed from: d  reason: collision with root package name */
    public final String f6884d = "mclient.alipay.com/service/rest.htm";

    /* renamed from: e  reason: collision with root package name */
    public final String f6885e = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* renamed from: f  reason: collision with root package name */
    public final String f6886f = "mclient.alipay.com/cashier/mobilepay.htm";

    /* renamed from: g  reason: collision with root package name */
    public Map<String, c> f6887g = new HashMap();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6889b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ H5PayCallback f6890c;

        public a(String str, boolean z10, H5PayCallback h5PayCallback) {
            this.f6888a = str;
            this.f6889b = z10;
            this.f6890c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            a4.a h5Pay = PayTask.this.h5Pay(new y3.a(PayTask.this.f6881a, this.f6888a, "payInterceptorWithUrl"), this.f6888a, this.f6889b);
            d.h("mspl", "inc finished: " + h5Pay.a());
            this.f6890c.onPayResult(h5Pay);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // com.alipay.sdk.util.a.e
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.util.a.e
        public void b() {
        }
    }

    public PayTask(Activity activity) {
        this.f6881a = activity;
        y3.b.e().b(this.f6881a);
        this.f6882b = new b4.a(activity, "去支付宝付款");
    }

    public static boolean b() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f6880k < f6879j) {
            return true;
        }
        f6880k = elapsedRealtime;
        return false;
    }

    private a.e c() {
        return new b();
    }

    private String d(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private String e(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get("resultStatus"));
        String str2 = map.get("result");
        c remove = this.f6887g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = remove != null ? remove.a() : "";
        strArr[1] = remove != null ? remove.g() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a10 = a(com.alipay.sdk.util.b.j("&callBackUrl=\"", "\"", str2), com.alipay.sdk.util.b.j("&call_back_url=\"", "\"", str2), com.alipay.sdk.util.b.j("&return_url=\"", "\"", str2), URLDecoder.decode(com.alipay.sdk.util.b.j("&return_url=", ContainerUtils.FIELD_DELIMITER, str2), "utf-8"), URLDecoder.decode(com.alipay.sdk.util.b.j("&callBackUrl=", ContainerUtils.FIELD_DELIMITER, str2), "utf-8"), com.alipay.sdk.util.b.j("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
        }
        if (remove != null) {
            String c10 = equals ? remove.c() : remove.e();
            if (!TextUtils.isEmpty(c10)) {
                return c10;
            }
        }
        return remove != null ? r3.a.G().A() : "";
    }

    private String f(String str, y3.a aVar) {
        String b10 = aVar.b(str);
        if (b10.contains("paymethod=\"expressGateway\"")) {
            return g(aVar, b10);
        }
        List<a.b> v10 = r3.a.G().v();
        if (!r3.a.G().f33373g || v10 == null) {
            v10 = o3.a.f31407d;
        }
        if (com.alipay.sdk.util.b.A(aVar, this.f6881a, v10)) {
            com.alipay.sdk.util.a aVar2 = new com.alipay.sdk.util.a(this.f6881a, aVar, c());
            d.h("mspl", "pay inner started: " + b10);
            String d10 = aVar2.d(b10);
            d.h("mspl", "pay inner raw result: " + d10);
            aVar2.i();
            if (TextUtils.equals(d10, "failed") || TextUtils.equals(d10, "scheme_failed")) {
                p3.a.b(aVar, "biz", "LogBindCalledH5");
                return g(aVar, b10);
            } else if (TextUtils.isEmpty(d10)) {
                return o3.b.a();
            } else {
                if (!d10.contains("{\"isLogin\":\"false\"}")) {
                    return d10;
                }
                p3.a.b(aVar, "biz", "LogHkLoginByIntent");
                return a(aVar, b10, v10, d10, this.f6881a);
            }
        } else {
            p3.a.b(aVar, "biz", "LogCalledH5");
            return g(aVar, b10);
        }
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                y3.b.e().b(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f6878i < r3.a.G().l()) {
                    return false;
                }
                f6878i = elapsedRealtime;
                r3.a.G().g(y3.a.o(), context.getApplicationContext(), false);
                return true;
            } catch (Exception e10) {
                d.d(e10);
                return false;
            }
        }
    }

    private String g(y3.a aVar, String str) {
        showLoading();
        com.alipay.sdk.app.c cVar = null;
        try {
            try {
                JSONObject c10 = new e().h(aVar, this.f6881a.getApplicationContext(), str).c();
                String optString = c10.optString("end_code", null);
                List<x3.a> b10 = x3.a.b(c10.optJSONObject("form").optJSONObject("onload"));
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    if (b10.get(i10).a() == com.alipay.sdk.protocol.a.Update) {
                        x3.a.c(b10.get(i10));
                    }
                }
                k(aVar, c10);
                dismissLoading();
                p3.a.a(this.f6881a, aVar, str, aVar.f36738d);
                for (int i11 = 0; i11 < b10.size(); i11++) {
                    x3.a aVar2 = b10.get(i11);
                    if (aVar2.a() == com.alipay.sdk.protocol.a.WapPay) {
                        String i12 = i(aVar, aVar2);
                        dismissLoading();
                        p3.a.a(this.f6881a, aVar, str, aVar.f36738d);
                        return i12;
                    } else if (aVar2.a() == com.alipay.sdk.protocol.a.OpenWeb) {
                        String j10 = j(aVar, aVar2, optString);
                        dismissLoading();
                        p3.a.a(this.f6881a, aVar, str, aVar.f36738d);
                        return j10;
                    }
                }
                dismissLoading();
                p3.a.a(this.f6881a, aVar, str, aVar.f36738d);
            } catch (IOException e10) {
                cVar = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.NETWORK_ERROR.b());
                p3.a.f(aVar, "net", e10);
                dismissLoading();
                p3.a.a(this.f6881a, aVar, str, aVar.f36738d);
            }
            if (cVar == null) {
                cVar = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.FAILED.b());
            }
            return o3.b.b(cVar.b(), cVar.a(), "");
        }
    }

    private synchronized String h(y3.a aVar, String str, boolean z10) {
        if (b()) {
            p3.a.h(aVar, "biz", "RepPay", "");
            return o3.b.e();
        }
        if (z10) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            o3.a.b(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            o3.a.b("");
        }
        if (str.contains("service=alipay.acquire.mr.ord.createandpay")) {
            q3.a.f32921c = true;
        }
        if (q3.a.f32921c) {
            if (str.startsWith("https://wappaygw.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://wappaygw.alipay.com/home/exterfaceAssign.htm?") + 53);
            } else if (str.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm?")) {
                str = str.substring(str.indexOf("https://mclient.alipay.com/home/exterfaceAssign.htm?") + 52);
            }
        }
        d.h("mspl", "pay prepared: " + str);
        String f10 = f(str, aVar);
        d.h("mspl", "pay raw result: " + f10);
        a4.e.c(aVar, this.f6881a.getApplicationContext(), f10);
        p3.a.c(aVar, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
        p3.a.c(aVar, "biz", "PgReturnV", h.a(f10, "resultStatus") + "|" + h.a(f10, "memo"));
        if (!r3.a.G().B()) {
            r3.a.G().g(aVar, this.f6881a.getApplicationContext(), false);
        }
        dismissLoading();
        p3.a.g(this.f6881a.getApplicationContext(), aVar, str, aVar.f36738d);
        d.h("mspl", "pay returning: " + f10);
        return f10;
    }

    private String i(y3.a aVar, x3.a aVar2) {
        String[] f10 = aVar2.f();
        Intent intent = new Intent(this.f6881a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", f10[0]);
        if (f10.length == 2) {
            bundle.putString("cookie", f10[1]);
        }
        intent.putExtras(bundle);
        a.C0536a.c(aVar, intent);
        this.f6881a.startActivity(intent);
        Object obj = f6877h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e10) {
                d.d(e10);
                return o3.b.a();
            }
        }
        String g10 = o3.b.g();
        return TextUtils.isEmpty(g10) ? o3.b.a() : g10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        r0 = r6.f();
        r11 = o3.b.b(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.util.b.M(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String j(y3.a aVar, x3.a aVar2, String str) {
        boolean f10;
        String g10;
        String[] f11 = aVar2.f();
        Intent intent = new Intent(this.f6881a, H5PayActivity.class);
        try {
            JSONObject P = com.alipay.sdk.util.b.P(new String(s3.a.d(f11[2])));
            intent.putExtra("url", f11[0]);
            intent.putExtra("title", f11[1]);
            intent.putExtra("version", "v2");
            intent.putExtra(Constant.KEY_METHOD, P.optString(Constant.KEY_METHOD, "POST"));
            o3.b.d(false);
            o3.b.c(null);
            a.C0536a.c(aVar, intent);
            this.f6881a.startActivity(intent);
            Object obj = f6877h;
            synchronized (obj) {
                try {
                    obj.wait();
                    f10 = o3.b.f();
                    g10 = o3.b.g();
                    o3.b.d(false);
                    o3.b.c(null);
                } catch (InterruptedException e10) {
                    d.d(e10);
                    return o3.b.a();
                }
            }
            String str2 = "";
            if (f10) {
                try {
                    List<x3.a> b10 = x3.a.b(com.alipay.sdk.util.b.P(new String(s3.a.d(g10))));
                    int i10 = 0;
                    while (true) {
                        if (i10 >= b10.size()) {
                            break;
                        }
                        x3.a aVar3 = b10.get(i10);
                        if (aVar3.a() == com.alipay.sdk.protocol.a.SetResult) {
                            break;
                        }
                        i10++;
                    }
                } catch (Throwable th2) {
                    d.d(th2);
                    p3.a.e(aVar, "biz", "H5PayDataAnalysisError", th2, g10);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            try {
                return o3.b.b(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th3) {
                p3.a.e(aVar, "biz", "H5PayDataAnalysisError", th3, "endCode: " + str);
                return o3.b.b(8000, "", "");
            }
        } catch (Throwable th4) {
            d.d(th4);
            p3.a.e(aVar, "biz", "H5PayDataAnalysisError", th4, Arrays.toString(f11));
            return o3.b.a();
        }
    }

    private void k(y3.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString("client_key");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                z3.a.a(y3.b.e().c()).b(optString, optString2);
            }
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "ParserTidClientKeyEx", th2);
        }
    }

    private boolean l(boolean z10, boolean z11, String str, StringBuilder sb2, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i10];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z11;
        }
        if (z10) {
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append(str);
            sb2.append("=\"");
            sb2.append(str2);
            sb2.append("\"");
            return true;
        }
        sb2.append(str);
        sb2.append("=\"");
        sb2.append(str2);
        sb2.append("\"");
        return true;
    }

    public void dismissLoading() {
        b4.a aVar = this.f6882b;
        if (aVar != null) {
            aVar.c();
            this.f6882b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        String j10 = com.alipay.sdk.util.b.j("<request_token>", "</request_token>", com.alipay.sdk.util.b.o(trim2).get("req_data"));
                        y3.a aVar = new y3.a(this.f6881a, "", "");
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + j10 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar.c("sc", "h5tonative") + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        String j11 = com.alipay.sdk.util.b.j("<request_token>", "</request_token>", com.alipay.sdk.util.b.o(trim3).get("req_data"));
                        y3.a aVar2 = new y3.a(this.f6881a, "", "");
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + j11 + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + aVar2.c("sc", "h5tonative") + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    y3.a aVar3 = new y3.a(this.f6881a, "", "");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", aVar3.c("sc", "h5tonative"));
                    return "new_external_info==" + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String j12 = com.alipay.sdk.util.b.j("?", "", str);
                    if (!TextUtils.isEmpty(j12)) {
                        Map<String, String> o10 = com.alipay.sdk.util.b.o(j12);
                        StringBuilder sb2 = new StringBuilder();
                        if (l(false, true, "trade_no", sb2, o10, "trade_no", "alipay_trade_no")) {
                            l(true, false, "pay_phase_id", sb2, o10, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb2.append("&biz_sub_type=\"TRADE\"");
                            sb2.append("&biz_type=\"trade\"");
                            String str2 = o10.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(o10.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(o10.get("sid")) || !TextUtils.isEmpty(o10.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb2.append("&app_name=\"" + str2 + "\"");
                            if (!l(true, true, "extern_token", sb2, o10, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            l(true, false, "appenv", sb2, o10, "appenv");
                            sb2.append("&pay_channel_id=\"alipay_sdk\"");
                            c cVar = new c(this, null);
                            cVar.d(o10.get("return_url"));
                            cVar.f(o10.get("show_url"));
                            cVar.b(o10.get("pay_order_id"));
                            y3.a aVar4 = new y3.a(this.f6881a, "", "");
                            String str3 = sb2.toString() + "&bizcontext=\"" + aVar4.c("sc", "h5tonative") + "\"";
                            this.f6887g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.a() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (r3.a.G().r() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                        Uri parse = Uri.parse(trim);
                        String queryParameter = parse.getQueryParameter("return_url");
                        String queryParameter2 = parse.getQueryParameter("show_url");
                        String queryParameter3 = parse.getQueryParameter("pay_order_id");
                        String a10 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                        String a11 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = parse.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                        String a12 = a(strArr);
                        String a13 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        String a14 = a(parse.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a12) && !TextUtils.isEmpty(a13)) {
                            String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a10, a11, a12, a13, a14, new y3.a(this.f6881a, "", "").c("sc", "h5tonative"));
                            c cVar2 = new c(this, null);
                            cVar2.d(queryParameter);
                            cVar2.f(queryParameter2);
                            cVar2.b(queryParameter3);
                            cVar2.h(a10);
                            this.f6887g.put(format, cVar2);
                            return format;
                        }
                    }
                }
                String c10 = new y3.a(this.f6881a, "", "").c("sc", "h5tonative");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", trim);
                jSONObject2.put("bizcontext", c10);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th2) {
            d.d(th2);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return a4.e.b(new y3.a(this.f6881a, "", "fetchTradeToken"), this.f6881a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.02";
    }

    public synchronized a4.a h5Pay(y3.a aVar, String str, boolean z10) {
        a4.a aVar2;
        aVar2 = new a4.a();
        String[] split = h(aVar, str, z10).split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            int indexOf = str2.indexOf("={");
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                hashMap.put(substring, d(str2, substring));
            }
        }
        if (hashMap.containsKey("resultStatus")) {
            aVar2.c(hashMap.get("resultStatus"));
        }
        aVar2.d(e(str, hashMap));
        if (TextUtils.isEmpty(aVar2.b())) {
            p3.a.h(aVar, "biz", "H5CbUrlEmpty", "");
        }
        return aVar2;
    }

    public synchronized String pay(String str, boolean z10) {
        return h(new y3.a(this.f6881a, str, "pay"), str, z10);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z10, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            d.h("mspl", "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new a(fetchOrderInfoFromH5PayUrl, z10, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z10) {
        y3.a aVar;
        aVar = new y3.a(this.f6881a, str, "payV2");
        return h.d(aVar, h(aVar, str, z10));
    }

    public void showLoading() {
        b4.a aVar = this.f6882b;
        if (aVar != null) {
            aVar.f();
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(y3.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        b.c d10 = com.alipay.sdk.util.b.d(aVar, activity, list);
        if (d10 == null || d10.b(aVar) || d10.a() || !TextUtils.equals(d10.f6934a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        d.f("mspl", "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.f6872b;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra("orderSuffix", str);
        intent.putExtra("externalPkgName", activity.getPackageName());
        intent.putExtra("phonecashier.pay.hash", valueOf);
        a.C0536a.c(aVar, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                d.f("mspl", "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                d.f("mspl", "PayTask interrupted");
                return o3.b.a();
            }
        }
        String str3 = PayResultActivity.b.f6876b;
        d.f("mspl", "PayTask ret: " + str3);
        return str3;
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f6893a;

        /* renamed from: b  reason: collision with root package name */
        public String f6894b;

        /* renamed from: c  reason: collision with root package name */
        public String f6895c;

        /* renamed from: d  reason: collision with root package name */
        public String f6896d;

        public c(PayTask payTask) {
            this.f6893a = "";
            this.f6894b = "";
            this.f6895c = "";
            this.f6896d = "";
        }

        public String a() {
            return this.f6895c;
        }

        public void b(String str) {
            this.f6895c = str;
        }

        public String c() {
            return this.f6893a;
        }

        public void d(String str) {
            this.f6893a = str;
        }

        public String e() {
            return this.f6894b;
        }

        public void f(String str) {
            this.f6894b = str;
        }

        public String g() {
            return this.f6896d;
        }

        public void h(String str) {
            this.f6896d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this(payTask);
        }
    }
}
