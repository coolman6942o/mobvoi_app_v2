package np;

import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
/* compiled from: SocketAdapter.kt */
/* loaded from: classes3.dex */
public interface k {
    boolean a(SSLSocket sSLSocket);

    boolean b();

    String c(SSLSocket sSLSocket);

    void d(SSLSocket sSLSocket, String str, List<? extends Protocol> list);
}
