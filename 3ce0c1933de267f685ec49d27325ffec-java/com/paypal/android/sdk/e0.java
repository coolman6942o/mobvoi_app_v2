package com.paypal.android.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e0 extends h0 {

    /* renamed from: a  reason: collision with root package name */
    private String f21172a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f21173b;

    /* renamed from: c  reason: collision with root package name */
    private Map f21174c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Handler f21175d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21176e;

    public e0(String str, HashMap hashMap, Handler handler, boolean z10) {
        this.f21172a = str;
        this.f21173b = hashMap;
        this.f21175d = handler;
        this.f21176e = z10;
    }

    @Override // com.paypal.android.sdk.h0, java.lang.Runnable
    public final void run() {
        Handler handler;
        Message obtain;
        Handler handler2 = this.f21175d;
        if (handler2 != null) {
            try {
                try {
                    handler2.sendMessage(Message.obtain(handler2, 0, this.f21172a));
                    if (!this.f21176e) {
                        this.f21174c.put("CLIENT-AUTH", "No cert");
                    }
                    this.f21174c.put("X-PAYPAL-RESPONSE-DATA-FORMAT", "NV");
                    this.f21174c.put("X-PAYPAL-REQUEST-DATA-FORMAT", "NV");
                    this.f21174c.put("X-PAYPAL-SERVICE-VERSION", "1.0.0");
                    if (this.f21176e) {
                        b0 a10 = t.f21949w.a();
                        a10.c(Uri.parse(this.f21172a));
                        a10.a(this.f21174c);
                        HashMap hashMap = this.f21173b;
                        StringBuilder sb2 = new StringBuilder();
                        boolean z10 = true;
                        for (Map.Entry entry : hashMap.entrySet()) {
                            if (z10) {
                                z10 = false;
                            } else {
                                sb2.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            sb2.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb2.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        }
                        int b10 = a10.b(sb2.toString().getBytes("UTF-8"));
                        if (b10 == 200) {
                            String str = new String(a10.a(), "UTF-8");
                            handler = this.f21175d;
                            obtain = Message.obtain(handler, 2, str);
                        } else {
                            throw new Exception("Network Connection Error with wrong http code: " + b10);
                        }
                    } else {
                        handler = this.f21175d;
                        obtain = Message.obtain(handler, 2, "not supported");
                    }
                    handler.sendMessage(obtain);
                } catch (Exception e10) {
                    Handler handler3 = this.f21175d;
                    handler3.sendMessage(Message.obtain(handler3, 1, e10));
                }
            } finally {
                i0.a().d(this);
            }
        }
    }
}
