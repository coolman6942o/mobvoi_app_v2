package com.huawei.hms.framework.network.grs.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.d.b.c;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public class a {
    public static HttpsURLConnection a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.d.b.a.a(context));
                httpsURLConnection.setHostnameVerifier(c.f13949b);
            } catch (IllegalArgumentException unused) {
                Logger.w("URLConnectionHelper", "init https ssl socket failed.");
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            String b10 = com.huawei.hms.framework.network.grs.d.a.b(context, "NetworkKit-grs", str2);
            Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + b10);
            httpsURLConnection.setRequestProperty("User-Agent", b10);
            return httpsURLConnection;
        }
        Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }
}
