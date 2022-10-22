package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.a.e;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import n4.c;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class f {
    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 80; i10++) {
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
        }
    }

    public static e a() throws ay {
        return new e.b("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).b();
    }

    public static String b(long j10) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j10));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String c(Throwable th2) {
        Throwable th3;
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th2.printStackTrace(printWriter);
                    for (Throwable cause = th2.getCause(); cause != null; cause = cause.getCause()) {
                        cause.printStackTrace(printWriter);
                    }
                    String obj = stringWriter.toString();
                    try {
                        stringWriter.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        printWriter.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    return obj;
                } catch (Throwable th6) {
                    th3 = th6;
                    try {
                        th3.printStackTrace();
                        return null;
                    } finally {
                        if (stringWriter != null) {
                            try {
                                stringWriter.close();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th8) {
                                th8.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th9) {
                th3 = th9;
                printWriter = null;
            }
        } catch (Throwable th10) {
            th3 = th10;
            stringWriter = null;
            printWriter = null;
        }
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        String e10 = c.e(e(str));
        try {
            return ((char) ((e10.length() % 26) + 65)) + e10;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicKey g(Context context) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        Throwable th2;
        Certificate certificate;
        try {
            certificate = new ByteArrayInputStream(c.f("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                certificate = certificateFactory.generateCertificate(certificate);
                if (!(certificate == null || keyFactory == null)) {
                    PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
                    try {
                        certificate.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return generatePublic;
                }
                return null;
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    th2.printStackTrace();
                    if (certificate != null) {
                        try {
                            certificate.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return null;
                } finally {
                    if (certificate != null) {
                        try {
                            certificate.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th7) {
            th2 = th7;
            certificate = null;
        }
    }

    public static byte[] h() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                bArr[i10] = Byte.parseByte(split[i10]);
            }
            String[] split2 = new StringBuffer(new String(c.f(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i11 = 0; i11 < split2.length; i11++) {
                bArr2[i11] = Byte.parseByte(split2[i11]);
            }
            return bArr2;
        } catch (Throwable th2) {
            c.b(th2, "Utils", "getIV");
            return new byte[16];
        }
    }

    public static byte[] i(byte[] bArr) {
        try {
            return m(bArr);
        } catch (Throwable th2) {
            c.b(th2, "Utils", "gZip");
            return new byte[0];
        }
    }

    public static String j(String str) {
        return str.length() < 2 ? "" : c.a(str.substring(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(byte[] bArr) {
        try {
            return l(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String l(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private static byte[] m(byte[] bArr) throws IOException, Throwable {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream2.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th3) {
                    th2 = th3;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        throw th2;
                    } catch (Throwable th4) {
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
            }
        } catch (Throwable th6) {
            th2 = th6;
            byteArrayOutputStream = null;
        }
    }
}
