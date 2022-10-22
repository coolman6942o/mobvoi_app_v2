package x4;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import n5.j;
import q4.b;
/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class g implements b {

    /* renamed from: b  reason: collision with root package name */
    private final h f36378b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f36379c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36380d;

    /* renamed from: e  reason: collision with root package name */
    private String f36381e;

    /* renamed from: f  reason: collision with root package name */
    private URL f36382f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f36383g;

    /* renamed from: h  reason: collision with root package name */
    private int f36384h;

    public g(URL url) {
        this(url, h.f36385a);
    }

    private byte[] d() {
        if (this.f36383g == null) {
            this.f36383g = c().getBytes(b.f32922a);
        }
        return this.f36383g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f36381e)) {
            String str = this.f36380d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) j.d(this.f36379c)).toString();
            }
            this.f36381e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f36381e;
    }

    private URL g() throws MalformedURLException {
        if (this.f36382f == null) {
            this.f36382f = new URL(f());
        }
        return this.f36382f;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f36380d;
        return str != null ? str : ((URL) j.d(this.f36379c)).toString();
    }

    public Map<String, String> e() {
        return this.f36378b.a();
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f36378b.equals(gVar.f36378b);
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // q4.b
    public int hashCode() {
        if (this.f36384h == 0) {
            int hashCode = c().hashCode();
            this.f36384h = hashCode;
            this.f36384h = (hashCode * 31) + this.f36378b.hashCode();
        }
        return this.f36384h;
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f36385a);
    }

    public g(URL url, h hVar) {
        this.f36379c = (URL) j.d(url);
        this.f36380d = null;
        this.f36378b = (h) j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f36379c = null;
        this.f36380d = j.b(str);
        this.f36378b = (h) j.d(hVar);
    }
}
