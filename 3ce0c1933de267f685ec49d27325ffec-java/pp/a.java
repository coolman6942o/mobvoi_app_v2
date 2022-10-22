package pp;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BasicCertificateChainCleaner.kt */
/* loaded from: classes3.dex */
public final class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private final e f32894b;

    /* compiled from: BasicCertificateChainCleaner.kt */
    /* renamed from: pp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0452a {
        private C0452a() {
        }

        public /* synthetic */ C0452a(f fVar) {
            this();
        }
    }

    static {
        new C0452a(null);
    }

    public a(e trustRootIndex) {
        i.f(trustRootIndex, "trustRootIndex");
        this.f32894b = trustRootIndex;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!i.b(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // pp.c
    public List<Certificate> a(List<? extends Certificate> chain, String hostname) throws SSLPeerUnverifiedException {
        i.f(chain, "chain");
        i.f(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        i.e(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate a10 = this.f32894b.a(x509Certificate);
            if (a10 != null) {
                if (arrayList.size() > 1 || (!i.b(x509Certificate, a10))) {
                    arrayList.add(a10);
                }
                if (b(a10, a10)) {
                    return arrayList;
                }
                z10 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                i.e(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    Objects.requireNonNull(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && i.b(((a) obj).f32894b, this.f32894b);
    }

    public int hashCode() {
        return this.f32894b.hashCode();
    }
}
