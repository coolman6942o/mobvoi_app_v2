package com.bjleisen.iface.sdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import h9.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
/* compiled from: AsyncHttpClient.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7614a = 8192;

    /* renamed from: b  reason: collision with root package name */
    public static final int f7615b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7616c = 1500;

    /* renamed from: d  reason: collision with root package name */
    private static final String f7617d = "AsyncHttpClient";

    /* renamed from: e  reason: collision with root package name */
    private static final int f7618e = 10;

    /* renamed from: f  reason: collision with root package name */
    private int f7619f;

    /* renamed from: g  reason: collision with root package name */
    private final DefaultHttpClient f7620g;

    /* renamed from: h  reason: collision with root package name */
    private final HttpContext f7621h;

    /* renamed from: i  reason: collision with root package name */
    private ExecutorService f7622i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<Context, List<f>> f7623j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, String> f7624k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7625l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7626m;

    public a() {
        this(80, 443, (byte) 0);
        this.f7626m = true;
    }

    private f b(Context context, String str, g gVar, h hVar) {
        return a(context, str, a(gVar, hVar), null, hVar);
    }

    private CookieStore c() {
        return this.f7620g.getCookieStore();
    }

    private static SchemeRegistry a(int i10, int i11) {
        if (i10 <= 0) {
            i10 = 80;
        }
        if (i11 <= 0) {
            i11 = 443;
        }
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i10));
        schemeRegistry.register(new Scheme("https", socketFactory, i11));
        return schemeRegistry;
    }

    private void b() {
        for (List<f> list : this.f7623j.values()) {
            if (list != null) {
                for (f fVar : list) {
                    fVar.a();
                }
            }
        }
        this.f7623j.clear();
    }

    private a(int i10) {
        this(i10, 443, (byte) 0);
    }

    private a(int i10, int i11) {
        this(i10, i11, (byte) 0);
    }

    private a(SchemeRegistry schemeRegistry) {
        this.f7619f = 10;
        this.f7625l = false;
        this.f7626m = false;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, LeisenIfaceConfig.TIME_OUT);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f7619f));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        String str = TextUtils.isEmpty(null) ? "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1" : null;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = Build.VERSION.RELEASE;
        if (str2.length() > 0) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str3 = Build.MODEL;
            if (str3.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str3);
            }
        }
        String str4 = Build.ID;
        if (str4.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str4);
        }
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format(str, stringBuffer, "Mobile "));
        HttpConnectionParams.setSoTimeout(basicHttpParams, LeisenIfaceConfig.TIME_OUT);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, LeisenIfaceConfig.TIME_OUT);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f7622i = Executors.newCachedThreadPool();
        this.f7623j = new WeakHashMap();
        this.f7624k = new HashMap();
        this.f7621h = new SyncBasicHttpContext(new BasicHttpContext());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f7620g = defaultHttpClient;
        defaultHttpClient.setHttpRequestRetryHandler(new i());
    }

    private static ExecutorService a() {
        return Executors.newCachedThreadPool();
    }

    private static ClientConnectionManager a(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    private f a(Context context, String str, g gVar, h hVar) {
        String a10;
        DefaultHttpClient defaultHttpClient = this.f7620g;
        HttpContext httpContext = this.f7621h;
        if (this.f7625l) {
            str = str.replace(" ", "%20");
        }
        if (!(gVar == null || (a10 = gVar.a()) == null)) {
            String str2 = "?";
            if (!str2.equals(a10)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (str.contains(str2)) {
                    str2 = ContainerUtils.FIELD_DELIMITER;
                }
                sb2.append(str2);
                str = sb2.toString() + a10;
            }
        }
        return a(defaultHttpClient, httpContext, new HttpGet(str), null, hVar, context);
    }

    public final f a(Context context, String str, HttpEntity httpEntity, String str2, h hVar) {
        DefaultHttpClient defaultHttpClient = this.f7620g;
        HttpContext httpContext = this.f7621h;
        HttpPost httpPost = new HttpPost(URI.create(str).normalize());
        if (httpEntity != null) {
            httpPost.setEntity(httpEntity);
        }
        return a(defaultHttpClient, httpContext, httpPost, str2, hVar, context);
    }

    private static HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private static HttpEntity a(g gVar, h hVar) {
        if (gVar == null) {
            return null;
        }
        try {
            return gVar.b();
        } catch (Throwable th2) {
            if (hVar != null) {
                hVar.a(0, null, null, th2);
                return null;
            }
            b.g(f7617d, th2.getMessage());
            return null;
        }
    }

    private f a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, h hVar, Context context) {
        if (hVar != null) {
            if (str != null) {
                httpUriRequest.setHeader("Content-Type", str);
            }
            hVar.a(this.f7626m);
            hVar.a(httpUriRequest.getAllHeaders());
            hVar.a(httpUriRequest.getURI());
            c cVar = new c(defaultHttpClient, httpContext, httpUriRequest, hVar);
            if (this.f7626m) {
                cVar.run();
            } else {
                this.f7622i.submit(cVar);
            }
            f fVar = new f(cVar);
            if (context != null) {
                List<f> list = this.f7623j.get(context);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f7623j.put(context, list);
                }
                list.add(fVar);
                Iterator<f> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().b()) {
                        it.remove();
                    }
                }
            }
            return fVar;
        }
        throw new IllegalArgumentException("ResponseHandler must not be null");
    }

    private static c a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, h hVar) {
        return new c(defaultHttpClient, httpContext, httpUriRequest, hVar);
    }

    private static String a(boolean z10, String str, g gVar) {
        String a10;
        if (z10) {
            str = str.replace(" ", "%20");
        }
        if (gVar == null || (a10 = gVar.a()) == null) {
            return str;
        }
        String str2 = "?";
        if (str2.equals(a10)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (str.contains(str2)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        sb2.append(str2);
        String sb3 = sb2.toString();
        return sb3 + a10;
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                b.n(f7617d, "Cannot close input stream:" + e10.getMessage());
            }
        }
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e10) {
                b.n(f7617d, "Cannot close output stream:" + e10.getMessage());
            }
        }
    }

    public final void a(Context context) {
        if (context != null) {
            b bVar = new b(this, context);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(bVar).start();
            } else {
                bVar.run();
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a(int i10, int i11, byte b10) {
        this(r0);
        i10 = i10 <= 0 ? 80 : i10;
        i11 = i11 <= 0 ? 443 : i11;
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i10));
        schemeRegistry.register(new Scheme("https", socketFactory, i11));
    }

    private void a(CookieStore cookieStore) {
        this.f7621h.setAttribute("http.cookie-store", cookieStore);
    }
}
