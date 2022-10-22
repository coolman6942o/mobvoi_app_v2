package fa;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f26372a = new b();

    private /* synthetic */ b() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean b10;
        b10 = c.b(str, sSLSession);
        return b10;
    }
}
