package pp;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.internal.platform.h;
/* compiled from: CertificateChainCleaner.kt */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32896a = new a(null);

    /* compiled from: CertificateChainCleaner.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final c a(X509TrustManager trustManager) {
            i.f(trustManager, "trustManager");
            return h.f32213c.g().c(trustManager);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public abstract List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
