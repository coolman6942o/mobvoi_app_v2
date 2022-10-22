package com.amap.api.mapcore2d;

import com.amap.api.maps2d.AMapException;
/* compiled from: AMapCoreException.java */
/* loaded from: classes.dex */
public class co extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f6962a;

    /* renamed from: b  reason: collision with root package name */
    private String f6963b;

    /* renamed from: c  reason: collision with root package name */
    private String f6964c;

    /* renamed from: d  reason: collision with root package name */
    private String f6965d;

    /* renamed from: e  reason: collision with root package name */
    private int f6966e;

    public co(String str) {
        super(str);
        this.f6962a = AMapException.ERROR_UNKNOWN;
        this.f6963b = "";
        this.f6964c = "1900";
        this.f6965d = "UnknownError";
        this.f6966e = -1;
        this.f6962a = str;
        b(str);
    }

    public String a() {
        return this.f6962a;
    }

    public String b() {
        return this.f6964c;
    }

    public String c() {
        return this.f6965d;
    }

    public String d() {
        return this.f6963b;
    }

    public int e() {
        return this.f6966e;
    }

    private void b(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f6966e = 21;
            this.f6964c = "1902";
            this.f6965d = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f6966e = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f6966e = 23;
            this.f6964c = "1802";
            this.f6965d = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f6966e = 24;
            this.f6964c = "1901";
            this.f6965d = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f6966e = 25;
            this.f6964c = "1903";
            this.f6965d = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f6966e = 26;
            this.f6964c = "1803";
            this.f6965d = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f6966e = 27;
            this.f6964c = "1804";
            this.f6965d = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f6966e = 28;
            this.f6964c = "1805";
            this.f6965d = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f6966e = 29;
            this.f6964c = "1801";
            this.f6965d = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f6966e = 30;
            this.f6964c = "1806";
            this.f6965d = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f6966e = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f6966e = 32;
        } else if ("requeust is null".equals(str)) {
            this.f6966e = 1;
        } else if ("request url is empty".equals(str)) {
            this.f6966e = 2;
        } else if ("response is null".equals(str)) {
            this.f6966e = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f6966e = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f6966e = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f6966e = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f6966e = 7;
        } else if ("线程池为空".equals(str)) {
            this.f6966e = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f6966e = 101;
        } else {
            this.f6966e = -1;
        }
    }

    public co(String str, String str2) {
        this(str);
        this.f6963b = str2;
    }
}
