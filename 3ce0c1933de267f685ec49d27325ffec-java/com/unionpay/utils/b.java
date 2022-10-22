package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.mobvoi.wear.providers.OtaColumn;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap f24582a = new c();

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
        if (r0.equals(r9) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        int i10;
        String a10 = UPUtils.a(context, "configs");
        String a11 = UPUtils.a(context, "mode");
        String a12 = UPUtils.a(context, "or");
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(a11) && !TextUtils.isEmpty(a12)) {
            try {
                JSONObject jSONObject = new JSONObject(a10);
                String a13 = i.a(jSONObject, "sign");
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
                String a14 = a(UPUtils.a(str + str2 + a12));
                String forConfig = UPUtils.forConfig(i10, a13);
                if (!TextUtils.isEmpty(forConfig)) {
                }
            } catch (Exception unused2) {
            }
        }
        str = "";
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                Object a15 = i.a(jSONArray, i11);
                if (a15 != null) {
                    JSONObject jSONObject2 = (JSONObject) a15;
                    if (OtaColumn.COLUMN_APP.equals(i.a(jSONObject2, "type"))) {
                        return new String(Base64.decode(i.a(jSONObject2, "ca"), 2));
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return "";
    }

    public static String a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return byteArrayOutputStream.toString(str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static String a(String str) {
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

    public static boolean a() {
        try {
            return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
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
        return !TextUtils.isEmpty((CharSequence) f24582a.get(str)) ? (String) f24582a.get(str) : str;
    }

    public static String c(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return "";
    }

    public static final boolean c(String str) {
        return !Pattern.compile("[^0-9]+").matcher(str).find();
    }

    public static boolean d(Context context, String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return packageInfo != null;
    }
}
