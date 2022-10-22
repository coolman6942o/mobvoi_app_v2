package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import kotlin.text.t;
import okio.ByteString;
/* compiled from: CertificatePinner.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c> f31845a;

    /* renamed from: b  reason: collision with root package name */
    private final pp.c f31846b;

    /* renamed from: d  reason: collision with root package name */
    public static final b f31844d = new b(null);

    /* renamed from: c  reason: collision with root package name */
    public static final g f31843c = new a().a();

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f31847a = new ArrayList();

        public final g a() {
            Set X;
            X = u.X(this.f31847a);
            return new g(X, null, 2, null);
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final String a(Certificate certificate) {
            i.f(certificate, "certificate");
            if (certificate instanceof X509Certificate) {
                return "sha256/" + c((X509Certificate) certificate).base64();
            }
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
        }

        public final ByteString b(X509Certificate sha1Hash) {
            i.f(sha1Hash, "$this$sha1Hash");
            ByteString.a aVar = ByteString.Companion;
            PublicKey publicKey = sha1Hash.getPublicKey();
            i.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            i.e(encoded, "publicKey.encoded");
            return ByteString.a.h(aVar, encoded, 0, 0, 3, null).sha1();
        }

        public final ByteString c(X509Certificate sha256Hash) {
            i.f(sha256Hash, "$this$sha256Hash");
            ByteString.a aVar = ByteString.Companion;
            PublicKey publicKey = sha256Hash.getPublicKey();
            i.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            i.e(encoded, "publicKey.encoded");
            return ByteString.a.h(aVar, encoded, 0, 0, 3, null).sha256();
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f31848a;

        /* renamed from: b  reason: collision with root package name */
        private final String f31849b;

        /* renamed from: c  reason: collision with root package name */
        private final ByteString f31850c;

        public final ByteString a() {
            return this.f31850c;
        }

        public final String b() {
            return this.f31849b;
        }

        public final boolean c(String hostname) {
            boolean D;
            boolean D2;
            boolean u10;
            int X;
            boolean u11;
            i.f(hostname, "hostname");
            D = t.D(this.f31848a, "**.", false, 2, null);
            if (D) {
                int length = this.f31848a.length() - 3;
                int length2 = hostname.length() - length;
                u11 = t.u(hostname, hostname.length() - length, this.f31848a, 3, length, false, 16, null);
                if (!u11) {
                    return false;
                }
                if (!(length2 == 0 || hostname.charAt(length2 - 1) == '.')) {
                    return false;
                }
            } else {
                D2 = t.D(this.f31848a, "*.", false, 2, null);
                if (!D2) {
                    return i.b(hostname, this.f31848a);
                }
                int length3 = this.f31848a.length() - 1;
                int length4 = hostname.length() - length3;
                u10 = t.u(hostname, hostname.length() - length3, this.f31848a, 1, length3, false, 16, null);
                if (!u10) {
                    return false;
                }
                X = kotlin.text.u.X(hostname, '.', length4 - 1, false, 4, null);
                if (X != -1) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return !(i.b(this.f31848a, cVar.f31848a) ^ true) && !(i.b(this.f31849b, cVar.f31849b) ^ true) && !(i.b(this.f31850c, cVar.f31850c) ^ true);
        }

        public int hashCode() {
            return (((this.f31848a.hashCode() * 31) + this.f31849b.hashCode()) * 31) + this.f31850c.hashCode();
        }

        public String toString() {
            return this.f31849b + '/' + this.f31850c.base64();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements qo.a<List<? extends X509Certificate>> {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        /* renamed from: a */
        public final List<X509Certificate> invoke() {
            List<Certificate> list;
            int p10;
            pp.c d10 = g.this.d();
            if (d10 == null || (list = d10.a(this.$peerCertificates, this.$hostname)) == null) {
                list = this.$peerCertificates;
            }
            p10 = n.p(list, 10);
            ArrayList arrayList = new ArrayList(p10);
            for (Certificate certificate : list) {
                Objects.requireNonNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public g(Set<c> pins, pp.c cVar) {
        i.f(pins, "pins");
        this.f31845a = pins;
        this.f31846b = cVar;
    }

    public final void a(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        i.f(hostname, "hostname");
        i.f(peerCertificates, "peerCertificates");
        b(hostname, new d(peerCertificates, hostname));
    }

    public final void b(String hostname, qo.a<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        i.f(hostname, "hostname");
        i.f(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<c> c10 = c(hostname);
        if (!c10.isEmpty()) {
            List<? extends X509Certificate> invoke = cleanedPeerCertificatesFn.invoke();
            for (X509Certificate x509Certificate : invoke) {
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (c cVar : c10) {
                    String b10 = cVar.b();
                    int hashCode = b10.hashCode();
                    if (hashCode != -903629273) {
                        if (hashCode == 3528965 && b10.equals("sha1")) {
                            if (byteString2 == null) {
                                byteString2 = f31844d.b(x509Certificate);
                            }
                            if (i.b(cVar.a(), byteString2)) {
                                return;
                            }
                        }
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.b());
                    } else if (b10.equals("sha256")) {
                        if (byteString == null) {
                            byteString = f31844d.c(x509Certificate);
                        }
                        if (i.b(cVar.a(), byteString)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + cVar.b());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : invoke) {
                sb2.append("\n    ");
                sb2.append(f31844d.a(x509Certificate2));
                sb2.append(": ");
                Principal subjectDN = x509Certificate2.getSubjectDN();
                i.e(subjectDN, "element.subjectDN");
                sb2.append(subjectDN.getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(hostname);
            sb2.append(":");
            for (c cVar2 : c10) {
                sb2.append("\n    ");
                sb2.append(cVar2);
            }
            String sb3 = sb2.toString();
            i.e(sb3, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb3);
        }
    }

    public final List<c> c(String hostname) {
        List<c> g10;
        i.f(hostname, "hostname");
        Set<c> set = this.f31845a;
        g10 = m.g();
        for (Object obj : set) {
            if (((c) obj).c(hostname)) {
                if (g10.isEmpty()) {
                    g10 = new ArrayList<>();
                }
                o.a(g10).add(obj);
            }
        }
        return g10;
    }

    public final pp.c d() {
        return this.f31846b;
    }

    public final g e(pp.c certificateChainCleaner) {
        i.f(certificateChainCleaner, "certificateChainCleaner");
        return i.b(this.f31846b, certificateChainCleaner) ? this : new g(this.f31845a, certificateChainCleaner);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (i.b(gVar.f31845a, this.f31845a) && i.b(gVar.f31846b, this.f31846b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (1517 + this.f31845a.hashCode()) * 41;
        pp.c cVar = this.f31846b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public /* synthetic */ g(Set set, pp.c cVar, int i10, f fVar) {
        this(set, (i10 & 2) != 0 ? null : cVar);
    }
}
