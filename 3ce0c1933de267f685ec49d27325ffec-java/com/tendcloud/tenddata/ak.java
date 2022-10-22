package com.tendcloud.tenddata;

import android.os.SystemClock;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22614a = 600;

    /* renamed from: b  reason: collision with root package name */
    private int f22615b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f22616c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<String>> f22617d;

    private ak(int i10, String str) {
        this(i10, str.getBytes(), null);
    }

    public static int a() {
        return f22614a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r9 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ak a(String str, HttpURLConnection httpURLConnection, long j10, ah ahVar) {
        Throwable th2;
        InputStream inputStream;
        int i10;
        ak akVar;
        InputStream inputStream2;
        try {
            i10 = httpURLConnection.getResponseCode();
            try {
                if (i10 > 400) {
                    inputStream2 = httpURLConnection.getErrorStream();
                } else {
                    inputStream2 = httpURLConnection.getInputStream();
                }
                inputStream = inputStream2;
            } catch (Throwable th3) {
                th2 = th3;
                inputStream = null;
                try {
                    bf.postSDKError(th2);
                    akVar = new ak(i10, null, null);
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            i10 = f22614a;
        }
        try {
            akVar = a(i10, httpURLConnection.getContentLength(), inputStream, httpURLConnection.getHeaderFields());
            a(str, httpURLConnection, i10, j10, akVar, ahVar);
        } catch (Throwable th5) {
            th2 = th5;
            bf.postSDKError(th2);
            akVar = new ak(i10, null, null);
        }
    }

    public int b() {
        return this.f22615b;
    }

    public byte[] c() {
        return this.f22616c;
    }

    public Map<String, List<String>> d() {
        return this.f22617d;
    }

    private ak(int i10, byte[] bArr, Map<String, List<String>> map) {
        this.f22615b = i10;
        this.f22616c = bArr;
        this.f22617d = map;
    }

    public static ak a(String str) {
        return new ak(f22614a, str);
    }

    /* JADX WARN: Finally extract failed */
    private static ak a(int i10, int i11, InputStream inputStream, Map<String, List<String>> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = i11 != -1 ? new ByteArrayOutputStream(i11) : new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    inputStream.close();
                    return new ak(i10, byteArrayOutputStream.toByteArray(), map);
                }
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }

    private static void a(String str, HttpURLConnection httpURLConnection, int i10, long j10, ak akVar, ah ahVar) {
        boolean z10;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getRequestMethod().equalsIgnoreCase("POST")) {
                    TreeMap treeMap = new TreeMap();
                    URL url = httpURLConnection.getURL();
                    treeMap.put("targetUrl", url.toString());
                    treeMap.put("targetIP", InetAddress.getByName(url.getHost()).getHostAddress());
                    if (i10 == 200) {
                        if (!(ahVar == null || ahVar.a() == null)) {
                            treeMap.put("reqSize", Integer.valueOf(ahVar.a().length));
                        }
                        treeMap.put("respTime", Long.valueOf(SystemClock.elapsedRealtime() - j10));
                        z10 = true;
                    } else {
                        treeMap.put("errorMsg", a(akVar));
                        treeMap.put("statusCode", Integer.valueOf(i10));
                        z10 = false;
                    }
                    bf.a(str, z10, treeMap);
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    private static String a(ak akVar) {
        if (akVar == null || akVar.c() == null) {
            return "";
        }
        try {
            byte[] c10 = akVar.c();
            return c10.length > 104857600 ? "Input stream more than 100 MB size limit" : new String(c10);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return "";
        }
    }
}
