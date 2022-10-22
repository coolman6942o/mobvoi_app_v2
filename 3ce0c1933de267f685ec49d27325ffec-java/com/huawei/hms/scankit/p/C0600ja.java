package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AlignmentPatternFinder.java */
/* renamed from: com.huawei.hms.scankit.p.ja  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0600ja {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14827a;

    /* renamed from: c  reason: collision with root package name */
    private final int f14829c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14830d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14831e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14832f;

    /* renamed from: g  reason: collision with root package name */
    private final float f14833g;

    /* renamed from: i  reason: collision with root package name */
    private final A f14835i;

    /* renamed from: b  reason: collision with root package name */
    private final List<C0596ia> f14828b = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    private final int[] f14834h = new int[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0600ja(C0595i iVar, int i10, int i11, int i12, int i13, float f10, A a10) {
        this.f14827a = iVar;
        this.f14829c = i10;
        this.f14830d = i11;
        this.f14831e = i12;
        this.f14832f = i13;
        this.f14833g = f10;
        this.f14835i = a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0596ia a() throws C0550a {
        C0596ia a10;
        int i10 = this.f14829c;
        int i11 = this.f14832f;
        int i12 = this.f14831e + i10;
        int i13 = this.f14830d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f14827a.b(i16, i15)) {
                i16++;
            }
            C0596ia a11 = a(i15, i16, i12, iArr);
            if (a11 != null) {
                return a11;
            }
            if (a(iArr) && (a10 = a(iArr, i15, i12)) != null) {
                return a10;
            }
        }
        if (!this.f14828b.isEmpty()) {
            return this.f14828b.get(0);
        }
        throw C0550a.a();
    }

    private C0596ia a(int i10, int i11, int i12, int[] iArr) {
        C0596ia a10;
        int i13 = 0;
        while (i11 < i12) {
            if (!this.f14827a.b(i11, i10)) {
                if (i13 == 1) {
                    i13++;
                }
                iArr[i13] = iArr[i13] + 1;
            } else if (i13 == 1) {
                iArr[1] = iArr[1] + 1;
            } else if (i13 != 2) {
                i13++;
                iArr[i13] = iArr[i13] + 1;
            } else if (a(iArr) && (a10 = a(iArr, i10, i11)) != null) {
                return a10;
            } else {
                iArr[0] = iArr[2];
                iArr[1] = 1;
                iArr[2] = 0;
                i13 = 1;
            }
            i11++;
        }
        return null;
    }

    private static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f10 = this.f14833g;
        float f11 = (3.0f * f10) / 4.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        if (r2[1] <= r12) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        if (r10 >= r1) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
        if (r0.b(r11, r10) != false) goto L59;
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
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
        r11 = (r2[0] + r2[1]) + r2[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        if (r11 >= (r13 * 3)) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
        if ((r11 * 3) > r13) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
        if (a(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0099, code lost:
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:?, code lost:
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float a(int i10, int i11, int i12, int i13) {
        C0595i iVar = this.f14827a;
        int b10 = iVar.b();
        int[] iArr = this.f14834h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && iVar.b(i11, i14) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i14--;
        }
        if (i14 < 0 || iArr[1] > i12) {
            return Float.NaN;
        }
        while (i14 >= 0 && !iVar.b(i11, i14) && iArr[0] <= i12) {
            iArr[0] = iArr[0] + 1;
            i14--;
        }
        if (iArr[0] > i12) {
            return Float.NaN;
        }
        int i15 = i10 + 1;
        while (i15 < b10 && iVar.b(i11, i15) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i15++;
        }
        return Float.NaN;
    }

    private C0596ia a(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float a10 = a(iArr, i11);
        float a11 = a(i10, (int) a10, iArr[1] * 3, i12);
        if (Float.isNaN(a11)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C0596ia iaVar : this.f14828b) {
            if (iaVar.a(f10, a11, a10)) {
                return iaVar.b(a11, a10, f10);
            }
        }
        C0596ia iaVar2 = new C0596ia(a10, a11, f10);
        this.f14828b.add(iaVar2);
        A a12 = this.f14835i;
        if (a12 == null) {
            return null;
        }
        a12.a(iaVar2);
        return null;
    }
}
