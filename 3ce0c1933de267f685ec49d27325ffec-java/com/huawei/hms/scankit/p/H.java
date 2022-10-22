package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.t;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
/* compiled from: OneDReader.java */
/* loaded from: classes2.dex */
public abstract class H implements t {
    private x b(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        int e10 = gVar.e();
        int c10 = gVar.c();
        C0591h hVar = new C0591h(e10);
        int max = Math.max(1, c10 >> 5);
        int i10 = c10 / 2;
        if (map != null) {
            EnumC0553d dVar = EnumC0553d.PHOTO_MODE_NUM;
            if (map.containsKey(dVar)) {
                i10 += (((Integer) map.get(dVar)).intValue() * max) / 3;
            }
        }
        int i11 = i10;
        int i12 = 0;
        while (i12 < 15) {
            int i13 = i12 + 1;
            int i14 = i13 / 2;
            if (!((i12 & 1) == 0)) {
                i14 = -i14;
            }
            int i15 = i11 + (i14 * max);
            if (i15 < 0 || i15 >= c10) {
                break;
            }
            x a10 = a(gVar, hVar, map, i15, e10);
            if (a10 != null && a10.g() != null) {
                return a10;
            }
            i12 = i13;
        }
        throw C0550a.a();
    }

    public abstract x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a;

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        return b(gVar, map);
    }

    private x a(C0587g gVar, C0591h hVar, Map<EnumC0553d, ?> map, int i10, int i11) throws C0550a {
        int i12 = 0;
        while (true) {
            int i13 = 3;
            if (i12 >= 3) {
                return null;
            }
            if (i12 == 0) {
                try {
                    hVar = gVar.a(i10, hVar);
                } catch (C0550a unused) {
                    continue;
                }
            } else if (i12 == 1) {
                hVar = gVar.b().a(i10, hVar);
                i13 = 1;
            } else if (i12 == 2) {
                if (!Ka.f14577o) {
                    continue;
                    i12++;
                } else {
                    hVar = gVar.a(i10, 1);
                }
            }
            if (a(hVar.c())) {
                x a10 = a(hVar, !Ka.f14565c ? 1 : i13, map, i10, i11);
                if (!(a10 == null || a10.g() == null)) {
                    return a10;
                }
            } else {
                continue;
            }
            i12++;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:15|(2:17|(6:19|35|21|(1:25)|26|(2:42|31)(2:38|28))))|20|35|21|(2:23|25)|26|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
        if (r7 == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        r19.g();
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private x a(C0591h hVar, int i10, Map<EnumC0553d, ?> map, int i11, int i12) {
        int i13;
        C0591h hVar2;
        H h10;
        x a10;
        z[] f10;
        EnumMap enumMap = map;
        for (int i14 = 0; i14 < i10; i14++) {
            if (i14 == 0) {
                hVar.b();
            }
            if (i14 == 1) {
                hVar.h();
            }
            if (i14 == 2) {
                hVar.f();
                hVar.i();
            }
            int i15 = 0;
            for (int i16 = 2; i15 < i16; i16 = 2) {
                if (i15 == 1) {
                    hVar.g();
                    if (enumMap != null) {
                        EnumC0553d dVar = EnumC0553d.NEED_RESULT_POINT_CALLBACK;
                        if (enumMap.containsKey(dVar)) {
                            EnumMap enumMap2 = new EnumMap(EnumC0553d.class);
                            enumMap2.putAll(enumMap);
                            enumMap2.remove(dVar);
                            h10 = this;
                            i13 = i11;
                            enumMap = enumMap2;
                            hVar2 = hVar;
                            a10 = h10.a(i13, hVar2, enumMap);
                            if (i15 == 1 && (f10 = a10.f()) != null) {
                                float f11 = i12;
                                f10[0] = new z((f11 - f10[0].b()) - 1.0f, f10[0].c());
                                f10[1] = new z((f11 - f10[1].b()) - 1.0f, f10[1].c());
                            }
                            if (!a(a10, i12)) {
                                return a10;
                            }
                            i15++;
                        }
                    }
                }
                h10 = this;
                hVar2 = hVar;
                i13 = i11;
                a10 = h10.a(i13, hVar2, enumMap);
                if (i15 == 1) {
                    float f112 = i12;
                    f10[0] = new z((f112 - f10[0].b()) - 1.0f, f10[0].c());
                    f10[1] = new z((f112 - f10[1].b()) - 1.0f, f10[1].c());
                }
                if (!a(a10, i12)) {
                }
            }
        }
        return null;
    }

    private static boolean a(int[] iArr) {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length && i10 < 20; i12++) {
            i10 += Integer.bitCount((i11 | (iArr[i12] << 1)) ^ iArr[i12]);
            i11 = (iArr[i12] >> 31) & 1;
        }
        return i10 >= 20;
    }

    private static boolean a(x xVar, int i10) {
        z[] f10 = xVar.f();
        return Math.abs(((double) f10[1].b()) - ((double) f10[0].b())) / ((double) i10) > 0.4d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(C0591h hVar, int i10, int[] iArr) throws C0550a {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int d10 = hVar.d();
        if (i10 < d10) {
            boolean z10 = !hVar.a(i10);
            int i11 = 0;
            while (i10 < d10) {
                if (hVar.a(i10) == z10) {
                    i11++;
                    if (i11 == length) {
                        break;
                    } else if (i11 < 0 || i11 >= iArr.length) {
                        throw C0550a.a();
                    } else {
                        iArr[i11] = 1;
                        z10 = !z10;
                    }
                } else if (i11 < 0 || i11 >= iArr.length) {
                    throw C0550a.a();
                } else {
                    iArr[i11] = iArr[i11] + 1;
                }
                i10++;
            }
            if (i11 == length) {
                return;
            }
            if (i11 != length - 1 || i10 != d10) {
                throw C0550a.a();
            }
            return;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static float a(int[] iArr, int[] iArr2, float f10) {
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
}
