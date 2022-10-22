package com.laser.tsm.sdk.http;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.laser.tsm.sdk.util.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
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
/* loaded from: classes2.dex */
public class AsyncHttpClient {
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static int DEFAULT_SOCKET_TIMEOUT = 30000;
    private static final String TAG = "AsyncHttpClient";
    private final Map<String, String> clientHeaderMap;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isEncodeUrl;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private ExecutorService threadPool;
    private int timeout;
    private boolean useSynchronousMode;

    public AsyncHttpClient(boolean z10) {
        this(false, 80, 443);
        this.useSynchronousMode = z10;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean z10, int i10, int i11) {
        if (i10 < 1) {
            i10 = 80;
        }
        if (i11 < 1) {
            i11 = 443;
        }
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i10));
        schemeRegistry.register(new Scheme("https", socketFactory, i11));
        return schemeRegistry;
    }

    public static HttpClient getNewHttpClient() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            SSLSocketFactoryEx sSLSocketFactoryEx = new SSLSocketFactoryEx(keyStore);
            sSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", sSLSocketFactoryEx, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception unused) {
            return new DefaultHttpClient();
        }
    }

    private String getUrlWithQueryString(boolean z10, String str, RequestParams requestParams) {
        String paramString;
        if (z10) {
            str = str.replace(" ", "%20");
        }
        if (requestParams == null || (paramString = requestParams.getParamString()) == null) {
            return str;
        }
        String str2 = "?";
        if (str2.equals(paramString)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (str.contains(str2)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        sb2.append(str2);
        String sb3 = sb2.toString();
        return sb3 + paramString;
    }

    private AsyncHttpRequest newAysncHttpRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, ResponseHandlerInterface responseHandlerInterface) {
        return new AsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, responseHandlerInterface);
    }

    private HttpEntity paramsToEntity(RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        if (requestParams == null) {
            return null;
        }
        try {
            return requestParams.getEntity(responseHandlerInterface);
        } catch (Throwable th2) {
            if (responseHandlerInterface != null) {
                responseHandlerInterface.sendFailureMessage(0, null, null, th2);
                return null;
            }
            LogUtil.e(TAG, "==>" + th2.getMessage());
            return null;
        }
    }

    public static void silentCloseInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                Log.w(TAG, "Cannot close input stream", e10);
            }
        }
    }

    public static void silentCloseOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e10) {
                Log.w(TAG, "Cannot close output stream", e10);
            }
        }
    }

    public void cancelAllRequests(boolean z10) {
        for (List<RequestHandle> list : this.requestMap.values()) {
            if (list != null) {
                for (RequestHandle requestHandle : list) {
                    requestHandle.cancel(z10);
                }
            }
        }
        this.requestMap.clear();
    }

    public void cancelRequests(final Context context, final boolean z10) {
        if (context != null) {
            Runnable runnable = new Runnable() { // from class: com.laser.tsm.sdk.http.AsyncHttpClient.1
                @Override // java.lang.Runnable
                public void run() {
                    for (RequestHandle requestHandle : (List) AsyncHttpClient.this.requestMap.get(context)) {
                        requestHandle.cancel(z10);
                    }
                    AsyncHttpClient.this.requestMap.remove(context);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(runnable).start();
            } else {
                runnable.run();
            }
        }
    }

    protected ClientConnectionManager createConnectionManager(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    public RequestHandle get(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isEncodeUrl, str, requestParams)), null, responseHandlerInterface, context);
    }

    public CookieStore getCookieStore() {
        return this.httpClient.getCookieStore();
    }

    protected ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    public RequestHandle post(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return post(context, str, paramsToEntity(requestParams, responseHandlerInterface), null, responseHandlerInterface);
    }

    protected RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandlerInterface != null) {
            if (str != null) {
                httpUriRequest.setHeader("Content-Type", str);
            }
            responseHandlerInterface.setUseSynchronousMode(this.useSynchronousMode);
            responseHandlerInterface.setRequestHeaders(httpUriRequest.getAllHeaders());
            responseHandlerInterface.setRequestURI(httpUriRequest.getURI());
            AsyncHttpRequest newAysncHttpRequest = newAysncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, responseHandlerInterface);
            if (this.useSynchronousMode) {
                newAysncHttpRequest.run();
            } else {
                this.threadPool.submit(newAysncHttpRequest);
            }
            RequestHandle requestHandle = new RequestHandle(newAysncHttpRequest);
            if (context != null) {
                List<RequestHandle> list = this.requestMap.get(context);
                if (list == null) {
                    list = new LinkedList<>();
                    this.requestMap.put(context, list);
                }
                list.add(requestHandle);
                Iterator<RequestHandle> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().shouldBeGarbageCollected()) {
                        it.remove();
                    }
                }
            }
            return requestHandle;
        } else {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        }
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
    }

    public RequestHandle post(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(URI.create(str).normalize()), httpEntity), str2, responseHandlerInterface, context);
    }

    public AsyncHttpClient(int i10) {
        this(false, i10, 443);
    }

    public AsyncHttpClient(int i10, int i11) {
        this(false, i10, i11);
    }

    public AsyncHttpClient(boolean z10, int i10, int i11) {
        this(getDefaultSchemeRegistry(z10, i10, i11));
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        this.timeout = DEFAULT_SOCKET_TIMEOUT;
        this.maxConnections = 10;
        this.isEncodeUrl = false;
        this.useSynchronousMode = false;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.timeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.timeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.timeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        createConnectionManager(schemeRegistry, basicHttpParams);
        this.threadPool = getDefaultThreadPool();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = getNewHttpClient();
    }
}
