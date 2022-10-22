package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* compiled from: Detector.java */
/* loaded from: classes2.dex */
public final class Y {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14711a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14712b = {6, 2, 7, 3};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f14713c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f14714d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    /* renamed from: e  reason: collision with root package name */
    private static boolean f14715e = false;

    public static C0580ea a(C0587g gVar, Map<EnumC0553d, ?> map, boolean z10) throws C0550a {
        C0595i b10 = gVar.b();
        a(false);
        List<z[]> a10 = a(z10, b10);
        if (a10.isEmpty()) {
            b10 = b10.clone();
            b10.e();
            a10 = a(z10, b10);
            a(true);
        }
        return new C0580ea(b10, a10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5 != 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        r5 = (com.huawei.hms.scankit.aiscan.common.z[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<z[]> a(boolean z10, C0595i iVar) {
        int i10;
        float f10;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            int i13 = i12;
            while (true) {
                if (i11 >= iVar.b()) {
                    break loop0;
                }
                z[] a10 = a(iVar, i11, i12);
                if (a10[0] == null && a10[3] == null) {
                    break;
                }
                arrayList.add(a10);
                if (!z10) {
                    break loop0;
                }
                if (a10[2] != null) {
                    i10 = (int) a10[2].b();
                    f10 = a10[2].c();
                } else {
                    i10 = (int) a10[4].b();
                    f10 = a10[4].c();
                }
                i11 = (int) f10;
                i12 = i10;
                i13 = 1;
            }
            i11 += 5;
            i12 = 0;
        }
        return arrayList;
    }

    private static z[] a(C0595i iVar, int i10, int i11) {
        int b10 = iVar.b();
        int d10 = iVar.d();
        z[] zVarArr = new z[8];
        a(zVarArr, a(iVar, b10, d10, i10, i11, f14713c), f14711a);
        if (zVarArr[4] != null) {
            i11 = (int) zVarArr[4].b();
            i10 = (int) zVarArr[4].c();
        }
        a(zVarArr, a(iVar, b10, d10, i10, i11, f14714d), f14712b);
        return zVarArr;
    }

    private static void a(z[] zVarArr, z[] zVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            zVarArr[iArr[i10]] = zVarArr2[i10];
        }
    }

    private static z[] a(C0595i iVar, int i10, int i11, int i12, int i13, int[] iArr) {
        boolean z10;
        int i14;
        int i15;
        int i16;
        z[] zVarArr = new z[4];
        int[] iArr2 = new int[iArr.length];
        int i17 = i12;
        while (true) {
            if (i17 >= i10) {
                z10 = false;
                break;
            }
            int[] a10 = a(iVar, i13, i17, i11, false, iArr, iArr2);
            if (a10 != null) {
                int i18 = i17;
                int[] iArr3 = a10;
                while (true) {
                    if (i18 <= 0) {
                        i16 = i18;
                        break;
                    }
                    int i19 = i18 - 1;
                    int[] a11 = a(iVar, i13, i19, i11, false, iArr, iArr2);
                    if (a11 == null) {
                        i16 = i19 + 1;
                        break;
                    }
                    iArr3 = a11;
                    i18 = i19;
                }
                float f10 = i16;
                zVarArr[0] = new z(iArr3[0], f10);
                zVarArr[1] = new z(iArr3[1], f10);
                z10 = true;
                i17 = i16;
            } else {
                i17 += 5;
            }
        }
        int i20 = i17 + 1;
        if (z10) {
            int[] iArr4 = {(int) zVarArr[0].b(), (int) zVarArr[1].b()};
            int i21 = i20;
            int i22 = 0;
            while (true) {
                if (i21 >= i10) {
                    i14 = i22;
                    i15 = i21;
                    break;
                }
                i14 = i22;
                i15 = i21;
                int[] a12 = a(iVar, iArr4[0], i21, i11, false, iArr, iArr2);
                if (a12 != null && Math.abs(iArr4[0] - a12[0]) < 5 && Math.abs(iArr4[1] - a12[1]) < 5) {
                    iArr4 = a12;
                    i22 = 0;
                } else if (i14 > 25) {
                    break;
                } else {
                    i22 = i14 + 1;
                }
                i21 = i15 + 1;
            }
            i20 = i15 - (i14 + 1);
            float f11 = i20;
            zVarArr[2] = new z(iArr4[0], f11);
            zVarArr[3] = new z(iArr4[1], f11);
        }
        if (i20 - i17 < 10) {
            Arrays.fill(zVarArr, (Object) null);
        }
        return zVarArr;
    }

    private static int[] a(C0595i iVar, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (iVar.b(i10, i11) && i10 > 0) {
            i13++;
            if (i13 >= 3) {
                break;
            }
            i10--;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i14 = 0;
        int i15 = i10;
        while (i10 < i12) {
            if (iVar.b(i10, i11) != z11) {
                iArr2[i14] = iArr2[i14] + 1;
            } else {
                if (i14 != length - 1) {
                    i14++;
                } else if (a(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i15, i10};
                } else {
                    i15 += iArr2[0] + iArr2[1];
                    int i16 = i14 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i16);
                    iArr2[i16] = 0;
                    iArr2[i14] = 0;
                    i14--;
                }
                iArr2[i14] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i14 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i15, i10 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    public static void a(boolean z10) {
        f14715e = z10;
    }

    public static boolean a() {
        return f14715e;
    }
}
