package okhttp3.internal.platform;

import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.i;
import kotlin.text.s;
import okhttp3.Protocol;
/* compiled from: Jdk9Platform.kt */
/* loaded from: classes3.dex */
public class f extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f32206d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f32207e = new a(null);

    /* compiled from: Jdk9Platform.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final f a() {
            if (b()) {
                return new f();
            }
            return null;
        }

        public final boolean b() {
            return f.f32206d;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r1.intValue() >= 9) goto L11;
     */
    static {
        Integer num = null;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            num = s.i(property);
        }
        boolean z10 = true;
        if (num == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z10 = false;
                f32206d = z10;
            }
        }
        f32206d = z10;
    }

    @Override // okhttp3.internal.platform.h
    public void e(SSLSocket sslSocket, String str, List<Protocol> protocols) {
        i.f(sslSocket, "sslSocket");
        i.f(protocols, "protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        List<String> b10 = h.f32213c.b(protocols);
        i.e(sslParameters, "sslParameters");
        Object[] array = b10.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        sslParameters.setApplicationProtocols((String[]) array);
        sslSocket.setSSLParameters(sslParameters);
    }

    @Override // okhttp3.internal.platform.h
    public String h(SSLSocket sslSocket) {
        i.f(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null) {
                return null;
            }
            if (applicationProtocol.hashCode() == 0) {
                if (applicationProtocol.equals("")) {
                    return null;
                }
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
