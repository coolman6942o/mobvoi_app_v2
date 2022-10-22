package okhttp3;

import io.d;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Handshake.kt */
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: e  reason: collision with root package name */
    public static final a f32269e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final d f32270a;

    /* renamed from: b  reason: collision with root package name */
    private final TlsVersion f32271b;

    /* renamed from: c  reason: collision with root package name */
    private final i f32272c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f32273d;

    /* compiled from: Handshake.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Handshake.kt */
        /* renamed from: okhttp3.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0443a extends Lambda implements qo.a<List<? extends Certificate>> {
            final /* synthetic */ List $peerCertificatesCopy;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0443a(List list) {
                super(0);
                this.$peerCertificatesCopy = list;
            }

            /* renamed from: a */
            public final List<Certificate> invoke() {
                return this.$peerCertificatesCopy;
            }
        }

        /* compiled from: Handshake.kt */
        /* loaded from: classes3.dex */
        static final class b extends Lambda implements qo.a<List<? extends Certificate>> {
            final /* synthetic */ List $peerCertificatesCopy;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(List list) {
                super(0);
                this.$peerCertificatesCopy = list;
            }

            /* renamed from: a */
            public final List<Certificate> invoke() {
                return this.$peerCertificatesCopy;
            }
        }

        private a() {
        }

        private final List<Certificate> c(Certificate[] certificateArr) {
            List<Certificate> g10;
            if (certificateArr != null) {
                return gp.b.t((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length));
            }
            g10 = m.g();
            return g10;
        }

        public final t a(SSLSession handshake) throws IOException {
            List<Certificate> list;
            i.f(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite != null) {
                int hashCode = cipherSuite.hashCode();
                if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                    throw new IOException("cipherSuite == " + cipherSuite);
                }
                i b10 = i.f31871t.b(cipherSuite);
                String protocol = handshake.getProtocol();
                if (protocol == null) {
                    throw new IllegalStateException("tlsVersion == null".toString());
                } else if (!i.b("NONE", protocol)) {
                    TlsVersion a10 = TlsVersion.Companion.a(protocol);
                    try {
                        list = c(handshake.getPeerCertificates());
                    } catch (SSLPeerUnverifiedException unused) {
                        list = m.g();
                    }
                    return new t(a10, b10, c(handshake.getLocalCertificates()), new b(list));
                } else {
                    throw new IOException("tlsVersion == NONE");
                }
            } else {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
        }

        public final t b(TlsVersion tlsVersion, i cipherSuite, List<? extends Certificate> peerCertificates, List<? extends Certificate> localCertificates) {
            i.f(tlsVersion, "tlsVersion");
            i.f(cipherSuite, "cipherSuite");
            i.f(peerCertificates, "peerCertificates");
            i.f(localCertificates, "localCertificates");
            return new t(tlsVersion, cipherSuite, gp.b.O(localCertificates), new C0443a(gp.b.O(peerCertificates)));
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Handshake.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements qo.a<List<? extends Certificate>> {
        final /* synthetic */ qo.a $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(qo.a aVar) {
            super(0);
            this.$peerCertificatesFn = aVar;
        }

        /* renamed from: a */
        public final List<Certificate> invoke() {
            List<Certificate> g10;
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                g10 = m.g();
                return g10;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(TlsVersion tlsVersion, i cipherSuite, List<? extends Certificate> localCertificates, qo.a<? extends List<? extends Certificate>> peerCertificatesFn) {
        d a10;
        i.f(tlsVersion, "tlsVersion");
        i.f(cipherSuite, "cipherSuite");
        i.f(localCertificates, "localCertificates");
        i.f(peerCertificatesFn, "peerCertificatesFn");
        this.f32271b = tlsVersion;
        this.f32272c = cipherSuite;
        this.f32273d = localCertificates;
        a10 = io.f.a(new b(peerCertificatesFn));
        this.f32270a = a10;
    }

    private final String b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        i.e(type, "type");
        return type;
    }

    public final i a() {
        return this.f32272c;
    }

    public final List<Certificate> c() {
        return this.f32273d;
    }

    public final List<Certificate> d() {
        return (List) this.f32270a.getValue();
    }

    public final TlsVersion e() {
        return this.f32271b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (tVar.f32271b == this.f32271b && i.b(tVar.f32272c, this.f32272c) && i.b(tVar.d(), d()) && i.b(tVar.f32273d, this.f32273d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f32271b.hashCode()) * 31) + this.f32272c.hashCode()) * 31) + d().hashCode()) * 31) + this.f32273d.hashCode();
    }

    public String toString() {
        int p10;
        int p11;
        List<Certificate> d10 = d();
        p10 = n.p(d10, 10);
        ArrayList arrayList = new ArrayList(p10);
        for (Certificate certificate : d10) {
            arrayList.add(b(certificate));
        }
        String obj = arrayList.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handshake{");
        sb2.append("tlsVersion=");
        sb2.append(this.f32271b);
        sb2.append(' ');
        sb2.append("cipherSuite=");
        sb2.append(this.f32272c);
        sb2.append(' ');
        sb2.append("peerCertificates=");
        sb2.append(obj);
        sb2.append(' ');
        sb2.append("localCertificates=");
        List<Certificate> list = this.f32273d;
        p11 = n.p(list, 10);
        ArrayList arrayList2 = new ArrayList(p11);
        for (Certificate certificate2 : list) {
            arrayList2.add(b(certificate2));
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
