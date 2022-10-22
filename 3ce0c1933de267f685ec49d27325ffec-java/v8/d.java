package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
import com.google.zxing.h;
import com.google.zxing.i;
import com.realsil.sdk.dfu.DfuException;
import java.util.Arrays;
import java.util.Map;
/* compiled from: Code93Reader.java */
/* loaded from: classes.dex */
public final class d extends k {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f35645c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    static final int[] f35646d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f35647e;

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f35648a = new StringBuilder(20);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f35649b = new int[6];

    static {
        int[] iArr = {DfuException.ERROR_REQUEST_MTU_NO_CALLBACK, 328, 324, 322, 296, 292, 290, 336, DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f35646d = iArr;
        f35647e = iArr[47];
    }

    private static void g(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        h(charSequence, length - 2, 20);
        h(charSequence, length - 1, 15);
    }

    private static void h(CharSequence charSequence, int i10, int i11) throws ChecksumException {
        int i12 = 0;
        int i13 = 1;
        for (int i14 = i10 - 1; i14 >= 0; i14--) {
            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i10) != f35645c[i12 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String i(CharSequence charSequence) throws FormatException {
        char c10;
        int i10;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 'a' || charAt > 'd') {
                sb2.append(charAt);
            } else if (i11 < length - 1) {
                i11++;
                char charAt2 = charSequence.charAt(i11);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i10 = charAt2 - '@';
                            c10 = (char) i10;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i10 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i10 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i10 = charAt2 + 16;
                        } else if (charAt2 < 'P' || charAt2 > 'S') {
                            if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                c10 = 127;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else {
                            i10 = charAt2 + '+';
                        }
                        c10 = (char) i10;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i10 = charAt2 - ' ';
                            c10 = (char) i10;
                            break;
                        } else if (charAt2 == 'Z') {
                            c10 = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i10 = charAt2 + ' ';
                            c10 = (char) i10;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c10 = 0;
                        break;
                }
                sb2.append(c10);
            } else {
                throw FormatException.getFormatInstance();
            }
            i11++;
        }
        return sb2.toString();
    }

    private int[] j(a aVar) throws NotFoundException {
        int g10 = aVar.g();
        int e10 = aVar.e(0);
        Arrays.fill(this.f35649b, 0);
        int[] iArr = this.f35649b;
        int length = iArr.length;
        boolean z10 = false;
        int i10 = 0;
        int i11 = e10;
        while (e10 < g10) {
            if (aVar.c(e10) ^ z10) {
                iArr[i10] = iArr[i10] + 1;
            } else {
                int i12 = length - 1;
                if (i10 != i12) {
                    i10++;
                } else if (l(iArr) == f35647e) {
                    return new int[]{i11, e10};
                } else {
                    i11 += iArr[0] + iArr[1];
                    int i13 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i12] = 0;
                    i10--;
                }
                iArr[i10] = 1;
                z10 = !z10;
            }
            e10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char k(int i10) throws NotFoundException {
        int i11 = 0;
        while (true) {
            int[] iArr = f35646d;
            if (i11 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            } else if (iArr[i11] == i10) {
                return f35645c[i11];
            } else {
                i11++;
            }
        }
    }

    private static int l(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int round = Math.round((iArr[i13] * 9.0f) / i10);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < round; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= round;
            }
        }
        return i12;
    }

    @Override // v8.k
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] j10;
        int e10 = aVar.e(j(aVar)[1]);
        int g10 = aVar.g();
        int[] iArr = this.f35649b;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f35648a;
        sb2.setLength(0);
        while (true) {
            k.e(aVar, e10, iArr);
            int l10 = l(iArr);
            if (l10 >= 0) {
                char k10 = k(l10);
                sb2.append(k10);
                int i11 = e10;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int e11 = aVar.e(i11);
                if (k10 == '*') {
                    sb2.deleteCharAt(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    if (e11 == g10 || !aVar.c(e11)) {
                        throw NotFoundException.getNotFoundInstance();
                    } else if (sb2.length() >= 2) {
                        g(sb2);
                        sb2.setLength(sb2.length() - 2);
                        float f10 = i10;
                        return new h(i(sb2), null, new i[]{new i((j10[1] + j10[0]) / 2.0f, f10), new i(e10 + (i13 / 2.0f), f10)}, BarcodeFormat.CODE_93);
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    e10 = e11;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
