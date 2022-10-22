package h0;

import android.util.Base64;
import j0.h;
import java.util.List;
/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f27645a;

    /* renamed from: b  reason: collision with root package name */
    private final String f27646b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27647c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f27648d;

    /* renamed from: e  reason: collision with root package name */
    private final int f27649e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f27650f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f27645a = (String) h.g(str);
        this.f27646b = (String) h.g(str2);
        this.f27647c = (String) h.g(str3);
        this.f27648d = (List) h.g(list);
        this.f27650f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f27648d;
    }

    public int c() {
        return this.f27649e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f27650f;
    }

    public String e() {
        return this.f27645a;
    }

    public String f() {
        return this.f27646b;
    }

    public String g() {
        return this.f27647c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f27645a + ", mProviderPackage: " + this.f27646b + ", mQuery: " + this.f27647c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f27648d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f27648d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f27649e);
        return sb2.toString();
    }
}
