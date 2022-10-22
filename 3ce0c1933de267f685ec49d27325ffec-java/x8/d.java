package x8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.h;
import com.google.zxing.i;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import v8.k;
import w8.a;
import w8.b;
import w8.c;
import w8.f;
import y8.j;
/* compiled from: RSSExpandedReader.java */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f36495k = {7, 5, 4, 3, 1};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f36496l = {4, 20, 52, 104, 204};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f36497m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n  reason: collision with root package name */
    private static final int[][] f36498n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o  reason: collision with root package name */
    private static final int[][] f36499o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, CameraConfig.CAMERA_THIRD_DEGREE, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, com.bjleisen.iface.sdk.a.f7612e, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: p  reason: collision with root package name */
    private static final int[][] f36500p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f36501g = new ArrayList(11);

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f36502h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final int[] f36503i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    private boolean f36504j;

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean A(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z10;
        boolean z11;
        Iterator<c> it = iterable2.iterator();
        do {
            z10 = false;
            if (it.hasNext()) {
                c next = it.next();
                Iterator<b> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z10 = true;
                        continue;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = next.a().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z11 = true;
                                continue;
                                break;
                            }
                        } else {
                            z11 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z11) {
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z10);
        return true;
    }

    private static boolean B(List<b> list) {
        int[][] iArr;
        boolean z10;
        for (int[] iArr2 : f36500p) {
            if (list.size() <= iArr2.length) {
                int i10 = 0;
                while (true) {
                    if (i10 >= list.size()) {
                        z10 = true;
                        break;
                    } else if (list.get(i10).b().c() != iArr2[i10]) {
                        z10 = false;
                        break;
                    } else {
                        i10++;
                    }
                }
                if (z10) {
                    return true;
                }
            }
        }
        return false;
    }

    private c C(com.google.zxing.common.a aVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        if (z10) {
            int i14 = this.f36503i[0] - 1;
            while (i14 >= 0 && !aVar.c(i14)) {
                i14--;
            }
            int i15 = i14 + 1;
            int[] iArr = this.f36503i;
            i13 = iArr[0] - i15;
            i11 = iArr[1];
            i12 = i15;
        } else {
            int[] iArr2 = this.f36503i;
            i12 = iArr2[0];
            int f10 = aVar.f(iArr2[1] + 1);
            i13 = f10 - this.f36503i[1];
            i11 = f10;
        }
        int[] i16 = i();
        System.arraycopy(i16, 0, i16, 1, i16.length - 1);
        i16[0] = i13;
        try {
            return new c(a.p(i16, f36498n), new int[]{i12, i11}, i12, i11, i10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void D(List<b> list, List<c> list2) {
        boolean z10;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z10 = false;
                    boolean z11 = true;
                    if (!it2.hasNext()) {
                        z10 = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                break;
                            }
                        } else {
                            z11 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z11) {
                        break;
                    }
                }
                if (z10) {
                    it.remove();
                }
            }
        }
    }

    private static void F(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    private void G(int i10, boolean z10) {
        boolean z11 = false;
        int i11 = 0;
        boolean z12 = false;
        while (true) {
            if (i11 >= this.f36502h.size()) {
                break;
            }
            c cVar = this.f36502h.get(i11);
            if (cVar.b() > i10) {
                z11 = cVar.c(this.f36501g);
                break;
            } else {
                z12 = cVar.c(this.f36501g);
                i11++;
            }
        }
        if (!z11 && !z12 && !A(this.f36501g, this.f36502h)) {
            this.f36502h.add(i11, new c(this.f36501g, i10, z10));
            D(this.f36501g, this.f36502h);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q(int i10) throws NotFoundException {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int d10 = p8.a.d(l());
        int d11 = p8.a.d(j());
        boolean z14 = false;
        boolean z15 = true;
        if (d10 > 13) {
            z11 = false;
            z10 = true;
        } else if (d10 < 4) {
            z10 = false;
            z11 = true;
        } else {
            z11 = false;
            z10 = false;
        }
        if (d11 > 13) {
            z13 = false;
            z12 = true;
        } else if (d11 < 4) {
            z12 = false;
            z13 = true;
        } else {
            z13 = false;
            z12 = false;
        }
        int i11 = (d10 + d11) - i10;
        boolean z16 = (d10 & 1) == 1;
        if ((d11 & 1) == 0) {
            z14 = true;
        }
        if (i11 == 1) {
            if (z16) {
                if (!z14) {
                    z10 = true;
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (z14) {
                z12 = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (i11 == -1) {
            if (z16) {
                if (z14) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z15) {
                    if (!z10) {
                        a.n(l(), m());
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                if (z10) {
                    a.g(l(), m());
                }
                if (z13) {
                    if (!z12) {
                        a.n(j(), m());
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                if (z12) {
                    a.g(j(), k());
                    return;
                }
                return;
            } else if (z14) {
                z13 = true;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else if (i11 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (z16) {
            if (!z14) {
                throw NotFoundException.getNotFoundInstance();
            } else if (d10 < d11) {
                z12 = true;
                if (z15) {
                }
                if (z10) {
                }
                if (z13) {
                }
                if (z12) {
                }
            } else {
                z13 = true;
                z10 = true;
            }
        } else if (z14) {
            throw NotFoundException.getNotFoundInstance();
        }
        z15 = z11;
        if (z15) {
        }
        if (z10) {
        }
        if (z13) {
        }
        if (z12) {
        }
    }

    private boolean r() {
        b bVar = this.f36501g.get(0);
        b c10 = bVar.c();
        b d10 = bVar.d();
        if (d10 == null) {
            return false;
        }
        int a10 = d10.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f36501g.size(); i11++) {
            b bVar2 = this.f36501g.get(i11);
            a10 += bVar2.c().a();
            i10++;
            b d11 = bVar2.d();
            if (d11 != null) {
                a10 += d11.a();
                i10++;
            }
        }
        return ((i10 + (-4)) * 211) + (a10 % 211) == c10.b();
    }

    private List<b> s(List<c> list, int i10) throws NotFoundException {
        while (i10 < this.f36502h.size()) {
            c cVar = this.f36502h.get(i10);
            this.f36501g.clear();
            for (c cVar2 : list) {
                this.f36501g.addAll(cVar2.a());
            }
            this.f36501g.addAll(cVar.a());
            if (B(this.f36501g)) {
                if (r()) {
                    return this.f36501g;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return s(arrayList, i10 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<b> t(boolean z10) {
        List<b> list = null;
        if (this.f36502h.size() > 25) {
            this.f36502h.clear();
            return null;
        }
        this.f36501g.clear();
        if (z10) {
            Collections.reverse(this.f36502h);
        }
        try {
            list = s(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f36502h);
        }
        return list;
    }

    static h u(List<b> list) throws NotFoundException, FormatException {
        String d10 = j.a(a.a(list)).d();
        i[] a10 = list.get(0).b().a();
        i[] a11 = list.get(list.size() - 1).b().a();
        return new h(d10, null, new i[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void x(com.google.zxing.common.a aVar, List<b> list, int i10) throws NotFoundException {
        int[] i11 = i();
        i11[0] = 0;
        i11[1] = 0;
        i11[2] = 0;
        i11[3] = 0;
        int g10 = aVar.g();
        if (i10 < 0) {
            i10 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z10 = list.size() % 2 != 0;
        if (this.f36504j) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < g10) {
            z11 = !aVar.c(i10);
            if (!z11) {
                break;
            }
            i10++;
        }
        int i12 = 0;
        boolean z12 = z11;
        int i13 = i10;
        while (i10 < g10) {
            if (aVar.c(i10) ^ z12) {
                i11[i12] = i11[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (z10) {
                        F(i11);
                    }
                    if (a.o(i11)) {
                        int[] iArr = this.f36503i;
                        iArr[0] = i13;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        F(i11);
                    }
                    i13 += i11[0] + i11[1];
                    i11[0] = i11[2];
                    i11[1] = i11[3];
                    i11[2] = 0;
                    i11[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                i11[i12] = 1;
                z12 = !z12;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int y(com.google.zxing.common.a aVar, int i10) {
        if (aVar.c(i10)) {
            return aVar.e(aVar.f(i10));
        }
        return aVar.f(aVar.e(i10));
    }

    private static boolean z(c cVar, boolean z10, boolean z11) {
        return cVar.c() != 0 || !z10 || !z11;
    }

    b E(com.google.zxing.common.a aVar, List<b> list, int i10) throws NotFoundException {
        c C;
        b bVar;
        boolean z10 = list.size() % 2 == 0;
        if (this.f36504j) {
            z10 = !z10;
        }
        int i11 = -1;
        boolean z11 = true;
        do {
            x(aVar, list, i11);
            C = C(aVar, i10, z10);
            if (C == null) {
                i11 = y(aVar, this.f36503i[0]);
                continue;
            } else {
                z11 = false;
                continue;
            }
        } while (z11);
        b v10 = v(aVar, C, z10, true);
        if (list.isEmpty() || !list.get(list.size() - 1).f()) {
            try {
                bVar = v(aVar, C, z10, false);
            } catch (NotFoundException unused) {
                bVar = null;
            }
            return new b(v10, bVar, C, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // v8.k
    public h b(int i10, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f36501g.clear();
        this.f36504j = false;
        try {
            return u(w(i10, aVar));
        } catch (NotFoundException unused) {
            this.f36501g.clear();
            this.f36504j = true;
            return u(w(i10, aVar));
        }
    }

    b v(com.google.zxing.common.a aVar, c cVar, boolean z10, boolean z11) throws NotFoundException {
        int[] h10 = h();
        h10[0] = 0;
        h10[1] = 0;
        h10[2] = 0;
        h10[3] = 0;
        h10[4] = 0;
        h10[5] = 0;
        h10[6] = 0;
        h10[7] = 0;
        if (z11) {
            k.f(aVar, cVar.b()[0], h10);
        } else {
            k.e(aVar, cVar.b()[1], h10);
            int i10 = 0;
            for (int length = h10.length - 1; i10 < length; length--) {
                int i11 = h10[i10];
                h10[i10] = h10[length];
                h10[length] = i11;
                i10++;
            }
        }
        float d10 = p8.a.d(h10) / 17.0f;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d10 - f10) / f10 <= 0.3f) {
            int[] l10 = l();
            int[] j10 = j();
            float[] m10 = m();
            float[] k10 = k();
            for (int i12 = 0; i12 < h10.length; i12++) {
                float f11 = (h10[i12] * 1.0f) / d10;
                int i13 = (int) (0.5f + f11);
                if (i13 <= 0) {
                    if (f11 >= 0.3f) {
                        i13 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i13 > 8) {
                    if (f11 <= 8.7f) {
                        i13 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i14 = i12 / 2;
                if ((i12 & 1) == 0) {
                    l10[i14] = i13;
                    m10[i14] = f11 - i13;
                } else {
                    j10[i14] = i13;
                    k10[i14] = f11 - i13;
                }
            }
            q(17);
            int c10 = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
            int i15 = 0;
            int i16 = 0;
            for (int length2 = l10.length - 1; length2 >= 0; length2--) {
                if (z(cVar, z10, z11)) {
                    i15 += l10[length2] * f36499o[c10][length2 * 2];
                }
                i16 += l10[length2];
            }
            int i17 = 0;
            for (int length3 = j10.length - 1; length3 >= 0; length3--) {
                if (z(cVar, z10, z11)) {
                    i17 += j10[length3] * f36499o[c10][(length3 * 2) + 1];
                }
            }
            int i18 = i15 + i17;
            if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i19 = (13 - i16) / 2;
            int i20 = f36495k[i19];
            return new b((f.b(l10, i20, true) * f36496l[i19]) + f.b(j10, 9 - i20, false) + f36497m[i19], i18);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    List<b> w(int i10, com.google.zxing.common.a aVar) throws NotFoundException {
        while (true) {
            try {
                this.f36501g.add(E(aVar, this.f36501g, i10));
            } catch (NotFoundException e10) {
                if (this.f36501g.isEmpty()) {
                    throw e10;
                } else if (r()) {
                    return this.f36501g;
                } else {
                    boolean z10 = !this.f36502h.isEmpty();
                    G(i10, false);
                    if (z10) {
                        List<b> t10 = t(false);
                        if (t10 != null) {
                            return t10;
                        }
                        List<b> t11 = t(true);
                        if (t11 != null) {
                            return t11;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }
}
