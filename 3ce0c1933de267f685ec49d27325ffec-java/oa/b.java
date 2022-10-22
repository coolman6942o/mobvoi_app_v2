package oa;

import com.mobvoi.wear.lpa.LpaConstants;
import kotlin.jvm.internal.i;
/* compiled from: ByteUtils.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31485a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f31486b;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        i.e(charArray, "(this as java.lang.String).toCharArray()");
        f31486b = charArray;
    }

    private b() {
    }

    public final String a(byte[] bArr) {
        if (bArr == null) {
            return LpaConstants.VALUE_NULL;
        }
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = i10 + 1;
                int i12 = bArr[i10] & 255;
                int i13 = i10 * 2;
                char[] cArr2 = f31486b;
                cArr[i13] = cArr2[i12 >>> 4];
                cArr[i13 + 1] = cArr2[i12 & 15];
                if (i11 > length) {
                    break;
                }
                i10 = i11;
            }
        }
        return new String(cArr);
    }

    public final int b(byte[] src, int i10) {
        i.f(src, "src");
        if (i10 >= src.length - 1) {
            return -1;
        }
        return ((src[i10 + 1] << 8) & 65280) | (src[i10] & 255);
    }
}
