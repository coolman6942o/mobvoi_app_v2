package pp;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.jvm.internal.i;
/* compiled from: BasicTrustRootIndex.kt */
/* loaded from: classes3.dex */
public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f32895a;

    public b(X509Certificate... caCerts) {
        i.f(caCerts, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : caCerts) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            i.e(subjectX500Principal, "caCert.subjectX500Principal");
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((Set) obj).add(x509Certificate);
        }
        this.f32895a = linkedHashMap;
    }

    @Override // pp.e
    public X509Certificate a(X509Certificate cert) {
        boolean z10;
        i.f(cert, "cert");
        Set<X509Certificate> set = this.f32895a.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            try {
                cert.verify(((X509Certificate) next).getPublicKey());
                z10 = true;
                continue;
            } catch (Exception unused) {
                z10 = false;
                continue;
            }
            if (z10) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof b) && i.b(((b) obj).f32895a, this.f32895a));
    }

    public int hashCode() {
        return this.f32895a.hashCode();
    }
}
