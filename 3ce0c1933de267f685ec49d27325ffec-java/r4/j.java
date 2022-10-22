package r4;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import n5.c;
import n5.f;
import r4.d;
import x4.g;
/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: g  reason: collision with root package name */
    static final b f33418g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final g f33419a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33420b;

    /* renamed from: c  reason: collision with root package name */
    private final b f33421c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f33422d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f33423e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f33424f;

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class a implements b {
        a() {
        }

        @Override // r4.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(g gVar, int i10) {
        this(gVar, i10, f33418g);
    }

    private InputStream d(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f33423e = c.d(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f33423e = httpURLConnection.getInputStream();
        }
        return this.f33423e;
    }

    private static boolean f(int i10) {
        return i10 / 100 == 2;
    }

    private static boolean g(int i10) {
        return i10 / 100 == 3;
    }

    private InputStream h(URL url, int i10, URL url2, Map<String, String> map) throws IOException {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f33422d = this.f33421c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f33422d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f33422d.setConnectTimeout(this.f33420b);
            this.f33422d.setReadTimeout(this.f33420b);
            this.f33422d.setUseCaches(false);
            this.f33422d.setDoInput(true);
            this.f33422d.setInstanceFollowRedirects(false);
            this.f33422d.connect();
            this.f33423e = this.f33422d.getInputStream();
            if (this.f33424f) {
                return null;
            }
            int responseCode = this.f33422d.getResponseCode();
            if (f(responseCode)) {
                return d(this.f33422d);
            }
            if (g(responseCode)) {
                String headerField = this.f33422d.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    c();
                    return h(url3, i10 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f33422d.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @Override // r4.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // r4.d
    public DataSource b() {
        return DataSource.REMOTE;
    }

    @Override // r4.d
    public void c() {
        InputStream inputStream = this.f33423e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f33422d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f33422d = null;
    }

    @Override // r4.d
    public void cancel() {
        this.f33424f = true;
    }

    @Override // r4.d
    public void e(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb2;
        long b10 = f.b();
        try {
            try {
                aVar.f(h(this.f33419a.h(), 0, null, this.f33419a.e()));
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.d(e10);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb2 = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(f.a(b10));
                Log.v("HttpUrlFetcher", sb2.toString());
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + f.a(b10));
            }
            throw th2;
        }
    }

    j(g gVar, int i10, b bVar) {
        this.f33419a = gVar;
        this.f33420b = i10;
        this.f33421c = bVar;
    }
}
