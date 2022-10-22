package com.airbnb.lottie.network;

import android.content.Context;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;
/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6669a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6670b;

    /* renamed from: c  reason: collision with root package name */
    private final a f6671c;

    private b(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f6669a = applicationContext;
        this.f6670b = str;
        if (str2 == null) {
            this.f6671c = null;
        } else {
            this.f6671c = new a(applicationContext);
        }
    }

    private d a() {
        j0.d<FileExtension, InputStream> a10;
        l<d> lVar;
        a aVar = this.f6671c;
        if (aVar == null || (a10 = aVar.a(this.f6670b)) == null) {
            return null;
        }
        FileExtension fileExtension = a10.f29364a;
        InputStream inputStream = a10.f29365b;
        if (fileExtension == FileExtension.ZIP) {
            lVar = e.r(new ZipInputStream(inputStream), this.f6670b);
        } else {
            lVar = e.h(inputStream, this.f6670b);
        }
        if (lVar.b() != null) {
            return lVar.b();
        }
        return null;
    }

    private l<d> b() {
        try {
            return c();
        } catch (IOException e10) {
            return new l<>(e10);
        }
    }

    private l<d> c() throws IOException {
        k3.d.a("Fetching " + this.f6670b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f6670b).openConnection();
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                l<d> g10 = g(httpURLConnection);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                sb2.append(g10.b() != null);
                k3.d.a(sb2.toString());
                return g10;
            }
            String f10 = f(httpURLConnection);
            return new l<>(new IllegalArgumentException("Unable to fetch " + this.f6670b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f10));
        } catch (Exception e10) {
            return new l<>(e10);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static l<d> e(Context context, String str, String str2) {
        return new b(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append(readLine);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e10) {
                    throw e10;
                }
            } catch (Throwable th2) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th2;
            }
        }
        bufferedReader.close();
        return sb2.toString();
    }

    private l<d> g(HttpURLConnection httpURLConnection) throws IOException {
        l<d> lVar;
        FileExtension fileExtension;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        if (contentType.contains("application/zip")) {
            k3.d.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            a aVar = this.f6671c;
            if (aVar == null) {
                lVar = e.r(new ZipInputStream(httpURLConnection.getInputStream()), null);
            } else {
                lVar = e.r(new ZipInputStream(new FileInputStream(aVar.f(this.f6670b, httpURLConnection.getInputStream(), fileExtension))), this.f6670b);
            }
        } else {
            k3.d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            a aVar2 = this.f6671c;
            if (aVar2 == null) {
                lVar = e.h(httpURLConnection.getInputStream(), null);
            } else {
                lVar = e.h(new FileInputStream(new File(aVar2.f(this.f6670b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f6670b);
            }
        }
        if (!(this.f6671c == null || lVar.b() == null)) {
            this.f6671c.e(this.f6670b, fileExtension);
        }
        return lVar;
    }

    public l<d> d() {
        d a10 = a();
        if (a10 != null) {
            return new l<>(a10);
        }
        k3.d.a("Animation for " + this.f6670b + " not found in cache. Fetching from network.");
        return b();
    }
}
