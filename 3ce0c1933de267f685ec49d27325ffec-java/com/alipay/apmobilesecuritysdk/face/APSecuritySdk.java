package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class APSecuritySdk {

    /* renamed from: a  reason: collision with root package name */
    public static APSecuritySdk f6840a;

    /* renamed from: c  reason: collision with root package name */
    public static Object f6841c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Context f6842b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: classes.dex */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.f6842b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f6840a == null) {
            synchronized (f6841c) {
                if (f6840a == null) {
                    f6840a = new APSecuritySdk(context);
                }
            }
        }
        return f6840a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a10 = a.a(this.f6842b, "");
        if (c4.a.d(a10)) {
            initToken(0, new HashMap(), null);
        }
        return a10;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.201910161639";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f6842b, "");
            tokenResult.clientKey = h.f(this.f6842b);
            tokenResult.apdid = a.a(this.f6842b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f6842b);
            if (c4.a.d(tokenResult.apdid) || c4.a.d(tokenResult.apdidToken) || c4.a.d(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i10, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i10);
        String b10 = h.b(this.f6842b);
        String c10 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (c4.a.g(b10) && !c4.a.e(b10, c10)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f6842b);
            d.a(this.f6842b);
            g.a(this.f6842b);
            i.h();
        }
        if (!c4.a.e(b10, c10)) {
            h.c(this.f6842b, c10);
        }
        String c11 = c4.a.c(map, "utdid", "");
        String c12 = c4.a.c(map, "tid", "");
        String c13 = c4.a.c(map, "userId", "");
        if (c4.a.d(c11)) {
            c11 = UtdidWrapper.getUtdid(this.f6842b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("utdid", c11);
        hashMap.put("tid", c12);
        hashMap.put("userId", c13);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f6842b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
