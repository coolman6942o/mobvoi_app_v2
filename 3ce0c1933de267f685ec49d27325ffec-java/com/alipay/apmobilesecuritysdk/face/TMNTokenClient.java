package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import c4.a;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TMNTokenClient {

    /* renamed from: a  reason: collision with root package name */
    public static TMNTokenClient f6847a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6848b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(String str, int i10);
    }

    public TMNTokenClient(Context context) {
        this.f6848b = null;
        if (context != null) {
            this.f6848b = context;
            return;
        }
        throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f6847a == null) {
            synchronized (TMNTokenClient.class) {
                if (f6847a == null) {
                    f6847a = new TMNTokenClient(context);
                }
            }
        }
        return f6847a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.d(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.d(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("utdid", UtdidWrapper.getUtdid(this.f6848b));
        hashMap.put("tid", "");
        hashMap.put("userId", "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int a10 = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.f6848b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    if (a10 == 0) {
                        initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.f6848b, str), 0);
                        return;
                    }
                    initResultListener2.onResult("", a10);
                }
            }
        });
    }
}
