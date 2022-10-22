package com.tendcloud.tenddata;

import android.os.SystemClock;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* compiled from: td */
/* loaded from: classes2.dex */
final class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22595a = 60000;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22596b = 60000;

    /* renamed from: c  reason: collision with root package name */
    private URL f22597c;

    /* renamed from: d  reason: collision with root package name */
    private aj f22598d;

    /* renamed from: e  reason: collision with root package name */
    private ai f22599e;

    /* renamed from: f  reason: collision with root package name */
    private ah f22600f;

    /* renamed from: g  reason: collision with root package name */
    private String f22601g;

    /* renamed from: h  reason: collision with root package name */
    private String f22602h;

    /* renamed from: i  reason: collision with root package name */
    private String f22603i;

    /* renamed from: j  reason: collision with root package name */
    private int f22604j;

    /* renamed from: k  reason: collision with root package name */
    private int f22605k;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static final class a {
        private ah body;
        private String cert;
        private ai headers;
        private String host;

        /* renamed from: ip  reason: collision with root package name */
        private String f22606ip;
        private aj method;
        private URL url;
        private int connectionTimeout = 60000;
        private int readTimeout = 60000;

        public a body(ah ahVar) {
            this.body = ahVar;
            return this;
        }

        public ag build() {
            return new ag(this.url, this.method, this.headers, this.body, this.connectionTimeout, this.readTimeout, this.cert, this.host, this.f22606ip);
        }

        public a cert(String str) {
            this.cert = str;
            return this;
        }

        public a connectionTimeout(int i10) {
            this.connectionTimeout = i10;
            return this;
        }

        public a header(ai aiVar) {
            this.headers = aiVar;
            return this;
        }

        public a host(String str) {
            this.host = str;
            return this;
        }

        public a ip(String str) {
            this.f22606ip = str;
            return this;
        }

        public a method(aj ajVar) {
            this.method = ajVar;
            return this;
        }

        public a readTimeout(int i10) {
            this.readTimeout = i10;
            return this;
        }

        public a url(String str) {
            try {
                this.url = new URL(str);
                return this;
            } catch (MalformedURLException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public aj a() {
        return this.f22598d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak b() {
        ak a10 = ak.a("");
        try {
            ak a11 = a(false);
            ad.b(this.f22602h, this.f22603i);
            if (a11.b() != ak.a()) {
                String str = this.f22602h;
                ad.a(str, ad.b(str), 2);
                ad.a(this.f22602h);
                return a11;
            }
            if (ad.a(this.f22602h, 2) != null) {
                this.f22597c = ad.a(this.f22597c, ad.a(this.f22602h, 2));
                a11 = a(true);
                if (a11.b() == ak.a()) {
                    ad.a(this.f22602h, null, 2);
                }
            } else {
                if (ad.a(this.f22602h, 1) != null) {
                    this.f22597c = ad.a(this.f22597c, ad.a(this.f22602h, 1));
                    a11 = a(true);
                    if (a11.b() != ak.a()) {
                        String str2 = this.f22602h;
                        ad.a(str2, ad.a(str2, 1), 2);
                        ad.a(this.f22602h);
                    }
                }
                if (a11.b() == ak.a() && ad.a(this.f22602h, 3) != null) {
                    this.f22597c = ad.a(this.f22597c, ad.a(this.f22602h, 3));
                    a11 = a(true);
                    if (a11.b() != ak.a()) {
                        String str3 = this.f22602h;
                        ad.a(str3, ad.a(str3, 3), 2);
                    }
                }
                if (a11.b() == ak.a() && ad.a(this.f22602h, 4) != null) {
                    this.f22597c = ad.a(this.f22597c, ad.a(this.f22602h, 4));
                    a11 = a(true);
                    if (a11.b() != ak.a()) {
                        String str4 = this.f22602h;
                        ad.a(str4, ad.a(str4, 4), 2);
                    }
                }
            }
            return a11;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak c() {
        ak a10 = ak.a("");
        try {
            return a(false);
        } catch (Throwable unused) {
            return a10;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n url: ");
        sb2.append(this.f22597c);
        sb2.append("\n method: ");
        sb2.append(this.f22598d);
        sb2.append("\n headers: ");
        sb2.append(this.f22599e);
        sb2.append("\n content length: ");
        ah ahVar = this.f22600f;
        Object obj = "";
        sb2.append(ahVar != null ? Integer.valueOf(ahVar.a().length) : obj);
        sb2.append("\n content Type: ");
        ah ahVar2 = this.f22600f;
        if (ahVar2 != null) {
            obj = ahVar2.b();
        }
        sb2.append(obj);
        sb2.append("\n host: ");
        sb2.append(this.f22602h);
        sb2.append("\n ip: ");
        sb2.append(this.f22603i);
        sb2.append("\n connectionTimeout: ");
        sb2.append(this.f22604j);
        sb2.append("\n readTimeout: ");
        sb2.append(this.f22605k);
        sb2.append("\n cert:  ");
        sb2.append(this.f22601g);
        sb2.append("\n");
        return sb2.toString();
    }

    private ag(URL url, aj ajVar, ai aiVar, ah ahVar, int i10, int i11, String str, String str2, String str3) {
        this.f22597c = url;
        this.f22598d = ajVar;
        this.f22599e = aiVar;
        this.f22600f = ahVar;
        this.f22604j = i10;
        this.f22605k = i11;
        this.f22601g = str;
        this.f22602h = str2;
        this.f22603i = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak a(boolean z10) {
        Throwable th2;
        ak a10;
        HttpURLConnection httpURLConnection = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.f22597c.openConnection();
            try {
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                URL url = this.f22597c;
                if (url != null && url.toString().startsWith("https://")) {
                    z.f23035a.put(Long.valueOf(Thread.currentThread().getId()), this.f22602h);
                    if (z10) {
                        z.setHostNameVerifyAllowAll(httpURLConnection2);
                    }
                }
                if (!u.b(this.f22601g)) {
                    z.a(httpURLConnection2, this.f22601g);
                }
                if (!u.b(this.f22602h)) {
                    httpURLConnection2.setRequestProperty("Host", u.b(this.f22597c.getHost()) ? this.f22602h : this.f22597c.getHost());
                    httpURLConnection2.setRequestProperty("Host", this.f22602h);
                }
                aj ajVar = this.f22598d;
                if (ajVar != null) {
                    ajVar.a(httpURLConnection2);
                }
                ai aiVar = this.f22599e;
                if (aiVar != null) {
                    aiVar.a(httpURLConnection2);
                }
                ah ahVar = this.f22600f;
                if (ahVar != null) {
                    ahVar.a(httpURLConnection2);
                }
                httpURLConnection2.connect();
                a10 = ak.a(this.f22602h, httpURLConnection2, elapsedRealtime, this.f22600f);
                httpURLConnection2.disconnect();
            } catch (Throwable th3) {
                th2 = th3;
                httpURLConnection = httpURLConnection2;
                try {
                    bf.postSDKError(th2);
                    a10 = ak.a(th2.getMessage());
                    return a10;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
        }
        return a10;
    }
}
