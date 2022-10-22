package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class q implements Callable<u> {

    /* renamed from: e  reason: collision with root package name */
    public static final HttpRequestRetryHandler f6777e = new ad();

    /* renamed from: a  reason: collision with root package name */
    public l f6778a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6779b;

    /* renamed from: c  reason: collision with root package name */
    public o f6780c;

    /* renamed from: d  reason: collision with root package name */
    public String f6781d;

    /* renamed from: f  reason: collision with root package name */
    public HttpUriRequest f6782f;

    /* renamed from: i  reason: collision with root package name */
    public CookieManager f6785i;

    /* renamed from: j  reason: collision with root package name */
    public AbstractHttpEntity f6786j;

    /* renamed from: k  reason: collision with root package name */
    public HttpHost f6787k;

    /* renamed from: l  reason: collision with root package name */
    public URL f6788l;

    /* renamed from: q  reason: collision with root package name */
    public String f6793q;

    /* renamed from: g  reason: collision with root package name */
    public HttpContext f6783g = new BasicHttpContext();

    /* renamed from: h  reason: collision with root package name */
    public CookieStore f6784h = new BasicCookieStore();

    /* renamed from: m  reason: collision with root package name */
    public int f6789m = 0;

    /* renamed from: n  reason: collision with root package name */
    public boolean f6790n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6791o = false;

    /* renamed from: p  reason: collision with root package name */
    public String f6792p = null;

    public q(l lVar, o oVar) {
        this.f6778a = lVar;
        this.f6779b = lVar.f6755a;
        this.f6780c = oVar;
    }

    public static long a(String[] strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if ("max-age".equalsIgnoreCase(strArr[i10])) {
                int i11 = i10 + 1;
                if (strArr[i11] != null) {
                    try {
                        return Long.parseLong(strArr[i11]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        Header[] allHeaders;
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private u a(HttpResponse httpResponse, int i10, String str) {
        Throwable th2;
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream = null;
        String str3 = null;
        if (entity != null && httpResponse.getStatusLine().getStatusCode() == 200) {
            Thread.currentThread().getId();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    a(entity, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    this.f6791o = false;
                    this.f6778a.c(System.currentTimeMillis() - currentTimeMillis);
                    this.f6778a.a(byteArray.length);
                    p pVar = new p(a(httpResponse), i10, str, byteArray);
                    long b10 = b(httpResponse);
                    Header contentType = httpResponse.getEntity().getContentType();
                    if (contentType != null) {
                        HashMap<String, String> a10 = a(contentType.getValue());
                        str3 = a10.get("charset");
                        str2 = a10.get("Content-Type");
                    } else {
                        str2 = null;
                    }
                    pVar.b(str2);
                    pVar.a(str3);
                    pVar.a(System.currentTimeMillis());
                    pVar.b(b10);
                    try {
                        byteArrayOutputStream2.close();
                        return pVar;
                    } catch (IOException e10) {
                        throw new RuntimeException("ArrayOutputStream close error!", e10.getCause());
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e11) {
                            throw new RuntimeException("ArrayOutputStream close error!", e11.getCause());
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
        } else if (entity != null) {
            return null;
        } else {
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
    }

    public static HashMap<String, String> a(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a10 = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a10.read(bArr);
                    if (read == -1 || this.f6780c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.f6780c.f();
                }
                outputStream.flush();
            } catch (Exception e10) {
                e10.getCause();
                throw new IOException("HttpWorker Request Error!" + e10.getLocalizedMessage());
            }
        } finally {
            r.a(a10);
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a10 = this.f6780c.a();
        String str = this.f6781d;
        if (str != null) {
            a10 = str;
        }
        if (a10 != null) {
            return new URI(a10);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f6782f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.f6786j == null) {
            byte[] b10 = this.f6780c.b();
            String b11 = this.f6780c.b("gzip");
            if (b10 != null) {
                if (TextUtils.equals(b11, "true")) {
                    this.f6786j = b.a(b10);
                } else {
                    this.f6786j = new ByteArrayEntity(b10);
                }
                this.f6786j.setContentType(this.f6780c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.f6786j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f6782f = httpPost;
        } else {
            this.f6782f = new HttpGet(b());
        }
        return this.f6782f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, ConnectTimeoutException -> 0x031a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:50:0x00f3, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:97:0x022f, B:98:0x023a), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0113 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, ConnectTimeoutException -> 0x031a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:50:0x00f3, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:97:0x022f, B:98:0x023a), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0146 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, ConnectTimeoutException -> 0x031a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:50:0x00f3, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:97:0x022f, B:98:0x023a), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0153 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, ConnectTimeoutException -> 0x031a, IOException -> 0x0277, HttpHostConnectException -> 0x02b9, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, Exception -> 0x023b, ConnectionPoolTimeoutException -> 0x033a, URISyntaxException -> 0x03ba, blocks: (B:4:0x0006, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x006c, B:30:0x0081, B:32:0x00ad, B:34:0x00bc, B:36:0x00c2, B:38:0x00cc, B:41:0x00d5, B:43:0x00e1, B:47:0x00eb, B:50:0x00f3, B:51:0x010b, B:53:0x0113, B:54:0x0120, B:56:0x0146, B:57:0x014d, B:59:0x0153, B:60:0x0157, B:62:0x015d, B:64:0x0169, B:68:0x0198, B:69:0x01b4, B:77:0x01d1, B:78:0x01ea, B:79:0x01eb, B:81:0x01f3, B:83:0x01f9, B:87:0x0205, B:89:0x0209, B:91:0x0219, B:93:0x0221, B:95:0x022b, B:97:0x022f, B:98:0x023a), top: B:183:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c8  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u call() {
        boolean z10;
        HttpHost httpHost;
        HttpHost httpHost2;
        List<Cookie> cookies;
        int statusCode;
        u a10;
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.f6779b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z11 = true;
                if (allNetworkInfo != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            z10 = true;
                            break;
                        }
                    }
                }
                z10 = false;
                if (z10) {
                    ArrayList<Header> d10 = this.f6780c.d();
                    if (d10 != null && !d10.isEmpty()) {
                        Iterator<Header> it = d10.iterator();
                        while (it.hasNext()) {
                            c().addHeader(it.next());
                        }
                    }
                    b.a((HttpRequest) c());
                    b.b((HttpRequest) c());
                    c().addHeader("cookie", i().getCookie(this.f6780c.a()));
                    this.f6783g.setAttribute("http.cookie-store", this.f6784h);
                    this.f6778a.a().a(f6777e);
                    long currentTimeMillis = System.currentTimeMillis();
                    f();
                    this.f6782f.getURI().toString();
                    HttpParams params = this.f6778a.a().getParams();
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6779b.getSystemService("connectivity")).getActiveNetworkInfo();
                    HttpHost httpHost3 = null;
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        String defaultHost = Proxy.getDefaultHost();
                        int defaultPort = Proxy.getDefaultPort();
                        if (defaultHost != null) {
                            httpHost = new HttpHost(defaultHost, defaultPort);
                            if (httpHost != null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                                httpHost3 = httpHost;
                            }
                            params.setParameter("http.route.default-proxy", httpHost3);
                            httpHost2 = this.f6787k;
                            if (httpHost2 != null) {
                                URL h10 = h();
                                HttpHost httpHost4 = new HttpHost(h10.getHost(), g(), h10.getProtocol());
                                this.f6787k = httpHost4;
                                httpHost2 = httpHost4;
                            }
                            if (g() == 80) {
                                httpHost2 = new HttpHost(h().getHost());
                            }
                            HttpResponse execute = this.f6778a.a().execute(httpHost2, (HttpRequest) this.f6782f, this.f6783g);
                            this.f6778a.b(System.currentTimeMillis() - currentTimeMillis);
                            cookies = this.f6784h.getCookies();
                            if (this.f6780c.e()) {
                                i().removeAllCookie();
                            }
                            if (!cookies.isEmpty()) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getDomain() != null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(cookie.getName());
                                        sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                                        sb2.append(cookie.getValue());
                                        sb2.append("; domain=");
                                        sb2.append(cookie.getDomain());
                                        sb2.append(cookie.isSecure() ? "; Secure" : "");
                                        i().setCookie(this.f6780c.a(), sb2.toString());
                                        CookieSyncManager.getInstance().sync();
                                    }
                                }
                            }
                            statusCode = execute.getStatusLine().getStatusCode();
                            String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                            if (statusCode != 200) {
                                if (statusCode != 304) {
                                    z11 = false;
                                }
                                if (!z11) {
                                    throw new HttpException(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                }
                            }
                            a10 = a(execute, statusCode, reasonPhrase);
                            if (((a10 != null || a10.b() == null) ? -1L : a10.b().length) == -1 && (a10 instanceof p)) {
                                try {
                                    Long.parseLong(((p) a10).a().getHead("Content-Length"));
                                } catch (Exception unused) {
                                }
                            }
                            if (this.f6780c.a() != null && !TextUtils.isEmpty(f())) {
                                f();
                            }
                            return a10;
                        }
                    }
                    httpHost = null;
                    if (httpHost != null) {
                    }
                    httpHost3 = httpHost;
                    params.setParameter("http.route.default-proxy", httpHost3);
                    httpHost2 = this.f6787k;
                    if (httpHost2 != null) {
                    }
                    if (g() == 80) {
                    }
                    HttpResponse execute2 = this.f6778a.a().execute(httpHost2, (HttpRequest) this.f6782f, this.f6783g);
                    this.f6778a.b(System.currentTimeMillis() - currentTimeMillis);
                    cookies = this.f6784h.getCookies();
                    if (this.f6780c.e()) {
                    }
                    if (!cookies.isEmpty()) {
                    }
                    statusCode = execute2.getStatusLine().getStatusCode();
                    String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                    if (statusCode != 200) {
                    }
                    a10 = a(execute2, statusCode, reasonPhrase2);
                    if (((a10 != null || a10.b() == null) ? -1L : a10.b().length) == -1) {
                        Long.parseLong(((p) a10).a().getHead("Content-Length"));
                    }
                    if (this.f6780c.a() != null) {
                        f();
                    }
                    return a10;
                }
                throw new HttpException(1, "The network is not available");
            } catch (HttpException e10) {
                e();
                if (this.f6780c.f() != null) {
                    e10.getCode();
                    e10.getMsg();
                }
                e10.toString();
                throw e10;
            } catch (NullPointerException e11) {
                e();
                int i10 = this.f6789m;
                if (i10 <= 0) {
                    this.f6789m = i10 + 1;
                } else {
                    e11.toString();
                    throw new HttpException(0, String.valueOf(e11));
                }
            } catch (SocketTimeoutException e12) {
                e();
                if (this.f6780c.f() != null) {
                    e12.toString();
                }
                e12.toString();
                throw new HttpException(4, String.valueOf(e12));
            } catch (UnknownHostException e13) {
                e();
                if (this.f6780c.f() != null) {
                    e13.toString();
                }
                e13.toString();
                throw new HttpException(9, String.valueOf(e13));
            } catch (SSLHandshakeException e14) {
                e();
                if (this.f6780c.f() != null) {
                    e14.toString();
                }
                e14.toString();
                throw new HttpException(2, String.valueOf(e14));
            } catch (ConnectTimeoutException e15) {
                e();
                if (this.f6780c.f() != null) {
                    e15.toString();
                }
                e15.toString();
                throw new HttpException(3, String.valueOf(e15));
            } catch (IOException e16) {
                e();
                if (this.f6780c.f() != null) {
                    e16.toString();
                }
                e16.toString();
                throw new HttpException(6, String.valueOf(e16));
            } catch (HttpHostConnectException e17) {
                e();
                if (this.f6780c.f() != null) {
                    e17.toString();
                }
                throw new HttpException(8, String.valueOf(e17));
            } catch (SSLPeerUnverifiedException e18) {
                e();
                if (this.f6780c.f() != null) {
                    e18.toString();
                }
                e18.toString();
                throw new HttpException(2, String.valueOf(e18));
            } catch (SSLException e19) {
                e();
                if (this.f6780c.f() != null) {
                    e19.toString();
                }
                e19.toString();
                throw new HttpException(6, String.valueOf(e19));
            } catch (NoHttpResponseException e20) {
                e();
                if (this.f6780c.f() != null) {
                    e20.toString();
                }
                e20.toString();
                throw new HttpException(5, String.valueOf(e20));
            } catch (Exception e21) {
                e();
                if (this.f6780c.f() != null) {
                    e21.toString();
                }
                throw new HttpException(0, String.valueOf(e21));
            } catch (ConnectionPoolTimeoutException e22) {
                e();
                if (this.f6780c.f() != null) {
                    e22.toString();
                }
                e22.toString();
                throw new HttpException(3, String.valueOf(e22));
            } catch (URISyntaxException e23) {
                throw new RuntimeException("Url parser error!", e23.getCause());
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f6782f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f6793q)) {
            return this.f6793q;
        }
        String b10 = this.f6780c.b("operationType");
        this.f6793q = b10;
        return b10;
    }

    private int g() {
        URL h10 = h();
        return h10.getPort() == -1 ? h10.getDefaultPort() : h10.getPort();
    }

    private URL h() {
        URL url = this.f6788l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.f6780c.a());
        this.f6788l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.f6785i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.f6785i = cookieManager2;
        return cookieManager2;
    }

    public final o a() {
        return this.f6780c;
    }
}
