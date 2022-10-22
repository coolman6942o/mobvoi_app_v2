package com.huawei.hianalytics.mn.no.rs;

import android.content.Context;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public final class mn extends SSLSocketFactory {

    /* renamed from: mn  reason: collision with root package name */
    private static final String[] f13611mn = {"3DES", "DES", "MD5", "RC4", "aNULL", "eNULL", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "DESX", "DES40", "RC2", "ANON", "NULL", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA"};

    /* renamed from: op  reason: collision with root package name */
    private static SocketFactory f13612op;

    /* renamed from: no  reason: collision with root package name */
    private final SSLContext f13613no;

    private mn(Context context) {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        this.f13613no = sSLContext;
        sSLContext.init(null, new X509TrustManager[]{new pq(context)}, null);
    }

    public static SocketFactory mn(Context context) {
        return no(context);
    }

    private void mn(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            mn(sSLSocket);
            no(sSLSocket);
        }
    }

    private void mn(SSLSocket sSLSocket) {
        if (sSLSocket != null && Build.VERSION.SDK_INT >= 16) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        }
    }

    private static boolean mn(String str) {
        for (String str2 : f13611mn) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static synchronized SocketFactory no(Context context) {
        String str;
        String str2;
        synchronized (mn.class) {
            try {
                if (f13612op == null) {
                    f13612op = new mn(context);
                }
                return f13612op;
            } catch (IOException unused) {
                str = "Factory";
                str2 = "getLocalInstanceLock(): Failed to new SSLSocketFactory instance,IO!";
                com.huawei.hianalytics.mn.no.qr.mn.op(str, str2);
                return null;
            } catch (KeyManagementException unused2) {
                str = "Factory";
                str2 = "getLocalInstanceLock(): Failed to new SSLSocketFactory instance,Key Manage!";
                com.huawei.hianalytics.mn.no.qr.mn.op(str, str2);
                return null;
            } catch (KeyStoreException unused3) {
                str = "Factory";
                str2 = "getLocalInstanceLock(): Failed to new SSLSocketFactory instance,Key Store!";
                com.huawei.hianalytics.mn.no.qr.mn.op(str, str2);
                return null;
            } catch (NoSuchAlgorithmException unused4) {
                str = "Factory";
                str2 = "getLocalInstanceLock(): Failed to new SSLSocketFactory instance,Algorithm Exception!";
                com.huawei.hianalytics.mn.no.qr.mn.op(str, str2);
                return null;
            } catch (GeneralSecurityException unused5) {
                str = "Factory";
                str2 = "getLocalInstanceLock(): GeneralSecurityException: Failed to new SSLSocketFactory instance";
                com.huawei.hianalytics.mn.no.qr.mn.op(str, str2);
                return null;
            }
        }
    }

    private static void no(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        if (!(enabledCipherSuites == null || enabledCipherSuites.length == 0)) {
            ArrayList arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                if (!mn(str)) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10) {
        Socket createSocket = this.f13613no.getSocketFactory().createSocket(str, i10);
        mn(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return createSocket(str, i10);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        Socket createSocket = this.f13613no.getSocketFactory().createSocket(socket, str, i10, z10);
        mn(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
