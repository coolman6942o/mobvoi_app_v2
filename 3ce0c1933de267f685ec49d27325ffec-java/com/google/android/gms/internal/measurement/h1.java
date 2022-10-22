package com.google.android.gms.internal.measurement;

import b6.i;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f9312a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f9313b;

    /* renamed from: c  reason: collision with root package name */
    private final f1 f9314c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9315d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f9316e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ d1 f9317f;

    public h1(d1 d1Var, String str, URL url, byte[] bArr, Map<String, String> map, f1 f1Var) {
        this.f9317f = d1Var;
        i.g(str);
        i.k(url);
        i.k(f1Var);
        this.f9312a = url;
        this.f9313b = bArr;
        this.f9314c = f1Var;
        this.f9315d = str;
        this.f9316e = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Map<String, List<String>> map;
        IOException e10;
        int i10;
        HttpURLConnection httpURLConnection;
        z1 d10;
        g1 g1Var;
        IOException e11;
        Map<String, List<String>> map2;
        int i11;
        Throwable th2;
        Throwable th3;
        byte[] B;
        this.f9317f.g();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.f9317f.A(this.f9312a);
            try {
                Map<String, String> map3 = this.f9316e;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (this.f9313b != null) {
                    byte[] V = this.f9317f.p().V(this.f9313b);
                    this.f9317f.c().R().d("Uploading data. size", Integer.valueOf(V.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(V.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(V);
                        outputStream2.close();
                    } catch (IOException e12) {
                        e10 = e12;
                        map = null;
                        i10 = 0;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        d10 = this.f9317f.d();
                        g1Var = new g1(this.f9315d, this.f9314c, i10, e10, null, map);
                        d10.J(g1Var);
                    } catch (Throwable th4) {
                        th2 = th4;
                        map2 = null;
                        i11 = 0;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.f9317f.d().J(new g1(this.f9315d, this.f9314c, i11, null, null, map2));
                        throw th2;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        d1 d1Var = this.f9317f;
                        B = d1.B(httpURLConnection);
                        httpURLConnection.disconnect();
                        d10 = this.f9317f.d();
                        g1Var = new g1(this.f9315d, this.f9314c, responseCode, null, B, headerFields);
                    } catch (IOException e13) {
                        e11 = e13;
                        i10 = responseCode;
                        map = headerFields;
                        e10 = e11;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        d10 = this.f9317f.d();
                        g1Var = new g1(this.f9315d, this.f9314c, i10, e10, null, map);
                        d10.J(g1Var);
                    } catch (Throwable th5) {
                        th2 = th5;
                        i11 = responseCode;
                        map2 = headerFields;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.f9317f.d().J(new g1(this.f9315d, this.f9314c, i11, null, null, map2));
                        throw th2;
                    }
                } catch (IOException e14) {
                    e11 = e14;
                    map = null;
                    i10 = responseCode;
                } catch (Throwable th6) {
                    th2 = th6;
                    map2 = null;
                    i11 = responseCode;
                }
            } catch (IOException e15) {
                e11 = e15;
                map = null;
                i10 = 0;
                e10 = e11;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e16) {
                        this.f9317f.c().K().c("Error closing HTTP compressed POST connection output stream. appId", z0.I(this.f9315d), e16);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                d10 = this.f9317f.d();
                g1Var = new g1(this.f9315d, this.f9314c, i10, e10, null, map);
                d10.J(g1Var);
            } catch (Throwable th7) {
                th3 = th7;
                map2 = null;
                i11 = 0;
                th2 = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e17) {
                        this.f9317f.c().K().c("Error closing HTTP compressed POST connection output stream. appId", z0.I(this.f9315d), e17);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f9317f.d().J(new g1(this.f9315d, this.f9314c, i11, null, null, map2));
                throw th2;
            }
        } catch (IOException e18) {
            e11 = e18;
            httpURLConnection = null;
            map = null;
        } catch (Throwable th8) {
            th3 = th8;
            httpURLConnection = null;
            map2 = null;
        }
        d10.J(g1Var);
    }
}
