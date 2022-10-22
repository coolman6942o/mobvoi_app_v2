package com.mobvoi.android.common.utils;

import com.mobvoi.wear.lpa.LpaConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;
/* compiled from: DigestEncodingUtils.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f15429a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f15430b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static long a(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return crc32.getValue();
    }

    public static String b(byte[] bArr) {
        return d(bArr, true);
    }

    public static String c(byte[] bArr, int i10, int i11, boolean z10) {
        if (i11 > bArr.length) {
            i11 = bArr.length;
        }
        int i12 = i11 - i10;
        char[] cArr = z10 ? f15429a : f15430b;
        char[] cArr2 = new char[i12 * 2];
        int i13 = 0;
        while (i10 < i11) {
            int i14 = bArr[i10] & 255;
            cArr2[i13] = cArr[i14 >>> 4];
            cArr2[i13 + 1] = cArr[i14 & 15];
            i10++;
            i13 += 2;
        }
        return new String(cArr2);
    }

    public static String d(byte[] bArr, boolean z10) {
        return bArr == null ? LpaConstants.VALUE_NULL : c(bArr, 0, bArr.length, z10);
    }

    private static int e(String str, int i10) {
        char charAt = str.charAt(i10);
        if (charAt >= '0' && charAt <= '9') {
            return charAt - '0';
        }
        char c10 = 'a';
        if (charAt < 'a' || charAt > 'f') {
            c10 = 'A';
            if (charAt < 'A' || charAt > 'F') {
                throw new IllegalArgumentException("Not hex string: " + str);
            }
        }
        return (charAt - c10) + 10;
    }

    public static byte[] f(String str) {
        String replace = str.replace(" ", "");
        if (replace.length() % 2 == 0) {
            int length = replace.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((e(replace, i11 + 1) | (e(replace, i11) << 4)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Bad length: " + replace);
    }

    public static String g(String str, String str2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return h(str.getBytes("UTF-8"), str2);
    }

    public static String h(byte[] bArr, String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return d(messageDigest.digest(), false);
    }

    public static String i(File file) throws NoSuchAlgorithmException, IOException {
        Throwable th2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            String j10 = j(fileInputStream);
            j.a(fileInputStream);
            return j10;
        } catch (Throwable th4) {
            th2 = th4;
            fileInputStream2 = fileInputStream;
            j.a(fileInputStream2);
            throw th2;
        }
    }

    public static String j(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int read;
        if (inputStream != null) {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            do {
                read = inputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            return d(messageDigest.digest(), false);
        }
        throw new IllegalArgumentException("Invalid input stream!");
    }

    public static String k(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return g(str, "MD5");
    }

    public static String l(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return g(str, "SHA-1");
    }

    public static String m(byte[] bArr) throws NoSuchAlgorithmException {
        return h(bArr, "SHA-1");
    }
}
