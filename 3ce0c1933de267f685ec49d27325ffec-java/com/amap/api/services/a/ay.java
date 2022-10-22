package com.amap.api.services.a;

import com.amap.api.maps2d.AMapException;
/* compiled from: AMapCoreException.java */
/* loaded from: classes.dex */
public class ay extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f7166a;

    /* renamed from: b  reason: collision with root package name */
    private String f7167b;

    /* renamed from: c  reason: collision with root package name */
    private String f7168c;

    /* renamed from: d  reason: collision with root package name */
    private String f7169d;

    /* renamed from: e  reason: collision with root package name */
    private int f7170e;

    public ay(String str) {
        super(str);
        this.f7166a = AMapException.ERROR_UNKNOWN;
        this.f7167b = "";
        this.f7168c = "1900";
        this.f7169d = "UnknownError";
        this.f7170e = -1;
        this.f7166a = str;
        b(str);
    }

    public String a() {
        return this.f7166a;
    }

    public String b() {
        return this.f7168c;
    }

    public String c() {
        return this.f7169d;
    }

    public String d() {
        return this.f7167b;
    }

    public int e() {
        return this.f7170e;
    }

    private void b(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f7170e = 21;
            this.f7168c = "1902";
            this.f7169d = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.f7170e = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f7170e = 23;
            this.f7168c = "1802";
            this.f7169d = "SocketTimeoutException";
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f7170e = 24;
            this.f7168c = "1901";
            this.f7169d = "IllegalArgumentException";
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f7170e = 25;
            this.f7168c = "1903";
            this.f7169d = "NullPointException";
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f7170e = 26;
            this.f7168c = "1803";
            this.f7169d = "MalformedURLException";
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f7170e = 27;
            this.f7168c = "1804";
            this.f7169d = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.f7170e = 28;
            this.f7168c = "1805";
            this.f7169d = "CannotConnectToHostException";
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f7170e = 29;
            this.f7168c = "1801";
            this.f7169d = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.f7170e = 30;
            this.f7168c = "1806";
            this.f7169d = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.f7170e = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.f7170e = 32;
        } else if ("requeust is null".equals(str)) {
            this.f7170e = 1;
        } else if ("request url is empty".equals(str)) {
            this.f7170e = 2;
        } else if ("response is null".equals(str)) {
            this.f7170e = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f7170e = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f7170e = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f7170e = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f7170e = 7;
        } else if ("线程池为空".equals(str)) {
            this.f7170e = 8;
        } else if ("获取对象错误".equals(str)) {
            this.f7170e = 101;
        } else {
            this.f7170e = -1;
        }
    }

    public ay(String str, String str2) {
        this(str);
        this.f7167b = str2;
    }
}
