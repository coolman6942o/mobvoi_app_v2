package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
import com.google.zxing.h;
import com.google.zxing.i;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: Code128Reader.java */
/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a  reason: collision with root package name */
    static final int[][] f35638a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int g(a aVar, int[] iArr, int i10) throws NotFoundException {
        k.e(aVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f35638a;
            if (i12 >= iArr2.length) {
                break;
            }
            float d10 = k.d(iArr, iArr2[i12], 0.7f);
            if (d10 < f10) {
                i11 = i12;
                f10 = d10;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] h(a aVar) throws NotFoundException {
        int g10 = aVar.g();
        int e10 = aVar.e(0);
        int[] iArr = new int[6];
        boolean z10 = false;
        int i10 = 0;
        int i11 = e10;
        while (e10 < g10) {
            if (aVar.c(e10) ^ z10) {
                iArr[i10] = iArr[i10] + 1;
            } else {
                if (i10 == 5) {
                    float f10 = 0.25f;
                    int i12 = -1;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float d10 = k.d(iArr, f35638a[i13], 0.7f);
                        if (d10 < f10) {
                            i12 = i13;
                            f10 = d10;
                        }
                    }
                    if (i12 >= 0 && aVar.i(Math.max(0, i11 - ((e10 - i11) / 2)), i11, false)) {
                        return new int[]{i11, e10, i12};
                    }
                    i11 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i10--;
                } else {
                    i10++;
                }
                iArr[i10] = 1;
                z10 = !z10;
            }
            e10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e2, code lost:
        if (r9 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012a, code lost:
        if (r9 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0131 A[PHI: r17 
      PHI: (r17v11 boolean) = (r17v16 boolean), (r17v18 boolean) binds: [B:64:0x010a, B:43:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013d A[PHI: r16 r17 
      PHI: (r16v5 boolean) = (r16v6 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean) binds: [B:81:0x013b, B:64:0x010a, B:65:0x010e, B:69:0x011a, B:68:0x0116, B:43:0x00c2, B:44:0x00c7, B:48:0x00d4, B:47:0x00cf] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r17v9 boolean) = (r17v10 boolean), (r17v16 boolean), (r17v16 boolean), (r17v16 boolean), (r17v16 boolean), (r17v18 boolean), (r17v18 boolean), (r17v18 boolean), (r17v18 boolean) binds: [B:81:0x013b, B:64:0x010a, B:65:0x010e, B:69:0x011a, B:68:0x0116, B:43:0x00c2, B:44:0x00c7, B:48:0x00d4, B:47:0x00cf] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // v8.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c10;
        char c11;
        boolean z10;
        boolean z11 = false;
        boolean z12 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] h10 = h(aVar);
        int i11 = h10[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i11));
        switch (i11) {
            case 103:
                c10 = 'e';
                break;
            case 104:
                c10 = 'd';
                break;
            case 105:
                c10 = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb2 = new StringBuilder(20);
        int i12 = 6;
        int[] iArr = new int[6];
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z16 = true;
        char c12 = c10;
        int i16 = h10[0];
        int i17 = h10[1];
        while (!z14) {
            int g10 = g(aVar, iArr, i17);
            arrayList.add(Byte.valueOf((byte) g10));
            if (g10 != 106) {
                z16 = true;
            }
            if (g10 != 106) {
                i14++;
                i11 += i14 * g10;
            }
            int i18 = i17;
            for (int i19 = 0; i19 < i12; i19++) {
                i18 += iArr[i19];
            }
            switch (g10) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c12) {
                        case 'c':
                            c11 = 'd';
                            if (g10 >= 100) {
                                if (g10 != 106) {
                                    z16 = false;
                                }
                                if (g10 != 106) {
                                    switch (g10) {
                                        case 100:
                                            c12 = 'd';
                                            break;
                                        case 101:
                                            z10 = false;
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb2.length() == 0) {
                                                    sb2.append("]C1");
                                                    break;
                                                } else {
                                                    sb2.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z10 = false;
                                    z14 = true;
                                    break;
                                }
                            } else {
                                if (g10 < 10) {
                                    sb2.append('0');
                                }
                                sb2.append(g10);
                            }
                            z10 = false;
                            break;
                        case 'd':
                            if (g10 < 96) {
                                if (z13 == z11) {
                                    sb2.append((char) (g10 + 32));
                                } else {
                                    sb2.append((char) (g10 + 32 + 128));
                                }
                                z10 = false;
                                z13 = false;
                                c11 = 'd';
                                break;
                            } else {
                                if (g10 != 106) {
                                    z16 = false;
                                }
                                if (g10 != 106) {
                                    switch (g10) {
                                        case 96:
                                        case 97:
                                        default:
                                            z10 = false;
                                            c11 = 'd';
                                            break;
                                        case 98:
                                            z10 = true;
                                            c11 = 'd';
                                            c12 = 'e';
                                            break;
                                        case 99:
                                            z10 = false;
                                            c11 = 'd';
                                            c12 = 'c';
                                            break;
                                        case 100:
                                            if (z11 || !z13) {
                                                if (z11) {
                                                }
                                                z10 = false;
                                                z13 = true;
                                                c11 = 'd';
                                                break;
                                            }
                                            z11 = true;
                                            z10 = false;
                                            z13 = false;
                                            c11 = 'd';
                                            break;
                                        case 101:
                                            z10 = false;
                                            c11 = 'd';
                                            c12 = 'e';
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb2.length() == 0) {
                                                    sb2.append("]C1");
                                                } else {
                                                    sb2.append((char) 29);
                                                }
                                            }
                                            z10 = false;
                                            c11 = 'd';
                                            break;
                                    }
                                }
                                z14 = true;
                                z10 = false;
                                c11 = 'd';
                            }
                            break;
                        case 'e':
                            if (g10 < 64) {
                                if (z13 == z11) {
                                    sb2.append((char) (g10 + 32));
                                } else {
                                    sb2.append((char) (g10 + 32 + 128));
                                }
                            } else if (g10 >= 96) {
                                if (g10 != 106) {
                                    z16 = false;
                                }
                                if (g10 != 106) {
                                    switch (g10) {
                                        case 98:
                                            z10 = true;
                                            c11 = 'd';
                                            c12 = 'd';
                                            break;
                                        case 100:
                                            z10 = false;
                                            c11 = 'd';
                                            c12 = 'd';
                                            break;
                                        case 101:
                                            if (z11 || !z13) {
                                                if (z11) {
                                                }
                                                z10 = false;
                                                z13 = true;
                                                c11 = 'd';
                                                break;
                                            }
                                            z11 = true;
                                            break;
                                        case 102:
                                            if (z12) {
                                                if (sb2.length() == 0) {
                                                    sb2.append("]C1");
                                                } else {
                                                    sb2.append((char) 29);
                                                }
                                            }
                                            z10 = false;
                                            c11 = 'd';
                                            break;
                                    }
                                }
                                z14 = true;
                                z10 = false;
                                c11 = 'd';
                            } else if (z13 == z11) {
                                sb2.append((char) (g10 - 64));
                            } else {
                                sb2.append((char) (g10 + 64));
                            }
                            z10 = false;
                            z13 = false;
                            c11 = 'd';
                            break;
                        default:
                            c11 = 'd';
                            z10 = false;
                            break;
                    }
                    if (z15) {
                        c12 = c12 == 'e' ? c11 : 'e';
                    }
                    z15 = z10;
                    i12 = 6;
                    i16 = i17;
                    i17 = i18;
                    i15 = i13;
                    i13 = g10;
                    break;
            }
        }
        int i20 = i17 - i16;
        int f10 = aVar.f(i17);
        if (aVar.i(f10, Math.min(aVar.g(), ((f10 - i16) / 2) + f10), false)) {
            int i21 = i15;
            if ((i11 - (i14 * i21)) % 103 == i21) {
                int length = sb2.length();
                if (length != 0) {
                    if (length > 0 && z16) {
                        if (c12 == 'c') {
                            sb2.delete(length - 2, length);
                        } else {
                            sb2.delete(length - 1, length);
                        }
                    }
                    float f11 = (h10[1] + h10[0]) / 2.0f;
                    float f12 = i16 + (i20 / 2.0f);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i22 = 0; i22 < size; i22++) {
                        bArr[i22] = ((Byte) arrayList.get(i22)).byteValue();
                    }
                    float f13 = i10;
                    return new h(sb2.toString(), bArr, new i[]{new i(f11, f13), new i(f12, f13)}, BarcodeFormat.CODE_128);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw ChecksumException.getChecksumInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
