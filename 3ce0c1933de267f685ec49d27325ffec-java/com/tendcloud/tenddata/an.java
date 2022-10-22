package com.tendcloud.tenddata;

import com.tendcloud.tenddata.l;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
/* compiled from: td */
/* loaded from: classes2.dex */
final class an {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22623a = 128;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22624b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static final String f22625c = "iv";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22626d = "salt";

    /* renamed from: e  reason: collision with root package name */
    private static final int f22627e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f22628f = 32;

    /* renamed from: g  reason: collision with root package name */
    private static final String f22629g = "AES/CBC/PKCS5Padding";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22630h = "PBKDF2WithHmacSHA1";

    /* renamed from: i  reason: collision with root package name */
    private static final String f22631i = "AES";

    an() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IvParameterSpec a() {
        try {
            l.b bVar = l.b.AES_IV_LOCK;
            l.getFileLock(bVar.toString());
            byte[] a10 = ap.a(f22625c, 16);
            if (a10 == null) {
                a10 = a(16);
                ap.a(f22625c, a10);
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a10);
            l.releaseFileLock(bVar.toString());
            return ivParameterSpec;
        } catch (Throwable unused) {
            l.releaseFileLock(l.b.AES_IV_LOCK.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        String str;
        byte[] bArr = null;
        try {
            l.b bVar = l.b.AES_SALT_LOCK;
            l.getFileLock(bVar.toString());
            bArr = ap.a(f22626d, 32);
            if (bArr == null || bArr.length == 0) {
                bArr = a(32);
                ap.a(f22626d, bArr);
            }
            str = bVar.toString();
        } catch (Throwable unused) {
            str = l.b.AES_SALT_LOCK.toString();
        }
        l.releaseFileLock(str);
        return bArr;
    }

    private static byte[] a(int i10) {
        byte[] bArr = new byte[i10];
        u.b().nextBytes(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(byte[] bArr, SecretKey secretKey, IvParameterSpec ivParameterSpec) {
        Cipher cipher = Cipher.getInstance(u.b(19) ? f22631i : f22629g);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SecretKey a(char[] cArr, byte[] bArr) {
        return SecretKeyFactory.getInstance(f22630h).generateSecret(new PBEKeySpec(cArr, bArr, f22624b, f22623a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, SecretKey secretKey, IvParameterSpec ivParameterSpec) {
        Cipher cipher = Cipher.getInstance(u.b(19) ? f22631i : f22629g);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }
}
