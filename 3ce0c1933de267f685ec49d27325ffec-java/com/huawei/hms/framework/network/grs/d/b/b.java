package com.huawei.hms.framework.network.grs.d.b;

import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f13945a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13946b = {"TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f13947c = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static SSLContext a() {
        int i10 = Build.VERSION.SDK_INT;
        return SSLContext.getInstance(i10 >= 29 ? "TLSv1.3" : i10 >= 16 ? "TLSv1.2" : "TLS");
    }

    public static boolean a(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return a(sSLSocket, f13947c);
    }

    public static boolean a(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= length) {
                break;
            }
            String str = enabledCipherSuites[i10];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    z10 = false;
                    break;
                } else if (upperCase.contains(strArr[i11].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i11++;
                }
            }
            if (!z10) {
                arrayList.add(str);
            }
            i10++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static void b(SSLSocket sSLSocket) {
        if (sSLSocket != null && !e(sSLSocket)) {
            a(sSLSocket);
        }
    }

    public static boolean b(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static void c(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
            }
            if (i10 >= 16 && i10 < 29) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            } else if (i10 < 16) {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
        }
    }

    public static void d(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            c(sSLSocket);
            b(sSLSocket);
        }
    }

    public static boolean e(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return Build.VERSION.SDK_INT > 19 ? b(sSLSocket, f13946b) : b(sSLSocket, f13945a);
    }
}
