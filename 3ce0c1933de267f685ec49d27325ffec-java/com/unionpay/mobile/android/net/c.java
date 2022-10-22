package com.unionpay.mobile.android.net;

import android.content.Context;
import com.unionpay.mobile.android.utils.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f23557a = null;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f23558b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f23559c = null;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f23560d = null;

    /* renamed from: e  reason: collision with root package name */
    private d f23561e;

    /* renamed from: f  reason: collision with root package name */
    private Context f23562f;

    public c(d dVar, Context context) {
        this.f23561e = null;
        this.f23561e = dVar;
        this.f23562f = context;
    }

    public final int a() {
        HttpsURLConnection httpsURLConnection;
        k.a("uppay", "HttpConn.connect() +++");
        d dVar = this.f23561e;
        int i10 = 1;
        if (dVar == null) {
            k.c("uppay", "params==null!!!");
            return 1;
        }
        try {
            URL a10 = dVar.a();
            if ("https".equals(a10.getProtocol().toLowerCase())) {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) a10.openConnection();
                httpsURLConnection2.setSSLSocketFactory(new a(this.f23562f).a().getSocketFactory());
                httpsURLConnection = httpsURLConnection2;
            } else {
                httpsURLConnection = (HttpURLConnection) a10.openConnection();
            }
            httpsURLConnection.setRequestMethod(this.f23561e.b());
            httpsURLConnection.setReadTimeout(60000);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setInstanceFollowRedirects(true);
            httpsURLConnection.setUseCaches(false);
            HashMap<String, String> d10 = this.f23561e.d();
            if (d10 != null) {
                for (String str : d10.keySet()) {
                    httpsURLConnection.setRequestProperty(str, d10.get(str));
                }
            }
            String b10 = this.f23561e.b();
            char c10 = 65535;
            int hashCode = b10.hashCode();
            if (hashCode != 70454) {
                if (hashCode == 2461856 && b10.equals("POST")) {
                    c10 = 1;
                }
            } else if (b10.equals("GET")) {
                c10 = 0;
            }
            if (c10 == 1) {
                httpsURLConnection.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(this.f23561e.c());
                outputStreamWriter.flush();
                outputStreamWriter.close();
            }
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                this.f23560d = inputStream;
                if (inputStream != null) {
                    this.f23559c = e.a(inputStream, "UTF-8");
                    i10 = 0;
                }
            } else if (httpsURLConnection.getResponseCode() == 401) {
                i10 = 8;
            } else {
                k.c("uppay", "http status code:" + httpsURLConnection.getResponseCode());
            }
        } catch (SSLHandshakeException e10) {
            e10.printStackTrace();
            i10 = 4;
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (IllegalStateException e12) {
            e12.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        k.a("uppay", "HttpConn.connect() ---");
        return i10;
    }

    public final String b() {
        return this.f23559c;
    }
}
