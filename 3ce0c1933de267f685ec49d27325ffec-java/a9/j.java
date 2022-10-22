package a9;

import b9.a;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.i;
import java.lang.reflect.Array;
import java.util.ArrayList;
/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f162a = new a();

    private static c a(h hVar) throws NotFoundException {
        int[] j10;
        if (hVar == null || (j10 = hVar.j()) == null) {
            return null;
        }
        int p10 = p(j10);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : j10) {
            i11 += p10 - i12;
            if (i12 > 0) {
                break;
            }
        }
        d[] d10 = hVar.d();
        for (int i13 = 0; i11 > 0 && d10[i13] == null; i13++) {
            i11--;
        }
        for (int length = j10.length - 1; length >= 0; length--) {
            i10 += p10 - j10[length];
            if (j10[length] > 0) {
                break;
            }
        }
        for (int length2 = d10.length - 1; i10 > 0 && d10[length2] == null; length2--) {
            i10--;
        }
        return hVar.a().a(i11, i10, hVar.k());
    }

    private static void b(f fVar, b[][] bVarArr) throws NotFoundException {
        int[] a10 = bVarArr[0][1].a();
        int j10 = (fVar.j() * fVar.l()) - r(fVar.k());
        if (a10.length == 0) {
            if (j10 <= 0 || j10 > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVarArr[0][1].b(j10);
        } else if (a10[0] != j10) {
            bVarArr[0][1].b(j10);
        }
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
    private static int c(b bVar, int i10, int i11, boolean z10, int i12, int i13) {
        int i14 = z10 ? -1 : 1;
        int i15 = i12;
        for (int i16 = 0; i16 < 2; i16++) {
            while (true) {
                if (!z10) {
                    if (i15 >= i11) {
                        break;
                    }
                    if (z10 != bVar.d(i15, i13)) {
                        break;
                    }
                } else {
                    if (i15 < i10) {
                        break;
                    }
                    if (z10 != bVar.d(i15, i13)) {
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

    private static boolean d(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i10) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f162a.a(iArr, i10, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static b[][] f(f fVar) {
        g[] o10;
        d[] d10;
        int c10;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, fVar.l(), fVar.j() + 2);
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            for (int i11 = 0; i11 < bVarArr[i10].length; i11++) {
                bVarArr[i10][i11] = new b();
            }
        }
        int i12 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (c10 = dVar.c()) >= 0 && c10 < bVarArr.length) {
                        bVarArr[c10][i12].b(dVar.e());
                    }
                }
            }
            i12++;
        }
        return bVarArr;
    }

    private static o8.b g(f fVar) throws FormatException, ChecksumException, NotFoundException {
        b[][] f10 = f(fVar);
        b(fVar, f10);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < fVar.l(); i10++) {
            int i11 = 0;
            while (i11 < fVar.j()) {
                int i12 = i11 + 1;
                int[] a10 = f10[i10][i12].a();
                int j10 = (fVar.j() * i10) + i11;
                if (a10.length == 0) {
                    arrayList.add(Integer.valueOf(j10));
                } else if (a10.length == 1) {
                    iArr[j10] = a10[0];
                } else {
                    arrayList3.add(Integer.valueOf(j10));
                    arrayList2.add(a10);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return h(fVar.k(), iArr, z8.a.b(arrayList), z8.a.b(arrayList3), iArr2);
    }

    private static o8.b h(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
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
                    return j(iArr, i10, iArr2);
                } catch (ChecksumException unused) {
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
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static o8.b i(b bVar, i iVar, i iVar2, i iVar3, i iVar4, int i10, int i11) throws NotFoundException, FormatException, ChecksumException {
        g gVar;
        int i12;
        int i13;
        int i14;
        int i15;
        h hVar = null;
        h hVar2 = null;
        f fVar = null;
        c cVar = new c(bVar, iVar, iVar2, iVar3, iVar4);
        for (int i16 = 0; i16 < 2; i16++) {
            if (iVar != null) {
                hVar = s(bVar, cVar, iVar, true, i10, i11);
            }
            if (iVar3 != null) {
                hVar2 = s(bVar, cVar, iVar3, false, i10, i11);
            }
            fVar = v(hVar, hVar2);
            if (fVar == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i16 != 0 || fVar.m() == null || (fVar.m().h() >= cVar.h() && fVar.m().f() <= cVar.f())) {
                fVar.p(cVar);
                break;
            } else {
                cVar = fVar.m();
            }
        }
        int j10 = fVar.j() + 1;
        fVar.q(0, hVar);
        fVar.q(j10, hVar2);
        boolean z10 = hVar != null;
        int i17 = i10;
        int i18 = i11;
        for (int i19 = 1; i19 <= j10; i19++) {
            int i20 = z10 ? i19 : j10 - i19;
            if (fVar.n(i20) == null) {
                if (i20 == 0 || i20 == j10) {
                    gVar = new h(cVar, i20 == 0);
                } else {
                    gVar = new g(cVar);
                }
                fVar.q(i20, gVar);
                int i21 = -1;
                int h10 = cVar.h();
                int i22 = -1;
                while (h10 <= cVar.f()) {
                    int t10 = t(fVar, i20, h10, z10);
                    if (t10 >= 0 && t10 <= cVar.e()) {
                        i15 = t10;
                    } else if (i22 != i21) {
                        i15 = i22;
                    } else {
                        i14 = i22;
                        i13 = h10;
                        i12 = i21;
                        i22 = i14;
                        h10 = i13 + 1;
                        i21 = i12;
                    }
                    i14 = i22;
                    int i23 = h10;
                    i12 = i21;
                    d k10 = k(bVar, cVar.g(), cVar.e(), z10, i15, i23, i17, i18);
                    i13 = i23;
                    if (k10 != null) {
                        gVar.f(i13, k10);
                        i17 = Math.min(i17, k10.f());
                        i18 = Math.max(i18, k10.f());
                        i22 = i15;
                        h10 = i13 + 1;
                        i21 = i12;
                    }
                    i22 = i14;
                    h10 = i13 + 1;
                    i21 = i12;
                }
            }
        }
        return g(fVar);
    }

    private static o8.b j(int[] iArr, int i10, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i11 = 1 << (i10 + 1);
            int e10 = e(iArr, iArr2, i11);
            w(iArr, i11);
            o8.b b10 = e.b(iArr, String.valueOf(i10));
            b10.k(Integer.valueOf(e10));
            b10.j(Integer.valueOf(iArr2.length));
            return b10;
        }
        throw FormatException.getFormatInstance();
    }

    private static d k(b bVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int d10;
        int a10;
        int c10 = c(bVar, i10, i11, z10, i12, i13);
        int[] q5 = q(bVar, i10, i11, z10, c10, i13);
        if (q5 == null) {
            return null;
        }
        int d11 = p8.a.d(q5);
        if (z10) {
            i16 = c10 + d11;
        } else {
            for (int i17 = 0; i17 < q5.length / 2; i17++) {
                int i18 = q5[i17];
                q5[i17] = q5[(q5.length - 1) - i17];
                q5[(q5.length - 1) - i17] = i18;
            }
            c10 -= d11;
            i16 = c10;
        }
        if (d(d11, i14, i15) && (a10 = z8.a.a((d10 = i.d(q5)))) != -1) {
            return new d(c10, i16, n(d10), a10);
        }
        return null;
    }

    private static a l(h hVar, h hVar2) {
        a i10;
        a i11;
        if (hVar == null || (i10 = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        } else if (hVar2 == null || (i11 = hVar2.i()) == null || i10.a() == i11.a() || i10.b() == i11.b() || i10.c() == i11.c()) {
            return i10;
        } else {
            return null;
        }
    }

    private static int[] m(int i10) {
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

    private static int n(int i10) {
        return o(m(i10));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0027 A[EDGE_INSN: B:24:0x0027->B:15:0x0027 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] q(b bVar, int i10, int i11, boolean z10, int i12, int i13) {
        int[] iArr = new int[8];
        int i14 = z10 ? 1 : -1;
        int i15 = 0;
        boolean z11 = z10;
        while (true) {
            if (z10) {
                if (i12 >= i11) {
                    break;
                }
                if (i15 < 8) {
                    break;
                } else if (bVar.d(i12, i13) == z11) {
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

    private static int r(int i10) {
        return 2 << i10;
    }

    private static h s(b bVar, c cVar, i iVar, boolean z10, int i10, int i11) {
        int i12;
        h hVar = new h(cVar, z10);
        int i13 = 0;
        while (i13 < 2) {
            int i14 = i13 == 0 ? 1 : -1;
            int c10 = (int) iVar.c();
            for (int d10 = (int) iVar.d(); d10 <= cVar.f() && d10 >= cVar.h(); d10 += i14) {
                d k10 = k(bVar, 0, bVar.k(), z10, c10, d10, i10, i11);
                if (k10 != null) {
                    hVar.f(d10, k10);
                    if (z10) {
                        i12 = k10.d();
                    } else {
                        i12 = k10.b();
                    }
                    c10 = i12;
                }
            }
            i13++;
        }
        return hVar;
    }

    private static int t(f fVar, int i10, int i11, boolean z10) {
        d[] d10;
        int i12 = z10 ? 1 : -1;
        d dVar = null;
        int i13 = i10 - i12;
        if (u(fVar, i13)) {
            dVar = fVar.n(i13).b(i11);
        }
        if (dVar != null) {
            return z10 ? dVar.b() : dVar.d();
        }
        d c10 = fVar.n(i10).c(i11);
        if (c10 != null) {
            return z10 ? c10.d() : c10.b();
        }
        if (u(fVar, i13)) {
            c10 = fVar.n(i13).c(i11);
        }
        if (c10 != null) {
            return z10 ? c10.b() : c10.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (u(fVar, i10)) {
                for (d dVar2 : fVar.n(i10).d()) {
                    if (dVar2 != null) {
                        return (z10 ? dVar2.b() : dVar2.d()) + (i12 * i14 * (dVar2.b() - dVar2.d()));
                    }
                }
                i14++;
            } else {
                c m10 = fVar.m();
                return z10 ? m10.g() : m10.e();
            }
        }
    }

    private static boolean u(f fVar, int i10) {
        return i10 >= 0 && i10 <= fVar.j() + 1;
    }

    private static f v(h hVar, h hVar2) throws NotFoundException {
        a l10;
        if ((hVar == null && hVar2 == null) || (l10 = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(l10, c.l(a(hVar), a(hVar2)));
    }

    private static void w(int[] iArr, int i10) throws FormatException {
        if (iArr.length >= 4) {
            int i11 = iArr[0];
            if (i11 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i11 != 0) {
            } else {
                if (i10 < iArr.length) {
                    iArr[0] = iArr.length - i10;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
