package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
/* loaded from: classes.dex */
public class c extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final X509HostnameVerifier f13948a = new BrowserCompatHostnameVerifier();

    /* renamed from: b  reason: collision with root package name */
    public static final X509HostnameVerifier f13949b = new StrictHostnameVerifier();

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f13950c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String[] f13951d = null;

    /* renamed from: e  reason: collision with root package name */
    private SSLContext f13952e;

    /* renamed from: f  reason: collision with root package name */
    private Context f13953f;

    private c(Context context, String str) {
        this.f13952e = null;
        this.f13953f = context;
        this.f13952e = b.a();
        this.f13952e.init(null, new X509TrustManager[]{new d(this.f13953f, str)}, null);
    }

    public static c a(Context context, String str) {
        if (f13950c == null) {
            synchronized (c.class) {
                if (f13950c == null) {
                    f13950c = new c(context, str);
                }
            }
        }
        return f13950c;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) {
        Socket createSocket = this.f13952e.getSocketFactory().createSocket(str, i10);
        if (createSocket instanceof SSLSocket) {
            b.d((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return createSocket(str, i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        Socket createSocket = this.f13952e.getSocketFactory().createSocket(socket, str, i10, z10);
        if (createSocket instanceof SSLSocket) {
            b.d((SSLSocket) createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] strArr = f13951d;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
