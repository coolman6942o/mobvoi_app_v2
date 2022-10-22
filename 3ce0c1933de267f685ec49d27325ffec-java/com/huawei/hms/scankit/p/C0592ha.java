package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.n;
import com.huawei.hms.scankit.aiscan.common.z;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: PDF417ScanningDecoder.java */
/* renamed from: com.huawei.hms.scankit.p.ha  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0592ha {

    /* renamed from: a  reason: collision with root package name */
    private static final Z f14808a = new Z();

    public static C0554e a(C0595i iVar, z zVar, z zVar2, z zVar3, z zVar4, int i10, int i11, Map<EnumC0553d, ?> map) throws C0550a {
        Q q5;
        V b10;
        Q q10 = new Q(iVar, zVar, zVar2, zVar3, zVar4);
        boolean z10 = true;
        X x10 = null;
        X x11 = null;
        while (true) {
            q5 = q10;
            if (zVar != null) {
                x10 = a(iVar, q5, zVar, true, i10, i11);
            }
            if (zVar3 != null) {
                x11 = a(iVar, q5, zVar3, false, i10, i11);
            }
            b10 = b(x10, x11);
            if (b10 != null) {
                q10 = b10.d();
                if (!z10 || q10 == null || (q10.f() >= q5.f() && q10.d() <= q5.d())) {
                    break;
                }
                z10 = false;
            } else {
                throw C0550a.a();
            }
        }
        b10.a(q5);
        int a10 = b10.a() + 1;
        b10.a(0, x10);
        b10.a(a10, x11);
        a(b10, x10, q5, a10, iVar, i10, i11);
        return a(b10, map);
    }

    private static boolean a(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    private static V b(X x10, X x11) throws C0550a {
        O a10;
        if ((x10 == null && x11 == null) || (a10 = a(x10, x11)) == null) {
            return null;
        }
        return new V(a10, Q.a(a(x10), a(x11)));
    }

    private static int c(int i10) {
        return 2 << i10;
    }

    private static int b(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002b A[EDGE_INSN: B:27:0x002b->B:18:0x002b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] b(C0595i iVar, int i10, int i11, boolean z10, int i12, int i13) {
        int[] iArr = new int[8];
        int i14 = z10 ? 1 : -1;
        boolean z11 = z10;
        int i15 = 0;
        while (true) {
            if (z10) {
                if (i12 >= i11) {
                    break;
                }
                if (i15 < 8) {
                    break;
                } else if (iVar.b(i12, i13) == z11) {
                    iArr[i15] = iArr[i15] + 1;
                    i12 += i14;
                } else {
                    i15++;
                    z11 = !z11;
                }
            } else {
                if (i12 < i10) {
                    break;
                }
                if (i15 < 8) {
                }
            }
        }
        if (i15 != 8) {
            if (z10) {
                i10 = i11;
            }
            if (!(i12 == i10 && i15 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int b(int i10) {
        return a(a(i10));
    }

    private static void a(V v10, X x10, Q q5, int i10, C0595i iVar, int i11, int i12) {
        W x11;
        int i13;
        int i14;
        int i15;
        W w10;
        int i16;
        int i17;
        boolean z10 = x10 != null;
        int i18 = i11;
        int i19 = i12;
        for (int i20 = 1; i20 <= i10; i20++) {
            int i21 = z10 ? i20 : i10 - i20;
            if (v10.a(i21) == null) {
                if (i21 == 0 || i21 == i10) {
                    x11 = new X(q5, i21 == 0);
                } else {
                    x11 = new W(q5);
                }
                W w11 = x11;
                v10.a(i21, w11);
                int i22 = -1;
                int i23 = i18;
                int i24 = i19;
                int f10 = q5.f();
                int i25 = -1;
                while (f10 <= q5.d()) {
                    int a10 = a(v10, i21, f10, z10);
                    if (a10 >= 0 && a10 <= q5.c()) {
                        i14 = a10;
                    } else if (i25 == i22) {
                        i16 = i25;
                        i15 = f10;
                        i17 = i23;
                        i13 = i22;
                        w10 = w11;
                        i23 = i17;
                        i14 = i16;
                        f10 = i15 + 1;
                        w11 = w10;
                        i25 = i14;
                        i22 = i13;
                    } else {
                        i14 = i25;
                    }
                    i16 = i25;
                    int i26 = f10;
                    int i27 = i24;
                    int i28 = i23;
                    i13 = i22;
                    w10 = w11;
                    S a11 = a(iVar, q5.e(), q5.c(), z10, i14, i26, i28, i27);
                    i15 = i26;
                    if (a11 != null) {
                        w10.a(i15, a11);
                        i23 = Math.min(i28, a11.f());
                        i24 = Math.max(i27, a11.f());
                        f10 = i15 + 1;
                        w11 = w10;
                        i25 = i14;
                        i22 = i13;
                    } else {
                        i24 = i27;
                        i17 = i28;
                        i23 = i17;
                        i14 = i16;
                        f10 = i15 + 1;
                        w11 = w10;
                        i25 = i14;
                        i22 = i13;
                    }
                }
                i18 = i23;
                i19 = i24;
            }
        }
    }

    private static Q a(X x10) throws C0550a {
        int[] d10;
        if (x10 == null || (d10 = x10.d()) == null) {
            return null;
        }
        int b10 = b(d10);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : d10) {
            i11 += b10 - i12;
            if (i12 > 0) {
                break;
            }
        }
        S[] b11 = x10.b();
        for (int i13 = 0; i11 > 0 && b11[i13] == null; i13++) {
            i11--;
        }
        for (int length = d10.length - 1; length >= 0; length--) {
            i10 += b10 - d10[length];
            if (d10[length] > 0) {
                break;
            }
        }
        for (int length2 = b11.length - 1; i10 > 0 && b11[length2] == null; length2--) {
            i10--;
        }
        return x10.a().a(i11, i10, x10.e());
    }

    private static O a(X x10, X x11) throws C0550a {
        O c10;
        O c11;
        if (x10 == null || (c10 = x10.c()) == null) {
            if (x11 == null) {
                return null;
            }
            return x11.c();
        } else if (x11 == null || (c11 = x11.c()) == null || c10.a() == c11.a() || c10.b() == c11.b() || c10.c() == c11.c()) {
            return c10;
        } else {
            return null;
        }
    }

    private static X a(C0595i iVar, Q q5, z zVar, boolean z10, int i10, int i11) {
        int i12;
        X x10 = new X(q5, z10);
        int i13 = 0;
        while (i13 < 2) {
            int i14 = i13 == 0 ? 1 : -1;
            int b10 = (int) zVar.b();
            for (int c10 = (int) zVar.c(); c10 <= q5.d() && c10 >= q5.f(); c10 += i14) {
                S a10 = a(iVar, 0, iVar.d(), z10, b10, c10, i10, i11);
                if (a10 != null) {
                    x10.a(c10, a10);
                    if (z10) {
                        i12 = a10.d();
                    } else {
                        i12 = a10.b();
                    }
                    b10 = i12;
                }
            }
            i13++;
        }
        return x10;
    }

    private static void a(V v10, P[][] pArr) throws C0550a {
        P p10 = pArr[0][1];
        int[] a10 = p10.a();
        int a11 = (v10.a() * v10.c()) - c(v10.b());
        if (a10.length == 0) {
            if (a11 < 1 || a11 > 928) {
                throw C0550a.a();
            }
            p10.a(a11);
        } else if (a10[0] != a11) {
            p10.a(a11);
        }
    }

    private static C0554e a(V v10, Map<EnumC0553d, ?> map) throws C0550a {
        P[][] a10 = a(v10);
        a(v10, a10);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[v10.c() * v10.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < v10.c(); i10++) {
            int i11 = 0;
            while (i11 < v10.a()) {
                int i12 = i11 + 1;
                int[] a11 = a10[i10][i12].a();
                int a12 = (v10.a() * i10) + i11;
                if (a11.length == 0) {
                    arrayList.add(Integer.valueOf(a12));
                } else if (a11.length == 1) {
                    iArr[a12] = a11[0];
                } else {
                    arrayList3.add(Integer.valueOf(a12));
                    arrayList2.add(a11);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return a(v10.b(), iArr, C0576da.a(arrayList), C0576da.a(arrayList3), iArr2, map);
    }

    private static C0554e a(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<EnumC0553d, ?> map) throws C0550a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            i11--;
            if (i11 > 0) {
                for (int i12 = 0; i12 < length; i12++) {
                    iArr[iArr3[i12]] = iArr4[i12][iArr5[i12]];
                }
                try {
                    return a(iArr, i10, iArr2, map);
                } catch (C0550a unused) {
                    if (length != 0) {
                        int i13 = 0;
                        while (true) {
                            if (i13 >= length) {
                                break;
                            } else if (iArr5[i13] < iArr4[i13].length - 1) {
                                iArr5[i13] = iArr5[i13] + 1;
                                break;
                            } else {
                                iArr5[i13] = 0;
                                if (i13 != length - 1) {
                                    i13++;
                                } else {
                                    throw C0550a.a();
                                }
                            }
                        }
                    } else {
                        throw C0550a.a();
                    }
                }
            } else {
                throw C0550a.a();
            }
        }
    }

    private static P[][] a(V v10) throws C0550a {
        W[] e10;
        S[] b10;
        int c10;
        P[][] pArr = (P[][]) Array.newInstance(P.class, v10.c(), v10.a() + 2);
        for (int i10 = 0; i10 < pArr.length; i10++) {
            for (int i11 = 0; i11 < pArr[i10].length; i11++) {
                pArr[i10][i11] = new P();
            }
        }
        int i12 = 0;
        for (W w10 : v10.e()) {
            if (w10 != null) {
                for (S s10 : w10.b()) {
                    if (s10 != null && (c10 = s10.c()) >= 0 && c10 < pArr.length) {
                        pArr[c10][i12].a(s10.e());
                    }
                }
            }
            i12++;
        }
        return pArr;
    }

    private static boolean a(V v10, int i10) {
        return i10 >= 0 && i10 <= v10.a() + 1;
    }

    private static int a(V v10, int i10, int i11, boolean z10) {
        S[] b10;
        int i12 = z10 ? 1 : -1;
        S s10 = null;
        int i13 = i10 - i12;
        if (a(v10, i13)) {
            s10 = v10.a(i13).a(i11);
        }
        if (s10 != null) {
            return z10 ? s10.b() : s10.d();
        }
        S b11 = v10.a(i10).b(i11);
        if (b11 != null) {
            return z10 ? b11.d() : b11.b();
        }
        if (a(v10, i13)) {
            b11 = v10.a(i13).b(i11);
        }
        if (b11 != null) {
            return z10 ? b11.b() : b11.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!a(v10, i10)) {
                return z10 ? v10.d().e() : v10.d().c();
            }
            for (S s11 : v10.a(i10).b()) {
                if (s11 != null) {
                    return (z10 ? s11.b() : s11.d()) + (i12 * i14 * (s11.b() - s11.d()));
                }
            }
            i14++;
        }
    }

    private static S a(C0595i iVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int a10;
        int a11;
        int a12 = a(iVar, i10, i11, z10, i12, i13);
        int[] b10 = b(iVar, i10, i11, z10, a12, i13);
        if (b10 == null) {
            return null;
        }
        int a13 = n.a(b10);
        if (z10) {
            i16 = a12 + a13;
        } else {
            for (int i17 = 0; i17 < b10.length / 2; i17++) {
                int i18 = b10[i17];
                b10[i17] = b10[(b10.length - 1) - i17];
                b10[(b10.length - 1) - i17] = i18;
            }
            a12 -= a13;
            i16 = a12;
        }
        if (a(a13, i14, i15) && (a11 = C0576da.a((a10 = C0572ca.a(b10)))) != -1) {
            return new S(a12, i16, b(a10), a11);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(C0595i iVar, int i10, int i11, boolean z10, int i12, int i13) {
        int i14 = z10 ? -1 : 1;
        int i15 = i12;
        for (int i16 = 0; i16 < 2; i16++) {
            while (true) {
                if (!z10) {
                    if (i15 >= i11) {
                        break;
                    }
                    if (z10 != iVar.b(i15, i13)) {
                        break;
                    }
                } else {
                    if (i15 < i10) {
                        break;
                    }
                    if (z10 != iVar.b(i15, i13)) {
                        if (Math.abs(i12 - i15) > 2) {
                            return i12;
                        }
                        i15 += i14;
                    }
                }
            }
            i14 = -i14;
            z10 = !z10;
        }
        return i15;
    }

    private static C0554e a(int[] iArr, int i10, int[] iArr2, Map<EnumC0553d, ?> map) throws C0550a, C0550a {
        if (iArr.length != 0) {
            int i11 = 1 << (i10 + 1);
            int a10 = a(iArr, iArr2, i11);
            a(iArr, i11);
            C0554e a11 = U.a(iArr, String.valueOf(i10), map);
            a11.b(Integer.valueOf(a10));
            a11.a(Integer.valueOf(iArr2.length));
            return a11;
        }
        throw C0550a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i10) throws C0550a {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f14808a.a(iArr, i10, iArr2);
        }
        throw C0550a.a();
    }

    private static void a(int[] iArr, int i10) throws C0550a {
        if (iArr.length >= 4) {
            int i11 = iArr[0];
            if (i11 > iArr.length) {
                throw C0550a.a();
            } else if (i11 != 0) {
            } else {
                if (i10 < iArr.length) {
                    iArr[0] = iArr.length - i10;
                    return;
                }
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private static int[] a(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
