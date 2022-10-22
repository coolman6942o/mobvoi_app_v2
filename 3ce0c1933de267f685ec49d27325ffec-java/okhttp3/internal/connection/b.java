package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.i;
import okhttp3.l;
/* compiled from: ConnectionSpecSelector.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f31945a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31946b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31947c;

    /* renamed from: d  reason: collision with root package name */
    private final List<l> f31948d;

    public b(List<l> connectionSpecs) {
        i.f(connectionSpecs, "connectionSpecs");
        this.f31948d = connectionSpecs;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int size = this.f31948d.size();
        for (int i10 = this.f31945a; i10 < size; i10++) {
            if (this.f31948d.get(i10).e(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public final l a(SSLSocket sslSocket) throws IOException {
        l lVar;
        i.f(sslSocket, "sslSocket");
        int i10 = this.f31945a;
        int size = this.f31948d.size();
        while (true) {
            if (i10 >= size) {
                lVar = null;
                break;
            }
            lVar = this.f31948d.get(i10);
            if (lVar.e(sslSocket)) {
                this.f31945a = i10 + 1;
                break;
            }
            i10++;
        }
        if (lVar != null) {
            this.f31946b = c(sslSocket);
            lVar.c(sslSocket, this.f31947c);
            return lVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f31947c);
        sb2.append(',');
        sb2.append(" modes=");
        sb2.append(this.f31948d);
        sb2.append(',');
        sb2.append(" supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        i.d(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        i.e(arrays, "java.util.Arrays.toString(this)");
        sb2.append(arrays);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean b(IOException e10) {
        i.f(e10, "e");
        this.f31947c = true;
        return this.f31946b && !(e10 instanceof ProtocolException) && !(e10 instanceof InterruptedIOException) && (!(e10 instanceof SSLHandshakeException) || !(e10.getCause() instanceof CertificateException)) && !(e10 instanceof SSLPeerUnverifiedException) && (e10 instanceof SSLException);
    }
}
