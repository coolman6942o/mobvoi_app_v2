package com.unionpay.mobile.android.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f24136a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f24137b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f24138c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f24139d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f24140e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f24141f = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f24142g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private a() {
    }

    public static byte[] a(String str) throws IOException {
        return b(str);
    }

    private static byte[] a(byte[] bArr, int i10) throws IOException {
        int i11;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        int i12 = i10 + 0;
        int i13 = 1;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i10)));
        } else if (i10 == 0) {
            return new byte[0];
        } else {
            if (i10 >= 4) {
                byte[] bArr2 = f24138c;
                int i14 = (i10 * 3) / 4;
                byte[] bArr3 = new byte[i14];
                byte[] bArr4 = new byte[4];
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i15 < i12) {
                    byte b10 = bArr2[bArr[i15] & 255];
                    if (b10 >= -5) {
                        if (b10 >= -1) {
                            int i18 = i16 + 1;
                            bArr4[i16] = bArr[i15];
                            if (i18 <= 3) {
                                i16 = i18;
                            } else if (i17 < 0 || (i11 = i17 + 2) >= i14) {
                                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i14), Integer.valueOf(i17)));
                            } else {
                                byte[] bArr5 = f24138c;
                                if (bArr4[2] == 61) {
                                    bArr3[i17] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i13]] & 255) << 12)) >>> 16);
                                } else if (bArr4[3] == 61) {
                                    int i19 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i13]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                    bArr3[i17] = (byte) (i19 >>> 16);
                                    bArr3[i17 + 1] = (byte) (i19 >>> 8);
                                    i13 = 2;
                                } else {
                                    int i20 = ((bArr5[bArr4[i13]] & 255) << 12) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[2]] & 255) << 6) | (bArr5[bArr4[3]] & 255);
                                    bArr3[i17] = (byte) (i20 >> 16);
                                    bArr3[i17 + 1] = (byte) (i20 >> 8);
                                    bArr3[i11] = (byte) i20;
                                    i13 = 3;
                                }
                                i17 += i13;
                                if (bArr[i15] == 61) {
                                    break;
                                }
                                i16 = 0;
                            }
                        }
                        i15++;
                        i13 = 1;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i15] & 255), Integer.valueOf(i15)));
                    }
                }
                byte[] bArr6 = new byte[i17];
                System.arraycopy(bArr3, 0, bArr6, 0, i17);
                return bArr6;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i10);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0052 -> B:52:0x0052). Please submit an issue!!! */
    private static byte[] b(String str) throws IOException {
        byte[] bArr;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        IOException e10;
        Objects.requireNonNull(str, "Input string was null.");
        try {
            bArr = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        byte[] a10 = a(bArr, bArr.length);
        if (a10.length >= 4 && 35615 == ((a10[0] & 255) | ((a10[1] << 8) & 65280))) {
            byte[] bArr2 = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(a10);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr2);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr2, 0, read);
                                } catch (IOException e11) {
                                    e10 = e11;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        e10.printStackTrace();
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        byteArrayInputStream.close();
                                        return a10;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (Exception unused4) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            a10 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                        } catch (IOException e12) {
                            e10 = e12;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e13) {
                        e10 = e13;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (Exception unused5) {
                }
            } catch (IOException e14) {
                e10 = e14;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused7) {
            }
        }
        return a10;
    }
}
