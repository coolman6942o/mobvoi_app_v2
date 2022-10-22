package j9;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import r9.b;
/* compiled from: FileDownloadUrlConnection.java */
/* loaded from: classes2.dex */
public class c implements j9.b {

    /* renamed from: a  reason: collision with root package name */
    protected URLConnection f29447a;

    /* compiled from: FileDownloadUrlConnection.java */
    /* loaded from: classes2.dex */
    public static class a {
    }

    /* compiled from: FileDownloadUrlConnection.java */
    /* loaded from: classes2.dex */
    public static class b implements b.AbstractC0460b {

        /* renamed from: a  reason: collision with root package name */
        private final a f29448a;

        public b() {
            this(null);
        }

        @Override // r9.b.AbstractC0460b
        public j9.b a(String str) throws IOException {
            return new c(str, this.f29448a);
        }

        public b(a aVar) {
        }
    }

    public c(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    @Override // j9.b
    public InputStream a() throws IOException {
        return this.f29447a.getInputStream();
    }

    @Override // j9.b
    public Map<String, List<String>> b() {
        return this.f29447a.getHeaderFields();
    }

    @Override // j9.b
    public boolean c(String str, long j10) {
        return false;
    }

    @Override // j9.b
    public int d() throws IOException {
        URLConnection uRLConnection = this.f29447a;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // j9.b
    public void e(String str, String str2) {
        this.f29447a.addRequestProperty(str, str2);
    }

    @Override // j9.b
    public void execute() throws IOException {
        this.f29447a.connect();
    }

    @Override // j9.b
    public String f(String str) {
        return this.f29447a.getHeaderField(str);
    }

    @Override // j9.b
    public void g() {
        try {
            this.f29447a.getInputStream().close();
        } catch (IOException unused) {
        }
    }

    @Override // j9.b
    public boolean h(String str) throws ProtocolException {
        URLConnection uRLConnection = this.f29447a;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // j9.b
    public Map<String, List<String>> i() {
        return this.f29447a.getRequestProperties();
    }

    public c(URL url, a aVar) throws IOException {
        this.f29447a = url.openConnection();
    }
}
