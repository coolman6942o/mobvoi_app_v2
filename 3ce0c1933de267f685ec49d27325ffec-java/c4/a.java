package c4;

import android.os.Environment;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class a {
    public static File a() {
        try {
            return (File) Environment.class.getMethod(new String(d4.a.a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5")), new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String c(Map<String, String> map, String str, String str2) {
        String str3;
        return (map == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    public static boolean d(String str) {
        int length;
        if (!(str == null || (length = str.length()) == 0)) {
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(str.charAt(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean e(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static String f(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean g(String str) {
        return !d(str);
    }

    public static boolean h(String str) {
        byte[] bytes;
        for (byte b10 : str.getBytes()) {
            if ((b10 >= 0 && b10 <= 31) || b10 >= Byte.MAX_VALUE) {
                return false;
            }
        }
        return true;
    }

    public static String i(String str) {
        return str == null ? "" : str;
    }

    public static String j(String str) {
        try {
            if (d(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < digest.length; i10++) {
                sb2.append(String.format("%02x", Byte.valueOf(digest[i10])));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String k(String str) {
        try {
            byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] bArr = new byte[byteArrayOutputStream.toByteArray().length + 4];
            System.arraycopy(array, 0, bArr, 0, 4);
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
            return Base64.encodeToString(bArr, 8);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l(String str) {
        if (d(str)) {
            return "";
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    return new String(Base64.encode(byteArray, 2));
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
