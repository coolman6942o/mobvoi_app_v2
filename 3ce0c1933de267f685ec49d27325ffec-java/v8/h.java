package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
import com.google.zxing.i;
import java.util.Map;
/* compiled from: ITFReader.java */
/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f35655b = {6, 8, 10, 12, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f35656c = {1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f35657d = {1, 1, 3};

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f35658e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a  reason: collision with root package name */
    private int f35659a = -1;

    private static int g(int[] iArr) throws NotFoundException {
        int length = f35658e.length;
        float f10 = 0.38f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float d10 = k.d(iArr, f35658e[i11], 0.78f);
            if (d10 < f10) {
                i10 = i11;
                f10 = d10;
            }
        }
        if (i10 >= 0) {
            return i10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] h(a aVar) throws NotFoundException {
        aVar.k();
        try {
            int[] k10 = k(aVar, l(aVar), f35657d);
            m(aVar, k10[0]);
            int i10 = k10[0];
            k10[0] = aVar.g() - k10[1];
            k10[1] = aVar.g() - i10;
            return k10;
        } finally {
            aVar.k();
        }
    }

    private static void i(a aVar, int i10, int i11, StringBuilder sb2) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            k.e(aVar, i10, iArr);
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                iArr2[i12] = iArr[i13];
                iArr3[i12] = iArr[i13 + 1];
            }
            sb2.append((char) (g(iArr2) + 48));
            sb2.append((char) (g(iArr3) + 48));
            for (int i14 = 0; i14 < 10; i14++) {
                i10 += iArr[i14];
            }
        }
    }

    private int[] j(a aVar) throws NotFoundException {
        int[] k10 = k(aVar, l(aVar), f35656c);
        this.f35659a = (k10[1] - k10[0]) / 4;
        m(aVar, k10[0]);
        return k10;
    }

    private static int[] k(a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int g10 = aVar.g();
        int i11 = i10;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < g10) {
            if (aVar.c(i10) ^ z10) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                int i13 = length - 1;
                if (i12 != i13) {
                    i12++;
                } else if (k.d(iArr2, iArr, 0.78f) < 0.38f) {
                    return new int[]{i11, i10};
                } else {
                    i11 += iArr2[0] + iArr2[1];
                    int i14 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int l(a aVar) throws NotFoundException {
        int g10 = aVar.g();
        int e10 = aVar.e(0);
        if (e10 != g10) {
            return e10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m(a aVar, int i10) throws NotFoundException {
        int i11 = this.f35659a * 10;
        if (i11 >= i10) {
            i11 = i10;
        }
        for (int i12 = i10 - 1; i11 > 0 && i12 >= 0 && !aVar.c(i12); i12--) {
            i11--;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // v8.k
    public com.google.zxing.h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z10;
        int[] j10 = j(aVar);
        int[] h10 = h(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        i(aVar, j10[1], h10[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f35655b;
        }
        int length = sb3.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= length2) {
                z10 = false;
                break;
            }
            int i13 = iArr[i11];
            if (length == i13) {
                z10 = true;
                break;
            }
            if (i13 > i12) {
                i12 = i13;
            }
            i11++;
        }
        if (!z10 && length > i12) {
            z10 = true;
        }
        if (z10) {
            float f10 = i10;
            return new com.google.zxing.h(sb3, null, new i[]{new i(j10[1], f10), new i(h10[0], f10)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }
}
