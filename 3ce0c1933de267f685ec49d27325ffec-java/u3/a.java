package u3;

import a4.d;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.mobvoi.wear.common.base.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final CookieManager f35283a = new CookieManager();

    /* renamed from: u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0511a {

        /* renamed from: a  reason: collision with root package name */
        public final String f35284a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f35285b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, String> f35286c;

        public C0511a(String str, Map<String, String> map, byte[] bArr) {
            this.f35284a = str;
            this.f35285b = bArr;
            this.f35286c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s headers=%s>", this.f35284a, this.f35286c);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, List<String>> f35287a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f35288b;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f35287a = map;
            this.f35288b = bArr;
        }
    }

    public static NetworkInfo a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b b(Context context, C0511a aVar) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream;
        Throwable th3;
        if (context == null) {
            return null;
        }
        try {
            d.h("mspl", "conn config: " + aVar);
            URL url = new URL(aVar.f35284a);
            Proxy e10 = e(context);
            d.h("mspl", "conn proxy: " + e10);
            if (e10 != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(e10);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                System.setProperty("http.keepAlive", "false");
                if (httpURLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                }
                CookieManager cookieManager = f35283a;
                if (cookieManager.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", cookieManager.getCookieStore().getCookies()));
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "msp");
                byte[] bArr = aVar.f35285b;
                if (bArr == null || bArr.length <= 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream;binary/octet-stream");
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Keep-Alive", "timeout=180, max=100");
                }
                Map<String, String> map = aVar.f35286c;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection.setDoInput(true);
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    httpURLConnection.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(aVar.f35285b);
                        bufferedOutputStream.flush();
                    } catch (Throwable th4) {
                        th2 = th4;
                        bufferedInputStream = null;
                        try {
                            d.d(th2);
                            return null;
                        } finally {
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                } else {
                    bufferedOutputStream = null;
                }
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] c10 = c(bufferedInputStream);
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    String join = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get("Set-Cookie");
                    if (list != null) {
                        for (String str : list) {
                            List<HttpCookie> parse = HttpCookie.parse(str);
                            if (parse != null && !parse.isEmpty()) {
                                f35283a.getCookieStore().add(url.toURI(), parse.get(0));
                            }
                        }
                    }
                    b bVar = new b(headerFields, join, c10);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused5) {
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    return bVar;
                } catch (Throwable th5) {
                    th2 = th5;
                    d.d(th2);
                    return null;
                }
            } catch (Throwable th6) {
                th3 = th6;
                th2 = th3;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                d.d(th2);
                return null;
            }
        } catch (Throwable th7) {
            th3 = th7;
            httpURLConnection = null;
        }
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String d(Context context) {
        try {
            NetworkInfo a10 = a(context);
            if (a10 != null && a10.isAvailable()) {
                return a10.getType() == 1 ? "wifi" : a10.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE;
    }

    public static Proxy e(Context context) {
        String d10 = d(context);
        if (d10 != null && !d10.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
