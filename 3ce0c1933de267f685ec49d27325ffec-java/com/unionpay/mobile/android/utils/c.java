package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.mobvoi.wear.providers.OtaColumn;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f24143a = new SimpleDateFormat("yyyyMMddhhmmss");

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f24144b = new d();

    /* renamed from: c  reason: collision with root package name */
    private static long[] f24145c = new long[256];

    static {
        for (int i10 = 0; i10 < 256; i10++) {
            long j10 = i10;
            for (int i11 = 0; i11 < 8; i11++) {
                j10 = (j10 >> 1) ^ ((((int) j10) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            f24145c[i10] = j10;
        }
    }

    public static String a() {
        return f24143a.format(new Date(System.currentTimeMillis()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
        if (com.unionpay.mobile.android.utils.PreferenceUtils.forConfig(r3, r2).equals(b(f(r8 + r1 + r9))) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        int i10;
        String a10 = PreferenceUtils.a(context, "configs");
        String a11 = PreferenceUtils.a(context, "mode");
        String a12 = PreferenceUtils.a(context, "or");
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12)) {
            try {
                JSONObject jSONObject = new JSONObject(a10);
                String a13 = j.a(jSONObject, "sign");
                try {
                    i10 = Integer.parseInt(a11);
                } catch (NumberFormatException unused) {
                    i10 = 0;
                }
                str = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str2 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
            } catch (Exception unused2) {
            }
        }
        str = "";
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                Object b10 = j.b(jSONArray, i11);
                if (b10 != null) {
                    JSONObject jSONObject2 = (JSONObject) b10;
                    if (OtaColumn.COLUMN_APP.equals(j.a(jSONObject2, "type"))) {
                        return new String(Base64.decode(j.a(jSONObject2, "ca"), 2));
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return "";
    }

    private static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb2.append(hexString.toUpperCase());
            if (i10 < bArr.length - 1) {
                sb2.append(':');
            }
        }
        return sb2.toString();
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return str.matches("[0-9A-Fa-f]+");
    }

    public static String b(Context context) {
        String str = f24144b.get(f.a(context));
        return !TextUtils.isEmpty(str) ? str : "1000";
    }

    public static String b(Context context, String str) {
        PackageInfo packageInfo;
        CertificateFactory certificateFactory;
        X509Certificate x509Certificate;
        try {
            String str2 = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
                packageInfo = null;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
            try {
                certificateFactory = CertificateFactory.getInstance("X509");
            } catch (CertificateException e11) {
                e11.printStackTrace();
                certificateFactory = null;
            }
            try {
                x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (CertificateException e12) {
                e12.printStackTrace();
                x509Certificate = null;
            }
            try {
                str2 = a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
            } catch (NoSuchAlgorithmException e13) {
                e13.printStackTrace();
            } catch (CertificateEncodingException e14) {
                e14.printStackTrace();
            }
            return str2.replaceAll(":", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        byte[] bytes;
        if (str == null) {
            return "";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb2 = new StringBuilder("");
        for (byte b10 : str.getBytes()) {
            sb2.append(charArray[(b10 & 240) >> 4]);
            sb2.append(charArray[b10 & 15]);
        }
        return sb2.toString().trim();
    }

    public static String c(String str) {
        try {
            return new BigDecimal(str).divide(new BigDecimal("100")).toString();
        } catch (Exception unused) {
            return "1";
        }
    }

    public static String d(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length() / 3; i10++) {
            sb2.append("cmd");
        }
        for (int i11 = 0; i11 < str.length() % 3; i11++) {
            sb2.append("cmd".charAt(i11));
        }
        byte[] bytes = str.getBytes();
        byte[] bytes2 = sb2.toString().getBytes();
        byte[] bArr = new byte[str.length()];
        for (int i12 = 0; i12 < bytes.length; i12++) {
            bArr[i12] = (byte) (bytes[i12] ^ bytes2[i12]);
        }
        return b.a(bArr);
    }

    public static String e(String str) {
        long j10;
        char[] charArray;
        if (str == null || str.length() == 0) {
            j10 = 0;
        } else {
            int length = str.length() * 2;
            byte[] bArr = new byte[length];
            int i10 = 0;
            for (char c10 : str.toCharArray()) {
                int i11 = i10 + 1;
                bArr[i10] = (byte) (c10 & 255);
                i10 = i11 + 1;
                bArr[i11] = (byte) (c10 >> '\b');
            }
            j10 = -1;
            for (int i12 = 0; i12 < length; i12++) {
                j10 = (j10 >> 8) ^ f24145c[(bArr[i12] ^ ((int) j10)) & 255];
            }
        }
        return Long.toHexString(j10);
    }

    private static String f(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(bytes);
            return b.a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }
}
