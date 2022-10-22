package d4;

import c4.a;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f25133a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";

    public static String a() {
        String str = new String();
        for (int i10 = 0; i10 < f25133a.length() - 1; i10 += 4) {
            str = str + f25133a.charAt(i10);
        }
        return str;
    }

    public static String b(String str, String str2) {
        try {
            PBEKeySpec d10 = d(str);
            byte[] bytes = str2.getBytes();
            byte[] f10 = f();
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(d10).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(f10));
            byte[] salt = d10.getSalt();
            ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
            allocate.put(salt);
            cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
            return c(allocate.array());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b10 : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b10 >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b10 & 15));
        }
        return stringBuffer.toString();
    }

    public static PBEKeySpec d(String str) {
        Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
        Object newInstance = cls.newInstance();
        byte[] bArr = new byte[16];
        Method method = cls.getMethod("nextBytes", bArr.getClass());
        method.setAccessible(true);
        method.invoke(newInstance, bArr);
        return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
    }

    public static String e(String str, String str2) {
        byte[] bArr;
        try {
            PBEKeySpec d10 = d(str);
            int length = str2.length() / 2;
            byte[] bArr2 = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr2[i10] = Integer.valueOf(str2.substring(i11, i11 + 2), 16).byteValue();
            }
            byte[] f10 = f();
            if (length <= 16) {
                bArr = null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(d10.getPassword(), Arrays.copyOf(bArr2, 16), 10, 128)).getEncoded(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(f10));
                bArr = cipher.doFinal(bArr2, 16, length - 16);
            }
        } catch (Exception unused) {
        }
        if (bArr != null) {
            String str3 = new String(bArr);
            if (a.h(str3)) {
                return str3;
            }
            return null;
        }
        throw new Exception();
    }

    public static byte[] f() {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 48; i10 += 2) {
                sb2.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i10));
            }
            return a.a(sb2.toString());
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
