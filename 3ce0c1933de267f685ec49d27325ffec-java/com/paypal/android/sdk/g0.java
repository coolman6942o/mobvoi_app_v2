package com.paypal.android.sdk;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class g0 implements b0 {

    /* renamed from: e  reason: collision with root package name */
    private static int f21303e = 60000;

    /* renamed from: f  reason: collision with root package name */
    private static int f21304f = 60000;

    /* renamed from: a  reason: collision with root package name */
    private final k0 f21305a = new k0(y1.l());

    /* renamed from: b  reason: collision with root package name */
    private byte[] f21306b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f21307c;

    /* renamed from: d  reason: collision with root package name */
    private Map f21308d;

    @Override // com.paypal.android.sdk.b0
    public final void a(Map map) {
        this.f21308d = map;
    }

    @Override // com.paypal.android.sdk.b0
    public final byte[] a() {
        return this.f21306b;
    }

    @Override // com.paypal.android.sdk.b0
    public final int b(byte[] bArr) {
        Throwable th2;
        OutputStream outputStream;
        HttpsURLConnection httpsURLConnection;
        BufferedInputStream bufferedInputStream = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(this.f21307c.toString()).openConnection();
            try {
                httpsURLConnection.setReadTimeout(f21304f);
                httpsURLConnection.setConnectTimeout(f21303e);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setSSLSocketFactory(this.f21305a);
                for (Map.Entry entry : this.f21308d.entrySet()) {
                    httpsURLConnection.setRequestProperty(entry.getKey().toString(), entry.getValue().toString());
                }
                httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                outputStream = httpsURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr);
                    outputStream.flush();
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpsURLConnection.getInputStream());
                        try {
                            byte[] bArr2 = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (true) {
                                int read = bufferedInputStream2.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            this.f21306b = byteArrayOutputStream.toByteArray();
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            bufferedInputStream = bufferedInputStream2;
                            y1.f(bufferedInputStream);
                            y1.f(outputStream);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th2;
                        }
                    } else {
                        this.f21306b = new byte[0];
                    }
                    y1.f(bufferedInputStream);
                    y1.f(outputStream);
                    httpsURLConnection.disconnect();
                    return responseCode;
                } catch (Throwable th4) {
                    th2 = th4;
                }
            } catch (Throwable th5) {
                th2 = th5;
                outputStream = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    @Override // com.paypal.android.sdk.b0
    public final void c(Uri uri) {
        this.f21307c = uri;
    }
}
