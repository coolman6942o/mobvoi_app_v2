package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.k;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UPPayEngine implements Handler.Callback, com.unionpay.mobile.android.fully.a, Runnable {

    /* renamed from: e  reason: collision with root package name */
    private Context f23573e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f23574f;

    /* renamed from: b  reason: collision with root package name */
    private d f23570b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f23571c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f23572d = null;

    /* renamed from: g  reason: collision with root package name */
    private a f23575g = null;

    /* renamed from: h  reason: collision with root package name */
    private com.unionpay.mobile.android.model.b f23576h = null;

    /* renamed from: a  reason: collision with root package name */
    protected c f23569a = null;

    /* renamed from: i  reason: collision with root package name */
    private long f23577i = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10, String str);
    }

    /* loaded from: classes2.dex */
    class b {

        /* renamed from: a  reason: collision with root package name */
        public int f23578a;

        /* renamed from: b  reason: collision with root package name */
        public String f23579b;

        public b(int i10, String str) {
            this.f23578a = i10;
            this.f23579b = str;
        }
    }

    public UPPayEngine(Context context) {
        this.f23573e = null;
        this.f23574f = null;
        this.f23573e = context;
        this.f23574f = new Handler(this);
    }

    private native String commonMessage(long j10, String str, String str2, String str3);

    private native String decryptResponse(long j10, String str);

    private native String desEncryptMessage(long j10, String str, String str2);

    private native String encryptMessage(long j10, String str);

    private native String followRulesMessage(long j10, String str, String str2);

    private native String getServerUrl(int i10, int i11, int i12);

    private native String getUserInfo(long j10, String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public static String i() {
        return new SimpleDateFormat("yyyyMMddhhmmss").format((Date) new java.sql.Date(System.currentTimeMillis()));
    }

    private native String initMessage(long j10, String str, String str2);

    private void n(String str) {
        new Thread(this, str).start();
    }

    private native String openupgradeMessage(long j10, String str, String str2);

    private native String payingMessage(long j10, String str, String str2, String str3, String str4, String str5);

    private native String retrieveInitializeKey(long j10);

    private native String rsaEncryptMessageForHFT(long j10, String str);

    private native String rsaPrivateEncryptMessage(long j10, String str);

    private native String ruleMessage(long j10, String str, String str2);

    private native void setSessionKey(long j10, String str);

    private native String unBoundMessage(long j10, String str, String str2);

    @Override // com.unionpay.mobile.android.fully.a
    public String a(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("reqtm", i());
            str2 = jSONObject.toString();
        } catch (JSONException unused) {
            str2 = str;
        }
        k.c("uppay", "post message = " + str);
        this.f23570b.a(encryptMessage(this.f23577i, str2));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        g();
        if (this.f23569a == null) {
            this.f23569a = new c(this.f23570b, this.f23573e);
        }
        int a10 = this.f23569a.a();
        String b10 = this.f23569a.b();
        if (a10 == 0) {
            String decryptResponse = decryptResponse(this.f23577i, b10);
            k.a("uppay", "[ response msg ] " + decryptResponse);
            return decryptResponse;
        }
        Message obtainMessage = this.f23574f.obtainMessage(2);
        obtainMessage.arg1 = a10;
        this.f23574f.sendMessage(obtainMessage);
        return null;
    }

    public final String a(String str, String str2) {
        return desEncryptMessage(this.f23577i, str, str2);
    }

    public final void a() {
        String str;
        StringBuilder sb2;
        String str2;
        if (!TextUtils.isEmpty(this.f23576h.f23524bk)) {
            com.unionpay.mobile.android.model.b bVar = this.f23576h;
            if (bVar.f23530f) {
                sb2 = new StringBuilder();
                sb2.append(this.f23576h.f23524bk);
                str2 = "/app/mobile/hft";
            } else if (bVar.f23527c) {
                sb2 = new StringBuilder();
                sb2.append(this.f23576h.f23524bk);
                str2 = "/app/mobile/json";
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.f23576h.f23524bk);
                str2 = "/gateway/mobile/json";
            }
            sb2.append(str2);
            str = sb2.toString();
        } else {
            int i10 = 2;
            int i11 = "01".equalsIgnoreCase(this.f23576h.I.f23863c) ? 1 : "02".equalsIgnoreCase(this.f23576h.I.f23863c) ? 2 : "98".equalsIgnoreCase(this.f23576h.I.f23863c) ? 98 : "99".equalsIgnoreCase(this.f23576h.I.f23863c) ? 99 : "95".equalsIgnoreCase(this.f23576h.I.f23863c) ? 95 : 0;
            k.a("uppay", "idx  is : " + i11 + ", isNewTypeTn :" + this.f23576h.f23527c);
            com.unionpay.mobile.android.model.b bVar2 = this.f23576h;
            if (!bVar2.f23530f) {
                i10 = bVar2.f23527c ? 1 : 0;
            }
            str = getServerUrl(i10, i11, bVar2.aO);
        }
        k.a("uppay", "url  is : " + str);
        this.f23570b = new d(str);
    }

    public final void a(long j10) {
        this.f23577i = j10;
    }

    public final void a(com.unionpay.mobile.android.model.b bVar) {
        com.unionpay.mobile.android.model.b bVar2 = this.f23576h;
        if (bVar2 == null || bVar2 != bVar) {
            this.f23576h = bVar;
        }
    }

    public final void a(a aVar) {
        this.f23575g = aVar;
    }

    public final void a(String str, String str2, int i10) {
        this.f23570b.a(commonMessage(this.f23577i, str, str2, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        if (i10 <= 0) {
            n(str);
            return;
        }
        this.f23574f.sendMessageDelayed(this.f23574f.obtainMessage(1, str), i10 * 1000);
    }

    public final void a(String str, String str2, String str3, String str4) {
        this.f23570b.a(payingMessage(this.f23577i, str, str2, str3, str4, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("pay");
    }

    public final String b() {
        return this.f23572d;
    }

    public final void b(String str) {
        this.f23571c = str;
    }

    public final void b(String str, String str2) {
        String str3;
        com.unionpay.mobile.android.model.b bVar = this.f23576h;
        if (bVar.f23530f) {
            Context context = this.f23573e;
            String a10 = bVar.a();
            com.unionpay.mobile.android.model.b bVar2 = this.f23576h;
            str3 = bh.b(context, str, "android", a10, bVar2.f23531g, bVar2.f23528d);
        } else {
            str3 = bh.a(this.f23573e, str, "android", bVar.a(), this.f23576h.f23531g, str2);
        }
        this.f23570b.a(initMessage(this.f23577i, str3, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("secret", retrieveInitializeKey(this.f23577i));
        this.f23570b.a(hashMap);
        n("init");
    }

    public final long c() {
        return this.f23577i;
    }

    public final void c(String str) {
        this.f23572d = str;
    }

    public final void c(String str, String str2) {
        a(str, str2, 0);
    }

    public final d d() {
        return this.f23570b;
    }

    public final boolean d(String str) {
        setSessionKey(this.f23577i, str);
        return true;
    }

    public final Handler e() {
        return this.f23574f;
    }

    public final String e(String str) {
        return encryptMessage(this.f23577i, str);
    }

    public final String f() {
        return this.f23571c;
    }

    public final String f(String str) {
        return decryptResponse(this.f23577i, str);
    }

    public final String g(String str) {
        return rsaPrivateEncryptMessage(this.f23577i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        String c10 = this.f23570b.c();
        if (!TextUtils.isEmpty(c10)) {
            try {
                JSONObject jSONObject = new JSONObject(f(c10));
                String string = jSONObject.getString("cmd");
                String string2 = jSONObject.getString("reqtm");
                d dVar = this.f23570b;
                Context context = this.f23573e;
                dVar.a(context, string, this.f23576h.f23515b + string2 + f.c(this.f23573e));
            } catch (JSONException unused) {
                this.f23570b.a(this.f23573e, "uppay", "1234567890");
            }
        }
    }

    public final String h(String str) {
        return rsaEncryptMessageForHFT(this.f23577i, str);
    }

    public final void h() {
        this.f23573e = null;
        this.f23574f.removeCallbacksAndMessages(null);
        this.f23574f = null;
        this.f23570b = null;
        this.f23576h = null;
        this.f23569a = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i10 = message.what;
        String str = null;
        if (i10 == 0) {
            b bVar = (b) message.obj;
            if (bVar.f23578a == 0) {
                str = decryptResponse(this.f23577i, bVar.f23579b);
                k.a("uppay", "resp is:" + str);
            }
            a aVar2 = this.f23575g;
            if (aVar2 != null) {
                aVar2.a(bVar.f23578a, str);
                k.b("uppayEx", "UPPayEngine:" + this.f23575g.toString());
            }
        } else if (i10 == 1) {
            n((String) message.obj);
        } else if (i10 == 2 && (aVar = this.f23575g) != null) {
            aVar.a(message.arg1, null);
        }
        return true;
    }

    public final void i(String str) {
        this.f23570b.a(ruleMessage(this.f23577i, str, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("rule");
    }

    public native long initJNIEnv(Activity activity, int i10, int i11, boolean z10, String str, int i12, String str2);

    public final void j(String str) {
        this.f23570b.a(followRulesMessage(this.f23577i, str, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("followRule");
    }

    public final void k(String str) {
        this.f23570b.a(openupgradeMessage(this.f23577i, str, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("openupgrade");
    }

    public final void l(String str) {
        this.f23570b.a(unBoundMessage(this.f23577i, str, i()));
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("unbindcard");
    }

    public final void m(String str) {
        String userInfo = getUserInfo(this.f23577i, str, i());
        k.a("uppay", "actEntrust msg:" + userInfo);
        this.f23570b.a(userInfo);
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sid", this.f23571c);
        this.f23570b.a(hashMap);
        n("getuserinfo");
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> d10;
        String str;
        int i10;
        try {
            com.unionpay.mobile.android.model.b bVar = this.f23576h;
            if (bVar == null || (i10 = bVar.aO) <= 0 || i10 > 5) {
                d10 = this.f23570b.d();
                str = "20131120";
            } else {
                d10 = this.f23570b.d();
                str = "20150423";
            }
            d10.put("magic_number", str);
            g();
            if (this.f23569a == null) {
                this.f23569a = new c(this.f23570b, this.f23573e);
            }
            b bVar2 = new b(this.f23569a.a(), this.f23569a.b());
            Handler handler = this.f23574f;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 0;
                obtainMessage.obj = bVar2;
                this.f23574f.sendMessage(obtainMessage);
            }
        } catch (NullPointerException | Exception unused) {
        }
    }
}
