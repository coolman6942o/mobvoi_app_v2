package com.unionpay.mobile.android.net;

import android.content.Context;
import java.io.IOException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private SSLContext f23552a = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f23553b;

    public a(Context context) {
        this.f23553b = context;
    }

    private static SSLContext a(Context context) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new b(context)}, null);
            return sSLContext;
        } catch (Exception e10) {
            throw new IOException(e10.getMessage());
        }
    }

    public final SSLContext a() throws IOException {
        if (this.f23552a == null) {
            this.f23552a = a(this.f23553b);
        }
        return this.f23552a;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(a.class);
    }

    public int hashCode() {
        return a.class.hashCode();
    }
}
