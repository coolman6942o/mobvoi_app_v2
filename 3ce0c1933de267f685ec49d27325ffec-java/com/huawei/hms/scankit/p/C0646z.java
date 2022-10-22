package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: Code128Reader.java */
/* renamed from: com.huawei.hms.scankit.p.z  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0646z extends H {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f15021a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static boolean a(C0591h hVar, int i10, int i11) {
        return hVar.a(i10, i11, false, false);
    }

    private static float b(C0591h hVar, int[] iArr, int i10) {
        int[] iArr2 = new int[7];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i11 : iArr) {
            i10 += i11;
        }
        boolean z10 = true;
        int i12 = 0;
        while (z10 && i10 < hVar.d()) {
            if (hVar.a(i10)) {
                i12++;
                i10++;
            } else {
                iArr2[6] = i12;
                z10 = false;
            }
        }
        int[][] iArr3 = f15021a;
        return H.a(iArr2, iArr3[iArr3.length - 1], 0.7f);
    }

    private int[] c(StringBuilder sb2, int[] iArr) throws C0550a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i10 < 100) {
            if (i10 < 10) {
                sb2.append('0');
            }
            sb2.append(i10);
        } else {
            if (i10 != 106) {
                i13 = 0;
            }
            if (i10 != 106) {
                switch (i10) {
                    case 100:
                        i14 = 100;
                        break;
                    case 101:
                        i14 = 101;
                        break;
                    case 102:
                        break;
                    default:
                        throw C0550a.a();
                }
            } else {
                i16 = 1;
            }
        }
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }

    private static int[] a(C0591h hVar) throws C0550a {
        int d10 = hVar.d();
        int b10 = hVar.b(0);
        int[] iArr = new int[6];
        boolean z10 = false;
        int i10 = 0;
        int i11 = b10;
        while (b10 < d10) {
            if (hVar.a(b10) != z10) {
                iArr[i10] = iArr[i10] + 1;
            } else {
                if (i10 == 5) {
                    float f10 = 0.25f;
                    int i12 = -1;
                    for (int i13 = 103; i13 <= 105; i13++) {
                        float a10 = H.a(iArr, f15021a[i13], 0.7f);
                        if (a10 < f10) {
                            i12 = i13;
                            f10 = a10;
                        }
                    }
                    if (i12 >= 0) {
                        return new int[]{i11, b10, i12};
                    }
                    i11 += iArr[0] + iArr[1];
                    int i14 = i10 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i14);
                    iArr[i14] = 0;
                    iArr[i10] = 0;
                    i10--;
                } else {
                    i10++;
                }
                iArr[i10] = 1;
                z10 = !z10;
            }
            b10++;
        }
        throw C0550a.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int[] b(StringBuilder sb2, int[] iArr) throws C0550a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        i14 = 101;
        if (i10 < 96) {
            if (i11 == i12) {
                sb2.append((char) (i10 + 32));
            } else {
                sb2.append((char) (i10 + 32 + 128));
            }
            i11 = 0;
        } else {
            if (i10 != 106) {
                i13 = 0;
            }
            if (i10 != 106) {
                switch (i10) {
                    case 96:
                    case 97:
                    case 102:
                        break;
                    case 98:
                        i15 = 1;
                        break;
                    case 99:
                        i14 = 99;
                        break;
                    case 100:
                        if (i12 != 0 || i11 == 0) {
                            if (i12 != 0 && i11 != 0) {
                                i11 = 0;
                                i12 = 0;
                                break;
                            } else {
                                i11 = 1;
                                break;
                            }
                        } else {
                            i11 = 0;
                            i12 = 1;
                            break;
                        }
                    case 101:
                        break;
                    default:
                        throw C0550a.a();
                }
            } else {
                i16 = 1;
            }
        }
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }

    private static int a(C0591h hVar, int[] iArr, int i10) throws C0550a {
        float f10;
        H.a(hVar, i10, iArr);
        float f11 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f15021a;
            if (i12 >= iArr2.length) {
                break;
            }
            int[] iArr3 = iArr2[i12];
            if (i12 == iArr2.length - 1) {
                f10 = b(hVar, iArr, i10);
            } else {
                f10 = H.a(iArr, iArr3, 0.7f);
            }
            if (f10 < f11) {
                i11 = i12;
                f11 = f10;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        int[] a10 = a(hVar);
        int i11 = a10[0] - (((a10[1] - a10[0]) / 11) * 10);
        if (i11 > 0 && i11 < a10[0]) {
            if (!a(hVar, i11, a10[0])) {
                throw C0550a.a();
            }
        }
        int i12 = a10[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i12));
        int i13 = i12 == 103 ? 101 : i12 == 104 ? 100 : i12 == 105 ? 99 : 0;
        if (i13 != 0) {
            StringBuilder sb2 = new StringBuilder(20);
            int[] iArr = new int[7];
            iArr[6] = i13;
            a(sb2, a10, iArr, i12, hVar, arrayList);
            int i14 = iArr[0];
            int i15 = iArr[1];
            int i16 = iArr[2];
            int i17 = iArr[3];
            int i18 = iArr[4];
            boolean z10 = iArr[5] == 1;
            int i19 = iArr[6];
            int i20 = i15 - i14;
            if ((i17 - (i18 * i16)) % 103 == i16) {
                int length = sb2.length();
                if (length != 0) {
                    if (length > 0 && z10) {
                        if (i19 == 99) {
                            sb2.delete(length - 2, length);
                        } else {
                            sb2.delete(length - 1, length);
                        }
                    }
                    float f10 = a10[0];
                    float f11 = i14 + ((i20 * 13) / 11);
                    int size = arrayList.size();
                    byte[] bArr = new byte[size];
                    for (int i21 = 0; i21 < size; i21++) {
                        bArr[i21] = arrayList.get(i21).byteValue();
                    }
                    float f12 = i10;
                    return new x(sb2.toString(), bArr, new z[]{new z(f10, f12), new z(f11, f12)}, BarcodeFormat.CODE_128);
                }
                throw C0550a.a();
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }

    private void a(StringBuilder sb2, int[] iArr, int[] iArr2, int i10, C0591h hVar, List<Byte> list) throws C0550a {
        C0646z zVar = this;
        char c10 = 0;
        int i11 = iArr[0];
        int i12 = iArr[1];
        int[] iArr3 = new int[6];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z10 = false;
        int i18 = 0;
        int i19 = 1;
        int i20 = iArr2[6];
        int i21 = i12;
        int i22 = i11;
        int i23 = i10;
        while (i13 == 0) {
            int a10 = a(hVar, iArr3, i21);
            list.add(Byte.valueOf((byte) a10));
            if (a10 != 106) {
                i15++;
                i23 += i15 * a10;
                i19 = 1;
            }
            int i24 = i21;
            for (int i25 = 0; i25 < 6; i25++) {
                i24 += iArr3[i25];
            }
            if (a10 != 105) {
                int[] iArr4 = {a10, i16, i17, i19, i20, 0, i13};
                if (i20 == 101) {
                    iArr4 = zVar.a(sb2, iArr4);
                } else if (i20 == 100) {
                    iArr4 = zVar.b(sb2, iArr4);
                } else if (i20 == 99) {
                    iArr4 = zVar.c(sb2, iArr4);
                }
                int i26 = iArr4[0];
                i16 = iArr4[1] == 1 ? 1 : 0;
                i17 = iArr4[2] == 1 ? 1 : 0;
                int i27 = iArr4[3] == 1 ? 1 : 0;
                boolean z11 = iArr4[5] == 1;
                int i28 = iArr4[6] == 1 ? 1 : 0;
                if (z10) {
                    i20 = iArr4[4] == 101 ? 100 : 101;
                } else {
                    i20 = iArr4[4];
                }
                z10 = z11;
                i14 = i18;
                c10 = 0;
                i13 = i28;
                i18 = i26;
                zVar = this;
                i19 = i27;
                i22 = i21;
                i21 = i24;
            } else {
                throw C0550a.a();
            }
        }
        iArr2[c10] = i22;
        iArr2[1] = i21;
        iArr2[2] = i14;
        iArr2[3] = i23;
        iArr2[4] = i15;
        iArr2[5] = i19;
        iArr2[6] = i20;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int[] a(StringBuilder sb2, int[] iArr) throws C0550a {
        int i10 = iArr[0];
        int i11 = iArr[1] == 1 ? 1 : 0;
        int i12 = iArr[2] == 1 ? 1 : 0;
        int i13 = iArr[3] == 1 ? 1 : 0;
        int i14 = iArr[4];
        int i15 = iArr[5] == 1 ? 1 : 0;
        int i16 = iArr[6] == 1 ? 1 : 0;
        if (i10 < 64) {
            if (i11 == i12) {
                sb2.append((char) (i10 + 32));
            } else {
                sb2.append((char) (i10 + 32 + 128));
            }
        } else if (i10 >= 96) {
            if (i10 != 106) {
                i13 = 0;
            }
            if (i10 != 106) {
                switch (i10) {
                    case 96:
                    case 97:
                    case 102:
                        break;
                    case 98:
                        i15 = 1;
                        i14 = 100;
                        break;
                    case 99:
                        i14 = 99;
                        break;
                    case 100:
                        i14 = 100;
                        break;
                    case 101:
                        if (i12 != 0 || i11 == 0) {
                            if (i12 != 0 && i11 != 0) {
                                i11 = 0;
                                i12 = 0;
                                break;
                            } else {
                                i11 = 1;
                                break;
                            }
                        } else {
                            i11 = 0;
                            i12 = 1;
                            break;
                        }
                    default:
                        throw C0550a.a();
                }
            } else {
                i16 = 1;
            }
            return new int[]{i10, i11, i12, i13, i14, i15, i16};
        } else if (i11 == i12) {
            sb2.append((char) (i10 - 64));
        } else {
            sb2.append((char) (i10 + 64));
        }
        i11 = 0;
        return new int[]{i10, i11, i12, i13, i14, i15, i16};
    }
}
