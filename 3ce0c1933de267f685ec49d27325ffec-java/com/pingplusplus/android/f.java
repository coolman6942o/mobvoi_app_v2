package com.pingplusplus.android;

import android.content.Context;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.api.OpenApiFactory;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static f f22094b;

    /* renamed from: a  reason: collision with root package name */
    private IOpenApi f22095a;

    private f(Context context, String str) {
        this.f22095a = OpenApiFactory.getInstance(context.getApplicationContext(), str);
        if (context instanceof PaymentActivity) {
            PaymentActivity paymentActivity = (PaymentActivity) context;
        }
    }

    public static f a(Context context, String str) {
        if (f22094b == null) {
            synchronized (f.class) {
                if (f22094b == null) {
                    f22094b = new f(context, str);
                }
            }
        }
        return f22094b;
    }

    public IOpenApi b() {
        return this.f22095a;
    }

    public void c() {
        f22094b = null;
        this.f22095a = null;
    }
}
