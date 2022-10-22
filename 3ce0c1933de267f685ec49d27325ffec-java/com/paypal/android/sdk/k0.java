package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
/* loaded from: classes2.dex */
public final class k0 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f21404a;

    public k0(InputStream inputStream) {
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                for (Certificate certificate : CertificateFactory.getInstance("X.509").generateCertificates(inputStream)) {
                    if (certificate instanceof X509Certificate) {
                        keyStore.setCertificateEntry(((X509Certificate) certificate).getSubjectDN().getName(), certificate);
                    }
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
                this.f21404a = sSLContext.getSocketFactory();
                try {
                    inputStream.close();
                } catch (IOException | NullPointerException unused) {
                }
            } catch (Exception e10) {
                throw new SSLException(e10.getMessage());
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException | NullPointerException unused2) {
            }
            throw th2;
        }
    }

    private static Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocket.getSupportedProtocols()));
            arrayList.retainAll(Arrays.asList("TLSv1.2", "TLSv1.1", "TLSv1"));
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10) {
        return a(this.f21404a.createSocket(str, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return a(this.f21404a.createSocket(str, i10, inetAddress, i11));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10) {
        return a(this.f21404a.createSocket(inetAddress, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return a(this.f21404a.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        return a(this.f21404a.createSocket(socket, str, i10, z10));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f21404a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f21404a.getSupportedCipherSuites();
    }
}
