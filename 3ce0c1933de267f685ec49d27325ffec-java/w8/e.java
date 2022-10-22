package w8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p8.a;
import v8.k;
/* compiled from: RSS14Reader.java */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f36146i = {1, 10, 34, 70, 126};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f36147j = {4, 20, 48, 81};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f36148k = {0, 161, 961, 2015, 2715};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f36149l = {0, 336, 1036, 1516};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f36150m = {8, 6, 4, 3, 1};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f36151n = {2, 4, 6, 8};

    /* renamed from: o  reason: collision with root package name */
    private static final int[][] f36152o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g  reason: collision with root package name */
    private final List<d> f36153g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<d> f36154h = new ArrayList();

    private static void q(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z10 = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.b() == dVar.b()) {
                    next.e();
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                collection.add(dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r1 < 4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r1 < 4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        r5 = false;
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        r2 = false;
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(boolean z10, int i10) throws NotFoundException {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int d10 = a.d(l());
        int d11 = a.d(j());
        boolean z15 = false;
        boolean z16 = true;
        if (z10) {
            if (d10 > 12) {
                z12 = false;
                z11 = true;
            } else if (d10 < 4) {
                z11 = false;
                z12 = true;
            } else {
                z12 = false;
                z11 = false;
            }
            if (d11 <= 12) {
            }
            z14 = false;
            z13 = true;
        } else {
            if (d10 > 11) {
                z12 = false;
                z11 = true;
            } else if (d10 < 5) {
                z11 = false;
                z12 = true;
            } else {
                z12 = false;
                z11 = false;
            }
            if (d11 <= 10) {
            }
            z14 = false;
            z13 = true;
        }
        int i11 = (d10 + d11) - i10;
        boolean z17 = (d10 & 1) == z10;
        if ((d11 & 1) == 1) {
            z15 = true;
        }
        if (i11 == 1) {
            if (z17) {
                if (!z15) {
                    z11 = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (z15) {
                z13 = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (i11 == -1) {
            if (z17) {
                if (z15) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z16) {
                    if (!z11) {
                        a.n(l(), m());
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                if (z11) {
                    a.g(l(), m());
                }
                if (z14) {
                    if (!z13) {
                        a.n(j(), m());
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                if (z13) {
                    a.g(j(), k());
                    return;
                }
                return;
            } else if (z15) {
                z14 = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (i11 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (z17) {
            if (!z15) {
                throw NotFoundException.getNotFoundInstance();
            } else if (d10 < d11) {
                z13 = true;
                if (z16) {
                }
                if (z11) {
                }
                if (z14) {
                }
                if (z13) {
                }
            } else {
                z14 = true;
                z11 = true;
            }
        } else if (z15) {
            throw NotFoundException.getNotFoundInstance();
        }
        z16 = z12;
        if (z16) {
        }
        if (z11) {
        }
        if (z14) {
        }
        if (z13) {
        }
    }

    private static boolean s(d dVar, d dVar2) {
        int a10 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c10 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c10 > 72) {
            c10--;
        }
        if (c10 > 8) {
            c10--;
        }
        return a10 == c10;
    }

    private static h t(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb2 = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb2.append('0');
        }
        sb2.append(valueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int charAt = sb2.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                charAt *= 3;
            }
            i10 += charAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb2.append(i12);
        i[] a10 = dVar.d().a();
        i[] a11 = dVar2.d().a();
        return new h(String.valueOf(sb2.toString()), null, new i[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_14);
    }

    private b u(com.google.zxing.common.a aVar, c cVar, boolean z10) throws NotFoundException {
        int[] h10 = h();
        h10[0] = 0;
        h10[1] = 0;
        h10[2] = 0;
        h10[3] = 0;
        h10[4] = 0;
        h10[5] = 0;
        h10[6] = 0;
        h10[7] = 0;
        if (z10) {
            k.f(aVar, cVar.b()[0], h10);
        } else {
            k.e(aVar, cVar.b()[1] + 1, h10);
            int i10 = 0;
            for (int length = h10.length - 1; i10 < length; length--) {
                int i11 = h10[i10];
                h10[i10] = h10[length];
                h10[length] = i11;
                i10++;
            }
        }
        int i12 = z10 ? 16 : 15;
        float d10 = a.d(h10) / i12;
        int[] l10 = l();
        int[] j10 = j();
        float[] m10 = m();
        float[] k10 = k();
        for (int i13 = 0; i13 < h10.length; i13++) {
            float f10 = h10[i13] / d10;
            int i14 = (int) (0.5f + f10);
            if (i14 <= 0) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                l10[i15] = i14;
                m10[i15] = f10 - i14;
            } else {
                j10[i15] = i14;
                k10[i15] = f10 - i14;
            }
        }
        r(z10, i12);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = l10.length - 1; length2 >= 0; length2--) {
            i16 = (i16 * 9) + l10[length2];
            i17 += l10[length2];
        }
        int i18 = 0;
        int i19 = 0;
        for (int length3 = j10.length - 1; length3 >= 0; length3--) {
            i18 = (i18 * 9) + j10[length3];
            i19 += j10[length3];
        }
        int i20 = i16 + (i18 * 3);
        if (z10) {
            if ((i17 & 1) != 0 || i17 > 12 || i17 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i21 = (12 - i17) / 2;
            int i22 = f36150m[i21];
            return new b((f.b(l10, i22, false) * f36146i[i21]) + f.b(j10, 9 - i22, true) + f36148k[i21], i20);
        } else if ((i19 & 1) != 0 || i19 > 10 || i19 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            int i23 = (10 - i19) / 2;
            int i24 = f36151n[i23];
            return new b((f.b(j10, 9 - i24, false) * f36147j[i23]) + f.b(l10, i24, true) + f36149l[i23], i20);
        }
    }

    private d v(com.google.zxing.common.a aVar, boolean z10, int i10, Map<DecodeHintType, ?> map) {
        int[] w10;
        j jVar;
        try {
            c x10 = x(aVar, i10, z10, w(aVar, 0, z10));
            if (map == null) {
                jVar = null;
            } else {
                jVar = (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (jVar != null) {
                float f10 = (w10[0] + w10[1]) / 2.0f;
                if (z10) {
                    f10 = (aVar.g() - 1) - f10;
                }
                jVar.a(new i(f10, i10));
            }
            b u10 = u(aVar, x10, true);
            b u11 = u(aVar, x10, false);
            return new d((u10.b() * 1597) + u11.b(), u10.a() + (u11.a() * 4), x10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] w(com.google.zxing.common.a aVar, int i10, boolean z10) throws NotFoundException {
        int[] i11 = i();
        i11[0] = 0;
        i11[1] = 0;
        i11[2] = 0;
        i11[3] = 0;
        int g10 = aVar.g();
        boolean z11 = false;
        while (i10 < g10) {
            z11 = !aVar.c(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i12 = i10;
        int i13 = 0;
        while (i10 < g10) {
            if (aVar.c(i10) ^ z11) {
                i11[i13] = i11[i13] + 1;
            } else {
                if (i13 != 3) {
                    i13++;
                } else if (a.o(i11)) {
                    return new int[]{i12, i10};
                } else {
                    i12 += i11[0] + i11[1];
                    i11[0] = i11[2];
                    i11[1] = i11[3];
                    i11[2] = 0;
                    i11[3] = 0;
                    i13--;
                }
                i11[i13] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private c x(com.google.zxing.common.a aVar, int i10, boolean z10, int[] iArr) throws NotFoundException {
        int i11;
        int i12;
        boolean c10 = aVar.c(iArr[0]);
        int i13 = iArr[0] - 1;
        while (i13 >= 0 && (aVar.c(i13) ^ c10)) {
            i13--;
        }
        int i14 = i13 + 1;
        int[] i15 = i();
        System.arraycopy(i15, 0, i15, 1, i15.length - 1);
        i15[0] = iArr[0] - i14;
        int p10 = a.p(i15, f36152o);
        int i16 = iArr[1];
        if (z10) {
            i12 = (aVar.g() - 1) - i14;
            i11 = (aVar.g() - 1) - i16;
        } else {
            i11 = i16;
            i12 = i14;
        }
        return new c(p10, new int[]{i14, iArr[1]}, i12, i11, i10);
    }

    @Override // v8.k
    public h b(int i10, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        q(this.f36153g, v(aVar, false, i10, map));
        aVar.k();
        q(this.f36154h, v(aVar, true, i10, map));
        aVar.k();
        for (d dVar : this.f36153g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f36154h) {
                    if (dVar2.c() > 1 && s(dVar, dVar2)) {
                        return t(dVar, dVar2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
