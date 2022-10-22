package e9;

import com.google.zxing.NotFoundException;
import com.google.zxing.j;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AlignmentPatternFinder.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.b f25857a;

    /* renamed from: c  reason: collision with root package name */
    private final int f25859c;

    /* renamed from: d  reason: collision with root package name */
    private final int f25860d;

    /* renamed from: e  reason: collision with root package name */
    private final int f25861e;

    /* renamed from: f  reason: collision with root package name */
    private final int f25862f;

    /* renamed from: g  reason: collision with root package name */
    private final float f25863g;

    /* renamed from: i  reason: collision with root package name */
    private final j f25865i;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f25858b = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    private final int[] f25864h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.google.zxing.common.b bVar, int i10, int i11, int i12, int i13, float f10, j jVar) {
        this.f25857a = bVar;
        this.f25859c = i10;
        this.f25860d = i11;
        this.f25861e = i12;
        this.f25862f = i13;
        this.f25863g = f10;
        this.f25865i = jVar;
    }

    private static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        if (r2[1] <= r12) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        if (r10 >= r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r0.d(r11, r10) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
        if (r2[2] > r12) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (r2[2] <= r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
        if (d(r2) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float b(int i10, int i11, int i12, int i13) {
        com.google.zxing.common.b bVar = this.f25857a;
        int g10 = bVar.g();
        int[] iArr = this.f25864h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && bVar.d(i11, i14) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i14--;
        }
        if (i14 >= 0 && iArr[1] <= i12) {
            while (i14 >= 0 && !bVar.d(i11, i14) && iArr[0] <= i12) {
                iArr[0] = iArr[0] + 1;
                i14--;
            }
            if (iArr[0] > i12) {
                return Float.NaN;
            }
            int i15 = i10 + 1;
            while (i15 < g10 && bVar.d(i11, i15) && iArr[1] <= i12) {
                iArr[1] = iArr[1] + 1;
                i15++;
            }
        }
        return Float.NaN;
    }

    private boolean d(int[] iArr) {
        float f10 = this.f25863g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    private a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float a10 = a(iArr, i11);
        float b10 = b(i10, (int) a10, iArr[1] * 2, i12);
        if (Float.isNaN(b10)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f25858b) {
            if (aVar.f(f10, b10, a10)) {
                return aVar.g(b10, a10, f10);
            }
        }
        a aVar2 = new a(a10, b10, f10);
        this.f25858b.add(aVar2);
        j jVar = this.f25865i;
        if (jVar == null) {
            return null;
        }
        jVar.a(aVar2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() throws NotFoundException {
        a e10;
        a e11;
        int i10 = this.f25859c;
        int i11 = this.f25862f;
        int i12 = this.f25861e + i10;
        int i13 = this.f25860d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f25857a.d(i16, i15)) {
                i16++;
            }
            int i17 = 0;
            while (i16 < i12) {
                if (!this.f25857a.d(i16, i15)) {
                    if (i17 == 1) {
                        i17++;
                    }
                    iArr[i17] = iArr[i17] + 1;
                } else if (i17 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i17 != 2) {
                    i17++;
                    iArr[i17] = iArr[i17] + 1;
                } else if (d(iArr) && (e11 = e(iArr, i15, i16)) != null) {
                    return e11;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i17 = 1;
                }
                i16++;
            }
            if (d(iArr) && (e10 = e(iArr, i15, i12)) != null) {
                return e10;
            }
        }
        if (!this.f25858b.isEmpty()) {
            return this.f25858b.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
