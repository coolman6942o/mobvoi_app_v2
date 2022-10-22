package com.huawei.hianalytics.mn.no.rs;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.b.pq;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
/* loaded from: classes.dex */
public abstract class no {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class mn extends Exception {
        mn(String str) {
            super(str);
        }
    }

    public static op mn(String str, byte[] bArr, Map<String, String> map) {
        return mn(str, bArr, map, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static op mn(String str, byte[] bArr, Map<String, String> map, String str2) {
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        if (TextUtils.isEmpty(str)) {
            return new op(-100, "");
        }
        int i10 = -102;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                str = mn((String) str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (str == 0) {
                        op opVar = new op(-101, "");
                        pq.mn((Closeable) null);
                        pq.mn((Closeable) null);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar;
                    }
                    map = str.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(map);
                    } catch (mn unused) {
                    } catch (SecurityException unused2) {
                    } catch (ConnectException unused3) {
                    } catch (UnknownHostException unused4) {
                    } catch (SSLHandshakeException unused5) {
                    } catch (SSLPeerUnverifiedException unused6) {
                    } catch (IOException unused7) {
                    }
                    try {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        i10 = str.getResponseCode();
                        op opVar2 = new op(i10, no(str));
                        pq.mn((Closeable) bufferedOutputStream);
                        pq.mn((Closeable) map);
                        pq.mn((HttpURLConnection) str);
                        return opVar2;
                    } catch (mn unused8) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
                        op opVar3 = new op(-101, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar3;
                    } catch (SecurityException unused9) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                        op opVar4 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar4;
                    } catch (ConnectException unused10) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "Network is unreachable or Connection refused");
                        op opVar5 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar5;
                    } catch (UnknownHostException unused11) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "No address associated with hostname or No network");
                        op opVar6 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar6;
                    } catch (SSLHandshakeException unused12) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "Chain validation failed,Certificate expired");
                        op opVar7 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar7;
                    } catch (SSLPeerUnverifiedException unused13) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "Certificate has not been verified,Request is restricted!");
                        op opVar8 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar8;
                    } catch (IOException unused14) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "events PostRequest(byte[]): IOException occurred.");
                        op opVar9 = new op(i10, "");
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        return opVar9;
                    } catch (Throwable th3) {
                        th2 = th3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        pq.mn((Closeable) bufferedOutputStream2);
                        pq.mn((Closeable) map);
                        if (str != 0) {
                            pq.mn((HttpURLConnection) str);
                        }
                        throw th2;
                    }
                } catch (mn unused15) {
                    map = 0;
                } catch (SecurityException unused16) {
                    map = 0;
                } catch (ConnectException unused17) {
                    map = 0;
                } catch (UnknownHostException unused18) {
                    map = 0;
                } catch (SSLHandshakeException unused19) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused20) {
                    map = 0;
                } catch (IOException unused21) {
                    map = 0;
                } catch (Throwable th4) {
                    th2 = th4;
                    map = 0;
                }
            } catch (Throwable th5) {
                th2 = th5;
            }
        } catch (mn unused22) {
            str = 0;
            map = 0;
        } catch (SecurityException unused23) {
            str = 0;
            map = 0;
        } catch (ConnectException unused24) {
            str = 0;
            map = 0;
        } catch (UnknownHostException unused25) {
            str = 0;
            map = 0;
        } catch (SSLHandshakeException unused26) {
            str = 0;
            map = 0;
        } catch (SSLPeerUnverifiedException unused27) {
            str = 0;
            map = 0;
        } catch (IOException unused28) {
            str = 0;
            map = 0;
        } catch (Throwable th6) {
            th2 = th6;
            str = 0;
            map = 0;
        }
    }

    private static HttpURLConnection mn(String str, int i10, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.huawei.hianalytics.mn.no.qr.mn.pq("HttpClient", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        mn(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i10));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void mn(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SocketFactory mn2 = com.huawei.hianalytics.mn.no.rs.mn.mn(com.huawei.hianalytics.mn.mn.no.a());
            if (mn2 == null || !(mn2 instanceof SSLSocketFactory)) {
                throw new mn("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) mn2);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }

    /* JADX WARN: Finally extract failed */
    private static String no(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                String mn2 = pq.mn(inputStream);
                pq.mn((Closeable) inputStream);
                return mn2;
            } catch (IOException unused) {
                com.huawei.hianalytics.mn.no.qr.mn.op("HttpClient", "When Response Content From Connection inputStream operation exception! ".concat(String.valueOf(httpURLConnection.getResponseCode())));
                pq.mn((Closeable) inputStream);
                return "";
            }
        } catch (Throwable th2) {
            pq.mn((Closeable) inputStream);
            throw th2;
        }
    }
}
