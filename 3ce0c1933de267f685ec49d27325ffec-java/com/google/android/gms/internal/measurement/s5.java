package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
final class s5 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f9658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s5() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private s5(SSLSocketFactory sSLSocketFactory) {
        this.f9658a = sSLSocketFactory;
    }

    private final SSLSocket a(SSLSocket sSLSocket) {
        return new t5(this, sSLSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        return a((SSLSocket) this.f9658a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10) throws IOException {
        return a((SSLSocket) this.f9658a.createSocket(str, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
        return a((SSLSocket) this.f9658a.createSocket(str, i10, inetAddress, i11));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        return a((SSLSocket) this.f9658a.createSocket(inetAddress, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        return a((SSLSocket) this.f9658a.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        return a((SSLSocket) this.f9658a.createSocket(socket, str, i10, z10));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f9658a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f9658a.getSupportedCipherSuites();
    }
}
