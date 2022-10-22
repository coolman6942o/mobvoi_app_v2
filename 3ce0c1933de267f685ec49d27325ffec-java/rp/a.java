package rp;

import java.util.Arrays;
import kotlin.jvm.internal.i;
import okio.ByteString;
/* compiled from: -Base64.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f33651a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f33652b;

    static {
        ByteString.a aVar = ByteString.Companion;
        f33651a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f33652b = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] a(String decodeBase64ToArray) {
        int i10;
        char charAt;
        i.f(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((charAt = decodeBase64ToArray.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char charAt2 = decodeBase64ToArray.charAt(i15);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i10 = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i10 = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i10 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i10 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i10 = 63;
            } else {
                if (!(charAt2 == '\n' || charAt2 == '\r' || charAt2 == ' ' || charAt2 == '\t')) {
                    return null;
                }
            }
            i13 = (i13 << 6) | i10;
            i12++;
            if (i12 % 4 == 0) {
                int i16 = i14 + 1;
                bArr[i14] = (byte) (i13 >> 16);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i13 >> 8);
                i14 = i17 + 1;
                bArr[i17] = (byte) i13;
            }
        }
        int i18 = i12 % 4;
        if (i18 == 1) {
            return null;
        }
        if (i18 == 2) {
            i14++;
            bArr[i14] = (byte) ((i13 << 12) >> 16);
        } else if (i18 == 3) {
            int i19 = i13 << 6;
            int i20 = i14 + 1;
            bArr[i14] = (byte) (i19 >> 16);
            i14 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
        }
        if (i14 == i11) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i14);
        i.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final String b(byte[] encodeBase64, byte[] map) {
        i.f(encodeBase64, "$this$encodeBase64");
        i.f(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = encodeBase64[i10];
            int i13 = i12 + 1;
            byte b11 = encodeBase64[i12];
            i10 = i13 + 1;
            byte b12 = encodeBase64[i13];
            int i14 = i11 + 1;
            bArr[i11] = map[(b10 & 255) >> 2];
            int i15 = i14 + 1;
            bArr[i14] = map[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i16 = i15 + 1;
            bArr[i15] = map[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 = i16 + 1;
            bArr[i16] = map[b12 & 63];
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b13 = encodeBase64[i10];
            int i17 = i11 + 1;
            bArr[i11] = map[(b13 & 255) >> 2];
            int i18 = i17 + 1;
            bArr[i17] = map[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr[i18] = b14;
            bArr[i18 + 1] = b14;
        } else if (length2 == 2) {
            int i19 = i10 + 1;
            byte b15 = encodeBase64[i10];
            byte b16 = encodeBase64[i19];
            int i20 = i11 + 1;
            bArr[i11] = map[(b15 & 255) >> 2];
            int i21 = i20 + 1;
            bArr[i20] = map[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr[i21] = map[(b16 & 15) << 2];
            bArr[i21 + 1] = (byte) 61;
        }
        return b.b(bArr);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = f33651a;
        }
        return b(bArr, bArr2);
    }

    public static final byte[] d() {
        return f33652b;
    }
}
