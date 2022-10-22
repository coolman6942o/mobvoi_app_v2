package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.Arrays;
import java.util.Map;
/* compiled from: CodaBarReader.java */
/* loaded from: classes.dex */
public final class a extends k {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f35632d = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: e  reason: collision with root package name */
    static final int[] f35633e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f35634f = {'A', 'B', 'C', 'D'};

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f35635a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    private int[] f35636b = new int[80];

    /* renamed from: c  reason: collision with root package name */
    private int f35637c = 0;

    static boolean g(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }

    private void h(int i10) {
        int[] iArr = this.f35636b;
        int i11 = this.f35637c;
        iArr[i11] = i10;
        int i12 = i11 + 1;
        this.f35637c = i12;
        if (i12 >= iArr.length) {
            int[] iArr2 = new int[i12 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f35636b = iArr2;
        }
    }

    private int i() throws NotFoundException {
        for (int i10 = 1; i10 < this.f35637c; i10 += 2) {
            int k10 = k(i10);
            if (k10 != -1 && g(f35634f, f35632d[k10])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f35636b[i12];
                }
                if (i10 == 1 || this.f35636b[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void j(com.google.zxing.common.a aVar) throws NotFoundException {
        int i10 = 0;
        this.f35637c = 0;
        int f10 = aVar.f(0);
        int g10 = aVar.g();
        if (f10 < g10) {
            boolean z10 = true;
            while (f10 < g10) {
                if (aVar.c(f10) ^ z10) {
                    i10++;
                } else {
                    h(i10);
                    z10 = !z10;
                    i10 = 1;
                }
                f10++;
            }
            h(i10);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int k(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f35637c) {
            return -1;
        }
        int[] iArr = this.f35636b;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = Integer.MAX_VALUE;
        int i15 = 0;
        for (int i16 = i10; i16 < i11; i16 += 2) {
            int i17 = iArr[i16];
            if (i17 < i14) {
                i14 = i17;
            }
            if (i17 > i15) {
                i15 = i17;
            }
        }
        int i18 = (i14 + i15) / 2;
        int i19 = 0;
        for (int i20 = i10 + 1; i20 < i11; i20 += 2) {
            int i21 = iArr[i20];
            if (i21 < i12) {
                i12 = i21;
            }
            if (i21 > i19) {
                i19 = i21;
            }
        }
        int i22 = (i12 + i19) / 2;
        int i23 = 128;
        int i24 = 0;
        for (int i25 = 0; i25 < 7; i25++) {
            i23 >>= 1;
            if (iArr[i10 + i25] > ((i25 & 1) == 0 ? i18 : i22)) {
                i24 |= i23;
            }
        }
        while (true) {
            int[] iArr2 = f35633e;
            if (i13 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i13] == i24) {
                return i13;
            }
            i13++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ad, code lost:
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(int i10) throws NotFoundException {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f35635a.length() - 1;
        int i11 = 0;
        int i12 = i10;
        int i13 = 0;
        while (true) {
            int i14 = f35633e[this.f35635a.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) << 1);
                iArr[i16] = iArr[i16] + this.f35636b[i12 + i15];
                iArr2[i16] = iArr2[i16] + 1;
                i14 >>= 1;
            }
            if (i13 >= length) {
                break;
            }
            i12 += 8;
            i13++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i17 = 0; i17 < 2; i17++) {
            fArr2[i17] = 0.0f;
            int i18 = i17 + 2;
            fArr2[i18] = ((iArr[i17] / iArr2[i17]) + (iArr[i18] / iArr2[i18])) / 2.0f;
            fArr[i17] = fArr2[i18];
            fArr[i18] = ((iArr[i18] * 2.0f) + 1.5f) / iArr2[i18];
        }
        loop3: while (true) {
            int i19 = f35633e[this.f35635a.charAt(i11)];
            for (int i20 = 6; i20 >= 0; i20--) {
                int i21 = (i20 & 1) + ((i19 & 1) << 1);
                float f10 = this.f35636b[i10 + i20];
                if (f10 < fArr2[i21] || f10 > fArr[i21]) {
                    break loop3;
                }
                i19 >>= 1;
            }
            if (i11 < length) {
                i10 += 8;
                i11++;
            } else {
                return;
            }
        }
    }

    @Override // v8.k
    public h b(int i10, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.f35636b, 0);
        j(aVar);
        int i11 = i();
        this.f35635a.setLength(0);
        int i12 = i11;
        do {
            int k10 = k(i12);
            if (k10 != -1) {
                this.f35635a.append((char) k10);
                i12 += 8;
                if (this.f35635a.length() > 1 && g(f35634f, f35632d[k10])) {
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (i12 < this.f35637c);
        int i13 = i12 - 1;
        int i14 = this.f35636b[i13];
        int i15 = 0;
        for (int i16 = -8; i16 < -1; i16++) {
            i15 += this.f35636b[i12 + i16];
        }
        if (i12 >= this.f35637c || i14 >= i15 / 2) {
            l(i11);
            for (int i17 = 0; i17 < this.f35635a.length(); i17++) {
                StringBuilder sb2 = this.f35635a;
                sb2.setCharAt(i17, f35632d[sb2.charAt(i17)]);
            }
            char charAt = this.f35635a.charAt(0);
            char[] cArr = f35634f;
            if (g(cArr, charAt)) {
                StringBuilder sb3 = this.f35635a;
                if (!g(cArr, sb3.charAt(sb3.length() - 1))) {
                    throw NotFoundException.getNotFoundInstance();
                } else if (this.f35635a.length() > 3) {
                    if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                        StringBuilder sb4 = this.f35635a;
                        sb4.deleteCharAt(sb4.length() - 1);
                        this.f35635a.deleteCharAt(0);
                    }
                    int i18 = 0;
                    for (int i19 = 0; i19 < i11; i19++) {
                        i18 += this.f35636b[i19];
                    }
                    float f10 = i18;
                    while (i11 < i13) {
                        i18 += this.f35636b[i11];
                        i11++;
                    }
                    float f11 = i10;
                    return new h(this.f35635a.toString(), null, new i[]{new i(f10, f11), new i(i18, f11)}, BarcodeFormat.CODABAR);
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
